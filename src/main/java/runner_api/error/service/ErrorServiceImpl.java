package runner_api.error.service;

import org.springframework.http.HttpStatus;

import runner_api.error.domain.ServiceError;
import runner_api.error.domain.RestError;


/**
 * Created by yeleilu on 18/03/2017.
 */
public class ErrorServiceImpl implements ErrorService
{
    @Override
    public RestError mapToRest (ServiceError serviceError) {
        return new RestError(serviceError.getErrorCode(), serviceError.getErrorMessage());
    }

    @Override
    public HttpStatus getHTTPStatus (ServiceError serviceError) {
        switch (serviceError.getErrorCode()) {
            case PERMISSION_DENIED:
                return HttpStatus.FORBIDDEN;
            case ENTITY_EXIST:
                return HttpStatus.CONFLICT;
            case ENTITY_NOT_FOUND:
                return HttpStatus.NOT_FOUND;
            case BAD_REQUEST:
                return HttpStatus.BAD_REQUEST;
        }
        return null;
    }
}
