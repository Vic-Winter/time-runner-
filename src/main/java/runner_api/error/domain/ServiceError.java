package runner_api.error.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by yeleilu on 12/03/2017.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ServiceError extends Throwable
{

    private ErrorCode errorCode;
    private String errorMessage;

    public ServiceError(ErrorCode errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

}
