package nl.groenier.locationpersistenceservice.persistence;

import nl.groenier.locationpersistenceservice.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
}
