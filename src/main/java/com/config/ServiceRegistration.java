package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.error.service.ErrorService;
import com.error.service.ErrorServiceImpl;
import com.event.service.EventService;
import com.event.service.EventServiceImpl;
import com.permission.service.PermissionService;
import com.permission.service.PermissionServiceImpl;
import com.timeSlide.service.TimeSlideService;
import com.timeSlide.service.TimeSlideServiceImpl;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Configuration
@EnableTransactionManagement
public class ServiceRegistration
{
    @Bean
    public UserService userService ()
    {
        return new UserServiceImpl();
    }

    @Bean
    public EventService eventService ()
    {
        return new EventServiceImpl();
    }

    @Bean
    public TimeSlideService timeSlideService ()
    {
        return new TimeSlideServiceImpl();
    }

    @Bean
    public PermissionService permissionService ()
    {
        return new PermissionServiceImpl();
    }

    @Bean
    public ErrorService errorService () {
        return new ErrorServiceImpl();
    }
}
