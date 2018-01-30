/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.demo.hello.drawing;

import ej.microui.display.Display;
import ej.microui.display.GraphicsContext;

/**
 *
 */
public abstract class Drawing {
	protected GraphicsContext graphicsContext;
	protected Display display;

	public void setGraphicsContext(GraphicsContext g) {
		this.graphicsContext = g;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public abstract void draw();
}
