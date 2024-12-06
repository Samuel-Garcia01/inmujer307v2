package SEGUROVIOLETA;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import ConexionBaseDeDatos.ConexionInmujer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RedesDeApoyo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTiposDeApoyo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private ConexionInmujer conexion;
	private Connection con;
	private JTextField txtviabilidad;
	private JTextField txtTiposdeRelacion;

	public void BusquedaDeDatos() {
		String sql = "SELECT * FROM datos WHERE EXP = '" + DatosGenerales.exp + "'";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String sqlRedes = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Redes_de_apoyo,'\n',1),'Tipo de relacion: ','')) AS tipo_de_relacion, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',2),'\n',-1),'Tipos de apoyo: ','')) AS tipos_de_apoyo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',3),'\n',-1),'Nombre: ','')) AS nombre, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',4),'\n',-1),'Dirección: ','')) AS direccion, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',5),'\n',-1),'Telefono: ','')) AS telefono FROM datos WHERE EXP = '"
						+ DatosGenerales.exp + "'";
				PreparedStatement pstRedes = con.prepareStatement(sqlRedes);
				ResultSet rsRedes = pstRedes.executeQuery();
				if (rsRedes.next()) {
					txtTiposdeRelacion.setText(rsRedes.getString("tipo_de_relacion"));
					txtTiposDeApoyo.setText(rsRedes.getString("tipos_de_apoyo"));
					txtNombre.setText(rsRedes.getString("nombre"));
					txtTelefono.setText(rsRedes.getString("telefono"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			int exp = 1;
			RedesDeApoyo frame = new RedesDeApoyo();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RedesDeApoyo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 809, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel_5.setBounds(224, 0, 50, 57);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/butterfly_side_espejo.png")));
		lblNewLabel_6.setBounds(506, 0, 50, 57);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Redes de Apoyo");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setBounds(316, 10, 161, 37);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/encabezadodatos.png")));
		lblNewLabel_8.setBounds(0, 0, 809, 57);
		panel.add(lblNewLabel_8);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(431, 77, 331, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 92, 69, 13);
		panel_1.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(105, 89, 155, 19);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelefono.setBounds(10, 167, 69, 13);
		panel_1.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 164, 155, 19);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(54, 77, 331, 364);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblTiposDeApoyo = new JLabel("Tipos de Apoyo:");
		lblTiposDeApoyo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTiposDeApoyo.setBounds(10, 25, 105, 13);
		panel_1_1.add(lblTiposDeApoyo);

		txtTiposDeApoyo = new JTextField();
		txtTiposDeApoyo.setBounds(125, 21, 196, 19);
		panel_1_1.add(txtTiposDeApoyo);
		txtTiposDeApoyo.setColumns(10);

		JLabel lblViabilidad = new JLabel("Viabilidad de la red de apoyo");
		lblViabilidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblViabilidad.setBounds(10, 109, 172, 14);
		panel_1_1.add(lblViabilidad);

		txtviabilidad = new JTextField();
		txtviabilidad.setBounds(214, 106, 86, 20);
		panel_1_1.add(txtviabilidad);
		txtviabilidad.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tipo de Relacion");
		lblNewLabel.setBounds(10, 62, 86, 19);
		panel_1_1.add(lblNewLabel);

		txtTiposdeRelacion = new JTextField();
		txtTiposdeRelacion.setBounds(121, 61, 86, 20);
		panel_1_1.add(txtTiposdeRelacion);
		txtTiposdeRelacion.setColumns(10);

		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoDeRelacion = txtTiposdeRelacion.getText();
				String tiposDeApoyo = txtTiposDeApoyo.getText();
				String nombre = txtNombre.getText();
				String telefono = txtTelefono.getText();

				String RedesDeApoyo = "";
				if (!tipoDeRelacion.isEmpty()) {
					RedesDeApoyo += "Tipo de relacion: " + tipoDeRelacion + "\n";
				} else {
					RedesDeApoyo += "Tipo de relacion: \n";
				}
				if (!tiposDeApoyo.isEmpty()) {
					RedesDeApoyo += "Tipos de apoyo: " + tiposDeApoyo + "\n";
				} else {
					RedesDeApoyo += "Tipos de apoyo: \n";
				}
				if (!nombre.isEmpty()) {
					RedesDeApoyo += "Nombre: " + nombre + "\n";
				} else {
					RedesDeApoyo += "Nombre: \n";
				}

				if (!telefono.isEmpty()) {
					RedesDeApoyo += "Telefono: " + telefono + "\n";
				} else {
					RedesDeApoyo += "Telefono: \n";
				}

				try {
					ConexionInmujer conexion = new ConexionInmujer();
					Connection con = conexion.conectar();

					String sql = "UPDATE seguro_violeta SET Redes_Apoyo = '" + RedesDeApoyo + "' WHERE id = '"+ DatosGenerales.id + "'";

					PreparedStatement pst = con.prepareStatement(sql);
					int rs = pst.executeUpdate();

					if (rs == 1) {
						System.out.println("¡Datos insertados correctamente!");
						SituacionEconomica ventana = new SituacionEconomica();
						ventana.setVisible(true);
						ventana.setLocationRelativeTo(null);
						dispose();
					}

				} catch (SQLException ex) {
					ex.printStackTrace();

				}
			}
		});
		btnSiguiente.setBackground(new Color(224, 167, 167));
		btnSiguiente.setForeground(new Color(0, 0, 0));
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 12));
		btnSiguiente.setBounds(341, 470, 142, 34);
		contentPane.add(btnSiguiente);

		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(224, 167, 167));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(54, 469, 131, 34);
		contentPane.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(0, 556, 809, 57);
		contentPane.add(panel_2);

		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBackground(new Color(224, 167, 167));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(631, 471, 131, 29);
		contentPane.add(btnNewButton_1);
	}

}
