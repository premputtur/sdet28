package com.crm.comcast.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * Java utility class
 * 
 * @author Premananda K
 *
 */
public class JavaUtility {
	/**
	 * This method will return random number
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;

	}

	/**
	 * This will return system date and Time
	 * 
	 * @return
	 */
	public String sysytemDateAndTime() {
		Date date = new Date();
		String dateAndTime = date.toString();
		return dateAndTime;
	}

}
