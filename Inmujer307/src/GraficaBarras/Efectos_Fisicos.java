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

public class Efectos_Fisicos extends JFrame {

	private JPanel contentPane;
	private JTextField txtHerida;
	private JTextField txtfracturas;
	private JTextField txtCicatrices;
	private JTextField txtAmputaciones;
	private JTextField txtEnfermedades;
	private JTextField txtQuemaduras;
	private JTextField txtOtros;
	private JTextField txtNinguno;

	public void CalcularHerida() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%herida%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtHerida.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularFractura() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%fractura%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtfracturas.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularCicatrices() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%cicatrices%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtCicatrices.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularAmpu() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%Amputaciones%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtAmputaciones.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularEnfermedades() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%enfermedad%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtEnfermedades.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularQuemaduras() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%quemaduras%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtQuemaduras.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularotros() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%otros%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtOtros.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularNinguno() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_fisicos) AS total FROM datos WHERE Efectos_fisicos LIKE '%ninguno%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtNinguno.setText(rs.getString("total"));
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
					Efectos_Fisicos frame = new Efectos_Fisicos();
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
	public Efectos_Fisicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Efectos_Fisicos.class.getResource("/img/encabezadografic.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 58, 316, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Herida");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fracturas");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 89, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cicatrices");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 72, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amputaciones");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 89, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enfermedades");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 223, 89, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Quemaduras");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 270, 89, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Otros");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 322, 72, 14);
		panel.add(lblNewLabel_7);
		
		txtHerida = new JTextField();
		txtHerida.setEditable(false);
		txtHerida.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHerida.setBounds(109, 32, 152, 20);
		panel.add(txtHerida);
		txtHerida.setColumns(10);
		
		txtfracturas = new JTextField();
		txtfracturas.setEditable(false);
		txtfracturas.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfracturas.setBounds(109, 84, 152, 20);
		panel.add(txtfracturas);
		txtfracturas.setColumns(10);
		
		txtCicatrices = new JTextField();
		txtCicatrices.setEditable(false);
		txtCicatrices.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCicatrices.setBounds(109, 129, 152, 20);
		panel.add(txtCicatrices);
		txtCicatrices.setColumns(10);
		
		txtAmputaciones = new JTextField();
		txtAmputaciones.setEditable(false);
		txtAmputaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAmputaciones.setBounds(109, 177, 152, 20);
		panel.add(txtAmputaciones);
		txtAmputaciones.setColumns(10);
		
		txtEnfermedades = new JTextField();
		txtEnfermedades.setEditable(false);
		txtEnfermedades.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEnfermedades.setBounds(109, 220, 152, 20);
		panel.add(txtEnfermedades);
		txtEnfermedades.setColumns(10);
		
		txtQuemaduras = new JTextField();
		txtQuemaduras.setEditable(false);
		txtQuemaduras.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtQuemaduras.setBounds(109, 267, 152, 20);
		panel.add(txtQuemaduras);
		txtQuemaduras.setColumns(10);
		
		txtOtros = new JTextField();
		txtOtros.setEditable(false);
		txtOtros.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtOtros.setBounds(109, 319, 152, 20);
		panel.add(txtOtros);
		txtOtros.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGraficas ventana = new menuGraficas();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(79, 473, 133, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("Ninguno");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 366, 72, 31);
		panel.add(lblNewLabel_9);
		
		txtNinguno = new JTextField();
		txtNinguno.setEditable(false);
		txtNinguno.setBounds(109, 371, 152, 20);
		panel.add(txtNinguno);
		txtNinguno.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(79, 0, 79));
		panel_2.setBounds(310, 566, 509, 45);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 213, 255));
		panel_3.setBounds(374, 84, 381, 433);
		contentPane.add(panel_3);
		
		JButton btnGraficar = new JButton("GRAFICAR");
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalAmputaciones = Integer.parseInt(txtAmputaciones.getText());
				int totalCicatrices = Integer.parseInt(txtCicatrices.getText());
				int totalEnfermedades = Integer.parseInt(txtEnfermedades.getText());
				int totalfracturas = Integer.parseInt(txtfracturas.getText());
				int totalHeridas = Integer.parseInt(txtHerida.getText());
				int totalNinguno = Integer.parseInt(txtNinguno.getText());
				int totalOtros = Integer.parseInt(txtOtros.getText());
				int totalQuemaduras = Integer.parseInt(txtQuemaduras.getText());
				
				//DefaultPieDataset
				DefaultCategoryDataset  datos = new DefaultCategoryDataset();
				datos.setValue(totalAmputaciones,"Amputaciones", "No Victimas");
				datos.setValue(totalCicatrices,"Cicatrices", "No Victimas");
				datos.setValue(totalEnfermedades,"Enfermedades","No Victimas");
				datos.setValue(totalfracturas, "Fracturas","No Victimas");
				datos.setValue(totalHeridas,"Heridas","No Victimas");
				datos.setValue(totalNinguno,"Ninguno", "No Victimas");
				datos.setValue(totalOtros,"Otros","No Victimas");
				datos.setValue(totalQuemaduras,"Quemaduras", "No Victimas");

				
				JFreeChart graficoPastel = ChartFactory.createBarChart(
						"Efectos Fisicos",	
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
		btnGraficar.setForeground(Color.WHITE);
		btnGraficar.setFont(new Font("Arial", Font.BOLD, 12));
		btnGraficar.setBackground(new Color(186, 85, 211));
		btnGraficar.setBounds(514, 528, 133, 23);
		contentPane.add(btnGraficar);
		CalcularAmpu();
		CalcularCicatrices();
		CalcularEnfermedades();
		CalcularFractura();
		CalcularHerida();
		CalcularNinguno();
		Calcularotros();
		CalcularQuemaduras();
		
	}
}
