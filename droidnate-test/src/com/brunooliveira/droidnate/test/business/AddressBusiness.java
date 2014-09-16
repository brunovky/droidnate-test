package com.brunooliveira.droidnate.test.business;

import android.content.Context;

import com.brunooliveira.droidnate.dao.DAO;
import com.brunooliveira.droidnate.exception.DroidnateException;
import com.brunooliveira.droidnate.test.model.Address;


public class AddressBusiness {
	
	private DAO<Address> addressDAO;
	
	public AddressBusiness(Context context) {
		addressDAO = new DAO<Address>(context, Address.class);
	}
	
	public long save(Address address) throws DroidnateException {
		return addressDAO.insert(address);
	}
	
	public Address findById(Long id) throws DroidnateException {
		return addressDAO.select("id = ?", new String[] {id.toString()});
	}

}