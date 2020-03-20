package com.dsa.general;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class MouseMove {

	public static final int ONE_MINUTE = 60000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;

	public static void main(String[] args) throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(ONE_MINUTE);
			System.out.println("Here I am Running");
		}

	}

}
