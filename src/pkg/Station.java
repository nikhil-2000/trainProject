package pkg;

import java.util.ArrayList;


public class Station {
	private String name;
	private ArrayList<Link> nearbyStations;
	

	public Station(String name,ArrayList<Link> nearbyStations) {
		this.name = name;
		this.nearbyStations = nearbyStations;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}