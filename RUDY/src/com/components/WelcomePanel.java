package com.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	String title = "Welcome to RUDY";
	String subTitle = "Up your fast calculated skills";

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawOperation(g);
		drawTitle(g);
		drawSubTitle(g);
		setBackground(new Color(188, 223, 255));
	}

	void drawRectangle(Graphics g, int x, int y, int w, int h, Color c) {
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}

	void drawAddition(Graphics g) {
		// |
		drawRectangle(g, 175, 204, 14, 46, new Color(218, 255, 239));
		// _
		drawRectangle(g, 159, 220, 46, 14, new Color(218, 255, 239));
	}

	void drawSubtraction(Graphics g) {
		drawRectangle(g, 136, 168, 46, 14, new Color(255, 254, 225));
	}

	void drawMultiplication(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		// Set rotation point to center of panel
		g2d.translate(189, 120);

		// Rotate by 45 degrees clockwise
		g2d.rotate(Math.toRadians(45));

		// Draw a red rectangle
		g2d.setColor(new Color(255, 237, 253));
		g2d.fillRect(-7, -23, 14, 46); // /
		g2d.setColor(new Color(255, 237, 253));
		g2d.fillRect(-23, -7, 46, 14); // \
	}

	void drawDivision(Graphics g) {
		drawRectangle(g, 243, 99, 46, 14, new Color(255, 245, 240));
		g.setColor(new Color(255, 245, 240));
		g.fillOval(259, 81, 14, 14);
		g.setColor(new Color(255, 245, 240));
		g.fillOval(259, 117, 14, 14);
	}

	public void drawOperation(Graphics g) {
		drawAddition(g);
		drawSubtraction(g);
		drawMultiplication(g);
		drawDivision(g);
	}

	public void drawTitle(Graphics g) {
		Font titleFont = new Font("Inter", Font.BOLD, 36);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(title, 241, 192);
	}

	public void drawSubTitle(Graphics g) {
		Font subTitleFont = new Font("Inter", Font.PLAIN, 16);
		g.setFont(subTitleFont);
		g.setColor(Color.black);
		g.drawString(subTitle, 292, 220);
	}

}
