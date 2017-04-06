package com.paytm.controller;

import com.paytm.domain.Product;
import com.paytm.repository.JdbcProductDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by harshitgupta on 6/4/17.
 */
@Controller
@RequestMapping("/addproduct.htm")
public class AddInventoryController {
    private JdbcProductDao jdbcProductDao;
    public void setJdbcProductDao(JdbcProductDao jdbcProductDao){
        this.jdbcProductDao = jdbcProductDao;
    }

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(method= RequestMethod.POST)
    public String processSubmit(Product product,
                                BindingResult result, SessionStatus status) {
            jdbcProductDao.saveProduct(product);

            status.setComplete();
            return "redirect:hello.htm";

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setupForm(
            ModelMap model) {

        Product product = new Product();

        model.addAttribute("price", product.getPrice());
        model.addAttribute("description", product.getDescription());

        return new ModelAndView("addproduct", "command", new Product());
    }

}
