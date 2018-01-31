/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello.drawing;

import com.microej.demo.hello.core.Point;
import com.microej.demo.hello.core.Rectangle;
import com.microej.demo.hello.core.WinnerChecker;

import ej.microui.display.Colors;

/**
 *
 */
public class WinningStrikeDrawing extends Drawing {
	private final BoardDrawing boardDrawing;
	private final WinnerChecker winnerChecker;
	private final int color;

	public WinningStrikeDrawing(BoardDrawing boardDrawing, WinnerChecker winnerChecker) {
		this.boardDrawing = boardDrawing;
		this.winnerChecker = winnerChecker;
		this.color = Colors.RED;
	}

	@Override
	public void draw() {
		if (winnerChecker.getWinner() == null) {
			return;
		}

		graphicsContext.setColor(color);

		Point startingPoint = winnerChecker.getStartingPoint();
		Point endingPoint = winnerChecker.getEndingPoint();

		if (Point.haveSameX(startingPoint, endingPoint) && !Point.haveSameY(startingPoint, endingPoint)) {
			drawVerticalStrike(startingPoint.getX());
		} else if (!Point.haveSameX(startingPoint, endingPoint) && Point.haveSameY(startingPoint, endingPoint)) {
			drawHorizontalStrike(startingPoint.getY());
		} else {
			boolean reverse = (startingPoint.getX() != 0);
			drawDiagonalStrike(reverse);
		}
	}

	private void drawVerticalStrike(int x) {
		Rectangle firstCell = boardDrawing.getCellRect(x, 0);
		Rectangle lastCell = boardDrawing.getCellRect(x, boardDrawing.getBoard().getHeight() - 1);

		graphicsContext.drawLine(firstCell.getCenterX(), firstCell.getY(), lastCell.getCenterX(), lastCell.getEndY());
	}

	private void drawHorizontalStrike(int y) {
		Rectangle firstCell = boardDrawing.getCellRect(0, y);
		Rectangle lastCell = boardDrawing.getCellRect(boardDrawing.getBoard().getWidth() - 1, y);

		graphicsContext.drawLine(firstCell.getX(), firstCell.getCenterY(), lastCell.getEndX(), lastCell.getCenterY());
	}

	private void drawDiagonalStrike(boolean reverse) {
		Rectangle firstCell, lastCell;

		if (!reverse) {
			firstCell = boardDrawing.getCellRect(0, 0);
			lastCell = boardDrawing.getCellRect(boardDrawing.getBoard().getWidth() - 1,
					boardDrawing.getBoard().getHeight() - 1);

			graphicsContext.drawLine(firstCell.getX(), firstCell.getY(), lastCell.getEndX(), lastCell.getEndY());
		} else {
			firstCell = boardDrawing.getCellRect(boardDrawing.getBoard().getWidth() - 1, 0);
			lastCell = boardDrawing.getCellRect(0, boardDrawing.getBoard().getHeight() - 1);

			graphicsContext.drawLine(firstCell.getEndX(), firstCell.getY(), lastCell.getX(), lastCell.getEndY());
		}
	}
}
