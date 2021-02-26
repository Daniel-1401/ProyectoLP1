package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import interfaces.EmpleadoInterface;
import modelos.Empleado;
import modelos.TipoCargo;
import modelos.TipoDocumento;
import modelos.Usuario;
import utils.ConectorBD;

public class GestionEmpleado implements EmpleadoInterface{

	@Override
	public int registrarEmpleado(Empleado em, Usuario us) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_empleadoUsuario (?,?,?,?,?,?,?,?,?,?,?,?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, em.getIdEmpleado());
			ejecutor.setString(2, em.getNombreEmpleado());
			ejecutor.setString(3, em.getApellidoEmpleado());
			ejecutor.setInt(4, em.getIdTipoDocumento());
			ejecutor.setString(5, em.getNumeroDocumento());
			ejecutor.setString(6, em.getFechaNacimiento());
			ejecutor.setInt(7, em.getIdCargo());
			ejecutor.setString(8, em.getGenero());
			ejecutor.setString(9, em.getEstado());
			ejecutor.setInt(10, em.getIdUsuario());
			ejecutor.setString(11, us.getLogin());
			ejecutor.setString(12, us.getPassword());
			
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION : " + se.getMessage());
			}
		}
 		return ok;
	}

	@Override
	public int eliminarEmpleado(Empleado em) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL del_Empleado (?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, em.getIdEmpleado());
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRA LA CONEXION: " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public int actualizarEmpledo(Empleado e, Usuario u) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL upd_Empleado(?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, e.getIdEmpleado());
			ejecutor.setString(2, e.getNombreEmpleado());
			ejecutor.setString(3, e.getApellidoEmpleado());
			ejecutor.setString(4, e.getEstado());
			ejecutor.setString(5, u.getPassword());
			ok = ejecutor.executeUpdate();
		}catch (Exception ex) {
			System.out.println("ERROR AL ACTUALIZAR: " + ex.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR CONEXIO: " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public Empleado obtener(String id) {
		Empleado empleado = new Empleado();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT * FROM `tb_empleado` WHERE `tb_empleado`.`idEmplEado` = ?";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, id);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				empleado.setIdEmpleado(rs.getString(1));
				empleado.setNombreEmpleado(rs.getString(2));
				empleado.setApellidoEmpleado(rs.getString(3));
				empleado.setIdTipoDocumento(rs.getInt(4));
				empleado.setNumeroDocumento(rs.getString(5));
				empleado.setFechaNacimiento(rs.getString(6));
				empleado.setIdCargo(rs.getInt(7));
				empleado.setGenero(rs.getString(8));
				empleado.setEstado(rs.getString(9));
				empleado.setIdUsuario(rs.getInt(10));
			}
		}catch (Exception e) {
			System.out.println("ERROR AL BUSCAR EMPLEADO: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException ex) {
				System.out.println("ERRO AL CERRAR CONEXION: " + ex.getMessage());
			}
		}
		return empleado;
	}

	@Override
	public ArrayList<TipoDocumento> listadoTipoDocumento() {
		ArrayList<TipoDocumento> lista = null;
		Connection conexion = null; 
		PreparedStatement ejecutor = null; 
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sql = "select * from tb_tipo_documento";
			ejecutor = conexion.prepareStatement(sql);
			rs = ejecutor.executeQuery();
			lista = new ArrayList<>();
			while (rs.next()) {
				TipoDocumento td = new TipoDocumento();
				td.setIdTipoDocumento(rs.getInt(1));
				td.setDescripcion(rs.getString(2));
				lista.add(td);				
			}
		} catch (Exception e) {
			System.out.println("Error en COMBO por Tipo de Documento: " + e.getMessage());
		} finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}		
		return lista;
	}

	@Override
	public String generarCodigo(int cargo) {
		String codigo = null;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT SUBSTRING(MAX(`tb_empleado`.`idEmpleado`),2) FROM `tb_empleado` WHERE `tb_empleado`.`idCargo` = ? ";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setInt(1, cargo);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				switch(cargo) {
				case 1:
					codigo = String.format("A%04d", rs.getInt(1)+1); break;
				case 2:
					codigo = String.format("R%04d", rs.getInt(1)+1); break;
				default:
					codigo = ("ERROR");break;
				}
			}
		}catch (Exception e) {
			System.out.print("ERROR AL GENERAR CODIGO: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException ex) {
				System.out.println("ERROR AL CERRAR CONEXION: " + ex.getMessage());
			}
		}
		return codigo;
	}

	@Override
	public ArrayList<TipoCargo> listadoTipoCargo() {
		ArrayList<TipoCargo> lstCargo = new ArrayList<TipoCargo>();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT * FROM `tb_cargo`";
			ejecutor = conexion.prepareStatement(sentencia);
			rs = ejecutor.executeQuery();
			while(rs.next()) {
				TipoCargo tipoCargo = new TipoCargo();
				tipoCargo.setIdCargo(rs.getInt(1));
				tipoCargo.setDescripcion(rs.getString(2));
				lstCargo.add(tipoCargo);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL LISTAR TIPOS DE CARGO: " +e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION: " + se.getMessage());
			}
		}
		return lstCargo;
	}
}
