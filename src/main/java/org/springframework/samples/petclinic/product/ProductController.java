package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping(value="/create")
	private String initFormCreate(ModelMap model) {
		String vista = "products/createOrUpdateProductForm";
		List<ProductType> tipos = productServ.getAllProductTypes();
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("tipos", tipos);
		return vista;
	}
	
	@PostMapping(value="/create")
	private String saveProduct(@Valid Product product, BindingResult result, ModelMap model) {
		String vista = "products/createOrUpdateProductForm";
		List<ProductType> tipos = productServ.getAllProductTypes();

		if(result.hasErrors()) {
			model.addAttribute("tipos", tipos);
			model.addAttribute("product", product);
			return vista;
		}else{
			productServ.save(product);
			model.addAttribute("message", "Producto guardado correctamente.");
			return "welcome";
		}
		
	}
	
    
}
