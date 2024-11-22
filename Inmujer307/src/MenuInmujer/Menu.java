package MenuInmujer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Informes.InformeAceptacion;
import Informes.InformeBoletaPago;
import Informes.InformePermanencia;
import Informes.InformePrimercontacto;
import MenuInmujer.MenuInmujer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
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
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/intMujer.png")));
		lblNewLabel.setBounds(80, 0, 53, 57);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/img/LG.png")));
		lblNewLabel_1.setBounds(634, 0, 66, 57);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("INFORMES");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 45));
		lblNewLabel_2.setBounds(145, 0, 479, 57);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(Menu.class.getResource("/img/encabezadoVino.png")));
		lblNewLabel_3.setBounds(0, 0, 803, 57);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 583, 803, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Menu.class.getResource("/img/pie.png")));
		lblNewLabel_4.setBounds(0, 0, 803, 57);
		panel_1.add(lblNewLabel_4);
		
		JButton btnPrimerContacto = new JButton("PRIMER CONTACTO");
		btnPrimerContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePrimercontacto ir = new InformePrimercontacto();
				ir.setVisible(true);
				ir.setLocationRelativeTo(null);
				dispose(); 
			}
		});
		btnPrimerContacto.setBackground(new Color(128, 0, 64));
		btnPrimerContacto.setFont(new Font("Arial", Font.BOLD, 10));
		btnPrimerContacto.setBounds(195, 299, 159, 21);
		contentPane.add(btnPrimerContacto);
		
		JLabel lblBoletaDePago = new JLabel("");
		lblBoletaDePago.setIcon(new ImageIcon(Menu.class.getResource("/img/Recibo.png")));
		lblBoletaDePago.setBounds(479, 86, 170, 203);
		contentPane.add(lblBoletaDePago);
		
		JButton btnBoletaDePago = new JButton("BOLETA DE PAGO");
		btnBoletaDePago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeBoletaPago ir = new InformeBoletaPago();
				ir.setVisible(true);
				ir.setLocationRelativeTo(null);
				dispose(); 
			}
		});
		btnBoletaDePago.setBackground(new Color(128, 0, 64));
		btnBoletaDePago.setFont(new Font("Arial", Font.BOLD, 10));
		btnBoletaDePago.setBounds(479, 299, 170, 21);
		contentPane.add(btnBoletaDePago);
		
		JLabel lblCartaAceptacion = new JLabel("");
		lblCartaAceptacion.setIcon(new ImageIcon(Menu.class.getResource("/img/Carta Aceptacion.png")));
		lblCartaAceptacion.setBounds(185, 332, 183, 203);
		contentPane.add(lblCartaAceptacion);
		
		JButton btnCartaAceptacion = new JButton("CARTA ACEPTACIAON");
		btnCartaAceptacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeAceptacion ir = new InformeAceptacion();
				ir.setVisible(true);
				ir.setLocationRelativeTo(null);
				dispose(); 
			}
		});
		btnCartaAceptacion.setBackground(new Color(128, 0, 64));
		btnCartaAceptacion.setFont(new Font("Arial", Font.BOLD, 10));
		btnCartaAceptacion.setBounds(195, 540, 159, 21);
		contentPane.add(btnCartaAceptacion);
		
		JLabel lblCartaPermanencia = new JLabel("");
		lblCartaPermanencia.setIcon(new ImageIcon(Menu.class.getResource("/img/carta Permanencia.png")));
		lblCartaPermanencia.setBounds(466, 330, 183, 203);
		contentPane.add(lblCartaPermanencia);
		
		JButton btnCartaPermanencia = new JButton("CARTA PERMANENCIA");
		btnCartaPermanencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePermanencia ir = new InformePermanencia();
				ir.setVisible(true);
				ir.setLocationRelativeTo(null);
				dispose(); 
			}
		});
		btnCartaPermanencia.setBackground(new Color(128, 0, 64));
		btnCartaPermanencia.setFont(new Font("Arial", Font.BOLD, 10));
		btnCartaPermanencia.setBounds(479, 540, 170, 21);
		contentPane.add(btnCartaPermanencia);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInmujer menu = new MenuInmujer();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 10));
		btnRegresar.setBackground(new Color(128, 0, 64));
		btnRegresar.setBounds(10, 540, 120, 21);
		contentPane.add(btnRegresar);
		
		JLabel lblBoletaDePago_1 = new JLabel("");
		lblBoletaDePago_1.setIcon(new ImageIcon(Menu.class.getResource("/img/Primer Contacto1.png")));
		lblBoletaDePago_1.setBounds(184, 88, 184, 203);
		contentPane.add(lblBoletaDePago_1);
	}
}
