package MenuInmujer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import GraficaBarras.Efectos_Fisicos;
import GraficaBarras.Efectos_Psicologicos;
import GraficaBarras.Efectos_Sexuales;
import GraficaBarras.TiposDeViolencia;
import GraficasPastel.Colonias;
import GraficasPastel.Edades;
import GraficasPastel.ModalidadViolencia;
import GraficasPastel.Colonias;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class menuGraficas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuGraficas frame = new menuGraficas();
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
	public menuGraficas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/pie.png")));
		lblNewLabel_1.setBounds(10, 551, 807, 61);
		contentPane.add(lblNewLabel_1);
		
		JLabel img1 = new JLabel("");
		img1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img1.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img1.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica.jpg")));
			}
		});
		img1.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica.jpg")));
		img1.setBounds(10, 93, 140, 140);
		contentPane.add(img1);
		
		JLabel img5 = new JLabel("");
		img5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img5.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG5.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img5.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica4.jpg")));
			}
		});
		img5.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica4.jpg")));
		img5.setBounds(10, 313, 140, 140);
		contentPane.add(img5);
		
		JLabel img2 = new JLabel("");
		img2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img2.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG2.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img2.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica1.jpg")));
			}
		});
		img2.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica1.jpg")));
		img2.setBounds(194, 93, 140, 140);
		contentPane.add(img2);
		
		JLabel img3 = new JLabel("");
		img3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img3.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG3.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img3.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica2.jpg")));
			}
		});
		img3.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica2.jpg")));
		img3.setBounds(412, 93, 140, 140);
		contentPane.add(img3);
		
		JLabel img4 = new JLabel("");
		img4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img4.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG4.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img4.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica3.jpg")));
			}
		});
		img4.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica3.jpg")));
		img4.setBounds(645, 93, 140, 140);
		contentPane.add(img4);
		
		JLabel img6 = new JLabel("");
		img6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img6.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG6.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img6.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica6.jpg")));
			}
		});
		img6.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica6.jpg")));
		img6.setBounds(194, 313, 140, 140);
		contentPane.add(img6);
		
		JLabel img7 = new JLabel("");
		img7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img7.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG7.jpg")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				img7.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica7.jpg")));
			}
		});
		img7.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica7.jpg")));
		img7.setBounds(412, 313, 140, 140);
		contentPane.add(img7);
		
		JLabel img8 = new JLabel("");
		img8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				img8.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/IMG8.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				img8.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica.jpg")));
			}
		});
		img8.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/grafica.jpg")));
		img8.setBounds(645, 313, 140, 140);
		contentPane.add(img8);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/butterfly_side_view_56.png")));
		lblNewLabel_2.setBounds(262, 3, 50, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/butterfly_side_espejo.png")));
		lblNewLabel_3.setBounds(488, 3, 57, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/encabezado.jpg")));
		lblNewLabel.setBounds(0, 0, 807, 61);
		contentPane.add(lblNewLabel);
		
		JLabel btnModalidades = new JLabel("");
		btnModalidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModalidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModalidades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnModalidades1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModalidades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnModalidades.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ModalidadViolencia ventana = new ModalidadViolencia();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnModalidades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnModalidades.jpg")));
		btnModalidades.setBounds(10, 244, 140, 27);
		contentPane.add(btnModalidades);
		
		JLabel btnTiposViolencia = new JLabel("");
		btnTiposViolencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTiposViolencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTiposViolencia.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnViolencia1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTiposViolencia.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnViolencia.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TiposDeViolencia ventana = new TiposDeViolencia();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnTiposViolencia.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnViolencia.jpg")));
		btnTiposViolencia.setBounds(194, 244, 140, 27);
		contentPane.add(btnTiposViolencia);
		
		JLabel btnColonias = new JLabel("");
		btnColonias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnColonias.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnColonias1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnColonias.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnColonias.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Colonias ventana = new Colonias();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnColonias.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnColonias.jpg")));
		btnColonias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnColonias.setBounds(412, 244, 140, 27);
		contentPane.add(btnColonias);
		
		JLabel btnEdades = new JLabel("");
		btnEdades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEdades2.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEdades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEdades.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Edades ventana = new Edades();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnEdades.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEdades.jpg")));
		btnEdades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdades.setBounds(645, 244, 140, 27);
		contentPane.add(btnEdades);
		
		JLabel btnEfectosFisicos = new JLabel("");
		btnEfectosFisicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEfectosFisicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnFisicos2.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEfectosFisicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnFisicos1.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Efectos_Fisicos ventana = new Efectos_Fisicos();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnEfectosFisicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnFisicos1.jpg")));
		btnEfectosFisicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEfectosFisicos.setBounds(10, 466, 140, 27);
		contentPane.add(btnEfectosFisicos);
		
		JLabel btnEfectosPsicologicos = new JLabel("");
		btnEfectosPsicologicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEfectosPsicologicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnPsicologicos1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEfectosPsicologicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnPsicologicos.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Efectos_Psicologicos ventana = new Efectos_Psicologicos();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnEfectosPsicologicos.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnPsicologicos.jpg")));
		btnEfectosPsicologicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEfectosPsicologicos.setBounds(187, 464, 147, 29);
		contentPane.add(btnEfectosPsicologicos);
		
		JLabel btnViolenciaSexual = new JLabel("");
		btnViolenciaSexual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnViolenciaSexual.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnSexual1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnViolenciaSexual.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnSexual.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Efectos_Sexuales ventana = new Efectos_Sexuales();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnViolenciaSexual.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnSexual.jpg")));
		btnViolenciaSexual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViolenciaSexual.setBounds(412, 464, 140, 29);
		contentPane.add(btnViolenciaSexual);
		
		JLabel btnViolenciaEconomica = new JLabel("");
		btnViolenciaEconomica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnViolenciaEconomica.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEconomica1.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnViolenciaEconomica.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEconomica.jpg")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnViolenciaEconomica.setIcon(new ImageIcon(menuGraficas.class.getResource("/IMG/btnEconomica.jpg")));
		btnViolenciaEconomica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViolenciaEconomica.setBounds(645, 471, 152, 29);
		contentPane.add(btnViolenciaEconomica);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 59, 807, 493);
		contentPane.add(panel);
	}
}
