package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.data.ProductDB;
import product.modal.Product;

@Controller
@RequestMapping("/edit")
public class EditController {
	ProductDB productDB;
	
	@Autowired
	public EditController(ProductDB productDB) {
		this.productDB = productDB;
	}
	
	@GetMapping
	public String editView(@RequestParam("code") String code, Model model) {
		Product product = productDB.findByCode(code);
		model.addAttribute("product", product);
		return "edit";
	}
	
	@PostMapping
	public String editProduct(Product product) {
		product.setCode(product.getCode().split(",")[0]);
		System.out.println(productDB.update(product));
		return "redirect:/displayProducts";
	}
}
