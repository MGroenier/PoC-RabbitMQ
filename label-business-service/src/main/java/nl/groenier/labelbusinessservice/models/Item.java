package nl.groenier.labelbusinessservice.models;

public class Item {

	private Integer id;
	private String descriptionOfContent;
	private int weightInGram;
	private int origin;
	private int destination;

	public Item(String descriptionOfContent, int weightInGram, int origin, int destination) {
		this.descriptionOfContent = descriptionOfContent;
		this.weightInGram = weightInGram;
		this.origin = origin;
		this.destination = destination;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionOfContent() {
		return descriptionOfContent;
	}

	public void setDescriptionOfContent(String descriptionOfContent) {
		this.descriptionOfContent = descriptionOfContent;
	}

	public int getWeightInGram() {
		return weightInGram;
	}

	public void setWeightInGram(int weightInGram) {
		this.weightInGram = weightInGram;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", descriptionOfContent='" + descriptionOfContent + '\'' +
				", weightInGram=" + weightInGram +
				", origin=" + origin +
				", destination=" + destination +
				'}';
	}

}
