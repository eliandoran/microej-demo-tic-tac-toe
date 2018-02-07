/*
 * Java
 *
 * Copyright 2008-2015 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package xyz.doran.elian.ej.tic_tac_toe;

import ej.microui.MicroUI;
import ej.wadapps.app.Activity;

/**
 * Hello activity
 */
public class TicTacToeActivity implements Activity {
	private TicTacToeDisplayable displayable;


	public TicTacToeActivity() {
		MicroUI.start();
	}

	@Override
	public void onStart() {
		displayable = new TicTacToeDisplayable();
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
		return "TicTacToe";
	}

}
