package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import ConexionBaseDeDatos.ConexionInmujer;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InformacionComplementaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionComplementaria frame = new InformacionComplementaria();
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
	public InformacionComplementaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 231, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(797, 0, -800, 611);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Información Complementaria");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(275, 11, 260, 33);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 128, 128), new Color(255, 128, 128)));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(158, 96, 470, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Observaciones generales y/o Canalización");
		lblNewLabel_2.setBounds(115, 7, 240, 14);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblNewLabel_2);
		
		JTextArea textObservaciones = new JTextArea();
		textObservaciones.setBackground(new Color(243, 220, 220));
		textObservaciones.setBounds(24, 27, 422, 115);
		panel_1.add(textObservaciones);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 128, 128), new Color(255, 128, 128)));
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(158, 312, 470, 165);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JCheckBox checAutorizo = new JCheckBox("Autorizo");
		buttonGroup.add(checAutorizo);
		checAutorizo.setFont(new Font("Arial", Font.PLAIN, 11));
		checAutorizo.setBackground(new Color(243, 220, 220));
		checAutorizo.setBounds(89, 69, 97, 23);
		panel_1_1.add(checAutorizo);
		
		JLabel lblNewLabel_3 = new JLabel("Autorización");
		lblNewLabel_3.setBounds(200, 11, 71, 14);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_3);
		
		JCheckBox checNoAutorizo = new JCheckBox("No autorizo");
		buttonGroup.add(checNoAutorizo);
		checNoAutorizo.setFont(new Font("Arial", Font.PLAIN, 11));
		checNoAutorizo.setBackground(new Color(243, 220, 220));
		checNoAutorizo.setBounds(281, 69, 97, 23);
		panel_1_1.add(checNoAutorizo);
		
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
					
					String sql = "DELETE FROM datos WHERE Nombre = '"+DatosGenerales.exp+"'";
					
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						int valor = pst.executeUpdate();
						if (valor==1) {
							System.out.println("Éxito en eliminar expediente");
						}
					} catch (Exception e1) {
						// TODO: handle exception
					}
				} else if (opcion == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(new Color(128, 0, 255));
		btnInicio.setFont(new Font("Arial", Font.PLAIN, 11));
		btnInicio.setBounds(255, 529, 108, 23);
		contentPane.add(btnInicio);
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Obser = textObservaciones.getText();
				String Auto = checNoAutorizo.getText();
				
				ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				
				String sql = "UPDATE datos SET Observaciones_generales_y_o_Canalizacion = ? , Autorizacion = ? WHERE EXP = ?";
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, Obser);
					pst.setString(2, Auto);
					pst.setInt(1, DatosGenerales.exp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				String autorizacion;

				

				if (!checAutorizo.isSelected() && !checNoAutorizo.isSelected()) {
				    JOptionPane.showMessageDialog(null,
				        "Debe seleccionar una opción",
				        "Error",
				        JOptionPane.ERROR_MESSAGE);
				    return; // Detiene la ejecución si no se ha seleccionado ninguna opción
				}
				// Mensaje de despedida y cierre del programa
				JOptionPane.showMessageDialog(null,
				    "Gracias por usar nuestro programa."
				    + "\nSi tiene algún otro inconveniente, "
				    + "\nno dude en consultar esta página.",
				    "Hasta luego",
				    JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		btnFinalizar.setForeground(new Color(255, 255, 255));
		btnFinalizar.setBackground(new Color(128, 0, 255));
		btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFinalizar.setBounds(456, 529, 108, 23);
		contentPane.add(btnFinalizar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(InformacionComplementaria.class.getResource("/IMG/butterfly_side_view_56.png")));
		lblNewLabel_4.setBounds(224, -14, 61, 69);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(InformacionComplementaria.class.getResource("/IMG/butterfly_side_espejo.png")));
		lblNewLabel_5.setBounds(525, -14, 102, 69);
		contentPane.add(lblNewLabel_5);
		lblNewLabel.setBounds(0, 0, 807, 57);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(InformacionComplementaria.class.getResource("/IMG/encabezado.gif")));
	}
}