package PrimerContacto;

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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Efectosfisicos extends JFrame {

	private JPanel contentPane;
	
	String Fisicos="";
	String Psicologicos="";
	String Sexuales="";
	String patrimoniales="";
	//CheckBox efectos fisicos
	JCheckBox chkHerida = new JCheckBox("HERIDA");
	JCheckBox chkFractura = new JCheckBox("FRACTURA");
	JCheckBox chkAmputaciones = new JCheckBox("AMPUTACIONES");
	JCheckBox chkEnfermedad = new JCheckBox("ENFERMEDAD");
	JCheckBox chkCicatrices = new JCheckBox("CICATRICES");
	JCheckBox chkQuemaduras = new JCheckBox("QUEMADURAS");
	JCheckBox chkOtrosFisicos = new JCheckBox("OTROS");
	JCheckBox chkNinguno = new JCheckBox("NINGUNO");
	//CheckBox efectos psicologicos
	JCheckBox chkAngustia = new JCheckBox("ANGUSTIA/MIEDO");
	JCheckBox chkEstresPostraumatico = new JCheckBox("ESTRES POSTRAUMATICO");
	JCheckBox chkAnsiedad = new JCheckBox("ANSIEDAD");
	JCheckBox chkIdeaSuicida = new JCheckBox("IDEACION SUICIDA");
	JCheckBox chkTranstornoAlimenticio = new JCheckBox("TRANSTORNO ALIMENTICIO");
	JCheckBox chkTranstornoSuenio = new JCheckBox("TRANSTORNO DEL SUEÑO");
	JCheckBox chkDepresion = new JCheckBox("DEPRESION");
	JCheckBox chkAislamiento = new JCheckBox("AISLAMIENTO");
	JCheckBox chkIntentoSuicida = new JCheckBox("INTENTO SUICIDA");
	JCheckBox chkOtroPsicologico = new JCheckBox("OTRO");
	//CheckBox efectos sexuales
	JCheckBox chkInfecciones = new JCheckBox("INFECCIONES");
	JCheckBox chkEmbarazo = new JCheckBox("EMBARAZO");
	JCheckBox chkAborto = new JCheckBox("ABORTO");
	JCheckBox chkNoAplicaSexuales = new JCheckBox("NO APLICA");
	//CheckBox efectos patrimoniales
	JCheckBox chkDejoEstudiar = new JCheckBox("DEJO DE ESTUDIAR");
	JCheckBox chkNoRecibePensionAlimenticia = new JCheckBox("NO RECIBE PENSION ALIMENTICIA");
	JCheckBox chkChantajeAportar = new JCheckBox("CHANTAJE PARA APORTAR");
	JCheckBox chkNoRecibeGasto = new JCheckBox("NO RECIBE GASTO");
	JCheckBox chkPerdidaPropiedades = new JCheckBox("PERDIDA DE PROPIEDADES");
	JCheckBox chkPerdidaDocumentos = new JCheckBox("QUEMA/PERDIDA DE DOCUMENTOS");
	JCheckBox chkSalirDomicilio = new JCheckBox("SALIR DEL DOMICILIO");
	JCheckBox chkNoAplicaEconomico = new JCheckBox("NO APLICA");
	
	public void insertarDatosEfectos() {
		boolean [] condFisicos = new boolean[8];
		boolean [] condPsicologicos = new boolean[10];
		boolean [] condSexuales = new boolean[4];
		boolean [] condPatrimoniales = new boolean[8];
		
		for (int i = 0; i < 8; i++) {
			if (chkHerida.isSelected() && !condFisicos[0]) {
				Fisicos += (i+1)+". "+chkHerida.getText().toLowerCase()+"\n";
				condFisicos[0] = true;
			} else if (chkFractura.isSelected() && !condFisicos[1]) {
				Fisicos += (i+1)+". "+chkFractura.getText().toLowerCase()+"\n";
				condFisicos[1] = true;
			} else if (chkAmputaciones.isSelected() && !condFisicos[2]) {
				Fisicos += (i+1)+". "+chkFractura.getText().toLowerCase()+"\n";
				condFisicos[2] = true;
			} else if (chkEnfermedad.isSelected() && !condFisicos[3]) {
				Fisicos += (i+1)+". "+chkEnfermedad.getText().toLowerCase()+"\n";
				condFisicos[3] = true;
			} else if (chkCicatrices.isSelected() && !condFisicos[4]) {
				Fisicos += (i+1)+". "+chkCicatrices.getText().toLowerCase()+"\n";
				condFisicos[4] = true;
			} else if (chkQuemaduras.isSelected() && !condFisicos[5]) {
				Fisicos += (i+1)+". "+chkQuemaduras.getText().toLowerCase()+"\n";
				condFisicos[5] = true;
			} else if (chkOtrosFisicos.isSelected() && !condFisicos[6]) {
				Fisicos += (i+1)+". "+chkOtrosFisicos.getText().toLowerCase()+"\n";
				condFisicos[6] = true;
			} else if (chkNinguno.isSelected() && !condFisicos[7]) {
				Fisicos += (i+1)+". "+chkNinguno.getText().toLowerCase()+"\n";
				condFisicos[7] = true;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (chkAngustia.isSelected() && !condPsicologicos[0]) {
				Psicologicos += (i+1)+". "+chkAngustia.getText().toLowerCase()+"\n";
				condPsicologicos[0] = true;
			} else if (chkEstresPostraumatico.isSelected() && !condPsicologicos[1]) {
				Psicologicos += (i+1)+". "+chkEstresPostraumatico.getText().toLowerCase()+"\n";
				condPsicologicos[1] = true;
			} else if (chkAnsiedad.isSelected() && !condPsicologicos[2]) {
				Psicologicos += (i+1)+". "+chkAnsiedad.getText().toLowerCase()+"\n";
				condPsicologicos[2] = true;
			} else if (chkIdeaSuicida.isSelected() && !condPsicologicos[3]) {
				Psicologicos += (i+1)+". "+chkIdeaSuicida.getText().toLowerCase()+"\n";
				condPsicologicos[3] = true;
			} else if (chkTranstornoAlimenticio.isSelected() && !condPsicologicos[4]) {
				Psicologicos += (i+1)+". "+chkTranstornoAlimenticio.getText().toLowerCase()+"\n";
				condPsicologicos[4] = true;
			} else if (chkTranstornoSuenio.isSelected() && !condPsicologicos[5]) {
				Psicologicos += (i+1)+". "+chkTranstornoSuenio.getText().toLowerCase()+"\n";
				condPsicologicos[5] = true;
			} else if (chkDepresion.isSelected() && !condPsicologicos[6]) {
				Psicologicos += (i+1)+". "+chkDepresion.getText().toLowerCase()+"\n";
				condPsicologicos[6] = true;
			} else if (chkAislamiento.isSelected() && !condPsicologicos[7]) {
				Psicologicos += (i+1)+". "+chkAislamiento.getText().toLowerCase()+"\n";
				condPsicologicos[7] = true;
			} else if (chkIntentoSuicida.isSelected() && !condPsicologicos[8]) {
				Psicologicos += (i+1)+". "+chkIntentoSuicida.getText().toLowerCase()+"\n";
				condPsicologicos[8] = true;
			} else if (chkOtroPsicologico.isSelected() && !condPsicologicos[9]) {
				Psicologicos += (i+1)+". "+chkOtroPsicologico.getText().toLowerCase()+"\n";
				condPsicologicos[9] = true;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if (chkInfecciones.isSelected() && !condSexuales[0]) {
				Sexuales += (i+1)+". "+chkInfecciones.getText().toLowerCase()+"\n";
				condSexuales [0] = true;
			} else if (chkEmbarazo.isSelected() && !condSexuales[1]) {
				Sexuales += (i+1)+". "+chkEmbarazo.getText().toLowerCase()+"\n";
				condSexuales [1] = true;
			} else if (chkAborto.isSelected() && !condSexuales[2]) {
				Sexuales += (i+1)+". "+chkAborto.getText().toLowerCase()+"\n";
				condSexuales [2] = true;
			} else if (chkNoAplicaSexuales.isSelected() && !condSexuales[3]) {
				Sexuales += (i+1)+". "+chkNoAplicaSexuales.getText().toLowerCase()+"\n";
				condSexuales [3] = true;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 8; i++) {
			if (chkDejoEstudiar.isSelected() && !condPatrimoniales[0]) {
				patrimoniales += (i+1)+". "+chkDejoEstudiar.getText().toLowerCase()+"\n";
				condPatrimoniales [0]= true;
			} else if (chkNoRecibePensionAlimenticia.isSelected() && !condPatrimoniales[1]) {
				patrimoniales += (i+1)+". "+chkNoRecibePensionAlimenticia.getText().toLowerCase()+"\n";
				condPatrimoniales [1]= true;
			} else if (chkNoRecibeGasto.isSelected() && !condPatrimoniales[2]) {
				patrimoniales += (i+1)+". "+chkNoRecibeGasto.getText().toLowerCase()+"\n";
				condPatrimoniales [2]= true;
			} else if (chkChantajeAportar.isSelected() && !condPatrimoniales[3]) {
				patrimoniales += (i+1)+". "+chkChantajeAportar.getText().toLowerCase()+"\n";
				condPatrimoniales [3]= true;
			} else if (chkPerdidaPropiedades.isSelected() && !condPatrimoniales[4]) {
				patrimoniales += (i+1)+". "+chkPerdidaPropiedades.getText().toLowerCase()+"\n";
				condPatrimoniales [4]= true;
			} else if (chkPerdidaDocumentos.isSelected() && !condPatrimoniales[5]) {
				patrimoniales += (i+1)+". "+chkPerdidaDocumentos.getText().toLowerCase()+"\n";
				condPatrimoniales [5]= true;
			} else if (chkSalirDomicilio.isSelected() && !condPatrimoniales[6]) {
				patrimoniales += (i+1)+". "+chkSalirDomicilio.getText().toLowerCase()+"\n";
				condPatrimoniales [6]= true;
			} else if (chkNoAplicaEconomico.isSelected() && !condPatrimoniales[7]) {
				patrimoniales += (i+1)+". "+chkNoAplicaEconomico.getText().toLowerCase()+"\n";
				condPatrimoniales [7]= true;
			} else {
				break;
			}
		}
	}
	
	public void insertarEfectos(String fs, String psq, String sx, String ecpm) {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "UPDATE datos SET Efectos_fisicos = '"+fs+"', Efectos_psicologicos = '"+psq+"', Efectos_sexuales = '"+sx+"', Efectos_económicos_y_patrimoniales = '"+ecpm+"' WHERE EXP = '"+DatosGenerales.exp+"'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			int valor = pst.executeUpdate();
			if (valor == 1) {
				System.out.println("Datos incertados");
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
		panel.setBounds(0, 0, 807, 611);
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
		
		chkHerida.setForeground(Color.BLACK);
		chkHerida.setBackground(new Color(243, 220, 220));
		chkHerida.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkHerida.setBounds(6, 27, 97, 23);
		panelEfectosFisicos.add(chkHerida);
		
		chkFractura.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkFractura.setBackground(new Color(243, 220, 220));
		chkFractura.setForeground(Color.BLACK);
		chkFractura.setBounds(6, 60, 97, 23);
		panelEfectosFisicos.add(chkFractura);
		
		chkAmputaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAmputaciones.setBackground(new Color(243, 220, 220));
		chkAmputaciones.setForeground(Color.BLACK);
		chkAmputaciones.setBounds(189, 27, 118, 23);
		panelEfectosFisicos.add(chkAmputaciones);
		
		chkEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEnfermedad.setBackground(new Color(243, 220, 220));
		chkEnfermedad.setForeground(Color.BLACK);
		chkEnfermedad.setBounds(189, 60, 118, 23);
		panelEfectosFisicos.add(chkEnfermedad);
		
		chkCicatrices.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkCicatrices.setBackground(new Color(243, 220, 220));
		chkCicatrices.setForeground(Color.BLACK);
		chkCicatrices.setBounds(384, 34, 97, 23);
		panelEfectosFisicos.add(chkCicatrices);
		
		chkQuemaduras.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkQuemaduras.setBackground(new Color(243, 220, 220));
		chkQuemaduras.setForeground(Color.BLACK);
		chkQuemaduras.setBounds(384, 60, 135, 23);
		panelEfectosFisicos.add(chkQuemaduras);
		
		chkOtrosFisicos.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkOtrosFisicos.setBackground(new Color(243, 220, 220));
		chkOtrosFisicos.setForeground(Color.BLACK);
		chkOtrosFisicos.setBounds(621, 34, 97, 23);
		panelEfectosFisicos.add(chkOtrosFisicos);
		
		chkNinguno.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNinguno.setBackground(new Color(243, 220, 220));
		chkNinguno.setForeground(Color.BLACK);
		chkNinguno.setBounds(621, 60, 97, 23);
		panelEfectosFisicos.add(chkNinguno);
		
		JPanel panelEfectosPsicologicos = new JPanel();
		panelEfectosPsicologicos.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosPsicologicos.setBackground(new Color(243, 220, 220));
		panelEfectosPsicologicos.setBounds(10, 171, 395, 233);
		panel.add(panelEfectosPsicologicos);
		panelEfectosPsicologicos.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PSICOLOGICOS");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(139, 11, 129, 14);
		panelEfectosPsicologicos.add(lblNewLabel_2);
		
		chkAngustia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAngustia.setBackground(new Color(243, 220, 220));
		chkAngustia.setBounds(6, 47, 178, 23);
		panelEfectosPsicologicos.add(chkAngustia);
		
		chkEstresPostraumatico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEstresPostraumatico.setBackground(new Color(243, 220, 220));
		chkEstresPostraumatico.setBounds(6, 85, 178, 23);
		panelEfectosPsicologicos.add(chkEstresPostraumatico);
		
		chkAnsiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAnsiedad.setBackground(new Color(243, 220, 220));
		chkAnsiedad.setBounds(6, 121, 178, 23);
		panelEfectosPsicologicos.add(chkAnsiedad);
		
		chkIdeaSuicida.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkIdeaSuicida.setBackground(new Color(243, 220, 220));
		chkIdeaSuicida.setBounds(6, 162, 178, 23);
		panelEfectosPsicologicos.add(chkIdeaSuicida);
		
		chkTranstornoAlimenticio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkTranstornoAlimenticio.setBackground(new Color(243, 220, 220));
		chkTranstornoAlimenticio.setBounds(6, 203, 196, 23);
		panelEfectosPsicologicos.add(chkTranstornoAlimenticio);
		
		chkTranstornoSuenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkTranstornoSuenio.setBackground(new Color(243, 220, 220));
		chkTranstornoSuenio.setBounds(204, 47, 185, 23);
		panelEfectosPsicologicos.add(chkTranstornoSuenio);
		
		chkDepresion.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkDepresion.setBackground(new Color(243, 220, 220));
		chkDepresion.setBounds(204, 85, 167, 23);
		panelEfectosPsicologicos.add(chkDepresion);
		
		chkAislamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAislamiento.setBackground(new Color(243, 220, 220));
		chkAislamiento.setBounds(204, 121, 167, 23);
		panelEfectosPsicologicos.add(chkAislamiento);
		
		chkIntentoSuicida.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkIntentoSuicida.setBackground(new Color(243, 220, 220));
		chkIntentoSuicida.setBounds(204, 162, 185, 23);
		panelEfectosPsicologicos.add(chkIntentoSuicida);
		
		chkOtroPsicologico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkOtroPsicologico.setBackground(new Color(243, 220, 220));
		chkOtroPsicologico.setBounds(204, 203, 167, 23);
		panelEfectosPsicologicos.add(chkOtroPsicologico);
		
		JPanel panelEfectosSexuales = new JPanel();
		panelEfectosSexuales.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosSexuales.setBackground(new Color(243, 220, 220));
		panelEfectosSexuales.setBounds(429, 171, 368, 233);
		panel.add(panelEfectosSexuales);
		panelEfectosSexuales.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("SEXUALES");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(141, 11, 101, 14);
		panelEfectosSexuales.add(lblNewLabel_3);
		
		chkInfecciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkInfecciones.setBackground(new Color(243, 220, 220));
		chkInfecciones.setBounds(52, 74, 113, 23);
		panelEfectosSexuales.add(chkInfecciones);
		
		chkEmbarazo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkEmbarazo.setBackground(new Color(243, 220, 220));
		chkEmbarazo.setBounds(215, 74, 97, 23);
		panelEfectosSexuales.add(chkEmbarazo);
		
		chkAborto.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAborto.setBackground(new Color(243, 220, 220));
		chkAborto.setBounds(52, 150, 97, 23);
		panelEfectosSexuales.add(chkAborto);
		
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
		
		//Economicos
		
		chkDejoEstudiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkDejoEstudiar.setBackground(new Color(243, 220, 220));
		chkDejoEstudiar.setBounds(6, 45, 215, 23);
		panelEfectosEconomicos.add(chkDejoEstudiar);
		
		chkNoRecibePensionAlimenticia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoRecibePensionAlimenticia.setBackground(new Color(243, 220, 220));
		chkNoRecibePensionAlimenticia.setBounds(6, 93, 215, 23);
		panelEfectosEconomicos.add(chkNoRecibePensionAlimenticia);
		
		chkNoRecibeGasto.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoRecibeGasto.setBackground(new Color(243, 220, 220));
		chkNoRecibeGasto.setBounds(217, 93, 162, 23);
		panelEfectosEconomicos.add(chkNoRecibeGasto);
		
		chkChantajeAportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkChantajeAportar.setBackground(new Color(243, 220, 220));
		chkChantajeAportar.setBounds(217, 45, 184, 23);
		panelEfectosEconomicos.add(chkChantajeAportar);
		
		chkPerdidaPropiedades.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPerdidaPropiedades.setBackground(new Color(243, 220, 220));
		chkPerdidaPropiedades.setBounds(408, 45, 215, 23);
		panelEfectosEconomicos.add(chkPerdidaPropiedades);
		
		chkPerdidaDocumentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPerdidaDocumentos.setBackground(new Color(243, 220, 220));
		chkPerdidaDocumentos.setBounds(412, 93, 226, 23);
		panelEfectosEconomicos.add(chkPerdidaDocumentos);
		
		chkSalirDomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkSalirDomicilio.setBackground(new Color(243, 220, 220));
		chkSalirDomicilio.setBounds(634, 45, 147, 23);
		panelEfectosEconomicos.add(chkSalirDomicilio);
		
		chkNoAplicaEconomico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkNoAplicaEconomico.setBackground(new Color(243, 220, 220));
		chkNoAplicaEconomico.setBounds(640, 93, 141, 23);
		panelEfectosEconomicos.add(chkNoAplicaEconomico);
		
		JLabel lblNewLabel_5 = new JLabel("EFECTOS");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_5.setBounds(316, 22, 151, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Efectosfisicos.class.getResource("/IMG/butterfly_side_view_56.png")));
		lblNewLabel.setBounds(251, 11, 55, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Efectosfisicos.class.getResource("/IMG/butterfly_side_espejo.png")));
		lblNewLabel_6.setBounds(444, 11, 67, 46);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Efectosfisicos.class.getResource("/IMG/encabezado.gif")));
		lblNewLabel_7.setBounds(0, 0, 807, 57);
		panel.add(lblNewLabel_7);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarDatosEfectos();
				System.out.println(Fisicos);
				System.out.println(Psicologicos);
				System.out.println(Sexuales);
				System.out.println(patrimoniales);
				insertarEfectos(Fisicos, Psicologicos, Sexuales, patrimoniales);
				RedesDeApoyo ventana = new RedesDeApoyo();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(243, 220, 220));
		btnSiguiente.setBounds(481, 577, 107, 23);
		panel.add(btnSiguiente);
		
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
		btnInicio.setFont(new Font("Arial", Font.BOLD, 11));
		btnInicio.setBackground(new Color(243, 220, 220));
		btnInicio.setBounds(270, 577, 89, 23);
		panel.add(btnInicio);
	}
}
