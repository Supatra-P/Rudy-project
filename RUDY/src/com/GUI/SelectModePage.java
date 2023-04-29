package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.components.CleanButton;
import com.components.CleanText;

public class SelectModePage extends BgWindow {

	private CleanButton btnEnter;
	private JRadioButton selectEasy, selectHard;

	private static String selectedMode;
	private static ArrayList<String> allTimeStamps = new ArrayList<String>();
	private static ArrayList<String> allSolutions = new ArrayList<String>();
	private static ArrayList<String> allResults = new ArrayList<String>();

	public SelectModePage() {
		super("RUDY: Select mode");

		// create title
		CleanText title = new CleanText("Please select mode", new Font("Inter", Font.BOLD, 36));

		// create select group
		JPanel groupSelect = new JPanel(new GridLayout(4, 0, 0, 24));
		groupSelect.setBackground(new Color(188, 223, 255));

		// create select mode
		selectEasy = new JRadioButton("   Easy");
		selectEasy.setFont(new Font("Inter", Font.BOLD, 24));
		selectEasy.setOpaque(true);
		selectEasy.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		selectEasy.setBackground(new Color(218, 255, 239));
		selectEasy.setPreferredSize(new Dimension(341, 62));

		selectHard = new JRadioButton("   Hard");
		selectHard.setFont(new Font("Inter", Font.BOLD, 24));
		selectHard.setOpaque(true);
		selectHard.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		selectHard.setBackground(new Color(255, 237, 253));
		selectHard.setPreferredSize(new Dimension(341, 62));

		ButtonGroup bg = new ButtonGroup();
		bg.add(selectEasy);
		bg.add(selectHard);

		// create button
		JPanel areas = new JPanel(new FlowLayout());
		areas.setBackground(new Color(188, 223, 255));
		btnEnter = new CleanButton("ENTER", Color.black, Color.white);
		areas.add(btnEnter);
		
		groupSelect.add(title);
		groupSelect.add(selectEasy);
		groupSelect.add(selectHard);
		groupSelect.add(areas);
		add(groupSelect);

		selectEasy.addItemListener(new SelectMode());
		selectHard.addItemListener(new SelectMode());
		btnEnter.addActionListener(new ToBothModePage());
		selectEasy.addKeyListener(new ToBothModePage());
		selectHard.addKeyListener(new ToBothModePage());

		paintCloud();
		setVisible(true);
	}

	class SelectMode implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getSource() == selectEasy) {
					System.out.println("select easy");
					selectedMode = "Easy mode";
				}
				if (e.getSource() == selectHard) {

					System.out.println("select hard");
					selectedMode = "Hard mode";
				}
			}

		}

	}

	class ToBothModePage implements ActionListener, KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				BothModePage.setMode(selectedMode);
				
				new BothModePage().setVisible(true);
				setVisible(false);
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			BothModePage.setMode(selectedMode);
			
			new BothModePage().setVisible(true);
			setVisible(false);
		}

	}

	public static void collectAllResults(String times, String solutions, String results) {
		allTimeStamps.add(times);
		allSolutions.add(solutions);
		allResults.add(results);
		System.out.println("all time: " + allTimeStamps);
		System.out.println("all soln: " + allSolutions);
		System.out.println("all result:" + allResults);
	}

	public static ArrayList<String> getAllTimes() {
		return allTimeStamps;
	}

	public static ArrayList<String> getAllSolutions() {
		return allSolutions;
	}

	public static ArrayList<String> getAllResults() {
		return allResults;
	}

	public static void setAllTimeStamps(ArrayList<String> allTimeStamp) {
		allTimeStamps = allTimeStamp;
	}

	public static void setAllSolutions(ArrayList<String> allSolution) {
		allSolutions = allSolution;
	}

	public static void setAllResults(ArrayList<String> allResult) {
		allResults = allResult;
	}

}
