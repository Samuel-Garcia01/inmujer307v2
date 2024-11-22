package GraficaBarras;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Efectos_Patrimoniales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaGrafica2;

		
	public void mostrarDatos2() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Efectos_economicos_y_patrimoniales, COUNT(Efectos_economicos_y_patrimoniales) AS total FROM datos GROUP BY Efectos_economicos_y_patrimoniales";
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Efectos");
		modelo.addColumn("Total Casos");
		
		tablaGrafica2.setModel(modelo);
		
		String[] baseDatos = new String[2];
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					baseDatos[0] = rs.getString("Efectos_economicos_y_patrimoniales");
					baseDatos[1] = rs.getString("total");
					
					modelo.addRow(baseDatos);
				} while (rs.next());
				tablaGrafica2.setModel(modelo);
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
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 261, 158);
		contentPane.add(scrollPane);
		
		tablaGrafica2 = new JTable();
		scrollPane.setViewportView(tablaGrafica2);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 159, 261, 182);
		contentPane.add(panel2);
		
		JButton btnGraficar = new JButton("New button");
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String et11 = tablaGrafica2.getValueAt(0, 0).toString();
				String et22 = tablaGrafica2.getValueAt(1, 0).toString();
				String et33 = tablaGrafica2.getValueAt(2, 0).toString();
				String et44 = tablaGrafica2.getValueAt(3, 0).toString();
				String et5= tablaGrafica2.getValueAt(4, 0).toString();
				String et6= tablaGrafica2.getValueAt(5, 0).toString();
				String et7= tablaGrafica2.getValueAt(6, 0).toString();
				String et8= tablaGrafica2.getValueAt(7, 0).toString();
				
				int DejoEstudiar=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(0, 1)));
				int NoPensionAlimenticia=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(1, 1)));
				int Nogastos=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(2, 1)));
				int Chantaje=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(3, 1)));
				int PerdidaPropiedades=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(4, 1)));
				int quema=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(5, 1)));
				int Salir=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(6, 1)));
				int Noaplica2=Integer.parseInt(String.valueOf(tablaGrafica2.getValueAt(7, 1)));
				
				DefaultCategoryDataset datos2= new DefaultCategoryDataset();
				
				datos2.setValue(DejoEstudiar, "1", "");
				datos2.setValue(NoPensionAlimenticia, "2", "");
				datos2.setValue(Nogastos, "3", "");
				datos2.setValue(Chantaje, "4", "");
				datos2.setValue(PerdidaPropiedades, "5", "");
				datos2.setValue(quema, "6", "");
				datos2.setValue(Salir, "7", "");
				datos2.setValue(Noaplica2, "8", "");
				
				JFreeChart grafico_barras2 = ChartFactory.createBarChart3D("Economicos", "Efectos", "Victimas", datos2, PlotOrientation.VERTICAL,true,true,false);
				ChartPanel paneldos = new ChartPanel(grafico_barras2);
				paneldos.setMouseWheelEnabled(true);
				paneldos.setPreferredSize(new Dimension(236, 219));
				
				panel2.setLayout(new BorderLayout());
				panel2.add(paneldos,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 488, 525);
			}
		});
		btnGraficar.setBounds(296, 264, 89, 23);
		contentPane.add(btnGraficar);
		mostrarDatos2();
	}
}
