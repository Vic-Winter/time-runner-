package runner_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import runner_api.event.service.EventService;
import runner_api.event.service.EventServiceImpl;
import runner_api.permission.service.PermissionService;
import runner_api.permission.service.PermissionServiceImpl;
import runner_api.timeSlide.service.TimeSlideService;
import runner_api.timeSlide.service.TimeSlideServiceImpl;
import runner_api.user.service.UserService;
import runner_api.user.service.UserServiceImpl;

/**
 * Created by yeleilu on 12/03/2017.
 */
@Configuration
@EnableTransactionManagement
public class BeanConfig {
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
}
