package com.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CleanButton extends JButton {

	public CleanButton(String name, Color bgColor, Color txtColor) {
		super(name);
		setForeground(txtColor);
		setBackground(bgColor);
		setBorder(BorderFactory.createEmptyBorder(16, 60, 17, 60));
		setFont(new Font("Inter", Font.BOLD, 24));
		setOpaque(true);
	}

}
