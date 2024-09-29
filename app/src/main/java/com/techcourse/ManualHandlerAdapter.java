package com.techcourse;

import com.interface21.webmvc.servlet.ModelAndView;
import com.interface21.webmvc.servlet.mvc.asis.Controller;
import com.interface21.webmvc.servlet.mvc.tobe.adapter.HandlerAdapter;
import com.interface21.webmvc.servlet.mvc.tobe.exception.ControllerExecutionException;
import com.interface21.webmvc.servlet.mvc.tobe.exception.UnprocessableHandlerException;
import com.interface21.webmvc.servlet.view.JspView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManualHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Controller controller = convertHandler(handler);

        try {
            String viewName = controller.execute(request, response);
            return new ModelAndView(new JspView(viewName));

        } catch (Exception e) {
            throw new ControllerExecutionException(e.getMessage(), e);
        }
    }

    private Controller convertHandler(Object handler) {
        if (!supports(handler)) {
            throw new UnprocessableHandlerException(handler.getClass().getName());
        }

        return (Controller) handler;
    }
}
