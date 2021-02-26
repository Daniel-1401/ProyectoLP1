package interfaces;

import java.util.ArrayList;

import modelos.Empleado;
import modelos.TipoCargo;
import modelos.TipoDocumento;
import modelos.Usuario;

public interface EmpleadoInterface {
	public int registrarEmpleado(Empleado e, Usuario u);
	public int eliminarEmpleado(Empleado e);
	public int actualizarEmpledo(Empleado e, Usuario u);
	public Empleado obtener(String id);
	public ArrayList<TipoDocumento> listadoTipoDocumento();
	public ArrayList<TipoCargo> listadoTipoCargo();
	public String generarCodigo(int cargo);
}
