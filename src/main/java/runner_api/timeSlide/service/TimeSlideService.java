package runner_api.timeSlide.service;

import runner_api.error.domain.RestError;
import runner_api.timeSlide.domain.TimeSlide;


/**
 * Created by yeleilu on 15/03/2017.
 */
public interface TimeSlideService
{
    Iterable<TimeSlide> getByEventId(Integer eventId) throws RestError;
    TimeSlide getOne(Integer id) throws RestError;
    TimeSlide create(TimeSlide event) throws RestError;
    TimeSlide update(Integer id, TimeSlide event) throws RestError;
    void delete(Integer id) throws RestError;
    void deleteByEventId(Integer eventId) throws RestError;
}
