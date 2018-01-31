/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello.drawing;

import com.microej.demo.hello.core.Point;
import com.microej.demo.hello.core.TicTacToeBoard;
import com.microej.demo.hello.core.WinnerChecker;

/**
 *
 */
public class WinningStrikeDrawing extends Drawing {
	private final TicTacToeBoard board;
	private final WinnerChecker winnerChecker;

	public WinningStrikeDrawing(TicTacToeBoard board, WinnerChecker winnerChecker) {
		this.board = board;
		this.winnerChecker = winnerChecker;
	}

	@Override
	public void draw() {
		if (winnerChecker.getWinner() == null) {
			return;
		}

		Point startingPoint = winnerChecker.getStartingPoint();
		Point endingPoint = winnerChecker.getEndingPoint();

		if (Point.haveSameX(startingPoint, endingPoint) && !Point.haveSameY(startingPoint, endingPoint)) {
			System.out.println("Vertical strike.");
		} else if (!Point.haveSameX(startingPoint, endingPoint) && Point.haveSameY(startingPoint, endingPoint)) {
			System.out.println("Horizontal strike.");
		} else {
			System.out.println("Diagonal strike.");
		}
	}
}
