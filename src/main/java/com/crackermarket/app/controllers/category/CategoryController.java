package com.crackermarket.app.controllers.category;

import com.crackermarket.app.entities.Category;
import com.crackermarket.app.entities.Parameter;
import com.crackermarket.app.services.CategoryDAO;
import com.crackermarket.app.services.ParameterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ParameterDAO parameterDao;
    @Autowired
    private EntityManager entityManager;


    @GetMapping("/browser")
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryDAO.findAllCategories());
        return "categories/category_browser";
    }

    @GetMapping("/new")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryDAO.findAllCategories());
        model.addAttribute("parameters", parameterDao.findAllParameters());
        return "/categories/category_creator";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category,
                                 @RequestParam(value = "parentCategoryId", required = false) String parentCategoryId,
                                 @RequestParam(value = "parameterId", required = false) String parameterId) {
        if(parentCategoryId != null) {
            category.setParentCategory(categoryDAO.findCategoryById(UUID.fromString(parentCategoryId)));
        }
        if(parameterId != null) {
            Set<Parameter> parameterSet = new HashSet<>();
            parameterSet.add(parameterDao.findParameterById(UUID.fromString(parameterId)));
            category.setParameters(parameterSet);
        }

        categoryDAO.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") String id, Model model) {
        Category category = categoryDAO.findCategoryById(UUID.fromString(id));
        model.addAttribute("category", category);
        entityManager.getTransaction().begin();
        List<Category> parentCategories = entityManager.createQuery("SELECT c FROM Category c WHERE c.id NOT IN (:selfId)")
                .setParameter("selfId", category.getId())
                .getResultList();
        entityManager.getTransaction().commit();
        model.addAttribute("category", category);
        model.addAttribute("parentCategories", parentCategories);
        model.addAttribute("categoryParameters", category.getParameters());
        return "/categories/category_editor";
    }
}
