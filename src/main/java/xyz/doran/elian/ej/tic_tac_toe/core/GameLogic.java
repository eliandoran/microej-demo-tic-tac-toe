/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package xyz.doran.elian.ej.tic_tac_toe.core;

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

		if (board.getWidth() != 3 || board.getHeight() != 3) {
			throw new UnsupportedOperationException("Board size can only be three");
		}

		reset();
	}

	public boolean mark(int cellX, int cellY) {
		if (hasEnded()) {
			reset();
			return false;
		}

		if (board.getAt(cellX, cellY) != null) {
			return false;
		}

		board.setAt(cellX, cellY, turn);

		winnerChecker.determineWinner();

		if (!hasEnded()) {
			nextTurn();
		}

		return true;
	}

	public boolean hasEnded() {
		if (winnerChecker.getWinner() != null) {
			return true;
		}

		if (winnerChecker.isTie() != null && winnerChecker.isTie()) {
			return true;
		}

		return false;
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
