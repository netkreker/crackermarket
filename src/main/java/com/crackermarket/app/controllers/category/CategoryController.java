package com.crackermarket.app.controllers.category;

import com.crackermarket.app.entities.Category;
import com.crackermarket.app.services.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @GetMapping("/new")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryDAO.findAllCategories());

        return "/categories/category_creator";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category,
                                 @RequestParam(value = "parentCategoryId", required = false) String id) {
        if(id != null) {
            category.setParentCategory(categoryDAO.findCategoryById(UUID.fromString(id)));
        }

        categoryDAO.saveCategory(category);
        return "redirect:/";
    }
}
