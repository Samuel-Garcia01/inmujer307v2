package Informes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
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
import java.util.List;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;

import com.itextpdf.text.BaseColor;
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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.Menu;



public class InformeSeguroVioleta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInforme;
	private JList<String> opciones;
	private DefaultListModel<String> lista;
	private JPopupMenu popmenu;
	private JTextField txtNombre;
	JTextArea Area = new JTextArea();

	ConexionInmujer conexion = new ConexionInmujer();
	Connection con = conexion.conectar();
	
	
	public void generarInformeSeguroVioleta(String expediente) {
		Document seguro_violeta = new Document();
		String ruta = System.getProperty("user.home");
		PdfWriter writter;
		
				
			try {
				writter = PdfWriter.getInstance(seguro_violeta, new FileOutputStream(ruta+"/desktop/SeguroVioleta.pdf"));
					
				seguro_violeta.open();
				PdfContentByte cb = writter.getDirectContentUnder();
					
				Image fondo = Image.getInstance("src/img/fondoInforme.gif");
				fondo.setAbsolutePosition(0,0);
				fondo.scaleAbsolute(595,842);
				cb.addImage(fondo);
					
				Font letra_pequenia = new Font(FontFactory.getFont("Century Gothic",9,Font.NORMAL,BaseColor.BLACK));
				Font letra_blanca = new Font(FontFactory.getFont("Century Gothic",9,Font.NORMAL,BaseColor.WHITE));
					
				Paragraph titulo = new Paragraph();
				titulo.setAlignment(Paragraph.ALIGN_CENTER);
				titulo.setFont(FontFactory.getFont("Century Gothic", 10, Font.BOLD,BaseColor.BLACK));
				titulo.add("\n\n\n\n\nESTUDIO SOCIECONOMICO DEL 'SEGURO VIOLETA. PARA EL EJERCICIO FISCAL 2024'");
				titulo.setIndentationLeft(110);
				titulo.setIndentationRight(110);
				
				PdfPTable tabla1 = new PdfPTable(1);
				tabla1.setSpacingBefore(10f);
				tabla1.setWidthPercentage(50);
				tabla1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				
				String sql = "SELECT *FROM seguro_violeta WHERE EXP = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, expediente);
			    ResultSet rs = pst.executeQuery();
				 while(rs.next()) {
					PdfPCell celda1 = new PdfPCell(new Phrase("MES: "+rs.getString("MES"),letra_pequenia));
					PdfPCell celda2 = new PdfPCell(new Phrase("EXPEDIENTE: "+String.valueOf(rs.getInt("EXP")),letra_pequenia));
					tabla1.addCell(celda1);
					tabla1.addCell(celda2);
				}
					 
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Nombre_de_la_victima"),letra_pequenia),
					103, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________________",letra_pequenia),
					37, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Nombre Completo",letra_pequenia),
					70, 625, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Fecha_de_nacimiento"),letra_pequenia),
					225, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________",letra_pequenia),
					185, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Fecha de Nacimiento",letra_pequenia),
					185, 625, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Edad"),letra_pequenia),
					300, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________",letra_pequenia),
					285, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Edad",letra_pequenia),
					295, 625, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Grado_de_Estudios"),letra_pequenia),
					375, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________________",letra_pequenia),
					338, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Grado de Estudios",letra_pequenia),
					338, 625, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Estado_Civil"),letra_pequenia),
					464, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("_____________",letra_pequenia),
					433, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Estado Civil",letra_pequenia),
					442, 625, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Ocupacion"),letra_pequenia),
					538, 640, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("____________",letra_pequenia),
					510, 635, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Ocupación",letra_pequenia),
					518, 625, 0);
					
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Calle")+" "+rs.getInt("Numero_calle")+" "+
					rs.getString("Colonia")+" "+rs.getString("Municipio"),letra_pequenia),
					145, 600, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("_________________________________________",letra_pequenia),
					37, 595, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Calle",letra_pequenia),
					52, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Número",letra_pequenia),
					97, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Colonia",letra_pequenia),
					152, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Municipio",letra_pequenia),
					208, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Codigo_postal"),letra_pequenia),
					275, 600, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("____________",letra_pequenia),
					260, 595, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Código Postal",letra_pequenia),
					260, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Telefono_Celular"),letra_pequenia),
					345, 600, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("_____________",letra_pequenia),
					337, 595, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Teléfono Celular",letra_pequenia),
					337, 585, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(rs.getString("Contacto_Emergencia"),letra_pequenia),
					490, 600, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("____________________________",letra_pequenia),
					420, 595, 0);
					ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Contacto de Emergencia",letra_pequenia),
					439, 585, 0);
				}
				
				PdfPTable tabla2 = new PdfPTable(6);
				tabla2.setSpacingBefore(90);
				tabla2.setWidthPercentage(100);
				tabla2.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					//Necesita datos
					String vivienda = rs.getString("Vivienda")!=null ? rs.getString("Vivienda"): "";
					String personasViviendo = rs.getInt("No_Personas")>0 ? String.valueOf(rs.getInt("No_Personas")): "";
					String estadoSalud = rs.getString("Estado_de_salud") !=null ? rs.getString("Estado_de_salud"): "";
					String tipoDeVivienda = rs.getString("Tipo_Vivienda") !=null ? rs.getString("Tipo_Vivienda"): "";
					String denuncia =rs.getString("Denuncia_y/o_demanda")!=null ? rs.getString("Denuncia_y/o_demanda"): "";
					String estructuraFamiliar= rs.getString("Estructura_familiar")!=null ? rs.getString("Estructura_familiar"): "";
					
					
					PdfPCell Vivienda = new PdfPCell(new Phrase("Vivienda: "+vivienda,letra_pequenia));
					PdfPCell PersonasViviendo = new PdfPCell(new  Phrase("Número de personas que iven en el domicilio: "+personasViviendo,letra_pequenia));
					PdfPCell EstadoSalud = new PdfPCell(new Phrase("Estado de Salud: "+estadoSalud,letra_pequenia));
					PdfPCell TipoDeVivienda = new PdfPCell(new Phrase("Tipo de Vivienda"+tipoDeVivienda,letra_pequenia));
					PdfPCell DenunciaODemanda = new PdfPCell(new Phrase("Denuncia(número) y/o Demanda(tipo): "+denuncia,letra_pequenia));
					PdfPCell Estructura_Familiar =new PdfPCell(new Phrase("Estructura familiar/Edad/Ocupación o Escolaridad/Parentesco",letra_pequenia));
					PdfPCell EstructuraFamiliar =new PdfPCell(new Phrase(estructuraFamiliar,letra_pequenia));
					
					Vivienda.setColspan(3);
					tabla2.addCell(Vivienda);
					PersonasViviendo.setColspan(3);
					tabla2.addCell(PersonasViviendo);
					EstadoSalud.setColspan(3);
					tabla2.addCell(EstadoSalud);
					TipoDeVivienda.setColspan(3);
					tabla2.addCell(TipoDeVivienda);
					DenunciaODemanda.setColspan(6);
					tabla2.addCell(DenunciaODemanda);
					Estructura_Familiar.setColspan(6);
					tabla2.addCell(Estructura_Familiar);
					EstructuraFamiliar.setColspan(6);
					tabla2.addCell(EstructuraFamiliar);
					
				}
				PdfPTable tabla3 = new PdfPTable(2);
				tabla3.setWidthPercentage(100);
				tabla3.setSpacingBefore(5);
				tabla3.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String tipoDeViolencia = rs.getString("Tipos_Violencia")!=null ? rs.getString("Tipos_Violencia"): "";
					String modalidadesDeViolencia = rs.getString("Modalidades_Violencia")!=null ? rs.getString("Modalidades_Violencia"): "";				
					
					PdfPCell violencia = new PdfPCell(new Phrase("TIPOS DE VIOLENCIA",letra_blanca));
					violencia.setBackgroundColor(BaseColor.BLACK);
					violencia.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell modalidad = new PdfPCell(new Phrase("MODALIDADES DE LA VIOLENCIA",letra_blanca)); 
					modalidad.setBackgroundColor(BaseColor.BLACK);
					modalidad.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell tipo_de_violencia = new PdfPCell(new Phrase(" "+tipoDeViolencia,letra_pequenia));
					PdfPCell modalidad_de_violencia = new PdfPCell(new Phrase(" "+modalidadesDeViolencia,letra_pequenia));
					
					tabla3.addCell(violencia);
					tabla3.addCell(modalidad);
					tabla3.addCell(tipo_de_violencia);
					tabla3.addCell(modalidad_de_violencia);
				}
				PdfPTable tabla4 = new PdfPTable(1);
				tabla4.setWidthPercentage(100);
				tabla4.setSpacingBefore(5);
				tabla4.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String Descripcion = rs.getString("Descripcion_Hechos_UltimoEpisodio_Violencia")!=null ? rs.getString("Descripcion_Hechos_UltimoEpisodio_Violencia"): "";
					String nivelRiesgo = rs.getString("Nivel_Riesgo")!=null ? rs.getString("Nivel_Riesgo"): "";
					
					PdfPCell hechos = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS HECHOS DEL ÚLTIMO EPISODIO DE VIOLENCIA",letra_blanca));
					hechos.setBackgroundColor(BaseColor.BLACK);
					hechos.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell descripcion_hechos = new PdfPCell(new Phrase(" "+Descripcion,letra_pequenia));
					PdfPCell nivel_de_riesgo = new PdfPCell(new Phrase("Nivel de Riesgo: "+nivelRiesgo,letra_pequenia));
					
					tabla4.addCell(hechos);
					tabla4.addCell(descripcion_hechos);
					tabla4.addCell(nivel_de_riesgo);
				}
				
				Paragraph exclusivo = new Paragraph();
				exclusivo.setAlignment(Paragraph.ALIGN_CENTER);
				exclusivo.setFont(FontFactory.getFont("Century Gothic", 7, Font.BOLD,BaseColor.BLACK));
				exclusivo.add("\n\n\n\n\nPARA LLENADO EXCLUSIVO DEL PERSONAL DEL INSTITUTO MUNICIPAL DE LA MUJER TULTITLAN");
				
				PdfPTable tabla5 = new PdfPTable(4);
				tabla5.setWidthPercentage(100);
				tabla5.setSpacingBefore(5);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String datosAgresor = rs.getString("Nombre_Agresor")!=null ? rs.getString("Nombre_Agresor"): "";
					String edadAgresor = rs.getInt("Edad_Agresor")>0 ? String.valueOf(rs.getInt("Edad_Agresor")): "";
					String relacionVinculo = rs.getString("Relacion_Vinculo_Agresor")!=null ? rs.getString("Relacion_Vinculo_Agresor"): "";
					String domicilioCompleto = rs.getString("Domicilio_Agresor")!=null ? rs.getString("Domicilio_Agresor"): "";
					String ocupacionAgresor = rs.getString("Ocupacion_Agresor")!=null ? rs.getString("Ocupacion_Agresor"): "";
					
					PdfPCell agresor = new PdfPCell(new Phrase("DATOS DE LA PERSONA GENERADORA DE VIOLENCIA",letra_blanca));
					agresor.setColspan(4);
					agresor.setBackgroundColor(BaseColor.BLACK);
					agresor.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell nombre = new PdfPCell(new Phrase("Nombre Completo: "+datosAgresor,letra_pequenia));
					PdfPCell edad = new PdfPCell(new Phrase("Edad: "+edadAgresor,letra_pequenia));
					PdfPCell relacion = new PdfPCell(new Phrase("Relación o Vínculo: "+relacionVinculo,letra_pequenia));
					PdfPCell domicilio = new PdfPCell(new Phrase("Domicilio Completo: "+domicilioCompleto,letra_pequenia));
					PdfPCell ocupacion = new PdfPCell(new Phrase("Ocupación: "+ocupacionAgresor,letra_pequenia));
					
					tabla5.addCell(agresor);
					nombre.setColspan(2);
					tabla5.addCell(nombre);
					edad.setColspan(1);
					tabla5.addCell(edad);
					relacion.setColspan(1);
					tabla5.addCell(relacion);
					domicilio.setColspan(2);
					tabla5.addCell(domicilio);
					ocupacion.setColspan(2);
					tabla5.addCell(ocupacion);
					
				}
				
				PdfPTable tabla6 = new PdfPTable(3);
				tabla6.setWidthPercentage(100);
				tabla6.setSpacingBefore(5);
				tabla6.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String efectosFisicos = rs.getString("Efectos_fisicos") !=null ? rs.getString("Efectos_fisicos"): "";
					String efectosPsicologicos = rs.getString("Efectos_Psicologicos") !=null ? rs.getString("Efectos_Psicologicos"): "";
					String efectosSexuales = rs.getString("Efectos_sexuales")!=null ? rs.getString("Efectos_sexuales"): "";
					String efectosEco = rs.getString("Economicos_Patrimoniales_Vicarios") !=null ? rs.getString("Economicos_Patrimoniales_Vicarios"): "";
					
					PdfPCell efectos = new PdfPCell(new Phrase("EFECTOS DE LA VIOLENCIA",letra_blanca));
					efectos.setBackgroundColor(BaseColor.BLACK);
					efectos.setColspan(3);
					efectos.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell e_fisicos = new PdfPCell(new Phrase("                           Fisícos: \n"+
					efectosFisicos,letra_pequenia));
					PdfPCell e_psicologicos = new PdfPCell(new Phrase("                       Psicológicos: \n"+
					efectosPsicologicos,letra_pequenia));
					PdfPCell e_sexuales = new PdfPCell(new Phrase("                          Sexuales: \n"+
					efectosSexuales,letra_pequenia));
					PdfPCell economicos_patrimonoales = new PdfPCell(new Phrase("Económicos, Patrimoniales y Vicarios\n"+
					efectosEco,letra_pequenia));
					economicos_patrimonoales.setColspan(3);
					
					tabla6.addCell(efectos);
					tabla6.addCell(e_fisicos);
					tabla6.addCell(e_psicologicos);
					tabla6.addCell(e_sexuales);
					tabla6.addCell(economicos_patrimonoales);
				}
				PdfPTable tabla7 = new PdfPTable(1);
				tabla7.setWidthPercentage(100);
				tabla7.setSpacingBefore(5);
				tabla7.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String redesDeApoyo = rs.getString("Redes_Apoyo")!=null ? rs.getString("Redes_Apoyo"): "";
					
					PdfPCell redes = new PdfPCell(new Phrase("REDES DE APOYO",letra_blanca));
					redes.setBackgroundColor(BaseColor.BLACK);
					redes.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell redes_de_apoyo = new PdfPCell(new Phrase(""+redesDeApoyo,letra_pequenia));
					
					tabla7.addCell(redes);
					tabla7.addCell(redes_de_apoyo);
				}
				PdfPTable tabla8 = new PdfPTable(2);
				tabla8.setWidthPercentage(100);
				tabla8.setSpacingBefore(5);
				tabla8.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String ingresosMensuales = rs.getString("Ingresos_Mensuales")!=null ? rs.getString("Ingresos_Mensuales"): "";
					String egresosMensuales = rs.getString("Egresos_Mensuales")!=null ? rs.getString("Egresos_Mensuales"): "";
					
					PdfPCell situacionEco = new PdfPCell(new Phrase("SITUACIÓN ECONÓMICA",letra_blanca));
					situacionEco.setColspan(2);
					situacionEco.setBackgroundColor(BaseColor.BLACK);
					situacionEco.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell IngresosEco = new PdfPCell(new Phrase("INGRESOS MENSUALES",letra_pequenia));
					IngresosEco.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell EgresosEco = new PdfPCell(new Phrase("EGRESOS MENSUALES",letra_pequenia));
					EgresosEco.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell ingresos_mensuales = new PdfPCell(new Phrase(""+ingresosMensuales,letra_pequenia));
					PdfPCell egresos_mensuales = new PdfPCell(new Phrase(""+egresosMensuales,letra_pequenia));
					
					tabla8.addCell(situacionEco);
					tabla8.addCell(IngresosEco);
					tabla8.addCell(EgresosEco);
					tabla8.addCell(ingresos_mensuales);
					tabla8.addCell(egresos_mensuales);
				}
				PdfPTable tabla9 = new PdfPTable(1);
				tabla9.setWidthPercentage(100);
				tabla9.setSpacingBefore(5);
				tabla9.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
				pst.setString(1, expediente);
				rs = pst.executeQuery();
				while (rs.next()) {
					String diagnosticoSocial = rs.getString("Diagnostico_Social") !=null ? rs.getString("Diagnostico_Social"): "";
					
					PdfPCell diagnostico = new PdfPCell(new Phrase("DIAGNOSTICO SOCIAL",letra_blanca));
					diagnostico.setBackgroundColor(BaseColor.BLACK);
					diagnostico.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell diagnostico_social = new PdfPCell(new Phrase(" "+diagnosticoSocial,letra_pequenia));
					
					tabla9.addCell(diagnostico);
					tabla9.addCell(diagnostico_social);
				}
				Font font = FontFactory.getFont(("Century Gothic"),8, Font.NORMAL); 
				 Paragraph avisodeprivacidad = new Paragraph("AVISO DE PRIVACIDAD: Con fundamento en lo dispuesto por los Artículos 3,"
				 		+ "fracción IX,6 y 143 de la Ley de Transparencia y Acceso a la Información Pública del Estado de México y "
				 		+ "Municipios, Articulo 6,15,29 y 32 de la Ley de Protección de Datos Personales en "
				 		+ "Posesión de Sujetos Obligados del Estado de México y Municipios y demás relativos aplicables, los datos "
				 		+ "recabados en la presente cedula serán utilizados con fines estadísticos y de control interno por el "
				 		+ "INSTITUTO MUNICIPAL DE LA MUJER DE TULTITLÁN.", font);
				 avisodeprivacidad.setSpacingAfter(30);
				 avisodeprivacidad.setAlignment(Paragraph.ALIGN_BOTTOM);

				 Paragraph lineafirma = new Paragraph("\n__________________________________");
		         lineafirma.setAlignment(Paragraph.ALIGN_CENTER);

		         Paragraph firmaDos = new Paragraph("LCD. MARÍA DEL ROCIO MONROY ROSADO\nCÉDULA PROFESIONAL 11677405",font);
		         firmaDos.setAlignment(Paragraph.ALIGN_CENTER);
		         Paragraph firma = new Paragraph("Nombre y firma de la persona usuaria", font);
		         firma.setAlignment(Paragraph.ALIGN_CENTER);
				
				seguro_violeta.add(titulo);
				seguro_violeta.add(tabla1);
				seguro_violeta.add(tabla2);
				seguro_violeta.add(tabla3);
				seguro_violeta.add(tabla4);
				seguro_violeta.add(avisodeprivacidad);
				seguro_violeta.add(lineafirma);
				seguro_violeta.add(firma);
				
				seguro_violeta.newPage();
				cb.addImage(fondo);
				seguro_violeta.add(exclusivo);
				seguro_violeta.add(tabla5);
				seguro_violeta.add(tabla6);
				seguro_violeta.add(tabla7);
				seguro_violeta.add(tabla8);
				seguro_violeta.add(tabla9);
				seguro_violeta.add(avisodeprivacidad);
				seguro_violeta.add(lineafirma);
				seguro_violeta.add(firmaDos);
				seguro_violeta.close();
					
				
				JOptionPane.showMessageDialog(null, "Informe generado");
					
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	
	/**
	 * Launch the application.
	 * 		
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeSeguroVioleta frame = new InformeSeguroVioleta();
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
	public InformeSeguroVioleta() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel.setBounds(10, 86, 90, 79);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 823, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/intMujer.png")));
		lblNewLabel_2.setBounds(22, 0, 53, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/LG.png")));
		lblNewLabel_3.setBounds(736, 0, 66, 58);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("INFORME SEGURO VIOLETA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		//lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(323, 10, 195, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/encabezado2.png")));
		lblNewLabel_5.setBounds(10, 0, 803, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_1.setBounds(709, 89, 104, 89);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 582, 803, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/encabezado2.png")));
		lblNewLabel_6.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_8.setBounds(0, 450, 405, 134);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_9.setBounds(402, 450, 421, 134);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_10.setBounds(0, 348, 100, 92);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel_11.setBounds(723, 361, 90, 89);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7.setBounds(10, 168, 90, 209);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7_1.setBounds(719, 171, 90, 209);
		contentPane.add(lblNewLabel_7_1);
		
		Area.setLineWrap(true);
		Area.setWrapStyleWord(true);
		Area.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(Area);
		scrollPane.setBounds(347, 131, 352, 118);
		contentPane.add(scrollPane);
		
		JButton btnGenerar = new JButton("");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expediente= txtInforme.getText();
				String exp = txtInforme.getText().trim();
				if (txtInforme.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número","Error",JOptionPane.ERROR_MESSAGE);
				}
				if (!exp.isEmpty() && !verificarExpediente(exp)) {
					JOptionPane.showMessageDialog(null, "El expediente no se encuetra en la base de datos",
							"Error",JOptionPane.ERROR_MESSAGE);
					txtInforme.setText("");
				}else {
					generarInformeSeguroVioleta(expediente);
				}
			}	
			
		});
		btnGenerar.setIcon(new ImageIcon(InformeSeguroVioleta.class.getResource("/img/generarPDF.png")));
		btnGenerar.setBounds(347, 361, 141, 34);
		contentPane.add(btnGenerar);
		
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
		
		
		JLabel lblNewLabel_12 = new JLabel("Ingrese el número de expediente");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(150, 106, 196, 14);
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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(180, 193, 141, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Buscar por nombre");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(177, 168, 144, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Caso de la persona");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(347, 106, 352, 14);
		contentPane.add(lblNewLabel_14);
		
		lista = new DefaultListModel<>();
		opciones = new JList<>(lista);
		popmenu = new JPopupMenu();
		popmenu.add(new JScrollPane(opciones));
		popmenu.setFocusable(false);
		
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarOpciones();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarOpciones();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarOpciones();
			}
		});
		opciones.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String nombre = opciones.getSelectedValue();
					txtNombre.setText(nombre);
					String exp = obtenerEXP(nombre);
					txtInforme.setText(exp);
					popmenu.setVisible(false);
				}
			}
		});
		opciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 ) {
					String nombre = opciones.getSelectedValue();
					txtNombre.setText(nombre);
					String exp = obtenerEXP(nombre);
					txtInforme.setText(exp);
					popmenu.setVisible(false);
				}
			}
		});
	}
	private String obtenerEXP(String nombre) {
		String exp = "";
		String sql = "SELECT EXP FROM seguro_violeta WHERE Nombre_de_la_victima = ?";
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
		String sql = "SELECT Nombre_de_la_victima FROM seguro_violeta WHERE Nombre_de_la_victima LIKE ?";
		
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
		String sql = "SELECT Nombre_de_la_victima FROM seguro_violeta WHERE EXP LIKE ?";
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
	private String obtenerCaso(String exp) {
		String caso= "";
		String sql = "SELECT Descripcion_Hechos_UltimoEpisodio_Violencia FROM seguro_violeta WHERE EXP LIKE ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, exp);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				caso = rs.getString("Descripcion_Hechos_UltimoEpisodio_Violencia");
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
		String sql = "SELECT COUNT(*) FROM seguro_violeta WHERE EXP = ?";
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