package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.data.ProductDB;

@Controller
@RequestMapping("/remove")
public class RemoveController {
	ProductDB productDB;
	
	@Autowired
	public RemoveController(ProductDB productDB) {
		this.productDB = productDB;
	}
	@GetMapping
	public String removeView(@RequestParam("code") String code, Model model) {
		model.addAttribute("product", productDB.findByCode(code));
		return "remove";
	}
	@PostMapping
	public String remove(@RequestParam("code") String code) {
		productDB.delete(code);
		return "redirect:/displayProducts";
	}
}
