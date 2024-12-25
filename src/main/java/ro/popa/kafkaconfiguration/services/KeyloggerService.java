package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.entities.Keylogger;

public interface KeyloggerService {
    void saveKeyloggerData(Keylogger keyloggerData);
}
