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
		this.winnerChecker = new WinnerChecker(board);

		reset();
	}

	public boolean mark(int cellX, int cellY) {
		if (this.winnerChecker.getWinner() != null) {
			reset();
			return false;
		}

		if (board.getAt(cellX, cellY) != null) {
			return false;
		}

		board.setAt(cellX, cellY, turn);

		if (!checkWinner()) {
			nextTurn();
		}

		return true;
	}

	public boolean checkWinner() {
		if (board.getWidth() != 3 || board.getHeight() != 3) {
			throw new UnsupportedOperationException("Board size can only be three");
		}

		return winnerChecker.determineWinner();
	}

	public WinnerChecker getWinnerChecker() {
		return winnerChecker;
	}

	private void reset() {
		turn = CellState.X;
		board.empty();
		winnerChecker.determineWinner();
	}

	private void nextTurn() {
		switch (turn) {
		case X:
			turn = CellState.O;
			break;

		case O:
			turn = CellState.X;
			break;
		}
	}
}
