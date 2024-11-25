package GraficaBarras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Efectos_Patrimoniales extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Efectos_Patrimoniales frame = new Efectos_Patrimoniales();
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
	public Efectos_Patrimoniales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Efectos_Patrimoniales.class.getResource("/img/encabezadografic.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 58, 316, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(74, 360, 133, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Efectos_Patrimoniales.class.getResource("/img/inmujer.png")));
		lblNewLabel_8.setBounds(0, 0, 316, 508);
		panel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(79, 0, 79));
		panel_2.setBounds(310, 566, 509, 45);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 213, 255));
		panel_3.setBounds(374, 84, 381, 433);
		contentPane.add(panel_3);
		
		JButton btnGraficar = new JButton("GRAFICAR");
		btnGraficar.setForeground(Color.WHITE);
		btnGraficar.setFont(new Font("Arial", Font.BOLD, 12));
		btnGraficar.setBackground(new Color(186, 85, 211));
		btnGraficar.setBounds(501, 528, 133, 23);
		contentPane.add(btnGraficar);
	}
}
