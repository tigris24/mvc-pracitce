package com.example.mvcpractice2.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.mvcpractice2.mvc.annotation.Controller;
import com.example.mvcpractice2.mvc.annotation.RequestMapping;
import com.example.mvcpractice2.mvc.repository.UserRepository;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", UserRepository.findAll());
        return "home";
    }
}