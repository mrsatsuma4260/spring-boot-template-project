package org.home.service.impl;

import org.home.properties.ApplicationProperties;
import org.home.service.IMonitoringService;
import org.springframework.stereotype.Service;

@Service
class MonitoringService
    implements IMonitoringService {

    private final ApplicationProperties properties;

    MonitoringService(final ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public String getVersion() {
        return properties.getVersion();
    }
}
