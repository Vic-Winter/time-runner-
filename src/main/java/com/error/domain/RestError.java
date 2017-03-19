package com.error.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by yeleilu on 14/03/2017.
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "ServiceError" )
public class RestError
{
    @ApiModelProperty
    private ErrorCode errorCode;

    private String errorMessage;

    // Jackson auto mapping
    public RestError() {
    }

    public RestError(ErrorCode errorCode, String errorMessage) {
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
