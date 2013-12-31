import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String [] args)
    {

        final SpringApplication app = new SpringApplication(Application.class);
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("server.port", 971);
        app.setDefaultProperties(parameters);
        app.run();
    }
}
