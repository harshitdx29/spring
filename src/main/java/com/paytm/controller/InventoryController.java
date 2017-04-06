package com.paytm.controller;

import com.paytm.domain.Product;
import com.paytm.repository.JdbcProductDao;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InventoryController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    private JdbcProductDao jdbcProductDao;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
        //ProductDao pdao = (ProductDao) context.getBean("productDAO");
//        Product product = new Product();
//        product.setPrice(23.45);
//        product.setDescription("Test Product");
//        this.jdbcProductDao.saveProduct(product);
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