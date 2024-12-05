package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class MenuJuegos7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJuegos7 frame = new MenuJuegos7();
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
	public MenuJuegos7() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 803, 57);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("JUEGOS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 45));
		lblNewLabel_2.setBounds(348, 0, 161, 57);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(MenuJuegos7.class.getResource("/img/EncabezadoJuegos.png")));
		lblNewLabel_3.setBounds(0, 0, 803, 57);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(137, 5, 160));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 583, 803, 57);
		contentPane.add(panel_1);
		
		JLabel lblMemorama = new JLabel("");
		lblMemorama.setIcon(new ImageIcon(MenuJuegos7.class.getResource("/img/memorama.png")));
		lblMemorama.setBackground(new Color(204, 0, 204));
		lblMemorama.setBounds(166, 187, 170, 203);
		contentPane.add(lblMemorama);
		
		JLabel lblAdivinaLaPalabra = new JLabel("");
		lblAdivinaLaPalabra.setIcon(new ImageIcon(MenuJuegos7.class.getResource("/img/adivina.png")));
		lblAdivinaLaPalabra.setBounds(469, 187, 168, 204);
		contentPane.add(lblAdivinaLaPalabra);
		
		JButton btnMemorama = new JButton("MEMORAMA");
		btnMemorama.setFont(new Font("Arial", Font.BOLD, 10));
		btnMemorama.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnMemorama.setBackground(Color.WHITE);
		btnMemorama.setBounds(166, 421, 170, 32);
		contentPane.add(btnMemorama);
		
		JButton btnAdivinaLaPalabra = new JButton("ADIVINA LA PALABRA");
		btnAdivinaLaPalabra.setFont(new Font("Arial", Font.BOLD, 10));
		btnAdivinaLaPalabra.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAdivinaLaPalabra.setBackground(Color.WHITE);
		btnAdivinaLaPalabra.setBounds(469, 427, 170, 32);
		contentPane.add(btnAdivinaLaPalabra);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 10));
		btnRegresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegresar.setBackground(Color.WHITE);
		btnRegresar.setBounds(10, 539, 120, 32);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuJuegos7.class.getResource("/img1/FondoJ7.png")));
		lblNewLabel.setBounds(0, 0, 823, 650);
		contentPane.add(lblNewLabel);
	}
}
