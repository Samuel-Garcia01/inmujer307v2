package GraficaBarras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ConexionBaseDeDatos.ConexionInmujer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Efectos_Sexuales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel1 = new JPanel();
	private JTable tablaGrafica;
 
	
			
	
	public void mostrarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Efectos_sexuales, COUNT(Efectos_sexuales) AS total FROM datos GROUP BY Efectos_sexuales";
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Efectos");
		modelo.addColumn("Total Casos");
		
		tablaGrafica.setModel(modelo);
		
		String[] baseDatos = new String[2];
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					baseDatos[0] = rs.getString("Efectos_sexuales");
					baseDatos[1] = rs.getString("total");
					
					modelo.addRow(baseDatos);
				} while (rs.next());
				tablaGrafica.setModel(modelo);
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
		setTitle("Efectos  Sexuales y patrimoniales de la Violencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel1.setBackground(new Color(128, 0, 255));
		
		
		panel1.setBounds(0, 267, 237, 219);
		contentPane.add(panel1);
		
		JPanel panelFisico = new JPanel();
		panelFisico.setBackground(new Color(255, 0, 128));
		panelFisico.setBounds(0, 0, 472, 268);
		contentPane.add(panelFisico);
		panelFisico.setLayout(null);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/GraficarBarras1.png")));
		btnGraficar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/GraficarBarras2.png/")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/GraficarBarras1.png/")));
			}
		});
		btnGraficar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGraficar.setBounds(348, 49, 76, 66);
		panelFisico.add(btnGraficar);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnterior.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flechaizquierda_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAnterior.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flechaizquierda_1.png")));
			}
		});
		btnAnterior.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flechaizquierda_1.png")));
		btnAnterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Efectos_Psicologicos obj = new Efectos_Psicologicos();
				obj.setVisible(true);
				dispose();
			}
		});
		btnAnterior.setBounds(288, 57, 41, 23);
		panelFisico.add(btnAnterior);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 278, 110);
		panelFisico.add(scrollPane);
		
		tablaGrafica = new JTable();
		scrollPane.setViewportView(tablaGrafica);
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String et1 = tablaGrafica.getValueAt(0, 0).toString();
				String et2 = tablaGrafica.getValueAt(1, 0).toString();
				String et3 = tablaGrafica.getValueAt(2, 0).toString();
				String et4 = tablaGrafica.getValueAt(3, 0).toString();
				
				int n1=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
				int n2=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
				int n3=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
				int n4=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
				
				
				DefaultCategoryDataset datos= new DefaultCategoryDataset();
				
				datos.setValue(n1, "1", et1);
				datos.setValue(n2, "2", et2);
				datos.setValue(n3, "3", et3);
				datos.setValue(n4, "4", et4);
				
				JFreeChart grafico_barras = ChartFactory.createBarChart3D("Sexuales", "Efectos", "Victimas", datos, PlotOrientation.VERTICAL,true,true,false);
				ChartPanel panel = new ChartPanel(grafico_barras);
				panel.setMouseWheelEnabled(true);
				panel.setPreferredSize(new Dimension(237, 219));
				
				panel1.setLayout(new BorderLayout());
				panel1.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 488, 525);
				
			}
		});
		mostrarDatos();
	}
}
