package runner_api.user.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import runner_api.error.domain.ServiceError;
import runner_api.error.service.ErrorService;
import runner_api.user.domain.User;
import runner_api.user.domain.UserRest;
import runner_api.user.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ErrorService errorService;

    /*
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity listAll() {
        try {
            Iterable<User> list = userService.listAll();
            List<UserRest> userlist = new ArrayList<>();
            list.forEach(user -> userlist.add(mapToRest(user)));
            return new ResponseEntity(userlist, HttpStatus.OK);
        }
        catch (ServiceError restError) {
            return new ResponseEntity(ServiceError.mapToRest(restError), HttpStatus.BAD_REQUEST);
        }
    }
    */

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getById(@PathVariable String name, Principal principal) {
        String loginUserName = principal.getName();
        try {
            User user = userService.getByName(name, loginUserName);
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody UserRest userRest, Principal principal) {
        String loginUserName = principal.getName();
        try {
            User user = userService.create(mapFromRest(userRest), loginUserName);
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@PathVariable String name, @RequestBody UserRest userRest, Principal principal) {
        String loginUserName = principal.getName();
        try {
            User updateRequest = mapFromRest(userRest);
            updateRequest.setName(name);
            User user = userService.update(updateRequest, loginUserName);
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable String name, Principal principal) {
        String loginUserName = principal.getName();
        try {
            userService.delete(name, loginUserName);
            return new ResponseEntity("UserRest deleted successfully", HttpStatus.OK);
        }
        catch (ServiceError serviceError) {
            return new ResponseEntity(errorService.mapToRest(serviceError), errorService.getHTTPStatus(serviceError));
        }
    }

    private static User mapFromRest (UserRest userRest) {
        User user = new User();
        user.setName(userRest.getName());
        user.setEmail(userRest.getEmail());
        user.setPassword(userRest.getPassword());

        return user;
    }

    private static UserRest mapToRest (User user) {
        return new UserRest(user.getName(), user.getEmail(), user.getPassword());
    }
}
