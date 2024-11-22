package Informes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.Menu;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InformePermanencia extends JFrame {

	private JPanel contentPane;
	Calendar datos = new GregorianCalendar();
	private String dia = String.valueOf(datos.get(Calendar.DATE));
	private String diaSemana = String.valueOf(datos.get(Calendar.DAY_OF_WEEK)-1);
	private String mes = String.valueOf(datos.get(Calendar.MONTH)+1);
	private String anio = String.valueOf(datos.get(Calendar.YEAR));
	private String fechaLarga = "";
	String nombre = "";
	private JTextField txtInforme;
	
	public String nombre() {
		String nombrecompleto = nombre;
		return nombrecompleto;
		
		}
	
	public String obtenerFechaLarga() {
		//Obtener la fecha larga, ejemplo <viernes 04 de octubre de 2024>
		String d = ""; //Se almacena el dia de la semana (lunes-domingo)
		String date = ""; //Se almacena el día del mes (1-31)
		String m = ""; //Se almacena el nombre del mes (enero a Diciembre)
		
		if (dia.length()==1) {
			date = "0"+dia;
		} else {
			date = dia;
		}
		
		if (diaSemana.equals("1")) {
			d = "lunes";
		}else if (diaSemana.equals("2")) {
			d = "martes";
		}else if (diaSemana.equals("3")) {
			d = "miercoles";
		}else if (diaSemana.equals("4")) {
			d = "jueves";
		}else if (diaSemana.equals("5")) {
			d = "viernes";
		}else if (diaSemana.equals("6")) {
			d = "sabado";
		}else if (diaSemana.equals("7")) {
			d = "domingo";
		}
		
		if (mes.equals("1")) {
			m = "enero";
		}else if (mes.equals("2")) {
			m = "febrero";
		}else if (mes.equals("3")) {
			m = "marzo";
		}else if (mes.equals("4")) {
			m = "abril";
		}else if (mes.equals("5")) {
			m = "mayo";
		}else if (mes.equals("6")) {
			m = "junio";
		}else if (mes.equals("7")) {
			m = "julio";
		}else if (mes.equals("8")) {
			m = "agosto";
		}else if (mes.equals("9")) {
			m = "septiembre";
		}else if (mes.equals("10")) {
			m = "octubre";
		}else if (mes.equals("11")) {
			m = "noviembre";
		}else if (mes.equals("12")) {
			m = "diciembre";
		}
		
		fechaLarga =   date + " de " + m + " de " + anio;
		
		return fechaLarga;
	}
    public void generarinforme() {
    	Document reporte = new Document();
    	
    	String ruta = System.getProperty("user.home");
    	try {
			PdfWriter writer =PdfWriter.getInstance(reporte, new FileOutputStream(ruta+"/desktop/informePermanencia.pdf"));//ruta+"/Desktop/informe.pdf"
			
			reporte.open();
			
			Image foto = Image.getInstance("src/img/informe1.1.png");
			foto.scaleToFit(600,1000);
			foto.setAlignment(Element.ALIGN_CENTER);
			reporte.add(foto);
			
			PdfContentByte canvas = writer.getDirectContent();
			
			Font font=FontFactory.getFont(FontFactory.HELVETICA,13,Font.NORMAL); //letra color normal ,font
			
			Phrase frase = new Phrase("Tultitlan,Estado de Mexico a "+obtenerFechaLarga(),font);
			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, frase, 370, 675, 0);// 370=es lo horizontal  del texto,675 lo alto el texto donde se pone,0 es la rotacion
			
			
			Font font1=FontFactory.getFont(FontFactory.HELVETICA,14,Font.BOLD);//en negrita la letra ,fon1
			
		    Phrase parrafo = new Phrase("Carta de permanencia al",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo, 300, 650, 0);
		    
		    Phrase parrafo1 = new Phrase("Programa Social Seguro Violeta del",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo1, 300, 635, 0);
		    
		    Phrase parrafo2 = new Paragraph("Municipio de Tultitlan para el Ejercicio Fiscal 2024.",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo2, 300, 620, 0);
		    
		    
		    Phrase texto = new Paragraph("Con fundamento en la fracci�n X. Requisitos de Permanencia y XVI. Conformaci�n",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto, 300, 580, 0);
		    
		    Phrase texto1 = new Paragraph("e Integraci�n del Comit� Dictaminador de las Reglas de Operaci�n del Programa",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto1, 300, 565, 0);
		    
		    Phrase texto2 = new Paragraph("Social Seguro Violeta del Municipio de Tultitl�n para el Ejercicio Fiscal 2024, hago",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto2, 300, 550, 0);
		    
		    Phrase texto3 = new Paragraph("menci�n que la BENEFICIARIA de nombre:",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto3, 300, 535, 0);
		    
		    Phrase nom = new Paragraph(nombre(),font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nom, 300, 495,0);
		    
		    Phrase linea = new Paragraph("_________________________________________________________",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, linea, 300, 480, 0);
		    
		    Phrase ben = new Paragraph("(Nombre de la Beneficiara)",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, ben, 300, 460, 0);
		    
		    
		    Phrase text = new Paragraph("Contin�a como BENEFICIARIA del Programa Social Seguro Violeta del",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text, 300, 420, 0);
		    
		    Phrase text1 = new Paragraph("Municipio de Tultitl�n para el Ejercicio Fiscal 2024, por lo que debe seguir",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text1, 300, 405, 0);
		    
		    Phrase text2 = new Paragraph("cumpliendo con lo estipulado en la fracci�n X. Requisitos de Permanencia.",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text2, 300, 390, 0);
		    
		    
		    Phrase frase2 = new Phrase("ATENTAMENTE",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, frase2, 300, 350, 0);
		    
		    Phrase linea1 = new Paragraph("_____________________________________________",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, linea1, 300, 270, 0);
		    
		    Phrase nombre = new Paragraph("DULCE IVON ROSAS GOD�NES",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre, 300, 255, 0);
		    
		    Phrase nombre1 = new Paragraph("JEFA DEL DEPARTAMENTO DE",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre1, 300, 240, 0);
		    
		    Phrase nombre2 = new Paragraph("ATENCI�N A LA VIOLENCIA DE G�NERO",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre2, 300, 225, 0);
		    
		    Phrase nombre3 = new Paragraph("Y PRESIDENTA DEL COMITE DICTAMINADOR",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre3, 300, 210, 0);
		    
		    
		    
			
			reporte.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
					InformePermanencia frame = new InformePermanencia();
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
	public InformePermanencia() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel.setBounds(10, 86, 90, 79);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 823, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/intMujer.png")));
		lblNewLabel_2.setBounds(22, 0, 53, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/LG.png")));
		lblNewLabel_3.setBounds(736, 0, 66, 58);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("INFORME PERMANENCIA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		//lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(323, 10, 195, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/encabezado2.png")));
		lblNewLabel_5.setBounds(10, 0, 803, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_1.setBounds(709, 89, 104, 89);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 582, 803, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/encabezado2.png")));
		lblNewLabel_6.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_8.setBounds(0, 450, 405, 134);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_9.setBounds(402, 450, 421, 134);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_10.setBounds(0, 348, 100, 92);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel_11.setBounds(723, 361, 90, 89);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7.setBounds(10, 168, 90, 209);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7_1.setBounds(719, 171, 90, 209);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_12 = new JLabel("Ingrese el n\u00FAmero de expediente");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(321, 213, 205, 14);
		contentPane.add(lblNewLabel_12);
		
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
		
		JButton btngenerar = new JButton("");
		btngenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id= "";
				id = (txtInforme.getText());
				if ((txtInforme.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un n�mero","Error",JOptionPane.ERROR_MESSAGE);
				}else {
				String sql ="SELECT*FROM datos WHERE EXP= ?";
				ConexionInmujer conexion = new ConexionInmujer();
				Connection con = conexion.conectar();
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, id);
					
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
					     nombre = rs.getString("Nombre_de_la_victima");
						generarinforme();
						
						JOptionPane.showMessageDialog(null, "informe generado");
					}else {
						JOptionPane.showMessageDialog(null, "no se encontro");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
			
		});
		btngenerar.setIcon(new ImageIcon(InformePermanencia.class.getResource("/img/generarPDF.png")));
		btngenerar.setBounds(350, 263, 141, 34);
		contentPane.add(btngenerar);
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
	}
}
