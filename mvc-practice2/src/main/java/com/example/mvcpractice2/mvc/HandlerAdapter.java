package com.example.mvcpractice2.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.mvcpractice2.mvc.view.ModelAndView;

public interface HandlerAdapter {
    boolean supports(Object handler);

    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
}