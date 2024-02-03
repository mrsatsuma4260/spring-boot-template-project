package org.home.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
@Getter
@Setter
public class DatabaseProperties {

    private String url;

    private String user;

    private String password;
}
