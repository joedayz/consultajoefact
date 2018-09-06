package pe.joedayz.cofaco.modelo;

public enum EstadoCabecera {



		B("Bloqueo"), P("Proceso"), E("Enviado"), X("Error de Envío");
		
	
		private String descripcion;
		
		EstadoCabecera(String descripcion){
			this.descripcion = descripcion;
		}
		
		public String getDescripcion(){
			return descripcion;
		}
		
	

}
