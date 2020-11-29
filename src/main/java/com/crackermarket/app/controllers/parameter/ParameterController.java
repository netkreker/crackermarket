package com.crackermarket.app.controllers.parameter;

import com.crackermarket.app.entities.Category;
import com.crackermarket.app.entities.Parameter;
import com.crackermarket.app.entities.ParameterType;
import com.crackermarket.app.services.ParameterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.UUID;

@Controller
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    ParameterDao parameterDao;

    @GetMapping("/new")
    public String createNewParameter(Model model) {
        model.addAttribute("parameter", new Parameter());
        return "/parameters/parameter_creator";
    }

    @PostMapping("/create")
    public String saveParameter(@ModelAttribute("parameter") Parameter parameter,
                                @RequestParam(value = "type", required = false) String type) {
        switch (type) {
            case "text" : parameter.setParameterType(ParameterType.STRING); break;
            case "number" : parameter.setParameterType(ParameterType.INTEGER); break;
            case "logic" : parameter.setParameterType(ParameterType.BOOLEAN); break;
        }
        parameterDao.saveParameter(parameter);
        return "redirect:/";
    }
}
