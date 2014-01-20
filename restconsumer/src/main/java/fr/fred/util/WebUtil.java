package fr.fred.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Frederic on 04/01/14.
 */
public class WebUtil {

    /**
     * Ressource distante
     */
   public static final String SERVICE_LOCATION = getServiceLocation();

    /**
     * Analyse la requete REST
     * @param req requete HTTP
     * @return le type de ressource à utiliser ainsi que l'id de cette ressource si c'est nécessaire
     * @throws ServletException en cas d'erreur dans la requete passée
     */
    public static AnalyzeUriResource analyzeUriResource(HttpServletRequest req) throws ServletException {
        return new AnalyzeUriResource(req);
    }

   private static String getServiceLocation()
   {
      final Properties prop = new Properties();
      InputStream input = null;
      String serviceLocation = "";
      try {

         input = WebUtil.class.getResourceAsStream("/application.properties");

         // load a properties file
         prop.load(input);

         // get the property value and print it out
         final int serverPort = StringUtils.isNumeric(prop.getProperty("remote.server.port")) ? Integer.valueOf(prop.getProperty("remote.server.port")) : 8181;
         final String serverHost = StringUtils.isNotEmpty(prop.getProperty("remote.server.address")) ? prop.getProperty("remote.server.address") : "localhost";
         serviceLocation = "http://"+serverHost+":"+serverPort;

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
      return serviceLocation;
   }
}
