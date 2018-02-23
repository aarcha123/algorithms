package com.algorithms.lesson1;

import java.util.Scanner;

public class ConsoleReader {
	
	public static int readInt(){
		Scanner scanner = new Scanner(System.in);
		String line=scanner.nextLine();
		return Integer.parseInt(line);
	}

}
