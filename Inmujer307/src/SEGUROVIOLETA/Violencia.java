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
import PrimerContacto.DatosGenerales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class Violencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JCheckBox chckbxViolenciaPsicologica = new JCheckBox("Violencia Psicológica");
	JCheckBox chckbxViolenciaFisica = new JCheckBox("Violencia Física");
	JCheckBox chckbxViolenciaSexual = new JCheckBox("Volencia Sexual");
	JCheckBox chckbxViolenciaEconomica = new JCheckBox("Violencia Económica");
	JCheckBox chckbxViolenciaPatrimonial = new JCheckBox("Violencia Patrimonial");
	JCheckBox chckbxViolenciaVicaria = new JCheckBox("Violencia Vicaria");
	JCheckBox chckbxFamilia = new JCheckBox("Familia");
	JCheckBox chckbxLaboral = new JCheckBox("Laboral");
	JCheckBox chckbxDocente = new JCheckBox("Docente");
	JCheckBox chckbxInstitucional = new JCheckBox("Institucional");
	JCheckBox chckbxCibernetica = new JCheckBox("Cibernética");
	JCheckBox chckbxComunitario = new JCheckBox("Comunitaria");
	
	public void BuscarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT * FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String sqlTipos = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Tipos_de_Violencia,',',1),', ','')) AS primer_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',2),',',-1),', ','')) AS segundo_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',3),',',-1),', ','')) AS tercer_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',4),',',-1),', ','')) AS cuarto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',5),',',-1),', ','')) AS quinto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',6),',',-1),', ','')) AS sexto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',7),',',-1),', ','')) AS septimo_tipo FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstTipos = con.prepareStatement(sqlTipos);
				ResultSet rsTipos = pstTipos.executeQuery();
				if (rsTipos.next()) {
					if (chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaFisica.setSelected(true);
					}
					if (chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaPsicologica.setSelected(true);
					}
					if (chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaSexual.setSelected(true);
					}
					if (chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaVicaria.setSelected(true);
					}
					if (chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaPatrimonial.setSelected(true);
					}
					if (chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaEconomica.setSelected(true);
					}
					//if (chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
					//	chckbxViolenciaAcosoHostigamiento.setSelected(true);
					//} 
				}
				
				String sqlModalidades = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Tipos_de_Violencia,',',1),', ','')) AS primer_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',2),',',-1),', ','')) AS segundo_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',3),',',-1),', ','')) AS tercer_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',4),',',-1),', ','')) AS cuarto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',5),',',-1),', ','')) AS quinto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',6),',',-1),', ','')) AS sexto_tipo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Tipos_de_Violencia,',',7),',',-1),', ','')) AS septimo_tipo FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstModalidades = con.prepareStatement(sqlTipos);
				ResultSet rsModalidades = pstModalidades.executeQuery();
				if (rsModalidades.next()) {
					if (chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaFisica.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaFisica.setSelected(true);
					}
					if (chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaPsicologica.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaPsicologica.setSelected(true);
					}
					if (chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaSexual.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaSexual.setSelected(true);
					}
					if (chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaVicaria.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaVicaria.setSelected(true);
					}
					if (chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaPatrimonial.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaPatrimonial.setSelected(true);
					}
					if (chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaEconomica.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaEconomica.setSelected(true);
					}
					//if (chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						//chckbxViolenciaAcosoHostigamiento.setSelected(true);
				//	} 
				}
				
				String sqlHc = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 1), 'Lugar: ', -1), 'Lugar: ', '')) AS lugar_hechos, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 2), 'Fecha: ', -1), 'Fecha: ', '')) AS fecha_hechos, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 3), 'Hora: ', -1), 'Hora:', '')) AS hora_hechos FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstHc = con.prepareStatement(sqlHc);
				ResultSet rsHc = pstHc.executeQuery();
				if (rsHc.next()) {
				//	txtLugar.setText(rsHc.getString("lugar_hechos"));
					//txtFecha.setText(rsHc.getString("fecha_hechos"));
					//comboHora.setSelectedItem(rsHc.getString("hora_hechos"));
				}
				//txtDescripcion.setText(rs.getString("Descripcion"));
			} else {
				System.out.println("No se encontraron registros");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertar(String tv, String md, String hm, String des) {

		try {

		
			ConexionInmujer conexion = new ConexionInmujer();
			Connection con = conexion.conectar();

			String sql = "UPDATE seguro_violeta SET Tipos_de_Violencia = '', Modalidades_de_violencia = '', Descripcion_Hechos_UltimoEpisodio_Violencia = '', WHERE EXP = ?";
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

		
		chckbxViolenciaPsicologica.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaPsicologica);
		chckbxViolenciaPsicologica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPsicologica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPsicologica.setBounds(198, 93, 149, 21);
		panel_1.add(chckbxViolenciaPsicologica);

		
		chckbxViolenciaSexual.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaSexual);
		chckbxViolenciaSexual.setBackground(new Color(243, 220, 220));
		chckbxViolenciaSexual.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaSexual.setBounds(20, 93, 149, 21);
		panel_1.add(chckbxViolenciaSexual);

		
		chckbxViolenciaEconomica.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaEconomica);
		chckbxViolenciaEconomica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaEconomica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaEconomica.setBounds(198, 139, 149, 21);
		panel_1.add(chckbxViolenciaEconomica);

		
		chckbxViolenciaPatrimonial.setForeground(new Color(47, 79, 79));
		buttonGroup.add(chckbxViolenciaPatrimonial);
		chckbxViolenciaPatrimonial.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPatrimonial.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPatrimonial.setBounds(20, 139, 149, 21);
		panel_1.add(chckbxViolenciaPatrimonial);

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

		
		chckbxFamilia.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxFamilia);
		chckbxFamilia.setBackground(new Color(243, 220, 220));
		chckbxFamilia.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxFamilia.setBounds(48, 42, 108, 21);
		panel_2.add(chckbxFamilia);

		chckbxDocente.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxDocente);
		chckbxDocente.setBackground(new Color(243, 220, 220));
		chckbxDocente.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxDocente.setBounds(48, 91, 108, 21);
		panel_2.add(chckbxDocente);

		chckbxInstitucional.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxInstitucional);
		chckbxInstitucional.setBackground(new Color(243, 220, 220));
		chckbxInstitucional.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxInstitucional.setBounds(48, 135, 108, 21);
		panel_2.add(chckbxInstitucional);

		chckbxComunitario.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxComunitario);
		chckbxComunitario.setBackground(new Color(243, 220, 220));
		chckbxComunitario.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxComunitario.setBounds(224, 91, 113, 21);
		panel_2.add(chckbxComunitario);

		chckbxLaboral.setForeground(new Color(47, 79, 79));
		buttonGroup_1.add(chckbxLaboral);
		chckbxLaboral.setBackground(new Color(243, 220, 220));
		chckbxLaboral.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxLaboral.setBounds(224, 135, 93, 21);
		panel_2.add(chckbxLaboral);

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


