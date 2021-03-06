/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package xyz.doran.elian.ej.tic_tac_toe.core;

public class TicTacToeBoard {
	private CellState[][] board;
	private final int boardWidth, boardHeight;

	public TicTacToeBoard() {
		this.boardWidth = this.boardHeight = 3;
		empty();
	}

	public int getWidth() {
		return this.boardWidth;
	}

	public int getHeight() {
		return this.boardHeight;
	}

	public CellState getAt(int x, int y) {
		validateCoordinates(x, y);
		return board[y][x];
	}

	public void setAt(int x, int y, CellState newState) {
		validateCoordinates(x, y);
		board[y][x] = newState;
	}

	public void empty() {
		this.board = new CellState[this.boardHeight][this.boardWidth];
	}

	public boolean isFull() {
		for (int x = 0; x < this.boardWidth; x++) {
			for (int y = 0; y < this.boardHeight; y++) {
				if (board[y][x] == null) {
					return false;
				}
			}
		}
		return true;
	}

	private void validateCoordinates(int x, int y) {
		if (x < 0 || x >= this.boardWidth) {
			throw new IllegalArgumentException("x should be between 0 and getWidth()-1");
		}

		if (y < 0 || y >= this.boardHeight) {
			throw new IllegalArgumentException("y should be between 0 and getHeight()-1");
		}
	}
}
