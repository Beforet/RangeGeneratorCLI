package edu.newpaltz.cs.CS352.HW1;
import java.util.ArrayList;
import java.util.Random;
/**
 * Generates a string of random characters. This implementation uses an ArrayList of Range objects
 * to define which characters may be chosen for the string.
 * @author Patrick
 *
 */
public class RandomStringGenerator {
	private final int C_UPPER = 67;
	private final int C_LOWER = 99;
	private final int D_DIGIT = 100;
	private final int DIGIT_SAMPLE = 48;
	private ArrayList<Range> rangeList = new ArrayList<Range>();
	private Random listSelect = new Random();
	
	public RandomStringGenerator() {
		
	}
	/**
	 * Adds a Range object to the ArrayList<Range>. Was going to use anonymous Range Objects,
	 * but that proved to be 
	 * @param first The first character in the range.
	 * @param last The last character in the range.
	 */
	public void addRange(char first, char last){
		int start = (int)first;
		int end = (int)last;		
		rangeList.add(new Range(start, end));		
	}
	/**
	 * This method repeatedly calls getRangeIndex to randomly determine which range object it will use
	 * @param length How long the random string will be.
	 * @return The random String.
	 */
	public String nextString(int length){
		char[] randomString = new char[length];		
		for (int count = 0; count < length; count++){
			Range selectedRange = rangeList.get(getRangeIndex());
			randomString[count] = selectedRange.getRandomCharacter();
		}
		return new String(randomString);
	}
	/**
	 * This nextString method takes a string parameter made up of the characters 'C', 'c', and 'd'.
	 * It iterates through this for each character and selects a random character from a specific Range object.
	 * It finds the Range object by calling findRangeIndex(int token):int with the selected character, except in the
	 * case of 'd'. Because 'd' is a lower case character, I needed to define a constant int value DIGIT_SAMPLE which
	 * is the ASCII for '0'.
	 * @param seed A string that will determine what characters will make up the output string.
	 * @return The randomized string.
	 */
	public String nextString(String seed){
		char[] randomString = new char[seed.length()];
		for (int index = 0; index < seed.length(); index++){
			char token = seed.charAt(index);
			int tokenCode = (int)token;
			int tokenIndex;
			switch (tokenCode) {
				case C_UPPER:
					tokenIndex = findRangeIndex(C_UPPER);
					randomString[index] = rangeList.get(tokenIndex).getRandomCharacter();
					break;
				case C_LOWER:
					tokenIndex = findRangeIndex(C_LOWER);
					randomString[index] = rangeList.get(tokenIndex).getRandomCharacter();
					break;
				case D_DIGIT:
					tokenIndex = findRangeIndex(DIGIT_SAMPLE);
					randomString[index] = rangeList.get(tokenIndex).getRandomCharacter();
					break;
				default:
					throw new BadStringException("Invald String: Please Input a String of characters "
						+ "'C', 'c', and 'd'");
			}
		}
		return new String(randomString);
	}	
	private int getRangeIndex(){
		int rangeIndex = listSelect.nextInt(rangeList.size());
		return rangeIndex;
	}
	/*
	 * This is a method I added myself to help determine which Range object the class should use for 
	 * randomization.
	 */
	private int findRangeIndex(int token) {
		int rangeIndex = -1;
		for(int index = 0; index < rangeList.size(); index++) {
			if (rangeList.get(index).checkCharacter(token)) {
				rangeIndex = index;
				break;
			}
		}
		return rangeIndex;
	}
}
