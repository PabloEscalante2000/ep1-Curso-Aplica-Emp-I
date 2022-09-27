package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class ModuloseguridadApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(ModuloseguridadApplication.class, args);


		/*//Cargar Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Crear conexión
		Connection connexion = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ep1",
						"root","root");

		//Crear Statement
		Statement statement = connexion.createStatement();

		// Ejecutar sentencia
		int afectedRows = statement
				.executeUpdate("UPDATE USERS SET name = 'jose' where id=1");*/
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa la entrada: ");
		int id = Integer.parseInt(entrada.next());
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			Connection connexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ep1",
							"root","root");
			Statement st = connexion.createStatement();
			ResultSet rs = st
					.executeQuery("select * from empleado where id =" + id);
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String pais = rs.getString("pais");
				System.out.println("Empleado: " + nombre + " " + apellido +
						"del país: " + pais);
			}
			rs.close();
			st.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
