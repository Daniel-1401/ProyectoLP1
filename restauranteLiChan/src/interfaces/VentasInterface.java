package interfaces;

import java.util.ArrayList;

import modelos.ProductosSeleccionados_Temporal;

public interface VentasInterface {
	
	public String generaNumeroBoleta();
	
	public ArrayList<ProductosSeleccionados_Temporal> lstProductosSeleccionados();
	public int insertarProductosSeleccionadosTemporal(ProductosSeleccionados_Temporal p);
}
