package clases;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;

public class DATOSDELAGRESOR extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DATOSDELAGRESOR frame = new DATOSDELAGRESOR();
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
	public DATOSDELAGRESOR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 807, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATOS DEL AGRESOR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(304, 19, 182, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/IMG/butterfly_side_view_56.png")));
		lblNewLabel_1.setBounds(241, 3, 51, 50);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/IMG/butterfly_side_espejo.png")));
		label.setBounds(509, 3, 51, 50);
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/IMG/encabezado.gif")));
		lblNewLabel_2.setBounds(0, 0, 807, 57);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(10, 62, 787, 63);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("NIVEL DE RIESGO");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(51, 11, 104, 14);
		panel_1.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"selecciona una opcion", "Bajo", "Medio", "alto"}));
		comboBox.setBounds(37, 36, 130, 22);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("NOMBRE COMPLETO");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(210, 11, 118, 14);
		panel_1.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(192, 37, 154, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("EDAD");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(406, 11, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"seleccione una opcion", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", ""}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBounds(371, 36, 130, 22);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(530, 11, 135, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(511, 37, 177, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(10, 136, 787, 63);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("GRADO ESCOLAR");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(83, 11, 106, 14);
		panel_1_1.add(lblNewLabel_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opcion", "Primaria Trunca", "primaria terminada", "Secundaria", "Bachillerato", "Licenciatura", "Posgrado", "Sin estudios"}));
		comboBox_2.setBounds(68, 36, 131, 22);
		panel_1_1.add(comboBox_2);
		
		JLabel lblNewLabel_8 = new JLabel("ESTADO");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(215, 11, 54, 14);
		panel_1_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CIVIL :");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(236, 24, 46, 14);
		panel_1_1.add(lblNewLabel_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("SOLTERO/A");
		rdbtnNewRadioButton.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton.setBounds(281, 7, 83, 23);
		panel_1_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("VIUDO/A");
		rdbtnNewRadioButton_1.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_1.setBounds(281, 36, 83, 23);
		panel_1_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("CASADO/A");
		rdbtnNewRadioButton_2.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_2.setBounds(377, 7, 109, 23);
		panel_1_1.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("RELACION O VINCULO");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(507, 11, 130, 14);
		panel_1_1.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(497, 37, 153, 20);
		panel_1_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1_1.setBounds(10, 199, 787, 63);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_11 = new JLabel("DOMICILIO");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_11.setBounds(84, 15, 67, 14);
		panel_1_1_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("COMPLETO :");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_12.setBounds(84, 30, 80, 14);
		panel_1_1_1.add(lblNewLabel_12);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 27, 158, 20);
		panel_1_1_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("SERVIDOR");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_13.setBounds(346, 15, 67, 14);
		panel_1_1_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("PUBLICO :");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_14.setBounds(346, 30, 67, 14);
		panel_1_1_1.add(lblNewLabel_14);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("SI");
		rdbtnNewRadioButton_4.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_4.setBounds(413, 11, 41, 23);
		panel_1_1_1.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("NO");
		rdbtnNewRadioButton_5.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_5.setBounds(413, 37, 41, 23);
		panel_1_1_1.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_15 = new JLabel("OCUPACION");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(529, 11, 80, 14);
		panel_1_1_1.add(lblNewLabel_15);
		
		textField_4 = new JTextField();
		textField_4.setBounds(486, 30, 158, 20);
		panel_1_1_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("CARACTERISTICAS");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_16.setBounds(95, 273, 161, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("DEL");
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17.setBounds(153, 287, 46, 14);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("AGRESOR");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_18.setBounds(124, 298, 81, 14);
		contentPane.add(lblNewLabel_18);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1_1_1.setBounds(10, 318, 384, 234);
		contentPane.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_19 = new JLabel("OJOS");
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19.setBounds(72, 75, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_19);
		
		textField_9 = new JTextField();
		textField_9.setBounds(25, 36, 139, 20);
		panel_1_1_1_1.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(25, 94, 139, 20);
		panel_1_1_1_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(25, 143, 139, 20);
		panel_1_1_1_1.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(25, 197, 139, 20);
		panel_1_1_1_1.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("TEZ");
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_20.setBounds(74, 12, 27, 14);
		panel_1_1_1_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("CARA");
		lblNewLabel_21.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_21.setBounds(72, 126, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("LABIOS");
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_22.setBounds(72, 172, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_20_1 = new JLabel("NARIZ");
		lblNewLabel_20_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_20_1.setBounds(253, 12, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_20_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(206, 36, 139, 20);
		panel_1_1_1_1.add(textField_5);
		
		JLabel lblNewLabel_19_1 = new JLabel("CABELLO");
		lblNewLabel_19_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19_1.setBounds(246, 75, 63, 14);
		panel_1_1_1_1.add(lblNewLabel_19_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(206, 94, 139, 20);
		panel_1_1_1_1.add(textField_6);
		
		JLabel lblNewLabel_21_1 = new JLabel("CEJAS");
		lblNewLabel_21_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_21_1.setBounds(253, 126, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_21_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(206, 143, 139, 20);
		panel_1_1_1_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(206, 197, 139, 20);
		panel_1_1_1_1.add(textField_8);
		
		JLabel lblNewLabel_22_1 = new JLabel("COMPLEXION");
		lblNewLabel_22_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_22_1.setBounds(236, 172, 83, 14);
		panel_1_1_1_1.add(lblNewLabel_22_1);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1_1_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1_1_1_1.setBounds(413, 318, 384, 282);
		contentPane.add(panel_1_1_1_1_1);
		
		JLabel lblNewLabel_23 = new JLabel("PORTA ARMAS");
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23.setBounds(43, 11, 85, 14);
		panel_1_1_1_1_1.add(lblNewLabel_23);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("SI");
		rdbtnNewRadioButton_6.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_6.setBounds(53, 32, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("NO");
		rdbtnNewRadioButton_7.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_7.setBounds(53, 58, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_7);
		
		JLabel lblNewLabel_24 = new JLabel("SELECCIONE ARMAS");
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(184, 11, 117, 14);
		panel_1_1_1_1_1.add(lblNewLabel_24);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"selecciona una opcion", "Pistola", "Punzocortante", "Contundente"}));
		comboBox_3.setBounds(184, 32, 130, 22);
		panel_1_1_1_1_1.add(comboBox_3);
		
		JLabel lblNewLabel_25 = new JLabel("\u00BFPERTENECE A ALGUNA ");
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_25.setBounds(10, 94, 149, 14);
		panel_1_1_1_1_1.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("BANDA DELICTIVA?");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_26.setBounds(20, 108, 118, 14);
		panel_1_1_1_1_1.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("\u00BFCONSUME ALGUN ");
		lblNewLabel_27.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_27.setBounds(184, 94, 110, 14);
		panel_1_1_1_1_1.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("TIPO DE SUSTANCIA");
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_28.setBounds(179, 108, 117, 14);
		panel_1_1_1_1_1.add(lblNewLabel_28);
		
		JRadioButton rdbtnNewRadioButton_6_1 = new JRadioButton("SI");
		rdbtnNewRadioButton_6_1.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_6_1.setBounds(53, 129, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_6_1);
		
		JRadioButton rdbtnNewRadioButton_7_1 = new JRadioButton("NO");
		rdbtnNewRadioButton_7_1.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_7_1.setBounds(53, 155, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_7_1);
		
		JRadioButton rdbtnNewRadioButton_6_2 = new JRadioButton("SI");
		rdbtnNewRadioButton_6_2.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_6_2.setBounds(211, 129, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_6_2);
		
		JRadioButton rdbtnNewRadioButton_7_2 = new JRadioButton("NO");
		rdbtnNewRadioButton_7_2.setBackground(new Color(243, 220, 220));
		rdbtnNewRadioButton_7_2.setBounds(211, 155, 50, 23);
		panel_1_1_1_1_1.add(rdbtnNewRadioButton_7_2);
		
		JLabel lblNewLabel_23_1 = new JLabel("CUAL?");
		lblNewLabel_23_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23_1.setBounds(216, 185, 85, 14);
		panel_1_1_1_1_1.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_29 = new JLabel("SE\u00D1AS PARTICULARES");
		lblNewLabel_29.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_29.setBounds(10, 185, 137, 14);
		panel_1_1_1_1_1.add(lblNewLabel_29);
		
		textField_13 = new JTextField();
		textField_13.setBounds(215, 201, 131, 20);
		panel_1_1_1_1_1.add(textField_13);
		textField_13.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 210, 149, 61);
		panel_1_1_1_1_1.add(textArea);
		
		JButton btnNewButton_2 = new JButton("CONTINUAR");
		btnNewButton_2.setBounds(229, 248, 117, 23);
		panel_1_1_1_1_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_16_1 = new JLabel("PARTICULARIDADES");
		lblNewLabel_16_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_16_1.setBounds(536, 273, 176, 14);
		contentPane.add(lblNewLabel_16_1);
		
		JLabel lblNewLabel_17_1 = new JLabel("DEL");
		lblNewLabel_17_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17_1.setBounds(606, 287, 46, 14);
		contentPane.add(lblNewLabel_17_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("AGRESOR");
		lblNewLabel_18_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_18_1.setBounds(577, 298, 81, 14);
		contentPane.add(lblNewLabel_18_1);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.setBounds(10, 577, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INICIO");
		btnNewButton_1.setBounds(243, 577, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}