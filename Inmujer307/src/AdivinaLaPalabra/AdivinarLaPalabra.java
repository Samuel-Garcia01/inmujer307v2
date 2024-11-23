package AdivinaLaPalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import AdivinaLaPalabra.VariablesJuego1;
public class AdivinarLaPalabra extends JFrame {
	private JTextArea palabraAdivinadaArea;
    private JTextField letraInput;
    private JButton intentarBtn, reiniciarBtn;
    private JLabel mensajeError;
    private VariablesJuego1 juego; // Instancia de la clase VariablesJuego1
    private JPanel panelDificultad;

    public AdivinarLaPalabra(VariablesJuego1 juego) {
        // Asignamos el objeto juego que se pasa en el constructor
        this.juego = juego;
        
        // Configuración básica de JFrame
        setTitle("Juego de Adivinar la Palabra");
        setSize(644, 459);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar los componentes de la interfaz gráfica
        inicializarComponentes(); // Llamar al método que inicializa los componentes

        // Configurar el juego inicial
        reiniciarJuego(); // Llamar al método de reiniciar juego
    }

    private void inicializarComponentes() {
        getContentPane().setLayout(null);
        // Configurar el JTextArea para mostrar la palabra adivinada
        palabraAdivinadaArea = new JTextArea();
        palabraAdivinadaArea.setBounds(141, 87, 300, 50);
        palabraAdivinadaArea.setFont(new Font("Arial", Font.PLAIN, 30));
        palabraAdivinadaArea.setEditable(false);
        palabraAdivinadaArea.setBackground(getBackground());
        getContentPane().add(palabraAdivinadaArea);

        // Campo para que el usuario ingrese una letra
        letraInput = new JTextField();
        letraInput.setBounds(214, 174, 100, 30);
        letraInput.setFont(new Font("Arial", Font.PLAIN, 20));
        getContentPane().add(letraInput);

        // Botón para intentar la letra
        intentarBtn = new JButton("Intentar");
        intentarBtn.setBounds(214, 255, 100, 30);
        getContentPane().add(intentarBtn);

        // Botón para reiniciar el juego
        reiniciarBtn = new JButton("Reiniciar");
        reiniciarBtn.setBounds(214, 300, 100, 30);
        getContentPane().add(reiniciarBtn);

        // Mensaje de error
        mensajeError = new JLabel("");
        mensajeError.setBounds(141, 355, 300, 30);
        mensajeError.setFont(new Font("Arial", Font.PLAIN, 14));
        getContentPane().add(mensajeError);

        // Panel para selección de dificultad
        panelDificultad = new JPanel();
        panelDificultad.setBounds(131, 13, 370, 50);
        panelDificultad.setLayout(new FlowLayout());
        getContentPane().add(panelDificultad);

        // Botones para seleccionar dificultad
        JButton facilBtn = new JButton("Fácil");
        JButton medioBtn = new JButton("Medio");
        JButton dificilBtn = new JButton("Difícil");

        panelDificultad.add(facilBtn);
        panelDificultad.add(medioBtn);
        panelDificultad.add(dificilBtn);

        // Acción para la dificultad fácil
        facilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(10);  // Establece 10 intentos para fácil
                reiniciarJuego();
            }
        });

        // Acción para la dificultad media
        medioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(6);  // Establece 6 intentos para medio
                reiniciarJuego();
            }
        });

        // Acción para la dificultad difícil
        dificilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(3);  // Establece 3 intentos para difícil
                reiniciarJuego();
            }
        });

        // Agregar acción al botón "Intentar"
        intentarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLetra();
            }
        });

        // Acción al hacer clic en "Reiniciar"
        reiniciarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
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
            letraInput.setText("");  // Limpiar el campo de entrada
            return;
        }

        // Comprobar si la letra ya fue intentada
        if (juego.yaAdivinada(letra)) {
            mensajeError.setText("Ya adivinaste esta letra.");
            letraInput.setText("");  // Limpiar el campo de entrada
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
        } else if (juego.haPerdido()) {
            mensajeError.setText("Game Over. La palabra era: " + juego.getPalabraSeleccionada());
        }

        letraInput.setText("");  // Limpiar el campo de entrada
    }

    private void reiniciarJuego() {
        juego.seleccionarPalabra();  // Seleccionar una nueva palabra
        palabraAdivinadaArea.setText(juego.getPalabraAdivinada());
        mensajeError.setText("");
        letraInput.setText("");  // Limpiar el campo de entrada
    }

    public static void main(String[] args) {
        // Crear la instancia de juego
        VariablesJuego1 juego = new VariablesJuego1();

        // Crear la ventana inicial para seleccionar dificultad
        JFrame dificultadVentana = new JFrame("Selecciona la dificultad");
        dificultadVentana.setSize(400, 200);
        dificultadVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel dificultadPanel = new JPanel();
        dificultadVentana.getContentPane().add(dificultadPanel);

        JButton facilBtn = new JButton("Fácil");
        JButton medioBtn = new JButton("Medio");
        JButton dificilBtn = new JButton("Difícil");

        dificultadPanel.add(facilBtn);
        dificultadPanel.add(medioBtn);
        dificultadPanel.add(dificilBtn);

        // Acción para la dificultad fácil
        facilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(10);  // Establece 10 intentos para fácil
                dificultadVentana.setVisible(false);
                AdivinarLaPalabra ventana = new AdivinarLaPalabra(juego);
                ventana.setVisible(true);
            }
        });

        // Acción para la dificultad media
        medioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(6);  // Establece 6 intentos para medio
                dificultadVentana.setVisible(false);
                AdivinarLaPalabra ventana = new AdivinarLaPalabra(juego);
                ventana.setVisible(true);
            }
        });

        // Acción para la dificultad difícil
        dificilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setIntentosMaximos(3);  // Establece 3 intentos para difícil
                dificultadVentana.setVisible(false);
                AdivinarLaPalabra ventana = new AdivinarLaPalabra(juego);
                ventana.setVisible(true);
            }
        });

        dificultadVentana.setVisible(true);
    }
}