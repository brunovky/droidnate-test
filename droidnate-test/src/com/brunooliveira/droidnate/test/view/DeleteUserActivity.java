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

@ContentView(R.layout.delete_user_layout)
public class DeleteUserActivity extends RoboActivity {
	
	@InjectView(R.id.etIDToDelete)
	private EditText etIDToDelete;
	@InjectView(R.id.etNameToDelete)
	private EditText etNameToDelete;
	@InjectView(R.id.etAgeToDelete)
	private EditText etAgeToDelete;
	@InjectView(R.id.btDelete)
	private Button btDelete;
	
	private User deletedUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initListeners();
	}

	private void initListeners() {
		etIDToDelete.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					UserService userService = new UserService(DeleteUserActivity.this);
					userService.findById(Long.parseLong(etIDToDelete.getText().toString()), new ModelResponseHandler<User>() {
						@Override
						public void onSuccess(User result) {
							if (result != null) {
								etNameToDelete.setText(result.getName());
								etAgeToDelete.setText(String.valueOf(result.getAge()));
								deletedUser = result;
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
		btDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				UserService userService = new UserService(DeleteUserActivity.this);
				userService.delete(deletedUser.getId());
			}
		});
	}

}