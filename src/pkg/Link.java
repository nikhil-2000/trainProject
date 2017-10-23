package pkg;

public class Link {
	private Station one;
	private Station two;
	private int weight;
	private String linkType;

	public Link(Station one, Station two, int weight, String linkType) {
		this.setOne(one);
		this.setTwo(two);
		this.setWeight(weight);
		this.linkType = linkType;
		
	}

	public Station getOne() {
		return one;
	}

	public void setOne(Station one) {
		this.one = one;
	}

	public Station getTwo() {
		return two;
	}

	public void setTwo(Station two) {
		this.two = two;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
