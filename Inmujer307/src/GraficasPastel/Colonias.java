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
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.menuGraficas;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Colonias extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JPanel panel_3 = new JPanel();

	public void colonias() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		String sql="SELECT Colonia, COUNT(Colonia) AS total FROM datos GROUP BY Colonia ORDER BY total DESC LIMIT 10";
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Colonias");
		modelo.addColumn("Total Casos");
		
		table.setModel(modelo);
		String []baseDatos= new String [3];
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			if (rs.next()) {
				
				 do {
					 baseDatos[0] = rs.getString("Colonia");
					 baseDatos[1] = rs.getString("total");
						
					 modelo.addRow(baseDatos);
				} while (rs.next());
				 table.setModel(modelo);
			} else {
				System.out.println("No hay registro");
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
					Colonias frame = new Colonias();
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
	public Colonias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 163, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Colonias.class.getResource("/img/encabezadografic.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 58, 316, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 296, 308);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		btnNewButton.setBounds(82, 473, 133, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Colonias.class.getResource("/img/inmujer.png")));
		lblNewLabel_8.setBounds(0, 0, 316, 508);
		panel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(79, 0, 79));
		panel_2.setBounds(310, 566, 509, 45);
		contentPane.add(panel_2);
		
		
		panel_3.setBackground(new Color(255, 213, 255));
		panel_3.setBounds(374, 84, 381, 433);
		contentPane.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("GRAFICAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultPieDataset datos= new DefaultPieDataset();
				int nflias = table.getRowCount();
				for (int i = 0; i < nflias; i++) {
					String et = table.getValueAt(i, 0).toString();
					int dato = Integer.parseInt(String.valueOf(table.getValueAt(i, 1)));
					datos.setValue("Colonia No. "+(i+1),dato);
					
				}
				JFreeChart grafico_pastel=ChartFactory.createPieChart(
						"Colonias con mayor indice de Incidentes",
						datos,
						true,
						true,
						false
						);
				
				ChartPanel panelGrafico = new ChartPanel(grafico_pastel);
				panelGrafico.setMouseWheelEnabled(true);
				panelGrafico.setPreferredSize(new Dimension(381, 433));
				
				panel_3.setLayout(new BorderLayout());
				panel_3.add(panelGrafico, BorderLayout.NORTH);
				
				pack();
				repaint();
				
				setBounds(100, 100, 823, 648);
				setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(186, 85, 211));
		btnNewButton_1.setBounds(511, 528, 133, 23);
		contentPane.add(btnNewButton_1);
		colonias();
	}
}
