package ro.popa.kafkaconfiguration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.repositories.UserSystemRepository;

@Service
public class UserSystemService {

    @Autowired
    private UserSystemRepository userSystemRepository;

    public UserSystem save(UserSystem userSystem) {
        if(!userSystemRepository.existsByUsername(userSystem.getUsername())) {
            return userSystemRepository.save(userSystem);
        } else {
            return null;
        }
    }

    public UserSystem findById(String id) {
        return userSystemRepository.findById(id).orElse(null);
    }
}
