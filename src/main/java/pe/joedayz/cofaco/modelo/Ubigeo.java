package pe.joedayz.cofaco.modelo;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ubigeo")
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long idUbigeo;
    private String codigoUbigeo;
    private String nombreUbigeo;



    @Id
    @GeneratedValue
    @Column(name = "id_ubigeo", nullable = false, length = 10)
    public Long getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(Long idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    @NotBlank
    @Column(name = "codigo_ubigeo", nullable = false, unique = true, length = 6)
    public String getCodigoUbigeo() {
        return codigoUbigeo;
    }

    public void setCodigoUbigeo(String codigoUbigeo) {
        this.codigoUbigeo = codigoUbigeo;
    }


    @NotBlank
    @Column(name = "nombre_ubigeo", nullable = false, length = 50)
    public String getNombreUbigeo() {
        return nombreUbigeo;
    }

    public void setNombreUbigeo(String nombreUbigeo) {
        this.nombreUbigeo = nombreUbigeo;
    }

    @Override
    public String toString() {
        return "Ubigeo{" +
                "idUbigeo=" + idUbigeo +
                ", codigoUbigeo='" + codigoUbigeo + '\'' +
                ", nombreUbigeo='" + nombreUbigeo + '\'' +
                '}';
    }
}
