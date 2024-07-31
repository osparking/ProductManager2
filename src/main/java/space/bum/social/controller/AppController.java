package space.bum.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import space.bum.social.entity.Product;
import space.bum.social.service.ProductService;

@Controller
public class AppController {

  @Autowired
  private ProductService service;

  @GetMapping("/new")
  public String newProductView(Model model) {
    var product = new Product();
    model.addAttribute("product", product);
    return "new_product";
  }

  @GetMapping("/")
  public String homePage(Model model) {
    List<Product> products = service.listAll();
    model.addAttribute("products", products);
    return "index";
  }
  
  @PostMapping("/save") 
  public String saveProduct (Product product){
      service.save(product);
      return "redirect:/";
  }
}
