package com.brunooliveira.droidnate.test.view;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.brunooliveira.droidnate.test.R;
import com.brunooliveira.droidnate.test.rest.model.User;
import com.brunooliveira.droidnate.test.service.UserService;
import com.brunooliveira.droidnate.ws.response.ModelResponseHandler;

@ContentView(R.layout.update_user_layout)
public class UpdateUserActivity extends RoboActivity {
	
	@InjectView(R.id.etIDToUpdate)
	private EditText etIDToUpdate;
	@InjectView(R.id.etNameToUpdate)
	private EditText etNameToUpdate;
	@InjectView(R.id.etAgeToUpdate)
	private EditText etAgeToUpdate;
	@InjectView(R.id.btUpdate)
	private Button btUpdate;
	
	private User updatedUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initListeners();
	}

	private void initListeners() {
		etIDToUpdate.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					UserService userService = new UserService(UpdateUserActivity.this);
					userService.findById(Long.parseLong(etIDToUpdate.getText().toString()), new ModelResponseHandler<User>() {
						@Override
						public void onSuccess(User result) {
							if (result != null) {
								etNameToUpdate.setEnabled(true);
								etAgeToUpdate.setEnabled(true);
								etNameToUpdate.setText(result.getName());
								etAgeToUpdate.setText(String.valueOf(result.getAge()));
								updatedUser = result;
							}
						}

						@Override
						public void onFailure(String errorMsg) {
							Toast.makeText(getBaseContext(), errorMsg, Toast.LENGTH_LONG).show();
						}
					});
				}
			}
		});
		btUpdate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				UserService userService = new UserService(UpdateUserActivity.this);
				String name = etNameToUpdate.getText().toString();
				String age = etAgeToUpdate.getText().toString();
				updatedUser.setName(name);
				updatedUser.setAge(Integer.parseInt(age));
				userService.update(updatedUser);
			}
		});
	}

}