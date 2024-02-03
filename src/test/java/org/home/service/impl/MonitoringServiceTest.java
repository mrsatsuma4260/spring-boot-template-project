package org.home.service.impl;

import org.home.TestcontainersConfiguration;
import org.home.properties.ApplicationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MonitoringServiceTest
        extends TestcontainersConfiguration {

    @Autowired
    private MonitoringService service;

    @MockBean
    private ApplicationProperties properties;

    @Test
    void testVersion() {
        final String fromProperties = UUID.randomUUID().toString();

        when(properties.getVersion())
                .thenReturn(fromProperties);

        final String version = service.getVersion();

        assertEquals(fromProperties, version);
    }
}
