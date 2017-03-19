package com.error.service;

import org.springframework.http.HttpStatus;

import com.error.domain.RestError;
import com.error.domain.ServiceError;


/**
 * Created by yeleilu on 18/03/2017.
 */
public interface ErrorService
{
    RestError mapToRest(ServiceError serviceError);

    HttpStatus getHTTPStatus(ServiceError serviceError);
}
