package com.brunooliveira.droidnate.test.view;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.brunooliveira.droidnate.test.R;

@ContentView(R.layout.menu_layout)
public class MenuActivity extends RoboActivity {
	
	@InjectView(R.id.btInsertUser)
	private Button btInsertUser;
	@InjectView(R.id.btUpdateUser)
	private Button btUpdateUser;
	@InjectView(R.id.btDeleteUser)
	private Button btDeleteUser;
	@InjectView(R.id.btFindUserById)
	private Button btFindUserById;
	@InjectView(R.id.btFindAllUsers)
	private Button btFindAllUsers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initListeners();
	}

	private void initListeners() {
		btInsertUser.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, InsertUserActivity.class));
			}
		});
		btUpdateUser.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, UpdateUserActivity.class));
			}
		});
		btDeleteUser.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, DeleteUserActivity.class));
			}
		});
		btFindUserById.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, FindUserByIdActivity.class));
			}
		});
		btFindAllUsers.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, FindAllUsersActivity.class));
			}
		});
	}

}