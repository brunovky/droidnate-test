package com.brunooliveira.droidnate.test.view;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.brunooliveira.droidnate.test.R;
import com.brunooliveira.droidnate.test.rest.model.User;
import com.brunooliveira.droidnate.test.service.UserService;
import com.brunooliveira.droidnate.ws.response.ListModelResponseHandler;

@ContentView(R.layout.find_all_users_layout)
public class FindAllUsersActivity extends RoboActivity {

	@InjectView(R.id.lvUsers)
	private ListView lvUsers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initAdapters();
	}

	private void initAdapters() {
		UserService userService = new UserService(FindAllUsersActivity.this);
		userService.findAllUsers(new ListModelResponseHandler<User>() {
			@Override
			public void onSuccess(List<User> result) {
				if (result != null) {
					List<String> users = new ArrayList<String>();
					for (User user : result) {
						users.add(user.toString());
					}
					lvUsers.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, users));
				}
			}
			
			@Override
			public void onFailure(String errorMsg) {
				Toast.makeText(getBaseContext(), errorMsg, Toast.LENGTH_LONG).show();
			}
		});
	}

}