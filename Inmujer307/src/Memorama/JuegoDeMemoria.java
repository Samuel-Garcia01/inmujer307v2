package Memorama;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import MenuInmujer.MenuDeJuegos;
public class JuegoDeMemoria extends JFrame {
	private ControladorDeJuego controlador;
    private ArrayList<Carta> cartas;
    private Timer temporizador;
    private Timer temporizadorLimite;
    private int segundos = 0;
    private int tiempoLimite = 50;

    public JuegoDeMemoria() {
        controlador = new ControladorDeJuego(this);
        cartas = new ArrayList<>();

        setTitle("Juego de Memoria");
        getContentPane().setLayout(new GridLayout(4, 4));
        setPreferredSize(new Dimension(823, 650));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon reverso = cargarImagen("src/img2/reverso.png");
        ArrayList<String> listaImagenes = cargarYMezclarCartas();

        for (String imagenRuta : listaImagenes) {
            Carta carta = new Carta(imagenRuta, reverso);
            carta.addActionListener(controlador);
            cartas.add(carta);
            getContentPane().add(carta);
        }

        iniciarTemporizador();
        iniciarTemporizadorLimite();
        setVisible(true);
    }

    private ArrayList<String> cargarYMezclarCartas() {
        String[] imagenes = {
            "src/img2/Inmujer1.jpg", "src/img2/Inmujer2.jpg", "src/img2/Inmujer3.jpg", "src/img2/Inmujer4.jpg",
            "src/img2/Inmujer5.jpg", "src/img2/Inmujer6.jpg", "src/img2/inmer7.png", "src/img2/Inmujer8.jpg",
            "src/img2/Inmujer1.jpg", "src/img2/Inmujer2.jpg", "src/img2/Inmujer3.jpg", "src/img2/Inmujer4.jpg",
            "src/img2/Inmujer5.jpg", "src/img2/Inmujer6.jpg", "src/img2/inmer7.png", "src/img2/Inmujer8.jpg"
        };
        ArrayList<String> listaImagenes = new ArrayList<>();
        Collections.addAll(listaImagenes, imagenes);
        Collections.shuffle(listaImagenes);
        return listaImagenes;
    }

    private ImageIcon cargarImagen(String ruta) {
        return new ImageIcon(ruta);
    }

    private void iniciarTemporizador() {
        temporizador = new Timer(1000, e -> segundos++);
        temporizador.start();
    }

    private void iniciarTemporizadorLimite() {
        temporizadorLimite = new Timer(1000, e -> {
            tiempoLimite--;
            String tiempoRestante = String.format("%02d:%02d", tiempoLimite / 60, tiempoLimite % 60);
            setTitle("Juego de Memoria - Tiempo restante: " + tiempoRestante);

            if (tiempoLimite <= 0) {
                temporizadorLimite.stop();
                mostrarDialogoFin("¡Tiempo agotado! 😱\n¿Quieres reiniciar el juego?");
            }
        });
        temporizadorLimite.start();
    }

    public void verificarVictoria() {
        boolean todasDescubiertas = cartas.stream().allMatch(Carta::isDescubierta);
        if (todasDescubiertas) {
            mostrarDialogoFin("¡Felicidades, has ganado! 🎉\n¿Quieres jugar de nuevo?");
        }
    }

    private void mostrarDialogoFin(String mensaje) {
        int respuesta = JOptionPane.showOptionDialog(
            this,
            mensaje,
            "Juego Terminado",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Reintentar", "Pantalla Principal", "Salir"},
            "Reintentar"
        );

        switch (respuesta) {
        case JOptionPane.YES_OPTION:
            dispose();
            iniciarJuego();
            break;
        case JOptionPane.NO_OPTION:
            // Aquí es donde el juego se va al menú principal
            MenuDeJuegos menu = new MenuDeJuegos(); // Abre el menú principal
            menu.setVisible(true); 
            dispose();  // Cierra el juego de memoria
            break;
        case JOptionPane.CANCEL_OPTION:
            System.exit(0);
            break;
    }
}

    public static void iniciarJuego() {
        new JuegoDeMemoria();
    }

    public static void main(String[] args) {
        iniciarJuego();
    }
}