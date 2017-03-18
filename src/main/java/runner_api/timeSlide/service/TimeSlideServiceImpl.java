package runner_api.timeSlide.service;

import org.springframework.beans.factory.annotation.Autowired;

import runner_api.error.domain.ErrorCode;
import runner_api.error.domain.ServiceError;
import runner_api.timeSlide.domain.TimeSlide;
import runner_api.timeSlide.repo.TimeSlideRepository;


/**
 * Created by yeleilu on 14/03/2017.
 */
public class TimeSlideServiceImpl implements TimeSlideService
{
    @Autowired
    private TimeSlideRepository timeSlideRepository;

    @Override
    public Iterable<TimeSlide> getByEventId(final Integer eventId) throws ServiceError
    {
        return timeSlideRepository.getByEventId(eventId);
    }

    @Override
    public TimeSlide getOne(final Integer id) throws ServiceError
    {
        TimeSlide timeSlide = timeSlideRepository.findOne(id);
        if (timeSlide == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "TimeSlide not found!");
        }
        return timeSlide;
    }

    @Override
    public TimeSlide create(final TimeSlide timeSlide) throws ServiceError
    {
        try {
            TimeSlide createdEvent = timeSlideRepository.save(timeSlide);
            return timeSlideRepository.findOne(createdEvent.getId());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_EXIST, "TimeSlide cannot be created!");
        }
    }

    @Override
    public TimeSlide update(final Integer id, final TimeSlide timeSlide) throws ServiceError
    {
        TimeSlide existingTimeSlide = timeSlideRepository.findOne(id);
        if (existingTimeSlide == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "TimeSlide not found!");
        }
        try {
            timeSlide.setId(id);
            TimeSlide updatedTimeSlide = timeSlideRepository.save(timeSlide);
            return timeSlideRepository.findOne(updatedTimeSlide.getId());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.BAD_REQUEST, "TimeSlide cannot be updated!");
        }
    }

    @Override
    public void delete(final Integer id) throws ServiceError
    {
        try {
            timeSlideRepository.delete(id);
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "TimeSlide cannot be found!");
        }
    }

    @Override
    public void deleteByEventId(final Integer eventId) throws ServiceError
    {
        try {
            timeSlideRepository.deleteByEventId(eventId);
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "Event cannot be found!");
        }
    }
}
