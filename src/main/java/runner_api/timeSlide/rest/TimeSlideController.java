package runner_api.timeSlide.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import runner_api.error.domain.ServiceError;
import runner_api.error.service.ErrorService;
import runner_api.timeSlide.domain.TimeSlide;
import runner_api.timeSlide.domain.TimeSlideRest;
import runner_api.timeSlide.service.TimeSlideService;


@RestController
@RequestMapping("/timeSlides")
public class TimeSlideController
{
    @Autowired
    private TimeSlideService timeSlideService;

    @Autowired
    private ErrorService errorService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getByEventId(@RequestParam Integer eventId, Principal principal) {
        String loginUserName = principal.getName();
        try {
            Iterable<TimeSlide> list = timeSlideService.getByEventId(eventId, loginUserName);
            List<TimeSlideRest> timeSlideList = new ArrayList<>();
            list.forEach(timeSlide -> timeSlideList.add(mapToRest(timeSlide)));
            return new ResponseEntity(timeSlideList, HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getById(@PathVariable Integer id) {
        try {
            TimeSlide timeSlide = timeSlideService.getOne(id);
            return new ResponseEntity(mapToRest(timeSlide), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }
    */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody TimeSlideRest timeSlideRest, Principal principal) {
        String loginUserName = principal.getName();
        try {
            TimeSlide timeSlide = timeSlideService.create(mapFromRest(timeSlideRest), loginUserName);
            return new ResponseEntity(mapToRest(timeSlide), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TimeSlideRest timeSlideRest, Principal principal) {
        String loginUserName = principal.getName();
        try {
            TimeSlide timeSlide = timeSlideService.update(id, mapFromRest(timeSlideRest), loginUserName);
            return new ResponseEntity(mapToRest(timeSlide), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable Integer id, Principal principal) {
        String loginUserName = principal.getName();
        try {
            timeSlideService.delete(id, loginUserName);
            return new ResponseEntity("TimeSlideRest deleted successfully", HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity deleteByEventId(@RequestParam Integer eventId, Principal principal) {
        String loginUserName = principal.getName();
        try {
            timeSlideService.deleteByEventId(eventId, loginUserName);
            return new ResponseEntity("TimeSlides deleted successfully", HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    private static TimeSlide mapFromRest (TimeSlideRest timeSlideRest) {
        TimeSlide timeSlide = new TimeSlide();
        timeSlide.setId(timeSlideRest.getId());
        timeSlide.setStartTime(timeSlideRest.getStartTime());
        timeSlide.setEndTime(timeSlideRest.getEndTime());
        timeSlide.setEventId(timeSlideRest.getEventId());

        return timeSlide;
    }

    private static TimeSlideRest mapToRest (TimeSlide timeSlide) {
        return new TimeSlideRest(timeSlide.getId(), timeSlide.getEventId(), timeSlide.getStartTime(), timeSlide.getEndTime());
    }
}
