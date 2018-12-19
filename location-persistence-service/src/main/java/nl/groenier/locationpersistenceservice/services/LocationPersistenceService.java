package nl.groenier.locationpersistenceservice.services;

import nl.groenier.locationpersistenceservice.models.Location;

public interface LocationPersistenceService {

	//Create
	public void create(Location item);

	//Read by id
	public Location read(Integer id);

	//Update
	public void update(Location item);

	//Delete by instance
	public void delete(Location item);

	//Delete by id
	public void delete(Integer id);

}
