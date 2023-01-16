package jq.supermarket.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends CrudRepository<ProductType, Integer> {

}
