/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello;

import java.util.HashMap;
import java.util.Map;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.GraphicsContext;

/**
 *
 */
public class BoardDrawing {
	private final TicTacToeBoard board;
	private GraphicsContext graphicsContext;
	private Display display;
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

	public void setGraphicsContext(GraphicsContext g) {
		this.graphicsContext = g;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void draw() {
		Rectangle boardRect = getBoardRect();

		for (int cellX = 0; cellX < board.getWidth(); cellX++) {
			for (int cellY = 0; cellY < board.getHeight(); cellY++) {
				int x = boardRect.getX() + (cellX * BOX_SIZE);
				int y = boardRect.getY() + (cellY * BOX_SIZE);

				CellState state = board.getAt(cellX, cellY);
				drawCell(state, this.getCellRect(cellX, cellY));
			}
		}
	}

	private void drawCell(CellState state, Rectangle cellRect) {
		int x = cellRect.getX();
		int y = cellRect.getY();

		graphicsContext.setColor(boardColor);
		graphicsContext.drawRect(cellRect.getX(), cellRect.getY(), cellRect.getWidth(), cellRect.getHeight());

		int padding = 5;

		if (state != CellState.Empty) {
			graphicsContext.setColor(cellStateColors.get(state));
		}

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

		default:
			break;
		}
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
}
