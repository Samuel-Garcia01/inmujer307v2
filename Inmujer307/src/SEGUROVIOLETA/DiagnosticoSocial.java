package SEGUROVIOLETA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.MenuInmujer;

public class DiagnosticoSocial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JTextArea ArreaDiagaosnistico = new JTextArea();

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosticoSocial social = new DiagnosticoSocial();
					social.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DiagnosticoSocial() {
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
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(22, 148, 787, 205);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
				ArreaDiagaosnistico.setBounds(10, 10, 769, 185);
				panel_4.add(ArreaDiagaosnistico);
		
				
				ArreaDiagaosnistico.setForeground(new Color(75, 0, 130));
				ArreaDiagaosnistico.setFont(new Font("Monospaced", Font.BOLD, 13));
				ArreaDiagaosnistico.setBackground(new Color(243, 220, 220));

		JButton btnSiguiente = new JButton("FINALIZAR");
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 12));
		btnSiguiente.setForeground(new Color(0, 0, 0));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diagnostico = ArreaDiagaosnistico.getText();
				ConexionInmujer conexion = new  ConexionInmujer();
				Connection con = conexion.conectar();
				String sql ="UPDATE seguro_violeta SET Diagnostico_Social = '"+diagnostico+"' WHERE id = '' ";
				try {
					PreparedStatement pst = con.prepareStatement(sql) ;
					MenuInmujer ventana = new MenuInmujer();
					dispose();
					ventana.setVisible(true);
					ventana.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnSiguiente.setBackground(new Color(224, 167, 167));
		btnSiguiente.setBounds(685, 445, 108, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setBackground(new Color(224, 167, 167));
		btnInicio.setBounds(350, 445, 108, 23);
		contentPane.add(btnInicio);
		
				JLabel lblNewLabel_10 = new JLabel("DIAGNOSTICO  SOCIAL\r\n");
				lblNewLabel_10.setBounds(24, 125, 769, 13);
				contentPane.add(lblNewLabel_10);
				lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 15));
	}
}



