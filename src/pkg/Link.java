package pkg;

public class Link {
	private Station otherStation;
	private int weight;

	public Link(Station otherStation, int weight) {
		this.setOtherStation(otherStation);
		this.setWeight(weight);
		
	}

	public Station getOtherStation() {
		return otherStation;
	}

	public void setOtherStation(Station otherStation) {
		this.otherStation = otherStation;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
