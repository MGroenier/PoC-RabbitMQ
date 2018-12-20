package nl.groenier.labelbusinessservice.models;

public class Label {

	private Item item;
	private Location origin;
	private Location destination;

	public Label(Item item, Location origin, Location destination) {
		this.item = item;
		this.origin = origin;
		this.destination = destination;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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

	@Override
	public String toString() {
		return "Label{" +
				"item=" + item +
				", origin=" + origin +
				", destination=" + destination +
				'}';
	}

}
