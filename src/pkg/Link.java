package pkg;

public class Link {
	private Station one, two;
	private int weight;
	private String linkType;

	public Link(Station one, Station two, int weight, String linkType) {
		this.one = one;
		this.two = two;
		this.weight = weight;
		this.linkType = linkType;
		
	}

}
