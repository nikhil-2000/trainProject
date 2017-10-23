package pkg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import sun.misc.Queue;

public class Map {
	Station startStation;

	public Map() {
		// TODO Auto-generated constructor stub
		Station kenton = new Station("Kenton Station");
		Station northwick = new Station("Northwick Park");
		this.linkStations(kenton, northwick, 5,"walking");
		this.startStation = kenton;
		Station wembley = new Station("Wembley Park");
		this.linkStations(northwick, wembley, 3, "train");
				
		
	}
	
	public void linkStations(Station firstStation,Station secondStation,int weight,String type) {
		firstStation.addNearbyStation(secondStation,weight,type);
		secondStation.addNearbyStation(firstStation,weight,type);
	}
	
	
	public Station findStation(String stationName) throws InterruptedException{
		if (this.startStation.getName() == stationName) {
			return startStation; 	
		}else{
			Queue<Station> unvisitedStations = new Queue<Station>();
			Set<Station> visitedStations = new HashSet<Station>();
			unvisitedStations.enqueue(startStation);
				
			Station currentStation =  (Station) unvisitedStations.dequeue();
			visitedStations.add(currentStation);
			ArrayList<Link> nearbyStation = currentStation.getNearbyStations();
			
			for (Link eachLink : nearbyStation) {
				Station eachStation = eachLink.getOtherStation();
				if (eachStation.getName() == stationName) {
					return eachStation;
				}else if (visitedStations.contains(eachStation)) {
					unvisitedStations.enqueue(eachStation);						
				}
			}
			
			while (unvisitedStations.isEmpty() == false) {
				currentStation = unvisitedStations.dequeue();
				System.out.println(currentStation.getName());
				for (Link eachLink : nearbyStation) {
					Station eachStation = eachLink.getOtherStation();
					if (eachStation.getName() == stationName) {
						return eachStation;
					}else if (visitedStations.contains(eachStation)) {
						unvisitedStations.enqueue(eachStation);						
					}
				}
			}
		
		}
		return null;	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	}

}
