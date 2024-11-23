package Memorama;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Carta extends JButton {
	private String imagenRuta;
    private boolean descubierta;
    private ImageIcon imagen;
    private ImageIcon reverso;

    public Carta(String imagenRuta, ImageIcon reverso) {
        this.imagenRuta = imagenRuta;
        this.reverso = new ImageIcon("src/img/tarjeta1.jpg"); 
        this.imagen = new ImageIcon(imagenRuta); 
        this.descubierta = false;

        // Aplica la imagen estética al botón
        setIcon(this.reverso); 
        setBorderPainted(false); 
        setContentAreaFilled(false); 
        setFocusPainted(false); 
    }

    public String getImagenRuta() {
        return imagenRuta;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void mostrarImagen() {
        setIcon(imagen); // Muestra la imagen real
        this.descubierta = true;
    }

    public void ocultarImagen() {
        setIcon(reverso); // Vuelve a mostrar el reverso
        this.descubierta = false;
    }
}
