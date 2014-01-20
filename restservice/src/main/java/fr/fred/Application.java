package fr.fred;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String [] args)
    {

        final SpringApplication app = new SpringApplication(Application.class);
       final Map<String, Object> parameters = getProperties();
        app.setDefaultProperties(parameters);
        app.run();
    }

   private static Map<String, Object> getProperties()
   {
      final Properties prop = new Properties();
      InputStream input = null;
      final Map<String, Object> parameters = new HashMap<String, Object>();

      try {

         input = Application.class.getResourceAsStream("application.properties");

         // load a properties file
         prop.load(input);

         // get the property value and print it out
         final int serverPort = StringUtils.isNumeric(prop.getProperty("server.port")) ? Integer.valueOf(prop.getProperty("server.port")) : 8181;
         final String serverHost = StringUtils.isNotEmpty(prop.getProperty("server.address")) ? prop.getProperty("server.address") : "localhost";
         parameters.put("server.port", serverPort);
         parameters.put("server.address", serverHost);

      } catch (IOException ex) {
         ex.printStackTrace();
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      return parameters;
   }
}
