package nl.groenier.itempersistenceservice.services;

import nl.groenier.itempersistenceservice.models.Item;
import nl.groenier.itempersistenceservice.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPersistenceServiceImpl implements ItemPersistenceService{

	@Autowired
	private ItemRepository itemRepository;

	//Create
	public void create(Item item) {
		itemRepository.save(item);
	}

	//Read
	public Optional<Item> read(Integer id) {
		return itemRepository.findById(id);
	}

	//Update
	public void update(Item item) {	}

	//Delete
	public void delete(Item item) {
		itemRepository.delete(item);
	}
	//Delete
	public void delete(Integer	id) {
		itemRepository.deleteById(id);
	}

}
