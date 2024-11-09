package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class RedesDeApoyo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		lblNewLabel_8.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/encabezado.gif")));
		lblNewLabel_8.setBounds(0, 0, 809, 57);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(431, 77, 331, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 53, 155, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 56, 69, 13);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 140, 155, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 143, 69, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 221, 69, 13);
		panel_1.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(89, 218, 155, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
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
		
		textField = new JTextField();
		textField.setBounds(125, 114, 196, 19);
		panel_1_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipos de Apoyo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 186, 105, 13);
		panel_1_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 183, 196, 19);
		panel_1_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(620, 510, 142, 34);
		contentPane.add(btnNewButton);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Arial", Font.BOLD, 12));
		btnInicio.setBounds(336, 510, 142, 34);
		contentPane.add(btnInicio);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegresar.setBounds(54, 510, 142, 34);
		contentPane.add(btnRegresar);
	}
}
