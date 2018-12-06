package nl.groenier.itempersistenceservice.persistence;

import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.models.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

	private List<Item> db = new ArrayList<>();

	public Database() {
		Location location1 = new Location("0", "Moermanskkade", "113", "1013CN", "NL");
		Location location2 = new Location("1", "Verdilaan", "33", "4384LB", "NL");

		Item item1 = new Item("0", location1, location2, "Something interesting.", 750, new Date());
		Item item2 = new Item("1", location2, location1, "Something even more interesting.", 750, new Date());

		db.add(item1);
		db.add(item2);
	}

	public List getDb() {
		return db;
	}

	public void setDb(List db) {
		this.db = db;
	}

	public Item getItem(int id) {
		return db.get(id);

	}

}
