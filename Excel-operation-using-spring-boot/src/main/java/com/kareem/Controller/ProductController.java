package com.kareem.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kareem.Entity.Product;
import com.kareem.Helper.ProductHelper;
import com.kareem.Services.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/upload")
	public ResponseEntity<?> Upload(@RequestParam("file") MultipartFile file) {
		if (ProductHelper.checkExcelFormat(file)) {
			// true

			this.productService.save(file);
			return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to DB"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Upload Excel File");
	}

	
	@GetMapping("product")
	public List<Product> getAllProduct()
	{
		return this.productService.getAllProducts();
	}
} 
