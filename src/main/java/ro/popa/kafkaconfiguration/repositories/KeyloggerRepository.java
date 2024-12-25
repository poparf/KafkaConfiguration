package ro.popa.kafkaconfiguration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.popa.kafkaconfiguration.entities.Keylogger;

@Repository
public interface KeyloggerRepository extends MongoRepository<Keylogger, String> {
}
