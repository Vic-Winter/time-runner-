package runner_api.timeSlide.service;

import runner_api.error.domain.ServiceError;
import runner_api.timeSlide.domain.TimeSlide;


/**
 * Created by yeleilu on 15/03/2017.
 */
public interface TimeSlideService
{
    Iterable<TimeSlide> getByEventId(Integer eventId) throws ServiceError;
    TimeSlide getOne(Integer id) throws ServiceError;
    TimeSlide create(TimeSlide event) throws ServiceError;
    TimeSlide update(Integer id, TimeSlide event) throws ServiceError;
    void delete(Integer id) throws ServiceError;
    void deleteByEventId(Integer eventId) throws ServiceError;
}
