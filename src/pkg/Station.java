package pkg;
import java.util.*;

public class Station {
	String name;
	Set<Connection> connectingStations = new HashSet<Connection>();
	int distanceFromStart;
	boolean isVisited;
	Station previousStation;
	Connection previousConnection;
	
	
	public Station(String givenName){
		name = givenName;
		distanceFromStart = Integer.MAX_VALUE;
	}
	
	public void connectByTrain(int givenWeight, Station givenStation) {
		Connection newLink = new Connection(givenWeight, givenStation,"Train");
		connectingStations.add(newLink);
		newLink = new Connection(givenWeight, this, "Train");
		givenStation.connectingStations.add(newLink);
	}
	public void connectByWalk(int givenWeight, Station givenStation) {
		Connection newLink = new Connection(givenWeight, givenStation, "Walk");
		connectingStations.add(newLink);
		newLink = new Connection(givenWeight, this, "Walk");
		givenStation.connectingStations.add(newLink);
	}
	
	public void markVisited() {
		isVisited = true;
	}
	public void markUnvisited() {
		isVisited = false;
		distanceFromStart = Integer.MAX_VALUE;
	}
	
	public Station getNextUnvisited() {
	Iterator<Connection> iterator = connectingStations.iterator();
	while (iterator.hasNext()) {
		Connection nextLink = (Connection) iterator.next();
		if (nextLink.connectingStation.isVisited == false) {
			return nextLink.connectingStation;
		}
	}
	return null;
	}
}
