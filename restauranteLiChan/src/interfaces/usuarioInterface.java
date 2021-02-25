package interfaces;

import modelos.Empleado;

public interface usuarioInterface {
	public Empleado loginAccess(String user, String password);
}
