package pkg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Map {
	Set<Station> stations = new HashSet<Station>();
	private Set<Station> visited = new HashSet<Station>();
	Station centralStation;
	
	
	Map(){
		//Met line
		Station harrowOnTheHill = new Station("Harrow on the Hill");
		Station northwickPark = new Station("Northwick Park");
		Station wembleyPark = new Station("Wembley Park");
		
		//Bakerloo
		Station kenton = new Station("Kenton");
		Station harrowWealdstone = new Station("Harrow and Wealdstone");
		Station southKenton = new Station("South Kenton");
		
		//Jubilee
		Station kingsbury = new Station("Kingsbury");
		Station neasden = new Station("Neasden");

		harrowOnTheHill.connectByTrain(1, northwickPark);
		northwickPark.connectByTrain(1, wembleyPark);
		harrowWealdstone.connectByTrain(1, kenton);
		kenton.connectByTrain(1, southKenton);
		kingsbury.connectByTrain(1, wembleyPark);
		wembleyPark.connectByTrain(1, neasden);
		
		northwickPark.connectByWalk(2, kenton);
		
		stations.add(harrowOnTheHill);
		stations.add(northwickPark);
		stations.add(wembleyPark);
		stations.add(kenton);
		stations.add(harrowWealdstone);
		stations.add(southKenton);
		stations.add(kingsbury);
		stations.add(neasden);
		
		centralStation = wembleyPark;
	}

	public Station getClosestStation(Set<Station> unvisitedStations) {
		int distanceFromStart = Integer.MAX_VALUE;
		Station closestStation = null;
		for (Station station : unvisitedStations) {
			if (station.distanceFromStart <= distanceFromStart) {
				closestStation = station;
				distanceFromStart = station.distanceFromStart;
			}
		}
		return closestStation;
	}
	
	public void unvisitAll() {
		for (Station sta: stations) {
			sta.markUnvisited();
		}
	}
	
	private List<Station> dijkstra(Station startStation, Station endStation) {
		Set<Station> unvisitedStations = stations;
		
		Station currentStation = startStation;
		currentStation.distanceFromStart = 0;
		
		while (!visited.contains(endStation)){
			currentStation = this.getClosestStation(unvisitedStations);
			for (Connection connection:currentStation.connectingStations) {
				Station station = connection.connectingStation;
				int distance = currentStation.distanceFromStart + connection.weight;
				if (distance < station.distanceFromStart) {
					station.distanceFromStart = distance;
					station.previousStation = currentStation;
					station.previousConnection = connection;
				}
			}
			unvisitedStations.remove(currentStation);
			visited.add(currentStation);
			
		}
		List<Station> path = new ArrayList<Station>();
		Station n = currentStation;
		while (n.name != startStation.name){
			path.add(0, n);
			n = n.previousStation;
		}
		path.add(0, startStation);
		this.unvisitAll();
		
		return path;
	}
	
	public Station findStation(String stationName, Station currentStation) {

		List<Station> stationQueue = new ArrayList<Station>();
		
		stationQueue.add(centralStation);
		centralStation.markVisited();
		while (!stationQueue.isEmpty()) {
			
			Station s = stationQueue.get(0);
			stationQueue.remove(s);

			if (s.name == stationName) {
				return s;
			}
			
			for (Connection e: s.connectingStations) {
				Station connectedStation = e.connectingStation;
				if (!connectedStation.isVisited) {
					connectedStation.markVisited();
					stationQueue.add(connectedStation);
				}
			}
		}
		return null;
	}
	
	public void getPath(String startStationName, String endStationName) {
		Station startStation = findStation(startStationName,centralStation);
		this.unvisitAll();
		Station endStation = findStation(endStationName,centralStation);
		this.unvisitAll();
		
		if (startStation == null) {
			System.out.println("Your Start Station doesn't exist on this map");
		}
		if (endStation == null) {
			System.out.println("Your End Station doesn't exist on this map");
		}
		
		List<Station> path = this.dijkstra(startStation, endStation);
		
		List<Integer> range = IntStream.rangeClosed(1, path.size()-1).boxed().collect(Collectors.toList());
		
		for (int i : range) {
			Station s = path.get(i);
			String step = s.previousStation.name + " --> " + s.previousConnection.description + "(" + s.previousConnection.weight + " mins) --> " + s.name;
			System.out.println(step);
		}
	}
}
