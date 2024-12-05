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

public class Efectos_Psicologicos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMiedo;
	private JTextField txtEstresPos;
	private JTextField txtIntentoSui;
	private JTextField txtAnsiedad;
	private JTextField txtIdeaSuici;
	private JTextField txtTrasAl;
	private JTextField txtTrasSue;
	private JTextField txtDepresion;
	private JTextField txtIslamient;
	private JTextField txtOtro;
	JPanel panel_3 = new JPanel();

	public void Calcularansiedad() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%ansiedad%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtAnsiedad.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularDepresion() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%depresion%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtDepresion.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularestresPos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%estres postraumatico%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtEstresPos.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularideasui() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%ideacion suicida%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtIdeaSuici.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularIntentoSui() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%intento suicida%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtIntentoSui.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularAisl() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%Aislamiento%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtIslamient.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularmiedo() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%miedo%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtMiedo.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Calcularotro() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%otro%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtOtro.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalculartasAl() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%trastorno alimenticio%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtTrasAl.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularTrasSue() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_psicologicos) AS total FROM datos WHERE Efectos_psicologicos LIKE '%trastorno del sueño%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtTrasSue.setText(rs.getString("total"));
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
					Efectos_Psicologicos frame = new Efectos_Psicologicos();
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
	public Efectos_Psicologicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Efectos_Psicologicos.class.getResource("/img/encabezadografic.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 58, 316, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Angustia y/o miedo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 144, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estres postraumatico");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 180, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Intento suicida");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 144, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ansiedad");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 72, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ideacion suicida");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 223, 144, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Trastorno alimenticio");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 270, 144, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Trastorno del sueño");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 322, 160, 14);
		panel.add(lblNewLabel_7);
		
		txtMiedo = new JTextField();
		txtMiedo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMiedo.setBounds(196, 32, 65, 20);
		panel.add(txtMiedo);
		txtMiedo.setColumns(10);
		
		txtEstresPos = new JTextField();
		txtEstresPos.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEstresPos.setBounds(200, 84, 61, 20);
		panel.add(txtEstresPos);
		txtEstresPos.setColumns(10);
		
		txtIntentoSui = new JTextField();
		txtIntentoSui.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtIntentoSui.setBounds(200, 129, 61, 20);
		panel.add(txtIntentoSui);
		txtIntentoSui.setColumns(10);
		
		txtAnsiedad = new JTextField();
		txtAnsiedad.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAnsiedad.setBounds(200, 177, 61, 20);
		panel.add(txtAnsiedad);
		txtAnsiedad.setColumns(10);
		
		txtIdeaSuici = new JTextField();
		txtIdeaSuici.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtIdeaSuici.setBounds(200, 220, 61, 20);
		panel.add(txtIdeaSuici);
		txtIdeaSuici.setColumns(10);
		
		txtTrasAl = new JTextField();
		txtTrasAl.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTrasAl.setBounds(200, 267, 61, 20);
		panel.add(txtTrasAl);
		txtTrasAl.setColumns(10);
		
		txtTrasSue = new JTextField();
		txtTrasSue.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTrasSue.setBounds(200, 319, 61, 20);
		panel.add(txtTrasSue);
		txtTrasSue.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Depresion");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 347, 144, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Aislamiento");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(10, 387, 120, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Otro");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 424, 46, 14);
		panel.add(lblNewLabel_11);
		
		txtDepresion = new JTextField();
		txtDepresion.setBounds(200, 350, 61, 20);
		panel.add(txtDepresion);
		txtDepresion.setColumns(10);
		
		txtIslamient = new JTextField();
		txtIslamient.setBounds(200, 384, 61, 20);
		panel.add(txtIslamient);
		txtIslamient.setColumns(10);
		
		txtOtro = new JTextField();
		txtOtro.setBounds(200, 421, 61, 20);
		panel.add(txtOtro);
		txtOtro.setColumns(10);
		
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
		btnNewButton_1.setBounds(80, 473, 133, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Efectos_Psicologicos.class.getResource("/img/inmujer.png")));
		lblNewLabel_8.setBounds(0, 0, 316, 507);
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
				int totalAmputaciones = Integer.parseInt(txtAnsiedad.getText());
				int totalCicatrices = Integer.parseInt(txtDepresion.getText());
				int totalEnfermedades = Integer.parseInt(txtEstresPos.getText());
				int totalfracturas = Integer.parseInt(txtIdeaSuici.getText());
				int totalHeridas = Integer.parseInt(txtIntentoSui.getText());
				int totalNinguno = Integer.parseInt(txtIslamient.getText());
				int totalOtros = Integer.parseInt(txtMiedo.getText());
				int totalQuemaduras = Integer.parseInt(txtOtro.getText());
				int totalTrasAl = Integer.parseInt(txtTrasAl.getText());
				int totalTrasSue = Integer.parseInt(txtTrasSue.getText());
				
				//DefaultPieDataset
				DefaultCategoryDataset  datos = new DefaultCategoryDataset();
				datos.setValue(totalAmputaciones,"Ansiedad", "No Victimas");
				datos.setValue(totalCicatrices,"Depresion", "No Victimas");
				datos.setValue(totalEnfermedades,"Estres postraumatico","No Victimas");
				datos.setValue(totalfracturas, "ideacion suicida","No Victimas");
				datos.setValue(totalHeridas,"Intento suicida","No Victimas");
				datos.setValue(totalNinguno,"Aislamiento", "No Victimas");
				datos.setValue(totalOtros,"Miedo","No Victimas");
				datos.setValue(totalQuemaduras,"Otro", "No Victimas");
				datos.setValue(totalTrasAl,"Trastorno alimenticio", "No Victimas");
				datos.setValue(totalTrasSue,"Trastorno del sueño", "No Victimas");

				
				JFreeChart graficoPastel = ChartFactory.createBarChart(
						"Efectos Psicologicos",	
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
		CalcularAisl();
		Calcularansiedad();
		CalcularDepresion();
		CalcularestresPos();
		Calcularideasui();
		CalcularIntentoSui();
		Calcularmiedo();
		Calcularotro();
		CalculartasAl();
		CalcularTrasSue();
	}
}
