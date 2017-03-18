package runner_api.permission.service;

import runner_api.error.domain.ServiceError;
import runner_api.user.domain.Action;


/**
 * Created by yeleilu on 18/03/2017.
 */
public interface PermissionService
{
    void verifyPermission (String name, String loginUserName, Action action) throws ServiceError;
}
