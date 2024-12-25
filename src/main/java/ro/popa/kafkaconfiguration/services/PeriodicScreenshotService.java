package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.DTO.PeriodicScreenshotDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.PeriodicScreenshot;

public interface PeriodicScreenshotService {
    PeriodicScreenshot saveScreenshot(PeriodicScreenshotDTO periodicScreenshotDTO);
    PeriodicScreenshot saveScreenshot(PeriodicScreenshotDTO periodicScreenshotDTO, UserSystemDTO userSystem);
}
