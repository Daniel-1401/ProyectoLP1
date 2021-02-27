package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentasInterface;
import modelos.ProductosSeleccionados_Temporal;
import utils.ConectorBD;

public class GestionVenta implements VentasInterface {

/******* BOLETA ****/
	
	public String generaNumeroBoleta() {
		String numBol = null; 

		Connection con = null;  
		PreparedStatement pst = null;  
		ResultSet rs = null;  

		try {

			con = ConectorBD.getConexion();

			String sql = "select substring(max(idBoleta),2) from tb_boleta";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();  

			if (rs.next()) {
				numBol = String.format("B%04d", rs.getInt(1)+1); 
			}
			
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}

		return numBol;
	}

	@Override
	public ArrayList<ProductosSeleccionados_Temporal> lstProductosSeleccionados() {
		ArrayList<ProductosSeleccionados_Temporal> lista = new ArrayList<ProductosSeleccionados_Temporal>();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "tb_ClienteProducto_Temporal";
			ejecutor = conexion.prepareStatement(sentencia);
			rs = ejecutor.executeQuery();
			while(rs.next()) {
				ProductosSeleccionados_Temporal nuevo = new ProductosSeleccionados_Temporal();
				nuevo.setIdBoleta(rs.getString(2));
				nuevo.setIdCliente(rs.getString(3));
				nuevo.setIdProducto(rs.getString(4));
				nuevo.setCantidadProducto(rs.getInt(5));
				nuevo.settotalProductoSeleccionado(rs.getDouble(6));
				nuevo.setNombreProducto(rs.getString(7));
				nuevo.setPrecioUnitProducto(rs.getDouble(8));
				lista.add(nuevo);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL LISTAR PRODUCTOS TEMPORALES");
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR CONEXION: " + se.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public int insertarProductosSeleccionadosTemporal(ProductosSeleccionados_Temporal p) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_productoClienteTemporal(?,?,?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, p.getIdBoleta());
			ejecutor.setString(2, p.getIdCliente());
			ejecutor.setString(3, p.getIdProducto());
			ejecutor.setInt(4, p.getCantidadProducto());
			ejecutor.setDouble(5, p.gettotalProductoSeleccionado());
			ejecutor.setString(6, p.getNombreProducto());
			ejecutor.setDouble(7, p.getPrecioUnitProducto());
			
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR ADMINISTRADOR: " + e.getMessage());
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
}
