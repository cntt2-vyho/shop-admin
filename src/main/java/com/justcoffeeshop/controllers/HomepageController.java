package com.justcoffeeshop.controllers;

import com.justcoffeeshop.models.UserModel;
import com.justcoffeeshop.services.CategoryService;
import com.justcoffeeshop.services.ProductService;
import com.justcoffeeshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomepageController {

    private final ProductService productService;

    private final UserService userService;


    private final CategoryService categoryService;

    public HomepageController(ProductService productService, UserService userService, CategoryService categoryService) {
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "littlecloset/index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", productService.findAll());
        return "littlecloset/cart";
    }
}
