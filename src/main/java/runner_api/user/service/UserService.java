package runner_api.user.service;

import runner_api.user.domain.User;
import runner_api.error.RestError;

/**
 * Created by yeleilu on 12/03/2017.
 */
public interface UserService {
    Iterable<User> listAll() throws RestError;
    User getByName(String name) throws RestError;
    User create(User user) throws RestError;
    User update(User user) throws RestError;
    void delete(String name) throws RestError;
}
