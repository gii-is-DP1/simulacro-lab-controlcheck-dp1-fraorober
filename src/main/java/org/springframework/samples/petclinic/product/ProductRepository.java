package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
    List<Product> findAll();
//	
	@Query("select pt from ProductType pt")
	List<ProductType> findAllProductTypes();
//    
//    Optional<Product> findById(int id);
//	
	@Query("select p from Product p where p.name LIKE :name")
	Product findByName(String name);
	
	@Query("select pt from ProductType pt where pt.name LIKE :name")
    ProductType findProductTypeByName(String name);

	@Query("select p from Product p where p.price < :price")
	List<Product> findByPriceLessThan(double price);
//	
//	
//    Product save(Product p); 
}
