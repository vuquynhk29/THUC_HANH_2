package product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.data.ProductDB;
import product.modal.Product;

@Controller
@RequestMapping("/displayProducts")
public class ViewProducts {
	ProductDB productDB;
	
	@Autowired
	public ViewProducts(ProductDB productDB) {
		this.productDB = productDB;
	}
	
	@GetMapping
	public String displayProducts(Model model) {
		List<Product> list = new ArrayList<>();
		productDB.findAll().forEach(list::add);
		model.addAttribute("list", list);
		return "displayProducts";
	}
}
