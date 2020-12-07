package com.crackermarket.app.controllers.signup;

import com.crackermarket.app.services.UserDAO;
import com.crackermarket.app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class SignUpUserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping(value = "/new")
    public ModelAndView registrationUser() {
        ModelAndView registerPage = new ModelAndView("users/user_registration", "user", new User());
        return registerPage;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> showAllUsers() {
        List<User> users = userDAO.findAllUsers();

        if (users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        for (User user: users)
            user.setPassword(null);

        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<?> getUserById(@PathVariable String username){
        User user = userDAO.findUserByUserName(username);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        user.setPassword(null);

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @ResponseBody
    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@RequestBody User user){

        if (user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        userDAO.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
