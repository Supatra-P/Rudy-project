package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.components.CleanButton;
import com.components.WelcomePanel;

public class WelcomePage extends BgWindow {

	private CleanButton btnStart;

	public WelcomePage() {
		super("RUDY");
		setLayout(new BorderLayout());

		btnStart = new CleanButton("START", Color.black, Color.white);
		btnStart.setPreferredSize(new Dimension(200, 62));
		btnStart.setBorder(BorderFactory.createEmptyBorder(16, 0, 17, 0));
		btnStart.addActionListener(new ToEnterNamePage());

		JPanel areas = new JPanel(new FlowLayout());
		areas.setBackground(new Color(188, 223, 255));
		areas.setBorder(BorderFactory.createEmptyBorder(71, 0, 160, 0));
		areas.add(btnStart);

		add(areas, BorderLayout.SOUTH);
		add(new WelcomePanel());

		paintCloud();
		setVisible(true);
	}

	class ToEnterNamePage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new EnterNamePage().setVisible(true);
			setVisible(false);


		}

	}

}
