package pe.joedayz.joefact.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * Created by Celeritech Peru on 18/08/2015.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private final String internoEmpresa;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        internoEmpresa = request.getParameter("internoEmpresa_input");

    }

    public String getyourParameter() {
        return internoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        CustomWebAuthenticationDetails that = (CustomWebAuthenticationDetails) o;

        return !(internoEmpresa != null ? !internoEmpresa.equals(that.internoEmpresa) : that.internoEmpresa != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (internoEmpresa != null ? internoEmpresa.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomWebAuthenticationDetails{"
                + "yourParameter='" + internoEmpresa + '\''
                + '}';
    }
}
