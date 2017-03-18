package runner_api.event.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import runner_api.error.domain.ServiceError;
import runner_api.error.service.ErrorService;
import runner_api.event.domain.Event;
import runner_api.event.domain.EventRest;
import runner_api.event.service.EventService;


@RestController
@RequestMapping("/events")
public class EventController
{
    @Autowired
    private EventService eventService;

    @Autowired
    private ErrorService errorService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getByUsername(@RequestParam String username) {
        try {
            Iterable<Event> list = eventService.getEventsByUsername(username);
            List<EventRest> eventList = new ArrayList<>();
            list.forEach(event -> eventList.add(mapToRest(event)));
            return new ResponseEntity(eventList, HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getById(@PathVariable Integer id) {
        try {
            Event event = eventService.getOne(id);
            return new ResponseEntity(mapToRest(event), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody EventRest eventRest) {
        try {
            Event event = eventService.create(mapFromRest(eventRest));
            return new ResponseEntity(mapToRest(event), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody EventRest eventRest) {
        try {
            Event event = eventService.update(id, mapFromRest(eventRest));
            return new ResponseEntity(mapToRest(event), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            eventService.delete(id);
            return new ResponseEntity("EventRest deleted successfully", HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    private static Event mapFromRest (EventRest eventRest) {
        Event event = new Event();
        event.setId(eventRest.getId());
        event.setCreatedOn(eventRest.getCreatedOn());
        event.setTitle(eventRest.getTitle());
        event.setDescription(eventRest.getDescription());
        event.setUsername(eventRest.getUsername());

        return event;
    }

    private static EventRest mapToRest (Event event) {
        return new EventRest(event.getUsername(), event.getTitle(), event.getDescription());
    }
}
