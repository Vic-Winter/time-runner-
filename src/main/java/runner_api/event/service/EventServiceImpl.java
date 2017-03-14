package runner_api.event.service;

import java.util.Iterator;

import runner_api.error.RestError;
import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 14/03/2017.
 */
public class EventServiceImpl implements EventService
{
    @Override
    public Iterator<Event> getEventsByUsername(final String username) throws RestError
    {
        return null;
    }

    @Override
    public Event getOne(final Integer id) throws RestError
    {
        return null;
    }

    @Override
    public Event getEventByName(final String name) throws RestError
    {
        return null;
    }

    @Override
    public Event create(final Event event) throws RestError
    {
        return null;
    }

    @Override
    public Event update(final Event event) throws RestError
    {
        return null;
    }

    @Override
    public void delete(final String name) throws RestError
    {

    }
}
