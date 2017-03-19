package com.event.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("select e from Event e where e.username = ?1")
    Iterable<Event> getEventsByUserName(String username);

    @Query("select e from Event e where e.title = ?1")
    Event findByTitle(String title);
}
