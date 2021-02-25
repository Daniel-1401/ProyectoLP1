package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmRegistroProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodProducto;
	private JTextField txtNombreProd;
	private JTextField txtPrecioProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProducto frame = new FrmRegistroProducto();
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
	public FrmRegistroProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Producto");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 16, 238, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel_1.setBounds(37, 63, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setBounds(37, 99, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio:");
		lblNewLabel_1_2.setBounds(37, 138, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setBounds(163, 60, 155, 20);
		contentPane.add(txtCodProducto);
		txtCodProducto.setColumns(10);
		
		txtNombreProd = new JTextField();
		txtNombreProd.setColumns(10);
		txtNombreProd.setBounds(163, 95, 157, 20);
		contentPane.add(txtNombreProd);
		
		txtPrecioProd = new JTextField();
		txtPrecioProd.setColumns(10);
		txtPrecioProd.setBounds(163, 135, 158, 20);
		contentPane.add(txtPrecioProd);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(112, 196, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(387, 57, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(386, 92, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(385, 131, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(305, 196, 89, 23);
		contentPane.add(btnLimpiar);
	}
}
