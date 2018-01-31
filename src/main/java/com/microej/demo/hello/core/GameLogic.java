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
public class GameLogic {
	CellState turn;
	TicTacToeBoard board;
	WinnerChecker winnerChecker;

	public GameLogic(TicTacToeBoard board) {
		this.board = board;
		this.turn = CellState.X;
		this.winnerChecker = new WinnerChecker(board);
	}

	public boolean mark(int cellX, int cellY) {
		if (board.getAt(cellX, cellY) != null) {
			return false;
		}

		board.setAt(cellX, cellY, turn);

		checkWinner();

		return true;
	}

	public void checkWinner() {
		if (board.getWidth() != 3 || board.getHeight() != 3) {
			throw new UnsupportedOperationException("Board size can only be three");
		}

		if (winnerChecker.determineWinner()) {
			System.out.println(winnerChecker.getWinner());
		}
	}

	public WinnerChecker getWinnerChecker() {
		return winnerChecker;
	}
}
