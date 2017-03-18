package runner_api.permission.service;

import runner_api.error.ErrorCode;
import runner_api.error.RestError;
import runner_api.user.domain.Action;


/**
 * Created by yeleilu on 18/03/2017.
 */
public class PermissionServiceImpl implements PermissionService
{
    @Override
    public void verifyPermission (String username, String loginUserName, Action action) throws RestError
    {
        switch (action) {
            case CREATEUSER:
                if (!loginUserName.equals("temp_user")) {
                    throw new RestError(ErrorCode.PERMISSION_DENIED, "User not allowed to create new user!");
                }
                break;
            default:
                if (loginUserName.equals("temp_user") || !username.equals(loginUserName)) {
                    throw new RestError(ErrorCode.PERMISSION_DENIED, "User not allowed to operate current action!");
                }
                break;
        }
    }
}
