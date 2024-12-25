package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.repositories.UserSystemRepository;
import ro.popa.kafkaconfiguration.services.UserSystemService;

@Service
public class UserSystemServiceImpl implements UserSystemService {

    private UserSystemRepository userSystemRepository;

    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    public UserSystem save(UserSystemDTO userSystemDTO) {
        if(!userSystemRepository.existsByUsername(userSystemDTO.getUsername())) {
            UserSystem userSystem = new UserSystem();
            userSystem.setUsername(userSystemDTO.getUsername());
            userSystem.setComputer_name(userSystemDTO.getComputerName());
            userSystem.setIp(userSystemDTO.getIp());
            userSystem.setOs(userSystemDTO.getOs());
            return userSystemRepository.save(userSystem);
        } else {
            return null;
        }
    }

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

    @Override
    public UserSystem findByUsername(String username) {
        return userSystemRepository.findByUsername(username).orElse(null);
    }
}
