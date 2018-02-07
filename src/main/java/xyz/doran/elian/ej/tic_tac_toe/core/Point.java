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
public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static boolean haveSameX(Point a, Point b) {
		return (a.x == b.x);
	}

	public static boolean haveSameY(Point a, Point b) {
		return (a.y == b.y);
	}
}
