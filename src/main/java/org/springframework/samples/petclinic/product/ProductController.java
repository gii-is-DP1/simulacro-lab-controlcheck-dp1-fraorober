package org.springframework.samples.petclinic.product;

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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		String vista = "products/createOrUpdateProductForm";
		Product product = new Product();
		model.put("product", product);
		model.put("tipos", productServ.getAllProductTypes());
		return vista;
	}
	
	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {
		String vista = "products/createOrUpdateProductForm";
		if (result.hasErrors()) {
			model.put("product", product);
			model.put("tipos", productServ.getAllProductTypes());
			return vista;
		}
		else {
			//creating owner, user and authorities
			this.productServ.save(product);
			model.put("message", "Guardado satisfactoriamente.");
			return "welcome";
		}
	}
    
}
