package runner_api.error.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import runner_api.error.domain.ErrorCode;


/**
 * Created by yeleilu on 14/03/2017.
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "RestError" )
public class RestErrorEntity {
    @ApiModelProperty
    private ErrorCode errorCode;

    private String errorMessage;

    // Jackson auto mapping
    public RestErrorEntity() {
    }

    public RestErrorEntity (ErrorCode errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(final ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}
