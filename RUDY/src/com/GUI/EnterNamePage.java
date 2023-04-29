package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import com.components.CleanButton;
import com.components.CleanText;

public class EnterNamePage extends BgWindow {

	private CleanButton btnEnter;
	private JTextField playerName;

	public EnterNamePage() {
		super("RUDY: Enter name");

		// create title
		CleanText title = new CleanText("Your name", new Font("Inter", Font.BOLD, 36));
		title.setPadding(0, 0, 0, 0, 0, 0);
		add(title, title.getPadding());

		// create input
		playerName = new JTextField("Enter your name . . .");
		playerName.setFont(new Font("Inter", Font.PLAIN, 24));
		playerName.setBorder(BorderFactory.createEmptyBorder(17, 30, 16, 30));
		playerName.setPreferredSize(new Dimension(440, 62));

		GridBagConstraints playerNamePadding = new GridBagConstraints();
		playerNamePadding.gridx = 0;
		playerNamePadding.gridy = 1;
		playerNamePadding.insets = new Insets(56, 0, 56, 0);
		add(playerName, playerNamePadding);

		// create button
		btnEnter = new CleanButton("ENTER", Color.black, Color.white);

		GridBagConstraints btnEnterPadding = new GridBagConstraints();
		btnEnterPadding.gridx = 0;
		btnEnterPadding.gridy = 2;
		btnEnterPadding.insets = new Insets(0, 0, 0, 0); // top left bottom right
		add(btnEnter, btnEnterPadding);

		btnEnter.addActionListener(new ClickToSelectModePage());
		playerName.addKeyListener(new EnterToSelectModePage());

		paintCloud();
		setVisible(true);
	}

	class ClickToSelectModePage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new SelectModePage().setVisible(true);
			setVisible(false);

			String name = playerName.getText();
			ShowResultPage.setPlayerName(name);
		}

	}

	class EnterToSelectModePage implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				new SelectModePage().setVisible(true);
				setVisible(false);

				String name = playerName.getText();
				ShowResultPage.setPlayerName(name);
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

}
