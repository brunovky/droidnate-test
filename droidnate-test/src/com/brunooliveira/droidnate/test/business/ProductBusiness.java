package com.brunooliveira.droidnate.test.business;

import android.content.Context;

import com.brunooliveira.droidnate.dao.DAO;
import com.brunooliveira.droidnate.exception.DroidnateException;
import com.brunooliveira.droidnate.test.model.Product;

public class ProductBusiness {
	
	private DAO<Product> productDAO;
	
	public ProductBusiness(Context context) {
		productDAO = new DAO<Product>(context, Product.class);
	}
	
	public long save(Product product) throws DroidnateException {
		return productDAO.insert(product);
	}
	
	public Product findById(Long id) throws DroidnateException {
		return productDAO.select("id=?", new String[] {id.toString()});
	}

}