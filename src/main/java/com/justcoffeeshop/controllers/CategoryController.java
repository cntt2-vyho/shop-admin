package com.justcoffeeshop.controllers;

import com.justcoffeeshop.models.CategoryModel;
import com.justcoffeeshop.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/admin/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/pages/categories";
    }


    @PostMapping("/categories/save")
    public String save(@Valid CategoryModel category, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "categories/form";
        }
        categoryService.save(category);
        redirect.addFlashAttribute("successMessage", "Saved category successfully!");
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (categoryService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted category successfully!");
            return "redirect:/categories";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/categories";
        }
    }
}
