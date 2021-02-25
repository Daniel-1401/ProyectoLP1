package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloLoader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class frmLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoader frame = new frmLoader();
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
	public frmLoader() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.addChangeListener(this);
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 186, 430, 45);
		contentPane.add(progressBar);
		iniciarCarga();
	}
	public void iniciarCarga() {
		HiloLoader carga = new HiloLoader(this);
		carga.start();
	}
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == progressBar) {
			stateChangedProgressBar(arg0);
		}
	}
	protected void stateChangedProgressBar(ChangeEvent arg0) {
		if(progressBar.getValue() == 100) {
			frmPrincipal principal = new frmPrincipal();
			principal.setVisible(true);
			principal.setLocationRelativeTo(null);
			dispose();
		}
	}
}
