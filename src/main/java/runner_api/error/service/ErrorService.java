package runner_api.error.service;

import org.springframework.http.HttpStatus;

import runner_api.error.domain.RestError;
import runner_api.error.domain.ServiceError;


/**
 * Created by yeleilu on 18/03/2017.
 */
public interface ErrorService
{
    RestError mapToRest (ServiceError serviceError);

    HttpStatus getHTTPStatus (ServiceError serviceError);
}
