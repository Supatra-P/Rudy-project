package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.components.CleanButton;
import com.components.CleanText;

public class ShowResultPage extends BgWindow {

	private CleanButton btnTryAgain;
	private static String playerName;
	private static ArrayList<String> timeStamps, solutions, randomResults;

	public ShowResultPage() {
		super("RUDY: Well Done ! | Show Result");

		// title
		String text = "Well Done, " + playerName + " !";
		CleanText title = new CleanText(text, new Font("Inter", Font.BOLD, 36));
		title.setPadding(0, 0, 0, 0, 0, 0);
		add(title, title.getPadding());

		// Rank
		JPanel all = new JPanel(new GridLayout(randomResults.size() + 1, 2, 12, 12));
		all.setBackground(new Color(188, 223, 255));

		// 1st
		CleanButton topSol = new CleanButton(
				solutions.get(getFastestResultIndex()) + " = " + randomResults.get(getFastestResultIndex()),
				Color.black, new Color(80, 139, 255));
		CleanButton topTime = new CleanButton(timeStamps.get(getFastestResultIndex()), Color.black,
				new Color(80, 139, 255));
		topSol.setBorder(BorderFactory.createEmptyBorder(16, 10, 17, 10));
		topTime.setBorder(BorderFactory.createEmptyBorder(16, 10, 17, 10));
		all.add(topSol);
		all.add(topTime);
		// other
		for (int i = 0; i < randomResults.size(); i++) {
			CleanButton sol = new CleanButton(solutions.get(i) + " = " + randomResults.get(i), Color.white,
					Color.black);
			CleanButton time = new CleanButton(timeStamps.get(i), Color.white, Color.black);
			sol.setFont(new Font("Inter", Font.BOLD, 20));
			time.setFont(new Font("Inter", Font.BOLD, 20));
			sol.setBorder(BorderFactory.createEmptyBorder(16, 10, 17, 10));
			time.setBorder(BorderFactory.createEmptyBorder(16, 10, 17, 10));
			all.add(sol);
			all.add(time);
		}

		GridBagConstraints allPadding = new GridBagConstraints();
		allPadding.gridx = 0;
		allPadding.gridy = 1;
		allPadding.insets = new Insets(30, 0, 0, 0);

		JScrollPane scrollAll = new JScrollPane(all);
		scrollAll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollAll.setMinimumSize(new Dimension(650, 374));
		add(scrollAll, allPadding);

		// button
		btnTryAgain = new CleanButton("TRY AGAIN", Color.black, Color.white);
		GridBagConstraints tryPadding = new GridBagConstraints();
		tryPadding.gridx = 0;
		tryPadding.gridy = 2;
		tryPadding.insets = new Insets(10, 0, 0, 0);
		add(btnTryAgain, tryPadding);

		btnTryAgain.addActionListener(new ToWelcomePage());

		setVisible(true);
	}

	class ToWelcomePage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			SelectModePage.setAllTimeStamps(new ArrayList<String>());
			SelectModePage.setAllSolutions(new ArrayList<String>());
			SelectModePage.setAllResults(new ArrayList<String>());

			new WelcomePage().setVisible(true);
			setVisible(false);

			System.out.println("try again");
		}

	}

	public static void setPlayerName(String name) {
		System.out.println("enter name : " + name);
		playerName = name;
	}

	public static void setAllPlayed(ArrayList<String> timeStamp, ArrayList<String> solution,
			ArrayList<String> randomResult) {
		timeStamps = timeStamp;
		solutions = solution;
		randomResults = randomResult;
	}

	public ArrayList<Integer> getTotalMilliSeconds() {
		ArrayList<Integer> allMilliSeconds = new ArrayList<Integer>();

		for (String time : timeStamps) {

			String[] timeList = time.split(":", 3);

			int milliSeconds = 0;
			int partHours = Integer.parseInt(timeList[0]) * 3600000;
			int partMinutes = Integer.parseInt(timeList[1]) * 60000;
			int partSeconds = Integer.parseInt(timeList[2]) * 1000;

			milliSeconds = partHours + partMinutes + partSeconds;

			allMilliSeconds.add(milliSeconds);

		}
		System.out.println(allMilliSeconds);

		return allMilliSeconds;
	}

	public int getFastestResultIndex() {
		ArrayList<Integer> allResultTimes = getTotalMilliSeconds();

		int fastestResult = Integer.MAX_VALUE;
		for (int i = 0; i < allResultTimes.size(); i++) {
			fastestResult = Math.min(fastestResult, allResultTimes.get(i));
		}
		System.out.println("index " + allResultTimes.indexOf(fastestResult) + ": " + fastestResult);

		return allResultTimes.indexOf(fastestResult);
	}

}
