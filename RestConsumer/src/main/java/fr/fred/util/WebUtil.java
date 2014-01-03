package fr.fred.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Frederic on 04/01/14.
 */
public class WebUtil {

    /**
     * Ressource distante
     */
    public static final String SERVICE_LOCATION = "http://localhost:971";

    /**
     * Analyse la requete REST
     * @param req requete HTTP
     * @return le type de ressource à utiliser ainsi que l'id de cette ressource si c'est nécessaire
     * @throws ServletException en cas d'erreur dans la requete passée
     */
    public static AnalyzeUriResource analyzeUriResource(HttpServletRequest req) throws ServletException {
        return new AnalyzeUriResource(req);
    }
}
