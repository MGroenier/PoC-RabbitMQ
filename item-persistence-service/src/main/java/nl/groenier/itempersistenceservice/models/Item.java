package nl.groenier.itempersistenceservice.models;

import java.util.Date;

public class Item {

	private String id;

	private Location origin;
	private Location destination;

	private String descriptionOfContent;
	private int weightInGram;

	private Date dateOfRegistration;

	public Item(String id, Location origin, Location destination, String descriptionOfContent, int weightInGram, Date dateOfRegistration) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.descriptionOfContent = descriptionOfContent;
		this.weightInGram = weightInGram;
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
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

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", origin=" + origin +
				", destination=" + destination +
				", descriptionOfContent='" + descriptionOfContent + '\'' +
				", weightInGram=" + weightInGram +
				", dateOfRegistration=" + dateOfRegistration +
				'}';
	}

}
