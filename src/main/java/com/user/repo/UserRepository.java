package com.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.user.domain.User;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, String> {

}
