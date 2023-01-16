package jq.supermarket.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

	@Autowired
	private ProductTypeRepo productTypeRepo;

	public ProductType add(ProductType productType) {
		return productTypeRepo.save(productType);
	}

	public Long count() {
		return productTypeRepo.count();
	}
}