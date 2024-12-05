package SEGUROVIOLETA;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;

	public class SituacionEconomica extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField txtsolicitante;
		private JTextField txtRedDeApoyo;
		private JTextField txtAlimentacion;
		private JTextField txtGas;
		private JTextField txtRenta;

		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		private JTextField txtagua;
		private JTextField txtserviciomedico;
		private JTextField txtgastos;
		private JTextField txtluz;
		private JTextField txtTelefono;
		private JTextField txtegresos;
		private JTextField txtIngresosmensuales;

		public void Regresar() {
			String sql = "SELECT * FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					String sqlRedes = "SELECT TRIM(REPLACE(SUBSTRING_INDEX(Redes_de_apoyo,'\n',1),'Tipo de relacion: ','')) AS tipo_de_relacion, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',2),'\n',-1),'Tipos de apoyo: ','')) AS tipos_de_apoyo, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',3),'\n',-1),'Nombre: ','')) AS nombre, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',4),'\n',-1),'Dirección: ','')) AS direccion, TRIM(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(Redes_de_apoyo,'\n',5),'\n',-1),'Telefono: ','')) AS telefono FROM datos WHERE EXP = '"+DatosGenerales.exp+"'";
					PreparedStatement pstRedes = con.prepareStatement(sqlRedes);
					ResultSet rsRedes = pstRedes.executeQuery();
					if (rsRedes.next()) {
						txtsolicitante.setText(rsRedes.getString("tipo_de_relacion"));
						txtRedDeApoyo.setText(rsRedes.getString("tipos_de_apoyo"));
						txtAlimentacion.setText(rsRedes.getString("nombre"));
						txtGas.setText(rsRedes.getString("direccion"));
						txtRenta.setText(rsRedes.getString("telefono"));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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

		public SituacionEconomica() {
			
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

			JLabel lblNewLabel_7 = new JLabel("SITUACIÓN ECONÓMICA ");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
			lblNewLabel_7.setBounds(271, 11, 253, 37);
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

			txtAlimentacion = new JTextField();
			txtAlimentacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtGas.requestFocus();
				}
			});
			txtAlimentacion.setBounds(147, 52, 155, 19);
			panel_1.add(txtAlimentacion);
			txtAlimentacion.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("ALIMENTACION");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_2.setBounds(10, 56, 127, 13);
			panel_1.add(lblNewLabel_2);

			txtGas = new JTextField();
			txtGas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtRenta.requestFocus();
				}
			});
			txtGas.setBounds(147, 87, 155, 19);
			panel_1.add(txtGas);
			txtGas.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("GAS");
			lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_3.setBounds(10, 91, 69, 13);
			panel_1.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("RENTA MENSUAL/PAGO VIVIENDA");
			lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_4.setBounds(10, 124, 127, 13);
			panel_1.add(lblNewLabel_4);

			txtRenta = new JTextField();
			txtRenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			txtRenta.setBounds(147, 117, 155, 19);
			panel_1.add(txtRenta);
			txtRenta.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("EGRESOS MENSUALES");
			lblNewLabel_10.setBounds(118, 11, 126, 13);
			panel_1.add(lblNewLabel_10);
			
			JLabel lblNewLabel_11 = new JLabel("AGUA");
			lblNewLabel_11.setBounds(10, 155, 46, 14);
			panel_1.add(lblNewLabel_11);
			
			JLabel lblNewLabel_12 = new JLabel("SERVICIO MEDICO");
			lblNewLabel_12.setBounds(10, 195, 127, 14);
			panel_1.add(lblNewLabel_12);
			
			JLabel lblNewLabel_13 = new JLabel("GASTOS ESCOLARES");
			lblNewLabel_13.setBounds(10, 233, 127, 14);
			panel_1.add(lblNewLabel_13);
			
			JLabel lblNewLabel_14 = new JLabel("LUZ");
			lblNewLabel_14.setBounds(10, 266, 127, 14);
			panel_1.add(lblNewLabel_14);
			
			JLabel lblNewLabel_15 = new JLabel("TELEFONO Y/O INTERNET");
			lblNewLabel_15.setBounds(10, 304, 127, 14);
			panel_1.add(lblNewLabel_15);
			
			JLabel lblNewLabel_16 = new JLabel("TOTAL:");
			lblNewLabel_16.setBounds(10, 329, 127, 14);
			panel_1.add(lblNewLabel_16);
			
			txtagua = new JTextField();
			txtagua.setBounds(147, 147, 155, 20);
			panel_1.add(txtagua);
			txtagua.setColumns(10);
			
			txtserviciomedico = new JTextField();
			txtserviciomedico.setBounds(147, 192, 155, 20);
			panel_1.add(txtserviciomedico);
			txtserviciomedico.setColumns(10);
			
			txtgastos = new JTextField();
			txtgastos.setBounds(147, 230, 155, 20);
			panel_1.add(txtgastos);
			txtgastos.setColumns(10);
			
			txtluz = new JTextField();
			txtluz.setBounds(147, 263, 155, 20);
			panel_1.add(txtluz);
			txtluz.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(147, 301, 155, 20);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			txtegresos = new JTextField();
			txtegresos.setBounds(147, 326, 155, 20);
			panel_1.add(txtegresos);
			txtegresos.setColumns(10);

			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
			panel_1_1.setBackground(new Color(243, 220, 220));
			panel_1_1.setBounds(54, 77, 331, 364);
			contentPane.add(panel_1_1);
			panel_1_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("SOLICITANTE");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 117, 105, 13);
			panel_1_1.add(lblNewLabel);

			txtsolicitante = new JTextField();
			txtsolicitante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtRedDeApoyo.requestFocus();

				}
			});
			txtsolicitante.setBounds(125, 114, 196, 19);
			panel_1_1.add(txtsolicitante);
			txtsolicitante.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("RED DE APOYO");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_1.setBounds(10, 186, 105, 13);
			panel_1_1.add(lblNewLabel_1);

			txtRedDeApoyo = new JTextField();
			txtRedDeApoyo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtAlimentacion.requestFocus();

				}
			});
			txtRedDeApoyo.setBounds(125, 183, 196, 19);
			panel_1_1.add(txtRedDeApoyo);
			txtRedDeApoyo.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("INGRESOS MENSUALES ");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setBounds(91, 21, 144, 29);
			panel_1_1.add(lblNewLabel_9);
			
			JLabel lblNewLabel_17 = new JLabel("TOTAL:");
			lblNewLabel_17.setBounds(10, 286, 46, 14);
			panel_1_1.add(lblNewLabel_17);
			
			txtIngresosmensuales = new JTextField();
			txtIngresosmensuales.setBounds(125, 283, 196, 20);
			panel_1_1.add(txtIngresosmensuales);
			txtIngresosmensuales.setColumns(10);

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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Efectosfisicos ventana = new Efectosfisicos();
					ventana.setVisible(true);
					ventana.setLocationRelativeTo(null);
					//ventana.Regresar();
					dispose();
				}
			});
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

					String tipoDeRelacion = txtsolicitante.getText();
					String tiposDeApoyo = txtRedDeApoyo.getText();
					String nombre = txtAlimentacion.getText();
					String direccion = txtGas.getText();
					String telefono = txtRenta.getText();

					String RedesDeApoyo = "";
					if (!tipoDeRelacion.isEmpty()) {
						RedesDeApoyo += "Tipo de relacion: "+tipoDeRelacion+"\n";
					} else {
						RedesDeApoyo += "Tipo de relacion: \n";
					}
					if (!tiposDeApoyo.isEmpty()) {
						RedesDeApoyo += "Tipos de apoyo: "+tiposDeApoyo+"\n";
					} else {
						RedesDeApoyo += "Tipos de apoyo: \n";
					}
					if (!nombre.isEmpty()) {
						RedesDeApoyo += "Nombre: "+nombre+"\n";
					} else {
						RedesDeApoyo += "Nombre: \n";
					}
					if (!direccion.isEmpty()) {
						RedesDeApoyo += "Dirección: "+direccion+"\n";
					} else {
						RedesDeApoyo += "Dirección: \n";
					}
					if (!telefono.isEmpty()) {
						RedesDeApoyo += "Telefono: "+telefono+"\n";
					} else {
						RedesDeApoyo += "Telefono: \n";
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
				}
			});
		}
	}