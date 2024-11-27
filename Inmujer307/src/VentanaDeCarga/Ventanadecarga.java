package VentanaDeCarga;

import javax.swing.*;

import MenuInmujer.MenuInmujer;

import java.awt.*;

public class Ventanadecarga extends JFrame {
    private static final long serialVersionUID = 1L;

    public Ventanadecarga() {
        // Configuración del JFrame
        setTitle("Pantalla de Carga");
        setSize(600, 400); // Tamaño más pequeño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true); // Elimina el borde del JFrame

        // Panel para el borde
        JPanel borde = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar contorno con color "In Mujer"
                g.setColor(new Color(242, 113, 151)); // Rosa pastel
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        borde.setBackground(Color.WHITE);
        borde.setLayout(new BorderLayout());
        borde.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Grosor del borde

        // Panel principal con imagen de fondo
        JPanel carga = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon fondo = new ImageIcon(Ventanadecarga.class.getResource("/img/in.jpg"));
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Imagen en toda la ventana
            }
        };
        carga.setBackground(Color.WHITE);
        carga.setLayout(null);
        
        // Barra de progreso animada
        BarraProgreso barradecarga = new BarraProgreso();
        barradecarga.setBackground(Color.WHITE);
        barradecarga.setBounds(10, 329, 560, 40); // Posicionado 
        carga.add(barradecarga);
        barradecarga.setLayout(null);

        borde.add(carga); // Añadimos el panel principal dentro del panel con borde
        getContentPane().add(borde);
        
        // Hilo para simular el tiempo de carga
        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) { // simula el tiemo que se tarda en entrar ala otra ventna 
                	barradecarga.setProgreso(i);
                    Thread.sleep(20); // Simula el tiempo de carga de la barra de carga
                }
                dispose(); // Cierra la pantalla de carga
                abrirMenuInmujer(); // Abre la ventana principal
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    

    // Método para abrir la ventana principal
    private void abrirMenuInmujer() {
    	MenuInmujer MenuInmujer = new MenuInmujer();
    	MenuInmujer.setLocationRelativeTo(null);
    	MenuInmujer.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ventanadecarga().setVisible(true);
        });
    }
}

class BarraProgreso extends JPanel {
    private static final long serialVersionUID = 1L;
    private int progreso = 0;

    public void setProgreso(int progreso) {
        this.progreso = progreso;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo de la barra
        g2d.setColor(new Color(255, 255, 255, 100)); // Blanco semitransparente
        g2d.fillRoundRect(0, 10, getWidth(), 20, 10, 10);

        // Progreso de la barra
        g2d.setColor(new Color(242, 113, 151, 180)); // Rosa pastel semitransparente
        g2d.fillRoundRect(0, 10, (int) (getWidth() * (progreso / 100.0)), 20, 10, 10);

        // Bordes de la barra
        g2d.setColor(new Color(0, 0, 0, 200)); // Negro semitransparente
        g2d.drawRoundRect(0, 10, getWidth(), 20, 10, 10);
    }
}