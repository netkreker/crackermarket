package com.crackermarket.app.shop.restcontrollers;

import com.crackermarket.app.shop.entities.Category;
import com.crackermarket.app.shop.services.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    Logger logger = Logger.getLogger(CategoryRestController.class);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> showAllCategories() {
        Category category = new Category();
        category.setName("Main");
        categoryService.save(category);
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()) {
            logger.error(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(categories, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if(category.getName() != null && !"".equals(category.getName())) {
            logger.info(HttpStatus.CREATED);
            return new ResponseEntity<>(category, httpHeaders, HttpStatus.CREATED);
        } else {
            logger.error(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> findCategory(@PathVariable String id){
        HttpHeaders httpHeaders = new HttpHeaders();
        Category category = categoryService.findById(id);
        if(category != null) {
            logger.info(HttpStatus.FOUND);
            return new ResponseEntity<>(category, httpHeaders,HttpStatus.OK);
        } else {
            logger.error(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
