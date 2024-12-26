package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;

import java.util.Optional;

public interface UserSystemService {
    UserSystem save(UserSystemDTO userSystemDTO);
    UserSystem save(UserSystem userSystem);
    UserSystem findById(String id);
    UserSystem findByUsername(String username);
    Optional<UserSystem> findByUsernameAndComputerName(String username, String computerName);
}
