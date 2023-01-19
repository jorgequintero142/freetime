package jq.supermarket.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import jq.supermarket.model.ProductType;
import jq.supermarket.repo.ProductTypeRepo;

@Configuration 
public class ProductTypeConfig implements CommandLineRunner {

	@Autowired
	private ProductTypeRepo productTypeRepo;

	@Override
	public void run(String... args) throws Exception {
		if (productTypeRepo.count() == 0) {
			ProductType productType1 = new ProductType(1, "Fruits");
			ProductType productType2 = new ProductType(2, "Vegetables");
			ProductType productType3 = new ProductType(3, "Fresh meat");
			ProductType productType4 = new ProductType(4, "Drinks");
			ProductType productType5 = new ProductType(5, "Baked");
			ProductType productType6 = new ProductType(6, "Grain and Cereal");
			ProductType productType7 = new ProductType(7, "Others");

			Set<ProductType> productList = new HashSet<>();
			productList.add(productType1);
			productList.add(productType2);
			productList.add(productType3);
			productList.add(productType4);
			productList.add(productType5);
			productList.add(productType6);
			productList.add(productType7);

			productTypeRepo.saveAll(productList);

		}
	}

}
