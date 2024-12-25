package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.entities.Keylogger;
import ro.popa.kafkaconfiguration.repositories.KeyloggerRepository;
import ro.popa.kafkaconfiguration.services.KeyloggerService;

@Service
public class KeyloggerServiceImpl implements KeyloggerService {

    private KeyloggerRepository keyloggerRepository;

    public KeyloggerServiceImpl(KeyloggerRepository keyloggerRepository) {
        this.keyloggerRepository = keyloggerRepository;
    }

    @Override
    public void saveKeyloggerData(Keylogger keyloggerData) {
        keyloggerRepository.save(keyloggerData);
    }
}
