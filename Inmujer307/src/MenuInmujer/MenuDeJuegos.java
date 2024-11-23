package MenuInmujer;

import java.awt.EventQueue;

//ADIVINA LA PALABRA IMPORTACION
import AdivinaLaPalabra.AdivinarLaPalabra;
import AdivinaLaPalabra.VariablesJuego1;

//MEMORAMA IMPORTACION 
import Memorama.Carta;
import Memorama.JuegoDeMemoria;
import Memorama.ControladorDeJuego;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDeJuegos extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDeJuegos frame = new MenuDeJuegos();
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
	public MenuDeJuegos() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 803, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/intMujer.png")));
		lblNewLabel.setBounds(80, 0, 53, 57);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/LG.png")));
		lblNewLabel_1.setBounds(634, 0, 66, 57);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("JUEGOS");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 45));
		lblNewLabel_2.setBounds(315, 0, 161, 57);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/encabezadoVino.png")));
		lblNewLabel_3.setBounds(0, 0, 803, 57);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 583, 803, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/pie.png")));
		lblNewLabel_4.setBounds(0, 0, 803, 57);
		panel_1.add(lblNewLabel_4);
		
		JButton btnMemorama = new JButton("MEMORAMA");
		btnMemorama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INICIAR LA CONEXION ENTRE EL JUEGO DE MEMORIA Y EL MENU 
				JuegoDeMemoria juego = new JuegoDeMemoria();
				
				dispose();
				
			}
		});
		btnMemorama.setBorder(null);
		btnMemorama.setBackground(new Color(128, 0, 64));
		btnMemorama.setFont(new Font("Arial", Font.BOLD, 10));
		btnMemorama.setBounds(165, 433, 170, 32);
		contentPane.add(btnMemorama);
		
		JLabel lblMemorama = new JLabel("");
		ImageIcon imgNormal1 = new ImageIcon(getClass().getResource("/img/memorama.png"));
		ImageIcon imgResaltado1 = new ImageIcon(getClass().getResource("/img/IntroduccionMemorama.png"));
		lblMemorama.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/memorama.png")));
		
		lblMemorama.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	lblMemorama.setIcon(imgResaltado1); // Cambia la imagen al pasar el ratón
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	lblMemorama.setIcon(imgNormal1); // Restaura la imagen al salir
		    }
		});
		lblMemorama.setBackground(new Color(204, 0, 204));
		lblMemorama.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/memorama.png")));
		lblMemorama.setBounds(165, 206, 170, 203);
		contentPane.add(lblMemorama);
		
		JButton btnAdivinaLaPalabra = new JButton("ADIVINA LA PALABRA");
		btnAdivinaLaPalabra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//INICIAR LA CONEXION ENTRE EL JUEGO DE ADIVINAR LA PALABRA Y EL MENU 
				VariablesJuego1 variables = new VariablesJuego1();
				AdivinarLaPalabra adivina = new AdivinarLaPalabra(variables);
				
				adivina.setVisible(true);
				adivina.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAdivinaLaPalabra.setBorder(null);
		btnAdivinaLaPalabra.setBackground(new Color(128, 0, 64));
		btnAdivinaLaPalabra.setFont(new Font("Arial", Font.BOLD, 10));
		btnAdivinaLaPalabra.setBounds(479, 433, 170, 32);
		contentPane.add(btnAdivinaLaPalabra);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBorder(null);
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 10));
		btnRegresar.setBackground(new Color(128, 0, 64));
		btnRegresar.setBounds(56, 529, 120, 32);
		contentPane.add(btnRegresar);
		ImageIcon imgNormal11 = new ImageIcon(getClass().getResource("/img/adivina.png"));
		ImageIcon imgResaltado11 = new ImageIcon(getClass().getResource("/img/IntroduccionAdivina.png"));
		
		JLabel lblAdivinaLaPalabra = new JLabel("");
		lblAdivinaLaPalabra.setBounds(481, 205, 168, 204);
		contentPane.add(lblAdivinaLaPalabra);
		lblAdivinaLaPalabra.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/adivina.png")));
		
		lblAdivinaLaPalabra.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	lblAdivinaLaPalabra.setIcon(imgResaltado11); // Cambia la imagen al pasar el ratón
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	lblAdivinaLaPalabra.setIcon(imgNormal11); // Restaura la imagen al salir
		    }
		});
		lblAdivinaLaPalabra.setIcon(new ImageIcon(MenuDeJuegos.class.getResource("/img/adivina.png")));
	}
}
