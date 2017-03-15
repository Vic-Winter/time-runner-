package runner_api.event.service;

import runner_api.error.RestError;
import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface EventService
{
    Iterable<Event> getEventsByUsername(String username) throws RestError;
    Event getOne(Integer id) throws RestError;
    Event findByTitle(String name) throws RestError;
    Event create(Event event) throws RestError;
    Event update(Integer id, Event event) throws RestError;
    void delete(Integer id) throws RestError;
}
