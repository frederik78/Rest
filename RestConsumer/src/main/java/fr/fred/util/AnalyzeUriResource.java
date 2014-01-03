package fr.fred.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Frederic on 31/12/13.
 */
public class AnalyzeUriResource {

    /**
     * Id dans la resource demandée
     */
    private Long id;

    /**
     * Nom de la resource demandée
     */
    private String resource;

    public AnalyzeUriResource(HttpServletRequest req) throws ServletException {

        final Pattern regExForAll = Pattern.compile("^" + req.getServletPath() + "/(\\w*)$|^" + req.getServletPath() + "$" );
        final Pattern regExForId = Pattern.compile("^" + req.getServletPath() + "/(\\w*)/(\\d*)$");

        Matcher matcher = regExForId.matcher(req.getRequestURI());
        if (matcher.find()) {
            resource = matcher.group(1);
            id = Long.parseLong(matcher.group(2));
        } else {
            matcher = regExForAll.matcher(req.getRequestURI());
            if (matcher.find()) {
                resource = matcher.group(1) != null ? matcher.group(1) : StringUtils.EMPTY;
                id = NumberUtils.LONG_ZERO;
            }else
            {
                throw new ServletException("Mauvaise URI");
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getResource() {
        return resource;
    }
}