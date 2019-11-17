package io.springgeeks.duka.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NoticeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String userMessage = "Wouldn't YOU like to Join the Team!";

        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            if (request.isUserInRole("ROLE_ADMIN"))
                userMessage = "Only YOU cam add an EMPLOYEE!!!!";
            else
                userMessage = "Keep up the good Work!! You're our #1 Employee!";
        }

        modelAndView.getModelMap().addAttribute("SpecialBlurb", userMessage);
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
