package ro.popa.kafkaconfiguration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.popa.kafkaconfiguration.entities.WindowActivity;

@Repository
public interface WindowActivityRepository extends MongoRepository<WindowActivity, String> {
}
