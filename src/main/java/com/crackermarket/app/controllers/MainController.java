package com.crackermarket.app.controllers;

import com.crackermarket.app.entities.*;
import com.crackermarket.app.enumerations.Rate;
import com.crackermarket.app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ParameterDAO parameterDAO;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    ParameterValueDAO parameterValueDAO;



    @GetMapping("/")
    public String sayHello() {
        return "index";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        Category category = new Category();
        category.setName("TV");

        Product product = new Product();
        product.setName("MyTV");

        Parameter parameter = new Parameter();
        parameter.setName("Model");
        parameter.setParameterType(ParameterType.STRING);

        ParameterValue parameterValue = new ParameterValue();
        parameterValue.setParameter(parameter);
        parameterValue.setProduct(product);
        parameterValue.setParameterValue("Samsung QLED");

        product.setCategory(category);
        product.setPrice(BigDecimal.valueOf(14999.99));
        product.setCount(1);

        category.addParameter(parameter);


        categoryDAO.saveCategory(category);
        productDAO.saveProduct(product);
        parameterValueDAO.saveParameterValue(parameterValue);
        return "index";
    }
}
