package Memorama;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDeJuego implements ActionListener {
    private Carta cartaSeleccionada;
    private Carta cartaAnterior;
    private boolean esperando = false;
    private JuegoDeMemoria juego; // Referencia a la ventana principal

    // Constructor para recibir la referencia del juego
    public ControladorDeJuego(JuegoDeMemoria juego) {
        this.juego = juego;
    }

    public void seleccionarCarta(Carta carta) {
        if (esperando || carta.isDescubierta()) return;

        carta.mostrarImagen();

        if (cartaAnterior == null) {
            cartaAnterior = carta;
        } else {
            if (cartaAnterior.getImagenRuta().equals(carta.getImagenRuta())) {
                // Coincidencia encontrada, ambas cartas permanecen descubiertas
                cartaAnterior = null; // Reinicia la selección
                // Verifica si todas las cartas están descubiertas
                juego.verificarVictoria();
            } else {
                esperando = true;
                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        carta.ocultarImagen();
                        cartaAnterior.ocultarImagen();
                        cartaAnterior = null;
                        esperando = false;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Carta cartaSeleccionada = (Carta) e.getSource();
        seleccionarCarta(cartaSeleccionada);
    }
}