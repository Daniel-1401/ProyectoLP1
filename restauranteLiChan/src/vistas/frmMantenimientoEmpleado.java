package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class frmMantenimientoEmpleado extends JFrame {
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoEmpleado frame = new frmMantenimientoEmpleado();
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
	public frmMantenimientoEmpleado() {
		setBounds(100, 100, 524, 478);
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(frmMantenimientoEmpleado.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnNewButton.setPressedIcon(new ImageIcon(frmMantenimientoEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setIcon(new ImageIcon(frmMantenimientoEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(474, 10, 28, 28);
		getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 104, 45, 13);
		getContentPane().add(lblNewLabel);

	}

}
