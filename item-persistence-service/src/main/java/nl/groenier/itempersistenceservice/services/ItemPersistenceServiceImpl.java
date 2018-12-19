package nl.groenier.itempersistenceservice.services;

import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.persistence.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPersistenceServiceImpl implements ItemPersistenceService{

	private final Logger logger = LoggerFactory.getLogger(ItemPersistenceServiceImpl.class);

	@Autowired
	private ItemRepository itemRepository;

	//Create
	public void create(Item item) {
		logger.info("Created Item.");
		itemRepository.save(item);
	}

	//Read
	public Optional<Item> read(Integer id) {
		logger.info("Read Item.");
		return itemRepository.findById(id);
	}

	//Update
	public void update(Item item) {
		//TODO Write an actual implementation.
		logger.info("Updated Item.");
	}

	//Delete
	public void delete(Item item) {
		logger.info("Deleted Item by object.");
		itemRepository.delete(item);
	}
	//Delete
	public void delete(Integer	id) {
		logger.info("Deleted Item by id.");
		itemRepository.deleteById(id);
	}

}
