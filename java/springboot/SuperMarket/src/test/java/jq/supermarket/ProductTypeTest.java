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

import jq.supermarket.typeofproduct.TypeOfProduct;
import jq.supermarket.typeofproduct.TypeOfProductRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductTypeTest {

	@Autowired
	private TypeOfProductRepository productTypeRepo;

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
		TypeOfProduct productType = new TypeOfProduct(999, "Cheese");
		TypeOfProduct productTypeSaved = productTypeRepo.save(productType);

		assertEquals(productTypeSaved.getNameTypeOfProduct(), productType.getNameTypeOfProduct());

		assertEquals((totalRecords) + 1, productTypeRepo.count());

	}

	@Test
	@Order(2)
	void testSearchProductType() {
		Optional<TypeOfProduct> productTypeExist = productTypeRepo.findById(999);
		assertEquals(true, productTypeExist.isPresent());

		Optional<TypeOfProduct> productTypeNotExist = productTypeRepo.findById(-9);
		assertEquals(false, productTypeNotExist.isPresent());

	}

	@Test
	@Order(3)
	void delete() {
		Optional<TypeOfProduct> productTypeExist = productTypeRepo.findById(999);
		productTypeRepo.deleteById(productTypeExist.get().getIdTypeOfProduct());
		assertEquals(0, productTypeRepo.count());
	}
}