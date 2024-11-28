package MenuInmujer;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import PrimerContacto.DatosGenerales;
import PrimerContacto.Violencia;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MenuInmujer extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					MenuInmujer frame = new MenuInmujer();
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
	

	public MenuInmujer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/menuencabezado.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(152, 14, 192), 3));
		panel.setBounds(51, 80, 184, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel btninmujer = new JLabel("");
		btninmujer.setBounds(10, 11, 166, 148);
		panel.add(btninmujer);
		btninmujer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btninmujer.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/imginmu.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btninmujer.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/primercontacto.png")));
			}
		});
		btninmujer.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/imginmu.png")));
		
		JButton btnNewButton = new JButton("Primer Contacto");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosGenerales ventanaDatosGenerales = new DatosGenerales();
				dispose();
				ventanaDatosGenerales.setVisible(true);
				ventanaDatosGenerales.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBackground(new Color(238, 196, 251));
		btnNewButton.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton.setBounds(74, 265, 143, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 69, 19));
		panel_1.setBounds(0, 56, 143, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(199, 21, 133));
		panel_2.setBounds(141, 56, 143, 10);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(33, 63, 38));
		panel_3.setBounds(282, 56, 130, 10);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(34, 139, 34));
		panel_4.setBounds(410, 56, 136, 10);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(210, 180, 140));
		panel_5.setBounds(543, 56, 136, 10);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		panel_6.setBounds(675, 56, 134, 10);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(152, 14, 192), 3));
		panel_7.setBounds(312, 80, 191, 174);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel btnseguro = new JLabel("");
		btnseguro.setBounds(15, 11, 166, 148);
		panel_7.add(btnseguro);
		btnseguro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnseguro.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/seguroviio.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnseguro.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/segvioleta.png")));	
			}
		});
		btnseguro.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/segvioleta.png")));
		
		JButton btnNewButton_1 = new JButton("Seguro Violeta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosGenerales ventanaDatosGenerales = new DatosGenerales();
				dispose();
				ventanaDatosGenerales.setVisible(true);
				ventanaDatosGenerales.setLocationRelativeTo(null);
				JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE EXPEDIENTE QUE SE LE DIO EN PRIMER CONTACTO","ESTE PASO ES IMPORTANTE PARA PODER CONTINUAR",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(238, 196, 255));
		btnNewButton_1.setBounds(322, 265, 166, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(0, 551, 809, 60);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/pie.png")));
		lblNewLabel_1.setBounds(0, 0, 819, 62);
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		panel_9.setBounds(574, 80, 191, 174);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel btninfomes = new JLabel("");
		btninfomes.setBounds(10, 11, 166, 148);
		panel_9.add(btninfomes);
		btninfomes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninfomes.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/tulti2.png")));		
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btninfomes.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/tultitlan.png")));		
			}
		});
		btninfomes.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/tultitlan.png")));
		
		JButton btnNewButton_2 = new JButton("Informes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBackground(new Color(238, 196, 255));
		btnNewButton_2.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton_2.setBounds(616, 265, 110, 23);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(152, 14, 192), 3));
		panel_10.setBounds(51, 311, 184, 174);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel btnestadisticas = new JLabel("");
		btnestadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			btnestadisticas.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/info.png")));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			btnestadisticas.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/graficalogo.png")));
			}
		});
		btnestadisticas.setBounds(10, 11, 166, 153);
		panel_10.add(btnestadisticas);
		btnestadisticas.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/graficalogo.png")));
		
		JButton btnNewButton_3 = new JButton("Estadisticas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGraficas menu = new menuGraficas();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBackground(new Color(238, 196, 255));
		btnNewButton_3.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton_3.setBounds(74, 497, 132, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel btntripticos = new JLabel("");
		btntripticos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			btntripticos.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/trip2.png")));		
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btntripticos.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/tripticologo.png")));	
			}
		});
		btntripticos.setBounds(322, 326, 166, 151);
		contentPane.add(btntripticos);
		btntripticos.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/tripticologo.png")));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(152, 14, 192), 3));
		panel_11.setBounds(312, 311, 191, 174);
		contentPane.add(panel_11);
		
		JButton btnNewButton_4 = new JButton("Tripticos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diseñoPDF diseño = new diseñoPDF();
				diseño.setVisible(true);
				diseño.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBackground(new Color(238, 196, 255));
		btnNewButton_4.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton_4.setBounds(367, 497, 101, 23);
		contentPane.add(btnNewButton_4);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(152, 14, 192), 3));
		panel_12.setBounds(574, 311, 191, 174);
		contentPane.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel btnjuego = new JLabel("");
		btnjuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnjuego.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/juegoinfo.png")));		
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnjuego.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/juegologo.png")));		
				
			}
		});
		btnjuego.setBounds(21, 11, 160, 151);
		panel_12.add(btnjuego);
		btnjuego.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/juegologo.png")));
		
		JButton btnNewButton_5 = new JButton("Juego");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDeJuegos juego = new MenuDeJuegos();
				juego.setVisible(true);
				juego.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBackground(new Color(238, 196, 255));
		btnNewButton_5.setFont(new Font("Californian FB", Font.BOLD, 12));
		btnNewButton_5.setBounds(637, 497, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuInmujer.class.getResource("/menuimg/fondologo1.png")));
		lblNewLabel_2.setBounds(0, 63, 821, 487);
		contentPane.add(lblNewLabel_2);
	}
}