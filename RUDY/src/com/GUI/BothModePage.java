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
import javax.swing.JTextField;
import javax.swing.Timer;

import com.components.CleanButton;
import com.components.CleanText;

public class BothModePage extends BgWindow implements ActionListener {

	private static String mode = getMode();
	private CleanButton btnBack, btnSaveAndNew, btnExit;

	private String timeStamp;
	CleanText stopWatch = new CleanText(timeStamp, new Font("Inter", Font.BOLD, 24));
	Timer timer = new Timer(1000, this);
	int time = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	String partSeconds = String.format("%02d", seconds);
	String partMinutes = String.format("%02d", minutes);
	String partHours = String.format("%02d", hours);

	private JTextField inputSolution;

	private String result = getRandomResult();
	CleanButton resultCard = new CleanButton(result, new Color(218, 255, 239), Color.black);

	private ArrayList<String> randomNumberCards = getRandomNumber();
	CleanButton cardNumber1 = new CleanButton(randomNumberCards.get(0), new Color(255, 254, 225), Color.black);
	CleanButton cardNumber2 = new CleanButton(randomNumberCards.get(1), new Color(255, 254, 225), Color.black);
	CleanButton cardNumber3 = new CleanButton(randomNumberCards.get(2), new Color(255, 254, 225), Color.black);
	CleanButton cardNumber4 = new CleanButton(randomNumberCards.get(3), new Color(255, 254, 225), Color.black);
	CleanButton cardNumber5 = new CleanButton(randomNumberCards.get(4), new Color(255, 254, 225), Color.black);

	public BothModePage() {
		super("RUDY: Select mode | " + mode);

		// mode and stop watch
		JPanel bar = new JPanel(new GridLayout(1, 2, 495, 0));
		bar.setBackground(new Color(188, 223, 255));

		CleanText currentMode = new CleanText("Mode: " + mode.substring(0, 4), new Font("Inter", Font.BOLD, 24));
		currentMode.setForeground(new Color(80, 139, 255));

		timeStamp = partHours + ":" + partMinutes + ":" + partSeconds;
		stopWatch.setText(timeStamp);
		stopWatch.setForeground(new Color(80, 139, 255));

		bar.add(currentMode);
		bar.add(stopWatch);
		add(bar);

		// group of random number
		JPanel randNumberGroup = new JPanel(new GridLayout(2, 1, 0, 12));
		randNumberGroup.setBackground(new Color(188, 223, 255));

		// random set of number
		JPanel setOfNumber = new JPanel(new GridLayout(1, 5, 12, 0));
		setOfNumber.setBackground(new Color(188, 223, 255));

		cardNumber1.setFont(new Font("Inter", Font.BOLD, 40));
		cardNumber1.setPreferredSize(new Dimension(101, 100));
		cardNumber1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOfNumber.add(cardNumber1);

		cardNumber2.setFont(new Font("Inter", Font.BOLD, 40));
		cardNumber2.setPreferredSize(new Dimension(101, 100));
		cardNumber2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOfNumber.add(cardNumber2);

		cardNumber3.setFont(new Font("Inter", Font.BOLD, 40));
		cardNumber3.setPreferredSize(new Dimension(101, 100));
		cardNumber3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOfNumber.add(cardNumber3);

		cardNumber4.setFont(new Font("Inter", Font.BOLD, 40));
		cardNumber4.setPreferredSize(new Dimension(101, 100));
		cardNumber4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOfNumber.add(cardNumber4);

		if (mode == "Hard mode") {
			cardNumber5.setFont(new Font("Inter", Font.BOLD, 40));
			cardNumber5.setPreferredSize(new Dimension(101, 100));
			cardNumber5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			setOfNumber.add(cardNumber5);
		}
		randNumberGroup.add(setOfNumber);

		// random result
		resultCard.setFont(new Font("Inter", Font.BOLD, 40));
		randNumberGroup.add(resultCard);

		GridBagConstraints groupPadding = new GridBagConstraints();
		groupPadding.gridx = 0;
		groupPadding.gridy = 1;
		groupPadding.insets = new Insets(42, 0, 35, 0);
		add(randNumberGroup, groupPadding);

		// create input solution
		inputSolution = new JTextField("Enter your solution . . .");
		inputSolution.setFont(new Font("Inter", Font.PLAIN, 24));
		inputSolution.setBorder(BorderFactory.createEmptyBorder(17, 30, 16, 30));
		inputSolution.setPreferredSize(new Dimension(440, 62));

		GridBagConstraints inputPadding = new GridBagConstraints();
		inputPadding.gridx = 0;
		inputPadding.gridy = 2;
		inputPadding.insets = new Insets(0, 0, 94, 0);
		add(inputSolution, inputPadding);

		// menu
		JPanel menu = new JPanel(new GridLayout(1, 3, 56, 0));
		menu.setBackground(new Color(188, 223, 255));

		GridBagConstraints menuPadding = new GridBagConstraints();
		menuPadding.gridx = 0;
		menuPadding.gridy = 3;
		menuPadding.insets = new Insets(0, 0, 0, 0);

		btnBack = new CleanButton("BACK", Color.white, Color.black);
		btnSaveAndNew = new CleanButton("SAVE & NEW", Color.black, Color.white);
		btnSaveAndNew.setBorder(BorderFactory.createEmptyBorder(16, 30, 17, 30));
		btnExit = new CleanButton("EXIT", Color.white, Color.black);

		menu.add(btnBack);
		menu.add(btnSaveAndNew);
		menu.add(btnExit);
		add(menu, menuPadding);

		btnBack.addActionListener(new ToSelectModePage());
		btnSaveAndNew.addActionListener(new SaveAndNew());
		btnExit.addActionListener(new ToShowResultPage());

		timer.start();
		setVisible(true);
	}

	class ToSelectModePage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			timer.stop();

			new SelectModePage().setVisible(true);
			setVisible(false);

			System.out.println("back from " + mode);
		}

	}

	class SaveAndNew implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			/** Keep all results of both mode in select mode page */
			SelectModePage.collectAllResults(timeStamp, inputSolution.getText(), result);

			/** Reset placeholder */
			inputSolution.setText("Enter your solution . . .");

			/** New random result number */
			result = getRandomResult();

			resultCard.setText(result);

			/** New random number card */
			randomNumberCards = getRandomNumber();

			cardNumber1.setText(randomNumberCards.get(0));
			cardNumber2.setText(randomNumberCards.get(1));
			cardNumber3.setText(randomNumberCards.get(2));
			cardNumber4.setText(randomNumberCards.get(3));
			if (mode == "Hard mode") {
				cardNumber5.setText(randomNumberCards.get(4));
			}

			/** Reset stop watch for count new time */
			reset();
		}

	}

	class ToShowResultPage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			/**
			 * Get all data from select mode page and Send all data to show result page
			 */
			ShowResultPage.setAllPlayed(SelectModePage.getAllTimes(), SelectModePage.getAllSolutions(),
					SelectModePage.getAllResults());

			timer.stop();
			new ShowResultPage().setVisible(true);
			setVisible(false);

			System.out.println("exit to show result from " + mode);
		}

	}

	public String getRandom(int bound) {
		return String.valueOf((int) (Math.random() * bound)); // 0-99 0-999 0-9
	}

	public String getRandomResult() {
		System.out.println("random result : " + mode);
		if (mode == "Easy mode")
			return getRandom(100);
		return getRandom(1000);
	}

	public ArrayList<String> getRandomNumber() {
		ArrayList<String> numberList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			numberList.add(getRandom(10));
		}
		return numberList;
	}

	public static String getMode() {
		return mode;
	}

	public static void setMode(String modeFromSelect) {
		mode = modeFromSelect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/** count time +1 every 1000 milliseconds or 1s */
		time++;
		hours = time / 3600;
		minutes = (time % 3600) / 60;
		seconds = time % 60;

		partSeconds = String.format("%02d", seconds);
		partMinutes = String.format("%02d", minutes);
		partHours = String.format("%02d", hours);
		timeStamp = partHours + ":" + partMinutes + ":" + partSeconds;

		stopWatch.setText(timeStamp);
	}

	public void reset() {
		timer.stop();

		time = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;

		partSeconds = String.format("%02d", seconds);
		partMinutes = String.format("%02d", minutes);
		partHours = String.format("%02d", hours);
		timeStamp = partHours + ":" + partMinutes + ":" + partSeconds;

		stopWatch.setText(timeStamp);

		timer.start();
	}

}
