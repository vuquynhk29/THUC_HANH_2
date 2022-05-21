package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.data.ProductDB;
import product.modal.Product;

@Controller
@RequestMapping("/addProduct")
public class AddProductController {
	ProductDB productDB;
	
	@Autowired
	public AddProductController(ProductDB productDB) {
		this.productDB = productDB;
	}
	
	@GetMapping
	public String addProductView(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@PostMapping
	public String addProduct(Product product, Model model) {
		if(productDB.findByCode(product.getCode())== null){
			productDB.save(product);
			return "redirect:/displayProducts";
		}
		else {
			model.addAttribute("error", "Code has been used. Please change");
			return "addProduct";
		}
		
	}
}
