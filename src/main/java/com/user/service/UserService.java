package com.user.service;

import com.error.domain.ServiceError;
import com.user.domain.User;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface UserService {
    Iterable<User> listAll() throws ServiceError;
    User getByName(String name, String loginUserName) throws ServiceError;
    User create(User user, String loginUserName) throws ServiceError;
    User update(User user, String loginUserName) throws ServiceError;
    void delete(String name, String loginUserName) throws ServiceError;
}
