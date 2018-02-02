/*
 * Java
 *
 * Copyright 2008-2017 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package xyz.elian.doran.microej.demo.tic_tac_toe;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;
import xyz.elian.doran.microej.demo.tic_tac_toe.core.GameLogic;
import xyz.elian.doran.microej.demo.tic_tac_toe.core.Point;
import xyz.elian.doran.microej.demo.tic_tac_toe.core.TicTacToeBoard;
import xyz.elian.doran.microej.demo.tic_tac_toe.drawing.BoardDrawing;
import xyz.elian.doran.microej.demo.tic_tac_toe.drawing.WinningStrikeDrawing;

/**
 * Displays MicroEJ image and a list of "Hello" messages.
 */
public class HelloDisplayable extends Displayable implements EventHandler {
	private final TicTacToeBoard board;
	private final GameLogic logic;
	private final BoardDrawing boardDrawing;
	private final WinningStrikeDrawing strikeDrawing;

	public HelloDisplayable() {
		super(Display.getDefaultDisplay());

		board = new TicTacToeBoard();
		logic = new GameLogic(board);
		boardDrawing = new BoardDrawing(board);
		strikeDrawing = new WinningStrikeDrawing(boardDrawing, logic.getWinnerChecker());
	}

	@Override
	public void paint(GraphicsContext g) {
		g.setColor(Colors.WHITE);
		int width = getDisplay().getWidth();
		int height = getDisplay().getHeight();
		g.fillRect(0, 0, width, height);

		g.setColor(Colors.BLACK);

		boardDrawing.setGraphicsContext(g);
		boardDrawing.setDisplay(getDisplay());
		boardDrawing.draw();

		strikeDrawing.setGraphicsContext(g);
		strikeDrawing.setDisplay(getDisplay());
		strikeDrawing.draw();
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
				Integer pointerX = p.getX();
				Integer pointerY = p.getY();

				if (boardDrawing.getBoardRect().isInside(pointerX, pointerY)) {
					Point cellPos = boardDrawing.getCellPosAt(pointerX, pointerY);
					Integer cellX = cellPos.getX();
					Integer cellY = cellPos.getY();

					logic.mark(cellX, cellY);
					repaint();
				}
			}
		}
		return false;
	}
}
