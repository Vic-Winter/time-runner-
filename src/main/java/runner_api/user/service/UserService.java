package runner_api.user.service;

import runner_api.user.domain.User;
import runner_api.error.domain.RestError;

/**
 * Created by yeleilu on 12/03/2017.
 */
public interface UserService {
    Iterable<User> listAll() throws RestError;
    User getByName(String name, String loginUserName) throws RestError;
    User create(User user, String loginUserName) throws RestError;
    User update(User user, String loginUserName) throws RestError;
    void delete(String name, String loginUserName) throws RestError;
}
