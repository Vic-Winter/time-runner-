package runner_api.event.service;

import runner_api.error.domain.ServiceError;
import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface EventService
{
    Iterable<Event> getEventsByUsername(String username) throws ServiceError;
    Event getOne(Integer id) throws ServiceError;
    Event findByTitle(String name) throws ServiceError;
    Event create(Event event) throws ServiceError;
    Event update(Integer id, Event event) throws ServiceError;
    void delete(Integer id) throws ServiceError;
}
