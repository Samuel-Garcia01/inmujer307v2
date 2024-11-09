package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Efectosfisicos extends JFrame {

	private JPanel contentPane;
	private JCheckBox checkBoxCicatrices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Efectosfisicos frame = new Efectosfisicos();
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
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(325, 11, 97, 16);
		panelEfectosFisicos.add(lblNewLabel_1);
		
		JCheckBox checkBoxHerida = new JCheckBox("HERIDA");
		checkBoxHerida.setForeground(Color.BLACK);
		checkBoxHerida.setBackground(new Color(243, 220, 220));
		checkBoxHerida.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxHerida.setBounds(6, 27, 97, 23);
		panelEfectosFisicos.add(checkBoxHerida);
		
		JCheckBox checkBoxFractura = new JCheckBox("FRACTURA");
		checkBoxFractura.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxFractura.setBackground(new Color(243, 220, 220));
		checkBoxFractura.setForeground(Color.BLACK);
		checkBoxFractura.setBounds(6, 60, 97, 23);
		panelEfectosFisicos.add(checkBoxFractura);
		
		JCheckBox checkBoxAmputaciones = new JCheckBox("AMPUTACIONES");
		checkBoxAmputaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxAmputaciones.setBackground(new Color(243, 220, 220));
		checkBoxAmputaciones.setForeground(Color.BLACK);
		checkBoxAmputaciones.setBounds(189, 27, 118, 23);
		panelEfectosFisicos.add(checkBoxAmputaciones);
		
		JCheckBox checkBoxEnfermedad = new JCheckBox("ENFERMEDAD");
		checkBoxEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxEnfermedad.setBackground(new Color(243, 220, 220));
		checkBoxEnfermedad.setForeground(Color.BLACK);
		checkBoxEnfermedad.setBounds(189, 60, 118, 23);
		panelEfectosFisicos.add(checkBoxEnfermedad);
		
		checkBoxCicatrices = new JCheckBox("CICATRICES");
		checkBoxCicatrices.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxCicatrices.setBackground(new Color(243, 220, 220));
		checkBoxCicatrices.setForeground(Color.BLACK);
		checkBoxCicatrices.setBounds(384, 34, 97, 23);
		panelEfectosFisicos.add(checkBoxCicatrices);
		
		JCheckBox checkBoxQuemaduras = new JCheckBox("QUEMADURAS");
		checkBoxQuemaduras.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxQuemaduras.setBackground(new Color(243, 220, 220));
		checkBoxQuemaduras.setForeground(Color.BLACK);
		checkBoxQuemaduras.setBounds(384, 60, 135, 23);
		panelEfectosFisicos.add(checkBoxQuemaduras);
		
		JCheckBox checkboxOtrosFisicos = new JCheckBox("OTROS");
		checkboxOtrosFisicos.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkboxOtrosFisicos.setBackground(new Color(243, 220, 220));
		checkboxOtrosFisicos.setForeground(Color.BLACK);
		checkboxOtrosFisicos.setBounds(621, 34, 97, 23);
		panelEfectosFisicos.add(checkboxOtrosFisicos);
		
		JCheckBox checkBoxNinguno = new JCheckBox("NINGUNO");
		checkBoxNinguno.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxNinguno.setBackground(new Color(243, 220, 220));
		checkBoxNinguno.setForeground(Color.BLACK);
		checkBoxNinguno.setBounds(621, 60, 97, 23);
		panelEfectosFisicos.add(checkBoxNinguno);
		
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
		
		JCheckBox checkboxAngustia = new JCheckBox("ANGUSTIA/MIEDO");
		checkboxAngustia.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkboxAngustia.setBackground(new Color(243, 220, 220));
		checkboxAngustia.setBounds(6, 47, 178, 23);
		panelEfectosPsicologicos.add(checkboxAngustia);
		
		JCheckBox checkBoxEstresPostraumatico = new JCheckBox("ESTRES POSTRAUMATICO");
		checkBoxEstresPostraumatico.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxEstresPostraumatico.setBackground(new Color(243, 220, 220));
		checkBoxEstresPostraumatico.setBounds(6, 85, 178, 23);
		panelEfectosPsicologicos.add(checkBoxEstresPostraumatico);
		
		JCheckBox checkBoxAnsiedad = new JCheckBox("ANSIEDAD");
		checkBoxAnsiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxAnsiedad.setBackground(new Color(243, 220, 220));
		checkBoxAnsiedad.setBounds(6, 121, 178, 23);
		panelEfectosPsicologicos.add(checkBoxAnsiedad);
		
		JCheckBox checkBoxIdeaSuicida = new JCheckBox("IDEACION SUICIDA ");
		checkBoxIdeaSuicida.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxIdeaSuicida.setBackground(new Color(243, 220, 220));
		checkBoxIdeaSuicida.setBounds(6, 162, 178, 23);
		panelEfectosPsicologicos.add(checkBoxIdeaSuicida);
		
		JCheckBox checkBoxTranstornoAlimenticio = new JCheckBox("TRANSTORNO ALIMENTICIO");
		checkBoxTranstornoAlimenticio.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxTranstornoAlimenticio.setBackground(new Color(243, 220, 220));
		checkBoxTranstornoAlimenticio.setBounds(6, 203, 196, 23);
		panelEfectosPsicologicos.add(checkBoxTranstornoAlimenticio);
		
		JCheckBox checkBoxTranstornoSuenio = new JCheckBox("TRANSTORNO DEL SUEÑO");
		checkBoxTranstornoSuenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxTranstornoSuenio.setBackground(new Color(243, 220, 220));
		checkBoxTranstornoSuenio.setBounds(204, 47, 185, 23);
		panelEfectosPsicologicos.add(checkBoxTranstornoSuenio);
		
		JCheckBox checkboxDepresion = new JCheckBox("DEPRESION");
		checkboxDepresion.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkboxDepresion.setBackground(new Color(243, 220, 220));
		checkboxDepresion.setBounds(204, 85, 167, 23);
		panelEfectosPsicologicos.add(checkboxDepresion);
		
		JCheckBox checkBoxAislamiento = new JCheckBox("AISLAMIENTO");
		checkBoxAislamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxAislamiento.setBackground(new Color(243, 220, 220));
		checkBoxAislamiento.setBounds(204, 121, 167, 23);
		panelEfectosPsicologicos.add(checkBoxAislamiento);
		
		JCheckBox checkBoxIntentoSuicida = new JCheckBox("INTENTO SUICIDA");
		checkBoxIntentoSuicida.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxIntentoSuicida.setBackground(new Color(243, 220, 220));
		checkBoxIntentoSuicida.setBounds(204, 162, 185, 23);
		panelEfectosPsicologicos.add(checkBoxIntentoSuicida);
		
		JCheckBox checkBoxOtroPsicologico = new JCheckBox("OTRO");
		checkBoxOtroPsicologico.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxOtroPsicologico.setBackground(new Color(243, 220, 220));
		checkBoxOtroPsicologico.setBounds(204, 203, 167, 23);
		panelEfectosPsicologicos.add(checkBoxOtroPsicologico);
		
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
		
		JCheckBox checkBoxInfecciones = new JCheckBox("INFECCIONES");
		checkBoxInfecciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxInfecciones.setBackground(new Color(243, 220, 220));
		checkBoxInfecciones.setBounds(52, 74, 113, 23);
		panelEfectosSexuales.add(checkBoxInfecciones);
		
		JCheckBox checkBoxEmbarazo = new JCheckBox("EMBARAZO");
		checkBoxEmbarazo.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxEmbarazo.setBackground(new Color(243, 220, 220));
		checkBoxEmbarazo.setBounds(215, 74, 97, 23);
		panelEfectosSexuales.add(checkBoxEmbarazo);
		
		JCheckBox chckbxNewCheckBox_20 = new JCheckBox("ABORTO");
		chckbxNewCheckBox_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_20.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_20.setBounds(52, 150, 97, 23);
		panelEfectosSexuales.add(chckbxNewCheckBox_20);
		
		JCheckBox checkBoxNoAplicaSexuales = new JCheckBox("NO APLICA");
		checkBoxNoAplicaSexuales.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxNoAplicaSexuales.setBackground(new Color(243, 220, 220));
		checkBoxNoAplicaSexuales.setBounds(215, 150, 97, 23);
		panelEfectosSexuales.add(checkBoxNoAplicaSexuales);
		
		JPanel panelEfectosEconomicos = new JPanel();
		panelEfectosEconomicos.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panelEfectosEconomicos.setBackground(new Color(243, 220, 220));
		panelEfectosEconomicos.setBounds(10, 415, 787, 130);
		panel.add(panelEfectosEconomicos);
		panelEfectosEconomicos.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ECONOMICOS Y PATRIMONIALES");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(297, 11, 269, 14);
		panelEfectosEconomicos.add(lblNewLabel_4);
		
		JCheckBox checkBoxDejoEstudiar = new JCheckBox("DEJO DE ESTUDIAR");
		checkBoxDejoEstudiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxDejoEstudiar.setBackground(new Color(243, 220, 220));
		checkBoxDejoEstudiar.setBounds(6, 45, 215, 23);
		panelEfectosEconomicos.add(checkBoxDejoEstudiar);
		
		JCheckBox checkBoxNoRecibePensionAlimenticia = new JCheckBox("NO RECIBE PENSION ALIMENTICIA");
		checkBoxNoRecibePensionAlimenticia.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxNoRecibePensionAlimenticia.setBackground(new Color(243, 220, 220));
		checkBoxNoRecibePensionAlimenticia.setBounds(6, 93, 215, 23);
		panelEfectosEconomicos.add(checkBoxNoRecibePensionAlimenticia);
		
		JCheckBox checkBoxNoRecibeGasto = new JCheckBox("NO RECIBE GASTO");
		checkBoxNoRecibeGasto.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxNoRecibeGasto.setBackground(new Color(243, 220, 220));
		checkBoxNoRecibeGasto.setBounds(217, 93, 162, 23);
		panelEfectosEconomicos.add(checkBoxNoRecibeGasto);
		
		JCheckBox checkboxChantajeAportar = new JCheckBox("CHANTAJE PARA APORTAR");
		checkboxChantajeAportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkboxChantajeAportar.setBackground(new Color(243, 220, 220));
		checkboxChantajeAportar.setBounds(217, 45, 184, 23);
		panelEfectosEconomicos.add(checkboxChantajeAportar);
		
		JCheckBox checkBoxPerdidaPropiedades = new JCheckBox("PERDIDA DE PROPIEDADES");
		checkBoxPerdidaPropiedades.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxPerdidaPropiedades.setBackground(new Color(243, 220, 220));
		checkBoxPerdidaPropiedades.setBounds(408, 45, 215, 23);
		panelEfectosEconomicos.add(checkBoxPerdidaPropiedades);
		
		JCheckBox checkBoxPerdidaDocumentos = new JCheckBox("QUEMA/PERDIDA DE DOCUMENTOS");
		checkBoxPerdidaDocumentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxPerdidaDocumentos.setBackground(new Color(243, 220, 220));
		checkBoxPerdidaDocumentos.setBounds(412, 93, 226, 23);
		panelEfectosEconomicos.add(checkBoxPerdidaDocumentos);
		
		JCheckBox checkBoxSalirDomicilio = new JCheckBox("SALIR DEL DOMICILIO");
		checkBoxSalirDomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxSalirDomicilio.setBackground(new Color(243, 220, 220));
		checkBoxSalirDomicilio.setBounds(634, 45, 147, 23);
		panelEfectosEconomicos.add(checkBoxSalirDomicilio);
		
		JCheckBox checkBoxNoAplicaEconomico = new JCheckBox("NO APLICA");
		checkBoxNoAplicaEconomico.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBoxNoAplicaEconomico.setBackground(new Color(243, 220, 220));
		checkBoxNoAplicaEconomico.setBounds(640, 93, 141, 23);
		panelEfectosEconomicos.add(checkBoxNoAplicaEconomico);
		
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
				String fisicos;
				String psicologicos;
				String sexuales;
				String patrimoniales;
			}
		});
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(243, 220, 220));
		btnSiguiente.setBounds(589, 577, 107, 23);
		panel.add(btnSiguiente);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 11));
		btnRegresar.setBackground(new Color(243, 220, 220));
		btnRegresar.setBounds(360, 577, 107, 23);
		panel.add(btnRegresar);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.setFont(new Font("Arial", Font.BOLD, 11));
		btnInicio.setBackground(new Color(243, 220, 220));
		btnInicio.setBounds(142, 577, 89, 23);
		panel.add(btnInicio);
	}
}
