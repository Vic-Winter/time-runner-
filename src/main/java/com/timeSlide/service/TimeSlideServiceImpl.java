package com.timeSlide.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.error.domain.ErrorCode;
import com.error.domain.ServiceError;
import com.event.service.EventService;
import com.timeSlide.domain.TimeSlide;
import com.timeSlide.repo.TimeSlideRepository;


/**
 * Created by yeleilu on 14/03/2017.
 */
public class TimeSlideServiceImpl implements TimeSlideService
{
    @Autowired
    private TimeSlideRepository timeSlideRepository;

    @Autowired
    private EventService eventService;

    @Override
    public Iterable<TimeSlide> getByEventId(final Integer eventId, String loginUserName) throws ServiceError
    {
        eventService.getOne(eventId, loginUserName);
        return timeSlideRepository.getByEventId(eventId);
    }

    /*
    public TimeSlide getOne(final Integer id) throws ServiceError
    {
        TimeSlide timeSlide = timeSlideRepository.findOne(id);
        if (timeSlide == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "TimeSlide not found!");
        }
        return timeSlide;
    }
    */

    @Override
    public TimeSlide create(final TimeSlide timeSlide, String loginUserName) throws ServiceError
    {
        eventService.getOne(timeSlide.getEventId(), loginUserName);
        try {
            TimeSlide createdEvent = timeSlideRepository.save(timeSlide);
            return timeSlideRepository.findOne(createdEvent.getId());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_EXIST, "TimeSlide cannot be created!");
        }
    }

    @Override
    public TimeSlide update(final Integer id, final TimeSlide timeSlide, String loginUserName) throws ServiceError
    {
        TimeSlide existingTimeSlide = timeSlideRepository.findOne(id);
        eventService.getOne(existingTimeSlide.getEventId(), loginUserName);
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
    public void delete(final Integer id, String loginUserName) throws ServiceError
    {
        TimeSlide existingTimeSlide = timeSlideRepository.findOne(id);
        eventService.getOne(existingTimeSlide.getEventId(), loginUserName);
        try {
            timeSlideRepository.delete(id);
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "TimeSlide cannot be found!");
        }
    }

    @Override
    public void deleteByEventId(final Integer eventId, String loginUserName) throws ServiceError
    {
        eventService.getOne(eventId, loginUserName);
        try {
            timeSlideRepository.deleteByEventId(eventId);
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "Event cannot be found!");
        }
    }
}
