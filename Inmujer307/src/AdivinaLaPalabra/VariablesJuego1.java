package AdivinaLaPalabra;

import java.util.Random;

public class VariablesJuego1 {
    private String palabraSeleccionada;
    private String palabraAdivinada;
    private int intentosRestantes;
    private int intentosMaximos;  // Nuevo campo para los intentos máximos
    private String[] palabras = {
    	    "mujer", 
    	    "igualdad", 
    	    "derechos", 
    	    "liberación",
    	    "violencia", 
    	    "libertad", 
    	    "respeto", 
    	    "solidaridad", 
    	    "equidad", 
    	    "justicia", 
    	    "lucha", 
    	    "esperanza",
    	    "valentía", 
    	    "sueños", 
    	    "dignidad", 
    	    "igualdad", 
    	    "fuerza", 
    	    "resiliencia", 
    	    "cambio", 
    	    "union"
    	};

    public VariablesJuego1() {
        reiniciar();  // Llamar a reiniciar al inicializar
    }

    // Seleccionar una palabra aleatoria de la lista
    public void seleccionarPalabra() {
        Random rand = new Random();
        palabraSeleccionada = palabras[rand.nextInt(palabras.length)];
        palabraAdivinada = "_".repeat(palabraSeleccionada.length());  // Inicializar con guiones bajos
    }

    // Reiniciar todos los valores del juego
    public void reiniciar() {
        seleccionarPalabra();
        intentosMaximos = 6;  // Establecer intentos máximos (por ejemplo, 6 intentos)
        intentosRestantes = intentosMaximos;  // Inicializar con el valor de intentos máximos
        palabraAdivinada = "_".repeat(palabraSeleccionada.length());  // Resetear palabra adivinada
    }

    // Obtener la palabra adivinada
    public String getPalabraAdivinada() {
        return palabraAdivinada;
    }

    // Procesar una letra y actualizar la palabra adivinada
    public boolean procesarLetra(String letra) {
        boolean letraCorrecta = false;
        StringBuilder nuevaPalabraAdivinada = new StringBuilder(palabraAdivinada);

        // Verificar si la letra está en la palabra seleccionada
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                nuevaPalabraAdivinada.setCharAt(i, letra.charAt(0));
                letraCorrecta = true;
            }
        }

        if (letraCorrecta) {
            palabraAdivinada = nuevaPalabraAdivinada.toString();
        } else {
            intentosRestantes--;
        }

        return letraCorrecta;
    }

    // Verificar si el jugador ha ganado
    public boolean haGanado() {
        return palabraAdivinada.equals(palabraSeleccionada);
    }

    // Verificar si el jugador ha perdido
    public boolean haPerdido() {
        return intentosRestantes <= 0;
    }

    // Obtener los intentos restantes
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    // Obtener la palabra completa
    public String getPalabraSeleccionada() {
        return palabraSeleccionada;
    }

    // Verificar si la letra ya ha sido adivinada
    public boolean yaAdivinada(String letra) {
        return palabraAdivinada.contains(letra);
    }

    // Establecer el número de intentos máximos según la dificultad
    public void setIntentosMaximos(int intentos) {
        this.intentosMaximos = intentos;
        this.intentosRestantes = intentos;  // Reiniciar los intentos restantes cuando se cambia la dificultad
    }

    // Obtener los intentos máximos (por si necesitas mostrarlo o verificarlo)
    public int getIntentosMaximos() {
        return intentosMaximos;
    }
}
