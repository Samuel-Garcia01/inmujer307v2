package SEGUROVIOLETA;
	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

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
	import java.util.Calendar;
	import java.util.GregorianCalendar;

	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.awt.event.ActionEvent;
	import javax.swing.SwingConstants;
 //puto el kevin
	public class NumeroDeExpediente extends JFrame {
	    private JPanel contentPane;
	    private JTextField txtInforme;
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    NumeroDeExpediente frame = new NumeroDeExpediente();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    // Constructor de la clase
	    public NumeroDeExpediente() {
	        setUndecorated(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 823, 650);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(255, 255, 255));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        // Agregar la etiqueta y el campo de texto para el número de expediente
	        JLabel lblNewLabel_12 = new JLabel("Ingrese el número de expediente");
	        lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_12.setBounds(311, 214, 205, 14);
	        contentPane.add(lblNewLabel_12);

	        txtInforme = new JTextField();
	        txtInforme.setBounds(350, 237, 141, 20);
	        contentPane.add(txtInforme);
	        txtInforme.setColumns(10);

	        // Botón para buscar el expediente
	        JButton btngenerar = new JButton("Buscar");
	        btngenerar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String id = txtInforme.getText();
	                if (id.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Debe ingresar un número", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                    // Realizar la consulta para obtener los datos del expediente
	                    String sql = "SELECT * FROM datos WHERE EXP = ?";
	                    ConexionInmujer conexion = new ConexionInmujer();
	                    Connection con = conexion.conectar();

	                    try {
	                        PreparedStatement pst = con.prepareStatement(sql);
	                        pst.setString(1, id);
	                        ResultSet rs = pst.executeQuery();
	                        
	                        if (rs.next()) {
	                            // Si el expediente existe, abrir la ventana DATOSDELAGRESOR
	                            Efectosfisicos datosVentana = new Efectosfisicos();
	                            datosVentana.setVisible(true);
	                            datosVentana.setLocationRelativeTo(null);
	                            datosVentana.cargarDatos(rs);
	                            dispose(); // Cierra la ventana de expediente
	                        } else {
	                            JOptionPane.showMessageDialog(null, "No se encontró el expediente", "Error", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } catch (SQLException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        });
	        btngenerar.setBounds(350, 272, 141, 34);
	        contentPane.add(btngenerar);
	    }
	}
