package com.brunooliveira.droidnate.test.model;

import java.math.BigDecimal;

import com.brunooliveira.droidnate.annotations.Column;
import com.brunooliveira.droidnate.annotations.Entity;

@Entity
public class Product {

	@Column(generatedValue = true)
	private Long id;
	private int quantity;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "total_price")
	private BigDecimal totalPrice;

	public Product(int quantity, double unitPrice, BigDecimal totalPrice) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}