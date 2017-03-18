package runner_api.event.service;

import runner_api.error.domain.ServiceError;
import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface EventService
{
    Iterable<Event> getEventsByUsername(String username, String loginUserName) throws ServiceError;
    Event getOne(Integer id, String loginUserName) throws ServiceError;
    Event findByTitle(String name, String loginUserName) throws ServiceError;
    Event create(Event event, String loginUserName) throws ServiceError;
    Event update(Integer id, Event event, String loginUserName) throws ServiceError;
    void delete(Integer id, String loginUserName) throws ServiceError;
}
