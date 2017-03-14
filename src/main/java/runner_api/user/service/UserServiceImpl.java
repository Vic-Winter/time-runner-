package runner_api.user.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import runner_api.error.ErrorCode;
import runner_api.error.RestError;
import runner_api.user.domain.User;
import runner_api.user.domain.UserRole;
import runner_api.user.repo.UserRepository;
import runner_api.user.repo.UserRoleRepository;

/**
 * Created by yeleilu on 11/03/2017.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Iterable<User> listAll() {
        return userRepo.findAll();
    }

    @Override
    public User getByName(String name) throws RestError {
        User user = userRepo.findOne(name);
        if (user == null) {
            throw new RestError(ErrorCode.ENTITY_NOT_FOUND, "User not found!");
        }
        return user;
    }

    @Override
    public User create(User user) throws RestError{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(new UserRole(user.getName(), "ROLE_USER")));
        User createdUser = userRepo.save(user);
        return getByName(createdUser.getName());
    }

    @Override
    public User update(User user) throws RestError{
        User existingUser = userRepo.findOne(user.getName());
        if (existingUser == null) {
            throw new RestError(ErrorCode.ENTITY_NOT_FOUND, "User not found!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(existingUser.getRoles());
        User updatedUser = userRepo.save(user);
        return userRepo.findOne(updatedUser.getName());
    }

    @Override
    public void delete(String name) throws RestError {
        userRoleRepo.delete(name);
        userRepo.delete(name);
    }
}

