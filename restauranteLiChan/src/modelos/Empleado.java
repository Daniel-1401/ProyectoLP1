package modelos;

public class Empleado {
	  private String idEmpleado;
	  private String nombreEmpleado;
	  private String apellidoEmpleado;
	  private int idTipoDocumento;
	  private String numeroDocumento;
	  private String fechaNacimiento;
	  private int idCargo;
	  private String genero;
	  private String estado;
	  private int idUsuario;
	  private double sueldoAdmin;
	  private int numHorasPorDiaRecep;
	  private int diasLaboralesRecep;
	  private double pagoPorHoraRecep;
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Empleado(String idEmpleado, String nombreEmpleado, String apellidoEmpleado, int idTipoDocumento,
			String numeroDocumento, String fechaNacimiento, int idCargo, String genero, String estado, int idUsuario) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.idCargo = idCargo;
		this.genero = genero;
		this.estado = estado;
		this.idUsuario = idUsuario;
	}
	
	public Empleado(String idEmpleado, String nombreEmpleado, String apellidoEmpleado, int idTipoDocumento,
			String numeroDocumento, String fechaNacimiento, int idCargo, String genero, String estado, int idUsuario,
			double sueldoAdmin) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.idCargo = idCargo;
		this.genero = genero;
		this.estado = estado;
		this.idUsuario = idUsuario;
		this.sueldoAdmin = sueldoAdmin;
	}
	
	public Empleado(String idEmpleado, String nombreEmpleado, String apellidoEmpleado, int idTipoDocumento,
			String numeroDocumento, String fechaNacimiento, int idCargo, String genero, String estado, int idUsuario,
			int numHorasPorDiaRecep, int diasLaboralesRecep, double pagoPorHoraRecep) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.idCargo = idCargo;
		this.genero = genero;
		this.estado = estado;
		this.idUsuario = idUsuario;
		this.numHorasPorDiaRecep = numHorasPorDiaRecep;
		this.diasLaboralesRecep = diasLaboralesRecep;
		this.pagoPorHoraRecep = pagoPorHoraRecep;
	}
	public Empleado() {
		super();
	}
	
}
