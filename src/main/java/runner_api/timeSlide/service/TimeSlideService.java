package runner_api.timeSlide.service;

import runner_api.error.domain.ServiceError;
import runner_api.timeSlide.domain.TimeSlide;


/**
 * Created by yeleilu on 15/03/2017.
 */
public interface TimeSlideService
{
    Iterable<TimeSlide> getByEventId(Integer eventId, String loginUserName) throws ServiceError;
    TimeSlide create(TimeSlide event, String loginUserName) throws ServiceError;
    TimeSlide update(Integer id, TimeSlide event, String loginUserName) throws ServiceError;
    void delete(Integer id, String loginUserName) throws ServiceError;
    void deleteByEventId(Integer eventId, String loginUserName) throws ServiceError;
}
