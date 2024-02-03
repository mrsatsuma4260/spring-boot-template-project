package org.home.controller;

import org.home.properties.ApplicationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private final ApplicationProperties properties;

    public MonitoringController(final ApplicationProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/version")
    String version() {
        return properties.getVersion();
    }
}
