package space.bum.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import space.bum.social.entity.Product;
import space.bum.social.entity.StoreUser;
import space.bum.social.repo.StoreUserRepository;
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
  
  @GetMapping("/edit/{id}")
  public String editProduct(@PathVariable("id") String idStr,
      Model model) {
    long id = Long.parseLong(idStr);
    model.addAttribute("product", service.get(id));
    return "edit_product";
  }
  
  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable("id") String idStr,
      Model model) {
    long id = Long.parseLong(idStr);
    service.delete(id);
    return "redirect:/";
  }
  
  @Autowired
  private StoreUserRepository storeUserRepository;
  
  @Autowired
  private PasswordEncoder encoder;
  
  @GetMapping("/register/{username}")
  public String registerUser(@PathVariable("username") String username) {
    StoreUser newUser = new StoreUser();
    newUser.setUsername(username);
    newUser.setPassword(encoder.encode("1234"));
    newUser.setEnabled(true);
    newUser.setRole("USER");
    
    storeUserRepository.save(newUser);
    return "redirect:/";
  }
}
