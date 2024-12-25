package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;

public interface UserSystemService {
    UserSystem save(UserSystemDTO userSystemDTO);
    UserSystem save(UserSystem userSystem);
    UserSystem findById(String id);
    UserSystem findByUsername(String username);
}
