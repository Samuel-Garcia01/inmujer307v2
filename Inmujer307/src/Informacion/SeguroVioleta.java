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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeguroVioleta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeguroVioleta frame = new SeguroVioleta();
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
	public void generarInforme2() {
        Document reporte = new Document();
        String ruta = System.getProperty("user.home");
        try {
        	  PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("Seguro Violeta.pdf"));
      
            
            
            reporte.open();
            
           
            try {
                Image encabezado1 = Image.getInstance("src/img/informe2.jpeg");
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

	public SeguroVioleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 808, 611);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEGURO VIOLETA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(354, 11, 173, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/mujeres.png")));
		lblNewLabel_1.setBounds(306, 193, 216, 200);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(238, 232, 170));
		lblNewLabel_3.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/encabezado1.jpg")));
		lblNewLabel_3.setBounds(0, 570, 808, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/Instituto.jpg")));
		lblNewLabel_4.setBounds(10, 101, 300, 134);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/funcion.jpg")));
		lblNewLabel_5.setBounds(10, 345, 300, 143);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/SeguroVioleta.jpg")));
		lblNewLabel_6.setBounds(499, 95, 299, 143);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/segura.jpg")));
		lblNewLabel_7.setBounds(499, 345, 299, 143);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("INSTITUTO MUNICIPAL DE LA MUJER  ");
		lblNewLabel_8.setForeground(new Color(65, 105, 225));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(22, 76, 290, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("¿QUE HACE EL INSTITUTO?");
		lblNewLabel_9.setForeground(new Color(65, 105, 225));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(52, 320, 234, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("SEGURO VIOLETA");
		lblNewLabel_10.setForeground(new Color(65, 105, 225));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(558, 68, 163, 22);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("FINALIDAD");
		lblNewLabel_11.setForeground(new Color(65, 105, 225));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(601, 313, 130, 28);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/heart cafe.png")));
		lblNewLabel_12.setBounds(22, 269, 32, 24);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/heart cafe.png")));
		lblNewLabel_13.setBounds(381, 68, 32, 22);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/heart cafe.png")));
		lblNewLabel_14.setBounds(718, 500, 32, 22);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/heart_26px.png")));
		lblNewLabel_15.setBounds(727, 58, 32, 26);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/heart_26px.png")));
		lblNewLabel_16.setBounds(10, 499, 46, 23);
		panel.add(lblNewLabel_16);
		
		JLabel btnGenerarPDF = new JLabel("");
		btnGenerarPDF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarPDF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGenerarPDF.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/pdfCafe1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGenerarPDF.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/pdfCafe.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				generarInforme2();
			}
		});
		btnGenerarPDF.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/pdfCafe.jpg")));
		btnGenerarPDF.setBounds(499, 519, 137, 41);
		panel.add(btnGenerarPDF);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/LogoCecyAjustado.png")));
		lblNewLabel_2.setBounds(10, 1, 99, 51);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/LogoInMujerCambiado.png")));
		lblNewLabel_17.setBounds(704, 0, 94, 57);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(SeguroVioleta.class.getResource("/img/encabezado1.jpg")));
		lblNewLabel_18.setBounds(0, 0, 808, 57);
		panel.add(lblNewLabel_18);
		
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
		btnNewButton_2.setBounds(169, 519, 141, 34);
		panel.add(btnNewButton_2);
	}
}
