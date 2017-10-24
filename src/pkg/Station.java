package pkg;

import java.util.ArrayList;


public class Station {
	private String name;
	private ArrayList<Link> nearbyStations;
	

	public Station(String name) {
		this.name = name;
		this.setNearbyStations(new ArrayList<Link>());
	}

	public void addNearbyStation(Station newStation,int weight,String linkType) {
		Link newLink = null;
		if (linkType == "walking") {
			newLink = new WalkingLink(newStation,weight); 
		}else if (linkType == "train") {
			newLink = new TrainLink(newStation,weight);
		}else {
			newLink = new Link(newStation,weight);
		}
		this.getNearbyStations().add(newLink);
	}
	
	public void addNearbyStation(Link link) {
		this.getNearbyStations().add(link);
	}
	public void removeNearbyStation(Station stationToRemove) {
		if (this.areStationsConnected(stationToRemove) == false) {
			return;
		}
		else {
			for(Link currentLink : getNearbyStations()) {
				if (currentLink.getOtherStation() == stationToRemove){
					this.getNearbyStations().remove(currentLink);
				}			
			}
		}
	}
	
	public boolean areStationsConnected(Station otherStation) {
		for (Link currentLink : getNearbyStations()) {
			if (currentLink.getOtherStation() == otherStation){
				return true;
			}
		}
		return false;
	}
	
	public int getStationLinkWeight(Station otherStation) {
		for (Link currentLink : getNearbyStations()) {
			if (currentLink.getOtherStation() == otherStation){
				return currentLink.getWeight();
			}
		}
		return Integer.MAX_VALUE ;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Link> getNearbyStations() {
		return nearbyStations;
	}

	public void setNearbyStations(ArrayList<Link> nearbyStations) {
		this.nearbyStations = nearbyStations;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	
}