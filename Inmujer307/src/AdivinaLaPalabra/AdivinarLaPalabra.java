package AdivinaLaPalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MenuInmujer.MenuDeJuegos;

public class AdivinarLaPalabra extends JFrame {
    private JTextArea palabraAdivinadaArea;
    private JTextField letraInput;
    private JButton reiniciarBtn;
    private JButton volverMenuBtn;  // Botón para volver al menú
    private JLabel mensajeError;
    private VariablesJuego1 juego; // Instancia de la clase VariablesJuego1

    public AdivinarLaPalabra(VariablesJuego1 juego) {
    	getContentPane().setBackground(new Color(233, 150, 122));
        // Asignamos el objeto juego que se pasa en el constructor
        this.juego = juego;

        // Configuración básica de JFrame
        setTitle("Juego de Adivinar la Palabra");
        setSize(823, 648);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar los componentes de la interfaz gráfica
        inicializarComponentes();

        // Configurar el juego inicial
        reiniciarJuego();
    }

    private void inicializarComponentes() {
        getContentPane().setLayout(null);

        // Configurar el JTextArea para mostrar la palabra adivinada
        palabraAdivinadaArea = new JTextArea();
        palabraAdivinadaArea.setBounds(243, 150, 332, 50);
        palabraAdivinadaArea.setFont(new Font("Arial", Font.PLAIN, 30));
        palabraAdivinadaArea.setEditable(false);
        palabraAdivinadaArea.setBackground(getBackground());
        getContentPane().add(palabraAdivinadaArea);

        // Campo para que el usuario ingrese una letra
        letraInput = new JTextField();
        letraInput.setBounds(305, 246, 192, 30);
        letraInput.setFont(new Font("Arial", Font.PLAIN, 20));
        getContentPane().add(letraInput);

        // Botón para reiniciar el juego
        reiniciarBtn = new JButton("Reiniciar");
        reiniciarBtn.setBounds(305, 349, 192, 30);
        getContentPane().add(reiniciarBtn);

        // Botón para volver al menú principal
        volverMenuBtn = new JButton("Volver al Menú");
        volverMenuBtn.setBounds(305, 420, 192, 30); // Ubicación del botón
        getContentPane().add(volverMenuBtn);

        // Mensaje de error
        mensajeError = new JLabel("");
        mensajeError.setBounds(125, 58, 300, 30);
        mensajeError.setFont(new Font("Arial", Font.PLAIN, 14));
        getContentPane().add(mensajeError);
        
        JLabel lblNewLabel = new JLabel("ADIVINA LA PALABRA");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel.setForeground(new Color(230, 230, 250));
        lblNewLabel.setBackground(new Color(230, 230, 250));
        lblNewLabel.setBounds(291, 24, 192, 13);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_1.setBounds(243, 0, 45, 51);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_espejo.png")));
        lblNewLabel_2.setBounds(466, 0, 45, 51);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_4.setBounds(98, 445, 63, 64);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_5.setBounds(670, 246, 50, 71);
        getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_6.setBounds(95, 98, 66, 64);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/LG.png")));
        lblNewLabel_3.setBounds(717, 0, 63, 61);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/encabezado.gif")));
        lblNewLabel_7.setBounds(0, 0, 809, 61);
        getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon(AdivinarLaPalabra.class.getResource("/img/butterfly_side_view_56.png")));
        lblNewLabel_8.setBounds(485, 529, 45, 50);
        getContentPane().add(lblNewLabel_8);

        // Acción al hacer clic en "Reiniciar"
        reiniciarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });

        // Acción al hacer clic en "Volver al Menú"
        volverMenuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirige al menú principal
                MenuDeJuegos menu = new MenuDeJuegos(); // Abre el menú principal
                menu.setVisible(true); 
                dispose();  // Cierra la ventana actual
            }
        });

        // Configurar evento para presionar "Enter"
        letraInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLetra();
            }
        });
    }

    private void procesarLetra() {
        String letra = letraInput.getText().toLowerCase();

        // Validar si la letra es válida (solo una letra, sin números ni caracteres especiales)
        if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
            mensajeError.setText("Por favor, ingresa solo una letra.");
            letraInput.setText(""); // Limpiar el campo de entrada
            return;
        }

        // Comprobar si la letra ya fue intentada
        if (juego.yaAdivinada(letra)) {
            mensajeError.setText("Ya adivinaste esta letra.");
            letraInput.setText(""); // Limpiar el campo de entrada
            return;
        }

        // Verificar si la letra está en la palabra
        boolean letraCorrecta = juego.procesarLetra(letra);

        if (letraCorrecta) {
            palabraAdivinadaArea.setText(juego.getPalabraAdivinada());
            mensajeError.setText("¡Letra correcta!");
        } else {
            mensajeError.setText("Letra incorrecta. Intentos restantes: " + juego.getIntentosRestantes());
        }

        // Verificar si el jugador ha ganado o perdido
        if (juego.haGanado()) {
            mensajeError.setText("¡Felicidades! Has adivinado la palabra.");
            letraInput.setEditable(false); // Bloquear el campo de entrada
        } else if (juego.haPerdido()) {
            mensajeError.setText("Game Over. La palabra era: " + juego.getPalabraSeleccionada());
            letraInput.setEditable(false); // Bloquear el campo de entrada
        }

        letraInput.setText(""); // Limpiar el campo de entrada
    }

    private void reiniciarJuego() {
        juego.reiniciar(); // Reiniciar el juego completamente en la clase VariablesJuego1
        palabraAdivinadaArea.setText(juego.getPalabraAdivinada());
        mensajeError.setText("");
        letraInput.setText(""); // Limpiar el campo de entrada
        letraInput.setEditable(true); // Habilitar el campo de entrada nuevamente
    }

    public static void main(String[] args) {
        // Crear la instancia de juego
        VariablesJuego1 juego = new VariablesJuego1();

        // Crear la ventana principal
        AdivinarLaPalabra ventana = new AdivinarLaPalabra(juego);
        ventana.setVisible(true);
    }
}
