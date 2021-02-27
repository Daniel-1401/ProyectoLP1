package modelos;

public class ProductosSeleccionados_Temporal {
	  private String idBoleta;
	  private String idCliente;
	  private String idProducto;
	  private int CantidadProducto;
	  private double totalProductoSeleccionado;
	  private String NombreProducto;
	  private double PrecioUnitProducto;
	
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidadProducto() {
		return CantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}
	public double gettotalProductoSeleccionado() {
		return totalProductoSeleccionado;
	}
	public void settotalProductoSeleccionado(double totalProductoSeleccionado) {
		totalProductoSeleccionado = totalProductoSeleccionado;
	}
	public String getNombreProducto() {
		return NombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}
	public double getPrecioUnitProducto() {
		return PrecioUnitProducto;
	}
	public void setPrecioUnitProducto(double precioUnitProducto) {
		PrecioUnitProducto = precioUnitProducto;
	}
	public ProductosSeleccionados_Temporal(String idBoleta, String idCliente, String idProducto,
			int cantidadProducto, double totalProductoSeleccionado, String nombreProducto, double precioUnitProducto) {
		super();
		this.idBoleta = idBoleta;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		CantidadProducto = cantidadProducto;
		totalProductoSeleccionado = totalProductoSeleccionado;
		NombreProducto = nombreProducto;
		PrecioUnitProducto = precioUnitProducto;
	}
	public ProductosSeleccionados_Temporal() {
		super();
	}
	  

}
