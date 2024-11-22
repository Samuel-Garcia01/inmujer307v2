package Informes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ConexionBaseDeDatos.ConexionInmujer;
import MenuInmujer.Menu;
import clasesExternas.FechaHora;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InformePrimercontacto extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInforme;

	
	public void generarInformePrimerContacto(String expediente) {
		FechaHora fecha = new FechaHora();
		Document primer_contacto = new Document();
		String ruta = System.getProperty("user.home");
		PdfWriter writter;
		ConexionInmujer conexion = new ConexionInmujer();
		Connection con = conexion.conectar();
		try {
			writter = PdfWriter.getInstance(primer_contacto, new FileOutputStream(ruta+"/desktop/PrimerContacto.pdf"));
			//writter = PdfWriter.getInstance(primer_contacto, new FileOutputStream(ruta+"/PrimerContacto.pdf"));
			primer_contacto.open();
			
			PdfContentByte cb = writter.getDirectContentUnder();
			
			Image logo = Image.getInstance("src/img/logo INMUJER.jpg");
			logo.setAbsolutePosition(10, 750);
			logo.scaleToFit(80,100);
			logo.setAlignment(Chunk.ALIGN_TOP+Chunk.ALIGN_LEFT);
			cb.addImage(logo);
			
			Image fondo = Image.getInstance("src/img/FondoPrimerContacto.jpg");
			fondo.setAbsolutePosition(0,0);
			fondo.scaleAbsolute(595,842);
			cb.addImage(fondo);
			
			Font letra_grande = new Font(FontFactory.getFont("Century Gothic",12,Font.NORMAL,BaseColor.BLACK));
			Font letra_pequenia = new Font(FontFactory.getFont("Century Gothic",9,Font.NORMAL,BaseColor.BLACK));
			Font letra_blanca = new Font(FontFactory.getFont("Century Gothic",9,Font.NORMAL,BaseColor.WHITE));
			
			Paragraph titulo = new Paragraph();
			titulo.setAlignment(Paragraph.ALIGN_TOP);
			titulo.setFont(FontFactory.getFont("Century Gothic", 12, Font.NORMAL,BaseColor.BLACK));
			titulo.add("FORMATO DE ATENCIÓN DE PRIMER CONTACTO");
			titulo.setIndentationLeft(236f);
						
			cb.setColorFill(BaseColor.WHITE);
			cb.setColorFill(BaseColor.BLACK);
			cb.rectangle(100, 754, 150, 20);
			cb.stroke();
			cb.fill();
			
			cb.setFontAndSize(BaseFont.createFont(), 9);
			cb.showTextAligned(Element.ALIGN_LEFT,"Elabor�:", 100, 780, 0);
			
			PdfPTable tabla1 = new PdfPTable(2);
			tabla1.setSpacingBefore(10f);
			tabla1.setWidthPercentage(51);
			tabla1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			String sql = "SELECT * FROM datos WHERE EXP = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, expediente);
			ResultSet rs = pst.executeQuery();
			 while(rs.next()) {
				 	
				 	PdfPCell celda1 = new PdfPCell(new Phrase("Fecha: "+String.valueOf(rs.getString("FECHA")),letra_pequenia));
				 	PdfPCell celda2 = new PdfPCell(new Phrase("Hora: "+fecha.obtenerHoraCompleta(),letra_pequenia));
				 	PdfPCell celda3 = new PdfPCell(new Phrase("EXP: "+String.valueOf(rs.getInt("EXP")),letra_pequenia));
				 	PdfPCell celda4 = new PdfPCell(new Phrase("Dia: "+fecha.obtenerDiaMesAnio(),letra_pequenia));
				 	
				 	tabla1.addCell(celda1);
				 	tabla1.addCell(celda2);
				 	tabla1.addCell(celda3);
				 	tabla1.addCell(celda4);
			}
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while(rs.next()) {
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Nombre_de_la_victima"),letra_pequenia),
			60, 735, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________________",letra_pequenia),
			37, 730, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Nombre Completo",letra_pequenia),
			70, 720, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Estado_Civil"),letra_pequenia),
			200, 735, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("_____________",letra_pequenia),
			185, 730, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Estado Civil",letra_pequenia),
			190, 720, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Ocupacion"),letra_pequenia),
			285, 735, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________________",letra_pequenia),
			270, 730, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Ocupación",letra_pequenia),
			285, 720, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Servicio_Medico"),letra_pequenia),
			390, 735, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("___________________",letra_pequenia),
			360, 730, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Servicio Médico",letra_pequenia),
			375, 720, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Grado_de_Estudios"),letra_pequenia),
			490, 735, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________________",letra_pequenia),
			463, 730, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Grado de Estudios",letra_pequenia),
			465, 720, 0);
			
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Edad"),letra_pequenia),
			53, 705, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________",letra_pequenia),
			38, 700, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Edad",letra_pequenia),
			48, 690, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Fecha_de_nacimiento"),letra_pequenia),
			118, 705, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________",letra_pequenia),
			100, 700, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Fecha de Nacimiento",letra_pequenia),
			103, 690, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Ingreso_familiar"),letra_pequenia),
			235, 705, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("________________",letra_pequenia),
			205, 700, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Ingreso Familiar",letra_pequenia),
			213, 690, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Domicilio"),letra_pequenia),
			325, 705, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("_________________________________________________",letra_pequenia),
			305, 700, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Domicilio",letra_pequenia),
			410, 690, 0);
			
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Codigo_postal"),letra_pequenia),
			53, 675, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("___________",letra_pequenia),
			38, 670, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Código Postal",letra_pequenia),
			38, 660, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Colonia"),letra_pequenia),
			115, 675, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________________",letra_pequenia),
			110, 670, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Colonia",letra_pequenia),
			140, 660, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Estado"),letra_pequenia),
			262, 675, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("___________________",letra_pequenia),
			250, 670, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Estado",letra_pequenia),
			280, 660, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Telefono_Celular"),letra_pequenia),
			377, 675, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________",letra_pequenia),
			360, 670, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Teléfono Celular",letra_pequenia),
			370, 660, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(rs.getString("Telefono_Casa"),letra_pequenia),
			490, 675, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("__________________",letra_pequenia),
			470, 670, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("Teléfono Casa",letra_pequenia),
			485, 660, 0);
			}
			Paragraph linea_larga = new Paragraph();
			linea_larga.add("____________________");
			linea_larga.setAlignment(Paragraph.ALIGN_CENTER);
			 
			PdfPTable tabla2 = new PdfPTable(2);
			tabla2.setSpacingBefore(100);
			tabla2.setWidthPercentage(100);
			tabla2.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String vivienda = rs.getString("Vivienda")!=null ? rs.getString("Vivienda"): "";
				String personasViviendo = rs.getInt("No_Personas")>0 ? String.valueOf(rs.getInt("No_Personas")): "";
				String contribuyente = rs.getString("Contribuyente_al_gasto")!=null ?rs.getString("Contribuyente_al_gasto"): "";
				String canalizada = rs.getString("Canalizada_por")!=null ?rs.getString("Canalizada_por"): "";
				String padecimiento = rs.getString("Padecimiento_y_o_Enfermedad_cronica") !=null ? rs.getString("Padecimiento_y_o_Enfermedad_cronica"): "";
				String denuncia =rs.getString("Denuncia")!=null ? rs.getString("Denuncia"): "";
				String hijosDependientes = rs.getString("Dependientes_Economicos")!=null ? rs.getString("Dependientes_Economicos"): "";
				
				PdfPCell Vivienda = new PdfPCell(new Phrase("Vivienda: "+vivienda,letra_pequenia));
				PdfPCell PersonasViviendo = new PdfPCell(new  Phrase("Número de personas que viven en el domicilio: "+personasViviendo,letra_pequenia));
				PdfPCell Contribuyente = new PdfPCell(new Phrase("¿Quién contribuye al gasto familiar? "+contribuyente,letra_pequenia));
				PdfPCell Canalizada = new PdfPCell(new Phrase("Canalizada por: "+canalizada,letra_pequenia));
				PdfPCell Padecimineto  =new PdfPCell(new Phrase("Padecimiento y/o enfermedad crónica: "+padecimiento,letra_pequenia));
				PdfPCell DenunciaODemanda = new PdfPCell(new Phrase("Denuncia(número) y/o demanda(tipo): "+denuncia,letra_pequenia));
				PdfPCell HijosDependientes  =new PdfPCell(new Phrase("Nombre edad y escolaridad/ocupación de los hijos o dependientes económicos: ",letra_pequenia));
				PdfPCell NomHijos = new PdfPCell(new Phrase(hijosDependientes,letra_pequenia));
				
				tabla2.addCell(Vivienda);
				tabla2.addCell(PersonasViviendo);
				tabla2.addCell(Contribuyente);
				tabla2.addCell(Canalizada);
				tabla2.addCell(Padecimineto);
				tabla2.addCell(DenunciaODemanda);
				HijosDependientes.setColspan(2);
				tabla2.addCell(HijosDependientes);
				NomHijos.setColspan(2);
				tabla2.addCell(NomHijos);
			}
			
			PdfPTable tabla3 = new PdfPTable(2);
			tabla3.setWidthPercentage(100);
			tabla3.setSpacingBefore(5);
			tabla3.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String tipoDeViolencia = rs.getString("Tipos_de_Violencia")!=null ? rs.getString("Tipos_de_Violencia"): "";
				String modalidadesDeViolencia = rs.getString("Modalidades_de_violencia")!=null ? rs.getString("Modalidades_de_violencia"): "";				
				
				PdfPCell violencia = new PdfPCell(new Phrase("TIPOS DE VIOLENCIA",letra_blanca));
				violencia.setBackgroundColor(BaseColor.BLACK);
				violencia.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell modalidad = new PdfPCell(new Phrase("MODALIDADES DE LA VIOLENCIA",letra_blanca)); 
				modalidad.setBackgroundColor(BaseColor.BLACK);
				modalidad.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell tipo_de_violencia = new PdfPCell(new Phrase(tipoDeViolencia,letra_pequenia));
				PdfPCell modalidad_de_violencia = new PdfPCell(new Phrase(modalidadesDeViolencia,letra_pequenia));
				
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
				String hechosYmotivos = rs.getString("Hechos_y_motivos_de_la_atencion")!=null ? rs.getString("Hechos_y_motivos_de_la_atencion"): "";
				String Descripcion = rs.getString("Descripcion")!=null ? rs.getString("Descripcion"): "";
				String nivelRiesgo = rs.getString("Nivel_de_Riesgo")!=null ? rs.getString("Nivel_de_Riesgo"): "";
				
				PdfPCell hechos = new PdfPCell(new Phrase("HECHOS Y MOTIVOS DE LA ATENCI�N",letra_blanca));
				hechos.setBackgroundColor(BaseColor.BLACK);
				hechos.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell lugar_y_fecha = new PdfPCell(new Phrase("Lugar, fecha y hora de la agresi�n: "+hechosYmotivos,letra_pequenia));
				PdfPCell descripcion = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS HECHOS",letra_pequenia));
				descripcion.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell descripcion_hechos = new PdfPCell(new Phrase(Descripcion,letra_pequenia));
				PdfPCell nivel_de_riesgo = new PdfPCell(new Phrase("Nivel de riesgo: "+nivelRiesgo,letra_pequenia));
				
				tabla4.addCell(hechos);
				tabla4.addCell(lugar_y_fecha);
				tabla4.addCell(descripcion);
				tabla4.addCell(descripcion_hechos);
				tabla4.addCell(nivel_de_riesgo);
			}
			
			PdfPTable tabla5 = new PdfPTable(2);
			tabla5.setWidthPercentage(100);
			tabla5.setSpacingBefore(5);
			tabla5.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String datosAgresor = rs.getString("Datos_del_Agresor")!=null ? rs.getString("Datos_del_Agresor"): "";
				String gradoEscolar = rs.getString("Grado_escolar")!=null ? rs.getString("Grado_escolar"): "";
				String estadoCivil = rs.getString("Estado_Civil_del_Agresor")!=null ? rs.getString("Estado_Civil_del_Agresor"): "";
				String relacionVinculo = rs.getString("Relacion_o_Vinculo")!=null ? rs.getString("Relacion_o_Vinculo"): "";
				String servidorPublico = rs.getString("Servidor_Publico")!=null ? rs.getString("Servidor_Publico"): "";
				String domicilioCompleto = rs.getString("Domicilio_completo")!=null ? rs.getString("Domicilio_completo"): "";
				String ocupacionAgresor = rs.getString("Ocupacion_del_Agresor")!=null ? rs.getString("Ocupacion_del_Agresor"): "";
				
				PdfPCell agresor = new PdfPCell(new Phrase("DATOS DEL AGRESOR",letra_blanca));
				agresor.setColspan(2);
				agresor.setBackgroundColor(BaseColor.BLACK);
				agresor.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell datos = new PdfPCell(new Phrase("Nombre completo, edad y fecha de nacimiento: "+datosAgresor,letra_pequenia));
				datos.setColspan(2);
				
				PdfPCell grado = new PdfPCell(new Phrase("Grado Escolar: "+gradoEscolar,letra_pequenia));
				PdfPCell estado_civil = new PdfPCell(new Phrase("Estado Civil: "+estadoCivil,letra_pequenia));
				PdfPCell relacion = new PdfPCell(new Phrase("Relación o vínculo: "+relacionVinculo,letra_pequenia));
				PdfPCell servidor_publico = new PdfPCell(new Phrase("Servidor Público: "+servidorPublico,letra_pequenia));
				PdfPCell domicilio = new PdfPCell(new Phrase("Domicilio Completo: "+domicilioCompleto,letra_pequenia));
				PdfPCell ocupacion = new PdfPCell(new Phrase("Ocupación: "+ocupacionAgresor,letra_pequenia));
				
				tabla5.addCell(agresor);
				tabla5.addCell(datos);
				tabla5.addCell(grado);
				tabla5.addCell(estado_civil);
				tabla5.addCell(relacion);
				tabla5.addCell(servidor_publico);
				tabla5.addCell(domicilio);
				tabla5.addCell(ocupacion);
			}
			
			PdfPTable tabla6 = new PdfPTable(2);
			tabla6.setWidthPercentage(100);
			tabla6.setSpacingBefore(5);
			tabla6.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String portaArmas = rs.getString("Porta_armas")!=null ? rs.getString("Porta_armas"): "";
				String seleccionarArmas = rs.getString("Seleccionar_armas")!=null ? rs.getString("Seleccionar_armas"): "";
				String bandaDelictiva = rs.getString("Pertenece_a_alguna_banda_delictiva")!=null ? rs.getString("Pertenece_a_alguna_banda_delictiva"): "";
				String sustancia = rs.getString("Consume_algún_tipo_de_sustancia")!=null ?  rs.getString("Consume_algún_tipo_de_sustancia"): "";
				String cual = rs.getString("Cual")!=null ? rs.getString("Cual"): "";
				String senias = rs.getString("Señas_particulares")!=null ? rs.getString("Señas_particulares"): "";
				
				PdfPCell filiacion = new PdfPCell(new Phrase("Media_filiacion_del_agresor",letra_blanca));
				filiacion.setBackgroundColor(BaseColor.BLACK);
				filiacion.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell particularidades = new PdfPCell(new Phrase("PARTICULARIDADES DEL AGRESOR",letra_blanca));
				particularidades.setBackgroundColor(BaseColor.BLACK);
				particularidades.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell media_filiacion = new PdfPCell(new Phrase(rs.getString("Media_filiacion_del_agresor"),letra_pequenia));
				PdfPCell porta_armas = new PdfPCell(new Phrase("Porta Armas: "+portaArmas+" "+seleccionarArmas+"\n\n"+
				 "¿Pertenece a alguna banda delictiva?"+" "+bandaDelictiva+"\n\n"+"¿Consume algún tipo de sustancia?¿Cuál?"+
				sustancia+" "+cual+"\n\n"+"Señas particulares: "+
				 senias,letra_pequenia));
				
				tabla6.addCell(filiacion);
				tabla6.addCell(particularidades);
				tabla6.addCell(media_filiacion);
				tabla6.addCell(porta_armas);
			}
			PdfPTable tabla7 = new PdfPTable(3);
			tabla7.setWidthPercentage(100);
			tabla7.setSpacingBefore(5);
			tabla7.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String efectosFisicos = rs.getString("Efectos_fisicos") !=null ? rs.getString("Efectos_fisicos"): "";
				String efectosPsicologicos = rs.getString("Efectos_psicologicos") !=null ? rs.getString("Efectos_psicologicos"): "";
				String efectosSexuales = rs.getString("Efectos_sexuales")!=null ? rs.getString("Efectos_sexuales"): "";
				String efectosEco = rs.getString("Efectos_economicos_y_patrimoniales") !=null ? rs.getString("Efectos_economicos_y_patrimoniales"): "";
				
				PdfPCell efectos = new PdfPCell(new Phrase("EFECTOS",letra_blanca));
				efectos.setBackgroundColor(BaseColor.BLACK);
				efectos.setColspan(3);
				efectos.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell e_fisicos = new PdfPCell(new Phrase("                           Fisicos: \n"+
				efectosFisicos,letra_pequenia));
				PdfPCell e_psicologicos = new PdfPCell(new Phrase("                       Psicologicos: \n"+
				efectosPsicologicos,letra_pequenia));
				PdfPCell e_sexuales = new PdfPCell(new Phrase("                          Sexuales: \n"+
				efectosSexuales,letra_pequenia));
				PdfPCell economicos_patrimonoales = new PdfPCell(new Phrase("Economicos y Patrimoniales\n"+
				efectosEco,letra_pequenia));
				economicos_patrimonoales.setColspan(3);
				
				tabla7.addCell(efectos);
				tabla7.addCell(e_fisicos);
				tabla7.addCell(e_psicologicos);
				tabla7.addCell(e_sexuales);
				tabla7.addCell(economicos_patrimonoales);
			}
			
			PdfPTable tabla8 = new PdfPTable(1);
			tabla8.setWidthPercentage(100);
			tabla8.setSpacingBefore(5);
			tabla8.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String redesDeApoyo = rs.getString("Redes_de_apoyo")!=null ? rs.getString("Redes_de_apoyo"): "";
				
				PdfPCell redes = new PdfPCell(new Phrase("REDES DE APOYO",letra_blanca));
				redes.setBackgroundColor(BaseColor.BLACK);
				redes.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell redes_de_apoyo = new PdfPCell(new Phrase(" "+redesDeApoyo,letra_pequenia));
				
				tabla8.addCell(redes);
				tabla8.addCell(redes_de_apoyo);
			}
			
			PdfPTable tabla9 = new PdfPTable(1);
			tabla9.setWidthPercentage(100);
			tabla9.setSpacingBefore(5);
			tabla9.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
			pst.setString(1, expediente);
			rs = pst.executeQuery();
			while (rs.next()) {
				String observacionesGenerales =rs.getString("Observaciones_generales_y_o_Canalizacion")!=null ? rs.getString("Observaciones_generales_y_o_Canalizacion"): "";
				
				PdfPCell observaciones = new PdfPCell(new Phrase("OBSERVACIONES GENERALES Y/O CANALIZACIÓN",letra_blanca));
				observaciones.setBackgroundColor(BaseColor.BLACK);
				observaciones.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell obs_generales = new PdfPCell(new Phrase(" "+observacionesGenerales,letra_pequenia));
				
				tabla9.addCell(observaciones);
				tabla9.addCell(obs_generales);
			}
			
			 Font font = FontFactory.getFont(("Century Gothic"),7, Font.NORMAL); 
			 Paragraph avisodeprivacidad = new Paragraph("AVISO DE PRIVACIDAD: Con fundamento en lo dispuesto por los Articulos 3,fraccion IX,6 y 143 de la Ley de Transparencia y Acceso a la Informacion Publica del Estado de Mexico y Municipios, Articulo 6,15,29 y 32 de la Ley de Proteccion de Datos Personales en Posesion de Sujetos Obligados del Estado de Mexico y Municipios y demas relativos aplicables, los datos recabados en la presente cedula seran utilizados con fines estadisticos y de control interno por el INSTITUTO MUNICIPAL DE LA MUJER DE TULTITLAN", font);
			 avisodeprivacidad.setAlignment(Paragraph.ALIGN_LEFT);
	         
			 Paragraph autorizacion = new Paragraph("\nAUTORIZO LA UTILIZACION DE MIS DATOS PARA ALIMENTAR LA PLATAFORMA DE BANCO DE DATOS E INFORMACION DEL ESTADO DE MEXICO SOBRE CASOS DE VIOLENCIA CONTRA LAS MUJERES", font);
			 autorizacion.setAlignment(Paragraph.ALIGN_LEFT);

			 Paragraph casillas = new Paragraph("AUTORIZO: ", font);
			 casillas.setAlignment(Paragraph.ALIGN_LEFT);
			 pst.setString(1, expediente);
			 rs = pst.executeQuery();
			 while(rs.next()) {
				 casillas.add(rs.getString("Autorizacion"));
			 }

			 Paragraph lineafirma = new Paragraph("__________________________________");
	         lineafirma.setAlignment(Paragraph.ALIGN_CENTER);

	         Paragraph firma = new Paragraph("Nombre y firma de la usuaria", font);
	         firma.setAlignment(Paragraph.ALIGN_CENTER);
		
		primer_contacto.add(logo);
		primer_contacto.add(titulo);
		primer_contacto.add(tabla1);
		primer_contacto.add(tabla2);
		primer_contacto.add(tabla3);
		primer_contacto.add(tabla4);
		primer_contacto.add(tabla5);
		primer_contacto.add(tabla6);
		primer_contacto.add(tabla7);
		primer_contacto.add(tabla8);
		primer_contacto.add(tabla9);
		
       primer_contacto.add(avisodeprivacidad);
       primer_contacto.add(autorizacion);
       primer_contacto.add(casillas);
       primer_contacto.add(lineafirma);
       primer_contacto.add(firma);
		primer_contacto.close();
		
		JOptionPane.showMessageDialog(null, "Informe generado");
			
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
					InformePrimercontacto frame = new InformePrimercontacto();
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
	public InformePrimercontacto() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel.setBounds(10, 86, 90, 79);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 823, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/intMujer.png")));
		lblNewLabel_2.setBounds(22, 0, 53, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/LG.png")));
		lblNewLabel_3.setBounds(736, 0, 66, 58);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("INFORME PRIMER CONTACTO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		//lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(323, 10, 195, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/encabezado2.png")));
		lblNewLabel_5.setBounds(10, 0, 803, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_1.setBounds(709, 89, 104, 89);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 582, 803, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/encabezado2.png")));
		lblNewLabel_6.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_8.setBounds(0, 450, 405, 134);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_9.setBounds(402, 450, 421, 134);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_10.setBounds(0, 348, 100, 92);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel_11.setBounds(723, 361, 90, 89);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7.setBounds(10, 168, 90, 209);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7_1.setBounds(719, 171, 90, 209);
		contentPane.add(lblNewLabel_7_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expediente= txtInforme.getText();
				if (txtInforme.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un n�mero","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					generarInformePrimerContacto(expediente);
				}
			}	
			
		});
		btnNewButton.setIcon(new ImageIcon(InformePrimercontacto.class.getResource("/img/generarPDF.png")));
		btnNewButton.setBounds(350, 284, 141, 34);
		contentPane.add(btnNewButton);
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Ingrese el n\u00FAmero de expediente");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(311, 214, 205, 14);
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
	}
}
