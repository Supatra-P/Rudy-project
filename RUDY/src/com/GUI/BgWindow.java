package com.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import com.components.Cloud;
import com.components.WelcomePanel;

public class BgWindow extends JFrame {

	private Cloud bgCloud;

	public BgWindow(String title) {
		super(title);
		getContentPane().setBackground(new Color(188, 223, 255));
		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
	}

	public Cloud paintCloud() {
		bgCloud = new Cloud();
		return bgCloud;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (bgCloud != null)
			bgCloud.drawCloud(g);
	}

}
