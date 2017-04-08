package com.paytm.controller;

import ch.qos.logback.classic.spi.LoggerRemoteView;
import com.paytm.domain.Product;
import com.paytm.repository.JdbcProductDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.DOMConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InventoryController implements Controller {

    Logger logger = (Logger) LogManager.getRootLogger();
    private  int testvariable;
    private JdbcProductDao jdbcProductDao;
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.jdbcProductDao.getProductList());

        return new ModelAndView("hello", "model", myModel);
    }

    public void setJdbcProductDao(JdbcProductDao jdbcProductDao) {
        this.jdbcProductDao = jdbcProductDao;
    }
}