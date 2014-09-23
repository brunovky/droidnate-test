package com.brunooliveira.droidnate.test.view;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.brunooliveira.droidnate.test.R;
import com.brunooliveira.droidnate.test.rest.model.User;
import com.brunooliveira.droidnate.test.service.UserService;

@ContentView(R.layout.insert_user_layout)
public class InsertUserActivity extends RoboActivity {
	
	@InjectView(R.id.etNameToInsert)
	private EditText etNameToInsert;
	@InjectView(R.id.etAgeToInsert)
	private EditText etAgeToInsert;
	@InjectView(R.id.btSave)
	private Button btSave;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initListeners();
	}

	private void initListeners() {
		btSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				UserService userService = new UserService(InsertUserActivity.this);
				String name = etNameToInsert.getText().toString();
				String age = etAgeToInsert.getText().toString();
				User user = new User(name, age != null && !age.equals("") ? Integer.parseInt(age) : 0);
				userService.save(user);
			}
		});
	}

}