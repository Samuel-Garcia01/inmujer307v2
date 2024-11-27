package SEGUROVIOLETA;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DatosGenerales extends JFrame {

	public static int exp;

	private JPanel contentPane;
	private JTextField txtApellidopaterno;
	private JTextField txtApellidoMaterno;
	private JTextField txtNombres;
	private JTextField txtDomicilio;
	private JTextField txtOcupacion;
	private JTextField txtNumeroCelular;
	private JTextField txtnumeroDeCasa;
	private JTextField txtEstado;
	private JTextField textField_12;
	private JTextField txtFecha;
	JComboBox comboDia = new JComboBox();
	JComboBox comboMes = new JComboBox();
	JComboBox comboAnio = new JComboBox();
	JComboBox comboEdad = new JComboBox();
	JComboBox comboCodigoPostal = new JComboBox();
	JComboBox comboVivienda = new JComboBox();
	JComboBox comboNopersonas = new JComboBox();
	JComboBox ComboEstadOCivil = new JComboBox();
	JComboBox comboColonia = new JComboBox();
	JTextArea area = new JTextArea();
	
	String NombreDeLaVictima;
	private JTextField txtEstadodesalud;
	private JTextField txtparentesco;
	private JTextField txtestructurafamiliar;

	public void BuscarExpediente() {
		// Aqui se crea un metodo para generar el numero de expediente medianate la
		// conexion ala base de datos
		

	}
	// Aqui definimos la variable

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosGenerales frame = new DatosGenerales();
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
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(23, 35, 138, 14);
		panel_1.add(lblNewLabel_1);

		txtApellidopaterno = new JTextField();
		txtApellidopaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent a) {
				int k = (int) a.getKeyChar();
				if (k >= 47 && k <= 58) {
					a.setKeyChar((char) KeyEvent.VK_CLEAR);
					JOptionPane.showMessageDialog(null, "¡Error, solo se aceptan letras en este campo! ",
							"Ingrese los datos nuevamente", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtApellidopaterno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtApellidopaterno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡No puedes continuar, necesitas llenar este campo!");
				} else {
					txtApellidoMaterno.requestFocus();
				}

			}
		});
		txtApellidopaterno.setBackground(new Color(243, 220, 220));
		txtApellidopaterno.setForeground(Color.BLACK);
		txtApellidopaterno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellidopaterno.setBounds(23, 11, 138, 20);
		panel_1.add(txtApellidopaterno);
		txtApellidopaterno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("APELLIDO MATERNO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(206, 35, 138, 14);
		panel_1.add(lblNewLabel_2);

		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent av) {
				int k = (int) av.getKeyChar();
				if (k >= 47 && k <= 58) {
					av.setKeyChar((char) KeyEvent.VK_CLEAR);
					JOptionPane.showMessageDialog(null, "¡Error, solo se aceptan letras en este campo! ",
							"Ingrese los datos nuevamente", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtApellidoMaterno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui implemente un if para que cuando termine de escribir lo mande al
				// siguiente txt automaticamente
				if (txtApellidoMaterno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡No puedes continuar, necesitas llenar este campo!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					txtNombres.requestFocus();
				}
			}
		});
		txtApellidoMaterno.setBackground(new Color(243, 220, 220));
		txtApellidoMaterno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellidoMaterno.setBounds(206, 11, 138, 20);
		panel_1.add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("NOMBRE/S");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(386, 35, 122, 14);
		panel_1.add(lblNewLabel_3);

		txtNombres = new JTextField();
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent avt) {
				int k = (int) avt.getKeyChar();
				if (k >= 47 && k <= 58) {
					avt.setKeyChar((char) KeyEvent.VK_CLEAR);
					JOptionPane.showMessageDialog(null, "¡Error, solo se aceptan letras en este campo!",
							"Ingrese los datos nuevamente", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		txtNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aqui se implementa un if para que cuando de un Enter lo mande alsiguiente txt
				// automaticamente
				if (txtApellidoMaterno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡No puedes continuar, necesitas llenar este campo!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboCodigoPostal.showPopup();
				}
			}
		});
		txtNombres.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombres.setBackground(new Color(243, 220, 220));
		txtNombres.setBounds(386, 11, 122, 20);
		panel_1.add(txtNombres);
		txtNombres.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2.setBackground(new Color(243, 220, 220));
		panel_2.setBounds(588, 80, 211, 222);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		ComboEstadOCivil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ComboEstadOCivil.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboServiciomedico.showPopup();
				}
			}
		});
		ComboEstadOCivil.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccione una opcion", "Soltera", "Casada", "Viuda" }));
		ComboEstadOCivil.setBackground(new Color(243, 220, 220));
		ComboEstadOCivil.setBounds(10, 11, 191, 22);
		panel_2.add(ComboEstadOCivil);

		JLabel lblNewLabel_4 = new JLabel("ESTADO CIVIL");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 38, 191, 14);
		panel_2.add(lblNewLabel_4);

		comboEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboEdad.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboVivienda.showPopup();
				}
			}
		});
		comboEdad.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion" }));
		for (int i = 1; i <= 99; i++) {
			String E = String.valueOf(i);
			String edad = "";
			if (E.length() == 1) {
				edad = "0" + E;

			} else {
				edad = E;
			}
			comboEdad.addItem(edad);

		}
		comboEdad.setBackground(new Color(243, 220, 220));
		comboEdad.setBounds(10, 57, 191, 22);
		panel_2.add(comboEdad);

		JLabel lblNewLabel_7 = new JLabel("EDAD");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 85, 191, 14);
		panel_2.add(lblNewLabel_7);
		comboVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboVivienda.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboNopersonas.showPopup();
				}
			}
		});

		comboVivienda.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione una opcion", "Familiar", "Propia", "Rentada", "Prestada" }));
		comboVivienda.setBackground(new Color(243, 220, 220));
		comboVivienda.setBounds(10, 104, 191, 22);
		panel_2.add(comboVivienda);

		JLabel lblNewLabel_11 = new JLabel("VIVIENDA");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 137, 191, 14);
		panel_2.add(lblNewLabel_11);

		comboNopersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboNopersonas.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboContribuyentealgasto.showPopup();
				}
			}
		});

		comboNopersonas.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion", "1", "2", "3", "4",
				"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
		comboNopersonas.setBackground(new Color(243, 220, 220));
		comboNopersonas.setBounds(10, 162, 191, 22);
		panel_2.add(comboNopersonas);

		JLabel lblNewLabel_12 = new JLabel("NO. PERSONAS");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_12.setBounds(10, 195, 191, 14);
		panel_2.add(lblNewLabel_12);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_3.setBackground(new Color(243, 220, 220));
		panel_3.setBounds(10, 175, 568, 103);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		comboCodigoPostal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboCodigoPostal.getSelectedItem().equals("54900")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Barrio Belém");
					comboColonia.addItem("Barrio La Concepción");
					comboColonia.addItem("Barrio Los Reyes");
					comboColonia.addItem("Barrio Nativitas");
					comboColonia.addItem("Barrio San Bartolo");
					comboColonia.addItem("Barrio San Juan");
					comboColonia.addItem("Barrio Santiaguito");
					comboColonia.addItem("Colonia Tultitlán de Mariano Escobedo Centro");
					comboColonia.addItem("Condominio Residencial los Reyes");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54910")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Fuentes del Valle");
					comboColonia.addItem("Fraccionamiento Villas de San José");
					comboColonia.addItem("Colonia Villa Esmeralda");
					comboColonia.addItem("Condominio Los Agaves Tultitlán");
					comboColonia.addItem("Condominio Los Portales");
					comboColonia.addItem("Colonia La Mariscala");
					comboColonia.addItem("Ranchería La Ponderosa");
					comboColonia.addItem("Condominio Jardines de Tultitlán");
					comboColonia.addItem("Zona comercial Central de Abastos");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54913")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento COCEM");
					comboColonia.addItem("Condominio Sol de Tultitlán (Zona Oriente)");
					comboColonia.addItem("Colonia Recursos Hidráulicos");
					comboColonia.addItem("Condominio Villas Jardín");
					comboColonia.addItem("Condominio Bosques de Tultitlán");
					comboColonia.addItem("Unidad habitacional Quinta el Ángel");
					comboColonia.addItem("Condominio Ampliación COCEM");
					comboColonia.addItem("Fraccionamiento Residencial del Sol");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54914")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Condominio Unidad Electricistas");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54915")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Independencia");
					comboColonia.addItem("Condominio El Obelisco");
					comboColonia.addItem("Zona industrial Independencia");
					comboColonia.addItem("Colonia Los Reyes");
					comboColonia.addItem("Condominio Porto Alegre");
					comboColonia.addItem("Residencial Rincón Colonial");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54916")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Lázaro Cárdenas (Zona Hornos)");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54918")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Parque industrial Cartagena");
					comboColonia.addItem("Parque industrial Tultitlán");
					comboColonia.addItem("Colonia El Cueyamil");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54920")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Condominio Hogares de Castera");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros III");
					comboColonia.addItem("Fraccionamiento San Pablo Castera II");
					comboColonia.addItem("Condominio Estrella de Tultitlán (Lote 55 Pte.)");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54924")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Llanuras");
					comboColonia.addItem("Condominio El Kiosco");
					comboColonia.addItem("Condominio Conjunto Cristal");
					comboColonia.addItem("Condominio Lote 104 (Tehuantepec)");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54925")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Hacienda San Pablo");
					comboColonia.addItem("Unidad habitacional Las Manzanas");
					comboColonia.addItem("Condominio Prados B");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54926")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Estepas");
					comboColonia.addItem("Condominio Lote 55 (Los Tejados)");
					comboColonia.addItem("Condominio Sustitución Arista");
					comboColonia.addItem("Condominio Los Agaves (Lote 71)");
					comboColonia.addItem("Fraccionamiento Galaxias Tultitlán");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54927")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Las Tórtolas");
					comboColonia.addItem("Unidad habitacional Mariano Escobedo (los Faroles)");
					comboColonia.addItem("Colonia Hogares de Castera Lote 73");
					comboColonia.addItem("Condominio Lote 41 (El Carmen)");
					comboColonia.addItem("Colonia Emilio Chuayffet");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54929")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Alborada I");
					comboColonia.addItem("Unidad habitacional La Alborada Vallas");
					comboColonia.addItem("Unidad habitacional Nuevo INFONAVIT");
					comboColonia.addItem("Fraccionamiento Unidad Morelos 3ra. Sección INFONAVIT");
					comboColonia.addItem("Condominio Lote 12 (Crepúsculo)");
					comboColonia.addItem("Condominio Villas Loreto");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros VI");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54930")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Granjas San Pablo");
					comboColonia.addItem("Fraccionamiento Izcalli Rinconada");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros IV");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros V");
					comboColonia.addItem("Unidad habitacional La Granja");
					comboColonia.addItem("Condominio Llanura Verde");
					comboColonia.addItem("Condominio Pensamientos");
					comboColonia.addItem("Unidad habitacional San Pablo de las Salinas");
					comboColonia.addItem("Pueblo San Pablo de las Salinas");
					comboColonia.addItem("Fraccionamiento Solidaridad Social (Lote 105)");
					comboColonia.addItem("Fraccionamiento Unidad Morelos 2da. Sección");
					comboColonia.addItem("Condominio Lote 92 (Las Rosas)");
					comboColonia.addItem("Condominio Las Granjas");
					comboColonia.addItem("Condominio Privada los Prados");
					comboColonia.addItem("Condominio Solar San Pablo");
					comboColonia.addItem("Condominio Quintas San Pablo");
					comboColonia.addItem("Colonia Lomas de San Pablo");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54932")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Magnolias");
					comboColonia.addItem("Condominio Conjunto Fortuna");
					comboColonia.addItem("Fraccionamiento IMMEX II");
					comboColonia.addItem("Condominio Isidro Fabela");
					comboColonia.addItem("Fraccionamiento Magnolias 2000");
					comboColonia.addItem("Condominio Lote 105 (Ébano)");
					comboColonia.addItem("Condominio Villas de San Pablo");
					comboColonia.addItem("Fraccionamiento Residencial Magnolias");
					comboColonia.addItem("Condominio San Pablo III-B");
					comboColonia.addItem("Condominio San Pablo III-A");
					comboColonia.addItem("Fraccionamiento Residencial San Pablo II");
					comboColonia.addItem("Condominio Villas San Pablo (Lote 117 Sur)");
				} else if (comboCodigoPostal.getSelectedItem().equals("54933")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Condominio Azul Cielo");
					comboColonia.addItem("Condominio Coyoli Martínez");
					comboColonia.addItem("Fraccionamiento Izcalli San Pablo");
					comboColonia.addItem("Condominio Jardines de San Pablo");
					comboColonia.addItem("Condominio Parque de San Pablo");
					comboColonia.addItem("Condominio Verde Claro");
					comboColonia.addItem("Condominio Lote 93 (Amalia)");
					comboColonia.addItem("Condominio El Campanario");
					comboColonia.addItem("Fraccionamiento Plaza Jardines");
					comboColonia.addItem("Condominio Residencial La Esperanza");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54934")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Condominio El Rocío");
					comboColonia.addItem("Condominio Gustavo Baz");
					comboColonia.addItem("Condominio Prados A");
				} else if (comboCodigoPostal.getSelectedItem().equals("54935")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Unidad habitacional Casas Alfa");
					comboColonia.addItem("Condominio Casitas San Pablo");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros I");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros II");
					comboColonia.addItem("Fraccionamiento Alborada II");
					comboColonia.addItem("Condominio La Isla");
					comboColonia.addItem("Fraccionamiento Unidad Morelos 3ra. Sección");
					comboColonia.addItem("Condominio Residencial Morelos");
					comboColonia.addItem("Condominio Lote 84 (Las Adelas)");
					comboColonia.addItem("Condominio Lote 82 (Guillermo González C.)");
					comboColonia.addItem("Condominio El Faro (Lote 3 Pte.)");
					comboColonia.addItem("Condominio Conjunto San Pablo");
					comboColonia.addItem("Condominio Lote 52 (Torres Tultitlán)");
					comboColonia.addItem("Colonia Las Calderas");
					comboColonia.addItem("Condominio Portal San Pablo");
					comboColonia.addItem("Condominio Portal San Pablo II");
					comboColonia.addItem("Condominio Las Almenas");
					comboColonia.addItem("Unidad habitacional Lava 46");
					comboColonia.addItem("Condominio Las Fuentes");
					comboColonia.addItem("Colonia Las Chinampas");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54938")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Ampliación San Pablo de las Salinas");
					comboColonia.addItem("Condominio Lote 64 (Octavio Paz)");
					comboColonia.addItem("Condominio Lote 47 (El Reloj Residencial)");
					comboColonia.addItem("Condominio Lote 48 (El Reloj Cronos)");
					comboColonia.addItem("Unidad habitacional Arboledas (lote 49)");
					comboColonia.addItem("Condominio Lote 62 (Juan Rulfo)");
					comboColonia.addItem("Condominio Arcos I");
					comboColonia.addItem("Condominio Lote 50 B (Las Laderas)");
					comboColonia.addItem("Condominio Lote 46 (El Reloj Villas)");
					comboColonia.addItem("Condominio Lote 63 Conjunto Pilares");
					comboColonia.addItem("Condominio Lote 50 A");
					comboColonia.addItem("Condominio Lote 50 D");
					comboColonia.addItem("Condominio Lote 50 C (Real De Tultitlán)");
					comboColonia.addItem("Condominio Lote 59 (Torres del Reloj)");
					comboColonia.addItem("Condominio Lote 76 (El Reloj)");
					comboColonia.addItem("Condominio El Laurel");
					comboColonia.addItem("Condominio Villas Tultitlán (Lote 65)");
					comboColonia.addItem("Condominio Arcos V");
					comboColonia.addItem("Condominio Arcos IV");
					comboColonia.addItem("Condominio Arcos III");
					comboColonia.addItem("Condominio Arcos II");
					comboColonia.addItem("Condominio Villas Santa Teresita");
					comboColonia.addItem("Condominio Bonito Tultitlán (lote 60)");
					comboColonia.addItem("Condominio El Alcázar");
					comboColonia.addItem("Condominio Arcos VI");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54939")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Paraje San Pablito");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54940")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Lechería");
					comboColonia.addItem("Zona industrial Corredor Lechería-Cuautitlán");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54942")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Benito Juárez");
					comboColonia.addItem("Colonia La Libertad");
					comboColonia.addItem("Colonia Ampliación Las Torres Segunda Sección");
					comboColonia.addItem("Colonia Las Torres I");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54943")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Ciudad Labor");
					comboColonia.addItem("Colonia Ojo de Agua Primera Sección");
					comboColonia.addItem("Colonia Ojo de Agua Segunda Sección");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54944")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Pueblo San Francisco Chilpan");
					comboColonia.addItem("Colonia Buenavista Parte Alta");
					comboColonia.addItem("Colonia El Fresno");
					comboColonia.addItem("Colonia La Joya");
					comboColonia.addItem("Condominio La Loma I");
					comboColonia.addItem("Fraccionamiento Villas de San Francisco Chilpan");
					comboColonia.addItem("Colonia Santa Clara");
					comboColonia.addItem("Colonia Buenavista Parte Baja");
					comboColonia.addItem("Condominio El Golfo");
					comboColonia.addItem("Condominio Arbolada la Loma");
					comboColonia.addItem("Condominio La Loma II");
					comboColonia.addItem("Condominio La Loma III");
					comboColonia.addItem("Condominio Plaza Arbolada la Loma");
					comboColonia.addItem("Colonia Ampliación El Fresno");
					comboColonia.addItem("Condominio Conjunto Urbano La Loma");
					comboColonia.addItem("Condominio Villas de San Francisco II");
					comboColonia.addItem("Colonia Ejido Buenavista");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54945")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Izcalli del Valle");
					comboColonia.addItem("Colonia Valle de Tules");
					comboColonia.addItem("Colonia Nueva Tultitlán");
					comboColonia.addItem("Colonia Valle Verde");
					comboColonia.addItem("Zona industrial Estado de México");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54946")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Ferrocarrilera");
					comboColonia.addItem("Colonia Mariano Escobedo");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54948")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Bello Horizonte");
					comboColonia.addItem("Pueblo San Mateo Cuautepec");
					comboColonia.addItem("Ejido San Mateo Cuautepec");
					comboColonia.addItem("Colonia Solidaridad 1ra. Sección");
					comboColonia.addItem("Condominio Real del Bosque");
					comboColonia.addItem("Colonia Solidaridad 3ra. Sección");
					comboColonia.addItem("Colonia Solidaridad 2da. Sección");
					comboColonia.addItem("Colonia Ejido San Antonio Tultitán");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54949")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Las Terrazas");
					comboColonia.addItem("Condominio Conjunto Brillante");
					comboColonia.addItem("Pueblo Santa María Cuautepec");
					comboColonia.addItem("Condominio Mayorazgo de Tultitlán");
					comboColonia.addItem("Colonia Ejido Santa María Cuautepec");
					comboColonia.addItem("Condominio Los Sauces");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54950")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia La Sardaña");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54954")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Rinconada San Marcos");
					comboColonia.addItem("Colonia Ampliación San Marcos");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54955")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia Ampliación Buenavista");
					comboColonia.addItem("Colonia Ampliación Buenavista 2da. Sección");
					comboColonia.addItem("Colonia Ampliación Buenavista 1ra. Sección");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54957")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia El Tesoro");
					comboColonia.addItem("Colonia Ampliación El Tesoro");
					comboColonia.addItem("Colonia Sierra de Guadalupe");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54958")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Fraccionamiento Jardines de la Cañada");
					comboColonia.addItem("Fraccionamiento Lomas de Cartagena");
					comboColonia.addItem("Fraccionamiento Lomas del Parque I");
					comboColonia.addItem("Colonia Ampliación La Sardaña");
					comboColonia.addItem("Condominio Los Tulipanes");
					comboColonia.addItem("Fraccionamiento Lomas del Parque III");
					comboColonia.addItem("Fraccionamiento Lomas del Parque II");
					comboColonia.addItem("Colonia FIMESA II (Ampliación la Sardaña)");
					comboColonia.showPopup();
				} else if (comboCodigoPostal.getSelectedItem().equals("54959")) {
					comboColonia.removeAllItems();// quita las opciones del combo 2
					comboColonia.addItem("selecciona una opcion");
					comboColonia.addItem("Colonia El Paraje");
					comboColonia.addItem("Zona industrial Corredor López Portillo");
					comboColonia.addItem("Colonia FIMESA I (El Paraje)");
					comboColonia.showPopup();
				} else {
					comboColonia.removeAllItems();
					comboCodigoPostal.removeAllItems();
				}

			}
		});
		comboCodigoPostal.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion", "54900", "54910",
				"54913", "54914", "54915", "54916", "54918", "54920", "54924", "54925", "54926", "54927", "54929",
				"54930", "54932", "54933", "54934", "54935", "54938", "54939", "54940", "54942", "54943", "54944",
				"54945", "54946", "54948", "54949", "54950", "54954", "54955", "54957", "54958", "54959" }));
		comboCodigoPostal.setBounds(10, 11, 136, 22);
		panel_3.add(comboCodigoPostal);

		JLabel lblNewLabel_14 = new JLabel("CODIGO POSTAL");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_14.setBounds(10, 36, 136, 14);
		panel_3.add(lblNewLabel_14);
		comboColonia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDomicilio.requestFocus();
			}
		});

		comboColonia.setBounds(190, 11, 149, 22);
		panel_3.add(comboColonia);

		JLabel lblNewLabel_15 = new JLabel("COLONIA");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(200, 36, 139, 14);
		panel_3.add(lblNewLabel_15);

		txtDomicilio = new JTextField();
		txtDomicilio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDomicilio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
				} else {
					txtOcupacion.requestFocus();
				}
			}
		});
		txtDomicilio.setBackground(new Color(243, 220, 220));
		txtDomicilio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDomicilio.setBounds(373, 12, 168, 20);
		panel_3.add(txtDomicilio);
		txtDomicilio.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("DOMICILIO");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_16.setBounds(373, 36, 168, 14);
		panel_3.add(lblNewLabel_16);

		txtEstado = new JTextField("Tultitlan");
		txtEstado.setEditable(false);
		txtEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtEstado.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
				} else {
					txtOcupacion.requestFocus();
				}
			}
		});
		txtEstado.setBackground(new Color(243, 220, 220));
		txtEstado.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEstado.setBounds(10, 55, 136, 20);
		panel_3.add(txtEstado);
		txtEstado.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("ESTADO");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(10, 78, 136, 14);
		panel_3.add(lblNewLabel_24);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 289, 252, 167);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		txtOcupacion = new JTextField();
		txtOcupacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtOcupacion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
				} else {
					txtIngresoFamiliar.requestFocus();
				}

			}
		});
		txtOcupacion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtOcupacion.setBackground(new Color(243, 220, 220));
		txtOcupacion.setBounds(27, 11, 194, 20);
		panel_4.add(txtOcupacion);
		txtOcupacion.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("OCUPACION");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17.setBounds(27, 32, 194, 14);
		panel_4.add(lblNewLabel_17);

		txtNumeroCelular = new JTextField();
		txtNumeroCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				int k = (int) ev.getKeyChar();
				if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
					ev.setKeyChar((char) KeyEvent.VK_CLEAR);
					JOptionPane.showMessageDialog(null, "ERROR SOLO SE ACEPTAN NUMEROS EN ESTE CAMPO !!! ",
							"INGRESE LOS DATOS NUEVAMENTE", JOptionPane.ERROR_MESSAGE);
				}
				if (txtNumeroCelular.getText().trim().length() == 10) {
					ev.consume();

				}
			}
		});
		txtNumeroCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNumeroCelular.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
				} else {
					txtnumeroDeCasa.requestFocus();
				}
			}
		});
		txtNumeroCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNumeroCelular.setBackground(new Color(243, 220, 220));
		txtNumeroCelular.setBounds(27, 55, 194, 20);
		panel_4.add(txtNumeroCelular);
		txtNumeroCelular.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("NUMERO CELULAR");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19.setBounds(27, 86, 194, 14);
		panel_4.add(lblNewLabel_19);

		txtnumeroDeCasa = new JTextField();
		txtnumeroDeCasa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int k = (int) evt.getKeyChar();
				if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
					evt.setKeyChar((char) KeyEvent.VK_CLEAR);
					JOptionPane.showMessageDialog(null, "ERROR SOLO SE ACEPTAN NUMEROS EN ESTE CAMPO !!! ",
							"INGRESE LOS DATOS NUEVAMENTE", JOptionPane.ERROR_MESSAGE);
				}
				if (txtnumeroDeCasa.getText().trim().length() == 10) {
					evt.consume();
				}
			}
		});
		txtnumeroDeCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCanalizadPor.requestFocus();
			}
		});
		txtnumeroDeCasa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtnumeroDeCasa.setBackground(new Color(243, 220, 220));
		txtnumeroDeCasa.setBounds(27, 111, 194, 20);
		panel_4.add(txtnumeroDeCasa);
		txtnumeroDeCasa.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("NUMERO CASA");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_20.setBounds(27, 142, 194, 14);
		panel_4.add(lblNewLabel_20);

		area.setBackground(new Color(243, 220, 220));
		area.setBounds(272, 312, 303, 103);
		contentPane.add(area);

		JLabel lblNewLabel_25 = new JLabel("EXP");
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_25.setBounds(20, 71, 49, 14);
		contentPane.add(lblNewLabel_25);

		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(56, 66, 96, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("MES");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_26.setBounds(172, 71, 49, 14);
		contentPane.add(lblNewLabel_26);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(206, 66, 116, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Se generan las variables para su almacenaciento, esto nos ayudara a guardar
				// los datos ingresado
				// por el usuario
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				NombreDeLaVictima = txtApellidopaterno.getText() + " " + txtApellidoMaterno.getText() + " "
						+ txtNombres.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboGradoestudios.getSelectedItem().toString();
				int edad = Integer.parseInt(comboEdad.getSelectedItem().toString());
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboServiciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = comboCodigoPostal.getSelectedItem().toString();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefonoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboVivienda.getSelectedItem().toString();
				String nopersonas = comboNopersonas.getSelectedItem().toString();
				String contribuyente = comboContribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				String FechaDeNacimiento = comboAnio.getSelectedItem().toString() + "-"
						+ comboMes.getSelectedItem().toString() + "-" + comboDia.getSelectedItem().toString();

				// En esta seccion se genera la conexion a la base de datos, la cual enviara la
				// informacion almacenada
				// en las variables creadas anteriormente.
			}
				
		});
		btnNewButton.setBackground(new Color(243, 220, 220));
		btnNewButton.setBounds(698, 586, 99, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_30 = new JLabel("Contacto De Emergencia (Numero y Nombre)");
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_30.setBounds(272, 288, 303, 14);
		contentPane.add(lblNewLabel_30);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel.setBackground(new Color(243, 220, 220));
		panel.setBounds(588, 317, 211, 184);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_31 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_31.setBounds(10, 10, 191, 13);
		panel.add(lblNewLabel_31);
		comboDia.setBounds(10, 43, 191, 22);
		panel.add(comboDia);
		comboDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboDia.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboMes.showPopup();
				}
			}
		});
		comboDia.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion" }));
		comboDia.setBackground(new Color(243, 220, 220));
		for (int i = 1; i <= 31; i++) {
			String d = String.valueOf(i);
			String dia = "";
			if (d.length() == 1) {
				dia = "0" + d;

			} else {
				dia = d;
			}
			comboDia.addItem(dia);
		}

		JLabel lblNewLabel_8 = new JLabel("DIA");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 68, 191, 14);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		comboMes.setBounds(10, 85, 191, 22);
		panel.add(comboMes);
		comboMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboMes.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					comboAnio.showPopup();
				}
			}
		});
		comboMes.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion" }));
		comboMes.setBackground(new Color(243, 220, 220));
		for (int i = 1; i <= 12; i++) {
			String m = String.valueOf(i);
			String mes = "";
			if (m.length() == 1) {
				mes = "0" + m;

			} else {
				mes = m;
			}
			comboMes.addItem(mes);

		}

		JLabel lblNewLabel_9 = new JLabel("MES");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(10, 111, 191, 14);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		comboAnio.setBounds(10, 132, 191, 22);
		panel.add(comboAnio);
		comboAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboAnio.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar una opcion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					area.requestFocus();
				}
			}
		});
		comboAnio.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opcion" }));
		comboAnio.setBackground(new Color(243, 220, 220));
		for (int i = 1940; i <= 2020; i++) {
			comboAnio.addItem(i);

		}

		JLabel lblNewLabel_10 = new JLabel("AÑO");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 159, 191, 14);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_30_1 = new JLabel("Denuncia y/o demanda (tipo y numero)");
		lblNewLabel_30_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_30_1.setBounds(10, 467, 235, 14);
		contentPane.add(lblNewLabel_30_1);
		
		JTextArea areadenuncia = new JTextArea();
		areadenuncia.setBackground(new Color(243, 220, 220));
		areadenuncia.setBounds(10, 492, 252, 103);
		contentPane.add(areadenuncia);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_5.setBackground(new Color(243, 220, 220));
		panel_5.setBounds(272, 425, 306, 184);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_17_1 = new JLabel("Estado De Salud:");
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17_1.setBounds(10, 11, 119, 14);
		panel_5.add(lblNewLabel_17_1);
		
		txtEstadodesalud = new JTextField();
		txtEstadodesalud.setColumns(10);
		txtEstadodesalud.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEstadodesalud.setBackground(new Color(243, 220, 220));
		txtEstadodesalud.setBounds(20, 36, 98, 20);
		panel_5.add(txtEstadodesalud);
		
		JLabel lblNewLabel_17_1_1 = new JLabel("Parentesco");
		lblNewLabel_17_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17_1_1.setBounds(10, 67, 119, 14);
		panel_5.add(lblNewLabel_17_1_1);
		
		txtparentesco = new JTextField();
		txtparentesco.setColumns(10);
		txtparentesco.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtparentesco.setBackground(new Color(243, 220, 220));
		txtparentesco.setBounds(20, 92, 98, 20);
		panel_5.add(txtparentesco);
		
		JLabel lblNewLabel_17_1_1_1 = new JLabel("Tipo de vivienda:");
		lblNewLabel_17_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17_1_1_1.setBounds(139, 11, 119, 14);
		panel_5.add(lblNewLabel_17_1_1_1);
		
		JComboBox combotipodevivienda = new JComboBox();
		combotipodevivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "casa", "cuarto", "departamento"}));
		combotipodevivienda.setBounds(149, 34, 131, 22);
		panel_5.add(combotipodevivienda);
		
		JLabel lblNewLabel_17_1_1_1_1 = new JLabel("Estructura Familiar:");
		lblNewLabel_17_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17_1_1_1_1.setBounds(139, 67, 119, 14);
		panel_5.add(lblNewLabel_17_1_1_1_1);
		
		txtestructurafamiliar = new JTextField();
		txtestructurafamiliar.setColumns(10);
		txtestructurafamiliar.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtestructurafamiliar.setBackground(new Color(243, 220, 220));
		txtestructurafamiliar.setBounds(149, 91, 98, 20);
		panel_5.add(txtestructurafamiliar);
	}
}
