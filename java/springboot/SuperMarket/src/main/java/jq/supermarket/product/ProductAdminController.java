package jq.supermarket.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jq.supermarket.typeofproduct.TypeOfProductService;
import jq.supermarket.typeofproduct.TypeOfProduct;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductAdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private TypeOfProductService typeOfProductService;

	@GetMapping(value = { "", "/", "/all" })
	public String home(Model model) {
		model.addAttribute("products", productService.getProducts(productService.getAllProducts()));
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		model.addAttribute("isAdmin", true);
		Product product = new Product();
		product.setTypeOfProduct(new TypeOfProduct());
		model.addAttribute("product", product);
		return "home";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam(name = "id") Integer idProduct, Model model) {
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		model.addAttribute("product", productService.getProductById(idProduct));
		return "product/create";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		model.addAttribute("product", new Product());
		return "product/create";
	}

	@PostMapping("/create")
	public String greetingSubmit(@ModelAttribute Product product, Model model) {
		try {
			product = productService.add(product);
			TypeOfProduct productType = typeOfProductService
					.getTypeOfProductById(product.getTypeOfProduct().getIdTypeOfProduct());
			product.setTypeOfProduct(productType);
			model.addAttribute("error", null);
		} catch (IllegalArgumentException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		model.addAttribute("product", product);
		return "product/result";
	}
}
