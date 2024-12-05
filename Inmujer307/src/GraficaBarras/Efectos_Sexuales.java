package GraficaBarras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.menuGraficas;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Efectos_Sexuales extends JFrame {

	private JPanel contentPane;
	private JTextField txtInfecc;
	private JTextField txtEmbaraz;
	private JTextField txtAbor;
	private JTextField txtNoApli;
	JPanel panel_3 = new JPanel();
	
	public void Calcularabor() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_sexuales) AS total FROM datos WHERE Efectos_sexuales LIKE '%aborto%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtAbor.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularemba() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_sexuales) AS total FROM datos WHERE Efectos_sexuales LIKE '%embarazo%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtEmbaraz.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularInfecc() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_sexuales) AS total FROM datos WHERE Efectos_sexuales LIKE '%infecciones%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtInfecc.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void CalcularNoApli() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_sexuales) AS total FROM datos WHERE Efectos_sexuales LIKE '%infecciones%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtNoApli.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Efectos_Sexuales frame = new Efectos_Sexuales();
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
	public Efectos_Sexuales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/encabezadografic.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 58, 316, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGraficas ventana = new menuGraficas();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(186, 85, 211));
		btnNewButton_1.setBounds(86, 473, 133, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Infecciones");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 115, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Embarazo");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 115, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Aborto");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 115, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No aplica");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 115, 14);
		panel.add(lblNewLabel_4);
		
		txtInfecc = new JTextField();
		txtInfecc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtInfecc.setBounds(181, 32, 80, 20);
		panel.add(txtInfecc);
		txtInfecc.setColumns(10);
		
		txtEmbaraz = new JTextField();
		txtEmbaraz.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEmbaraz.setBounds(181, 84, 80, 20);
		panel.add(txtEmbaraz);
		txtEmbaraz.setColumns(10);
		
		txtAbor = new JTextField();
		txtAbor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAbor.setBounds(181, 129, 80, 20);
		panel.add(txtAbor);
		txtAbor.setColumns(10);
		
		txtNoApli = new JTextField();
		txtNoApli.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNoApli.setBounds(181, 177, 80, 20);
		panel.add(txtNoApli);
		txtNoApli.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/inmujer.png")));
		lblNewLabel_8.setBounds(0, 0, 316, 508);
		panel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(79, 0, 79));
		panel_2.setBounds(310, 566, 509, 45);
		contentPane.add(panel_2);
		
		
		panel_3.setBackground(new Color(255, 213, 255));
		panel_3.setBounds(374, 84, 381, 433);
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("GRAFICAR");
		btnNewButton.setBounds(509, 528, 133, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalAmputaciones = Integer.parseInt(txtAbor.getText());
				int totalCicatrices = Integer.parseInt(txtEmbaraz.getText());
				int totalEnfermedades = Integer.parseInt(txtInfecc.getText());
				int totalfracturas = Integer.parseInt(txtNoApli.getText());
				
				//DefaultPieDataset
				DefaultCategoryDataset  datos = new DefaultCategoryDataset();
				datos.setValue(totalAmputaciones,"Aborto", "No Victimas");
				datos.setValue(totalCicatrices,"Embarazo", "No Victimas");
				datos.setValue(totalEnfermedades,"Infeccion","No Victimas");
				datos.setValue(totalfracturas, "No aplica","No Victimas");
				
				JFreeChart graficoPastel = ChartFactory.createBarChart(
						"Efectos sexuales",	
						"Efectos",
						"Victimas",
						datos,
						PlotOrientation.VERTICAL,
						false,			
						true,			
						false			
						);
				
				
				ChartPanel panel = new ChartPanel(graficoPastel);
				panel.setMouseWheelEnabled(rootPaneCheckingEnabled);
				panel.setPreferredSize(new Dimension(381, 433));
				
				
				panel_3.setLayout(new BorderLayout());
				panel_3.add(panel,BorderLayout.NORTH);
				
				
				pack();
				repaint();
				setBounds(100, 100, 823, 648);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		Calcularabor();
		Calcularemba();
		CalcularInfecc();
		CalcularNoApli();
	}
}
