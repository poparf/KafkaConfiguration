package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.repositories.PeriodicScreenshotRepository;
import ro.popa.kafkaconfiguration.services.PeriodicScreenshotService;

@Service
public class PeriodicScreenshotServiceImpl implements PeriodicScreenshotService {

    private PeriodicScreenshotRepository periodicScreenshotRepository;

    public PeriodicScreenshotServiceImpl(PeriodicScreenshotRepository periodicScreenshotRepository) {
        this.periodicScreenshotRepository = periodicScreenshotRepository;
    }
}
