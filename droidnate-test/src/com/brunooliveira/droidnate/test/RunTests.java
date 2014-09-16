package com.brunooliveira.droidnate.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import android.test.suitebuilder.TestSuiteBuilder;

public class RunTests extends TestSuite {
	
	public static Test suite() {
		return new TestSuiteBuilder(RunTests.class).includeAllPackagesUnderHere().build();
	}

}