package GraficasPastel;

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
import org.jfree.data.general.DefaultPieDataset;

import ConexionBaseDeDatos.ConexionInmujer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ModalidadViolencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel1 = new JPanel();
	private JScrollPane scrollPane;
	private JTable tablaGrafica;
	
	public void mostrarDatos() {
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		
		String sql = "SELECT Modalidades_de_violencia, COUNT(Modalidades_de_violencia) AS total FROM datos GROUP BY Modalidades_de_violencia";
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Modalidades");
		modelo.addColumn("Total Casos");
		
		tablaGrafica.setModel(modelo);
		
		String[] baseDatos = new String[2];
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					baseDatos[0] = rs.getString("Modalidades_de_violencia");
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
					ModalidadViolencia frame = new ModalidadViolencia();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModalidadViolencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel1.setBounds(205, 11, 238, 354);
		contentPane.add(panel1);
		
		JButton btnGraficar = new JButton("");
		btnGraficar.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/GraficarPastel1.png")));
		btnGraficar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGraficar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/GraficarPastel2.png/")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGraficar.setIcon(new ImageIcon(ModalidadViolencia.class.getResource("/img/GraficarPastel1.png/")));
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
				
				
				int dato1 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(0, 1)));
				int dato2 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(1, 1)));
				int dato3 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(2, 1)));
				int dato4 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(3, 1)));
				int dato5 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(4, 1)));
				int dato6 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(5, 1)));
				int dato7 = Integer.parseInt(String.valueOf(tablaGrafica.getValueAt(6, 1)));
				
				DefaultPieDataset datos= new DefaultPieDataset();
				
				datos.setValue("Modalidad 1",dato1);
				datos.setValue("Modalidad 2",dato2);
				datos.setValue("Modalidad 3",dato3);
				datos.setValue("Modalidad 4",dato4);
				datos.setValue("Modalidad 5",dato5);
				datos.setValue("Modalidad 6",dato6);
				datos.setValue("Modalidad 7",dato7);
				
				JFreeChart grafico_pastel=ChartFactory.createPieChart("Modalidades de violencia", datos,true,true,false);
				ChartPanel panel = new ChartPanel(grafico_pastel);
				panel.setMouseWheelEnabled(true);
				panel.setPreferredSize(new Dimension(238, 354));
				
				panel1.setLayout(new BorderLayout());
				panel1.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
				setBounds(100, 100, 469, 415);
				
			}
		});
		btnGraficar.setBounds(94, 232, 61, 65);
		contentPane.add(btnGraficar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 185, 210);
		contentPane.add(scrollPane);
		
		tablaGrafica = new JTable();
		scrollPane.setViewportView(tablaGrafica);
		mostrarDatos();
	}
}


