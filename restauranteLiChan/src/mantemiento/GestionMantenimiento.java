package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.MantenimientoInterface;
import modelos.RegistroCliente;
import modelos.TipoDocumento;
import utils.ConectorBD;

public class GestionMantenimiento implements MantenimientoInterface{


	public ArrayList<TipoDocumento> listadoDeDocumento() {
		
		ArrayList<TipoDocumento> lista = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null;
		
		try {
			con = ConectorBD.getConexion();
			String sql = "select * from tb_tipo_documento";
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			
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
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}		
	
		return lista;
	}

	
	public String generarCodigoCliRegistro(){
		String codigo = null;
		
		Connection con = null;  
		PreparedStatement pst = null;  
		ResultSet rs = null;
		
		try {

			con = ConectorBD.getConexion();
			String sql = "select substring(max(idCliente),2) from tb_clientes";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();  

			if (rs.next()) {
				
				codigo = String.format("C%04d", rs.getInt(1)+1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en generarNumeroRegistro : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}
				
		return codigo;
	}


	/**** Registro Cliente  *****/
	
	public int registro(RegistroCliente r) {
		int rs = 0;
		
		Connection con = null;  
		PreparedStatement pst1 = null;
		
		try {
			con = ConectorBD.getConexion();
			con.setAutoCommit(false);
			
			String sql1 = "INSERT INTO tb_clientes VALUES (?,?,?,?,?,?,?)";
			pst1 = con.prepareStatement(sql1);
			
			pst1.setString(1, r.getIdCliente());
			pst1.setString(2, r.getNombreCliente());
			pst1.setString(3, r.getApellidoCliente());
			pst1.setString(4, r.getDireccionCliente());
			pst1.setInt(5, r.getNumeroTelefonico());
			pst1.setInt(6, r.getIdtipoDocumento());
			pst1.setString(7, r.getNumeroDocumento());


			rs = pst1.executeUpdate(); 
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error en REGISTRO DE CITA: " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("ERROR EN EL REGISTRO DE CITA" +e1.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}			
		
		return rs;
	}



	
	
	public int eliminar(int idCliente) {
		int rs = 0;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "delete from tb_clientes where idCliente = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, idCliente);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Eliminar: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return rs;
	}



	
	
	
	
	

}
