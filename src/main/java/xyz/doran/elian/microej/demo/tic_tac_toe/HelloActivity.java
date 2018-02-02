/*
 * Java
 *
 * Copyright 2008-2015 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package xyz.doran.elian.microej.demo.tic_tac_toe;

import ej.microui.MicroUI;
import ej.wadapps.app.Activity;

/**
 * Hello activity
 */
public class HelloActivity implements Activity {
	private HelloDisplayable displayable;


	public HelloActivity() {
		MicroUI.start();
	}

	@Override
	public void onStart() {
		displayable = new HelloDisplayable();
		displayable.show();
	}

	@Override
	public void onStop() {
		this.displayable.hide();
		this.displayable = null;
	}

	@Override
	public void onCreate() {
	}

	@Override
	public void onRestart() {
	}

	@Override
	public void onResume() {
	}

	@Override
	public void onPause() {
	}

	@Override
	public void onDestroy() {
	}

	@Override
	public String getID() {
		return "Hello-activity";
	}

}
