package runner_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
}
