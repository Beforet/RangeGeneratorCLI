package edu.newpaltz.cs.CS352.HW1;

import org.apache.commons.cli.*;
/**
 *  
 *  
 * @author Patrick Ford
 *
 */
public class RandomStringGeneratorTester {
	public static void main(String[] args) throws ParseException {
		RandomStringGenerator generator = new RandomStringGenerator();
		Options options = new Options();
		BasicParser parser = new BasicParser();
		
		generator.addRange('A', 'Z');
		generator.addRange('a', 'z');
		generator.addRange('0', '9');
		options.addOption("i", true, "takes in a number to determine length of random string");
		options.addOption("s", true, "takes in a string of C, c, and d characters to determine contents of random string");
		
		CommandLine cmd = parser.parse(options, args);		
		if (cmd.hasOption('i')) {
			int length = Integer.parseInt(cmd.getOptionValue('i'));
			System.out.println(generator.nextString(length));
		}
		if (cmd.hasOption('s')) {
			String seed = cmd.getOptionValue('s');
			System.out.println(generator.nextString(seed));
		}
	}
}
