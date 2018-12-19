package nl.groenier.gatewayservice.models;

public class Label {

	private Item item;

	public Label(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Label{" +
				"item=" + item +
				'}';
	}

}
