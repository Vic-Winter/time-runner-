package com.permission.service;

import com.error.domain.ErrorCode;
import com.error.domain.ServiceError;
import com.permission.domain.Action;


/**
 * Created by yeleilu on 18/03/2017.
 */
public class PermissionServiceImpl implements PermissionService
{
    @Override
    public void verifyPermission (String username, String loginUserName, Action action) throws ServiceError
    {
        switch (action) {
            case CREATEUSER:
                if (!loginUserName.equals("temp_user")) {
                    throw new ServiceError(ErrorCode.PERMISSION_DENIED, "User not allowed to create new user!");
                }
                break;
            default:
                if (loginUserName.equals("temp_user") || !username.equals(loginUserName)) {
                    throw new ServiceError(ErrorCode.PERMISSION_DENIED, "User not allowed to operate current action!");
                }
                break;
        }
    }
}
