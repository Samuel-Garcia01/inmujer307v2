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

public class Efectos_Patrimoniales extends JFrame {

	private JPanel contentPane;
	private JTextField txtDejoEstu;
	private JTextField txtChantaje;
	private JTextField txtPerida;
	private JTextField txtSalirD;
	private JTextField txtPensionAl;
	private JTextField txtNoGasto;
	private JTextField txtQuema;
	private JTextField txtNoApl;
	JPanel panel_1 = new JPanel();
	JPanel panel_3 = new JPanel();

	public void CalcularChant() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%chantaje para aportar%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtChantaje.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularDejoEst() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%Dejó de estudiar%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtDejoEstu.setText(rs.getString("total"));
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
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%no aplica%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtNoApl.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularGasto() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%no recibe gasto%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtNoGasto.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularPension() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%no recibe pension alimenticia%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtPensionAl.setText(rs.getString("total"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CalcularPerdida() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%Perdida de propiedades%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtPerida.setText(rs.getString("total"));
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
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%quema de documentos%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtQuema.setText(rs.getString("total"));
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
		
		String sql = "SELECT COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos WHERE Efectos_economicos_y_patrimoniales LIKE '%Salir del domicilio%'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtSalirD.setText(rs.getString("total"));
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
		
		JLabel lblNewLabel_1 = new JLabel("Dejó de esudiar");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 35, 102, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chantaje para aportar");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 87, 153, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Perdida de propiedades");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 132, 153, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salir del domicilio");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 180, 133, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No recibe pension alimenticia");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 223, 184, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("No recibe gasto");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 270, 133, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Quema o perdida de documentos");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 322, 206, 14);
		panel.add(lblNewLabel_7);
		
		txtDejoEstu = new JTextField();
		txtDejoEstu.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDejoEstu.setBounds(226, 32, 66, 20);
		panel.add(txtDejoEstu);
		txtDejoEstu.setColumns(10);
		
		txtChantaje = new JTextField();
		txtChantaje.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtChantaje.setBounds(226, 84, 66, 20);
		panel.add(txtChantaje);
		txtChantaje.setColumns(10);
		
		txtPerida = new JTextField();
		txtPerida.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPerida.setBounds(226, 129, 66, 20);
		panel.add(txtPerida);
		txtPerida.setColumns(10);
		
		txtSalirD = new JTextField();
		txtSalirD.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSalirD.setBounds(226, 177, 66, 20);
		panel.add(txtSalirD);
		txtSalirD.setColumns(10);
		
		txtPensionAl = new JTextField();
		txtPensionAl.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPensionAl.setBounds(226, 220, 66, 20);
		panel.add(txtPensionAl);
		txtPensionAl.setColumns(10);
		
		txtNoGasto = new JTextField();
		txtNoGasto.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNoGasto.setBounds(226, 267, 66, 20);
		panel.add(txtNoGasto);
		txtNoGasto.setColumns(10);
		
		txtQuema = new JTextField();
		txtQuema.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtQuema.setBounds(226, 319, 66, 20);
		panel.add(txtQuema);
		txtQuema.setColumns(10);
		
		
		panel_1.setBackground(new Color(79, 0, 79));
		panel_1.setBounds(0, 507, 316, 46);
		panel.add(panel_1);
		
		JLabel lblNewLabel_9 = new JLabel("No aplica");
		lblNewLabel_9.setBounds(10, 360, 87, 14);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Efectos_Patrimoniales.class.getResource("/img/inmujer.png")));
		lblNewLabel_8.setBounds(0, 0, 316, 507);
		panel.add(lblNewLabel_8);
		
		txtNoApl = new JTextField();
		txtNoApl.setBounds(226, 357, 66, 20);
		panel.add(txtNoApl);
		txtNoApl.setColumns(10);
		
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
		btnNewButton_1.setBounds(83, 473, 133, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(79, 0, 79));
		panel_2.setBounds(310, 566, 509, 45);
		contentPane.add(panel_2);
		
		
		panel_3.setBackground(new Color(255, 213, 255));
		panel_3.setBounds(374, 84, 381, 433);
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("GRAFICAR");
		btnNewButton.setBounds(506, 528, 133, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalAmputaciones = Integer.parseInt(txtChantaje.getText());
				int totalCicatrices = Integer.parseInt(txtDejoEstu.getText());
				int totalEnfermedades = Integer.parseInt(txtNoApl.getText());
				int totalfracturas = Integer.parseInt(txtNoGasto.getText());
				int totalHeridas = Integer.parseInt(txtPensionAl.getText());
				int totalNinguno = Integer.parseInt(txtPerida.getText());
				int totalOtros = Integer.parseInt(txtQuema.getText());
				int totalQuemaduras = Integer.parseInt(txtSalirD.getText());
				
				//DefaultPieDataset
				DefaultCategoryDataset  datos = new DefaultCategoryDataset();
				datos.setValue(totalAmputaciones,"Chantaje para aportar", "No Victimas");
				datos.setValue(totalCicatrices,"Dejó de estudiar", "No Victimas");
				datos.setValue(totalEnfermedades,"No aplica","No Victimas");
				datos.setValue(totalfracturas, "No recibe gasto","No Victimas");
				datos.setValue(totalHeridas,"No recibe pension alimenticia","No Victimas");
				datos.setValue(totalNinguno,"perdida de propiedades", "No Victimas");
				datos.setValue(totalOtros,"perdida o quema de documentos","No Victimas");
				datos.setValue(totalQuemaduras,"Salor del domicilio", "No Victimas");

				
				JFreeChart graficoPastel = ChartFactory.createBarChart(
						"Efectos Patrimonials",	
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
		CalcularChant();
		CalcularDejoEst();
		CalcularGasto();
		CalcularNinguno();
		CalcularNoApli();
		Calcularotros();
		CalcularPension();
		CalcularPerdida();
	}
}
