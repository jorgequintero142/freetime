package jq.supermarket.typeofproduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfProductRepository extends CrudRepository<TypeOfProduct, Integer> {

}
