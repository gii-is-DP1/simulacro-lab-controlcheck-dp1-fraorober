package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	@Autowired
	private ProductService productServ;
	
	
	@Override	//mostrar
	public String print(ProductType object, Locale locale) {
		String name = object.name;
		return name;
	}

	@Override
	public ProductType parse(String text, Locale locale) throws ParseException {
		ProductType productType = productServ.getProductType(text);
		if(productType == null) {
			throw new ParseException(text, 0);
		}else {
			return productType;
		}
	}
	
    
}
