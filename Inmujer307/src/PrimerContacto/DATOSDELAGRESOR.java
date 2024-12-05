package PrimerContacto;

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
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.MenuInmujer;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DATOSDELAGRESOR extends JFrame {
//Jesus es puto
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();

	JComboBox comboNivel = new JComboBox();
	JComboBox comboEdad = new JComboBox();
	JComboBox comboGrado = new JComboBox();
	JComboBox comboEstadoCivil = new JComboBox();
	JComboBox comboTArma = new JComboBox();
	
	JRadioButton rdservidorSI = new JRadioButton("SI");
	JRadioButton rdservidorNO = new JRadioButton("NO");
	JRadioButton rdportaArmasSI = new JRadioButton("SI");
	JRadioButton rdportaArmasNO = new JRadioButton("NO");
	JRadioButton rdBandaDelictivaSI = new JRadioButton("SI");
	JRadioButton rdBandaDelictivaNO = new JRadioButton("NO");
	JRadioButton rdConsumeSI = new JRadioButton("SI");
	JRadioButton rdConsumeNO = new JRadioButton("NO");
	
	JTextArea txtSeñasP = new JTextArea();
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

	public void InsertarEnBase(String NiveldeRiesgo, String DatosdelAgresor, String GradoEscolar, String EstadoCivil, String RelacionoVinculo, String Domicilio, String ServidorPublico, String Ocupacion, String MediaAfil,String PortaArmas, String Tipo, String PerteneceABanda, String Sustancias, String cual, String Señas) {

		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();

		String sql = "UPDATE datos SET Nivel_de_Riesgo = '"+NiveldeRiesgo+"', Datos_del_Agresor = '"+DatosdelAgresor+"',Grado_escolar = '"+GradoEscolar+"', Estado_Civil_del_Agresor = '"+EstadoCivil+"', Relacion_o_Vinculo = '"+RelacionoVinculo+"', Domicilio_completo = '"+Domicilio+"', Servidor_Publico = '"+ServidorPublico+"', Ocupacion_del_Agresor = '"+Ocupacion+"',Media_filiacion_del_agresor = '"+MediaAfil+"', Porta_armas = '"+PortaArmas+"', Seleccionar_armas = '"+Tipo+"', Pertenece_a_alguna_banda_delictiva = '"+PerteneceABanda+"', Consume_algun_tipo_de_sustancia = '"+Sustancias+"', Cual = '"+cual+"', Señas_particulares = '"+Señas+"' WHERE EXP = '"+DatosGenerales.exp+"'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			int valor = pst.executeUpdate();
			if (valor == 1) {
				System.out.println("Insertado correctamente");
				Efectosfisicos ventana = new Efectosfisicos();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			} else {
				System.out.println("No insertado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void Regresar() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();

		String sql = "SELECT * FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				comboNivel.setSelectedItem(rs.getString("Nivel_de_Riesgo"));
				
				String sqlDatos = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Datos_del_Agresor,'\n',1),'Nombre: ','')) AS nombre_agresor, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Datos_del_Agresor,'\n',2),'\n',-1),'Edad: ','')) AS edad_agresor, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Datos_del_Agresor,'\n',3),'\n',-1),'Fecha de nacimiento: ','')) AS fecha_nacimiento FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstDatos = con.prepareStatement(sqlDatos);
				ResultSet rsDatos = pstDatos.executeQuery();
				if (rsDatos.next()) {
					txtNombre.setText(rsDatos.getString("nombre_agresor"));
					
					String edad = rsDatos.getString("edad_agresor"), e = "";
					if (edad.length()==1) {
						e = "0"+edad;
					} else {
						e = edad;
					}
					comboEdad.setSelectedItem(e);
					
					txtFechadeN.setText(rsDatos.getString("fecha_nacimiento"));
				}
				
				comboGrado.setSelectedItem(rs.getString("Grado_escolar"));
				comboEstadoCivil.setSelectedItem(rs.getString("Estado_Civil_del_Agresor"));
				txtRelacion.setText(rs.getString("Relacion_o_Vinculo"));
				txtDomicilio.setText(rs.getString("Domicilio_completo"));
				
				String servidorPublico = rs.getString("Servidor_Publico");
				if (servidorPublico.equalsIgnoreCase("si")) {
					rdservidorSI.setSelected(true);
				} else if (servidorPublico.equalsIgnoreCase("no")) {
					rdservidorNO.setSelected(true);
				}
				
				txtOcupacion.setText(rs.getString("Ocupacion_del_Agresor"));
				
				String sqlFiliacion = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',1),'Tez: ','')) AS tez, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',2),'\n',-1),'Nariz: ','')) AS nariz, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',3),'\n',-1),'Ojos: ','')) AS ojos, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',4),'\n',-1),'Cabello: ','')) AS cabello, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',5),'\n',-1),'Cara: ','')) AS cara, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',6),'\n',-1),'Cejas: ','')) AS cejas, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',7),'\n',-1),'Labios: ','')) AS labios, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Media_filiacion_del_agresor,'\n',8),'\n',-1),'Complexion: ','')) AS complexion FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstFiliacion = con.prepareStatement(sqlFiliacion);
				ResultSet rsFiliacion = pstFiliacion.executeQuery();
				if (rsFiliacion.next()) {
					txtTez.setText(rsFiliacion.getString("tez"));
					txtNariz.setText(rsFiliacion.getString("nariz"));
					txtOjos.setText(rsFiliacion.getString("ojos"));
					txtCabello.setText(rsFiliacion.getString("cabello"));
					txtCara.setText(rsFiliacion.getString("cara"));
					txtCejas.setText(rsFiliacion.getString("cejas"));
					txtLabios.setText(rsFiliacion.getString("labios"));
					txtComplexion.setText(rsFiliacion.getString("complexion"));
				}
				
				String portaArmas = rs.getString("Porta_armas");
				if (portaArmas.equalsIgnoreCase("si")) {
					rdportaArmasSI.setSelected(true);
				} else if (portaArmas.equalsIgnoreCase("no")) {
					rdportaArmasNO.setSelected(true);
				}
				
				comboTArma.setSelectedItem(rs.getString("Seleccionar_armas"));
				
				String bandaDelictiva = rs.getString("Pertenece_a_alguna_banda_delictiva");
				if (bandaDelictiva.equalsIgnoreCase("si")) {
					rdBandaDelictivaSI.setSelected(true);
				} else if (bandaDelictiva.equalsIgnoreCase("no")) {
					rdBandaDelictivaNO.setSelected(true);
				}
				
				String TSustancia = rs.getString("Consume_algun_tipo_de_sustancia");
				if (TSustancia.equalsIgnoreCase("si")) {
					rdConsumeSI.setSelected(true);
				} else if (TSustancia.equalsIgnoreCase("no")) {
					rdConsumeNO.setSelected(true);
				}
				txtCuales.setText(rs.getString("Cual"));
				
				txtSeñasP.setText(rs.getString("Señas_particulares"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		lblNewLabel_1.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel_1.setBounds(241, 3, 51, 50);
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/butterfly_side_espejo.png")));
		label.setBounds(509, 3, 51, 50);
		panel.add(label);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/encabezadodatos.png")));
		lblNewLabel_2.setBounds(0, 0, 807, 57);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(10, 62, 787, 63);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("NIVEL DE RIESGO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(37, 11, 130, 14);
		panel_1.add(lblNewLabel_3);

		
		comboNivel.setModel(new DefaultComboBoxModel(new String[] {"selecciona una opcion", "Bajo", "Medio", "alto"}));
		comboNivel.setBounds(37, 36, 145, 22);
		panel_1.add(comboNivel);

		JLabel lblNewLabel_4 = new JLabel("NOMBRE COMPLETO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(207, 12, 154, 14);
		panel_1.add(lblNewLabel_4);

		txtNombre = new JTextField();
		txtNombre.setBounds(207, 38, 154, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("EDAD");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(395, 11, 145, 14);
		panel_1.add(lblNewLabel_5);

		
		comboEdad.setModel(new DefaultComboBoxModel(new String[] { "seleccione una opcion", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
				"41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
				"58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74",
				"75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91",
				"92", "93", "94", "95", "96", "97", "98", "99", "" }));
		comboEdad.setForeground(Color.BLACK);
		comboEdad.setBounds(395, 36, 145, 22);
		panel_1.add(comboEdad);

		JLabel lblNewLabel_6 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(569, 11, 177, 14);
		panel_1.add(lblNewLabel_6);

		txtFechadeN = new JTextField();
		txtFechadeN.setBounds(569, 37, 177, 20);
		panel_1.add(txtFechadeN);
		txtFechadeN.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(10, 133, 787, 63);
		contentPane.add(panel_1_1);

		JLabel lblNewLabel_7 = new JLabel("GRADO ESCOLAR");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(68, 11, 131, 14);
		panel_1_1.add(lblNewLabel_7);

		
		comboGrado.setModel(new DefaultComboBoxModel(new String[] { "Selecciona una opcion", "Primaria Trunca",
				"primaria terminada", "Secundaria", "Bachillerato", "Licenciatura", "Posgrado", "Sin estudios" }));
		comboGrado.setBounds(46, 36, 174, 22);
		panel_1_1.add(comboGrado);

		JLabel lblNewLabel_8 = new JLabel("ESTADO CIVIL");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(316, 11, 158, 14);
		panel_1_1.add(lblNewLabel_8);

		JLabel lblNewLabel_10 = new JLabel("RELACION O VINCULO");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(559, 12, 158, 14);
		panel_1_1.add(lblNewLabel_10);

		txtRelacion = new JTextField();
		txtRelacion.setBounds(559, 38, 158, 20);
		panel_1_1.add(txtRelacion);
		txtRelacion.setColumns(10);
		
		
		comboEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Soltera", "Casada", "Divorciada", "Viuda", "Separada", "Union libre", "Comprometida"}));
		comboEstadoCivil.setBounds(316, 36, 158, 22);
		panel_1_1.add(comboEstadoCivil);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1_1.setBounds(10, 203, 787, 63);
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
		lblNewLabel_14.setBounds(346, 35, 67, 14);
		panel_1_1_1.add(lblNewLabel_14);

		
		buttonGroup_1.add(rdservidorSI);
		rdservidorSI.setBackground(new Color(243, 220, 220));
		rdservidorSI.setBounds(413, 11, 41, 23);
		panel_1_1_1.add(rdservidorSI);

		
		buttonGroup_1.add(rdservidorNO);
		rdservidorNO.setBackground(new Color(243, 220, 220));
		rdservidorNO.setBounds(413, 37, 56, 23);
		panel_1_1_1.add(rdservidorNO);

		JLabel lblNewLabel_15 = new JLabel("OCUPACION");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(486, 11, 158, 14);
		panel_1_1_1.add(lblNewLabel_15);

		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(486, 30, 158, 20);
		panel_1_1_1.add(txtOcupacion);
		txtOcupacion.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("CARACTERISTICAS");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_16.setBounds(117, 273, 161, 14);
		contentPane.add(lblNewLabel_16);

		JLabel lblNewLabel_18 = new JLabel("DEL AGRESOR");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_18.setBounds(117, 298, 161, 14);
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
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23.setBounds(10, 11, 139, 14);
		panel_1_1_1_1_1.add(lblNewLabel_23);

		
		buttonGroup_2.add(rdportaArmasSI);
		rdportaArmasSI.setBackground(new Color(243, 220, 220));
		rdportaArmasSI.setBounds(53, 32, 50, 23);
		panel_1_1_1_1_1.add(rdportaArmasSI);

		
		buttonGroup_2.add(rdportaArmasNO);
		rdportaArmasNO.setBackground(new Color(243, 220, 220));
		rdportaArmasNO.setBounds(53, 58, 50, 23);
		panel_1_1_1_1_1.add(rdportaArmasNO);

		JLabel lblNewLabel_24 = new JLabel("SELECCIONE ARMAS");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(211, 11, 152, 14);
		panel_1_1_1_1_1.add(lblNewLabel_24);

		
		comboTArma.setModel(new DefaultComboBoxModel(
				new String[] { "selecciona una opcion", "Pistola", "Punzocortante", "Contundente" }));
		comboTArma.setBounds(211, 32, 152, 22);
		panel_1_1_1_1_1.add(comboTArma);

		JLabel lblNewLabel_25 = new JLabel("\u00BFPERTENECE A ALGUNA ");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_25.setBounds(10, 94, 157, 14);
		panel_1_1_1_1_1.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("BANDA DELICTIVA?");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_26.setBounds(20, 108, 139, 14);
		panel_1_1_1_1_1.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("\u00BFCONSUME ALGUN ");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_27.setBounds(211, 94, 152, 14);
		panel_1_1_1_1_1.add(lblNewLabel_27);

		JLabel lblNewLabel_28 = new JLabel("TIPO DE SUSTANCIA?");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_28.setBounds(206, 108, 157, 14);
		panel_1_1_1_1_1.add(lblNewLabel_28);

		
		buttonGroup_3.add(rdBandaDelictivaSI);
		rdBandaDelictivaSI.setBackground(new Color(243, 220, 220));
		rdBandaDelictivaSI.setBounds(53, 129, 50, 23);
		panel_1_1_1_1_1.add(rdBandaDelictivaSI);

		
		buttonGroup_3.add(rdBandaDelictivaNO);
		rdBandaDelictivaNO.setBackground(new Color(243, 220, 220));
		rdBandaDelictivaNO.setBounds(53, 155, 50, 23);
		panel_1_1_1_1_1.add(rdBandaDelictivaNO);

		
		buttonGroup_4.add(rdConsumeSI);
		rdConsumeSI.setBackground(new Color(243, 220, 220));
		rdConsumeSI.setBounds(251, 129, 50, 23);
		panel_1_1_1_1_1.add(rdConsumeSI);

		
		buttonGroup_4.add(rdConsumeNO);
		rdConsumeNO.setBackground(new Color(243, 220, 220));
		rdConsumeNO.setBounds(251, 155, 50, 23);
		panel_1_1_1_1_1.add(rdConsumeNO);

		JLabel lblNewLabel_23_1 = new JLabel("CUAL?");
		lblNewLabel_23_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23_1.setBounds(216, 185, 130, 14);
		panel_1_1_1_1_1.add(lblNewLabel_23_1);

		JLabel lblNewLabel_29 = new JLabel("SE\u00D1AS PARTICULARES");
		lblNewLabel_29.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_29.setBounds(10, 185, 149, 14);
		panel_1_1_1_1_1.add(lblNewLabel_29);

		txtCuales = new JTextField();
		txtCuales.setBounds(215, 201, 131, 20);
		panel_1_1_1_1_1.add(txtCuales);
		txtCuales.setColumns(10);

		
		txtSeñasP.setBounds(10, 210, 149, 61);
		panel_1_1_1_1_1.add(txtSeñasP);

		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DatosdelAgresor = "";
				if (!txtNombre.getText().isEmpty()) {
					DatosdelAgresor += "Nombre: " + txtNombre.getText() + "\n";
				} else {
					DatosdelAgresor += "Nombre: Dato no dado" + "\n";
				}
				if (comboEdad.getSelectedIndex() == 0) {
					DatosdelAgresor += "Edad: dato no dado"+"\n";
				} else {
					DatosdelAgresor += "Edad: " + comboEdad.getSelectedItem().toString() + "\n";
				}
				if (!txtFechadeN.getText().isEmpty()) {
					DatosdelAgresor += "Fecha de nacimiento: " + txtFechadeN.getText();
				} else {
					DatosdelAgresor += "Fecha de nacimiento: dato no dado";
				}

				String NiveldeRiesgo = comboNivel.getSelectedItem().toString();
				String GradoEscolar = comboGrado.getSelectedItem().toString();
				String EstadoCivil = comboEstadoCivil.getSelectedItem().toString();
				
				String RelacionoVinculo = txtRelacion.getText();
				String Domicilio = txtDomicilio.getText();
				String ServidorPublico = "";
				if (rdservidorSI.isSelected()) {
					ServidorPublico = "Si";
				} else if (rdservidorNO.isSelected()) {
					ServidorPublico = "No";
				} else {
					ServidorPublico = "";
				}
				String Ocupacion = txtOcupacion.getText();
				String MediaAfil = "Tez: " + txtTez.getText() + "\n" + "Nariz: " + txtNariz.getText() + "\n" + "Ojos: "
						+ txtOjos.getText() + "\n" + "Cabello: " + txtCabello.getText() + "\n" + "Cara: "
						+ txtCara.getText() + "\n" + "Cejas: " + txtCejas.getText() + "\n" + "Labios: "
						+ txtLabios.getText() + "\n" + "Complexion: " + txtComplexion.getText();
				String PortaArmas = "";
				if (rdportaArmasSI.isSelected()) {
					PortaArmas = "Si";
				} else if (rdportaArmasNO.isSelected()) {
					PortaArmas = "No";
				}
				String Tipo = comboTArma.getSelectedItem().toString();
				String PerteneceABanda = "";
				if (rdBandaDelictivaSI.isSelected()) {
					PerteneceABanda = "Si";
				} else if (rdBandaDelictivaNO.isSelected()) {
					PerteneceABanda = "No";
				} else {
					PerteneceABanda = "Dato no dado";
				}
				String Sustancias = "";
				if (rdConsumeSI.isSelected()) {
					Sustancias = "Si";
				} else if (rdConsumeNO.isSelected()) {
					Sustancias = "No";
				} else {
					Sustancias = "Dato no dado";
				}
				String Señas = txtSeñasP.getText();
				String cual = txtCuales.getText();

				InsertarEnBase(NiveldeRiesgo, DatosdelAgresor, GradoEscolar, EstadoCivil, RelacionoVinculo, Domicilio,
						ServidorPublico, Ocupacion, MediaAfil, PortaArmas, Tipo, PerteneceABanda, Sustancias, cual,
						Señas);
			}
		});
		btnContinuar.setBounds(229, 248, 117, 23);
		panel_1_1_1_1_1.add(btnContinuar);

		JLabel lblNewLabel_16_1 = new JLabel("PARTICULARIDADES");
		lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_16_1.setBounds(536, 273, 176, 14);
		contentPane.add(lblNewLabel_16_1);

		JLabel lblNewLabel_18_1 = new JLabel("DEL AGRESOR");
		lblNewLabel_18_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_18_1.setBounds(536, 298, 176, 14);
		contentPane.add(lblNewLabel_18_1);

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
					ConexionInmujer conexion = new ConexionInmujer();
					Connection con = conexion.conectar();
					
					String sql = "DELETE FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
					
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						int valor = pst.executeUpdate();
						if (valor==1) {
							System.out.println("Éxito en eliminar expediente");
						}
						MenuInmujer ventana = new MenuInmujer();
						ventana.setVisible(true);
						ventana.setLocationRelativeTo(null);
						dispose();
					} catch (Exception e1) {
						// TODO: handle exception
					}
				} else if (opcion == JOptionPane.NO_OPTION) {
					
				}

			}
		});
		btnInicio.setBounds(37, 579, 89, 23);
		contentPane.add(btnInicio);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Violencia ventana = new Violencia();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				ventana.Regresar();
				dispose();
			}
		});
		btnNewButton.setBounds(224, 577, 89, 23);
		contentPane.add(btnNewButton);
	}
}