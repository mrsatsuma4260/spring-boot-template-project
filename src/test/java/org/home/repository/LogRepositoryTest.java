package org.home.repository;

import org.home.TestcontainersConfiguration;
import org.home.domain.LogEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LogRepositoryTest
        extends TestcontainersConfiguration {

    @Autowired
    private LogRepository repository;

    @Test
    void testSave() {
        final String text = UUID.randomUUID().toString();

        final LogEntity log = new LogEntity();
        log.setText(text);

        final LogEntity saved = repository.saveAndFlush(log);
        assertNotNull(saved.getUuid());
        assertEquals(text, saved.getText());
    }
}
