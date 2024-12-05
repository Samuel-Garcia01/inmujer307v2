package GraficasPastel;

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
import org.jfree.data.general.DefaultPieDataset;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.menuGraficas;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModalidadViolencia extends JFrame {

	private JPanel contentPane;
	private JTextField txtFami;
	private JTextField txtDocen;
	private JTextField txtInsti;
	private JTextField txtNoviazgo;
	private JTextField txtComunitaria;
	private JTextField txtLabo;
	private JTextField txtCiber;
	JPanel panel_3 = new JPanel();

	public void CalcularFamiliar() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%familiar%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtFami.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularInsti() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%institucional%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtInsti.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularLabo() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%laboral%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtLabo.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularNoviazgo() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%noviazgo%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtNoviazgo.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularDocen() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%Docente%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtDocen.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularComu() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%comunitaria%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtComunitaria.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void CalcularCiber() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Modalidades_de_violencia) AS total FROM datos WHERE Modalidades_de_violencia LIKE '%cibernetica%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtCiber.setText(rs.getString("total"));
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
					ModalidadViolencia frame = new ModalidadViolencia();
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
	public ModalidadViolencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/encabezadografic.png")));
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
		
		JLabel lblNewLabel_1 = new JLabel("Familiar");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Docente");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Institucional");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 72, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Noviazgo");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 72, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Comunitaria");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 223, 72, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Laboral");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 270, 49, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cibernetica");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 322, 72, 14);
		panel.add(lblNewLabel_7);
		
		txtFami = new JTextField();
		txtFami.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFami.setBounds(109, 32, 152, 20);
		panel.add(txtFami);
		txtFami.setColumns(10);
		
		txtDocen = new JTextField();
		txtDocen.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDocen.setBounds(109, 84, 152, 20);
		panel.add(txtDocen);
		txtDocen.setColumns(10);
		
		txtInsti = new JTextField();
		txtInsti.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtInsti.setBounds(109, 129, 152, 20);
		panel.add(txtInsti);
		txtInsti.setColumns(10);
		
		txtNoviazgo = new JTextField();
		txtNoviazgo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNoviazgo.setBounds(109, 177, 152, 20);
		panel.add(txtNoviazgo);
		txtNoviazgo.setColumns(10);
		
		txtComunitaria = new JTextField();
		txtComunitaria.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtComunitaria.setBounds(109, 220, 152, 20);
		panel.add(txtComunitaria);
		txtComunitaria.setColumns(10);
		
		txtLabo = new JTextField();
		txtLabo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLabo.setBounds(109, 267, 152, 20);
		panel.add(txtLabo);
		txtLabo.setColumns(10);
		
		txtCiber = new JTextField();
		txtCiber.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCiber.setBounds(109, 319, 152, 20);
		panel.add(txtCiber);
		txtCiber.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/inmujer.png")));
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
		btnNewButton.setBounds(503, 528, 133, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalciber = Integer.parseInt(txtCiber.getText());
				int totalComu = Integer.parseInt(txtComunitaria.getText());
				int totalDoce = Integer.parseInt(txtDocen.getText());
				int totalFami = Integer.parseInt(txtFami.getText());
				int totalInsti = Integer.parseInt(txtInsti.getText());
				int totalLabo = Integer.parseInt(txtLabo.getText());
				int totalNov = Integer.parseInt(txtNoviazgo.getText());
				
				//DefaultPieDataset
				DefaultPieDataset  datos = new DefaultPieDataset();
				datos.setValue("Cibernetica",totalciber);
				datos.setValue("Comunitaria",totalComu);
				datos.setValue("Docente",totalDoce);
				datos.setValue("Familiar",totalFami);
				datos.setValue("Institucional",totalInsti);
				datos.setValue("Laboral",totalLabo);
				datos.setValue("Noviazgo",totalNov);

				JFreeChart graficoPastel=ChartFactory.createPieChart(
						"Modalidades con mayor indice de incidentes",
						datos,
						true,
						true,
						false);
				
				ChartPanel panelGrafico = new ChartPanel(graficoPastel);
				panelGrafico.setMouseWheelEnabled(true);
				panelGrafico.setPreferredSize(new Dimension(381, 433));
				
				
				panel_3.setLayout(new BorderLayout());
				panel_3.add(panelGrafico,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 823, 648);
				setLocationRelativeTo(null);
				

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		CalcularCiber();
		CalcularComu();
		CalcularDocen();
		CalcularFamiliar();
		CalcularInsti();
		CalcularLabo();
		CalcularNoviazgo();
	}
}
