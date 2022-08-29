package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("select p from Product p")
    List<Product> findAll();
	
	@Query("select ptype from ProductType ptype")
    List<ProductType> findAllProductTypes();
    
	@Query("select p from Product p where p.id LIKE :id")
    Optional<Product> findById(int id);
	
	@Query("select p from Product p where p.name LIKE :name")
    Product findByName(String name);
	
	@Query("select p from ProductType p where p.name LIKE :name")
    ProductType findProductTypeByName(String name);
	
	@Query("select p from Product p where p.price < :price ")
	List<Product> findByPriceLessThan(double price);
	
	
    //Product save(Product p); ---> uso el del crud
}
