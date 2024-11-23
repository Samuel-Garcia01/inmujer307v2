package Memorama;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class JuegoDeMemoria extends JFrame {
    private ControladorDeJuego controlador;
    private ArrayList<Carta> cartas;

    
    public JuegoDeMemoria() {
        controlador = new ControladorDeJuego(this); // Pasamos la referencia de la ventana
        cartas = new ArrayList<>();

        // Configuración de la ventana
        setTitle("Juego de Memoria");
        setLayout(new GridLayout(4, 4));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar la imagen de reverso (la imagen de fondo de las cartas)
        ImageIcon reverso = new ImageIcon("src/img/reverso.png");

        // Cargar las rutas de las imágenes para las cartas (8 pares)
        String[] imagenes = {
            "src/img/Inmujer1.jpg", "src/img/Inmujer2.jpg", "src/img/Inmujer3.jpg", "src/img/Inmujer4.jpg",
            "src/img/Inmujer5.jpg", "src/img/Inmujer6.jpg", "src/img/inmer7.png", "src/img/Inmujer8.jpg",
            "src/img/Inmujer1.jpg", "src/img/Inmujer2.jpg", "src/img/Inmujer3.jpg", "src/img/Inmujer4.jpg",
            "src/img/Inmujer5.jpg", "src/img/Inmujer6.jpg", "src/img/inmer7.png", "src/img/Inmujer8.jpg"
        };

        // Mezclar las cartas para que aparezcan en posiciones aleatorias
        ArrayList<String> listaImagenes = new ArrayList<>();
        Collections.addAll(listaImagenes, imagenes);
        Collections.shuffle(listaImagenes);

        // Crear y agregar cada carta con su imagen oculta
        for (String imagenRuta : listaImagenes) {
            Carta carta = new Carta(imagenRuta, reverso);
            carta.addActionListener(controlador);
            cartas.add(carta);
            add(carta);
        }

        setVisible(true);
    }

    // Método para verificar si el jugador ha ganado
    public void verificarVictoria() {
        boolean todasDescubiertas = cartas.stream().allMatch(Carta::isDescubierta);
        if (todasDescubiertas) {
            int respuesta = JOptionPane.showOptionDialog(
                this,
                "¡Felicidades, has ganado! 🎉\n¿Quieres jugar de nuevo?",
                "Juego Terminado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Reintentar", "Salir"},
                "Reintentar"
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                // Reiniciar el juego
                dispose();
                iniciarJuego();
            } else {
                System.exit(0); // Salir del juego
            }
        }
    }

    // Método para iniciar el juego
    public static void iniciarJuego() {
        new JuegoDeMemoria();
    }

    public static void main(String[] args) {
        iniciarJuego();
    }
}
