/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello.drawing;

import java.util.HashMap;
import java.util.Map;

import com.microej.demo.hello.core.CellState;
import com.microej.demo.hello.core.Point;
import com.microej.demo.hello.core.Rectangle;
import com.microej.demo.hello.core.TicTacToeBoard;

import ej.microui.display.Colors;

/**
 *
 */
public class BoardDrawing extends Drawing {
	private final TicTacToeBoard board;

	private final int BOX_SIZE = 70;

	private final Integer boardColor;

	private final Map<CellState, Integer> cellStateColors;

	public BoardDrawing(TicTacToeBoard board) {
		this.board = board;

		this.boardColor = Colors.BLACK;
		this.cellStateColors = new HashMap<>();
		this.cellStateColors.put(CellState.X, Colors.BLUE);
		this.cellStateColors.put(CellState.O, Colors.RED);
	}

	@Override
	public void draw() {
		for (int cellX = 0; cellX < board.getWidth(); cellX++) {
			for (int cellY = 0; cellY < board.getHeight(); cellY++) {
				CellState state = board.getAt(cellX, cellY);
				drawCell(state, this.getCellRect(cellX, cellY));
			}
		}
	}

	private void drawCell(CellState state, Rectangle cellRect) {
		int x = cellRect.getX();
		int y = cellRect.getY();

		graphicsContext.setColor(boardColor);
		graphicsContext.drawRect(cellRect.getX() - 1, cellRect.getY() - 1, cellRect.getWidth() + 1,
				cellRect.getHeight() + 1);

		int padding = 5;

		if (state == null) {
			return;
		}

		graphicsContext.setColor(cellStateColors.get(state));

		switch (state) {
		case X:
			int startX = cellRect.getX() + padding;
			int startY = cellRect.getY() + padding;
			int endX = startX + BOX_SIZE - (padding * 2);
			int endY = startY + BOX_SIZE - (padding * 2);

			graphicsContext.drawLine(startX, startY, endX, endY);
			graphicsContext.drawLine(endX, startY, startX, endY);
			break;

		case O:
			graphicsContext.drawCircle(x + padding, y + padding, BOX_SIZE - (padding * 2));
			break;
		}
	}

	public TicTacToeBoard getBoard() {
		return board;
	}

	public Rectangle getBoardRect() {
		int totalWidth = board.getWidth() * BOX_SIZE;
		int totalHeight = board.getHeight() * BOX_SIZE;
		int startX = (display.getWidth() - totalWidth) / 2;
		int startY = (display.getHeight() - totalHeight) / 2;

		return new Rectangle(startX, startY, totalWidth, totalHeight);
	}

	public Rectangle getCellRect(int x, int y) {
		int startX = x;
		int startY = y;
		int width = BOX_SIZE;
		int height = BOX_SIZE;

		Rectangle result = new Rectangle(startX, startY, width, height);
		result = result.offsetBy(getBoardRect());
		result = result.offsetBy(BOX_SIZE * x, BOX_SIZE * y);
		return result;
	}

	public Point getCellPosAt(int screenX, int screenY) {
		for (int cellX = 0; cellX < board.getWidth(); cellX++) {
			for (int cellY = 0; cellY < board.getHeight(); cellY++) {
				if (getCellRect(cellX, cellY).isInside(screenX, screenY)) {
					return new Point(cellX, cellY);
				}
			}
		}

		return null;
	}
}
