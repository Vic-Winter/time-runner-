package runner_api.event.service;

import java.util.Iterator;

import org.springframework.context.annotation.Bean;

import runner_api.error.RestError;
import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface EventService
{
    Iterator<Event> getEventsByUsername(String username) throws RestError;
    Event getOne(Integer id) throws RestError;
    Event getEventByName(String name) throws RestError;
    Event create(Event event) throws RestError;
    Event update(Event event) throws RestError;
    void delete(String name) throws RestError;
}
