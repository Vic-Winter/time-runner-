package runner_api.event.service;

import org.springframework.beans.factory.annotation.Autowired;

import runner_api.error.domain.ErrorCode;
import runner_api.error.domain.ServiceError;
import runner_api.event.domain.Event;
import runner_api.event.repo.EventRepository;


/**
 * Created by yeleilu on 14/03/2017.
 */
public class EventServiceImpl implements EventService
{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Iterable<Event> getEventsByUsername(final String username) throws ServiceError
    {
        return eventRepository.getEventsByUserName(username);
    }

    @Override
    public Event getOne(final Integer id) throws ServiceError
    {
        Event event = eventRepository.findOne(id);
        if (event == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "Event not found!");
        }
        return event;
    }

    @Override
    public Event findByTitle(final String name) throws ServiceError
    {
        Event event = eventRepository.findByTitle(name);
        if (event == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "Event not found!");
        }
        return event;
    }

    @Override
    public Event create(final Event event) throws ServiceError
    {
        try {
            Event createdEvent = eventRepository.save(event);
            return eventRepository.findOne(createdEvent.getId());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_EXIST, "Event with same name already exist!");
        }
    }

    @Override
    public Event update(final Integer id, final Event event) throws ServiceError
    {
        Event existingEvent = eventRepository.findOne(id);
        if (existingEvent == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "Event not found!");
        }
        try {
            event.setId(id);
            event.setCreatedOn(existingEvent.getCreatedOn());
            Event updatedEvent = eventRepository.save(event);
            return eventRepository.findOne(updatedEvent.getId());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.BAD_REQUEST, "Event cannot be updated!");
        }
    }

    @Override
    public void delete(final Integer id) throws ServiceError
    {
        eventRepository.delete(id);
    }
}
