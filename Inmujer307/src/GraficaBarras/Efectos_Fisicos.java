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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Efectos_Fisicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel1 = new JPanel();
	private JTable tablaGrafica;
	
	public void mostrarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Efectos_fisicos, COUNT(Efectos_fisicos) AS total FROM datos GROUP BY Efectos_fisicos";
		
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
					baseDatos[0] = rs.getString("Efectos_fisicos");
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
		setTitle("Efectos  fisicos de la Violencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel1.setBackground(new Color(255, 0, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 264, 205);
		contentPane.add(scrollPane);
		
		tablaGrafica = new JTable();
		scrollPane.setViewportView(tablaGrafica);
		
		panel1.setBounds(0, 266, 454, 269);
		contentPane.add(panel1);
		
		JButton btnGraficar = new JButton("");
		btnGraficar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGraficar.setIcon(new ImageIcon(Efectos_Fisicos.class.getResource("/img/GraficarBarras1.png")));
		btnGraficar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(Efectos_Fisicos.class.getResource("/img/GraficarBarras2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(Efectos_Fisicos.class.getResource("/img/GraficarBarras1.png")));
			}
		});
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
				
				
				int dato1 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
				int dato2 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
				int dato3 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
				int dato4 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
				int dato5 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(4, 1)));
				int dato6 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(5, 1)));
				int dato7 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(6, 1)));
				int dato8 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(7, 1)));
				
				DefaultCategoryDataset datos= new DefaultCategoryDataset();
				
				datos.setValue(dato1, "Efectos fisicos", et1);
				datos.setValue(dato2, "Efectos fisicos", et2);
				datos.setValue(dato3, "Efectos fisicos", et3);
				datos.setValue(dato4, "Efectos fisicos", et4);
				datos.setValue(dato5, "Efectos fisicos", et5);
				datos.setValue(dato6, "Efectos fisicos", et6);
				datos.setValue(dato7, "Efectos fisicos", et7);
				datos.setValue(dato8, "Efectos fisicos", et8);
				
				JFreeChart grafico_barras = ChartFactory.createBarChart3D("Fisicos", "Efectos", "Victimas", datos, PlotOrientation.HORIZONTAL,true,true,false);
				ChartPanel panel = new ChartPanel(grafico_barras);
				panel.setMouseWheelEnabled(true);
				panel.setPreferredSize(new Dimension(281, 278));
				
				panel1.setLayout(new BorderLayout());
				panel1.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 460, 574);
			}
		});
		btnGraficar.setBounds(86, 202, 89, 72);
		contentPane.add(btnGraficar);

		
		JButton btnNex = new JButton("");
		btnNex.setIcon(new ImageIcon(Efectos_Fisicos.class.getResource("/img/Flecha_1.png")));
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
				Efectos_Psicologicos obj = new Efectos_Psicologicos();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNex.setBounds(355, 230, 38, 23);
		contentPane.add(btnNex);
		mostrarDatos();
		
		
		
	}
}
