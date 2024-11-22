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
import GraficasPastel.ModalidadViolencia;

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

public class Efectos_Psicologicos extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel panel1 = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable tablaGrafica;
	
	public void mostrarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Efectos_psicologicos, COUNT(Efectos_psicologicos) AS total FROM datos GROUP BY Efectos_psicologicos";
		
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
					baseDatos[0] = rs.getString("Efectos_psicologicos");
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
		setTitle("Efectos  psicologicos de la Violencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 525);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel1.setBackground(new Color(128, 0, 255));
		
		tablaGrafica = new JTable();
		scrollPane.setViewportView(tablaGrafica);
		
		panel1.setBounds(0, 267, 335, 219);
		contentPane.add(panel1);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setIcon(new ImageIcon(Efectos_Psicologicos.class.getResource("/img/GraficarBarras1.png")));
		btnGraficar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/GraficarBarras2.png/")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/GraficarBarras1.png/")));
			}
		});
		btnGraficar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String et1 = tablaGrafica.getValueAt(0, 0).toString();
				String et2 = tablaGrafica.getValueAt(1, 0).toString();
				String et3 = tablaGrafica.getValueAt(2, 0).toString();
				String et4 = tablaGrafica.getValueAt(3, 0).toString();
				String et5= tablaGrafica.getValueAt(4, 0).toString();
				String et6= tablaGrafica.getValueAt(5, 0).toString();
				String et7= tablaGrafica.getValueAt(6, 0).toString();
				String et8= tablaGrafica.getValueAt(7, 0).toString();
				String et9= tablaGrafica.getValueAt(8, 0).toString();
				String et10= tablaGrafica.getValueAt(9, 0).toString();
				
				int n1=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
				int n2=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
				int n3=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
				int n4=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
				int n5=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(4, 1)));
				int n6=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(5, 1)));
				int n7=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(6, 1)));
				int n8=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(7, 1)));
				int n9=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(8, 1)));
				int n10=Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(9, 1)));
				
				DefaultCategoryDataset datos= new DefaultCategoryDataset();
				
				datos.setValue(n1, "1", et1);
				datos.setValue(n2, "2", et2);
				datos.setValue(n3, "3", et3);
				datos.setValue(n4, "4", et4);
				datos.setValue(n5, "5", et5);
				datos.setValue(n6, "6", et6);
				datos.setValue(n7, "7", et7);
				datos.setValue(n8, "8", et8);
				datos.setValue(n9, "9", et9);
				datos.setValue(n10, "10", et10);
				
				JFreeChart grafico_barras = ChartFactory.createBarChart3D("Psicologicos", "Efectos", "Victimas", datos, PlotOrientation.HORIZONTAL,true,true,false);
				ChartPanel panel = new ChartPanel(grafico_barras);
				panel.setMouseWheelEnabled(true);
				panel.setPreferredSize(new Dimension(335, 219));
				
				panel1.setLayout(new BorderLayout());
				panel1.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 488, 525);
			}
		});
		btnGraficar.setBounds(385, 201, 77, 72);
		contentPane.add(btnGraficar);
		
		JButton btnNex = new JButton("");
		btnNex.setIcon(new ImageIcon(Efectos_Psicologicos.class.getResource("/img/Flecha_1.png")));
		btnNex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNex.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/flecha_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNex.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flecha_1.png")));
			}
		});
		btnNex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Efectos_Sexuales obj = new Efectos_Sexuales();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNex.setBounds(362, 144, 35, 23);
		contentPane.add(btnNex);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Efectos_Psicologicos.class.getResource("/img/Flechaizquierda_1.png")));
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flechaizquierda_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Efectos_Sexuales.class.getResource("/img/Flechaizquierda_1.png")));
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Efectos_Fisicos obj = new Efectos_Fisicos();
				obj.setVisible(true);
				dispose();
			}
			
		});
		btnAtras.setBounds(362, 61, 35, 23);
		contentPane.add(btnAtras);
		scrollPane.setBounds(0, 0, 335, 228);
		contentPane.add(scrollPane);
		mostrarDatos();
		
	}
}
