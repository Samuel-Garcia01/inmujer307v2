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

public class TiposDeViolencia extends JFrame {

	private JPanel contentPane;
	private JTextField txtfisa;
	private JTextField txtVicaria;
	private JTextField txtSexual;
	private JTextField txtPsi;
	private JTextField txtPatri;
	private JTextField txtEconomica;
	JPanel panel_3 = new JPanel();

	public void Calcularfisica() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%fisica%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtfisa.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularvicaria() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%vicaria%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtVicaria.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularaexual() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%sexual%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtSexual.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularPsico() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%psicologica%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtPsi.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularPatrimo() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%patrimonial%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtPatri.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calculareconomi() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Tipos_de_Violencia) AS total FROM datos WHERE Tipos_de_Violencia LIKE '%economica%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtEconomica.setText(rs.getString("total"));
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
					TiposDeViolencia frame = new TiposDeViolencia();
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
	public TiposDeViolencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TiposDeViolencia.class.getResource("/img/encabezadografic.png")));
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
		btnNewButton_1.setBounds(81, 473, 133, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Fisica");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vicaria");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sexual");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 72, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Psicoloica");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 72, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Patrimonial");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 223, 72, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Economica");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 270, 89, 14);
		panel.add(lblNewLabel_6);
		
		txtfisa = new JTextField();
		txtfisa.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfisa.setBounds(109, 32, 152, 20);
		panel.add(txtfisa);
		txtfisa.setColumns(10);
		
		txtVicaria = new JTextField();
		txtVicaria.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtVicaria.setBounds(109, 84, 152, 20);
		panel.add(txtVicaria);
		txtVicaria.setColumns(10);
		
		txtSexual = new JTextField();
		txtSexual.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSexual.setBounds(109, 129, 152, 20);
		panel.add(txtSexual);
		txtSexual.setColumns(10);
		
		txtPsi = new JTextField();
		txtPsi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPsi.setBounds(109, 177, 152, 20);
		panel.add(txtPsi);
		txtPsi.setColumns(10);
		
		txtPatri = new JTextField();
		txtPatri.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPatri.setBounds(109, 220, 152, 20);
		panel.add(txtPatri);
		txtPatri.setColumns(10);
		
		txtEconomica = new JTextField();
		txtEconomica.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEconomica.setBounds(109, 267, 152, 20);
		panel.add(txtEconomica);
		txtEconomica.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TiposDeViolencia.class.getResource("/img/inmujer.png")));
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
		btnNewButton.setBounds(507, 528, 133, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalfisico = Integer.parseInt(txtfisa.getText());
				int totalvicaria = Integer.parseInt(txtVicaria.getText());
				int totalsexual = Integer.parseInt(txtSexual.getText());
				int totalpsicolo = Integer.parseInt(txtPsi.getText());
				int totalpatrimonial = Integer.parseInt(txtPatri.getText());
				int totalecoeco = Integer.parseInt(txtEconomica.getText());
				
				//DefaultPieDataset
				DefaultCategoryDataset  datos = new DefaultCategoryDataset();
				datos.setValue(totalfisico,"fisica", "No Victimas");
				datos.setValue(totalvicaria,"vicaria", "No Victimas");
				datos.setValue(totalsexual,"sexual","No Victimas");
				datos.setValue(totalpsicolo, "psicologica","No Victimas");
				datos.setValue(totalpatrimonial,"Patrimonial","No Victimas");
				datos.setValue(totalecoeco,"Economica", "No Victimas");

				
				JFreeChart graficoPastel = ChartFactory.createBarChart(
						"TIPOS DE VIOLENCIA",	
						"tipos",
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
		Calcularaexual();
		Calculareconomi();
		Calcularfisica();
		CalcularPatrimo();
		CalcularPsico();
		Calcularvicaria();
		}
}
