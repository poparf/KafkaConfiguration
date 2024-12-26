package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.DTO.KeyloggerDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.Keylogger;

public interface KeyloggerService {
    void saveKeyloggerData(Keylogger keyloggerData);
    Keylogger save(KeyloggerDTO keyloggerDTO, UserSystemDTO userSystemDTO);
}
