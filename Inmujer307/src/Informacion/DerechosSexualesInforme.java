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

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DerechosSexualesInforme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DerechosSexualesInforme frame = new DerechosSexualesInforme();
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
	
	  public void generarInforme3() {
	        Document reporte = new Document();
	        String ruta = System.getProperty("user.home");
	        try {
	        	  PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("Salud Sexual.pdf"));
	      
	            
	            
	            reporte.open();
	            
	           
	            try {
	                Image encabezado1 = Image.getInstance("src/img/informe5.jpeg");
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
	public DerechosSexualesInforme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/tulipanes.jpg")));
		lblNewLabel_1.setBounds(-81, 103, 405, 669);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Derechos Sexuales");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(323, 11, 176, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPromueveElReconocimiento = new JLabel("Este promueve el reconocimiento de la sexu-\r\nalidad como una parte fundamental del ser hu-\r\nmano, presente en todas las etapas de la vida.\r\nDestaca la importancia del disfrute y el placer sexual\r\npara el bienestar físico, mental y social. Además,\r\nseñala que los adolescentes y jóvenes tienen\r\nderechos sexuales que deben ser protegidos,\r\nsin distinciones, y hace énfasis en la necesidad\r\nde garantizar una protección amplia para las\r\npersonas.");
		lblPromueveElReconocimiento.setForeground(new Color(0, 0, 0));
		lblPromueveElReconocimiento.setBounds(122, 103, 202, 275);
		contentPane.add(lblPromueveElReconocimiento);
		
		JTextArea txtrPromueveElReconocimiento = new JTextArea();
		txtrPromueveElReconocimiento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrPromueveElReconocimiento.setText("Este promueve el reconocimiento de la sexualidad como una parte fundamental\r\ndel ser humano, presente en todas las etapas de la vida. Destaca la importancia\r\ndel disfrute y el placer sexual para el bienestar físico, mental y social. Además,\r\nseñala que los adolescentes y jóvenes tienen derechos sexuales que deben ser\r\nprotegidos, sin distinciones, y hace énfasis en la necesidad de garantizar una\r\nprotección amplia para las personas.\r\n\r\nSe resalta que la sexualidad va más allá de las relaciones sexuales o los órganos reproductivos, involucrando todos los aspectos emocionales y físicos relaciona-\r\ndos con el cuerpo. El Instituto Municipal de la Mujer de Tultitlán ofrece orienta-\r\nción sobre salud sexual y reproductiva a los jóvenes, con horarios de atención \r\nde lunes a viernes, y está ubicado en Tultitlán, Estado de México.\r\n\r\nEl mensaje principal es fomentar la educación sobre los derechos sexuales y la\r\nsalud sexual de los jóvenes, brindándoles acceso a la información y recursos \r\nnecesarios para ejercer sus derechos de manera segura y responsable.");
		txtrPromueveElReconocimiento.setBounds(323, 127, 484, 330);
		contentPane.add(txtrPromueveElReconocimiento);
		
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diseñoPDF diseño = new diseñoPDF();
				diseño.setVisible(true);
				diseño.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(408, 539, 134, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGenerarPdff = new JButton("GENERAR PDF");
		btnGenerarPdff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme3();
			}
		});
		btnGenerarPdff.setForeground(Color.WHITE);
		btnGenerarPdff.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGenerarPdff.setBackground(new Color(128, 0, 255));
		btnGenerarPdff.setBounds(596, 539, 134, 23);
		contentPane.add(btnGenerarPdff);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/butterfly_side_view_56.png")));
		lblNewLabel.setBounds(258, -2, 57, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/butterfly_side_espejo.png")));
		lblNewLabel_3.setBounds(509, -2, 57, 48);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/LogoCecyAjustado.png")));
		lblNewLabel_4.setBounds(20, -2, 104, 57);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/LogoInMujerCambiado.png")));
		lblNewLabel_4_1.setBounds(694, -2, 105, 57);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(DerechosSexualesInforme.class.getResource("/img/encabezado.gif")));
		lblNewLabel_5.setBounds(0, -2, 807, 57);
		contentPane.add(lblNewLabel_5);
	}
}
