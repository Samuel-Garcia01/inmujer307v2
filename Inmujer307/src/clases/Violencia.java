package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Violencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

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
		lblNewLabel_8.setIcon(new ImageIcon(Violencia.class.getResource("/img/encabezado.gif")));
		lblNewLabel_8.setBounds(0, 0, 809, 57);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_1.setBackground(new Color(243, 220, 220));
		panel_1.setBounds(10, 77, 386, 232);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Violencia Física");
		chckbxNewCheckBox.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(20, 42, 149, 21);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Tipos de Violencia");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(138, 10, 113, 13);
		panel_1.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Violencia Psicológica");
		chckbxNewCheckBox_1.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_1.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBounds(198, 93, 149, 21);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Volencia Sexual");
		chckbxNewCheckBox_2.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_2.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_2.setBounds(20, 93, 149, 21);
		panel_1.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Violencia Económica");
		chckbxNewCheckBox_3.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_3.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_3.setBounds(198, 139, 149, 21);
		panel_1.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Violencia Patrimonial");
		chckbxNewCheckBox_4.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_4.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_4.setBounds(20, 139, 149, 21);
		panel_1.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Acoso/Hostigamiento");
		chckbxNewCheckBox_5.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_5.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_5.setBounds(102, 188, 149, 21);
		panel_1.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Violencia Vicaria");
		chckbxNewCheckBox_6.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_6.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_6.setBounds(198, 42, 149, 21);
		panel_1.add(chckbxNewCheckBox_6);
		
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
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Familia");
		chckbxNewCheckBox_7.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_7.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_7.setBounds(48, 42, 108, 21);
		panel_2.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Docente");
		chckbxNewCheckBox_8.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_8.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_8.setBounds(48, 91, 108, 21);
		panel_2.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Institucional");
		chckbxNewCheckBox_9.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_9.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_9.setBounds(48, 135, 108, 21);
		panel_2.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Noviazgo");
		chckbxNewCheckBox_10.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_10.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_10.setBounds(224, 42, 93, 21);
		panel_2.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Comunitaria");
		chckbxNewCheckBox_11.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_11.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_11.setBounds(224, 91, 93, 21);
		panel_2.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Laboral");
		chckbxNewCheckBox_12.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_12.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_12.setBounds(224, 135, 93, 21);
		panel_2.add(chckbxNewCheckBox_12);
		
		JCheckBox chckbxNewCheckBox_13 = new JCheckBox("Cibernética");
		chckbxNewCheckBox_13.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_13.setFont(new Font("Arial", Font.BOLD, 12));
		chckbxNewCheckBox_13.setBounds(145, 187, 93, 21);
		panel_2.add(chckbxNewCheckBox_13);
		
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
		
		textField = new JTextField();
		textField.setBounds(139, 53, 145, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de la Agresión:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(295, 56, 132, 13);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("Hora de la Agresión:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(570, 56, 132, 13);
		panel_3.add(lblNewLabel_9);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(422, 53, 138, 19);
		panel_3.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(694, 54, 85, 17);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(233, 150, 122), 3));
		panel_4.setBackground(new Color(243, 220, 220));
		panel_4.setBounds(10, 441, 789, 162);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(243, 220, 220));
		textArea.setBounds(10, 32, 769, 120);
		panel_4.add(textArea);
		
		JLabel lblNewLabel_10 = new JLabel("Descripción de los Hechos:");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(10, 9, 165, 13);
		panel_4.add(lblNewLabel_10);
	}
}
