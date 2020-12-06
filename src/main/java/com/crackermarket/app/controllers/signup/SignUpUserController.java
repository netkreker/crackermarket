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

    @ResponseBody
    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@ModelAttribute("user") User user){

        if (user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        userDAO.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
