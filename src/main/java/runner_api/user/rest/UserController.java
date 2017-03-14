package runner_api.user.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner_api.user.domain.User;
import runner_api.user.domain.UserRest;
import runner_api.user.service.UserService;
import runner_api.error.RestError;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity listAll() {
        try {
            Iterable<User> list = userService.listAll();
            List<UserRest> userlist = new ArrayList<>();
            list.forEach(user -> userlist.add(mapToRest(user)));
            return new ResponseEntity(userlist, HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(RestError.mapToRest(restError), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity getById(@PathVariable String name) {
        try {
            User user = userService.getByName(name);
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(RestError.mapToRest(restError), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody UserRest userRest) {
        try {
            User user = userService.create(mapFromRest(userRest));
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(RestError.mapToRest(restError), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@PathVariable String name, @RequestBody UserRest userRest) {
        try {
            User user = userService.update(mapFromRest(userRest));
            return new ResponseEntity(mapToRest(user), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(RestError.mapToRest(restError), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable String name) {
        try {
            userService.delete(name);
            return new ResponseEntity("UserRest deleted successfully", HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(RestError.mapToRest(restError), HttpStatus.BAD_REQUEST);
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
