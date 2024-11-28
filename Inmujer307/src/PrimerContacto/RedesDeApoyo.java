package PrimerContacto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.*;
import MenuInmujer.MenuInmujer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RedesDeApoyo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipoDeRealacion;
	private JTextField txtTiposDeApoyo;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	ConexionInmujer conexion = new ConexionInmujer();
	Connection con = conexion.conectar();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedesDeApoyo frame = new RedesDeApoyo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDireccion.requestFocus();
			}
		});
		txtNombre.setBounds(89, 53, 155, 19);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 56, 69, 13);
		panel_1.add(lblNewLabel_2);

		txtDireccion = new JTextField();
		txtDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTelefono.requestFocus();
			}
		});
		txtDireccion.setBounds(89, 140, 155, 19);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Dirección:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 143, 69, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Teléfono:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 221, 69, 13);
		panel_1.add(lblNewLabel_4);

		txtTelefono = new JTextField();
		txtTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtTelefono.setBounds(89, 218, 155, 19);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(54, 77, 331, 364);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tipo de Relación:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 117, 105, 13);
		panel_1_1.add(lblNewLabel);

		txtTipoDeRealacion = new JTextField();
		txtTipoDeRealacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtTiposDeApoyo.requestFocus();

			}
		});
		txtTipoDeRealacion.setBounds(125, 114, 196, 19);
		panel_1_1.add(txtTipoDeRealacion);
		txtTipoDeRealacion.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tipos de Apoyo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 186, 105, 13);
		panel_1_1.add(lblNewLabel_1);

		txtTiposDeApoyo = new JTextField();
		txtTiposDeApoyo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtNombre.requestFocus();

			}
		});
		txtTiposDeApoyo.setBounds(125, 183, 196, 19);
		panel_1_1.add(txtTiposDeApoyo);
		txtTiposDeApoyo.setColumns(10);

		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBackground(new Color(222, 158, 158));
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 12));
		btnSiguiente.setBounds(533, 510, 142, 34);
		contentPane.add(btnSiguiente);

		JButton btnInicio = new JButton("INICIO");
		btnInicio.setBackground(new Color(222, 158, 158));
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
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
		btnInicio.setBounds(162, 510, 135, 34);
		contentPane.add(btnInicio);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.setBackground(new Color(222, 158, 158));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(362, 510, 112, 34);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(133, 20, 121));
		panel_2.setBounds(0, 566, 809, 47);
		contentPane.add(panel_2);

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipoDeRelacion = txtTipoDeRealacion.getText();
				String tiposDeApoyo = txtTiposDeApoyo.getText();
				String nombre = txtNombre.getText();
				String direccion = txtDireccion.getText();
				String telefono = txtTelefono.getText();

				String RedesDeApoyo = "";
				if (!tipoDeRelacion.isEmpty()) {
					RedesDeApoyo += "Tipo de relacion: "+tipoDeRelacion+"\n";
				} else {
					RedesDeApoyo += "Tipo de relacion: No dada";
				}
				if (!tiposDeApoyo.isEmpty()) {
					RedesDeApoyo += "Tipos de apoyo: "+tiposDeApoyo+"\n";
				} else {
					RedesDeApoyo += "Tipos de apoyo: No dado";
				}
				if (!nombre.isEmpty()) {
					RedesDeApoyo += "Nombre: "+nombre+"\n";
				} else {
					RedesDeApoyo += "Nombre: No dado";
				}
				if (!direccion.isEmpty()) {
					RedesDeApoyo += "Dirección: "+direccion+"\n";
				} else {
					RedesDeApoyo += "Dirección: No dado";
				}
				if (!telefono.isEmpty()) {
					RedesDeApoyo += "Telefono: "+telefono+"\n";
				} else {
					RedesDeApoyo += "Telefono: No dado";
				}

				try (Connection conn = conexion.conectar()) {
					ConexionInmujer conexion = new ConexionInmujer();
					Connection con = conexion.conectar();
					if (conn != null) {

						String sql = "UPDATE datos SET Redes_de_apoyo = ? WHERE EXP = ?";

						try (PreparedStatement pst = conn.prepareStatement(sql)) {
							pst.setString(1, RedesDeApoyo);
							pst.setInt(2, DatosGenerales.exp);
							
							int rs = pst.executeUpdate();

							if (rs == 1) {
								System.out.println("¡Datos insertados correctamente!");
							}
						}
					}
				} catch (SQLException ex) {
					ex.printStackTrace();

				}
				InformacionComplementaria ventana = new InformacionComplementaria();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
	}
}