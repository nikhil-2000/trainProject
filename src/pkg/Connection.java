package pkg;

public class Connection {
	int weight;
	Station connectingStation;
	String description;
	
	Connection(int givenWeight,Station givenStation, String givenDescription){
		weight = givenWeight;
		connectingStation = givenStation;
		description = givenDescription;
	}

	public Station getConnectingStation() {
		return connectingStation;
	}

	public int getWeight() {
		return weight;
	}
	
}
