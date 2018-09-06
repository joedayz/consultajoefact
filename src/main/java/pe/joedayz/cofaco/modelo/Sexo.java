package pe.joedayz.cofaco.modelo;

public enum Sexo {

	MASCULINO("Masculino"), FEMENINO("Femenino");



    private String descripcion;

    Sexo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
