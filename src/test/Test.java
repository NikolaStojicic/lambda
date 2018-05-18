/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	boolean stopIt = false;

	private void initializeSingingInThreads() {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";

		Performance first = new Performance(lyrics1, 1500);
		Performance second = new Performance(lyrics2, 1500);

		Synchronizer synch = new Synchronizer(true);
		pattiSmith = new Singer("Patti Smith", Voice.FIRST, first, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, second, stopIt, synch);
	}

	public void testSingInThreads() {
		initializeSingingInThreads();
		pattiSmith.start();
		bruceSpringsteen.start();
		IN.nextLine();
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
	}

}
