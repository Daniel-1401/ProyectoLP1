package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import mantemiento.GestionMantenimiento;
import modelos.RegistroCliente;
import modelos.TipoDocumento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JTextField txtApellidoCli;
	private JTextField txtDirecCli;
	private JTextField txtTelef;
	private JTextField txtNumDoc;
	private JComboBox cboDocumento;
	private JTextField txtNombreCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroCliente frame = new FrmRegistroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Clientes");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(162, 19, 238, 19);
		contentPane.add(lblNewLabel);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setEditable(false);
		txtCodCliente.setColumns(10);
		txtCodCliente.setBounds(166, 56, 155, 20);
		contentPane.add(txtCodCliente);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Cliente:");
		lblNewLabel_1.setBounds(40, 59, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBounds(40, 122, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellidoCli = new JTextField();
		txtApellidoCli.setColumns(10);
		txtApellidoCli.setBounds(164, 122, 157, 20);
		contentPane.add(txtApellidoCli);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1_2.setBounds(40, 161, 101, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtDirecCli = new JTextField();
		txtDirecCli.setColumns(10);
		txtDirecCli.setBounds(163, 164, 158, 20);
		contentPane.add(txtDirecCli);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
				txtCodCliente.setEditable(true);
			}
		});
		btnEliminar.setBounds(390, 53, 107, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(389, 88, 108, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(388, 127, 108, 23);
		contentPane.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoCliente();
			}
		});
		btnLimpiar.setBounds(297, 327, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro();

			}
		});
		btnRegistrar.setBounds(123, 327, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_1_2_1.setBounds(40, 200, 101, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tipo de Documento:");
		lblNewLabel_1_2_2.setBounds(40, 232, 114, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Num Documento:");
		lblNewLabel_1_2_3.setBounds(40, 264, 101, 14);
		contentPane.add(lblNewLabel_1_2_3);
		
		txtTelef = new JTextField();
		txtTelef.setColumns(10);
		txtTelef.setBounds(163, 200, 158, 20);
		contentPane.add(txtTelef);
		
		txtNumDoc = new JTextField();
		txtNumDoc.setColumns(10);
		txtNumDoc.setBounds(163, 267, 158, 20);
		contentPane.add(txtNumDoc);
		
		cboDocumento = new JComboBox();
		cboDocumento.setBounds(163, 234, 158, 22);
		contentPane.add(cboDocumento);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1_1.setBounds(40, 87, 85, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtNombreCli = new JTextField();
		txtNombreCli.setColumns(10);
		txtNombreCli.setBounds(164, 87, 157, 20);
		contentPane.add(txtNombreCli);
		setLocationRelativeTo(null);
		
		listadoCombo();
		txtCodCliente.setText(ObtenerCodigoCliente());
	}
	
	void registro() {
		
		String idCliente, nombreCli, apellidoCli, direcCli, numDocumento;
		int numeroTel, idtipoDocumento;
		
		idCliente = leerCodCliente();
		nombreCli = leerNombreCli();
		apellidoCli = leerApellidoCli();
		direcCli = leerDirecCli();
		numDocumento = leerNumDocumento();
		numeroTel = leerNumeroTel();
		idtipoDocumento = leerIdTipoDocumento();
		
		RegistroCliente rc = new RegistroCliente();
		rc.setIdCliente(idCliente);
		rc.setNombreCliente(nombreCli);
		rc.setApellidoCliente(apellidoCli);
		rc.setDireccionCliente(direcCli);
		rc.setNumeroTelefonico(numeroTel);
		rc.setIdtipoDocumento(idtipoDocumento);
		rc.setNumeroDocumento(numDocumento);
		
		
		if (idCliente == null || nombreCli == null || apellidoCli == null || direcCli == null || numeroTel == 0
				|| idtipoDocumento == 0 || numDocumento == null) {
			JOptionPane.showMessageDialog(this, "Ingrese TODOS los datos requeridos");
		}else {
			GestionMantenimiento gm = new GestionMantenimiento();
			int rs = gm.registro(rc);
			JOptionPane.showMessageDialog(this, "Cliente " + "'" + rc.getNombreCliente() + " " 
										+ rc.getApellidoCliente() + "'" + " Registrado");
			nuevoCliente();
		}
		
	}
	
	void eliminarCliente() {
		
		
		
	}
	
	/******* NUEVO CLIENTE *******/
	void nuevoCliente() {
		txtNombreCli.setText("");
		txtApellidoCli.setText("");
		txtNumDoc.setText("");
		txtDirecCli.setText("");
		txtTelef.setText("");
		
		cboDocumento.setSelectedItem("--> Seleccione");
		txtCodCliente.setText(ObtenerCodigoCliente());
	}
	
	
	/******* COMBO *******/
	void listadoCombo() {
		ArrayList<TipoDocumento> lstTdocumento = new GestionMantenimiento().listadoDeDocumento();
		
		cboDocumento.addItem("--> Seleccione");
		for (TipoDocumento td : lstTdocumento) {
			cboDocumento.addItem(td.getIdTipoDocumento() + ".- " + td.getDescripcion());
		}
	}
	
	
	/***** Numero de Registro   *********/
	private String ObtenerCodigoCliente() {
		return new GestionMantenimiento().generarCodigoCliRegistro();
	}
	
	/****** Validaion **********/
	private String leerCodCliente() {
		
		return txtCodCliente.getText();
	}

	private String leerNombreCli() {
		
		if (txtNombreCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Nombre es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtNombreCli.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Nombre", "Aviso", 2);
			return null;
		}
		return txtNombreCli.getText();
	}

	private String leerApellidoCli() {
		
		if (txtApellidoCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Apellido es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtApellidoCli.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el APELLIDO", "Aviso", 2);
			return null;
		}
		
		return txtApellidoCli.getText();
	}

	private String leerDirecCli() {
		
		if (txtDirecCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "La dirección es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtDirecCli.getText().matches("^[a-zA-Záéíóú0-9. ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en la DIRECCIÓN", "Aviso", 2);
			return null;
		}
		
		return txtDirecCli.getText();
		
	}
	
	private int leerIdTipoDocumento() {
		if (cboDocumento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Documento", "Aviso",2);
			return 0;
		}
		return cboDocumento.getSelectedIndex();
	}

	private String leerNumDocumento() {
		
		if (txtNumDoc.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "El número de Documento es un campo OBLIGATORIO");
			return null;
			
		}else {
			switch (cboDocumento.getSelectedItem() + "" ) {
			
			case "DNI": {
				if(!txtNumDoc.getText().matches("^[0-9]{​​​​​8}​​​​​​$")) {
					JOptionPane.showMessageDialog(this, "DNI incorrecto", "Aviso", 2);
					return null;
				}
			}
			case "PASAPORTE":
				if(!txtNumDoc.getText().matches("^[A-Z]{​​​​​1}​​​​​​[0-9]$")) {
					JOptionPane.showMessageDialog(this, "Pasaporte Incorrecto", "Aviso", 2);
					return null;
				}
			}
		}


		return txtNumDoc.getText();
	}

	private int leerNumeroTel() {
		
		if (txtTelef.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "El número de Teléfono es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtTelef.getText().matches("^[0-9]{9}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el Telefono", "Aviso", 2);
			return 0;
		}

		return Integer.parseInt(txtTelef.getText());
	}

	

	
}
