import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaJDBC {
    public static void main(String[] args) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/garapena_db", "root", ""
            );

            
            Statement statement = connection.createStatement();

           
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inscripciones");

            
            ArrayList<String[]> misInscripciones = new ArrayList<>();

            
            int contIA = 0;
            int contDB = 0;
            int contSOS = 0;
            int contDIG = 0;

            String mievento;

            
            while (resultSet.next()) {
                mievento = resultSet.getString("evento");

                
                if (mievento.equals("Inteligencia Artificial")) {
                    contIA++;
                } else if (mievento.equals("Base de Datos")) {
                    contDB++;
                } else if (mievento.equals("Sostenibilidad")) {
                    contSOS++;
                } else if (mievento.equals("Digitalizacion")) {
                    contDIG++;
                }

                
                String[] fila = {
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("evento")
                };
                misInscripciones.add(fila);

               
                System.out.println(
                    "ID: " + resultSet.getInt("id") +
                    " | Nombre: " + resultSet.getString("nombre") +
                    " | Apellido: " + resultSet.getString("apellido") +
                    " | Email: " + resultSet.getString("email") +
                    " | Evento: " + resultSet.getString("evento")
                );
            }

            
            System.out.println("\n📊 RESULTADOS DE INSCRIPCIONES\n");

            
            System.out.println("Total de personas inscritas: " + misInscripciones.size());

            
            System.out.println("\nPersonas inscritas por evento:");
            System.out.println("- Inteligencia Artificial: " + contIA);
            System.out.println("- Base de Datos: " + contDB);
            System.out.println("- Sostenibilidad: " + contSOS);
            System.out.println("- Digitalizacion: " + contDIG);

            
            System.out.println("\nListado de personas por evento:");

            System.out.println("\n[Inteligencia Artificial]");
            for (String[] fila : misInscripciones) {
                if (fila[2].equals("Inteligencia Artificial")) {
                    System.out.println("  - " + fila[0] + " " + fila[1]);
                }
            }

            System.out.println("\n[Base de Datos]");
            for (String[] fila : misInscripciones) {
                if (fila[2].equals("Base de Datos")) {
                    System.out.println("  - " + fila[0] + " " + fila[1]);
                }
            }

            System.out.println("\n[Sostenibilidad]");
            for (String[] fila : misInscripciones) {
                if (fila[2].equals("Sostenibilidad")) {
                    System.out.println("  - " + fila[0] + " " + fila[1]);
                }
            }

            System.out.println("\n[Digitalizacion]");
            for (String[] fila : misInscripciones) {
                if (fila[2].equals("Digitalizacion")) {
                    System.out.println("  - " + fila[0] + " " + fila[1]);
                }
            }

            
            connection.close();
            System.out.println("\n✅ Conexión cerrada correctamente.");

        } catch (Exception e) {
            System.out.println("❌ Error al conectar o consultar la base de datos:");
            e.printStackTrace();
        }
    }
}


