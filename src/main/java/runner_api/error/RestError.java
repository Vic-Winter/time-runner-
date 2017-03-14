package runner_api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by yeleilu on 12/03/2017.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RestError extends Throwable
{

    private ErrorCode errorCode;
    private String errorMessage;

    public RestError(ErrorCode errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static RestErrorEntity mapToRest (RestError restError) {
        return new RestErrorEntity(restError.getErrorCode(), restError.getErrorMessage());
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
