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
	boolean ended;

	public GameLogic(TicTacToeBoard board) {
		this.board = board;
		this.turn = CellState.X;
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

		// Check for vertical winnings.
		verticalWinnerCheck();
	}

	public void verticalWinnerCheck() {
		boolean xWon, oWon;

		for (int cellX = 0; cellX < board.getWidth(); cellX++) {
			xWon = true;
			oWon = true;

			for (int cellY = 0; cellY < board.getHeight(); cellY++) {
				CellState state = board.getAt(cellX, cellY);

				if (state == null) {
					xWon = oWon = false;
				}
				if (state != CellState.X) {
					xWon = false;
				} else if (state != CellState.O) {
					oWon = false;
				}
			}

			if (xWon || oWon) {
				if (xWon) {
					System.out.println("X won");
				}

				return;
			}
		}
	}
}
