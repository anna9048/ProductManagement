package com.faith.model;

import java.sql.Date;



public class Product {

	 private Integer productID;
	 private String productName;
	 private Date manufacturingDate;
	 private Integer suppliedId;
	 private Integer categoryId;
	 private Double Price;
	 private Integer stock,status;
	 
	 public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Integer getSuppliedId() {
		return suppliedId;
	}

	public void setSuppliedId(Integer suppliedId) {
		this.suppliedId = suppliedId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName="
				+ productName + ", manufacturingDate=" + manufacturingDate
				+ ", suppliedId=" + suppliedId + ", categoryId=" + categoryId
				+ ", Price=" + Price + ", stock=" + stock + ", status="
				+ status + "]";
	}
	 
	
}
