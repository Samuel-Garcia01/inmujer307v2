package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DatosGenerales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	JComboBox combodos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosGenerales frame = new DatosGenerales();
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
	public DatosGenerales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 659);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(10, 97, 568, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO PATERNO");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(33, 35, 132, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(243, 220, 220));
		textField.setForeground(Color.BLACK);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(23, 11, 138, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO MATERNO");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(206, 35, 132, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(243, 220, 220));
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(192, 11, 138, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NOMBRE/S");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(418, 35, 78, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBackground(new Color(243, 220, 220));
		textField_2.setBounds(386, 11, 122, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2.setBackground(new Color(243, 220, 220));
		panel_2.setBounds(588, 92, 211, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBoxestadocivil = new JComboBox();
		comboBoxestadocivil.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Soltera", "Casada", "Viuda"}));
		comboBoxestadocivil.setBackground(new Color(243, 220, 220));
		comboBoxestadocivil.setBounds(10, 11, 191, 22);
		panel_2.add(comboBoxestadocivil);
		
		JLabel lblNewLabel_4 = new JLabel("ESTADO CIVIL");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(67, 38, 120, 14);
		panel_2.add(lblNewLabel_4);
		
		JComboBox comboBoxserviciomedico = new JComboBox();
		comboBoxserviciomedico.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "IMSS ", "ISSEMYM", "ISSSTE", "ISSFAM", "Otro", "Sin seguro"}));
		comboBoxserviciomedico.setBackground(new Color(243, 220, 220));
		comboBoxserviciomedico.setBounds(10, 60, 191, 22);
		panel_2.add(comboBoxserviciomedico);
		
		JLabel lblNewLabel_5 = new JLabel("SERVICIO MEDICO");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(54, 85, 114, 14);
		panel_2.add(lblNewLabel_5);
		
		JComboBox comboBoxgradoestudios = new JComboBox();
		comboBoxgradoestudios.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Primaria trunca", "Primaria terminada", "Secundaria", "Bachillerato", "Licenciatura", "Posgrado", "Sin estudios"}));
		comboBoxgradoestudios.setBackground(new Color(243, 220, 220));
		comboBoxgradoestudios.setBounds(10, 107, 191, 22);
		panel_2.add(comboBoxgradoestudios);
		
		JLabel lblNewLabel_6 = new JLabel("GRADO DE ESTUDIOS");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(54, 132, 147, 14);
		panel_2.add(lblNewLabel_6);
		
		JComboBox comboBoxedad = new JComboBox();
		comboBoxedad.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion"}));
		for (int i = 1; i <= 99; i++) {
			String E = String.valueOf(i);
			String edad = "";
			if (E.length()==1) {
				edad = "0"+E;
				
			}else {
				edad = E;
			}
          comboBoxedad.addItem(edad);
			
		}
		comboBoxedad.setBackground(new Color(243, 220, 220));
		comboBoxedad.setBounds(10, 157, 191, 22);
		panel_2.add(comboBoxedad);
		
		JLabel lblNewLabel_7 = new JLabel("EDAD");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(94, 179, 49, 14);
		panel_2.add(lblNewLabel_7);
		
		JComboBox comboBoxdia = new JComboBox();
		comboBoxdia.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion"}));
		for (int i = 1; i <= 31; i++) {
			String d = String.valueOf(i);
			String dia = "";
			if (d.length()==1) {
				dia = "0"+d;
				
			}else {
				dia = d;
			}
          comboBoxdia.addItem(dia);
			
		}
		comboBoxdia.setBackground(new Color(243, 220, 220));
		comboBoxdia.setBounds(10, 204, 191, 22);
		panel_2.add(comboBoxdia);
		
		JLabel lblNewLabel_8 = new JLabel("DIA");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(94, 229, 49, 14);
		panel_2.add(lblNewLabel_8);
		
		JComboBox comboBoxmes = new JComboBox();
		comboBoxmes.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion"}));
		for (int i = 1; i <= 12; i++) {
			String m = String.valueOf(i);
			String mes = "";
			if (m.length()==1) {
				mes = "0"+m;
				
			}else {
				mes = m;
			}
          comboBoxmes.addItem(mes);
			
		}
		comboBoxmes.setBackground(new Color(243, 220, 220));
		comboBoxmes.setBounds(10, 254, 191, 22);
		panel_2.add(comboBoxmes);
		
		JLabel lblNewLabel_9 = new JLabel("MES");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(94, 278, 49, 14);
		panel_2.add(lblNewLabel_9);
		
		JComboBox comboBoxanio = new JComboBox();
		comboBoxanio.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion"}));
		for (int i = 1940; i <=2020; i++) {
			comboBoxanio.addItem(i);
			
		}
		comboBoxanio.setBackground(new Color(243, 220, 220));
		comboBoxanio.setBounds(10, 303, 191, 22);
		panel_2.add(comboBoxanio);
		
		JLabel lblNewLabel_10 = new JLabel("AÑO");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(94, 328, 49, 14);
		panel_2.add(lblNewLabel_10);
		
		JComboBox comboBoxvivienda = new JComboBox();
		comboBoxvivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Familiar", "Propia", "Rentada", "Prestada"}));
		comboBoxvivienda.setBackground(new Color(243, 220, 220));
		comboBoxvivienda.setBounds(10, 351, 191, 22);
		panel_2.add(comboBoxvivienda);
		
		JLabel lblNewLabel_11 = new JLabel("VIVIENDA");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_11.setBounds(83, 372, 165, 14);
		panel_2.add(lblNewLabel_11);
		
		JComboBox comboBoxNopersonas = new JComboBox();
		comboBoxNopersonas.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		comboBoxNopersonas.setBackground(new Color(243, 220, 220));
		comboBoxNopersonas.setBounds(10, 397, 191, 22);
		panel_2.add(comboBoxNopersonas);
		
		JLabel lblNewLabel_12 = new JLabel("NO. PERSONAS");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_12.setBounds(66, 420, 168, 14);
		panel_2.add(lblNewLabel_12);
		
		JComboBox comboBoxcontribuyentealgasto = new JComboBox();
		comboBoxcontribuyentealgasto.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Mama", "Papa", "Esposo", "Esposa", "Abuelos", "Concubino(a)", "Hijo(a)"}));
		comboBoxcontribuyentealgasto.setBackground(new Color(243, 220, 220));
		comboBoxcontribuyentealgasto.setBounds(10, 447, 191, 22);
		panel_2.add(comboBoxcontribuyentealgasto);
		
		JLabel lblNewLabel_13 = new JLabel("CONTRIBUYENTE AL GASTO");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_13.setBounds(32, 472, 194, 14);
		panel_2.add(lblNewLabel_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_3.setBackground(new Color(243, 220, 220));
		panel_3.setBounds(10, 175, 568, 103);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox combouno = new JComboBox();
		combouno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (combouno.getSelectedItem().equals("54900")) {
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("selecciona una opcion");
					combodos.addItem("Barrio Belém");
					combodos.addItem("Barrio La Concepción");
					combodos.addItem("Barrio Los Reyes");
					combodos.addItem("Barrio Nativitas");
					combodos.addItem("Barrio San Bartolo");
					combodos.addItem("Barrio San Juan");
					combodos.addItem("Barrio Santiaguito");
					combodos.addItem("Colonia Tultitlán de Mariano Escobedo Centro");
					combodos.addItem("Condominio Residencial los Reyes");
				}else if (combouno.getSelectedItem().equals("54910")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Fuentes del Valle");
					combodos.addItem("Fraccionamiento Villas de San José");
					combodos.addItem("Colonia Villa Esmeralda");
					combodos.addItem("Condominio Los Agaves Tultitlán");
					combodos.addItem("Condominio Los Portales");
					combodos.addItem("Colonia La Mariscala");
					combodos.addItem("Ranchería La Ponderosa");
					combodos.addItem("Condominio Jardines de Tultitlán");
					combodos.addItem("Zona comercial Central de Abastos");

					
				}else if (combouno.getSelectedItem().equals("54913")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento COCEM");
					combodos.addItem("Condominio Sol de Tultitlán (Zona Oriente)");
					combodos.addItem("Colonia Recursos Hidráulicos");
					combodos.addItem("Condominio Villas Jardín");
					combodos.addItem("Condominio Bosques de Tultitlán");
					combodos.addItem("Unidad habitacional Quinta el Ángel");
					combodos.addItem("Condominio Ampliación COCEM");
					combodos.addItem("Fraccionamiento Residencial del Sol");

					
				}else if (combouno.getSelectedItem().equals("54914")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Condominio Unidad Electricistas");

				}else if (combouno.getSelectedItem().equals("54915")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Independencia");
					combodos.addItem("Condominio El Obelisco");
					combodos.addItem("Zona industrial Independencia");
					combodos.addItem("Colonia Los Reyes");
					combodos.addItem("Condominio Porto Alegre");
					combodos.addItem("Residencial Rincón Colonial");
	
				}else if (combouno.getSelectedItem().equals("54916")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
				combodos.addItem("Colonia Lázaro Cárdenas (Zona Hornos)");	
					
				}else if (combouno.getSelectedItem().equals("54918")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Parque industrial Cartagena");
					combodos.addItem("Parque industrial Tultitlán");
					combodos.addItem("Colonia El Cueyamil");

				}else if (combouno.getSelectedItem().equals("54920")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Condominio Hogares de Castera");
					combodos.addItem("Fraccionamiento Jardines de los Claustros III");
					combodos.addItem("Fraccionamiento San Pablo Castera II");
					combodos.addItem("Condominio Estrella de Tultitlán (Lote 55 Pte.)");

					
				}else if (combouno.getSelectedItem().equals("54924")){
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Llanuras");
					combodos.addItem("Condominio El Kiosco");
					combodos.addItem("Condominio Conjunto Cristal");
					combodos.addItem("Condominio Lote 104 (Tehuantepec)");

					
				}else if (combouno.getSelectedItem().equals("54925")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Hacienda San Pablo");
					combodos.addItem("Unidad habitacional Las Manzanas");
					combodos.addItem("Condominio Prados B");

				}else if (combouno.getSelectedItem().equals("54926")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Estepas");
					combodos.addItem("Condominio Lote 55 (Los Tejados)");
					combodos.addItem("Condominio Sustitución Arista");
					combodos.addItem("Condominio Los Agaves (Lote 71)");
					combodos.addItem("Fraccionamiento Galaxias Tultitlán");

					
				}else if (combouno.getSelectedItem().equals("54927")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Las Tórtolas");
					combodos.addItem("Unidad habitacional Mariano Escobedo (los Faroles)");
					combodos.addItem("Colonia Hogares de Castera Lote 73");
					combodos.addItem("Condominio Lote 41 (El Carmen)");
					combodos.addItem("Colonia Emilio Chuayffet");
	
				}else if (combouno.getSelectedItem().equals("54929")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Alborada I");
					combodos.addItem("Unidad habitacional La Alborada Vallas");
					combodos.addItem("Unidad habitacional Nuevo INFONAVIT");
					combodos.addItem("Fraccionamiento Unidad Morelos 3ra. Sección INFONAVIT");
					combodos.addItem("Condominio Lote 12 (Crepúsculo)");
					combodos.addItem("Condominio Villas Loreto");
					combodos.addItem("Fraccionamiento Jardines de los Claustros VI");

					
				}else if (combouno.getSelectedItem().equals("54930")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Granjas San Pablo");
					combodos.addItem("Fraccionamiento Izcalli Rinconada");
					combodos.addItem("Fraccionamiento Jardines de los Claustros IV");
					combodos.addItem("Fraccionamiento Jardines de los Claustros V");
					combodos.addItem("Unidad habitacional La Granja");
					combodos.addItem("Condominio Llanura Verde");
					combodos.addItem("Condominio Pensamientos");
					combodos.addItem("Unidad habitacional San Pablo de las Salinas");
					combodos.addItem("Pueblo San Pablo de las Salinas");
					combodos.addItem("Fraccionamiento Solidaridad Social (Lote 105)");
					combodos.addItem("Fraccionamiento Unidad Morelos 2da. Sección");
					combodos.addItem("Condominio Lote 92 (Las Rosas)");
					combodos.addItem("Condominio Las Granjas");
					combodos.addItem("Condominio Privada los Prados");
					combodos.addItem("Condominio Solar San Pablo");
					combodos.addItem("Condominio Quintas San Pablo");
					combodos.addItem("Colonia Lomas de San Pablo");

					
				}else if (combouno.getSelectedItem().equals("54932")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Magnolias");
					combodos.addItem("Condominio Conjunto Fortuna");
					combodos.addItem("Fraccionamiento IMMEX II");
					combodos.addItem("Condominio Isidro Fabela");
					combodos.addItem("Fraccionamiento Magnolias 2000");
					combodos.addItem("Condominio Lote 105 (Ébano)");
					combodos.addItem("Condominio Villas de San Pablo");
					combodos.addItem("Fraccionamiento Residencial Magnolias");
					combodos.addItem("Condominio San Pablo III-B");
					combodos.addItem("Condominio San Pablo III-A");
					combodos.addItem("Fraccionamiento Residencial San Pablo II");
					combodos.addItem("Condominio Villas San Pablo (Lote 117 Sur)");	
				}else if (combouno.getSelectedItem().equals("54933")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Condominio Azul Cielo");
					combodos.addItem("Condominio Coyoli Martínez");
					combodos.addItem("Fraccionamiento Izcalli San Pablo");
					combodos.addItem("Condominio Jardines de San Pablo");
					combodos.addItem("Condominio Parque de San Pablo");
					combodos.addItem("Condominio Verde Claro");
					combodos.addItem("Condominio Lote 93 (Amalia)");
					combodos.addItem("Condominio El Campanario");
					combodos.addItem("Fraccionamiento Plaza Jardines");
					combodos.addItem("Condominio Residencial La Esperanza");

					
				}else if (combouno.getSelectedItem().equals("54934")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Condominio El Rocío");
					combodos.addItem("Condominio Gustavo Baz");
					combodos.addItem("Condominio Prados A");	
				}else if (combouno.getSelectedItem().equals("54935")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Unidad habitacional Casas Alfa");
					combodos.addItem("Condominio Casitas San Pablo");
					combodos.addItem("Fraccionamiento Jardines de los Claustros I");
					combodos.addItem("Fraccionamiento Jardines de los Claustros II");
					combodos.addItem("Fraccionamiento Alborada II");
					combodos.addItem("Condominio La Isla");
					combodos.addItem("Fraccionamiento Unidad Morelos 3ra. Sección");
					combodos.addItem("Condominio Residencial Morelos");
					combodos.addItem("Condominio Lote 84 (Las Adelas)");
					combodos.addItem("Condominio Lote 82 (Guillermo González C.)");
					combodos.addItem("Condominio El Faro (Lote 3 Pte.)");
					combodos.addItem("Condominio Conjunto San Pablo");
					combodos.addItem("Condominio Lote 52 (Torres Tultitlán)");
					combodos.addItem("Colonia Las Calderas");
					combodos.addItem("Condominio Portal San Pablo");
					combodos.addItem("Condominio Portal San Pablo II");
					combodos.addItem("Condominio Las Almenas");
					combodos.addItem("Unidad habitacional Lava 46");
					combodos.addItem("Condominio Las Fuentes");
					combodos.addItem("Colonia Las Chinampas");
	
				}else if (combouno.getSelectedItem().equals("54938")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Ampliación San Pablo de las Salinas");
					combodos.addItem("Condominio Lote 64 (Octavio Paz)");
					combodos.addItem("Condominio Lote 47 (El Reloj Residencial)");
					combodos.addItem("Condominio Lote 48 (El Reloj Cronos)");
					combodos.addItem("Unidad habitacional Arboledas (lote 49)");
					combodos.addItem("Condominio Lote 62 (Juan Rulfo)");
					combodos.addItem("Condominio Arcos I");
					combodos.addItem("Condominio Lote 50 B (Las Laderas)");
					combodos.addItem("Condominio Lote 46 (El Reloj Villas)");
					combodos.addItem("Condominio Lote 63 Conjunto Pilares");
					combodos.addItem("Condominio Lote 50 A");
					combodos.addItem("Condominio Lote 50 D");
					combodos.addItem("Condominio Lote 50 C (Real De Tultitlán)");
					combodos.addItem("Condominio Lote 59 (Torres del Reloj)");
					combodos.addItem("Condominio Lote 76 (El Reloj)");
					combodos.addItem("Condominio El Laurel");
					combodos.addItem("Condominio Villas Tultitlán (Lote 65)");
					combodos.addItem("Condominio Arcos V");
					combodos.addItem("Condominio Arcos IV");
					combodos.addItem("Condominio Arcos III");
					combodos.addItem("Condominio Arcos II");
					combodos.addItem("Condominio Villas Santa Teresita");
					combodos.addItem("Condominio Bonito Tultitlán (lote 60)");
					combodos.addItem("Condominio El Alcázar");
					combodos.addItem("Condominio Arcos VI");

					
				}else if(combouno.getSelectedItem().equals("54939")){
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Paraje San Pablito");

					
				}else if (combouno.getSelectedItem().equals("54940")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Lechería");
					combodos.addItem("Zona industrial Corredor Lechería-Cuautitlán");

					
				}else if (combouno.getSelectedItem().equals("54942")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Benito Juárez");
					combodos.addItem("Colonia La Libertad");
					combodos.addItem("Colonia Ampliación Las Torres Segunda Sección");
					combodos.addItem("Colonia Las Torres I");

					
				}else if (combouno.getSelectedItem().equals("54943")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Ciudad Labor");
					combodos.addItem("Colonia Ojo de Agua Primera Sección");
					combodos.addItem("Colonia Ojo de Agua Segunda Sección");

				}else if(combouno.getSelectedItem().equals("54944")){
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Pueblo San Francisco Chilpan");
					combodos.addItem("Colonia Buenavista Parte Alta");
					combodos.addItem("Colonia El Fresno");
					combodos.addItem("Colonia La Joya");
					combodos.addItem("Condominio La Loma I");
					combodos.addItem("Fraccionamiento Villas de San Francisco Chilpan");
					combodos.addItem("Colonia Santa Clara");
					combodos.addItem("Colonia Buenavista Parte Baja");
					combodos.addItem("Condominio El Golfo");
					combodos.addItem("Condominio Arbolada la Loma");
					combodos.addItem("Condominio La Loma II");
					combodos.addItem("Condominio La Loma III");
					combodos.addItem("Condominio Plaza Arbolada la Loma");
					combodos.addItem("Colonia Ampliación El Fresno");
					combodos.addItem("Condominio Conjunto Urbano La Loma");
					combodos.addItem("Condominio Villas de San Francisco II");
					combodos.addItem("Colonia Ejido Buenavista");

					
				}else if (combouno.getSelectedItem().equals("54945")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Izcalli del Valle");
					combodos.addItem("Colonia Valle de Tules");
					combodos.addItem("Colonia Nueva Tultitlán");
					combodos.addItem("Colonia Valle Verde");
					combodos.addItem("Zona industrial Estado de México");

				}else if (combouno.getSelectedItem().equals("54946")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Ferrocarrilera");
					combodos.addItem("Colonia Mariano Escobedo");

					
				}else if (combouno.getSelectedItem().equals("54948")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Bello Horizonte");
					combodos.addItem("Pueblo San Mateo Cuautepec");
					combodos.addItem("Ejido San Mateo Cuautepec");
					combodos.addItem("Colonia Solidaridad 1ra. Sección");
					combodos.addItem("Condominio Real del Bosque");
					combodos.addItem("Colonia Solidaridad 3ra. Sección");
					combodos.addItem("Colonia Solidaridad 2da. Sección");
					combodos.addItem("Colonia Ejido San Antonio Tultitán");

					
				}else if (combouno.getSelectedItem().equals("54949")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Las Terrazas");
					combodos.addItem("Condominio Conjunto Brillante");
					combodos.addItem("Pueblo Santa María Cuautepec");
					combodos.addItem("Condominio Mayorazgo de Tultitlán");
					combodos.addItem("Colonia Ejido Santa María Cuautepec");
					combodos.addItem("Condominio Los Sauces");

					
				}else if (combouno.getSelectedItem().equals("54950")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia La Sardaña");

					
				}else if (combouno.getSelectedItem().equals("54954")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Rinconada San Marcos");
					combodos.addItem("Colonia Ampliación San Marcos");

					
				}else if (combouno.getSelectedItem().equals("54955")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia Ampliación Buenavista");
					combodos.addItem("Colonia Ampliación Buenavista 2da. Sección");
					combodos.addItem("Colonia Ampliación Buenavista 1ra. Sección");

				}else if (combouno.getSelectedItem().equals("54957")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia El Tesoro");
					combodos.addItem("Colonia Ampliación El Tesoro");
					combodos.addItem("Colonia Sierra de Guadalupe");

					
				}else if (combouno.getSelectedItem().equals("54958")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Fraccionamiento Jardines de la Cañada");
					combodos.addItem("Fraccionamiento Lomas de Cartagena");
					combodos.addItem("Fraccionamiento Lomas del Parque I");
					combodos.addItem("Colonia Ampliación La Sardaña");
					combodos.addItem("Condominio Los Tulipanes");
					combodos.addItem("Fraccionamiento Lomas del Parque III");
					combodos.addItem("Fraccionamiento Lomas del Parque II");
					combodos.addItem("Colonia FIMESA II (Ampliación la Sardaña)");

					
				}else if (combouno.getSelectedItem().equals("54959")) {
					combodos.addItem("selecciona una opcion");
					combodos.removeAllItems();//quita las opciones del combo 2
					combodos.addItem("Colonia El Paraje");
					combodos.addItem("Zona industrial Corredor López Portillo");
					combodos.addItem("Colonia FIMESA I (El Paraje)");

				}else{
					combodos.removeAllItems();
					combouno.removeAllItems();
				}
				
			}
		});
		combouno.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "54900", "54910", "54913", "54914", "54915", "54916", "54918", "54920", "54924", "54925", "54926", "54927", "54929", "54930", "54932", "54933", "54934", "54935", "54938", "54939", "54940", "54942", "54943", "54944", "54945", "54946", "54948", "54949", "54950", "54954", "54955", "54957", "54958", "54959"}));
		combouno.setBounds(10, 11, 136, 22);
		panel_3.add(combouno);
		
		JLabel lblNewLabel_14 = new JLabel("CODIGO POSTAL");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_14.setBounds(32, 36, 111, 14);
		panel_3.add(lblNewLabel_14);
		
		
		combodos.setBounds(190, 11, 149, 22);
		panel_3.add(combodos);
		
		JLabel lblNewLabel_15 = new JLabel("COLONIA");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(238, 36, 111, 14);
		panel_3.add(lblNewLabel_15);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(243, 220, 220));
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBounds(373, 12, 168, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("DOMICILIO");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_16.setBounds(430, 36, 97, 14);
		panel_3.add(lblNewLabel_16);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(243, 220, 220));
		textField_10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_10.setBounds(10, 55, 136, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("ESTADO");
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(51, 78, 95, 14);
		panel_3.add(lblNewLabel_24);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 289, 252, 313);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBackground(new Color(243, 220, 220));
		textField_4.setBounds(27, 11, 194, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("OCUPACION");
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17.setBounds(86, 32, 106, 14);
		panel_4.add(lblNewLabel_17);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBackground(new Color(243, 220, 220));
		textField_5.setBounds(27, 51, 194, 20);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("INGRESO FAMILIAR");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_18.setBounds(69, 73, 125, 14);
		panel_4.add(lblNewLabel_18);
		
		textField_6 = new JTextField();
		textField_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_6.setBackground(new Color(243, 220, 220));
		textField_6.setBounds(27, 93, 194, 20);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("NUMERO CELULAR");
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19.setBounds(69, 117, 125, 14);
		panel_4.add(lblNewLabel_19);
		
		textField_7 = new JTextField();
		textField_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBackground(new Color(243, 220, 220));
		textField_7.setBounds(27, 139, 194, 20);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("NUMERO CASA");
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_20.setBounds(69, 162, 106, 14);
		panel_4.add(lblNewLabel_20);
		
		textField_8 = new JTextField();
		textField_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_8.setBackground(new Color(243, 220, 220));
		textField_8.setBounds(27, 185, 194, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("CANALIZADA POR:");
		lblNewLabel_21.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_21.setBounds(69, 207, 122, 14);
		panel_4.add(lblNewLabel_21);
		
		textField_9 = new JTextField();
		textField_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_9.setBackground(new Color(243, 220, 220));
		textField_9.setBounds(27, 224, 194, 20);
		panel_4.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("PADECIMIENTO CRONICO");
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_22.setBounds(55, 247, 166, 14);
		panel_4.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("DENUNCIA");
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23.setBounds(86, 291, 95, 14);
		panel_4.add(lblNewLabel_23);
		
		textField_11 = new JTextField();
		textField_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_11.setBackground(new Color(243, 220, 220));
		textField_11.setBounds(27, 270, 194, 20);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		JTextArea txtrNombreEdadY = new JTextArea();
		txtrNombreEdadY.setBackground(new Color(243, 220, 220));
		txtrNombreEdadY.setBounds(272, 313, 303, 270);
		contentPane.add(txtrNombreEdadY);
		
		JLabel lblNewLabel_25 = new JLabel("EXP");
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_25.setBounds(20, 71, 49, 14);
		contentPane.add(lblNewLabel_25);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(56, 66, 96, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_26 = new JLabel("FECHA");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_26.setBounds(464, 71, 49, 14);
		contentPane.add(lblNewLabel_26);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setBounds(511, 66, 116, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("HORA");
		lblNewLabel_27.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_27.setBounds(637, 71, 49, 14);
		contentPane.add(lblNewLabel_27);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setBounds(684, 68, 96, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_28 = new JLabel("New label");
		lblNewLabel_28.setIcon(new ImageIcon(DatosGenerales.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel_28.setBounds(213, 5, 49, 50);
		contentPane.add(lblNewLabel_28);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DatosGenerales.class.getResource("/img/butterfly_side_espejo.png")));
		lblNewLabel.setBounds(550, -4, 49, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_29 = new JLabel("New label");
		lblNewLabel_29.setIcon(new ImageIcon(DatosGenerales.class.getResource("/img/encabezado2.gif")));
		lblNewLabel_29.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel_29);
		
		JButton btnNewButton = new JButton("SIGUIENTE");
		btnNewButton.setBackground(new Color(243, 220, 220));
		btnNewButton.setBounds(464, 594, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.setBackground(new Color(243, 220, 220));
		btnNewButton_1.setBounds(267, 594, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_30 = new JLabel("Nombre, Edad y Escolaridad/ Ocupacion");
		lblNewLabel_30.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_30.setBounds(272, 288, 272, 14);
		contentPane.add(lblNewLabel_30);
	}
}
