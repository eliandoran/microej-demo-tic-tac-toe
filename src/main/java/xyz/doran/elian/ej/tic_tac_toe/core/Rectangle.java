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
public class Rectangle {
	private final int x, y, width, height;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getEndX() {
		return x + width;
	}

	public int getEndY() {
		return y + height;
	}

	public int getCenterX() {
		return x + (width / 2);
	}

	public int getCenterY() {
		return y + (height / 2);
	}

	public Rectangle offsetBy(int offsetX, int offsetY) {
		return new Rectangle(x + offsetX, y + offsetY, width, height);
	}

	public Rectangle offsetBy(Rectangle sourceRect) {
		return new Rectangle(x + sourceRect.x, y + sourceRect.y, width, height);
	}

	public boolean isInside(int pointX, int pointY) {
		return ((pointX >= getX() && pointX <= getEndX()) &&
				(pointY >= getY() && pointY <= getEndY()));
	}

	public boolean isInside(Point point) {
		return isInside(point.getX(), point.getY());
	}
}
