package com.permission.service;

import com.error.domain.ServiceError;
import com.permission.domain.Action;


/**
 * Created by yeleilu on 18/03/2017.
 */
public interface PermissionService
{
    void verifyPermission(String name, String loginUserName, Action action) throws ServiceError;
}
