package com.example.mvcpractice2.mvc.view;

import static com.example.mvcpractice2.mvc.view.RedirectView.*;

public class JspViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName) {
        if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
            return new RedirectView(viewName);
        }
        return new JspView(viewName + ".jsp");
    }
}