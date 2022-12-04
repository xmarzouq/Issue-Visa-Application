package main;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import Program.Immigration;

public class Main {
	private static Scanner scanner;
	private static Immigration obj;
	
	public static void main(String[] args) throws Exception {
		obj = new Immigration();
		scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		System.out.print("--> ");
		String name = scanner.nextLine();
		System.out.println("\nEnter your passport number");
		System.out.print("--> ");
		String passport = scanner.nextLine();
		obj.issueVisitVisa(name, passport);
	}	
}
