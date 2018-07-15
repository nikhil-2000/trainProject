package pkg;
import java.util.*;

public class userProgram {

	private static Scanner userInput;

	public static void main(String[] args) {
		//Input departureStation
		//Input destinationStation
		//Find Start Station on Map
		//Use Dijkstra to find shortest path to end station
		//Output path in formation Station --> Type(Time) --> Station
		
		userInput = new Scanner(System.in);
		System.out.println("Enter the start station:");
		String startStationName = userInput.next();
		System.out.println("Enter the destination station:");
		String endStationName = userInput.next();
		
		Map tubeMap = new Map();
		tubeMap.getPath(startStationName, endStationName);
				
	}

}
