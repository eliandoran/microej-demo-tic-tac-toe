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
		int totalWidth = board.getWidth() * BOX_SIZE;
		int totalHeight = board.getHeight() * BOX_SIZE;
		int startX = (display.getWidth() - totalWidth) / 2;
		int startY = (display.getHeight() - totalHeight) / 2;

		for (int cellX = 0; cellX < board.getWidth(); cellX++) {
			for (int cellY = 0; cellY < board.getHeight(); cellY++) {
				int x = startX + (cellX * BOX_SIZE);
				int y = startY + (cellY * BOX_SIZE);

				CellState state = board.getAt(cellX, cellY);
				drawCell(state, x, y);
			}
		}
	}

	private void drawCell(CellState state, int x, int y) {
		graphicsContext.setColor(boardColor);
		graphicsContext.drawRect(x, y, BOX_SIZE, BOX_SIZE);

		int padding = 5;

		if (state != CellState.Empty) {
			graphicsContext.setColor(cellStateColors.get(state));
		}

		switch (state) {
		case X:
			int startX = x + padding;
			int startY = y + padding;
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
}
