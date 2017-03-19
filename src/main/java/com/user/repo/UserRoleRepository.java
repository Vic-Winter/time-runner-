package com.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.user.domain.UserRole;


/**
 * Created by yeleilu on 13/03/2017.
 */
@Transactional
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    @Transactional
    @Modifying
    @Query("delete from UserRole where username = ?1")
    void delete(String username);
}
