package com.example.mvcpractice2.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.mvcpractice2.mvc.controller.Controller;
import com.example.mvcpractice2.mvc.view.ModelAndView;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String viewName = ((Controller) handler).handleRequest(request, response);
        return new ModelAndView(viewName);
    }
}