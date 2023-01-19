package jq.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jq.supermarket.model.ProductType;
import jq.supermarket.repo.ProductTypeRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductTypeTest {

	@Autowired
	private ProductTypeRepo productTypeRepo;

	private Long totalRecords = 0l;

	@BeforeAll
	static void setup() {

	}

	@BeforeEach
	void init() {
		totalRecords = productTypeRepo.count();
	}

	@Test
	@Order(1)
	void testSaveProductType() {
		if (totalRecords > 0) {
			productTypeRepo.deleteAll();
		}
		ProductType productType = new ProductType(999, "Cheese");
		ProductType productTypeSaved = productTypeRepo.save(productType);

		assertEquals(productTypeSaved.getNameProductType(), productType.getNameProductType());

		assertEquals((totalRecords) + 1, productTypeRepo.count());

	}

	@Test
	@Order(2)
	void testSearchProductType() {
		Optional<ProductType> productTypeExist = productTypeRepo.findById(999);
		assertEquals(true, productTypeExist.isPresent());

		Optional<ProductType> productTypeNotExist = productTypeRepo.findById(-9);
		assertEquals(false, productTypeNotExist.isPresent());

	}

	@Test
	@Order(3)
	void delete() {
		Optional<ProductType> productTypeExist = productTypeRepo.findById(999);
		productTypeRepo.deleteById(productTypeExist.get().getIdProductType());
		assertEquals(0, productTypeRepo.count());
	}
}