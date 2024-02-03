package org.home.controller;

import org.home.service.IMonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private final IMonitoringService service;

    public MonitoringController(final IMonitoringService service) {
        this.service = service;
    }

    @GetMapping("/version")
    String version() {
        return service.getVersion();
    }
}
