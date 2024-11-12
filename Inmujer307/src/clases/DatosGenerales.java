package clases;

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

import ConexionBaseDeDatos.ConexionInmujer;
import clasesExternas.FechaHora;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DatosGenerales extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellidopaterno;
	private JTextField txtApellidoMaterno;
	private JTextField txtNombres;
	private JTextField txtDomicilio;
	private JTextField txtOcupacion;
	private JTextField txtIngresoFamiliar;
	private JTextField txtNumeroCelular;
	private JTextField txtnumeroDeCasa;
	private JTextField txtCanalizadPor;
	private JTextField txtPadecimientoCronico;
	private JTextField txtEstado;
	private JTextField txtDenuncia;
	private JTextField textField_12;
	private JTextField txtFecha;
	private JTextField txtHora;
	JComboBox comboBoxcontribuyentealgasto = new JComboBox();
	JComboBox comboBoxgradoestudios = new JComboBox();
	JComboBox comboBoxNopersonas = new JComboBox();
	JComboBox comboBoxanio = new JComboBox();
	JComboBox comboBoxvivienda = new JComboBox();
	JComboBox comboBoxserviciomedico = new JComboBox();
	JComboBox ComboEstadOCivil = new JComboBox();
	JComboBox comboColonia = new JComboBox();
	JTextArea area = new JTextArea();
	FechaHora fech = new FechaHora();
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
		
		txtApellidopaterno = new JTextField();
		txtApellidopaterno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtApellidopaterno.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
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
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(206, 35, 132, 14);
		panel_1.add(lblNewLabel_2);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Aqui implemente un if para que cuando termine de escribir lo mande al siguiente txt automaticamente
					if (txtApellidoMaterno.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
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
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(418, 35, 78, 14);
		panel_1.add(lblNewLabel_3);
		
		txtNombres = new JTextField();
		txtNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Aqui implemente un if para que cuando termine de escribir lo mande al siguiente txt automaticamente
				if (txtApellidoMaterno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
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
		panel_2.setBounds(588, 92, 211, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		ComboEstadOCivil.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "Soltera", "Casada", "Viuda"}));
		ComboEstadOCivil.setBackground(new Color(243, 220, 220));
		ComboEstadOCivil.setBounds(10, 11, 191, 22);
		panel_2.add(ComboEstadOCivil);
		
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
		
		JComboBox comboCodigoPostal = new JComboBox();
		comboCodigoPostal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboCodigoPostal.getSelectedItem().equals("54900")) {
					comboColonia.removeAllItems();//quita las opciones del combo 2
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
				}else if (comboCodigoPostal.getSelectedItem().equals("54910")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Fuentes del Valle");
					comboColonia.addItem("Fraccionamiento Villas de San José");
					comboColonia.addItem("Colonia Villa Esmeralda");
					comboColonia.addItem("Condominio Los Agaves Tultitlán");
					comboColonia.addItem("Condominio Los Portales");
					comboColonia.addItem("Colonia La Mariscala");
					comboColonia.addItem("Ranchería La Ponderosa");
					comboColonia.addItem("Condominio Jardines de Tultitlán");
					comboColonia.addItem("Zona comercial Central de Abastos");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54913")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento COCEM");
					comboColonia.addItem("Condominio Sol de Tultitlán (Zona Oriente)");
					comboColonia.addItem("Colonia Recursos Hidráulicos");
					comboColonia.addItem("Condominio Villas Jardín");
					comboColonia.addItem("Condominio Bosques de Tultitlán");
					comboColonia.addItem("Unidad habitacional Quinta el Ángel");
					comboColonia.addItem("Condominio Ampliación COCEM");
					comboColonia.addItem("Fraccionamiento Residencial del Sol");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54914")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Condominio Unidad Electricistas");

				}else if (comboCodigoPostal.getSelectedItem().equals("54915")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Independencia");
					comboColonia.addItem("Condominio El Obelisco");
					comboColonia.addItem("Zona industrial Independencia");
					comboColonia.addItem("Colonia Los Reyes");
					comboColonia.addItem("Condominio Porto Alegre");
					comboColonia.addItem("Residencial Rincón Colonial");
	
				}else if (comboCodigoPostal.getSelectedItem().equals("54916")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
				comboColonia.addItem("Colonia Lázaro Cárdenas (Zona Hornos)");	
					
				}else if (comboCodigoPostal.getSelectedItem().equals("54918")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Parque industrial Cartagena");
					comboColonia.addItem("Parque industrial Tultitlán");
					comboColonia.addItem("Colonia El Cueyamil");

				}else if (comboCodigoPostal.getSelectedItem().equals("54920")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Condominio Hogares de Castera");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros III");
					comboColonia.addItem("Fraccionamiento San Pablo Castera II");
					comboColonia.addItem("Condominio Estrella de Tultitlán (Lote 55 Pte.)");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54924")){
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Llanuras");
					comboColonia.addItem("Condominio El Kiosco");
					comboColonia.addItem("Condominio Conjunto Cristal");
					comboColonia.addItem("Condominio Lote 104 (Tehuantepec)");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54925")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Hacienda San Pablo");
					comboColonia.addItem("Unidad habitacional Las Manzanas");
					comboColonia.addItem("Condominio Prados B");

				}else if (comboCodigoPostal.getSelectedItem().equals("54926")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Estepas");
					comboColonia.addItem("Condominio Lote 55 (Los Tejados)");
					comboColonia.addItem("Condominio Sustitución Arista");
					comboColonia.addItem("Condominio Los Agaves (Lote 71)");
					comboColonia.addItem("Fraccionamiento Galaxias Tultitlán");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54927")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Las Tórtolas");
					comboColonia.addItem("Unidad habitacional Mariano Escobedo (los Faroles)");
					comboColonia.addItem("Colonia Hogares de Castera Lote 73");
					comboColonia.addItem("Condominio Lote 41 (El Carmen)");
					comboColonia.addItem("Colonia Emilio Chuayffet");
	
				}else if (comboCodigoPostal.getSelectedItem().equals("54929")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Alborada I");
					comboColonia.addItem("Unidad habitacional La Alborada Vallas");
					comboColonia.addItem("Unidad habitacional Nuevo INFONAVIT");
					comboColonia.addItem("Fraccionamiento Unidad Morelos 3ra. Sección INFONAVIT");
					comboColonia.addItem("Condominio Lote 12 (Crepúsculo)");
					comboColonia.addItem("Condominio Villas Loreto");
					comboColonia.addItem("Fraccionamiento Jardines de los Claustros VI");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54930")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54932")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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
				}else if (comboCodigoPostal.getSelectedItem().equals("54933")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54934")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Condominio El Rocío");
					comboColonia.addItem("Condominio Gustavo Baz");
					comboColonia.addItem("Condominio Prados A");	
				}else if (comboCodigoPostal.getSelectedItem().equals("54935")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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
	
				}else if (comboCodigoPostal.getSelectedItem().equals("54938")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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

					
				}else if(comboCodigoPostal.getSelectedItem().equals("54939")){
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Paraje San Pablito");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54940")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Lechería");
					comboColonia.addItem("Zona industrial Corredor Lechería-Cuautitlán");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54942")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Benito Juárez");
					comboColonia.addItem("Colonia La Libertad");
					comboColonia.addItem("Colonia Ampliación Las Torres Segunda Sección");
					comboColonia.addItem("Colonia Las Torres I");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54943")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Ciudad Labor");
					comboColonia.addItem("Colonia Ojo de Agua Primera Sección");
					comboColonia.addItem("Colonia Ojo de Agua Segunda Sección");

				}else if(comboCodigoPostal.getSelectedItem().equals("54944")){
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
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

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54945")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Izcalli del Valle");
					comboColonia.addItem("Colonia Valle de Tules");
					comboColonia.addItem("Colonia Nueva Tultitlán");
					comboColonia.addItem("Colonia Valle Verde");
					comboColonia.addItem("Zona industrial Estado de México");

				}else if (comboCodigoPostal.getSelectedItem().equals("54946")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Ferrocarrilera");
					comboColonia.addItem("Colonia Mariano Escobedo");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54948")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Bello Horizonte");
					comboColonia.addItem("Pueblo San Mateo Cuautepec");
					comboColonia.addItem("Ejido San Mateo Cuautepec");
					comboColonia.addItem("Colonia Solidaridad 1ra. Sección");
					comboColonia.addItem("Condominio Real del Bosque");
					comboColonia.addItem("Colonia Solidaridad 3ra. Sección");
					comboColonia.addItem("Colonia Solidaridad 2da. Sección");
					comboColonia.addItem("Colonia Ejido San Antonio Tultitán");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54949")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Las Terrazas");
					comboColonia.addItem("Condominio Conjunto Brillante");
					comboColonia.addItem("Pueblo Santa María Cuautepec");
					comboColonia.addItem("Condominio Mayorazgo de Tultitlán");
					comboColonia.addItem("Colonia Ejido Santa María Cuautepec");
					comboColonia.addItem("Condominio Los Sauces");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54950")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia La Sardaña");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54954")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Rinconada San Marcos");
					comboColonia.addItem("Colonia Ampliación San Marcos");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54955")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia Ampliación Buenavista");
					comboColonia.addItem("Colonia Ampliación Buenavista 2da. Sección");
					comboColonia.addItem("Colonia Ampliación Buenavista 1ra. Sección");

				}else if (comboCodigoPostal.getSelectedItem().equals("54957")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia El Tesoro");
					comboColonia.addItem("Colonia Ampliación El Tesoro");
					comboColonia.addItem("Colonia Sierra de Guadalupe");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54958")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Fraccionamiento Jardines de la Cañada");
					comboColonia.addItem("Fraccionamiento Lomas de Cartagena");
					comboColonia.addItem("Fraccionamiento Lomas del Parque I");
					comboColonia.addItem("Colonia Ampliación La Sardaña");
					comboColonia.addItem("Condominio Los Tulipanes");
					comboColonia.addItem("Fraccionamiento Lomas del Parque III");
					comboColonia.addItem("Fraccionamiento Lomas del Parque II");
					comboColonia.addItem("Colonia FIMESA II (Ampliación la Sardaña)");

					
				}else if (comboCodigoPostal.getSelectedItem().equals("54959")) {
					comboColonia.addItem("selecciona una opcion");
					comboColonia.removeAllItems();//quita las opciones del combo 2
					comboColonia.addItem("Colonia El Paraje");
					comboColonia.addItem("Zona industrial Corredor López Portillo");
					comboColonia.addItem("Colonia FIMESA I (El Paraje)");

				}else{
					comboColonia.removeAllItems();
					comboCodigoPostal.removeAllItems();
				}
				
			}
		});
		comboCodigoPostal.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion", "54900", "54910", "54913", "54914", "54915", "54916", "54918", "54920", "54924", "54925", "54926", "54927", "54929", "54930", "54932", "54933", "54934", "54935", "54938", "54939", "54940", "54942", "54943", "54944", "54945", "54946", "54948", "54949", "54950", "54954", "54955", "54957", "54958", "54959"}));
		comboCodigoPostal.setBounds(10, 11, 136, 22);
		panel_3.add(comboCodigoPostal);
		
		JLabel lblNewLabel_14 = new JLabel("CODIGO POSTAL");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_14.setBounds(32, 36, 111, 14);
		panel_3.add(lblNewLabel_14);
		
		
		comboColonia.setBounds(190, 11, 149, 22);
		panel_3.add(comboColonia);
		
		JLabel lblNewLabel_15 = new JLabel("COLONIA");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_15.setBounds(238, 36, 111, 14);
		panel_3.add(lblNewLabel_15);
		
		txtDomicilio = new JTextField();
		txtDomicilio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtDomicilio.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						txtEstado.requestFocus();
					}
			}
		});
		txtDomicilio.setBackground(new Color(243, 220, 220));
		txtDomicilio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDomicilio.setBounds(373, 12, 168, 20);
		panel_3.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("DOMICILIO");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_16.setBounds(430, 36, 97, 14);
		panel_3.add(lblNewLabel_16);
		
		txtEstado = new JTextField();
		txtEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtEstado.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
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
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_24.setBounds(51, 78, 95, 14);
		panel_3.add(lblNewLabel_24);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 289, 252, 313);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		txtOcupacion = new JTextField();
		txtOcupacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtOcupacion.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
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
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_17.setBounds(86, 32, 106, 14);
		panel_4.add(lblNewLabel_17);
		
		txtIngresoFamiliar = new JTextField();
		txtIngresoFamiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtIngresoFamiliar.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						txtNumeroCelular.requestFocus();
					}
			}
		});
		txtIngresoFamiliar.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtIngresoFamiliar.setBackground(new Color(243, 220, 220));
		txtIngresoFamiliar.setBounds(27, 51, 194, 20);
		panel_4.add(txtIngresoFamiliar);
		txtIngresoFamiliar.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("INGRESO FAMILIAR");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_18.setBounds(69, 73, 125, 14);
		panel_4.add(lblNewLabel_18);
		
		txtNumeroCelular = new JTextField();
		txtNumeroCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtNumeroCelular.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						txtnumeroDeCasa.requestFocus();
					}
			}
		});
		txtNumeroCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNumeroCelular.setBackground(new Color(243, 220, 220));
		txtNumeroCelular.setBounds(27, 93, 194, 20);
		panel_4.add(txtNumeroCelular);
		txtNumeroCelular.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("NUMERO CELULAR");
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_19.setBounds(69, 117, 125, 14);
		panel_4.add(lblNewLabel_19);
		
		txtnumeroDeCasa = new JTextField();
		txtnumeroDeCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtnumeroDeCasa.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						txtCanalizadPor.requestFocus();
					}
			}
		});
		txtnumeroDeCasa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtnumeroDeCasa.setBackground(new Color(243, 220, 220));
		txtnumeroDeCasa.setBounds(27, 139, 194, 20);
		panel_4.add(txtnumeroDeCasa);
		txtnumeroDeCasa.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("NUMERO CASA");
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_20.setBounds(69, 162, 106, 14);
		panel_4.add(lblNewLabel_20);
		
		txtCanalizadPor = new JTextField();
		txtCanalizadPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtCanalizadPor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						txtPadecimientoCronico.requestFocus();
					}
			}
		});
		txtCanalizadPor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCanalizadPor.setBackground(new Color(243, 220, 220));
		txtCanalizadPor.setBounds(27, 185, 194, 20);
		panel_4.add(txtCanalizadPor);
		txtCanalizadPor.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("CANALIZADA POR:");
		lblNewLabel_21.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_21.setBounds(69, 207, 122, 14);
		panel_4.add(lblNewLabel_21);
		
		txtPadecimientoCronico = new JTextField();
		txtPadecimientoCronico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui definimos la variable
				String fecha = txtFecha.getText();
				String Hora = txtHora.getText();
				String apellidoPaterno = txtApellidopaterno.getText();
				String apellidoMaterno = txtApellidoMaterno.getText();
				String EstadoCivil = ComboEstadOCivil.getSelectedItem().toString();
				String GradoDeEstudios = comboBoxgradoestudios.getSelectedItem().toString();
				String Ocupacion = txtOcupacion.getText();
				String servicioMedico = comboBoxserviciomedico.getSelectedItem().toString();
				String IngresoFamiliar = txtIngresoFamiliar.getText();
				String Domicilio = txtDomicilio.getText();
				String CodigoPostal = txtCanalizadPor.getText();
				String colonia = comboColonia.getSelectedItem().toString();
				String Estado = txtEstado.getText();
				String telefonoCelular = txtNumeroCelular.getText();
				String telefnoCasa = txtnumeroDeCasa.getText();
				String vivienda = comboBoxvivienda.getSelectedItem().toString();
				String nopersonas = comboBoxNopersonas.getSelectedItem().toString();
				String contribuyente = comboBoxcontribuyentealgasto.getSelectedItem().toString();
				String canalizadaPor = txtCanalizadPor.getText();
				String padecimiento = txtPadecimientoCronico.getText();
				String denuncia = txtDenuncia.getText();
				String dependientes = area.getText();
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtPadecimientoCronico.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
					txtDenuncia.requestFocus();
					}
			}
		});
		txtPadecimientoCronico.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPadecimientoCronico.setBackground(new Color(243, 220, 220));
		txtPadecimientoCronico.setBounds(27, 224, 194, 20);
		panel_4.add(txtPadecimientoCronico);
		txtPadecimientoCronico.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("PADECIMIENTO CRONICO");
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_22.setBounds(55, 247, 166, 14);
		panel_4.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("DENUNCIA");
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_23.setBounds(86, 291, 95, 14);
		panel_4.add(lblNewLabel_23);
		
		txtDenuncia = new JTextField();
		txtDenuncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Es la conexion ala base de datos con el programa
				
								ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				String sql = "INSERT INTO datos(FECHA,HORA,Apellido_Paterno,Apellido_Materno,Nombre,Estado_Civil,Ocupacion,Servicio_Medico,Grado_de_Estudios,Edad,Fecha_de_nacimiento,Ingreso_familiar,Domicilio,Codigo_postal,Colonia,Estado,Telefono_Celular,Telefono_Casa,Vivienda,No_Personas,Contribuyente_al_gasto,Canalizada_por,Padecimiento_y_o_Enfermedad_cronica,Denuncia,Dependientes_Economicos)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if (txtDenuncia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " ¡¡NO PUEDES CONTINUAR NECESITAS LLENAR ESTE CAMPO !!");
					}else {
						area.requestFocus();
					}
			}
		});
		txtDenuncia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDenuncia.setBackground(new Color(243, 220, 220));
		txtDenuncia.setBounds(27, 270, 194, 20);
		panel_4.add(txtDenuncia);
		txtDenuncia.setColumns(10);
		
		
		area.setBackground(new Color(243, 220, 220));
		area.setBounds(272, 313, 303, 270);
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
		
		JLabel lblNewLabel_26 = new JLabel("FECHA");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_26.setBounds(464, 71, 49, 14);
		contentPane.add(lblNewLabel_26);
		
		txtFecha = new JTextField(fech.obtenerFechaCortaInversa());
		txtFecha.setEditable(false);
		txtFecha.setBounds(511, 66, 116, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("HORA");
		lblNewLabel_27.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_27.setBounds(637, 71, 49, 14);
		contentPane.add(lblNewLabel_27);
		
		txtHora = new JTextField(fech.obtenerHoraCompleta());
		txtHora.setEditable(false);
		txtHora.setBounds(684, 68, 96, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
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
				Violencia ventana = new Violencia();
				dispose();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
			}
		});
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
