package runner_api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import runner_api.error.ErrorCode;
import runner_api.error.RestError;
import runner_api.user.domain.User;
import runner_api.user.repo.UserRepository;
import runner_api.user.repo.UserRoleRepository;

/**
 * Created by yeleilu on 11/03/2017.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserRoleRepository userRoleRepo;

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
        User createdUser = userRepo.save(user);
        return getByName(createdUser.getName());
    }

    @Override
    public User update(User user) throws RestError{
        if (userRepo.findOne(user.getName()) == null) {
            throw new RestError(ErrorCode.ENTITY_NOT_FOUND, "User not found!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User updatedUser = userRepo.save(user);
        return userRepo.findOne(updatedUser.getName());
    }

    @Override
    public void delete(String name) throws RestError {
        userRoleRepo.delete(name);
        userRepo.delete(name);
    }
}

