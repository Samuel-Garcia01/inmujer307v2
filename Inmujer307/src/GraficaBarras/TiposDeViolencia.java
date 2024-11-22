package GraficaBarras;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TiposDeViolencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel contenedor = new JPanel();
	private JScrollPane scrollPane;
	private JTable tablaGrafica;

	public void mostrarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Tipos_de_Violencia, COUNT(Tipos_de_Violencia) AS total FROM datos GROUP BY Tipos_de_Violencia";
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Tipos de violencia");
		modelo.addColumn("Total Casos");
		
		tablaGrafica.setModel(modelo);
		
		String[] baseDatos = new String[2];
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					baseDatos[0] = rs.getString("Tipos_de_Violencia");
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
		setBounds(100, 100, 689, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contenedor.setBounds(10, 214, 653, 239);
		contentPane.add(contenedor);
		
		JButton btnGraficar = new JButton("Graficar");
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
		btnGraficar.setIcon(new ImageIcon(TiposDeViolencia.class.getResource("/img/GraficarBarras1.png")));
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
				
				
				int dato1 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
				int dato2 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
				int dato3 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
				int dato4 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
				int dato5 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(4, 1)));
				int dato6 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(5, 1)));
				int dato7 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(6, 1)));
				
				
				DefaultCategoryDataset Datos = new DefaultCategoryDataset();
				
				Datos.setValue(dato1, "Tipos de violencia", et1);
				Datos.setValue(dato2, "Tipos de violencia", et2);
				Datos.setValue(dato3, "Tipos de violencia", et3);
				Datos.setValue(dato4, "Tipos de violencia", et4);
				Datos.setValue(dato5, "Tipos de violencia", et5);
				Datos.setValue(dato6, "Tipos de violencia", et6);
				Datos.setValue(dato7, "Tipos de violencia", et7);
				
				JFreeChart graficoBarras = ChartFactory.createBarChart(
						"GRAFICA DE TIPOS DE VIOLENCIA",
						"Tipos",
						"Victimas",
						Datos,
						PlotOrientation.VERTICAL,
						true,
						true,
						false
						);
				
				ChartPanel cont = new ChartPanel(graficoBarras);
				cont.setMouseWheelEnabled(true);
				cont.setPreferredSize(new Dimension(653, 239));
				
				contenedor.setLayout(new BorderLayout());
				contenedor.add(cont,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 689, 503);
			}
		});
		btnGraficar.setBounds(539, 127, 76, 69);
		contentPane.add(btnGraficar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 340, 192);
		contentPane.add(scrollPane);
		
		tablaGrafica = new JTable();
		scrollPane.setViewportView(tablaGrafica);
		mostrarDatos();
	}
}
