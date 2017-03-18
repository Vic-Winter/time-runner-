package runner_api.timeSlide.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import runner_api.timeSlide.domain.TimeSlide;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Transactional
public interface TimeSlideRepository extends CrudRepository<TimeSlide, Integer> {
    @Query("select t from TimeSlide t where t.eventId = ?1")
    Iterable<TimeSlide> getByEventId(Integer eventId);

    @Modifying
    @Query("delete from TimeSlide where eventId = ?1")
    void deleteByEventId(Integer eventId);
}
