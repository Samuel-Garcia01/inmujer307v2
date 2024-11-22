package Informacion;


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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class elArteDeSerMujer extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrFasePremenstrualDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					elArteDeSerMujer frame = new elArteDeSerMujer();
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
	
	 public void generarInforme() {
	        Document reporte = new Document();
	        String ruta = System.getProperty("user.home");
	        try {
	           
	            PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("El Arte De Ser Mujer.pdf"));
	            
	            
	            reporte.open();
	            
	           
	            try {
	                Image encabezado1 = Image.getInstance("src/img/informe1.jpeg");
	                encabezado1.scaleToFit(500, 650); 
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

	public elArteDeSerMujer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(elArteDeSerMujer.class.getResource("/img/encabezado21.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(636, 412, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(elArteDeSerMujer.class.getResource("/img/Sin título-8.png")));
		lblNewLabel_2.setBounds(-22, 59, 219, 163);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(elArteDeSerMujer.class.getResource("/img/Sin título-8.png")));
		lblNewLabel_3.setBounds(604, 482, 195, 118);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(elArteDeSerMujer.class.getResource("/img/Sin título-13.png")));
		lblNewLabel_4.setBounds(-12, 194, 105, 389);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(elArteDeSerMujer.class.getResource("/img/Sin título-13.png")));
		lblNewLabel_5.setBounds(695, 71, 95, 400);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diseñoPDF diseño = new diseñoPDF();
				diseño.setVisible(true);
				diseño.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setBounds(220, 482, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GENERAR PDF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setBounds(452, 483, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrqueEsLa = new JTextArea();
		txtrqueEsLa.setEditable(false);
		txtrqueEsLa.setBackground(new Color(255, 182, 193));
		txtrqueEsLa.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrqueEsLa.setText("\r\nLa menstruación es un proceso \r\nnatural que experimentan las \r\nmujeres durante la pubertad\r\ngeneralmente entre los 10 y 16 años\r\nhasta alrededor de los  45 o 55 años. \r\nCada mes las hormonas activan el\r\ncrecimiento de 10 a 20 óvulos en\r\nuno de los  ovarios, pero solo uno o \r\ndos maduran y son liberados.\r");
		txtrqueEsLa.setBounds(207, 113, 195, 162);
		contentPane.add(txtrqueEsLa);
		
		JTextArea txtrFasePreovulatoriaNo = new JTextArea();
		txtrFasePreovulatoriaNo.setEditable(false);
		txtrFasePreovulatoriaNo.setBackground(new Color(255, 182, 193));
		txtrFasePreovulatoriaNo.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrFasePreovulatoriaNo.setText("No hay sangrado, el\r\nflujo es escaso\r\ny transparente\r");
		txtrFasePreovulatoriaNo.setBounds(505, 317, 167, 109);
		contentPane.add(txtrFasePreovulatoriaNo);
		
		JTextArea txtrFaseOvulatoriaDe = new JTextArea();
		txtrFaseOvulatoriaDe.setEditable(false);
		txtrFaseOvulatoriaDe.setBackground(new Color(255, 182, 193));
		txtrFaseOvulatoriaDe.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrFaseOvulatoriaDe.setText("De no ser fecundado,\r\nel óvulo se desintegra\r\ny es eliminado con\r\notras secreciones\r\nvaginales\r\ngeneralmente días\r\nantes del sangrado\r\nmenstrual.\r");
		txtrFaseOvulatoriaDe.setBounds(130, 317, 130, 109);
		contentPane.add(txtrFaseOvulatoriaDe);
		
		txtrFasePremenstrualDe = new JTextArea();
		txtrFasePremenstrualDe.setEditable(false);
		txtrFasePremenstrualDe.setBackground(new Color(255, 182, 193));
		txtrFasePremenstrualDe.setText("De no ser fecundado, el\r\nóvulo se desintegra y es\r\neliminado con otras\r\nsecreciones vaginales\r\ngeneralmente días antes\r\ndel sangrado menstrual.\r\n\r");
		txtrFasePremenstrualDe.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrFasePremenstrualDe.setBounds(316, 317, 167, 109);
		contentPane.add(txtrFasePremenstrualDe);
		
		JTextArea txtrcomoDesecharCon = new JTextArea();
		txtrcomoDesecharCon.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrcomoDesecharCon.setEditable(false);
		txtrcomoDesecharCon.setBackground(new Color(255, 182, 193));
		txtrcomoDesecharCon.setText("-Envuelve el material sanitario \r\nusado (toallas y/o tampones\r\ndesechables) en un\r\nperiódico viejo o papel\r\n higiénico\r\n-No arrojes\r\nmaterial sanitario usado al\r\ninodoro ya que obstruirá el\r\ndrenaje.");
		txtrcomoDesecharCon.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrcomoDesecharCon.setBounds(457, 126, 178, 118);
		contentPane.add(txtrcomoDesecharCon);
		
		JLabel lblNewLabel_6 = new JLabel("¿QUE ES LA MENSTRUACION?");
		lblNewLabel_6.setForeground(new Color(148, 0, 211));
		lblNewLabel_6.setFont(new Font("Yu Gothic Light", Font.BOLD, 10));
		lblNewLabel_6.setBounds(207, 103, 178, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("¿COMO DESECHAR COMO BUEN HABITO?\r\n");
		lblNewLabel_7.setForeground(new Color(153, 50, 204));
		lblNewLabel_7.setFont(new Font("Yu Gothic Light", Font.BOLD, 9));
		lblNewLabel_7.setBounds(452, 101, 206, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("FASE OVULATORIA");
		lblNewLabel_8.setForeground(new Color(153, 50, 204));
		lblNewLabel_8.setFont(new Font("Yu Gothic Light", Font.BOLD, 10));
		lblNewLabel_8.setBounds(131, 281, 105, 23);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("FASE PRE-MENSTRUAL");
		lblNewLabel_9.setFont(new Font("Yu Gothic Light", Font.BOLD, 10));
		lblNewLabel_9.setForeground(new Color(153, 50, 204));
		lblNewLabel_9.setBounds(310, 278, 142, 29);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("FASE PRE-OVULATORIA");
		lblNewLabel_10.setFont(new Font("Yu Gothic Light", Font.BOLD, 10));
		lblNewLabel_10.setForeground(new Color(153, 50, 204));
		lblNewLabel_10.setBounds(505, 281, 122, 18);
		contentPane.add(lblNewLabel_10);
	}
}
