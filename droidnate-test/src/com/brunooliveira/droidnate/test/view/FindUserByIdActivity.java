package com.brunooliveira.droidnate.test.view;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.Toast;

import com.brunooliveira.droidnate.test.R;
import com.brunooliveira.droidnate.test.rest.model.User;
import com.brunooliveira.droidnate.test.service.UserService;
import com.brunooliveira.droidnate.ws.response.ModelResponseHandler;

@ContentView(R.layout.find_user_by_id_layout)
public class FindUserByIdActivity extends RoboActivity {

	@InjectView(R.id.etIDToFind)
	private EditText etIDToFind;
	@InjectView(R.id.etNameToFind)
	private EditText etNameToFind;
	@InjectView(R.id.etAgeToFind)
	private EditText etAgeToFind;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initListeners();
	}

	private void initListeners() {
		etIDToFind.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					UserService userService = new UserService(FindUserByIdActivity.this);
					userService.findById(Long.parseLong(etIDToFind.getText().toString()), new ModelResponseHandler<User>() {
						@Override
						public void onSuccess(User result) {
							if (result != null) {
								etNameToFind.setText(result.getName());
								etAgeToFind.setText(String.valueOf(result.getAge()));
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
	}

}