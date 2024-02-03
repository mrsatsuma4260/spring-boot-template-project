package org.home;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {TestcontainersConfiguration.Initializer.class})
public class TestcontainersConfiguration {

    private static final String DATABASE_NAME = "postgres";
    @Container
    public static PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>("postgres:15-alpine")
                    .withReuse(true)
                    .withDatabaseName(DATABASE_NAME);

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(final ConfigurableApplicationContext context) {
            TestPropertyValues.of(
                            "database.datasource.username=" + container.getUsername(),
                            "database.datasource.password=" + container.getPassword(),
                            "database.datasource.jdbcUrl=" + container.getJdbcUrl())
                    .applyTo(context.getEnvironment());
        }
    }
}