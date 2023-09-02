package authorization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    public final String env;
    public final String baseUrl;
    public final String username;
    public final String userPassword;

    private static final String ENV_NAME = "ACTIVE_ENVIRONMENT";

    public ApplicationConfig() {
        String getenv = System.getenv(ENV_NAME);
        if (getenv == null) env = "default";
        else env = getenv;
        Properties properties = parseProperties();
        this.baseUrl = properties.getProperty("base.url");
        this.username =  properties.getProperty("user.login");
        this.userPassword = properties.getProperty("user.password");

    }

    public Properties parseProperties() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(env + ".properties")

        ) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
