package SEGUROVIOLETA;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class Violencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public void insertar(String tv, String md, String hm, String des) {

		try {

			// UPDATE datos SET Tipos_de_Violencia = "aaaa", Modalidades_de_violencia =
			// "bbb", Hechos_y_motivos_de_la_atencion = "ccc", Descripcion = ""
			ConexionInmujer conexion = new ConexionInmujer();
			Connection con = conexion.conectar();

			String sql = "UPDATE datos SET Tipos_de_Violencia = ?, Modalidades_de_violencia = ?, Hechos_y_motivos_de_la_atencion = ?, Descripcion = ? WHERE EXP = ?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, tv);
			preparedStmt.setString(2, md);
			preparedStmt.setString(3, hm);
			preparedStmt.setString(4, des);
			preparedStmt.setInt(5, DatosGenerales.exp);

			int valor = preparedStmt.executeUpdate();
			if (valor == 1) {
				System.out.println("Insertado correctamente");
				
				DATOSDELAGRESOR ventana = new DATOSDELAGRESOR();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();

				con.close();
			} else {
				System.out.println("No se inserto");
			}
		}

		catch (Exception e) {
			System.err.println("Error esto no esta funcionando");
			e.printStackTrace();
			System.out.println(e);
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Violencia frame = new Violencia();
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
	public Violencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 809, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Violencia.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel_5.setBounds(251, 0, 50, 57);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Violencia.class.getResource("/img/butterfly_side_espejo.png")));
		lblNewLabel_6.setBounds(480, 0, 50, 57);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("    Violencia");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_7.setBounds(305, 0, 165, 57);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Violencia.class.getResource("/img/encabezadodatos.png")));
		lblNewLabel_8.setBounds(0, 0, 809, 57);
		panel.add(lblNewLabel_8);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(10, 77, 386, 232);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JCheckBox chckbxViolenciaFisica = new JCheckBox("Violencia Física");
		chckbxViolenciaFisica.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaFisica);
		chckbxViolenciaFisica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaFisica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaFisica.setBounds(20, 42, 149, 21);
		panel_1.add(chckbxViolenciaFisica);

		JLabel lblNewLabel = new JLabel("Tipos de Violencia");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(138, 10, 113, 13);
		panel_1.add(lblNewLabel);

		JCheckBox chckbxViolenciaPsicologica = new JCheckBox("Violencia Psicológica");
		chckbxViolenciaPsicologica.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaPsicologica);
		chckbxViolenciaPsicologica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPsicologica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPsicologica.setBounds(198, 93, 149, 21);
		panel_1.add(chckbxViolenciaPsicologica);

		JCheckBox chckbxViolenciaSexual = new JCheckBox("Volencia Sexual");
		chckbxViolenciaSexual.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaSexual);
		chckbxViolenciaSexual.setBackground(new Color(243, 220, 220));
		chckbxViolenciaSexual.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaSexual.setBounds(20, 93, 149, 21);
		panel_1.add(chckbxViolenciaSexual);

		JCheckBox chckbxViolenciaEconomica = new JCheckBox("Violencia Económica");
		chckbxViolenciaEconomica.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaEconomica);
		chckbxViolenciaEconomica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaEconomica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaEconomica.setBounds(198, 139, 149, 21);
		panel_1.add(chckbxViolenciaEconomica);

		JCheckBox chckbxViolenciaPatrimonial = new JCheckBox("Violencia Patrimonial");
		chckbxViolenciaPatrimonial.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaPatrimonial);
		chckbxViolenciaPatrimonial.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPatrimonial.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPatrimonial.setBounds(20, 139, 149, 21);
		panel_1.add(chckbxViolenciaPatrimonial);

		JCheckBox chckbxViolenciaVicaria = new JCheckBox("Violencia Vicaria");
		chckbxViolenciaVicaria.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaVicaria);
		chckbxViolenciaVicaria.setBackground(new Color(243, 220, 220));
		chckbxViolenciaVicaria.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaVicaria.setBounds(198, 42, 149, 21);
		panel_1.add(chckbxViolenciaVicaria);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_2.setBackground(new Color(243, 220, 220));
		panel_2.setBounds(413, 77, 386, 232);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Modalidades de Violencia");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(115, 10, 155, 13);
		panel_2.add(lblNewLabel_1);

		JCheckBox chckbxFamilia = new JCheckBox("Familia");
		chckbxFamilia.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxFamilia);
		chckbxFamilia.setBackground(new Color(243, 220, 220));
		chckbxFamilia.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxFamilia.setBounds(48, 42, 108, 21);
		panel_2.add(chckbxFamilia);

		JCheckBox chckbxDocente = new JCheckBox("Docente");
		chckbxDocente.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxDocente);
		chckbxDocente.setBackground(new Color(243, 220, 220));
		chckbxDocente.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxDocente.setBounds(48, 91, 108, 21);
		panel_2.add(chckbxDocente);

		JCheckBox chckbxInstitucional = new JCheckBox("Institucional");
		chckbxInstitucional.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxInstitucional);
		chckbxInstitucional.setBackground(new Color(243, 220, 220));
		chckbxInstitucional.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxInstitucional.setBounds(48, 135, 108, 21);
		panel_2.add(chckbxInstitucional);

		JCheckBox chckbxComunitario = new JCheckBox("Comunitaria");
		chckbxComunitario.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxComunitario);
		chckbxComunitario.setBackground(new Color(243, 220, 220));
		chckbxComunitario.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxComunitario.setBounds(224, 91, 113, 21);
		panel_2.add(chckbxComunitario);

		JCheckBox chckbxLaboral = new JCheckBox("Laboral");
		chckbxLaboral.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxLaboral);
		chckbxLaboral.setBackground(new Color(243, 220, 220));
		chckbxLaboral.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxLaboral.setBounds(224, 135, 93, 21);
		panel_2.add(chckbxLaboral);

		JCheckBox chckbxCibernetica = new JCheckBox("Cibernética");
		chckbxCibernetica.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxCibernetica);
		chckbxCibernetica.setBackground(new Color(243, 220, 220));
		chckbxCibernetica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxCibernetica.setBounds(224, 42, 93, 21);
		panel_2.add(chckbxCibernetica);
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 320, 787, 104);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(75, 0, 130));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setBackground(new Color(243, 220, 220));
		textArea.setBounds(10, 31, 769, 67);
		panel_4.add(textArea);

		JLabel lblNewLabel_10 = new JLabel("Descripción de los Hechos del ultimo episodio de violencia");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(10, 9, 769, 13);
		panel_4.add(lblNewLabel_10);

		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 12));
		btnSiguiente.setForeground(new Color(0, 0, 0));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionInmujer conMujer = new ConexionInmujer();

				String tiposDeViolencia = "";

				if (chckbxViolenciaFisica.isSelected()) {
					tiposDeViolencia = chckbxViolenciaFisica.getText();
				}
				if (chckbxViolenciaSexual.isSelected()) {
					tiposDeViolencia = chckbxViolenciaSexual.getText();
				}
				if (chckbxViolenciaPatrimonial.isSelected()) {
					tiposDeViolencia = chckbxViolenciaPatrimonial.getText();
				}
				if (chckbxViolenciaVicaria.isSelected()) {
					tiposDeViolencia = chckbxViolenciaVicaria.getText();
				}
				if (chckbxViolenciaPsicologica.isSelected()) {
					tiposDeViolencia = chckbxViolenciaPsicologica.getText();
				}
				if (chckbxViolenciaEconomica.isSelected()) {
					tiposDeViolencia = chckbxViolenciaEconomica.getText();
				}

				String modalidades = "";

				if (chckbxFamilia.isSelected()) {
					modalidades = chckbxFamilia.getText();
				}
				if (chckbxDocente.isSelected()) {
					modalidades = chckbxDocente.getText();
				}
				if (chckbxInstitucional.isSelected()) {
					modalidades = chckbxInstitucional.getText();
				}
				if (chckbxComunitario.isSelected()) {
					modalidades = chckbxComunitario.getText();
				}
				if (chckbxComunitario.isSelected()) {
					modalidades = chckbxComunitario.getText();
				}
				if (chckbxLaboral.isSelected()) {
					modalidades = chckbxLaboral.getText();
				}
				if (chckbxCibernetica.isSelected()) {
					modalidades = chckbxCibernetica.getText();
				}

				// Hechos y motivos
				String hechosYMotivos = "";


				// Descripcion de los hechos
				String DescripcionDeLosHechos = "";

				if (!textArea.getText().isEmpty()) {
					DescripcionDeLosHechos += textArea.getText();
				}

				insertar(tiposDeViolencia, modalidades, hechosYMotivos, DescripcionDeLosHechos);
			}
		});
		btnSiguiente.setBackground(new Color(224, 167, 167));
		btnSiguiente.setBounds(685, 445, 108, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegresar.setBackground(new Color(224, 167, 167));
		btnRegresar.setForeground(new Color(0, 0, 0));
		btnRegresar.setBounds(10, 445, 108, 23);
		contentPane.add(btnRegresar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBounds(0, 486, 829, 57);
		contentPane.add(panel_3);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setBackground(new Color(224, 167, 167));
		btnInicio.setBounds(350, 445, 108, 23);
		contentPane.add(btnInicio);
	}
}


