package SEGUROVIOLETA;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import ConexionBaseDeDatos.ConexionInmujer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RedesDeApoyo extends JFrame {

    private JPanel contentPane;
    private JTextField txtTiposDeApoyo;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private ConexionInmujer conexion;
    private Connection con;

    public static void main(String[] args) {
       
            try {
                int exp = 1; 
                RedesDeApoyo frame = new RedesDeApoyo(exp);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    

    public RedesDeApoyo(int exp) {
        this(); 
        cargarDatos(exp);
    }

    public RedesDeApoyo() {
        conexion = new ConexionInmujer();
        con = conexion.conectar();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 823, 650);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(247, 231, 245));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 809, 57);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_5.setBounds(224, 0, 50, 57);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/butterfly_side_espejo.png")));
        lblNewLabel_6.setBounds(506, 0, 50, 57);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Redes de Apoyo");
        lblNewLabel_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_7.setBounds(316, 10, 161, 37);
        panel.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon(RedesDeApoyo.class.getResource("/img/encabezado.gif")));
        lblNewLabel_8.setBounds(0, 0, 809, 57);
        panel.add(lblNewLabel_8);

      
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
        panel_1.setBackground(new Color(243, 220, 220));
        panel_1.setBounds(431, 77, 331, 153);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombre.setBounds(10, 56, 69, 13);
        panel_1.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setBounds(89, 53, 155, 19);
        panel_1.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 12));
        lblTelefono.setBounds(10, 105, 69, 13);
        panel_1.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setEditable(false);
        txtTelefono.setBounds(89, 101, 155, 19);
        panel_1.add(txtTelefono);
        txtTelefono.setColumns(10);

       
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBorder(new LineBorder(new Color(233, 150, 122), 3));
        panel_1_1.setBackground(new Color(243, 220, 220));
        panel_1_1.setBounds(54, 77, 331, 364);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);

        JLabel lblTiposDeApoyo = new JLabel("Tipos de Apoyo:");
        lblTiposDeApoyo.setFont(new Font("Arial", Font.BOLD, 12));
        lblTiposDeApoyo.setBounds(10, 25, 105, 13);
        panel_1_1.add(lblTiposDeApoyo);

        txtTiposDeApoyo = new JTextField();
        txtTiposDeApoyo.setEditable(false);
        txtTiposDeApoyo.setBounds(125, 21, 196, 19);
        panel_1_1.add(txtTiposDeApoyo);
        txtTiposDeApoyo.setColumns(10);

        JLabel lblViabilidad = new JLabel("Viabilidad de la red de apoyo");
        lblViabilidad.setFont(new Font("Arial", Font.PLAIN, 12));
        lblViabilidad.setBounds(10, 70, 172, 14);
        panel_1_1.add(lblViabilidad);

       
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 12));
        btnSiguiente.setBounds(533, 510, 142, 34);
        contentPane.add(btnSiguiente);
        
        JButton btnNewButton = new JButton("Inicio");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(137, 510, 131, 34);
        contentPane.add(btnNewButton);

        
       
    }

    public void cargarDatos(int exp) {
        String sql = "SELECT Redes_de_apoyo, Nombre_de_la_victima, Telefono_Celular FROM datos WHERE EXP = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, exp);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtTiposDeApoyo.setText(rs.getString("Redes_de_apoyo"));
                txtNombre.setText(rs.getString("Nombre_de_la_victima"));
                txtTelefono.setText(rs.getString("Telefono_Celular"));
            } else {
                System.out.println("Datos no encontrados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
    }
}
