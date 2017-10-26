package pkg;


import java.util.Scanner;


public class Program {
	private static Scanner uInput;
	private static Scanner uInput2;

	public static void main(String[] args) throws InterruptedException {
		Map tubeMap = new Map();
		System.out.println("This program will help you find the quickest route between two stations");
		System.out.println("Enter the station you will be travelling from");
		uInput = new Scanner(System.in);
		uInput2 = new Scanner(System.in);
		String statAName;
		statAName = uInput.nextLine();				
		System.out.println("Enter the station you will be travelling to");
		String statBName;
		statBName = uInput2.nextLine();
		String route;
		route = ("You are travelling from " + statAName + " to " + statBName);
		System.out.println(route);
		Station statA = tubeMap.findStation(statAName);
		Station statB = tubeMap.findStation(statBName);
		if (statA != null || statB != null) {
			
		}
		//Check if the two stations are connected
			//Find the stations which the user has entered by moving through the map
			//See if there are links between the two
		//If they are, find the weight of the connection
			//For each link, get the weight and add it to a running total
			//Tell the user the type of link between the stations
		
		
		
		
		 

	}
}
