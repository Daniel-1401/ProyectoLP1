package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class FrmRegistroEmpleado extends JInternalFrame implements ActionListener {
	private JButton btnCerrar;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTipodocumentp;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblGenero;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblNumeroDeDoc;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNroDocumento;
	private JTextField txtGenero;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JComboBox cboTipoDocumento;
	private JDateChooser dtFecha;
	private JLabel lblSueldo;
	private JTextField txtSueldo;
	private JLabel lblNumeroDeHoras;
	private JTextField txtNumHorasPorDia;
	private JLabel lblDiasLaborales;
	private JTextField txtDiasLaborales;
	private JLabel lblPagoPorHora;
	private JTextField txtPagoPorHora;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnNuevoRegistro;
	public static int OpcionEmpleado = 1;
	private String Titulo = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroEmpleado frame = new FrmRegistroEmpleado();
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
	public FrmRegistroEmpleado() {
		setBounds(100, 100, 568, 485);
		switch(OpcionEmpleado) {
		case 1:
			Titulo = "REGISTRAR ADMINISTRADOR";
				break;
		default:	
			Titulo = "REGISTRAR RECEPCIONISTA";
				break;
		}
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setRolloverIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setPressedIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(473, 10, 28, 28);
		getContentPane().add(btnCerrar);
		
		lblNewLabel = new JLabel(Titulo);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(75, 10, 334, 63);
		getContentPane().add(lblNewLabel);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCodigo.setBounds(10, 83, 200, 20);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombres.setBounds(10, 113, 200, 20);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApellidos.setBounds(10, 143, 200, 20);
		getContentPane().add(lblApellidos);
		
		lblTipodocumentp = new JLabel("TipoDocumento");
		lblTipodocumentp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipodocumentp.setBounds(10, 173, 200, 20);
		getContentPane().add(lblTipodocumentp);
		
		lblNumeroDeDoc = new JLabel("Numero de Documento:");
		lblNumeroDeDoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumeroDeDoc.setBounds(10, 203, 200, 20);
		getContentPane().add(lblNumeroDeDoc);

		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(10, 233, 200, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGenero.setBounds(10, 263, 200, 20);
		getContentPane().add(lblGenero);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(10, 293, 200, 20);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(10, 323, 200, 20);
		getContentPane().add(lblContrasea);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(220, 83, 150, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(220, 113, 150, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(220, 143, 150, 20);
		getContentPane().add(txtApellidos);
		
		cboTipoDocumento = new JComboBox();
		cboTipoDocumento.setBounds(220, 173, 150, 20);
		getContentPane().add(cboTipoDocumento);

		txtNroDocumento = new JTextField();
		txtNroDocumento.setColumns(10);
		txtNroDocumento.setBounds(220, 203, 150, 20);
		getContentPane().add(txtNroDocumento);

		dtFecha = new JDateChooser();
		dtFecha.setBounds(220, 233, 150, 20);
		getContentPane().add(dtFecha);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(220, 263, 150, 20);
		getContentPane().add(txtGenero);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(220, 293, 150, 20);
		getContentPane().add(txtUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 323, 150, 20);
		getContentPane().add(passwordField);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnEliminar.setBounds(381, 80, 165, 50);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnActualizar.setBounds(381, 140, 165, 50);
		getContentPane().add(btnActualizar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnBuscar.setBounds(381, 200, 165, 50);
		getContentPane().add(btnBuscar);

		
		switch(OpcionEmpleado) {
			case 1:
				
				lblSueldo = new JLabel("Sueldo:");
				lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSueldo.setBounds(10, 353, 200, 20);
				getContentPane().add(lblSueldo);
				
				txtSueldo = new JTextField();
				txtSueldo.setColumns(10);
				txtSueldo.setBounds(220, 353, 150, 20);
				getContentPane().add(txtSueldo);
				
				btnNuevoRegistro = new JButton("NUEVO REGISTRO");
				btnNuevoRegistro.addActionListener(this);
				btnNuevoRegistro.setFont(new Font("Verdana", Font.BOLD, 13));
				btnNuevoRegistro.setBounds(380, 260, 165, 50);
				getContentPane().add(btnNuevoRegistro);
				
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.addActionListener(this);
				btnRegistrar.setFont(new Font("Verdana", Font.BOLD, 13));
				btnRegistrar.setBounds(380, 320, 165, 50);
				getContentPane().add(btnRegistrar);

				break;
			case 2:
				lblNumeroDeHoras = new JLabel("Numero de horas por dia");
				lblNumeroDeHoras.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNumeroDeHoras.setBounds(10, 353, 200, 20);
				getContentPane().add(lblNumeroDeHoras);
				
				txtNumHorasPorDia = new JTextField();
				txtNumHorasPorDia.setColumns(10);
				txtNumHorasPorDia.setBounds(220, 353, 150, 20);
				getContentPane().add(txtNumHorasPorDia);
				
				lblDiasLaborales = new JLabel("Dias laborales:");
				lblDiasLaborales.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblDiasLaborales.setBounds(10, 383, 200, 20);
				getContentPane().add(lblDiasLaborales);
				
				txtDiasLaborales = new JTextField();
				txtDiasLaborales.setColumns(10);
				txtDiasLaborales.setBounds(220, 383, 150, 20);
				getContentPane().add(txtDiasLaborales);
				
				lblPagoPorHora = new JLabel("Pago por hora:");
				lblPagoPorHora.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblPagoPorHora.setBounds(10, 413, 200, 20);
				getContentPane().add(lblPagoPorHora);
				
				txtPagoPorHora = new JTextField();
				txtPagoPorHora.setColumns(10);
				txtPagoPorHora.setBounds(220, 413, 150, 20);
				getContentPane().add(txtPagoPorHora);
				
				btnNuevoRegistro = new JButton("NUEVO REGISTRO");
				btnNuevoRegistro.setFont(new Font("Verdana", Font.BOLD, 13));
				btnNuevoRegistro.addActionListener(this);
				btnNuevoRegistro.setBounds(380, 308, 165, 50);
				getContentPane().add(btnNuevoRegistro);
				
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.setFont(new Font("Verdana", Font.BOLD, 13));
				btnRegistrar.addActionListener(this);
				btnRegistrar.setBounds(381, 383, 165, 50);
				getContentPane().add(btnRegistrar);
				break;
		}

		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedbtnRegistrar(arg0);
		}
		if (arg0.getSource() == btnNuevoRegistro) {
			actionPerformedbtnNuevoRegistro(arg0);
		}
	}
	protected void btnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
	}
	protected void actionPerformedbtnRegistrar(ActionEvent arg0) {
	}
	protected void actionPerformedbtnNuevoRegistro(ActionEvent arg0) {
		dispose();
		frmPrincipal.panelContenedor.removeAll();
		FrmRegistroEmpleadosMenu frm = new FrmRegistroEmpleadosMenu();
		frm.setBounds(100, 100, 480, 300);
		frmPrincipal.panelContenedor.add(frm);
		frm.setVisible(true);
		
	}
}
