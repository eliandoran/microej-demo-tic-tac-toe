/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello.core;

/**
 *
 */
public class WinnerChecker {
	private final TicTacToeBoard board;

	public WinnerChecker(TicTacToeBoard board) {
		this.board = board;
	}

	public boolean determineWinner() {
		lineScan();

		return false;
	}

	private void lineScan() {
		for (int i = 0; i < board.getWidth(); i++) {
			scan(0, i, 1, 0);
			scan(i, 0, 0, 1);
		}

		scan(0, 0, 1, 1);
		scan(board.getWidth() - 1, 0, -1, 1);
	}

	private void scan(int x, int y, int xGain, int yGain) {
		CellState previousState = null;

		while (x < board.getWidth() && y < board.getHeight()) {
			CellState currentState = board.getAt(x, y);

			if (currentState == null) {
				return;
			}

			if (previousState != null) {
				if (currentState != previousState) {
					return;
				}
			} else {
				previousState = currentState;
			}

			x += xGain;
			y += yGain;
		}

		System.out.println(previousState);
	}
}
