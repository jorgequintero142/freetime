package jq.supermarket.typeofproduct;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfProductService {

	@Autowired
	private TypeOfProductRepository typeOfProductRepository;

	public Long count() {
		return typeOfProductRepository.count();
	}

	public TypeOfProduct add(TypeOfProduct typeOfProduct) {
		return typeOfProductRepository.save(typeOfProduct);
	}

	public List<TypeOfProduct> getAllTypeOfProducts() {
		return (List<TypeOfProduct>) typeOfProductRepository.findAll();
	}

	public TypeOfProduct getTypeOfProductById(Integer idTypeOfProduct) {
		Optional<TypeOfProduct> typeOfProduct = typeOfProductRepository.findById(idTypeOfProduct);
		if (!typeOfProduct.isPresent()) {
			throw new IllegalArgumentException(
					String.format("Type of product with id %d does not exist", idTypeOfProduct));
		}
		return typeOfProduct.get();
	}

}