package com.timeSlide.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.timeSlide.domain.TimeSlide;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Transactional
public interface TimeSlideRepository extends CrudRepository<TimeSlide, Integer> {
    @Query("select t from TimeSlide t inner join t.event e where e.id = :eventId")
    Iterable<TimeSlide> getByEventId(@Param("eventId") Integer eventId);

    @Modifying
    @Query(value = "delete from time_slides t where t.event_id = ?1", nativeQuery=true)
    void deleteByEventId(Integer eventId);
}
