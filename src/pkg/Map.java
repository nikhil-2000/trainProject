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
	
	public void linkStationsByFoot(Station firstStation,Station secondStation,int weight) {
		firstStation.addNearbyStation(new WalkingLink(secondStation, weight));
		secondStation.addNearbyStation(new WalkingLink(firstStation, weight));
	}
	
	public void linkStationsByTrain(Station firstStation,Station secondStation,int weight) {
		firstStation.addNearbyStation(new TrainLink(secondStation, weight));
		secondStation.addNearbyStation(new TrainLink(firstStation, weight));
	}
	public Station findStation(String stationName) throws InterruptedException{
		if (this.startStation.getName() == stationName) {
			return startStation; 	
		}else{
			Queue<Station> unvisitedStations = new Queue<Station>();
			Set<Station> visitedStations = new HashSet<Station>();
			
			unvisitedStations.enqueue(startStation);	
			visitedStations.add(startStation);
			ArrayList<Link> nearbyStation = startStation.getNearbyStations();
				
			while (unvisitedStations.isEmpty() == false) {
				Station currentStation = unvisitedStations.dequeue();
				visitedStations.add(currentStation);
				nearbyStation = currentStation.getNearbyStations();
				
				for (Link eachLink : nearbyStation) {
					Station eachStation = eachLink.getOtherStation();
					if (eachStation.getName() == stationName) {
						return eachStation;
					}else if (visitedStations.contains(eachStation) == false) {
						unvisitedStations.enqueue(eachStation);						
					}
				}
			}
			return null;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	}

}
