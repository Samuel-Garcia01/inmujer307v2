package Informacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import MenuInmujer.diseñoPDF;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LeyOlimpia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeyOlimpia frame = new LeyOlimpia();
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
	
	  public void generarInforme4() {
	        Document reporte = new Document();
	        String ruta = System.getProperty("user.home");
	        try {
	        	  PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream(ruta+"/desktop/Ley Olimpya.pdf"));
	      
	            
	            
	            reporte.open();
	            
	           
	            try {
	                Image encabezado1 = Image.getInstance("src/img/informe4.jpeg");
	                encabezado1.scaleToFit(500,650); 
	                encabezado1.setAlignment(Chunk.ALIGN_CENTER);
	                reporte.add(encabezado1); 
	            } catch (IOException e) {
	               
	              
	            }

	            
	            
	        } catch (DocumentException | FileNotFoundException e) {
	           
	            JOptionPane.showMessageDialog(null, "Error al generar el informe PDF.", "Error de Informe", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	        
	       
	        if (reporte.isOpen()) {
	            reporte.close();
	        }
	        
	     
	        JOptionPane.showMessageDialog(null, "Informe generado exitosamente.", "Informe Generado", JOptionPane.INFORMATION_MESSAGE);
	    }

	   
	public LeyOlimpia() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel.setBounds(10, 86, 90, 79);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 823, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/LogoCecyAjustado.png")));
		lblNewLabel_2.setBounds(22, 0, 92, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/LogoInMujerCambiado.png")));
		lblNewLabel_3.setBounds(705, 0, 108, 58);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LEY OLIMPIA");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(323, 20, 195, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/encabezado2.png")));
		lblNewLabel_5.setBounds(10, 0, 813, 58);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_1.setBounds(709, 89, 104, 89);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 582, 803, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/encabezado2.png")));
		lblNewLabel_6.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(-4, 0, 803, 58);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/pie.png")));
		lblNewLabel_12.setBounds(10, 10, 783, 38);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_8.setBounds(0, 450, 405, 134);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/tulipanesJF.png")));
		lblNewLabel_9.setBounds(402, 450, 421, 134);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/mariposaSinFondo2.png")));
		lblNewLabel_10.setBounds(0, 348, 100, 92);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/mariposaSinFondo.png")));
		lblNewLabel_11.setBounds(723, 361, 90, 89);
		contentPane.add(lblNewLabel_11);
		
		JTextArea txtAreaOlimpia = new JTextArea();
		txtAreaOlimpia.setEnabled(false);
		txtAreaOlimpia.setEditable(false);
		txtAreaOlimpia.setDisabledTextColor(txtAreaOlimpia.getForeground());
		
		txtAreaOlimpia.setFont(new Font("Arial", Font.BOLD, 12));
		txtAreaOlimpia.setLineWrap(true);
		txtAreaOlimpia.setWrapStyleWord(true);
		txtAreaOlimpia.setText("QUE ES LA LEY OLIMPIA?  \r\nEs un conjunto de reformas  lesgislativas encaminadas a reconocer la violencia digital y sancionar los delitos que violen la intimidad sexual de las personas a traves de medios digitales. Iniciativa impulsada por Olimpia Coral Melo, busca frenar y castigar la violencia digital hacias las  mujeres, penalizando el acoso y la difusion de los llamados \"packs\", que son imagenes, videos o audios con contenido sexual sin consentimiento de las victimas.\r\n");
		txtAreaOlimpia.setBounds(110, 102, 259, 175);
		contentPane.add(txtAreaOlimpia);
		
		JTextArea txtAreaConductas = new JTextArea();
		txtAreaConductas.setEnabled(false);
		txtAreaConductas.setEditable(false);
		txtAreaConductas.setDisabledTextColor(txtAreaConductas.getForeground());
		
		txtAreaConductas.setFont(new Font("Arial", Font.BOLD, 12));
		txtAreaConductas.setWrapStyleWord(true);
		txtAreaConductas.setLineWrap(true);
		txtAreaConductas.setText("CONDUCTAS QUE ATENTAN  CONTRA LA INTIMIDAD.\r\nVideo, auidio, fotografiar o elaborar videos reales o simulados de contenido sexual intimo, de una persona mediante engaño. Exponer, distribuir, difundir, exhibir, reproducir, transmitir, comercializar, ofertar, intercambiar y compartir imagenes, auidios o videos de contenido sexual intimo de una persona, a sabiendas de que no existe consentimiento, mediante materiales, redes sociales o cualquier medio tecnologico.\r\n");
		txtAreaConductas.setBounds(454, 102, 259, 178);
		contentPane.add(txtAreaConductas);
		
		JTextArea txtAreaSancion = new JTextArea();
		txtAreaSancion.setEnabled(false);
		txtAreaSancion.setEditable(false);
		txtAreaSancion.setDisabledTextColor(txtAreaSancion.getForeground());
		
		txtAreaSancion.setFont(new Font("Arial", Font.BOLD, 12));
		txtAreaSancion.setWrapStyleWord(true);
		txtAreaSancion.setLineWrap(true);
		txtAreaSancion.setText("SANCION\r\nEn el Estado de México, la Ley Olimpia se aprobo el 26 de mayo de 2021. Las sanciones previstas para este delito pueden incluir penas de prision de 3 a 6 años y multas economicas.\r\n");
		txtAreaSancion.setBounds(110, 287, 259, 89);
		contentPane.add(txtAreaSancion);
		
		JTextArea txtAreaDenuncia = new JTextArea();
		txtAreaDenuncia.setEnabled(false);
		txtAreaDenuncia.setEditable(false);
		txtAreaDenuncia.setDisabledTextColor(txtAreaDenuncia.getForeground());
		
		txtAreaDenuncia.setFont(new Font("Arial", Font.BOLD, 12));
		txtAreaDenuncia.setLineWrap(true);
		txtAreaDenuncia.setWrapStyleWord(true);
		txtAreaDenuncia.setText("DONDE PUEDO DENUNCIAR? \r\nPuedes acudir a la Fiscalia General de Justicia del Estado de México y solicitar la intervencion de la Fiscalia especializada en Delitos Electronicos del Estado de México.");
		txtAreaDenuncia.setBounds(454, 287, 259, 82);
		contentPane.add(txtAreaDenuncia);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7.setBounds(10, 168, 90, 209);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/Enredadera1.2.png")));
		lblNewLabel_7_1.setBounds(719, 171, 90, 209);
		contentPane.add(lblNewLabel_7_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme4();
			}
		});
		btnNewButton.setIcon(new ImageIcon(LeyOlimpia.class.getResource("/img/generarPDF.png")));
		btnNewButton.setBounds(454, 386, 141, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diseñoPDF diseño = new diseñoPDF();
				diseño.setVisible(true);
				diseño.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(221, 160, 221));
		btnNewButton_2.setBounds(229, 386, 141, 34);
		contentPane.add(btnNewButton_2);
	}
}
