/*
 * Java
 *
 * Copyright 2008-2017 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package com.microej.demo.hello;

import java.io.IOException;

import com.microej.demo.hello.core.CellState;
import com.microej.demo.hello.core.TicTacToeBoard;
import com.microej.demo.hello.drawing.BoardDrawing;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

/**
 * Displays MicroEJ image and a list of "Hello" messages.
 */
public class HelloDisplayable extends Displayable implements EventHandler{

	private Image microejImage;
	private final TicTacToeBoard board;
	private final BoardDrawing boardDrawing;

	public HelloDisplayable() {
		super(Display.getDefaultDisplay());

		board = new TicTacToeBoard();
		boardDrawing = new BoardDrawing(board);

		try {
			microejImage = Image.createImage("/com/microej/demo/hello/images/microej.png");
		}
		catch (IOException e) {
			throw new AssertionError(e);
		}
	}

	@Override
	public void paint(GraphicsContext g) {
		// clean
		g.setColor(Colors.WHITE);
		int width = getDisplay().getWidth();
		int height = getDisplay().getHeight();
		g.fillRect(0, 0, width, height);

		g.setColor(Colors.BLACK);

		board.setAt(0, 0, CellState.X);
		board.setAt(1, 1, CellState.O);
		board.setAt(2, 1, CellState.X);

		boardDrawing.setGraphicsContext(g);
		boardDrawing.setDisplay(getDisplay());
		boardDrawing.draw();

		// g.drawImage(microejImage, width / 2, y, GraphicsContext.HCENTER |
		// GraphicsContext.TOP);
	}

	@Override
	public EventHandler getController() {
		return this;
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER) {
			Pointer p = (Pointer) EventGenerator.get(Event.getGeneratorID(event));
			if (Pointer.isPressed(event)) {
				/*
				 * int height = homeImage.getHeight(); if (isIncluded(p,
				 * HOME_PADDING, Display.getDefaultDisplay().getHeight() -
				 * height - HOME_PADDING, homeImage.getWidth(), height)) { //
				 * here, the user has pressed on the image System.out.println(
				 * "=> EXIT REQUEST"); ActivitiesScheduler scheduler =
				 * ServiceLoaderFactory.getServiceLoader()
				 * .getService(ActivitiesScheduler.class); if (scheduler !=
				 * null) { // An activity scheduler is registered in the system
				 * // Trigger a come back to the registered launcher
				 * System.out.println("=> SHOW LAUNCHER");
				 * scheduler.showLauncher(); } return true; }
				 */
			}
		}
		return false;
	}

	private static boolean isIncluded(Pointer p, int startX, int startY, int width, int height) {
		int x = p.getX();
		int y = p.getY();
		return (x >= startX && x < width + startX) && (y >= startY && y < height + startY);
	}

}
