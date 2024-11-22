package MenuInmujer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import Informacion.DerechosSexualesInforme;
import Informacion.LeyOlimpia;
import Informacion.SeguroVioleta;
import Informacion.elArteDeSerMujer;
import MenuInmujer.MenuInmujer;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class diseñoPDF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					diseñoPDF frame = new diseñoPDF();
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

			JOptionPane.showMessageDialog(null, "Error al generar el informe PDF.", "Error de Informe",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		if (reporte.isOpen()) {
			reporte.close();
		}

		JOptionPane.showMessageDialog(null, "Informe generado exitosamente.", "Informe Generado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void generarInforme2() {
		Document reporte = new Document();
		String ruta = System.getProperty("user.home");
		try {
			PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("Seguro Violeta.pdf"));

			reporte.open();

			try {
				Image encabezado1 = Image.getInstance("src/img/informe2.jpeg");
				encabezado1.scaleToFit(500, 650);
				encabezado1.setAlignment(Chunk.ALIGN_CENTER);
				reporte.add(encabezado1);
			} catch (IOException e) {

			}

		} catch (DocumentException | FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Error al generar el informe PDF.", "Error de Informe",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		if (reporte.isOpen()) {
			reporte.close();
		}

		JOptionPane.showMessageDialog(null, "Informe generado exitosamente.", "Informe Generado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void generarInforme3() {
		Document reporte = new Document();
		String ruta = System.getProperty("user.home");
		try {
			PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("Salud Sexual.pdf"));

			reporte.open();

			try {
				Image encabezado1 = Image.getInstance("src/img/informe5.jpeg");
				encabezado1.scaleToFit(500, 650);
				encabezado1.setAlignment(Chunk.ALIGN_CENTER);
				reporte.add(encabezado1);
			} catch (IOException e) {

			}

		} catch (DocumentException | FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Error al generar el informe PDF.", "Error de Informe",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		if (reporte.isOpen()) {
			reporte.close();
		}

		JOptionPane.showMessageDialog(null, "Informe generado exitosamente.", "Informe Generado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void generarInforme4() {
		Document reporte = new Document();
		String ruta = System.getProperty("user.home");
		try {
			PdfWriter writer = PdfWriter.getInstance(reporte, new FileOutputStream("Ley Olympia.pdf"));

			reporte.open();

			try {
				Image encabezado1 = Image.getInstance("src/img/informe4.jpeg");
				encabezado1.scaleToFit(500, 650);
				encabezado1.setAlignment(Chunk.ALIGN_CENTER);
				reporte.add(encabezado1);
			} catch (IOException e) {

			}

		} catch (DocumentException | FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Error al generar el informe PDF.", "Error de Informe",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		if (reporte.isOpen()) {
			reporte.close();
		}

		JOptionPane.showMessageDialog(null, "Informe generado exitosamente.", "Informe Generado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public diseñoPDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 204, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/encabezadoinfo.png")));
		lblNewLabel.setBounds(0, 0, 809, 60);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(114, 44, 55));
		panel.setBounds(0, 578, 809, 35);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 0, 128), 3));
		panel_1.setBackground(new Color(232, 204, 240));
		panel_1.setBounds(83, 102, 199, 164);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel btnimagenartedesermujer = new JLabel("");
		btnimagenartedesermujer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnimagenartedesermujer
						.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/foto2mestruacion.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnimagenartedesermujer.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/mestrupro1.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				elArteDeSerMujer arte = new elArteDeSerMujer();
				arte.setVisible(true);
				arte.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnimagenartedesermujer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnimagenartedesermujer.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/mestrupro1.png")));
		btnimagenartedesermujer.setBounds(10, 11, 179, 139);
		panel_1.add(btnimagenartedesermujer);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(139, 0, 139), 3));
		panel_2.setBackground(new Color(232, 204, 240));
		panel_2.setBounds(83, 348, 199, 154);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel btnderechossex = new JLabel("");
		btnderechossex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnderechossex.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/derechos2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnderechossex.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/derechossex.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				DerechosSexualesInforme derechos = new DerechosSexualesInforme();
				derechos.setVisible(true);
				derechos.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnderechossex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnderechossex.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/derechossex.png")));
		btnderechossex.setBounds(10, 11, 179, 130);
		panel_2.add(btnderechossex);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(139, 0, 139), 3));
		panel_3.setBackground(new Color(232, 204, 240));
		panel_3.setBounds(483, 102, 192, 164);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel btnsegurovio = new JLabel("");
		btnsegurovio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsegurovio.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/segurofoto2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnsegurovio.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/manoseg.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				SeguroVioleta seguro = new SeguroVioleta();
				seguro.setVisible(true);
				seguro.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnsegurovio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsegurovio.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/manoseg.png")));
		btnsegurovio.setBounds(10, 11, 172, 142);
		panel_3.add(btnsegurovio);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(139, 0, 139), 3));
		panel_4.setBackground(new Color(232, 204, 240));
		panel_4.setBounds(483, 348, 199, 154);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel btnley = new JLabel("");
		btnley.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnley.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/leyoli2.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnley.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/leyolimpia.png")));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				LeyOlimpia ley = new LeyOlimpia();
				ley.setVisible(true);
				ley.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnley.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnley.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/leyolimpia.png")));
		btnley.setBounds(10, 11, 179, 132);
		panel_4.add(btnley);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_4.setBounds(10, 71, 75, 68);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_6.setBounds(371, 474, 49, 60);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_7.setBounds(727, 266, 49, 60);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_8.setBounds(10, 376, 49, 50);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_9.setBounds(690, 75, 49, 64);
		contentPane.add(lblNewLabel_9);

		JButton btnelartedesermujer = new JButton("El arte de ser mujer PDF");
		btnelartedesermujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme();

			}
		});
		btnelartedesermujer.setBackground(new Color(221, 160, 221));
		btnelartedesermujer.setFont(new Font("Arial", Font.BOLD, 12));
		btnelartedesermujer.setBounds(93, 277, 178, 23);
		contentPane.add(btnelartedesermujer);

		JButton btnderechossexuales = new JButton("Derechos Sexuales PDF");
		btnderechossexuales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme3();
			}
		});
		btnderechossexuales.setBackground(new Color(221, 160, 221));
		btnderechossexuales.setFont(new Font("Arial", Font.BOLD, 12));
		btnderechossexuales.setBounds(93, 526, 178, 23);
		contentPane.add(btnderechossexuales);

		JButton btnsegurovioleta = new JButton("Seguro Violeta PDF");
		btnsegurovioleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme2();
			}
		});
		btnsegurovioleta.setBackground(new Color(221, 160, 221));
		btnsegurovioleta.setFont(new Font("Arial", Font.BOLD, 12));
		btnsegurovioleta.setBounds(493, 277, 171, 23);
		contentPane.add(btnsegurovioleta);

		JButton btnleyolimpia = new JButton("Ley Olimpia PDF");
		btnleyolimpia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInforme4();
			}
		});
		btnleyolimpia.setBackground(new Color(221, 160, 221));
		btnleyolimpia.setFont(new Font("Arial", Font.BOLD, 12));
		btnleyolimpia.setBounds(493, 513, 182, 23);
		contentPane.add(btnleyolimpia);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/sphere_24px.png")));
		lblNewLabel_10.setBounds(727, 477, 49, 57);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/butterfly_side_view_55.png")));
		lblNewLabel_11.setBounds(343, 71, 49, 50);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/sphere_24px.png")));
		lblNewLabel_12.setBounds(10, 266, 49, 34);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/sphere_24px.png")));
		lblNewLabel_13.setBounds(411, 233, 49, 50);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/sphere_24px.png")));
		lblNewLabel_14.setBounds(36, 532, 49, 35);
		contentPane.add(lblNewLabel_14);

		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInmujer menu = new MenuInmujer();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setBounds(343, 545, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(diseñoPDF.class.getResource("/img/encabezadoinfo.png")));
		lblNewLabel_1.setBounds(-75, 0, 192, 60);
		contentPane.add(lblNewLabel_1);
	}
}
