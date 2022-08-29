package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRep;
	
    public List<Product> getAllProducts(){
        return productRep.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRep.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRep.findProductTypeByName(typeName);
    }
    
    public List<ProductType> getAllProductTypes(){
    	return productRep.findAllProductTypes();
    }

    public Product save(Product p){
        return productRep.save(p);       
    }

    
}
