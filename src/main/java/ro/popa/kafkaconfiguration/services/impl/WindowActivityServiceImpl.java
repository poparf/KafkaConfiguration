package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.WindowActivityDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.entities.WindowActivity;
import ro.popa.kafkaconfiguration.repositories.WindowActivityRepository;
import ro.popa.kafkaconfiguration.services.WindowActivityService;

@Service
public class WindowActivityServiceImpl implements WindowActivityService {

    private WindowActivityRepository windowActivityRepository;

    public WindowActivityServiceImpl(WindowActivityRepository windowActivityRepository) {
        this.windowActivityRepository = windowActivityRepository;
    }

    @Override
    public WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData) {
        return null;
        //WindowActivity windowActivity = new WindowActivity();
    }

    @Override
    public WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData, UserSystem userSystem) {
        return null;
    }
}
