package ro.popa.kafkaconfiguration.services;

import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.DTO.WindowActivityDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.entities.WindowActivity;

public interface WindowActivityService {
    WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData);
    WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData, UserSystem userSystem);
    WindowActivity saveWindowActivityData(WindowActivityDTO windowActivityData, UserSystemDTO userSystem);
}
