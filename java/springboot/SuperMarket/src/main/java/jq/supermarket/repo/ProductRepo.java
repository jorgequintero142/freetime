package jq.supermarket.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jq.supermarket.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.productType.idProductType = :productType AND UPPER(p.nameProduct) LIKE %:productName%")
	List<Product> searchByTypeProductAndName(@Param("productType") Integer productType,
			@Param("productName") String productName);

	@Query("SELECT p FROM Product p WHERE UPPER(p.nameProduct) LIKE %:productName%")
	List<Product> searchByName(@Param("productName") String productName);

	@Query("SELECT p FROM Product p WHERE p.productType.idProductType = :productType")
	List<Product> searchByTypeProduct(@Param("productType") Integer productType);
}