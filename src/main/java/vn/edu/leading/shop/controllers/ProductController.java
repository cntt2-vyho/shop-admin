package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.ProductModel;
import vn.edu.leading.shop.services.CategoryService;
import vn.edu.leading.shop.services.ProductService;
import vn.edu.leading.shop.services.SupplierService;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final SupplierService supplierService;

    public ProductController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @GetMapping("/admin/products")
    public String product(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "admin/pages/products";
    }

    @PostMapping("admin/products")
    public String save(@Valid ProductModel product, BindingResult result, RedirectAttributes redirect,Model model) {
        if (result.hasErrors()) {
            return "admin/pages/products";
        }
        productService.save(product);
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved product successfully!");
        return "admin/pages/products";
    }

    @GetMapping("/products/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect,Model model) {
        if (productService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted product successfully!");
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            return "admin/pages/products";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            return "admin/pages/products";
        }
    }
}
