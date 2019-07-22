package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.leading.shop.configs.IAuthenticationFacade;
import vn.edu.leading.shop.models.ShipperModel;
import vn.edu.leading.shop.models.UserModel;
import vn.edu.leading.shop.services.CategoryService;
import vn.edu.leading.shop.services.ProductService;
import vn.edu.leading.shop.services.ShipperService;
import vn.edu.leading.shop.services.UserService;

import java.util.List;

@Controller
public class HomeController {

    public final CategoryService categoryService;

    private final ProductService productService;
    private final UserService userService;

    private final ShipperService shipperService;


    private final IAuthenticationFacade authentication;

    public HomeController(CategoryService categoryService, ProductService productService, UserService userService, ShipperService shipperService, IAuthenticationFacade authentication) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.shipperService = shipperService;
        this.authentication = authentication;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "admin/home/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "admin/home/index1";
    }

    @GetMapping("/product-detail/{id}/{str}")
    public String product(@PathVariable("id") Long id, Model model, @PathVariable String str) {
        model.addAttribute("productModel", productService.findById(id));
        model.addAttribute("metaname",str);

        return "admin/home/product-detail";
    }

    @GetMapping("/cart")
    public String addToCart(Model model) {
        List<ShipperModel> shipperModelList = shipperService.findAll();
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        model.addAttribute("shippers", shipperModelList);
        return "admin/home/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {

        return "admin/home/checkout";
    }
}
