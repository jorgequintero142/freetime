package jq.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jq.supermarket.model.Product;
import jq.supermarket.model.ProductType;
import jq.supermarket.service.ProductService;
import jq.supermarket.service.ProductTypeService;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductAdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeService productTypeService;

	@GetMapping(value = { "", "/", "/all" })
	public String home(Model model) {
		model.addAttribute("products", productService.getInfoAllProducts());
		model.addAttribute("typesprod", productTypeService.getAll());
		model.addAttribute("isAdmin", true);
		Product pr = new Product();
		pr.setProductType(new ProductType());
		model.addAttribute("product", pr);
		return "home";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam(name = "id") Integer idProduct, Model model) {
		model.addAttribute("typesprod", productTypeService.getAll());
		model.addAttribute("product", productService.getById(idProduct));
		return "product/create";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("typesprod", productTypeService.getAll());
		model.addAttribute("product", new Product());
		return "product/create";
	}

	@PostMapping("/create")
	public String greetingSubmit(@ModelAttribute Product product, Model model) {
		try {
			product = productService.add(product);
			ProductType productType = productTypeService.findById(product.getProductType().getIdProductType());
			product.setProductType(productType);
			model.addAttribute("error", null);
		} catch (IllegalArgumentException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("typesprod", productTypeService.getAll());
		model.addAttribute("product", product);
		return "product/result";
	}
}
