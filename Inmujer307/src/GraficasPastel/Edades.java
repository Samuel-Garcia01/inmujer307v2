package GraficasPastel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import ConexionBaseDeDatos.ConexionInmujer;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Edades extends JFrame {


		private JPanel contentPane;
		private JTable tablaGrafica;
		JPanel panel1 = new JPanel();
		
		
		public void mostrarDatos() {
			ConexionInmujer conexion = new ConexionInmujer();
			Connection con = conexion.conectar();
			
			String sql = "SELECT Edad, COUNT(Edad) AS total FROM datos GROUP BY Edad";
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Edades");
			modelo.addColumn("Total Casos");
			
			tablaGrafica.setModel(modelo);
			
			String[] baseDatos = new String[2];
			
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					do {
						baseDatos[0] = rs.getString("Edad");
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
						Edades frame = new Edades();
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
		public Edades() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 823, 648);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(222, 163, 231));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Edades.class.getResource("/img/encabezadografic.png")));
			lblNewLabel.setBounds(0, 0, 809, 60);
			contentPane.add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 58, 316, 553);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(79, 0, 79));
			panel_1.setBounds(0, 507, 316, 46);
			panel.add(panel_1);
			
			JScrollPane PanelTabla = new JScrollPane();
			PanelTabla.setBounds(10, 11, 306, 495);
			panel.add(PanelTabla);
			
			tablaGrafica = new JTable();
			PanelTabla.setViewportView(tablaGrafica);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(79, 0, 79));
			panel_2.setBounds(310, 566, 509, 45);
			contentPane.add(panel_2);
			
			panel1.setBackground(new Color(255, 213, 255));
			panel1.setBounds(374, 84, 381, 433);
			contentPane.add(panel1);
			
			JButton btnGracicar = new JButton("");
			btnGracicar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnGracicar.setIcon(new ImageIcon(Edades.class.getResource("/img/GraficarPastel2.png/")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnGracicar.setIcon(new ImageIcon(Edades.class.getResource("/img/GraficarPastel1.png/")));
				}
			});
			btnGracicar.setIcon(new ImageIcon(Edades.class.getResource("/img/GraficarPastel1.png")));
			btnGracicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGracicar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String et1 = tablaGrafica.getValueAt(0, 0).toString();
					String et2 = tablaGrafica.getValueAt(1, 0).toString();
					String et3 = tablaGrafica.getValueAt(2, 0).toString();
					String et4 = tablaGrafica.getValueAt(3, 0).toString();
					String et5= tablaGrafica.getValueAt(4, 0).toString();
					String et6= tablaGrafica.getValueAt(5, 0).toString();
					String et7= tablaGrafica.getValueAt(6, 0).toString();
					String et8= tablaGrafica.getValueAt(7, 0).toString();
					String et9= tablaGrafica.getValueAt(8, 0).toString();
					String et10 = tablaGrafica.getValueAt(9, 0).toString();
					
					
					int dato1 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
					int dato2 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
					int dato3 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
					int dato4 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
					int dato5 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(4, 1)));
					int dato6 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(5, 1)));
					int dato7 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(6, 1)));
					int dato8 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(7, 1)));
					int dato9 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(8, 1)));
					int dato10 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(9, 1)));
					
					DefaultPieDataset datos= new DefaultPieDataset();
					
					datos.setValue("Edad 1", dato1);
					datos.setValue("Edad 2", dato2);
					datos.setValue("Edad 3", dato3);
					datos.setValue("Edad 4", dato4);
					datos.setValue("Edad 5", dato5);
					datos.setValue("Edad 6", dato6);
					datos.setValue("Edad 7", dato7);
					datos.setValue("Edad 8", dato8);
					datos.setValue("Edad 9", dato9);
					datos.setValue("Edad 10", dato10);
					
					JFreeChart grafico_pastel=ChartFactory.createPieChart3D(
							"Edades con mayor indice de Insidentes",
							datos,
							true,
							true,
							false
							);
					
					ChartPanel panelGrafico = new ChartPanel(grafico_pastel);
					panelGrafico.setMouseWheelEnabled(true);
					panelGrafico.setPreferredSize(new Dimension(381, 433));
					
					panel1.setLayout(new BorderLayout());
					panel1.add(panelGrafico, BorderLayout.NORTH);
					
					pack();
					repaint();
					
					setBounds(100, 100, 823, 648);
				}
			});
			btnGracicar.setBounds(708, 516, 68, 51);
			contentPane.add(btnGracicar);
			mostrarDatos();
		}
	}
