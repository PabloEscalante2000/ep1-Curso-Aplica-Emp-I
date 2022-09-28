package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class ModuloseguridadApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		SpringApplication.run(ModuloseguridadApplication.class, args);


		// LISTAR REGISTROS - STATEMENT

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			Connection connexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ep1",
							"root","root");
			Statement st = connexion.createStatement();
			ResultSet rs = st
					.executeQuery("select * from empleado");
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String pais = rs.getString("pais");
				System.out.println("Empleado: " + nombre + " " + apellido +
						" del país: " + pais);
			}
			rs.close();
			st.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// ELIMINAR REGISTROS - PREPAREDSTATEMENT

		try {

			Scanner sc = new Scanner(System.in);

			System.out.println("Por favor el id del empleado que quiere borrar");

			String id = sc.nextLine();

			Connection connexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ep1",
							"root","root");

			PreparedStatement ps = connexion
					.prepareStatement("delete from empleado where id="+id);
			int vañ = ps.executeUpdate();

			System.out.println("Se ha eliminado el empleado");

			ps.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// CREAR REGISTROS - CALLABLESTATEMENT

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Por favor ingrese su nombre");

			String nombre = br.readLine();

			System.out.println("Ingrese su apellido");

			String apellido = br.readLine();

			System.out.println("Ingrese su pais");

			String pais = br.readLine();

			br.close();

			Connection connexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ep1",
							"root","root");



			CallableStatement cs = connexion
					.prepareCall("{call insertar_empleado('" +
							nombre+"','" +
							apellido+"','" +
							pais+"')}");



			ResultSet rs = cs
					.executeQuery();

			System.out.println("Se han ingresado los datos");

			rs.close();
			cs.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
