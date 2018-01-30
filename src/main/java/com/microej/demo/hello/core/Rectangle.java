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

	public Rectangle offsetBy(int offsetX, int offsetY) {
		return new Rectangle(x + offsetX, y + offsetY, width, height);
	}

	public Rectangle offsetBy(Rectangle sourceRect) {
		return new Rectangle(x + sourceRect.x, y + sourceRect.y, width, height);
	}
}
