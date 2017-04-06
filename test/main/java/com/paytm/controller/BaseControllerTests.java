package com.paytm.controller;

import org.springframework.web.servlet.ModelAndView;

import springapp.web.HelloController;

import junit.framework.TestCase;

public class HelloControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{
        BaseController controller = new BaseController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("index.jsp", modelAndView.getViewName());
    }
}