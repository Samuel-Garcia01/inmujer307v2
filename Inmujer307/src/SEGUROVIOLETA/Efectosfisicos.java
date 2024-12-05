package SEGUROVIOLETA;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.MenuInmujer;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class Efectosfisicos extends JFrame {

	private JPanel contentPane;
	
	String Fisicos="";
	String Psicologicos="";
	String Sexuales="";
	String patrimoniales="";
	//CheckBox efectos fisicos
	JCheckBox chkHerida = new JCheckBox("MORETONES");
	JCheckBox chkFractura = new JCheckBox("FRACTURA");
	JCheckBox chkEnfermedad = new JCheckBox("ENFERMEDAD");
	JCheckBox chkCicatrices = new JCheckBox("CICATRICES");
	JCheckBox chkQuemaduras = new JCheckBox("QUEMADURAS");
	JCheckBox chkNinguno = new JCheckBox("NINGUNO");
	//CheckBox efectos psicologicos
	JCheckBox chkAngustia = new JCheckBox("ANGUSTIA/MIEDO");
	JCheckBox chkEstresPostraumatico = new JCheckBox("ESTRES POSTRAUMATICO");
	JCheckBox chkAnsiedad = new JCheckBox("ANSIEDAD");
	JCheckBox chkTranstornoAlimenticio = new JCheckBox("TRANSTORNO ALIMENTICIO");
	JCheckBox chkTranstornoSuenio = new JCheckBox("TRANSTORNO DEL SUEÑO");
	JCheckBox chkDepresion = new JCheckBox("DEPRESION");
	JCheckBox chkIntentoSuicida = new JCheckBox("INTENTO SUICIDA");
	JCheckBox chkOtroPsicologico = new JCheckBox("OTRO");
	//CheckBox efectos sexuales
	JCheckBox chkInfecciones = new JCheckBox("INFECCIONES");
	JCheckBox chkEmbarazo = new JCheckBox("EMBARAZO");
	JCheckBox chkAborto = new JCheckBox("ABORTO");
	JCheckBox chkNoAplicaSexuales = new JCheckBox("NO APLICA");
	//CheckBox efectos patrimoniales
	JCheckBox chkDejoTrabajar = new JCheckBox("DEJO DE TRABAJAR");
	JCheckBox chkNoRecibePensionAlimenticia = new JCheckBox("NO RECIBE PENSION ALIMENTICIA");
	JCheckBox chkChantajeAportar = new JCheckBox("CHANTAJE PARA APORTAR");
	JCheckBox chkNoRecibeGasto = new JCheckBox("NO RECIBE PEN");
	JCheckBox chkPerdidaPropiedades = new JCheckBox("PERDIDA DE PROPIEDADES");
	JCheckBox chkPerdidaDocumentos = new JCheckBox("QUEMA/PERDIDA DE DOCUMENTOS");
	JCheckBox chkSalirDomicilio = new JCheckBox("SALIR DEL DOMICILIO");
	JCheckBox chkNoAplicaEconomico = new JCheckBox("NO APLICA");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final JButton btnNewButton = new JButton("REGRESAR");
	
	public void cargarDatos(ResultSet rs) {
	    try {
	        // Obtener datos del ResultSet
	        String efectosFisicos = rs.getString("Efectos_fisicos");
	        String efectosPsicologicos = rs.getString("Efectos_psicologicos");
	        String efectosSexuales = rs.getString("Efectos_sexuales");
	        String efectosEconomicos = rs.getString("Efectos_economicos_y_patrimoniales");

	        // Validar datos nulos o vacíos
	        efectosFisicos = (efectosFisicos == null) ? "" : efectosFisicos;
	        efectosPsicologicos = (efectosPsicologicos == null) ? "" : efectosPsicologicos;
	        efectosSexuales = (efectosSexuales == null) ? "" : efectosSexuales;
	        efectosEconomicos = (efectosEconomicos == null) ? "" : efectosEconomicos;

	        // Imprimir los datos obtenidos
	        System.out.println("Efectos Físicos obtenidos: " + efectosFisicos);
	        System.out.println("Efectos Psicológicos obtenidos: " + efectosPsicologicos);
	        System.out.println("Efectos Sexuales obtenidos: " + efectosSexuales);
	        System.out.println("Efectos Económicos obtenidos: " + efectosEconomicos);

	        // Definir arreglos de JCheckBox
	        JCheckBox[] efectosFisicosCheckboxes = { chkFractura, chkHerida, chkEnfermedad, chkCicatrices, chkQuemaduras, chkNinguno };
	        JCheckBox[] efectosPsicologicosCheckboxes = { chkAngustia, chkEstresPostraumatico, chkAnsiedad, chkTranstornoAlimenticio, chkTranstornoSuenio, chkDepresion, chkIntentoSuicida, chkOtroPsicologico };
	        JCheckBox[] efectosSexualesCheckboxes = { chkInfecciones, chkEmbarazo, chkAborto, chkNoAplicaSexuales };
	        JCheckBox[] efectosEconomicosCheckboxes = { chkDejoTrabajar, chkNoRecibePensionAlimenticia, chkNoRecibeGasto, chkChantajeAportar, chkPerdidaPropiedades, chkPerdidaDocumentos, chkSalirDomicilio, chkNoAplicaEconomico };

	        // Actualizar JCheckBox
	        actualizarCheckboxes(efectosFisicos.split(","), efectosFisicosCheckboxes, "Físicos");
	        actualizarCheckboxes(efectosPsicologicos.split(","), efectosPsicologicosCheckboxes, "Psicológicos");
	        actualizarCheckboxes(efectosSexuales.split(","), efectosSexualesCheckboxes, "Sexuales");
	        actualizarCheckboxes(efectosEconomicos.split(","), efectosEconomicosCheckboxes, "Económicos");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void actualizarCheckboxes(String[] efectosArray, JCheckBox[] checkboxes, String categoria) {
	    for (JCheckBox checkBox : checkboxes) {
	        boolean marcado = false;
	        System.out.println("Evaluando JCheckBox: " + checkBox.getText());
	        for (String efecto : efectosArray) {
	            System.out.println("Comparando con efecto: " + efecto.trim());
	            if (checkBox.getText().trim().equalsIgnoreCase(efecto.trim())) {
	                marcado = true;
	                System.out.println("Coincidencia encontrada para: " + checkBox.getText());
	                break;
	            }
	        }
	        checkBox.setSelected(marcado);
	        if (!marcado) {
	            System.out.println("No se encontró coincidencia para: " + checkBox.getText());
	        }
	    }
	}

	
	public void insertarDatosEfectos() {
		
		
		if (chkHerida.isSelected()) {
			Fisicos = chkHerida.getText().toLowerCase()+"\n";
		} else if (chkFractura.isSelected()) {
			Fisicos = chkFractura.getText().toLowerCase()+"\n";
		} else if (chkEnfermedad.isSelected()) {
			Fisicos = chkEnfermedad.getText().toLowerCase()+"\n";
		} else if (chkCicatrices.isSelected()) {
			Fisicos = chkCicatrices.getText().toLowerCase()+"\n";
		} else if (chkQuemaduras.isSelected()) {
			Fisicos = chkQuemaduras.getText().toLowerCase()+"\n";
		} else if (chkNinguno.isSelected()) {
			Fisicos = chkNinguno.getText().toLowerCase()+"\n";
		}
		
		if (chkAngustia.isSelected()) {
			Psicologicos = chkAngustia.getText().toLowerCase()+"\n";
		} else if (chkEstresPostraumatico.isSelected()) {
			Psicologicos = chkEstresPostraumatico.getText().toLowerCase()+"\n";
		} else if (chkAnsiedad.isSelected()) {
			Psicologicos = chkAnsiedad.getText().toLowerCase()+"\n";
		} else if (chkTranstornoAlimenticio.isSelected()) {
			Psicologicos = chkTranstornoAlimenticio.getText().toLowerCase()+"\n";
		} else if (chkTranstornoSuenio.isSelected()) {
			Psicologicos = chkTranstornoSuenio.getText().toLowerCase()+"\n";
		} else if (chkDepresion.isSelected()) {
			Psicologicos = chkDepresion.getText().toLowerCase()+"\n";
		} else if (chkIntentoSuicida.isSelected()) {
			Psicologicos = chkIntentoSuicida.getText().toLowerCase()+"\n";
		} else if (chkOtroPsicologico.isSelected()) {
			Psicologicos = chkOtroPsicologico.getText().toLowerCase()+"\n";
		}
		
		if (chkInfecciones.isSelected()) {
			Sexuales = chkInfecciones.getText().toLowerCase()+"\n";
		} else if (chkEmbarazo.isSelected()) {
			Sexuales = chkEmbarazo.getText().toLowerCase()+"\n";
		} else if (chkAborto.isSelected()) {
			Sexuales = chkAborto.getText().toLowerCase()+"\n";
		} else if (chkNoAplicaSexuales.isSelected()) {
			Sexuales = chkNoAplicaSexuales.getText().toLowerCase()+"\n";
		}
		
		if (chkDejoTrabajar.isSelected()) {
			patrimoniales = chkDejoTrabajar.getText().toLowerCase()+"\n";
		} else if (chkNoRecibePensionAlimenticia.isSelected()) {
			patrimoniales = chkNoRecibePensionAlimenticia.getText().toLowerCase()+"\n";
		} else if (chkNoRecibeGasto.isSelected()) {
			patrimoniales = chkNoRecibeGasto.getText().toLowerCase()+"\n";
		} else if (chkChantajeAportar.isSelected()) {
			patrimoniales = chkChantajeAportar.getText().toLowerCase()+"\n";
		} else if (chkPerdidaPropiedades.isSelected()) {
			patrimoniales = chkPerdidaPropiedades.getText().toLowerCase()+"\n";
		} else if (chkPerdidaDocumentos.isSelected()) {
			patrimoniales = chkPerdidaDocumentos.getText().toLowerCase()+"\n";
		} else if (chkSalirDomicilio.isSelected()) {
			patrimoniales = chkSalirDomicilio.getText().toLowerCase()+"\n";
		} else if (chkNoAplicaEconomico.isSelected()) {
			patrimoniales = chkNoAplicaEconomico.getText().toLowerCase()+"\n";
		}
	}
	
	public void insertarEfectos(String fs, String psq, String sx, String ecpm) {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "UPDATE datos SET Efectos_fisicos = '"+fs+"', Efectos_psicologicos = '"+psq+"', Efectos_sexuales = '"+sx+"', Efectos_economicos_y_patrimoniales = '"+ecpm+"' WHERE EXP = '"+DatosGenerales.exp+"'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			int valor = pst.executeUpdate();
			if (valor == 1) {
				System.out.println("Datos incertados");
				RedesDeApoyo ventana = new RedesDeApoyo();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			} else {
				System.out.println("Datos no incertados");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Efectosfisicos frame = new Efectosfisicos();
					frame.setLocationRelativeTo(null);
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
	public Efectosfisicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(247, 231, 245));
		panel.setBounds(0, 0, 807, 613);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelEfectosFisicos = new JPanel();
		panelEfectosFisicos.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosFisicos.setBackground(new Color(243, 220, 220));
		panelEfectosFisicos.setBounds(10, 68, 787, 92);
		panel.add(panelEfectosFisicos);
		panelEfectosFisicos.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" FISICOS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(325, 11, 97, 16);
		panelEfectosFisicos.add(lblNewLabel_1);
		buttonGroup.add(chkHerida);
		
		chkHerida.setForeground(new Color(47, 79, 79));
		chkHerida.setBackground(new Color(243, 220, 220));
		chkHerida.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkHerida.setBounds(56, 29, 97, 23);
		panelEfectosFisicos.add(chkHerida);
		buttonGroup.add(chkFractura);
		
		chkFractura.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkFractura.setBackground(new Color(243, 220, 220));
		chkFractura.setForeground(new Color(47, 79, 79));
		chkFractura.setBounds(56, 62, 97, 23);
		panelEfectosFisicos.add(chkFractura);
		buttonGroup.add(chkEnfermedad);
		
		chkEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEnfermedad.setBackground(new Color(243, 220, 220));
		chkEnfermedad.setForeground(new Color(47, 79, 79));
		chkEnfermedad.setBounds(335, 34, 118, 23);
		panelEfectosFisicos.add(chkEnfermedad);
		buttonGroup.add(chkCicatrices);
		
		chkCicatrices.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkCicatrices.setBackground(new Color(243, 220, 220));
		chkCicatrices.setForeground(new Color(47, 79, 79));
		chkCicatrices.setBounds(596, 36, 97, 23);
		panelEfectosFisicos.add(chkCicatrices);
		buttonGroup.add(chkQuemaduras);
		
		chkQuemaduras.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkQuemaduras.setBackground(new Color(243, 220, 220));
		chkQuemaduras.setForeground(new Color(47, 79, 79));
		chkQuemaduras.setBounds(335, 67, 135, 23);
		panelEfectosFisicos.add(chkQuemaduras);
		buttonGroup.add(chkNinguno);
		
		chkNinguno.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNinguno.setBackground(new Color(243, 220, 220));
		chkNinguno.setForeground(new Color(47, 79, 79));
		chkNinguno.setBounds(596, 62, 97, 23);
		panelEfectosFisicos.add(chkNinguno);
		
		JPanel panelEfectosPsicologicos = new JPanel();
		panelEfectosPsicologicos.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosPsicologicos.setBackground(new Color(243, 220, 220));
		panelEfectosPsicologicos.setBounds(10, 171, 395, 233);
		panel.add(panelEfectosPsicologicos);
		panelEfectosPsicologicos.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PSICOLOGICOS");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(139, 11, 129, 14);
		panelEfectosPsicologicos.add(lblNewLabel_2);
		buttonGroup_1.add(chkAngustia);
		chkAngustia.setForeground(new Color(47, 79, 79));
		
		chkAngustia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAngustia.setBackground(new Color(243, 220, 220));
		chkAngustia.setBounds(6, 47, 178, 23);
		panelEfectosPsicologicos.add(chkAngustia);
		buttonGroup_1.add(chkEstresPostraumatico);
		chkEstresPostraumatico.setForeground(new Color(47, 79, 79));
		
		chkEstresPostraumatico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEstresPostraumatico.setBackground(new Color(243, 220, 220));
		chkEstresPostraumatico.setBounds(6, 85, 178, 23);
		panelEfectosPsicologicos.add(chkEstresPostraumatico);
		buttonGroup_1.add(chkAnsiedad);
		chkAnsiedad.setForeground(new Color(47, 79, 79));
		
		chkAnsiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAnsiedad.setBackground(new Color(243, 220, 220));
		chkAnsiedad.setBounds(6, 121, 178, 23);
		panelEfectosPsicologicos.add(chkAnsiedad);
		buttonGroup_1.add(chkTranstornoAlimenticio);
		chkTranstornoAlimenticio.setForeground(new Color(47, 79, 79));
		
		chkTranstornoAlimenticio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkTranstornoAlimenticio.setBackground(new Color(243, 220, 220));
		chkTranstornoAlimenticio.setBounds(6, 203, 196, 23);
		panelEfectosPsicologicos.add(chkTranstornoAlimenticio);
		buttonGroup_1.add(chkTranstornoSuenio);
		chkTranstornoSuenio.setForeground(new Color(47, 79, 79));
		
		chkTranstornoSuenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkTranstornoSuenio.setBackground(new Color(243, 220, 220));
		chkTranstornoSuenio.setBounds(204, 47, 185, 23);
		panelEfectosPsicologicos.add(chkTranstornoSuenio);
		buttonGroup_1.add(chkDepresion);
		chkDepresion.setForeground(new Color(47, 79, 79));
		
		chkDepresion.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkDepresion.setBackground(new Color(243, 220, 220));
		chkDepresion.setBounds(204, 85, 167, 23);
		panelEfectosPsicologicos.add(chkDepresion);
		buttonGroup_1.add(chkIntentoSuicida);
		chkIntentoSuicida.setForeground(new Color(47, 79, 79));
		
		chkIntentoSuicida.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkIntentoSuicida.setBackground(new Color(243, 220, 220));
		chkIntentoSuicida.setBounds(6, 163, 185, 23);
		panelEfectosPsicologicos.add(chkIntentoSuicida);
		buttonGroup_1.add(chkOtroPsicologico);
		chkOtroPsicologico.setForeground(new Color(47, 79, 79));
		
		chkOtroPsicologico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkOtroPsicologico.setBackground(new Color(243, 220, 220));
		chkOtroPsicologico.setBounds(204, 121, 167, 23);
		panelEfectosPsicologicos.add(chkOtroPsicologico);
		
		JPanel panelEfectosSexuales = new JPanel();
		panelEfectosSexuales.setForeground(new Color(47, 79, 79));
		panelEfectosSexuales.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosSexuales.setBackground(new Color(243, 220, 220));
		panelEfectosSexuales.setBounds(429, 171, 368, 233);
		panel.add(panelEfectosSexuales);
		panelEfectosSexuales.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("SEXUALES");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(141, 11, 101, 14);
		panelEfectosSexuales.add(lblNewLabel_3);
		buttonGroup_2.add(chkInfecciones);
		chkInfecciones.setForeground(new Color(47, 79, 79));
		
		chkInfecciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkInfecciones.setBackground(new Color(243, 220, 220));
		chkInfecciones.setBounds(52, 74, 113, 23);
		panelEfectosSexuales.add(chkInfecciones);
		buttonGroup_2.add(chkEmbarazo);
		chkEmbarazo.setForeground(new Color(47, 79, 79));
		
		chkEmbarazo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEmbarazo.setBackground(new Color(243, 220, 220));
		chkEmbarazo.setBounds(215, 74, 97, 23);
		panelEfectosSexuales.add(chkEmbarazo);
		buttonGroup_2.add(chkAborto);
		chkAborto.setForeground(new Color(47, 79, 79));
		
		chkAborto.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAborto.setBackground(new Color(243, 220, 220));
		chkAborto.setBounds(52, 150, 97, 23);
		panelEfectosSexuales.add(chkAborto);
		buttonGroup_2.add(chkNoAplicaSexuales);
		chkNoAplicaSexuales.setForeground(new Color(47, 79, 79));
		
		chkNoAplicaSexuales.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoAplicaSexuales.setBackground(new Color(243, 220, 220));
		chkNoAplicaSexuales.setBounds(215, 150, 97, 23);
		panelEfectosSexuales.add(chkNoAplicaSexuales);
		
		JPanel panelEfectosEconomicos = new JPanel();
		panelEfectosEconomicos.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosEconomicos.setBackground(new Color(243, 220, 220));
		panelEfectosEconomicos.setBounds(10, 415, 787, 130);
		panel.add(panelEfectosEconomicos);
		panelEfectosEconomicos.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ECONOMICOS Y PATRIMONIALES");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(285, 11, 281, 14);
		panelEfectosEconomicos.add(lblNewLabel_4);
		buttonGroup_3.add(chkDejoTrabajar);
		chkDejoTrabajar.setForeground(new Color(47, 79, 79));
		
		//Economicos
		
		chkDejoTrabajar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkDejoTrabajar.setBackground(new Color(243, 220, 220));
		chkDejoTrabajar.setBounds(6, 45, 215, 23);
		panelEfectosEconomicos.add(chkDejoTrabajar);
		buttonGroup_3.add(chkNoRecibePensionAlimenticia);
		chkNoRecibePensionAlimenticia.setForeground(new Color(47, 79, 79));
		
		chkNoRecibePensionAlimenticia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoRecibePensionAlimenticia.setBackground(new Color(243, 220, 220));
		chkNoRecibePensionAlimenticia.setBounds(6, 93, 215, 23);
		panelEfectosEconomicos.add(chkNoRecibePensionAlimenticia);
		buttonGroup_3.add(chkNoRecibeGasto);
		chkNoRecibeGasto.setForeground(new Color(47, 79, 79));
		
		chkNoRecibeGasto.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoRecibeGasto.setBackground(new Color(243, 220, 220));
		chkNoRecibeGasto.setBounds(217, 93, 162, 23);
		panelEfectosEconomicos.add(chkNoRecibeGasto);
		buttonGroup_3.add(chkChantajeAportar);
		chkChantajeAportar.setForeground(new Color(47, 79, 79));
		
		chkChantajeAportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkChantajeAportar.setBackground(new Color(243, 220, 220));
		chkChantajeAportar.setBounds(217, 45, 184, 23);
		panelEfectosEconomicos.add(chkChantajeAportar);
		buttonGroup_3.add(chkPerdidaPropiedades);
		chkPerdidaPropiedades.setForeground(new Color(47, 79, 79));
		
		chkPerdidaPropiedades.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPerdidaPropiedades.setBackground(new Color(243, 220, 220));
		chkPerdidaPropiedades.setBounds(408, 45, 215, 23);
		panelEfectosEconomicos.add(chkPerdidaPropiedades);
		buttonGroup_3.add(chkPerdidaDocumentos);
		chkPerdidaDocumentos.setForeground(new Color(47, 79, 79));
		
		chkPerdidaDocumentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPerdidaDocumentos.setBackground(new Color(243, 220, 220));
		chkPerdidaDocumentos.setBounds(412, 93, 226, 23);
		panelEfectosEconomicos.add(chkPerdidaDocumentos);
		buttonGroup_3.add(chkSalirDomicilio);
		chkSalirDomicilio.setForeground(new Color(47, 79, 79));
		
		chkSalirDomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkSalirDomicilio.setBackground(new Color(243, 220, 220));
		chkSalirDomicilio.setBounds(634, 45, 147, 23);
		panelEfectosEconomicos.add(chkSalirDomicilio);
		buttonGroup_3.add(chkNoAplicaEconomico);
		chkNoAplicaEconomico.setForeground(new Color(47, 79, 79));
		
		chkNoAplicaEconomico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoAplicaEconomico.setBackground(new Color(243, 220, 220));
		chkNoAplicaEconomico.setBounds(640, 93, 141, 23);
		panelEfectosEconomicos.add(chkNoAplicaEconomico);
		
		JLabel lblNewLabel_5 = new JLabel("EFECTOS");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_5.setBounds(345, 0, 150, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Efectosfisicos.class.getResource("/img/EncabezadoJuegos.png")));
		lblNewLabel_7.setBounds(0, 0, 807, 57);
		panel.add(lblNewLabel_7);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setForeground(new Color(0, 0, 0));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarDatosEfectos();
				System.out.println(Fisicos);
				System.out.println(Psicologicos);
				System.out.println(Sexuales);
				System.out.println(patrimoniales);
				insertarEfectos(Fisicos, Psicologicos, Sexuales, patrimoniales);
			}
		});
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(224, 167, 167));
		btnSiguiente.setBounds(690, 555, 107, 23);
		panel.add(btnSiguiente);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.setForeground(new Color(0, 0, 0));
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
		btnInicio.setFont(new Font("Arial", Font.BOLD, 11));
		btnInicio.setBackground(new Color(224, 167, 167));
		btnInicio.setBounds(345, 555, 89, 23);
		panel.add(btnInicio);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(224, 167, 167));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(10, 555, 119, 23);
		
		panel.add(btnNewButton);
	}
}


