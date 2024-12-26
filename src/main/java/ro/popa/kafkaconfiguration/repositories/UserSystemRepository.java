package ro.popa.kafkaconfiguration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.popa.kafkaconfiguration.entities.UserSystem;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends MongoRepository<UserSystem, String> {

    boolean existsByUsernameAndComputerName(String username, String computerName);
    Optional<UserSystem> findByUsernameAndComputerName(String username, String computerName);
    boolean existsByUsername(String username);
    Optional<UserSystem> findByUsername(String username);
}
