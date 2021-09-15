package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class UsersBackgroundProcessController {
    @Autowired
    private UserService service;

    @Scheduled(fixedDelay = 60000, initialDelay = 3000)
    public void UpdatePoint() {
        service.sumPoint();
    }
}
