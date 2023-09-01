package com.kareem.Services;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.kareem.Entity.Product;
import com.kareem.Helper.ProductHelper;
import com.kareem.Repository.ProductRepositroy;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositroy productRepositroy;
	
	public void save(MultipartFile file)
	{
		try {
			
	List<Product> products 	= ProductHelper.convertExcelToListOfProduct(file.getInputStream());
	this.productRepositroy.saveAll(products);
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts(){
		return this.productRepositroy.findAll();
	}
	
}
