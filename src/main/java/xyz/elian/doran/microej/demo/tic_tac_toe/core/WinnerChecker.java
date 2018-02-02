/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package xyz.elian.doran.microej.demo.tic_tac_toe.core;

/**
 *
 */
public class WinnerChecker {
	private final TicTacToeBoard board;
	private CellState winner;
	private Point startingPoint;
	private Point endingPoint;
	private Boolean isTie;

	public WinnerChecker(TicTacToeBoard board) {
		this.board = board;
	}

	public boolean determineWinner() {
		winner = null;
		startingPoint = endingPoint = null;
		isTie = null;

		lineScan();
		return (winner != null);
	}

	public CellState getWinner() {
		return this.winner;
	}

	public Boolean isTie() {
		return isTie;
	}

	public Point getStartingPoint() {
		return this.startingPoint;
	}

	public Point getEndingPoint() {
		return this.endingPoint;
	}

	private void lineScan() {
		for (int i = 0; i < board.getWidth(); i++) {
			scan(0, i, 1, 0);
			scan(i, 0, 0, 1);
		}

		scan(0, 0, 1, 1);
		scan(board.getWidth() - 1, 0, -1, 1);

		if (board.isFull() && getWinner() == null) {
			isTie = true;
		}
	}

	private void scan(int x, int y, int xGain, int yGain) {
		Point startingPoint = new Point(x, y);
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

		this.startingPoint = startingPoint;
		this.endingPoint = new Point(x - xGain, y - yGain);
		this.winner = previousState;
	}
}
