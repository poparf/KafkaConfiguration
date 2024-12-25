package ro.popa.kafkaconfiguration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.services.impl.UserSystemServiceImpl;

@RestController
@RequestMapping("/api/user-system")
public class UserSystemController {

    @Autowired
    private UserSystemServiceImpl userSystemServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<UserSystem> getUserSystem(@PathVariable String id) {
        UserSystem userSystem = userSystemServiceImpl.findById(id);
        if(userSystem == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userSystem);
    }
}
