package com.components;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud {

	void drawCircle(Graphics g, int x, int y, int w, int h, Color c) {
		g.setColor(c);
		g.fillOval(x, y, w, h);
	}

	public void drawCloud(Graphics g) {
		int coordx[] = { -51, 430, 579 };
		int coordy[] = { 509, 458, 307 };
		for (int i = 0; i < coordx.length; i++) {
			drawCircle(g, coordx[i], coordy[i], 374, 355, Color.white);
		}
	}

}
