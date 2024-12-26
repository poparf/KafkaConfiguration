package ro.popa.kafkaconfiguration.services.impl;

import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.DTO.WindowActivityDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.entities.WindowActivity;
import ro.popa.kafkaconfiguration.repositories.WindowActivityRepository;
import ro.popa.kafkaconfiguration.services.UserSystemService;
import ro.popa.kafkaconfiguration.services.WindowActivityService;

import java.util.Date;

@Service
public class WindowActivityServiceImpl implements WindowActivityService {

    private WindowActivityRepository windowActivityRepository;
    private UserSystemService userSystemService;

    public WindowActivityServiceImpl(WindowActivityRepository windowActivityRepository, UserSystemService userSystemService) {
        this.windowActivityRepository = windowActivityRepository;
        this.userSystemService = userSystemService;
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

    @Override
    public WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData, UserSystemDTO userSystemDTO) {
        UserSystem user = userSystemService
                .findByUsernameAndComputerName(userSystemDTO.getUsername(), userSystemDTO.getComputerName())
                .orElseGet(() -> userSystemService.save(userSystemDTO));

        WindowActivity windowActivity = new WindowActivity();
        windowActivity.setUserSystem(user);
        windowActivity.setTitle(windowActivityData.getTitle());
        windowActivity.setTimestamp(new Date(windowActivityData.getStartTime() * 1000));
        windowActivity.setDuration(windowActivityData.getDuration());
        return windowActivityRepository.save(windowActivity);
    }
}
