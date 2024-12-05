package Informes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.Menu;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InformeBoletaPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtInforme;
	private JList<String> opciones;
	private DefaultListModel<String> lista;
	private JPopupMenu popmenu;
	private JTextField txtNombre;
	
	ConexionInmujer conexion = new ConexionInmujer(); 
    Connection con = conexion.conectar();
	 public void boletadepago(String expediente) {
	        Document boleta = new Document();
	        String ruta = System.getProperty("user.home");

	        try {
	            PdfWriter writer = PdfWriter.getInstance(boleta, new FileOutputStream(ruta+"/BoletaDePago.pdf"));//ruta + "/Boleta_de_Pago.pdf"
	            boleta.open();

	            try {                
	                Image fondo = Image.getInstance("src/img/fondoInforme.gif");
	                PdfContentByte cb=writer.getDirectContentUnder();
	                fondo.setAbsolutePosition(0, 0);
	                fondo.scaleAbsolute(612,792);
	                cb.addImage(fondo);

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            
	            Paragraph espacio= new Paragraph("\n\n\n\n\n\n\n\n\n\n");
	            boleta.add(espacio);
	            
	            PdfPTable tabla = new PdfPTable(5);
	            tabla.setWidthPercentage(100);
	            com.itextpdf.text.Font font = FontFactory.getFont(("Centuary Gothic"), 9, Font.BOLD); 
	            PdfPCell cell = new PdfPCell(new Phrase("ID", font));
	            PdfPCell cell1 = new PdfPCell(new Phrase("NETO PAGADO", font));
	            PdfPCell cell2= new PdfPCell(new Phrase("FOLIO EXPEDIENTE", font));
	            PdfPCell cell3 = new PdfPCell(new Phrase("BENEFICIARIA", font));
	            PdfPCell cell4 = new PdfPCell(new Phrase("MES DE DISPERSION", font));
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	            tabla.addCell(cell);
	            tabla.addCell(cell1);
	            tabla.addCell(cell2);
	            tabla.addCell(cell3);
	            tabla.addCell(cell4);
	            tabla.setHorizontalAlignment(Element.ALIGN_CENTER + Element.ALIGN_BOTTOM); 
	            
	            
	            String sql = "SELECT * FROM boleta_de_pago WHERE id = ?";

	            try {
	            	PreparedStatement pst = con.prepareStatement(sql);
	            	 pst.setString(1, expediente);
	                 ResultSet rs = pst.executeQuery();

	                while (rs.next()) {
	                	
	                	PdfPCell id = new PdfPCell(new Phrase(String.valueOf(rs.getInt("id"))));
	                	id.setHorizontalAlignment(Element.ALIGN_CENTER);
	                	
	                	PdfPCell netopagado = new PdfPCell(new Phrase("$"+String.valueOf(rs.getDouble("Neto_Pagado"))));
	                    netopagado.setHorizontalAlignment(Element.ALIGN_CENTER);
	                    
	                    PdfPCell folioexpediente=new PdfPCell(new Phrase(String.valueOf(rs.getInt("Folio_Expediente"))));
	                    folioexpediente.setHorizontalAlignment(Element.ALIGN_CENTER);
	                    
	                    PdfPCell beneficiaria=new PdfPCell(new Phrase(rs.getString("Beneficiaria")));
	                    beneficiaria.setHorizontalAlignment(Element.ALIGN_CENTER);

	                    PdfPCell mesdispersion=new PdfPCell(new Phrase(String.valueOf(rs.getString("Mes_de_Dispercion"))));
	                    mesdispersion.setHorizontalAlignment(Element.ALIGN_CENTER);

	                    tabla.setHorizontalAlignment(Element.ALIGN_CENTER + Element.ALIGN_BOTTOM); 
	                    tabla.addCell(id);
	                    tabla.addCell(netopagado);
	                    tabla.addCell(folioexpediente);  
	                    tabla.addCell(beneficiaria);
	                    tabla.addCell(mesdispersion);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            boleta.add(tabla);

	            Paragraph espacios = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	            boleta.add(espacios);

	            Paragraph lineafirma = new Paragraph("__________________________________");
	            lineafirma.setAlignment(Element.ALIGN_CENTER);
	            boleta.add(lineafirma);

	            Paragraph firma = new Paragraph("FIRMA");
	            firma.setAlignment(Element.ALIGN_CENTER);
	            boleta.add(firma);

	            boleta.close();
	            conexion.conectar();

	            JOptionPane.showMessageDialog(null, "Informe generado");

	        } catch (FileNotFoundException | DocumentException e) {
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
					InformeBoletaPago frame = new InformeBoletaPago();
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
	public InformeBoletaPago() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel.setBounds(10, 86, 90, 79);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 823, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/intMujer.png")));
		lblNewLabel_2.setBounds(22, 0, 53, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/LG.png")));
		lblNewLabel_3.setBounds(736, 0, 66, 58);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("INFORME BOLETA DE PAGO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		//lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(323, 10, 195, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/encabezado2.png")));
		lblNewLabel_5.setBounds(10, 0, 803, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_1.setBounds(709, 89, 104, 89);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 582, 803, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/encabezado2.png")));
		lblNewLabel_6.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_8.setBounds(0, 450, 405, 134);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_9.setBounds(402, 450, 421, 134);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_10.setBounds(0, 348, 100, 92);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel_11.setBounds(723, 361, 90, 89);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7.setBounds(10, 168, 90, 209);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7_1.setBounds(719, 171, 90, 209);
		contentPane.add(lblNewLabel_7_1);
		
		txtInforme = new JTextField();
		txtInforme.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char digito = e.getKeyChar();
				if (Character.isLetter(digito)) {
					e.consume();
					JOptionPane.showMessageDialog(null, 
							"Solo se aceptan numeros en este campo",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtInforme.setBounds(350, 237, 141, 20);
		contentPane.add(txtInforme);
		txtInforme.setColumns(10);
		txtInforme.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				mostarNombre();
				popmenu.setVisible(false);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				mostarNombre();
				popmenu.setVisible(false);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				mostarNombre();
				popmenu.setVisible(false);
			}
		});
		
		
		JButton btnGenerar = new JButton("");
		btnGenerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String exp = txtInforme.getText().trim();
				String expediente= txtInforme.getText();
				if (txtInforme.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número","Error",JOptionPane.ERROR_MESSAGE);
				}
				if (!exp.isEmpty() && !verificarExpediente(exp)) {
					JOptionPane.showMessageDialog(null, "El expediente no se encuetra en la base de datos",
							"Error",JOptionPane.ERROR_MESSAGE);
					txtInforme.setText("");
				}else {
					boletadepago(expediente);
				}
			}
		});
		btnGenerar.setIcon(new ImageIcon(InformeBoletaPago.class.getResource("/img/generarPDF.png")));
		btnGenerar.setBounds(350, 261, 141, 34);
		contentPane.add(btnGenerar);
		
		JLabel lblNewLabel_12 = new JLabel("Ingrese el n\u00FAmero de expediente");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(320, 214, 196, 14);
		contentPane.add(lblNewLabel_12);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu ir = new Menu();
				ir.setVisible(true);
				ir.setLocationRelativeTo(null);
				dispose(); 
			}
		});
		btnRegresar.setBounds(116, 416, 116, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel_13 = new JLabel("Buscar por nombre");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(347, 332, 144, 14);
		contentPane.add(lblNewLabel_13);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(350, 357, 141, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lista = new DefaultListModel<>();
		opciones = new JList<>(lista);
		popmenu = new JPopupMenu();
		popmenu.add(new JScrollPane(opciones));
		popmenu.setFocusable(false);
		
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarOpciones();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarOpciones();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarOpciones();
			}
		});
		opciones.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String nombreUsuario = opciones.getSelectedValue();
					txtNombre.setText(nombreUsuario);
					String exp = obtenerEXP(nombreUsuario);
					txtInforme.setText(exp);
					popmenu.setVisible(false);
				}
			}
		});
		opciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 ) {
					String nombreUsuario = opciones.getSelectedValue();
					txtNombre.setText(nombreUsuario);
					String exp = obtenerEXP(nombreUsuario);
					txtInforme.setText(exp);
					popmenu.setVisible(false);
				}
			}
		});
	}
	private String obtenerEXP(String nombre) {
		String exp = "";
		String sql = "SELECT id FROM boleta_de_pago WHERE Beneficiaria LIKE ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				exp = rs.getString("id");
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exp;
	}
	
	private void actualizarOpciones() {
		String buscarTexto = txtNombre.getText().trim();
		if (buscarTexto.isEmpty()) {
			popmenu.setVisible(false);
			return;
		}
		List<String> opciones = obtenerOpcionesBaseDatos(buscarTexto);
		lista.clear();
		for (String opcion : opciones) {
			lista.addElement(opcion);
		}
		if (!opciones.isEmpty()) {
			popmenu.show(txtNombre, 0, txtNombre.getHeight());
		} else {
			popmenu.setVisible(true);
		}
	}
	private List<String> obtenerOpcionesBaseDatos(String buscarTexto){
		List<String> opciones = new ArrayList<>();
		String sql = "SELECT Beneficiaria FROM boleta_de_pago WHERE Beneficiaria LIKE ?";
		
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+buscarTexto+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				opciones.add(rs.getString("Beneficiaria"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opciones;
	}
	private void mostarNombre() {
		String exp = txtInforme.getText().trim();
		if (exp.isEmpty()) {
			txtNombre.setText("");
			return;
		}
		String nombre = obtenerNombre(exp);
		if (nombre.isEmpty()) {
			txtNombre.setText("");
		}else {
			txtNombre.setText(nombre);
		}
	}
	private String obtenerNombre(String exp) {
		String nombre = "";
		String sql = "SELECT Beneficiaria FROM boleta_de_pago WHERE id LIKE ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, exp);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				nombre = rs.getString("Beneficiaria");
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
	}
	private boolean verificarExpediente(String exp) {
		String sql = "SELECT COUNT(*) FROM boleta_de_pago WHERE id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, exp);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int datos = rs.getInt(1);
				return datos>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
