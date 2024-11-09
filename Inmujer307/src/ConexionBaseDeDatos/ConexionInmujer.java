package ConexionBaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionInmujer {
	public static final String conector = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/inmujer307";
	public static final String usuario = "root";
	public static final String password = "";
	Connection con = null;
	//ARROJA ERROR SI LA CONEXION NO FUE EXITOSA
	static {
		try {
			Class.forName(conector);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("NO SE PUDO CARGAR EL CONECTOR ☠️");
			e.printStackTrace();
		}
	}

		//PERMITE LA CONEXION A LA BASE DE DATOS INMUJER
	public Connection conectar() {
		try {
			con = DriverManager.getConnection(url,usuario,password);
			System.out.println("CONEXION ESTABLECIDA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("CONEXION FALLIDA!!");
			e.printStackTrace();
		}
		return con;
	}
	
}