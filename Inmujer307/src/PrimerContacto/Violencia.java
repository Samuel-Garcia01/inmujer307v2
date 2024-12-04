package PrimerContacto;

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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;

public class Violencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	
	//Tipos de violencia
	JCheckBox chckbxViolenciaFisica = new JCheckBox("Violencia Física");
	JCheckBox chckbxViolenciaPsicologica = new JCheckBox("Violencia Psicológica");
	JCheckBox chckbxViolenciaSexual = new JCheckBox("Volencia Sexual");
	JCheckBox chckbxViolenciaEconomica = new JCheckBox("Violencia Económica");
	JCheckBox chckbxViolenciaPatrimonial = new JCheckBox("Violencia Patrimonial");
	JCheckBox chckbxViolenciaAcosoHostigamiento = new JCheckBox("Acoso/Hostigamiento");
	JCheckBox chckbxViolenciaVicaria = new JCheckBox("Violencia Vicaria");
	
	//Modalidades de violencia
	JCheckBox chckbxFamilia = new JCheckBox("Familia");
	JCheckBox chckbxDocente = new JCheckBox("Docente");
	JCheckBox chckbxInstitucional = new JCheckBox("Institucional");
	JCheckBox chckbxNoviazgo = new JCheckBox("Noviazgo");
	JCheckBox chckbxComunitario = new JCheckBox("Comunitaria");
	JCheckBox chckbxLaboral = new JCheckBox("Laboral");
	JCheckBox chckbxCibernetica = new JCheckBox("Cibernética");
	
	//Hechos y motivos de la atencion
	JTextField txtLugar = new JTextField();
	JTextField txtFecha = new JTextField();
	JComboBox comboHora = new JComboBox();
	JTextArea txtDescripcion = new JTextArea();
	
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
	
	public void Regresar() {
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
					if (chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("primer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("segundo_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("tercer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("cuarto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("quinto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("sexto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsTipos.getString("septimo_tipo"))) {
						chckbxViolenciaAcosoHostigamiento.setSelected(true);
					} 
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
					if (chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("primer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("segundo_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("tercer_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("cuarto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("quinto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("sexto_tipo"))||chckbxViolenciaAcosoHostigamiento.getText().equalsIgnoreCase(rsModalidades.getString("septimo_tipo"))) {
						chckbxViolenciaAcosoHostigamiento.setSelected(true);
					} 
				}
				
				String sqlHc = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 1), 'Lugar: ', -1), 'Lugar: ', '')) AS lugar_hechos, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 2), 'Fecha: ', -1), 'Fecha: ', '')) AS fecha_hechos, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Hechos_y_motivos_de_la_atencion, '\\n', 3), 'Hora: ', -1), 'Hora:', '')) AS hora_hechos FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
				PreparedStatement pstHc = con.prepareStatement(sqlHc);
				ResultSet rsHc = pstHc.executeQuery();
				if (rsHc.next()) {
					txtLugar.setText(rsHc.getString("lugar_hechos"));
					txtFecha.setText(rsHc.getString("fecha_hechos"));
					comboHora.setSelectedItem(rsHc.getString("hora_hechos"));
				}
				txtDescripcion.setText(rs.getString("Descripcion"));
			} else {
				System.out.println("No se encontraron registros");
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
		setBounds(100, 100, 823, 650);
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
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_7.setBounds(311, 10, 173, 37);
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

		
		chckbxViolenciaFisica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaFisica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaFisica.setBounds(20, 42, 149, 21);
		panel_1.add(chckbxViolenciaFisica);

		JLabel lblNewLabel = new JLabel("Tipos de Violencia");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(138, 10, 113, 13);
		panel_1.add(lblNewLabel);

		
		chckbxViolenciaPsicologica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPsicologica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPsicologica.setBounds(198, 93, 149, 21);
		panel_1.add(chckbxViolenciaPsicologica);

		
		chckbxViolenciaSexual.setBackground(new Color(243, 220, 220));
		chckbxViolenciaSexual.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaSexual.setBounds(20, 93, 149, 21);
		panel_1.add(chckbxViolenciaSexual);

		
		chckbxViolenciaEconomica.setBackground(new Color(243, 220, 220));
		chckbxViolenciaEconomica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaEconomica.setBounds(198, 139, 149, 21);
		panel_1.add(chckbxViolenciaEconomica);

		
		chckbxViolenciaPatrimonial.setBackground(new Color(243, 220, 220));
		chckbxViolenciaPatrimonial.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaPatrimonial.setBounds(20, 139, 149, 21);
		panel_1.add(chckbxViolenciaPatrimonial);

		
		chckbxViolenciaAcosoHostigamiento.setBackground(new Color(243, 220, 220));
		chckbxViolenciaAcosoHostigamiento.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxViolenciaAcosoHostigamiento.setBounds(102, 188, 174, 21);
		panel_1.add(chckbxViolenciaAcosoHostigamiento);

		
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

		
		chckbxFamilia.setBackground(new Color(243, 220, 220));
		chckbxFamilia.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxFamilia.setBounds(48, 42, 108, 21);
		panel_2.add(chckbxFamilia);

		
		chckbxDocente.setBackground(new Color(243, 220, 220));
		chckbxDocente.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxDocente.setBounds(48, 91, 108, 21);
		panel_2.add(chckbxDocente);

		
		chckbxInstitucional.setBackground(new Color(243, 220, 220));
		chckbxInstitucional.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxInstitucional.setBounds(48, 135, 108, 21);
		panel_2.add(chckbxInstitucional);

		
		chckbxNoviazgo.setBackground(new Color(243, 220, 220));
		chckbxNoviazgo.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNoviazgo.setBounds(224, 42, 93, 21);
		panel_2.add(chckbxNoviazgo);

		
		chckbxComunitario.setBackground(new Color(243, 220, 220));
		chckbxComunitario.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxComunitario.setBounds(224, 91, 113, 21);
		panel_2.add(chckbxComunitario);

		
		chckbxLaboral.setBackground(new Color(243, 220, 220));
		chckbxLaboral.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxLaboral.setBounds(224, 135, 93, 21);
		panel_2.add(chckbxLaboral);

		
		chckbxCibernetica.setBackground(new Color(243, 220, 220));
		chckbxCibernetica.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxCibernetica.setBounds(145, 187, 93, 21);
		panel_2.add(chckbxCibernetica);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_3.setBackground(new Color(243, 220, 220));
		panel_3.setBounds(10, 319, 789, 112);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Hechos y Motivos de la Atención");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(306, 10, 192, 13);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Lugar de los Hechos:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 56, 132, 13);
		panel_3.add(lblNewLabel_3);

		
		txtLugar.setBounds(139, 52, 145, 19);
		panel_3.add(txtLugar);
		txtLugar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Fecha de la Agresión:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(295, 56, 132, 13);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_9 = new JLabel("Hora de la Agresión:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(570, 56, 132, 13);
		panel_3.add(lblNewLabel_9);

		
		txtFecha.setColumns(10);
		txtFecha.setBounds(422, 53, 138, 19);
		panel_3.add(txtFecha);

		
		comboHora.setBounds(694, 54, 85, 17);
		panel_3.add(comboHora);

		comboHora.addItem("Seleccione una opcion");
		String hora = "";
		String minutos = "";
		String h = "";
		String m = "";

		for (int i = 0; i <= 23; i++) {
			for (int j = 0; j <= 59; j++) {
				h = String.valueOf(i);
				m = String.valueOf(j);
				if (h.length() == 1) {
					hora = "0" + h;
				} else {
					hora = h;
				}

				if (m.length() == 1) {
					minutos = "0" + m;
				} else {
					minutos = m;
				}
				comboHora.addItem(hora + ":" + minutos);
			}

		}

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 441, 789, 112);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		
		txtDescripcion.setBackground(new Color(243, 220, 220));
		txtDescripcion.setBounds(10, 31, 769, 70);
		panel_4.add(txtDescripcion);

		JLabel lblNewLabel_10 = new JLabel("Descripción de los Hechos:");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(10, 9, 165, 13);
		panel_4.add(lblNewLabel_10);

		JButton btnGuardar = new JButton("SIGUIENTE");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionInmujer conMujer = new ConexionInmujer();

				String tiposDeViolencia = "";

				if (chckbxViolenciaFisica.isSelected()) {
					tiposDeViolencia += chckbxViolenciaFisica.getText()+", ";
				}
				if (chckbxViolenciaSexual.isSelected()) {
					tiposDeViolencia += chckbxViolenciaSexual.getText()+", ";
				}
				if (chckbxViolenciaPatrimonial.isSelected()) {
					tiposDeViolencia += chckbxViolenciaPatrimonial.getText()+", ";
				}
				if (chckbxViolenciaVicaria.isSelected()) {
					tiposDeViolencia += chckbxViolenciaVicaria.getText()+", ";
				}
				if (chckbxViolenciaPsicologica.isSelected()) {
					tiposDeViolencia += chckbxViolenciaPsicologica.getText()+", ";
				}
				if (chckbxViolenciaEconomica.isSelected()) {
					tiposDeViolencia += chckbxViolenciaEconomica.getText()+", ";
				}
				if (chckbxViolenciaAcosoHostigamiento.isSelected()) {
					tiposDeViolencia += chckbxViolenciaAcosoHostigamiento.getText()+", ";
				}

				String modalidades = "";

				if (chckbxFamilia.isSelected()) {
					modalidades += chckbxFamilia.getText()+", ";
				}
				if (chckbxDocente.isSelected()) {
					modalidades += chckbxDocente.getText()+", ";
				}
				if (chckbxInstitucional.isSelected()) {
					modalidades += chckbxInstitucional.getText()+", ";
				}
				if (chckbxNoviazgo.isSelected()) {
					modalidades += chckbxNoviazgo.getText()+", ";
				}
				if (chckbxComunitario.isSelected()) {
					modalidades += chckbxComunitario.getText()+", ";
				}
				if (chckbxComunitario.isSelected()) {
					modalidades += chckbxComunitario.getText()+", ";
				}
				if (chckbxLaboral.isSelected()) {
					modalidades += chckbxLaboral.getText()+", ";
				}
				if (chckbxCibernetica.isSelected()) {
					modalidades += chckbxCibernetica.getText()+", ";
				}

				// Hechos y motivos
				String hechosYMotivos = "";

				if (!txtLugar.getText().isEmpty()) {
					hechosYMotivos += "Lugar: " + txtFecha.getText() + "\n";
				} else {
					hechosYMotivos += "Lugar: No dado\n";
				}
				if (!txtFecha.getText().isEmpty()) {
					hechosYMotivos += "Fecha: " + txtFecha.getText() + "\n";
				} else {
					hechosYMotivos += "Fecha: No dado\n";
				}
				if (comboHora.getSelectedIndex() == 0) {
					hechosYMotivos += "Hora: No dada\n";
				} else {
					hechosYMotivos += "Hora: " + comboHora.getSelectedItem().toString() + "\n";
				}

				// Descripcion de los hechos
				String DescripcionDeLosHechos = "";

				if (!txtDescripcion.getText().isEmpty()) {
					DescripcionDeLosHechos += txtDescripcion.getText();
				}

				insertar(tiposDeViolencia, modalidades, hechosYMotivos, DescripcionDeLosHechos);
			}
		});
		btnGuardar.setBackground(new Color(222, 158, 158));
		btnGuardar.setBounds(518, 579, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosGenerales ventana = new DatosGenerales();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				ventana.Regresar();
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(222, 158, 158));
		btnNewButton.setBounds(256, 579, 96, 23);
		contentPane.add(btnNewButton);
	}
}
