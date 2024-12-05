package SEGUROVIOLETA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.MenuInmujer;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DATOSDELAGRESOR extends JFrame {
	
	
	 private JPanel contentPane;
	    private JTextField txtNombre;
	    private JTextField txtRelacion;
	    private JTextField txtDomicilio;
	    private JTextField txtOcupacion;
	    

	    
	    public void cargarDatos(ResultSet rs) {
	        try {
	            // Obtener los datos del resultado de la consulta y cargarlos en los campos
	            String nombre = rs.getString("Nombre_de_la_victima");
	            String relacion = rs.getString("Relacion_o_Vinculo");
	            String domicilio = rs.getString("Domicilio_completo");
	            String ocupacion = rs.getString("Ocupacion_del_Agresor");
	            String edad = rs.getString("Edad");
	            
	            txtNombre.setText(nombre);
	            txtRelacion.setText(relacion);
	            txtDomicilio.setText(domicilio);
	            txtOcupacion.setText(ocupacion);
	            comboEdad.setSelectedItem(edad);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }	

	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	JComboBox comboEdad = new JComboBox();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DATOSDELAGRESOR frame = new DATOSDELAGRESOR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void InsertarEnBase(String DatosdelAgresor, String RelacionoVinculo, String Domicilio,String Ocupacion) {

		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();

		String sql = "UPDATE datos SET Datos_del_Agresor = '"+DatosdelAgresor+"', Relacion_o_Vinculo = '"+RelacionoVinculo+"', Domicilio_completo = '"+Domicilio+"', Ocupacion_del_Agresor = '"+Ocupacion+"' WHERE EXP = '"+DatosGenerales.exp+"'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			int valor = pst.executeUpdate();
			if (valor == 1) {
				System.out.println("Insertado correctamente");
				Efectosfisicos ventana = new Efectosfisicos();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			} else {
				System.out.println("No insertado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public DATOSDELAGRESOR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 807, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DATOS DEL AGRESOR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(304, 19, 182, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel_1.setBounds(241, 3, 51, 50);
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/butterfly_side_espejo.png")));
		label.setBounds(509, 3, 51, 50);
		panel.add(label);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(DATOSDELAGRESOR.class.getResource("/img/encabezadodatos.png")));
		lblNewLabel_2.setBounds(0, 0, 807, 57);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(12, 94, 787, 166);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("NOMBRE COMPLETO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(36, 51, 154, 14);
		panel_1.add(lblNewLabel_4);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 49, 230, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("EDAD");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(480, 75, 79, 14);
		panel_1.add(lblNewLabel_5);
		comboEdad.setFont(new Font("Arial", Font.BOLD, 11));

		comboEdad.setModel(new DefaultComboBoxModel(new String[] { "seleccione una opcion", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
				"41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
				"58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74",
				"75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91",
				"92", "93", "94", "95", "96", "97", "98", "99", "" }));
		comboEdad.setForeground(Color.BLACK);
		comboEdad.setBounds(569, 71, 188, 22);
		panel_1.add(comboEdad);
		
				JLabel lblNewLabel_10 = new JLabel("RELACION O VINCULO");
				lblNewLabel_10.setBounds(36, 127, 158, 14);
				panel_1.add(lblNewLabel_10);
				lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
				
						txtRelacion = new JTextField();
						txtRelacion.setBounds(200, 125, 230, 20);
						panel_1.add(txtRelacion);
						txtRelacion.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(18, 335, 789, 140);
		contentPane.add(panel_1_1);
		
				JLabel lblNewLabel_11 = new JLabel("DOMICILIO COMPLETO :\r\n");
				lblNewLabel_11.setBounds(38, 52, 158, 26);
				panel_1_1.add(lblNewLabel_11);
				lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 12));
						
								txtDomicilio = new JTextField();
								txtDomicilio.setBounds(194, 56, 158, 20);
								panel_1_1.add(txtDomicilio);
								txtDomicilio.setColumns(10);
								
										JLabel lblNewLabel_15 = new JLabel("OCUPACION");
										lblNewLabel_15.setBounds(408, 58, 131, 14);
										panel_1_1.add(lblNewLabel_15);
										lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
										
												txtOcupacion = new JTextField();
												txtOcupacion.setBounds(572, 56, 158, 20);
												panel_1_1.add(txtOcupacion);
												txtOcupacion.setColumns(10);

		JButton btnInicio = new JButton("INICIO");
		btnInicio.setFont(new Font("Arial", Font.BOLD, 10));
		btnInicio.setForeground(new Color(0, 0, 0));
		btnInicio.setBackground(new Color(224, 167, 167));
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
		btnInicio.setBounds(336, 518, 128, 23);
		contentPane.add(btnInicio);
		
				JButton btnSIGUIENTE = new JButton("SIGUIENTE");
				btnSIGUIENTE.setForeground(new Color(0, 0, 0));
				btnSIGUIENTE.setBackground(new Color(224, 167, 167));
				btnSIGUIENTE.setBounds(671, 518, 128, 23);
				contentPane.add(btnSIGUIENTE);
				
				JButton btnNewButton = new JButton("REGRESAR");
				btnNewButton.setForeground(new Color(0, 0, 0));
				btnNewButton.setBackground(new Color(224, 167, 167));
				btnNewButton.setBounds(8, 518, 111, 23);
				contentPane.add(btnNewButton);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(128, 0, 128));
				panel_2.setBounds(0, 551, 809, 62);
				contentPane.add(panel_2);
				btnSIGUIENTE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String edad = comboEdad.getSelectedItem().toString();
						String RelacionoVinculo = txtRelacion.getText();
						String Domicilio = txtDomicilio.getText();
						String Ocupacion = txtOcupacion.getText();
						
					}
				});
	}
}