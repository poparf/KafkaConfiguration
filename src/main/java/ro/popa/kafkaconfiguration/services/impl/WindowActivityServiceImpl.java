package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.repositories.WindowActivityRepository;

@Service
public class WindowActivityServiceImpl {

    private WindowActivityRepository windowActivityRepository;

    public WindowActivityServiceImpl(WindowActivityRepository windowActivityRepository) {
        this.windowActivityRepository = windowActivityRepository;
    }
}
