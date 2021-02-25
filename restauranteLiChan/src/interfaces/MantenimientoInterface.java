package interfaces;

import java.util.ArrayList;

import modelos.RegistroCliente;
import modelos.TipoDocumento;

public interface MantenimientoInterface {
	
	/********* Cliente ***********/
	public ArrayList<TipoDocumento> listadoDeDocumento();
	
	public String generarCodigoCliRegistro();
	
	public int registro(RegistroCliente r);
	
	public int eliminar(int idCliente);
	

}
