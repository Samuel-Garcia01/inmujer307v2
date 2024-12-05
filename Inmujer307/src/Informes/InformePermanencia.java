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
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
	private JList<String> opciones;
	private DefaultListModel<String> lista;
	private JPopupMenu popmenu;
	private JTextField txtNombre;
	JTextArea Area = new JTextArea();
	ConexionInmujer conexion = new ConexionInmujer();
	Connection con = conexion.conectar();
	
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
    	//se crea el documento
    	Document reporte = new Document();
    	//se obtiene la ruta
    	String ruta = System.getProperty("user.home");
    	try {
    		//se utiliza para que se pueda codificar los elementos dentro del PDF
			PdfWriter writer =PdfWriter.getInstance(reporte, new FileOutputStream(ruta+"/CartaDePermanencia.pdf"));//ruta+"/Desktop/informe.pdf"
			//se abre el documento
			reporte.open();
			//se coloca la imagen de fondo
			Image foto = Image.getInstance("src/img/fondoInforme.gif");
			//se pone la escala del tamaño de la imagen
			foto.setAbsolutePosition(0,0);
			foto.scaleAbsolute(595,842);
			//es para añadir la imagen dentro del PDF	
			reporte.add(foto);
			
			//permite modificar el contenido del PDF 
			PdfContentByte canvas = writer.getDirectContent();
			//se define la letra y sus caracteristicas
			Font font=FontFactory.getFont(FontFactory.HELVETICA,13,Font.NORMAL); //letra color normal ,font
			//es para añadir una frase al documento
			Phrase frase = new Phrase("Tultitlán,Estado de México a "+obtenerFechaLarga(),font);
			//alinea textoi en columnas 
			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, frase, 370, 675, 0);// 370=es lo horizontal  del texto,675 lo alto el texto donde se pone,0 es la rotacion
			
			
			Font font1=FontFactory.getFont(FontFactory.HELVETICA,14,Font.BOLD);//en negrita la letra ,fon1
			
		    Phrase parrafo = new Phrase("Carta de Permanencia al",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo, 300, 650, 0);
		    
		    Phrase parrafo1 = new Phrase("Programa Social Seguro Violeta del",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo1, 300, 635, 0);
		    
		    Phrase parrafo2 = new Paragraph("Municipio de Tultitlán para el Ejercicio Fiscal 2024.",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, parrafo2, 300, 620, 0);
		    
		    
		    Phrase texto = new Paragraph("Con fundamento en la fracción X. Requisitos de Permanencia y XVI. Conformación",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto, 300, 580, 0);
		    
		    Phrase texto1 = new Paragraph("e Integración del Comité Dictaminador de las Reglas de Operación del Programa",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto1, 300, 565, 0);
		    
		    Phrase texto2 = new Paragraph("Social Seguro Violeta del Municipio de Tultitlán para el Ejercicio Fiscal 2024, hago",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto2, 300, 550, 0);
		    
		    Phrase texto3 = new Paragraph("mención que la BENEFICIARIA de nombre:",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, texto3, 300, 535, 0);
		    
		    Phrase nom = new Paragraph(nombre(),font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nom, 300, 495,0);
		    
		    Phrase linea = new Paragraph("_________________________________________________________",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, linea, 300, 480, 0);
		    
		    Phrase ben = new Paragraph("(Nombre de la Beneficiara)",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, ben, 300, 460, 0);
		    
		    
		    Phrase text = new Paragraph("Continúa como BENEFICIARIA del Programa Social Seguro Violeta del",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text, 300, 420, 0);
		    
		    Phrase text1 = new Paragraph("Municipio de Tultitlán para el Ejercicio Fiscal 2024, por lo que debe seguir",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text1, 300, 405, 0);
		    
		    Phrase text2 = new Paragraph("cumpliendo con lo estipulado en la fracción X. Requisitos de Permanencia.",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, text2, 300, 390, 0);
		    
		    
		    Phrase frase2 = new Phrase("ATENTAMENTE",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, frase2, 300, 350, 0);
		    
		    Phrase linea1 = new Paragraph("_____________________________________________",font);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, linea1, 300, 270, 0);
		    
		    Phrase nombre = new Paragraph("DULCE IVON ROSAS GODÍNES",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre, 300, 255, 0);
		    
		    Phrase nombre1 = new Paragraph("JEFA DEL DEPARTAMENTO DE",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre1, 300, 240, 0);
		    
		    Phrase nombre2 = new Paragraph("ATENCIÓN A LA VIOLENCIA DE GÉNERO",font1);
		    ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, nombre2, 300, 225, 0);
		    
		    Phrase nombre3 = new Paragraph("Y PRESIDENTA DEL COMITÉ DICTAMINADOR",font1);
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
		
		Area.setLineWrap(true);
		Area.setWrapStyleWord(true);
		Area.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(Area);
		scrollPane.setBounds(347, 131, 352, 118);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_12 = new JLabel("Ingrese el n\u00FAmero de expediente");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(150, 106, 196, 14);
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
		txtInforme.setBounds(180, 131, 141, 20);
		contentPane.add(txtInforme);
		txtInforme.setColumns(10);
		
		txtInforme.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				mostrarCaso();
				mostarNombre();
				popmenu.setVisible(false);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				mostrarCaso();
				mostarNombre();
				popmenu.setVisible(false);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				mostrarCaso();
				mostarNombre();
				popmenu.setVisible(false);
			}
		});
		
		JButton btngenerar = new JButton("");
		btngenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp = txtInforme.getText().trim();
				String id= "";
				id = (txtInforme.getText());
				if (txtInforme.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número","Error",JOptionPane.ERROR_MESSAGE);
				}
				if(!exp.isEmpty() && !verificarExpediente(exp)) {
					JOptionPane.showMessageDialog(null, "El expediente no se encuetra en la base de datos",
							"Error",JOptionPane.ERROR_MESSAGE);
					txtInforme.setText("");
				}else {
				String sql ="SELECT*FROM datos WHERE EXP= ?";
				
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, id);
					
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
					     nombre = rs.getString("Nombre_de_la_victima");
						generarinforme();
						
						JOptionPane.showMessageDialog(null, "Informe generado");
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
		btngenerar.setBounds(347, 361, 141, 34);
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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(180, 193, 141, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Buscar por nombre");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(177, 168, 144, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Caso de la persona");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(347, 106, 352, 14);
		contentPane.add(lblNewLabel_15);
		
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
		String sql = "SELECT EXP FROM datos WHERE Nombre_de_la_victima LIKE ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				exp = rs.getString("EXP");
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exp;
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
		String sql = "SELECT Nombre_de_la_victima FROM datos WHERE EXP LIKE ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, exp);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				nombre = rs.getString("Nombre_de_la_victima");
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
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
		String sql = "SELECT Nombre_de_la_victima FROM datos WHERE Nombre_de_la_victima LIKE ?";
		
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+buscarTexto+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				opciones.add(rs.getString("Nombre_de_la_victima"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opciones;
	 }
		private String obtenerCaso(String exp) {
			String caso= "";
			String sql = "SELECT Hechos_y_motivos_de_la_atencion FROM datos WHERE EXP LIKE ?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, exp);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					caso = rs.getString("Hechos_y_motivos_de_la_atencion");
					if (caso == null) {
						caso = "No se encontraron datos";
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return caso;
		}
		private void mostrarCaso() {
			String exp = txtInforme.getText().trim();
			if (exp.isEmpty()) {
				Area.setText("");
				return;
			}
			String caso = obtenerCaso(exp);
			if (!caso.isEmpty()) {
				Area.setText(caso);
			}else {
				Area.setText("No se encontraron datos");
			}
	}
		private boolean verificarExpediente(String exp) {
			String sql = "SELECT COUNT(*) FROM datos WHERE EXP = ?";
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