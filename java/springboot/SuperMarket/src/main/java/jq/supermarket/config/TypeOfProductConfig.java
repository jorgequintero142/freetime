package jq.supermarket.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import jq.supermarket.typeofproduct.TypeOfProduct;
import jq.supermarket.typeofproduct.TypeOfProductRepository;

@Configuration 
public class TypeOfProductConfig implements CommandLineRunner {

	@Autowired
	private TypeOfProductRepository typeOfProductRepository;

	@Override
	public void run(String... args) throws Exception {
		//Creating new  types of product
		if (typeOfProductRepository.count() == 0) {
			TypeOfProduct typeOfProduct1 = new TypeOfProduct(1, "Fruits");
			TypeOfProduct typeOfProduct2 = new TypeOfProduct(2, "Vegetables");
			TypeOfProduct typeOfProduct3 = new TypeOfProduct(3, "Fresh meat");
			TypeOfProduct typeOfProduct4 = new TypeOfProduct(4, "Drinks");
			TypeOfProduct typeOfProduct5 = new TypeOfProduct(5, "Baked");
			TypeOfProduct typeOfProduct6 = new TypeOfProduct(6, "Grain and Cereal");
			TypeOfProduct typeOfProduct7 = new TypeOfProduct(7, "Others");

			Set<TypeOfProduct> typeOfProducts = new HashSet<>();
			typeOfProducts.add(typeOfProduct1);
			typeOfProducts.add(typeOfProduct2);
			typeOfProducts.add(typeOfProduct3);
			typeOfProducts.add(typeOfProduct4);
			typeOfProducts.add(typeOfProduct5);
			typeOfProducts.add(typeOfProduct6);
			typeOfProducts.add(typeOfProduct7);

			typeOfProductRepository.saveAll(typeOfProducts);

		}
	}

}
