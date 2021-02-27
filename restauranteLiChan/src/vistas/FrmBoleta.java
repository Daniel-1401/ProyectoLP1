package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantemiento.GestionMantenimiento;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmBoleta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumBoleta;
	private JTextField txtFecha;
	public static JTextField txtNomCliente;
	public static JTextField txtidCliente;
	public static JTextField txtFelefono;
	public static JTextField txtDocumento;
	public static JTextField txtDireccion;
	private JTextField txtCantidad;
	public static JTextField txtNomProducto;
	public static JTextField txtPrecioProducto;
	private JTable tblSalida;
	private JTextField txtTotal;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta frame = new FrmBoleta();
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
	public FrmBoleta() {
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chifa Li Chan");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(261, 11, 197, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(29, 131, 675, 99);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Id Cliente:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(328, 27, 68, 19);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(10, 27, 135, 19);
		panel_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(444, 63, 68, 19);
		panel_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2.setBounds(10, 63, 135, 19);
		panel_1.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Documento:");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2_1.setBounds(233, 63, 135, 19);
		panel_1.add(lblNewLabel_2_2_2_1);
		
		txtNomCliente = new JTextField();
		txtNomCliente.setEditable(false);
		txtNomCliente.setBounds(70, 28, 248, 20);
		panel_1.add(txtNomCliente);
		txtNomCliente.setColumns(10);
		
		txtidCliente = new JTextField();
		txtidCliente.setEditable(false);
		txtidCliente.setBounds(398, 28, 86, 20);
		panel_1.add(txtidCliente);
		txtidCliente.setColumns(10);
		
		txtFelefono = new JTextField();
		txtFelefono.setEditable(false);
		txtFelefono.setBounds(70, 64, 153, 20);
		panel_1.add(txtFelefono);
		txtFelefono.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setEditable(false);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(318, 64, 116, 20);
		panel_1.add(txtDocumento);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(521, 64, 144, 20);
		panel_1.add(txtDireccion);
		
		JButton btnConsultarCliente = new JButton("");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCliente d = new DlgCliente();
				d.setVisible(true);
			
			}
		});
		btnConsultarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/ClientesBoleta.png")));
		btnConsultarCliente.setContentAreaFilled(false);
		btnConsultarCliente.setBorderPainted(false);
		btnConsultarCliente.setBorder(null);
		btnConsultarCliente.setBounds(539, 20, 37, 37);
		panel_1.add(btnConsultarCliente);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(186, 32, 65, 108);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/logoResto.png")));
		
		JLabel lblNewLabel_2 = new JLabel("Numero de Boleta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(306, 51, 136, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(306, 99, 125, 23);
		contentPane.add(lblNewLabel_3);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumBoleta.setBounds(438, 60, 108, 20);
		contentPane.add(txtNumBoleta);
		txtNumBoleta.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(438, 100, 108, 20);
		contentPane.add(txtFecha);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Productos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(29, 235, 675, 71);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Plato:");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_3.setBounds(10, 27, 68, 19);
		panel_1_1.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Precio:");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1_1.setBounds(279, 27, 68, 19);
		panel_1_1.add(lblNewLabel_2_2_1_1_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(512, 28, 77, 20);
		panel_1_1.add(txtCantidad);
		
		txtNomProducto = new JTextField();
		txtNomProducto.setEditable(false);
		txtNomProducto.setColumns(10);
		txtNomProducto.setBounds(48, 28, 184, 20);
		panel_1_1.add(txtNomProducto);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setEditable(false);
		txtPrecioProducto.setColumns(10);
		txtPrecioProducto.setBounds(324, 28, 103, 20);
		panel_1_1.add(txtPrecioProducto);
		
		JButton btnConsultarCliente_1 = new JButton("");
		btnConsultarCliente_1.setContentAreaFilled(false);
		btnConsultarCliente_1.setBorderPainted(false);
		btnConsultarCliente_1.setBorder(null);
		btnConsultarCliente_1.setBounds(539, 20, 37, 37);
		panel_1_1.add(btnConsultarCliente_1);
		
		JButton btnConsultarProducto = new JButton("");
		btnConsultarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgProducto p = new DlgProducto();
				p.setVisible(true);
				
			}
		});
		btnConsultarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/box.png")));
		btnConsultarProducto.setContentAreaFilled(false);
		btnConsultarProducto.setBorderPainted(false);
		btnConsultarProducto.setBorder(null);
		btnConsultarProducto.setBounds(235, 20, 37, 37);
		panel_1_1.add(btnConsultarProducto);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Cantidad:");
		lblNewLabel_2_2_1_2.setBounds(441, 27, 135, 19);
		panel_1_1.add(lblNewLabel_2_2_1_2);
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		btnAgregar.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/venta.png")));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setBorder(null);
		btnAgregar.setBounds(603, 10, 37, 37);
		panel_1_1.add(btnAgregar);
		
		JLabel lblNewLabel_4 = new JLabel("A\u00F1adir");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_4.setBounds(599, 43, 54, 14);
		panel_1_1.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 317, 675, 126);
		contentPane.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setModel(modelo);
		modelo.addColumn("Cant.");
		modelo.addColumn("Descripcion");
		modelo.addColumn("P.Unidad");
		modelo.addColumn("Importe");
		scrollPane.setViewportView(tblSalida);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(587, 454, 117, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Total:");
		lblNewLabel_2_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_2_1.setBounds(536, 454, 41, 19);
		contentPane.add(lblNewLabel_2_2_1_2_1);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(307, 454, 89, 23);
		contentPane.add(btnImprimir);
		
		setLocationRelativeTo(null);
		
		txtNumBoleta.setText(obtenerNumBoleta());
		txtFecha.setText(obtenerFecha());
	}
	
	double total = 0;

	
	void agregarProducto() {
	
	}
	
	
	
	private String obtenerNumBoleta() {		
		
		return new GestionMantenimiento().generaNumeroBoleta();
	}
	
	private String obtenerFecha() {
		
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	
	//-----------------------------------------
	private String leerNomCli() {
		return txtNomCliente.getText();
	}
	
	private String leerIdCli() {
		return txtidCliente.getText();
	}
	
	private int leerTelefono() {
		return Integer.parseInt(txtFelefono.getText());
	}
	
	private String leerDocumento() {
		return txtDocumento.getText();
	}
	
	private String LeerDireccion() {
		return txtDireccion.getText();
	}
	
	private String leerNomProd() {
		return txtNomProducto.getText();
	}
	
	private double leerPrecio() {

		return Double.parseDouble(txtPrecioProducto.getText());
	}
	
	private double leerCantidad() {
		
		if (txtCantidad.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Ingrese una Canidad");
			return 0;
		}
		
		if(!txtCantidad.getText().matches("^[0-9]{2}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en la Cantidad", "Aviso", 2);
			return 0;
		}	
		return Double.parseDouble(txtCantidad.getText());
	}
	
	private double leerTotal() {
		return Double.parseDouble(txtTotal.getText());
	}
	
	
	
}
