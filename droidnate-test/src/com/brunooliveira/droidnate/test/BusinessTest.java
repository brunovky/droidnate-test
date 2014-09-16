package com.brunooliveira.droidnate.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import android.test.AndroidTestCase;

import com.brunooliveira.droidnate.exception.DroidnateException;
import com.brunooliveira.droidnate.helper.DatabaseHelper;
import com.brunooliveira.droidnate.test.business.AddressBusiness;
import com.brunooliveira.droidnate.test.business.ProductBusiness;
import com.brunooliveira.droidnate.test.business.UserBusiness;
import com.brunooliveira.droidnate.test.model.Address;
import com.brunooliveira.droidnate.test.model.Product;
import com.brunooliveira.droidnate.test.model.User;

public class BusinessTest extends AndroidTestCase {

	private UserBusiness userBusiness;
	private AddressBusiness addressBusiness;
	private ProductBusiness productBusiness;

	@Override
	protected void setUp() throws Exception {
		DatabaseHelper.setDefaultPackage("com.brunooliveira.droidnate.test");
		DatabaseHelper.setDatabaseName("db_teste.db");
		this.userBusiness = new UserBusiness(getContext());
		this.addressBusiness = new AddressBusiness(getContext());
		this.productBusiness = new ProductBusiness(getContext());
	}

	public void test1SaveUser() {
		try {
			Address address = new Address("Street One", 1000);
			addressBusiness.save(address);
			address = addressBusiness.findById(1L);
			long result = userBusiness.save(new User("Bruno Oliveira", true, Calendar.getInstance(), address));
			assertFalse(result == -1);
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

	public void test2NameError() {
		try {
			userBusiness.save(new User());
			fail("Deveria retornar DroidnateException");
		} catch (DroidnateException e) {
			assertEquals("name can't be null", e.getCause().getLocalizedMessage());
		}
	}

	public void test3DeleteUser() {
		try {
			Address address = addressBusiness.findById(1L);
			userBusiness.save(new User("Deleted User", true, Calendar.getInstance(), address));
			int result = userBusiness.delete(2L);
			assertEquals(1, result);
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

	public void test4UpdateUser() {
		try {
			User updatedUser = userBusiness.findById(1L);
			updatedUser.setAdmin(false);
			int result = userBusiness.update(updatedUser, 1L);
			assertFalse(result == -1);
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

	public void test5FindUserById() {
		try {
			User user = userBusiness.findById(1L);
			assertEquals("Bruno Oliveira", user.getName());
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

	public void test6FindAllUsers() {
		try {
			List<User> users = userBusiness.findAllUsers();
			assertEquals(1, users.size());
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

	public void test7SaveProduct() {
		try {
			Product product = new Product(5, 12.99, new BigDecimal(5 * 12.99));
			long result = productBusiness.save(product);
			assertFalse(result == -1);
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}
	
	public void test8FindProductById() {
		try {
			Product product = productBusiness.findById(1L);
			assertEquals(12.99, product.getUnitPrice());
		} catch (DroidnateException e) {
			fail(e.getMessage());
		}
	}

}