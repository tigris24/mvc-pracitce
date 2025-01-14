package com.example.mvcpractice2.mvc.view;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspView implements View {
    private final String name;

    public JspView(String name) {
        this.name = name;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        model.forEach(request::setAttribute);
        RequestDispatcher rd = request.getRequestDispatcher(name);
        rd.forward(request, response);
    }
}