package pe.joedayz.joefact.modelo;

import java.util.Date;

/**
 * Created by awusr on 07/05/2016.
 */

public interface BaseEntity {

    public String getCreatedBy();

    public void setCreatedBy(String createdBy);

    public Date getCreatedDate() ;

    public void setCreatedDate(Date createdDate);

    public String getUpdatedBy();

    public void setUpdatedBy(String updatedBy);

    public Date getUpdatedDate();

    public void setUpdatedDate(Date updatedDate);

}

