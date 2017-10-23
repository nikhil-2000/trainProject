package pkg;

import java.util.ArrayList;


public class Station {
	private String name;
	private ArrayList<Link> nearbyStations;
	

	public Station(String name) {
		this.name = name;
		this.nearbyStations = new ArrayList<Link>();
	}

	public void addNearbyStation(Station newStation,int weight,String linkType) {
		Link newLink = new Link(this,newStation,weight,linkType);
		this.nearbyStations.add(newLink);
	}
	
	public void removeNearbyStation(Station stationToRemove) {
		if (this.areStationsConnected(stationToRemove) == false) {
			return;
		}
		else {
			for(Link currentStation : nearbyStations) {
				if (currentStation.getOne() == stationToRemove || currentStation.getTwo()  == stationToRemove){
					this.nearbyStations.remove(currentStation);
				}			
			}
		}
	}
	
	public boolean areStationsConnected(Station otherStation) {
		for (int i=0; i<this.nearbyStations.size();i++) {
			Link currentLink = this.nearbyStations.get(i);
			if (currentLink.getOne() == otherStation || currentLink.getTwo()  == otherStation){
				return true;
			}
		}
		return false;
	}
	
	public int getStationLinkWeight(Station otherStation) {
		for (int i=0; i<this.nearbyStations.size();i++) {
			Link currentLink = this.nearbyStations.get(i);
			if (currentLink.getOne() == otherStation || currentLink.getTwo()  == otherStation){
				return currentLink.getWeight();
			}
		}
		return Integer.MAX_VALUE ;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
}