package runner_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import runner_api.account.service.AccountService;
import runner_api.account.service.AccountServiceImpl;

/**
 * Created by yeleilu on 12/03/2017.
 */
@Configuration
public class BeanConfig {
    @Bean
    public AccountService accountService () {
        return new AccountServiceImpl();
    }
}
