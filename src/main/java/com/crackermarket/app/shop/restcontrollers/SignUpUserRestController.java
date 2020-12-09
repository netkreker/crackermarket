package com.crackermarket.app.shop.restcontrollers;

import com.crackermarket.app.core.LogEntityService;
import com.crackermarket.app.shop.entities.LogEntity;
import com.crackermarket.app.shop.services.UserService;
import com.crackermarket.app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class SignUpUserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogEntityService service;

    @GetMapping(value = "/new")
    public ModelAndView registrationUser() {
        ModelAndView registerPage = new ModelAndView("users/user_registration", "user", new User());
        return registerPage;
    }

    // Getters
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showAllUsers() {
        List<User> users = userService.findAllUsers();

        if (users.isEmpty()) {
            LogEntity log = new LogEntity("error", this.getClass(), "showAllUsers", HttpStatus.NOT_FOUND, "Users not found", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (User user: users)
            user.setPassword(null);

        LogEntity log = new LogEntity("info", this.getClass(), "showAllUsers", HttpStatus.FOUND, "Users found", null);
        service.save(log);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@PathVariable String username){
        User user = userService.findUserByUserName(username);

        if (user == null) {
            LogEntity log = new LogEntity("error", this.getClass(), "getUserById", HttpStatus.NOT_FOUND, "User with username \'" + username + "\' not found", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setPassword(null);

        LogEntity log = new LogEntity("info", this.getClass(), "getUserById", HttpStatus.FOUND, "User with id \'" + user.getId() + "\' found", null);
        service.save(log);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    // Creator
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User user){

        if (user == null) {
            LogEntity log = new LogEntity("error", this.getClass(), "createUser", HttpStatus.BAD_REQUEST, "User with id \'" + user.getId() + "\' not created", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(user);

        LogEntity log = new LogEntity("info", this.getClass(), "createUser", HttpStatus.CREATED, "User with id \'" + user.getId() + "\' was created", null);
        service.save(log);
        return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
    }

    // Put
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestBody User newUser, @PathVariable(name = "id") String id){

        User oldUser = userService.findUserById(UUID.fromString(id));

        if (oldUser == null) {

            LogEntity log = new LogEntity("error", this.getClass(), "updateUser", HttpStatus.NOT_FOUND, "User with id \'" + id + "\' not found", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (oldUser == newUser) {
            LogEntity log = new LogEntity("info", this.getClass(), "updateUser", HttpStatus.NOT_MODIFIED, "User with id \'" + id + "\' not modified", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        userService.updateUser(newUser);

        LogEntity log = new LogEntity("info", this.getClass(), "updateUser", HttpStatus.OK, "User with id \'" + id + "\' was updated", null);
        service.save(log);
        return new ResponseEntity<>(newUser.getId(), HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable(name="id") String id){
        User user = userService.findUserById(UUID.fromString(id));

        if (user == null) {
            LogEntity log = new LogEntity("error", this.getClass(), "deleteUser", HttpStatus.NOT_FOUND, "User with id \'" + id + "\' not found", null);
            service.save(log);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUser(user);

        LogEntity log = new LogEntity("info", this.getClass(), "deleteUser", HttpStatus.OK, "User with id \'" + id + "\' was deleted", null);
        service.save(log);
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }

}
