package com.example.mvcpractice2.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.mvcpractice2.mvc.model.User;
import com.example.mvcpractice2.mvc.repository.UserRepository;

public class UserCreateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }
}