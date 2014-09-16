package com.brunooliveira.droidnate.test.business;

import java.util.List;

import android.content.Context;

import com.brunooliveira.droidnate.dao.DAO;
import com.brunooliveira.droidnate.exception.DroidnateException;
import com.brunooliveira.droidnate.test.model.User;

public class UserBusiness {

	private DAO<User> userDAO;

	public UserBusiness(Context context) {
		userDAO = new DAO<User>(context, User.class);
	}

	public long save(User user) throws DroidnateException {
		return userDAO.insert(user);
	}
	
	public int update(User user, Long id) throws DroidnateException {
		return userDAO.update(user, "id = ?", new String[] {id.toString()});
	}
	
	public int delete(Long id) {
		return userDAO.delete("id = ?", new String[] {id.toString()});
	}
	
	public User findById(Long id) throws DroidnateException {
		return userDAO.select("id = ?", new String[] {id.toString()});
	}
	
	public List<User> findAllUsers() throws DroidnateException {
		return userDAO.selectAll("id");
	}

}