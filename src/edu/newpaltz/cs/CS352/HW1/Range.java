package edu.newpaltz.cs.CS352.HW1;
import java.util.Random;
/**
 * Describes two values between which a character can be selected.
 * This implementation relies on the ASCII for different characters.
 * Example: The range a-z will be treated as the integers 97-122.
 * @author Patrick Ford
 *
 */
public class Range {
	private int start, end;
	private Random picker;	

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
		picker = new Random();
	}
	/**
	 * This method randomly picks an int value between the start and the end value.
	 * @return The randomly selected int value cast as a char value.
	 */
	public char getRandomCharacter() {
		int selection = picker.nextInt(end - start) + start;
		return (char)selection;
	}
	/**
	 * Checks if a given character code is in this Range object
	 * @param characterCode
	 * @return
	 */
	public boolean checkCharacter(int characterCode) {
		return (characterCode <= end && characterCode >= start);
	}
}
