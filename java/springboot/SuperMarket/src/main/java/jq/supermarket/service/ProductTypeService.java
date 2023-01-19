package jq.supermarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jq.supermarket.model.Product;
import jq.supermarket.model.ProductType;
import jq.supermarket.repo.ProductTypeRepo;

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

	public List<ProductType> getAll() {
		return (List<ProductType>) productTypeRepo.findAll();
	}

	public ProductType findById(Integer idProductType) {
		Optional<ProductType> optProductType = productTypeRepo.findById(idProductType);
		if (!optProductType.isPresent()) {
			throw new IllegalArgumentException(String.format("Product Type with id %d does not exist", idProductType));
		}
		return optProductType.get();
	}

}