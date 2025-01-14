package com.example.mvcpractice2.mvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectView implements View {
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";

    private final String name;

    public RedirectView(String name) {
        this.name = name;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        model.forEach(request::setAttribute);
        response.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}