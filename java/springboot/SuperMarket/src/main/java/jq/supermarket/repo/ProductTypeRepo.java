package jq.supermarket.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jq.supermarket.model.ProductType;

@Repository
public interface ProductTypeRepo extends CrudRepository<ProductType, Integer> {

}
