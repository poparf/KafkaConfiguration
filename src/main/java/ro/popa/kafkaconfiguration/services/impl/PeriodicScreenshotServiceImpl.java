package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.PeriodicScreenshotDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.PeriodicScreenshot;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.repositories.PeriodicScreenshotRepository;
import ro.popa.kafkaconfiguration.services.PeriodicScreenshotService;
import ro.popa.kafkaconfiguration.services.UserSystemService;

import java.util.Base64;
import java.util.Date;

@Service
public class PeriodicScreenshotServiceImpl implements PeriodicScreenshotService {

    private PeriodicScreenshotRepository periodicScreenshotRepository;
    private UserSystemService userSystemService;

    public PeriodicScreenshotServiceImpl(PeriodicScreenshotRepository periodicScreenshotRepository, UserSystemService userSystemService) {
        this.periodicScreenshotRepository = periodicScreenshotRepository;
        this.userSystemService = userSystemService;
    }

    @Override
    public PeriodicScreenshot saveScreenshot(PeriodicScreenshotDTO periodicScreenshotDTO) {
        PeriodicScreenshot periodicScreenshot = new PeriodicScreenshot();
        byte[] decodedBytes = Base64.getDecoder().decode(periodicScreenshotDTO.getScreenshotB64Encoded());
        periodicScreenshot.setScreenshot(decodedBytes);
        periodicScreenshot.setTimestamp(new Date(periodicScreenshotDTO.getTimestamp() * 1000));
        return periodicScreenshotRepository.save(periodicScreenshot);
    }

    @Override
    public PeriodicScreenshot saveScreenshot(PeriodicScreenshotDTO periodicScreenshotDTO, UserSystemDTO userSystem) {
        PeriodicScreenshot periodicScreenshot = new PeriodicScreenshot();
        byte[] decodedBytes = Base64.getDecoder().decode(periodicScreenshotDTO.getScreenshotB64Encoded());
        periodicScreenshot.setScreenshot(decodedBytes);
        periodicScreenshot.setTimestamp(new Date(periodicScreenshotDTO.getTimestamp() * 1000));
        UserSystem userSystemFound = userSystemService.findByUsername(userSystem.getUsername());
        if(userSystemFound == null) {
            userSystemFound = userSystemService.save(userSystem);
        }
        periodicScreenshot.setUserSystem(userSystemFound);
        return periodicScreenshotRepository.save(periodicScreenshot);
    }
}
