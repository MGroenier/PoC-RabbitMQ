package nl.groenier.locationpersistenceservice.services;

import nl.groenier.locationpersistenceservice.models.Location;
import nl.groenier.locationpersistenceservice.persistence.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationPersistenceServiceImpl implements LocationPersistenceService {

	private final Logger logger = LoggerFactory.getLogger(LocationPersistenceServiceImpl.class);

	@Autowired
	private LocationRepository locationRepository;

	//Create
	public void create(Location item) {
		logger.info("Created Item.");
		locationRepository.save(item);
	}

	//Read
	public Location read(Integer id) {
		logger.info("Read Item.");
		Optional<Location> readItem = locationRepository.findById(id);
		Location itemToReturn= null;
		if (readItem.isPresent()) {
			itemToReturn = readItem.get();
		}
		return itemToReturn;
	}

	//Update
	public void update(Location item) {
		//TODO Write an actual implementation.
		logger.info("Updated Item.");
	}

	//Delete
	public void delete(Location item) {
		logger.info("Deleted Item by object.");
		locationRepository.delete(item);
	}
	//Delete
	public void delete(Integer	id) {
		logger.info("Deleted Item by id.");
		locationRepository.deleteById(id);
	}

}
