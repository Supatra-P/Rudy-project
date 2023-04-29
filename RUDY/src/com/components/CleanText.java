package com.components;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class CleanText extends JLabel {

	private GridBagConstraints padding;

	public CleanText(String title, Font font) {
		super(title);
		setFont(font);
		padding = new GridBagConstraints();
	}

	/*
	 * use the GridBagLayout manager to position the JButton in the center of the
	 * container
	 */
	// specify the position
	public void setPadding(int top, int left, int bottom, int right, int x, int y) {
		// set the grid x and grid y to 0 to position the button in the top-left corner
		// of the container
		padding.gridx = x;
		padding.gridy = y;
		// set the insets property to specify the margins around the button
		padding.insets = new Insets(top, left, bottom, right);
	}

	public GridBagConstraints getPadding() {
		return padding;
	}

}
