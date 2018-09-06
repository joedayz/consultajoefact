package pe.joedayz.joefact.modelo;

public enum TipoEmpresaApp {

	INTERNO("Interno"), EXTERNO("Externo");



    private String descripcion;

    TipoEmpresaApp(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
