package ro.popa.kafkaconfiguration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.popa.kafkaconfiguration.entities.PeriodicScreenshot;

@Repository
public interface PeriodicScreenshotRepository extends MongoRepository<PeriodicScreenshot, String> {
}
