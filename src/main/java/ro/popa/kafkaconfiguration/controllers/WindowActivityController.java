package ro.popa.kafkaconfiguration.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.popa.kafkaconfiguration.services.impl.WindowActivityServiceImpl;

@RestController
@RequestMapping("/api/window-activity")
public class WindowActivityController {

    private WindowActivityServiceImpl windowActivityServiceImpl;
}
