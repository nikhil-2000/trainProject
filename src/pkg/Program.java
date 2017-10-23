package pkg;

import java.util.Scanner;

public class Program {
	private static Scanner uInput;
	private static Scanner uInput2;

	public static void main(String[] args) {
		Map tubeMap = new Map();
		System.out.println("This program will help you find the quickest route between two stations");
		System.out.println("Enter the station you will be travelling from");
		uInput = new Scanner(System.in);
		uInput2 = new Scanner(System.in);
		String statA;
		statA = uInput.nextLine();				
		System.out.println("Enter the station you will be travelling to");
		String statB;
		statB = uInput2.nextLine();
		String route;
		route = ("You are travelling from " + statA + " to " + statB);
		System.out.println(route);
		//Check if the two stations are connected
			//Find the stations which the user has entered by moving through the map
			//See if there are links between the two
		//If they are, find the weight of the connection
			//For each link, get the weight and add it to a running total
			//Tell the user the type of link between the stations
		
		
		
		
		 

	}
}
