package jq.supermarket.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.typeOfProduct.idTypeOfProduct = :idTypeOfProduct AND UPPER(p.nameProduct) LIKE %:nameProduct%")
	List<Product> searchByTypeProductAndName(@Param("idTypeOfProduct") Integer idTypeOfProduct,
			@Param("nameProduct") String nameProduct);

	@Query("SELECT p FROM Product p WHERE UPPER(p.nameProduct) LIKE %:nameProduct%")
	List<Product> searchByName(@Param("nameProduct") String nameProduct);

	@Query("SELECT p FROM Product p WHERE p.typeOfProduct.idTypeOfProduct = :idTypeOfProduct")
	List<Product> searchByTypeProduct(@Param("idTypeOfProduct") Integer idTypeOfProduct);
}