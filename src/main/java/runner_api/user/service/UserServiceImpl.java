package runner_api.user.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import runner_api.error.domain.ErrorCode;
import runner_api.error.domain.ServiceError;
import runner_api.permission.service.PermissionService;
import runner_api.user.domain.Action;
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

    @Autowired
    private PermissionService permissionService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Iterable<User> listAll() {
        return userRepo.findAll();
    }

    @Override
    public User getByName(String name, String loginUserName) throws ServiceError
    {
        permissionService.verifyPermission(name, loginUserName, Action.VIEWUSER);
        User user = userRepo.findOne(name);
        if (user == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "User not found!");
        }
        return user;
    }

    @Override
    public User create(User user, String loginUserName) throws ServiceError
    {
        permissionService.verifyPermission(null, loginUserName, Action.CREATEUSER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(new UserRole(user.getName(), "ROLE_USER")));
        try {
            User createdUser = userRepo.save(user);
            return userRepo.findOne(createdUser.getName());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.ENTITY_EXIST, "User with same name already exist!");
        }
    }

    @Override
    public User update(User user, String loginUserName) throws ServiceError
    {
        permissionService.verifyPermission(user.getName(), loginUserName, Action.EDITUSER);
        User existingUser = userRepo.findOne(user.getName());
        if (existingUser == null) {
            throw new ServiceError(ErrorCode.ENTITY_NOT_FOUND, "User not found!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(existingUser.getRoles());
        try {
            User updatedUser = userRepo.save(user);
            return userRepo.findOne(updatedUser.getName());
        }
        catch (Exception e) {
            throw new ServiceError(ErrorCode.BAD_REQUEST, "User cannot be updated!");
        }
    }

    @Override
    public void delete(String name, String loginUserName) throws ServiceError
    {
        permissionService.verifyPermission(name, loginUserName, Action.EDITUSER);
        userRoleRepo.delete(name);
        userRepo.delete(name);
    }
}

