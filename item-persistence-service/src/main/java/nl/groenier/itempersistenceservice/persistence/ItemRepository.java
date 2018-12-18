package nl.groenier.itempersistenceservice.persistence;

import nl.groenier.itempersistenceservice.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
