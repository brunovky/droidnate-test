package com.brunooliveira.droidnate.test.app;

import com.brunooliveira.droidnate.ws.helper.WebServicesHelper;

import android.app.Application;

public class DroidnateApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		WebServicesHelper.setServerName("192.168.43.168");
		WebServicesHelper.setPort("8080");
		WebServicesHelper.setProjectName("droidnate-rest");
		WebServicesHelper.setWaitingText("Please wait...");
	}

}
