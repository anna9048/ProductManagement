package com.faith.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.Product;

public class ProductDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private static final String INSERT = "INSERT INTO PRODUCT(productName,manufacturingDate,suppliedId,categoryId,Price,stock,status)values(?,?,?,?,?,?,1)";
	private static final String LIST = "SELECT * FROM PRODUCT";
	private static final String SEARCH_ByName = "SELECT * FROM PRODUCT where productname=?";
	
	private static final String UPDATE = "UPDATE PRODUCT SET productName=?,manufacturingDate=?,suppliedId=?,categoryId=?,price=?,stock=? where productid=?";
	private static final String DELETE = "UPDATE PRODUCT SET STATUS=0 WHERE PRODUCTID=?";

	// Insert product details

	public void insertProduct(final Product product) {

		template.update(INSERT, product.getProductName(),
				product.getManufacturingDate(), product.getSuppliedId(),
				product.getCategoryId(), product.getPrice(), product.getStock());
	}

	// List all product details

	public List<Product> listAllProductDetails() {
		return template.query(LIST, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product objProduct = new Product();
				objProduct.setProductID(rs.getInt(1));
				objProduct.setProductName(rs.getString(2));
				objProduct.setManufacturingDate(rs.getDate(3));
				objProduct.setSuppliedId(rs.getInt(4));
				objProduct.setCategoryId(rs.getInt(5));
				objProduct.setPrice(rs.getDouble(6));
				objProduct.setStock(rs.getInt(7));
				objProduct.setStatus(rs.getInt(8));
				return objProduct;
			}
		});
	}

	// list products by manufacturing year
	
	/*
	public List<Product> listAllProductDetails() {

        List<Product> products = template.query(
               LIST,
                new BeanPropertyRowMapper<Product>(Product.class));

        return products;
    }*/

	// Search product by name
	public Product findByName(String productName) {

		return template.queryForObject(SEARCH_ByName,
				new Object[] { productName },
				new BeanPropertyRowMapper<Product>(Product.class));

	}

	//update product
	public void updateProduct(final Product product){  
		
		template.update(UPDATE, product.getProductName(),
				product.getManufacturingDate(), product.getSuppliedId(),
				product.getCategoryId(), product.getPrice(), product.getStock(),product.getProductID());
	    
	}  
	
	//delete product
	public void deleteProduct(final int ID){  
	      

    	template.update(DELETE, ID); 
	}
}
