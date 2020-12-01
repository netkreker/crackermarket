package com.crackermarket.app.controllers;

import com.crackermarket.app.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class MainController {
    @GetMapping("/")
    public String sayHello() {
        return "index";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){

        Category category = new Category();
        category.setName("TV");

        Product product = new Product();
        product.setName("Samsung");
        product.setPrice(BigDecimal.valueOf(15499.99));
        product.setCategory(category);

        Parameter parameter = new Parameter();
        parameter.setParameterType(ParameterType.INTEGER);
        parameter.setName("WIDTH");

        ParameterValue parameterValue = new ParameterValue();
        parameterValue.setValue("350");
        parameterValue.setProduct(product);
        parameterValue.setParameter(parameter);

        return "goodbye";
    }
}
