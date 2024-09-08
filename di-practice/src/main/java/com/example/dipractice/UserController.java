package com.example.dipractice;

import com.example.dipractice.annotation.Controller;
import com.example.dipractice.annotation.Inject;

@Controller
public class UserController {

    private UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
