package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.ProductDao;
import com.faith.model.Product;

@CrossOrigin
@RestController
@RequestMapping("/st")
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	// INSERTING COURSE

		@RequestMapping(value = "/product", method = RequestMethod.POST)
		public void insertProductDetails(@RequestBody Product product) {
			dao.insertProduct(product);
		}

		//LISTING COURSE
		@RequestMapping(value = "/products", method = RequestMethod.GET)
		public List getProductDetails() {

			List list;
			System.out.println("Get all the mechine Details : ");
			list = dao.listAllProductDetails();

			return list;
		}
		
		// DETAILS SELECT BY Name

		@RequestMapping(value = "/productsname/{productName}", method = RequestMethod.GET)
		public Product getEmployeeByName(@PathVariable("productName") String proName) {

			System.out.println("Get the single mechine details using name: ");
			Product vd = (Product) dao.findByName(proName);
			return vd;
		}
		
		//Updating Product
		
		@RequestMapping(value = "/productupdate/{id}", method = RequestMethod.PUT)
		public void updateProductDetails(@RequestBody Product pr){
			
			dao.updateProduct(pr);
		}
		
		
		
		// Disabling product

		@RequestMapping(value = "/productdel/{id}", method = RequestMethod.PUT)
		void disableProduct(@PathVariable("id") int proId) {

			dao.deleteProduct(proId);
		}
}
