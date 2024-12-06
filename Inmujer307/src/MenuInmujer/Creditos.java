package MenuInmujer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Creditos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creditos frame = new Creditos();
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
	public Creditos() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 803, 57);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("CREDITOS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 40));
		lblNewLabel_2.setBounds(328, 0, 195, 57);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(Creditos.class.getResource("/img/EncabezadoJuegos.png")));
		lblNewLabel_3.setBounds(0, 0, 803, 57);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(137, 5, 160));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 583, 803, 57);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_5_5 = new JLabel("DIRIGIDO POR: Adrian Villamares Martínez");
		lblNewLabel_5_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_5.setBounds(10, 10, 427, 43);
		panel_1.add(lblNewLabel_5_5);
		lblNewLabel_5_5.setFont(new Font("Arial", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInmujer inm = new MenuInmujer();
				inm.setVisible(true);
				inm.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton.setBackground(new Color(238, 130, 238));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(542, 10, 124, 35);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2.setBackground(new Color(243, 220, 220));
		panel_2.setBounds(10, 77, 314, 185);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("PROGRAMADORES:");
		lblNewLabel_5.setBounds(10, 10, 208, 30);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		
		JTextArea txtArea = new JTextArea();
		txtArea.setEnabled(false);
		txtArea.setEditable(false);
		txtArea.setDisabledTextColor(txtArea.getForeground());
		
		txtArea.setEnabled(false);
		txtArea.setWrapStyleWord(true);
		txtArea.setEditable(false);
		txtArea.setBounds(10, 50, 294, 117);
		panel_2.add(txtArea);
		txtArea.setBackground(new Color(243, 220, 220));
		txtArea.setFont(new Font("Arial", Font.BOLD, 12));
		txtArea.setText("ARIZMENDI MEDRANO KEVIN ANDRES\r\nESQUIVEL GARCIA CESAR SAMUEL\r\nFLORES CHAVEZ VICTOR DANIEL\r\nGARCIA REBOLLO AXEL YAEL\r\nLORA ESTRADA IAN ALEXIS\r\nMARQUEZ GUERRERO JESUS\r\nMONDRAGON MONROY EFRAIN DEMIAN\r\nSERRANO ELIZARRAGA EMMANUEL ALEJANDRO\r\n");
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2_1.setBackground(new Color(243, 220, 220));
		panel_2_1.setBounds(499, 77, 314, 185);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_6 = new JLabel("INFORMACIÓN:\r\n");
		lblNewLabel_5_6.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5_6.setBounds(10, 10, 208, 30);
		panel_2_1.add(lblNewLabel_5_6);
		
		JTextArea txtArea_2_1_1 = new JTextArea();
		txtArea_2_1_1.setWrapStyleWord(true);
		txtArea_2_1_1.setText("ARIZMENDI MEDRANO KEVIN ANDRES\r\nESQUIVEL GARCIA CESAR SAMUEL\r\nFLORES CHAVEZ VICTOR DANIEL\r\nGARCIA REBOLLO AXEL YAEL\r\nLORA ESTRADA IAN ALEXIS\r\nMARQUEZ GUERRERO JESUS\r\nMONDRAGON MONROY EFRAIN DEMIAN\r\nSERRANO ELIZARRAGA EMMANUEL ALEJANDRO\r\n");
		txtArea_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		txtArea_2_1_1.setEnabled(false);
		txtArea_2_1_1.setEditable(false);
		txtArea_2_1_1.setDisabledTextColor(Color.BLACK);
		txtArea_2_1_1.setBackground(new Color(243, 220, 220));
		txtArea_2_1_1.setBounds(10, 50, 294, 117);
		panel_2_1.add(txtArea_2_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2_2.setBackground(new Color(243, 220, 220));
		panel_2_2.setBounds(10, 388, 314, 185);
		contentPane.add(panel_2_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("INFORMES:");
		lblNewLabel_5_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5_3.setBounds(10, 10, 208, 30);
		panel_2_2.add(lblNewLabel_5_3);
		
		JTextArea txtArea_2 = new JTextArea();
		txtArea_2.setWrapStyleWord(true);
		txtArea_2.setText("ARIZMENDI MEDRANO KEVIN ANDRES\r\nESQUIVEL GARCIA CESAR SAMUEL\r\nFLORES CHAVEZ VICTOR DANIEL\r\nGARCIA REBOLLO AXEL YAEL\r\nLORA ESTRADA IAN ALEXIS\r\nMARQUEZ GUERRERO JESUS\r\nMONDRAGON MONROY EFRAIN DEMIAN\r\nSERRANO ELIZARRAGA EMMANUEL ALEJANDRO\r\n");
		txtArea_2.setFont(new Font("Arial", Font.BOLD, 12));
		txtArea_2.setEnabled(false);
		txtArea_2.setEditable(false);
		txtArea_2.setDisabledTextColor(Color.BLACK);
		txtArea_2.setBackground(new Color(243, 220, 220));
		txtArea_2.setBounds(10, 50, 294, 117);
		panel_2_2.add(txtArea_2);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2_2_1.setBackground(new Color(243, 220, 220));
		panel_2_2_1.setBounds(499, 388, 314, 185);
		contentPane.add(panel_2_2_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("GRÁFICAS:");
		lblNewLabel_5_3_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5_3_1.setBounds(10, 10, 208, 30);
		panel_2_2_1.add(lblNewLabel_5_3_1);
		
		JTextArea txtArea_2_1 = new JTextArea();
		txtArea_2_1.setWrapStyleWord(true);
		txtArea_2_1.setText("CAÑAMO FLORES PAVEL TADEO\r\nCASILLAS DE LA ROSA LEONEL SAMUEL\r\nCASTILLO RAMIREZ AXEL DAVID\r\nDOMINGUEZ LOPEZ FERNANDO\r\nHERNANDEZ GARCIA BRAYAN\r\nHERNANDEZ ROMERO RODRIGO\r\n RAYON OSORIO ADELA GABRIELLE\r");
		txtArea_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		txtArea_2_1.setEnabled(false);
		txtArea_2_1.setEditable(false);
		txtArea_2_1.setDisabledTextColor(Color.BLACK);
		txtArea_2_1.setBackground(new Color(243, 220, 220));
		txtArea_2_1.setBounds(10, 50, 294, 117);
		panel_2_2_1.add(txtArea_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_3.setBackground(new Color(243, 220, 220));
		panel_3.setBounds(10, 272, 803, 103);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5_6_1 = new JLabel("DISEÑO VISUAL:\r\n");
		lblNewLabel_5_6_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5_6_1.setBounds(10, 40, 161, 30);
		panel_3.add(lblNewLabel_5_6_1);
		
		JTextArea txtrTorresParadaDulce = new JTextArea();
		txtrTorresParadaDulce.setBounds(174, 10, 619, 83);
		panel_3.add(txtrTorresParadaDulce);
		txtrTorresParadaDulce.setWrapStyleWord(true);
		txtrTorresParadaDulce.setText("TORRES PARADA DULCE MARIA      BARRIOS MARTINEZ VANIA AMAIRANY     \r\n\r\nVAZQUEZ PINEDA YUE DANAE           HERNANDEZ SANTIAGO MELANIE VANESSA        CENTENO VARGAS URIEL\r\n\r\nPERALTA SALAZAR ILSE AGALI      CASTRO ZEPEDA LUIS ESTEBAN\r\n\r\n\r\n\r\n");
		txtrTorresParadaDulce.setFont(new Font("Arial", Font.BOLD, 12));
		txtrTorresParadaDulce.setEnabled(false);
		txtrTorresParadaDulce.setEditable(false);
		txtrTorresParadaDulce.setDisabledTextColor(Color.BLACK);
		txtrTorresParadaDulce.setBackground(new Color(243, 220, 220));
	}
}
