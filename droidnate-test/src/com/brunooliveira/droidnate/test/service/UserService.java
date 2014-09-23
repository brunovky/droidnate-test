package com.brunooliveira.droidnate.test.service;

import android.content.Context;
import android.widget.Toast;

import com.brunooliveira.droidnate.test.rest.model.User;
import com.brunooliveira.droidnate.ws.annotations.DELETE;
import com.brunooliveira.droidnate.ws.annotations.GET;
import com.brunooliveira.droidnate.ws.annotations.POST;
import com.brunooliveira.droidnate.ws.annotations.PUT;
import com.brunooliveira.droidnate.ws.request.RequestBuilder;
import com.brunooliveira.droidnate.ws.response.ListModelResponseHandler;
import com.brunooliveira.droidnate.ws.response.ModelResponseHandler;
import com.brunooliveira.droidnate.ws.response.ToastResponseHandler;

public class UserService {

	private Context context;

	public UserService(Context context) {
		this.context = context;
	}

	@POST("user/save")
	public void save(User user) {
		if (user.getName() == null || user.getName().equals("")) Toast.makeText(context, "User is required", Toast.LENGTH_LONG).show();
		else if (user.getAge() == 0) Toast.makeText(context, "Age is required", Toast.LENGTH_LONG).show();
		else new RequestBuilder(context).entity(user).waitingDialog(true).create().execute(new ToastResponseHandler(context, "User registered successfully!", "Failure user account"));
	}

	@PUT("user/update")
	public void update(User user) {
		new RequestBuilder(context).entity(user).waitingDialog(true).create().execute(new ToastResponseHandler(context, "User updated successfully!", "Failure user account"));
	}

	@DELETE("user/delete/{id}")
	public void delete(Long id) {
		new RequestBuilder(context).param("id", id).waitingDialog(true).create().execute(new ToastResponseHandler(context, "User deleted successfully!", "Failure user account"));
	}

	@GET(value = "user/find/{id}", returnType = User.class)
	public void findById(Long id, ModelResponseHandler<User> handler) {
		new RequestBuilder(context).param("id", id).waitingDialog(true).create().execute(handler);
	}

	@GET(value = "user/all", returnType = User.class)
	public void findAllUsers(ListModelResponseHandler<User> handler) {
		new RequestBuilder(context).waitingDialog(true).create().execute(handler);
	}

}