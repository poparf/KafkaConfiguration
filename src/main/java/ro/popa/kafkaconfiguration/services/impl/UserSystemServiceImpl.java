package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.repositories.UserSystemRepository;
import ro.popa.kafkaconfiguration.services.UserSystemService;

import java.util.Optional;

@Service
public class UserSystemServiceImpl implements UserSystemService {

    private UserSystemRepository userSystemRepository;

    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    public UserSystem save(UserSystemDTO userSystemDTO) {
        if(userSystemRepository.existsByUsernameAndComputerName(userSystemDTO.getUsername(), userSystemDTO.getComputerName())) {
           return null;
        } else {
            UserSystem userSystem = new UserSystem();
            userSystem.setUsername(userSystemDTO.getUsername());
            userSystem.setComputerName(userSystemDTO.getComputerName());
            userSystem.setIp(userSystemDTO.getIp());
            userSystem.setOs(userSystemDTO.getOs());
            return userSystemRepository.save(userSystem);
        }
    }

    public UserSystem save(UserSystem userSystem) {
        if(userSystemRepository.existsByUsernameAndComputerName(userSystem.getUsername(), userSystem.getComputerName())) {
            return null;
        } else {
            return userSystemRepository.save(userSystem);
        }
    }

    public UserSystem findById(String id) {
        return userSystemRepository.findById(id).orElse(null);
    }

    @Override
    public UserSystem findByUsername(String username) {
        return userSystemRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Optional<UserSystem> findByUsernameAndComputerName(String username, String computerName) {
        return userSystemRepository.findByUsernameAndComputerName(username, computerName);
    }
}
