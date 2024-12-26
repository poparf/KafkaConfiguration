package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.KeyloggerDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.Keylogger;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.repositories.KeyloggerRepository;
import ro.popa.kafkaconfiguration.services.KeyloggerService;
import ro.popa.kafkaconfiguration.services.UserSystemService;

import java.util.Date;

@Service
public class KeyloggerServiceImpl implements KeyloggerService {

    private final KeyloggerRepository keyloggerRepository;
    private final UserSystemService userSystemService;

    public KeyloggerServiceImpl(KeyloggerRepository keyloggerRepository, UserSystemService userSystemService) {
        this.keyloggerRepository = keyloggerRepository;
        this.userSystemService = userSystemService;
    }

    @Override
    public void saveKeyloggerData(Keylogger keyloggerData) {
        keyloggerRepository.save(keyloggerData);
    }

    @Override
    public Keylogger save(KeyloggerDTO keyloggerDTO, UserSystemDTO userSystemDTO) {

        UserSystem user = userSystemService
                .findByUsernameAndComputerName(userSystemDTO.getUsername(), userSystemDTO.getComputerName())
                .orElseGet(() -> userSystemService.save(userSystemDTO));

        Keylogger keylogger = new Keylogger();
        keylogger.setUserSystem(user);
        keylogger.setKeys(keyloggerDTO.getKeys());
        keylogger.setStartTime(new Date(keyloggerDTO.getStartTime() * 1000));
        keylogger.setEndTime(new Date(keyloggerDTO.getEndTime() * 1000));
        return keyloggerRepository.save(keylogger);
    }
}
