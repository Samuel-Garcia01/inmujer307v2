package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class InformacionComplementaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");

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
		lblNewLabel_1.setBounds(276, 11, 260, 33);
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(243, 220, 220));
		textArea.setBounds(24, 27, 422, 115);
		panel_1.add(textArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 128, 128), new Color(255, 128, 128)));
		panel_1_1.setBackground(new Color(243, 220, 220));
		panel_1_1.setBounds(158, 312, 470, 165);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Autorizo");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxNewCheckBox.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox.setBounds(89, 69, 97, 23);
		panel_1_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("Autorización");
		lblNewLabel_3.setBounds(200, 11, 71, 14);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("No autorizo");
		chckbxNewCheckBox_1.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxNewCheckBox_1.setBackground(new Color(243, 220, 220));
		chckbxNewCheckBox_1.setBounds(281, 69, 97, 23);
		panel_1_1.add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(148, 529, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FINALIZAR");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(525, 529, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGRESAR");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 0, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_2.setBounds(346, 529, 108, 23);
		contentPane.add(btnNewButton_2);
		
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
