package clases;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DATOSDELAGRESOR extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtFechadeN;
	private JTextField txtRelacion;
	private JTextField txtDomicilio;
	private JTextField txtOcupacion;
	private JTextField txtTez;
	private JTextField txtOjos;
	private JTextField txtCara;
	private JTextField txtLabios;
	private JTextField txtNariz;
	private JTextField txtCabello;
	private JTextField txtCejas;
	private JTextField txtComplexion;
	private JTextField txtCuales;

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
	
	public void InsertarEnBase(String EstadoCivil, String Nombre, String Edad , String Fechadenacimiento, String GradoEscolar, String NivelDeRiesgo, String Relacion,String ServidorPublico, String Ocupacion, String Tez, String Nariz, String Ojos, String Cabello, String Cara, String Cejas, String Labios, String Complexion, String PortaArmas, String SelecArma, String PerteneceABanda, String ConsumeSustancia, String Señas, String Cual) {
		
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "UPDATE datos SET  Estado_Civil = '',Edad = '',Fecha_de_nacimiento='', Grado_escolar = '',Nivel_de_Riesgo = '',Relacion_o_Vinculo = '', Servidor_Publico = '', Ocupacion = '', Porta_armas = '', Pertenece_a_alguna_banda_delictiva = '', Consume_algún_tipo_de_sustancia = '', Señas_particulares = '', Cual = '',Media_filiación_del_agresor = '' WHERE Nombre = ''";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					
				} while (rs.next());
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
		
		JComboBox comboNivel = new JComboBox();
		comboNivel.setModel(new DefaultComboBoxModel(new String[] {"selecciona una opcion", "Bajo", "Medio", "alto"}));
		comboNivel.setBounds(37, 36, 130, 22);
		panel_1.add(comboNivel);
		
		JLabel lblNewLabel_4 = new JLabel("NOMBRE COMPLETO");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(210, 11, 118, 14);
		panel_1.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 37, 154, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("EDAD");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(406, 11, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JComboBox comboEdad = new JComboBox();
		comboEdad.setModel(new DefaultComboBoxModel(new String[] {"seleccione una opcion", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", ""}));
		comboEdad.setForeground(Color.BLACK);
		comboEdad.setBounds(371, 36, 130, 22);
		panel_1.add(comboEdad);
		
		JLabel lblNewLabel_6 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(530, 11, 135, 14);
		panel_1.add(lblNewLabel_6);
		
		txtFechadeN = new JTextField();
		txtFechadeN.setBounds(511, 37, 177, 20);
		panel_1.add(txtFechadeN);
		txtFechadeN.setColumns(10);
		
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
		
		JComboBox comboGrado = new JComboBox();
		comboGrado.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opcion", "Primaria Trunca", "primaria terminada", "Secundaria", "Bachillerato", "Licenciatura", "Posgrado", "Sin estudios"}));
		comboGrado.setBounds(68, 36, 131, 22);
		panel_1_1.add(comboGrado);
		
		JLabel lblNewLabel_8 = new JLabel("ESTADO");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(215, 11, 54, 14);
		panel_1_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CIVIL :");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(236, 24, 46, 14);
		panel_1_1.add(lblNewLabel_9);
		
		JRadioButton rdestSolt = new JRadioButton("SOLTERO/A");
		rdestSolt.setBackground(new Color(243, 220, 220));
		rdestSolt.setBounds(281, 7, 83, 23);
		panel_1_1.add(rdestSolt);
		
		JRadioButton rdestViud = new JRadioButton("VIUDO/A");
		rdestViud.setBackground(new Color(243, 220, 220));
		rdestViud.setBounds(281, 36, 83, 23);
		panel_1_1.add(rdestViud);
		
		JRadioButton rdestCasad = new JRadioButton("CASADO/A");
		rdestCasad.setBackground(new Color(243, 220, 220));
		rdestCasad.setBounds(377, 7, 109, 23);
		panel_1_1.add(rdestCasad);
		
		JLabel lblNewLabel_10 = new JLabel("RELACION O VINCULO");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(507, 11, 130, 14);
		panel_1_1.add(lblNewLabel_10);
		
		txtRelacion = new JTextField();
		txtRelacion.setBounds(497, 37, 153, 20);
		panel_1_1.add(txtRelacion);
		txtRelacion.setColumns(10);
		
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
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(161, 27, 158, 20);
		panel_1_1_1.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("SERVIDOR");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_13.setBounds(346, 15, 67, 14);
		panel_1_1_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("PUBLICO :");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_14.setBounds(346, 30, 67, 14);
		panel_1_1_1.add(lblNewLabel_14);
		
		JRadioButton rdservidorSI = new JRadioButton("SI");
		rdservidorSI.setBackground(new Color(243, 220, 220));
		rdservidorSI.setBounds(413, 11, 41, 23);
		panel_1_1_1.add(rdservidorSI);
		
		JRadioButton rdservidorNO = new JRadioButton("NO");
		rdservidorNO.setBackground(new Color(243, 220, 220));
		rdservidorNO.setBounds(413, 37, 41, 23);
		panel_1_1_1.add(rdservidorNO);
		
		JLabel lblNewLabel_15 = new JLabel("OCUPACION");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(529, 11, 80, 14);
		panel_1_1_1.add(lblNewLabel_15);
		
		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(486, 30, 158, 20);
		panel_1_1_1.add(txtOcupacion);
		txtOcupacion.setColumns(10);
		
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
		
		txtTez = new JTextField();
		txtTez.setBounds(25, 36, 139, 20);
		panel_1_1_1_1.add(txtTez);
		txtTez.setColumns(10);
		
		txtOjos = new JTextField();
		txtOjos.setBounds(25, 94, 139, 20);
		panel_1_1_1_1.add(txtOjos);
		txtOjos.setColumns(10);
		
		txtCara = new JTextField();
		txtCara.setBounds(25, 143, 139, 20);
		panel_1_1_1_1.add(txtCara);
		txtCara.setColumns(10);
		
		txtLabios = new JTextField();
		txtLabios.setBounds(25, 197, 139, 20);
		panel_1_1_1_1.add(txtLabios);
		txtLabios.setColumns(10);
		
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
		
		txtNariz = new JTextField();
		txtNariz.setColumns(10);
		txtNariz.setBounds(206, 36, 139, 20);
		panel_1_1_1_1.add(txtNariz);
		
		JLabel lblNewLabel_19_1 = new JLabel("CABELLO");
		lblNewLabel_19_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19_1.setBounds(246, 75, 63, 14);
		panel_1_1_1_1.add(lblNewLabel_19_1);
		
		txtCabello = new JTextField();
		txtCabello.setColumns(10);
		txtCabello.setBounds(206, 94, 139, 20);
		panel_1_1_1_1.add(txtCabello);
		
		JLabel lblNewLabel_21_1 = new JLabel("CEJAS");
		lblNewLabel_21_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_21_1.setBounds(253, 126, 46, 14);
		panel_1_1_1_1.add(lblNewLabel_21_1);
		
		txtCejas = new JTextField();
		txtCejas.setColumns(10);
		txtCejas.setBounds(206, 143, 139, 20);
		panel_1_1_1_1.add(txtCejas);
		
		txtComplexion = new JTextField();
		txtComplexion.setColumns(10);
		txtComplexion.setBounds(206, 197, 139, 20);
		panel_1_1_1_1.add(txtComplexion);
		
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
		
		JRadioButton rdportaArmasSI = new JRadioButton("SI");
		rdportaArmasSI.setBackground(new Color(243, 220, 220));
		rdportaArmasSI.setBounds(53, 32, 50, 23);
		panel_1_1_1_1_1.add(rdportaArmasSI);
		
		JRadioButton rdportaArmasNO = new JRadioButton("NO");
		rdportaArmasNO.setBackground(new Color(243, 220, 220));
		rdportaArmasNO.setBounds(53, 58, 50, 23);
		panel_1_1_1_1_1.add(rdportaArmasNO);
		
		JLabel lblNewLabel_24 = new JLabel("SELECCIONE ARMAS");
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(184, 11, 117, 14);
		panel_1_1_1_1_1.add(lblNewLabel_24);
		
		JComboBox comboTArma = new JComboBox();
		comboTArma.setModel(new DefaultComboBoxModel(new String[] {"selecciona una opcion", "Pistola", "Punzocortante", "Contundente"}));
		comboTArma.setBounds(184, 32, 130, 22);
		panel_1_1_1_1_1.add(comboTArma);
		
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
		
		JRadioButton rdBandaDelictivaSI = new JRadioButton("SI");
		rdBandaDelictivaSI.setBackground(new Color(243, 220, 220));
		rdBandaDelictivaSI.setBounds(53, 129, 50, 23);
		panel_1_1_1_1_1.add(rdBandaDelictivaSI);
		
		JRadioButton rdBandaDelictivaNO = new JRadioButton("NO");
		rdBandaDelictivaNO.setBackground(new Color(243, 220, 220));
		rdBandaDelictivaNO.setBounds(53, 155, 50, 23);
		panel_1_1_1_1_1.add(rdBandaDelictivaNO);
		
		JRadioButton rdConsumeSI = new JRadioButton("SI");
		rdConsumeSI.setBackground(new Color(243, 220, 220));
		rdConsumeSI.setBounds(211, 129, 50, 23);
		panel_1_1_1_1_1.add(rdConsumeSI);
		
		JRadioButton rdConsumeNO = new JRadioButton("NO");
		rdConsumeNO.setBackground(new Color(243, 220, 220));
		rdConsumeNO.setBounds(211, 155, 50, 23);
		panel_1_1_1_1_1.add(rdConsumeNO);
		
		JLabel lblNewLabel_23_1 = new JLabel("CUAL?");
		lblNewLabel_23_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23_1.setBounds(216, 185, 85, 14);
		panel_1_1_1_1_1.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_29 = new JLabel("SE\u00D1AS PARTICULARES");
		lblNewLabel_29.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_29.setBounds(10, 185, 137, 14);
		panel_1_1_1_1_1.add(lblNewLabel_29);
		
		txtCuales = new JTextField();
		txtCuales.setBounds(215, 201, 131, 20);
		panel_1_1_1_1_1.add(txtCuales);
		txtCuales.setColumns(10);
		
		JTextArea txtSeñasP = new JTextArea();
		txtSeñasP.setBounds(10, 210, 149, 61);
		panel_1_1_1_1_1.add(txtSeñasP);
		
		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				Efectosfisicos sigventana = new Efectosfisicos();
				dispose();
				sigventana.setVisible(true);
			}
		});
		btnContinuar.setBounds(229, 248, 117, 23);
		panel_1_1_1_1_1.add(btnContinuar);
		
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
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				Violencia antventana = new Violencia();
				dispose();
				antventana.setVisible(true);
			}
		});
		btnRegresar.setBounds(10, 577, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] opciones = {"Aceptar","Cancelar"};
				int opcion = JOptionPane.showOptionDialog(null,
						"¿Está seguro de que quiere regresar? Todos los datos ingresados se perderán",
						"Confirmación",
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE,
						null,
						opciones,
						opciones[0]);
				if (opcion== JOptionPane.YES_OPTION) {
					
				} else if (opcion == JOptionPane.NO_OPTION) {
					
				}
				
			}
		});
		btnInicio.setBounds(243, 577, 89, 23);
		contentPane.add(btnInicio);
	}
}