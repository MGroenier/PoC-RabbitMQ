package nl.groenier.itempersistenceservice.services;

import nl.groenier.itempersistenceservice.models.Item;

import java.util.Optional;

public interface ItemPersistenceService {

	//Create
	public void create(Item item);

	//Read by id
	public Optional<Item> read(Integer id);

	//Update
	public void update(Item item);

	//Delete by instance
	public void delete(Item item);

	//Delete by id
	public void delete(Integer	id);

}
