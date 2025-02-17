package org.example;

import org.basex.api.client.ClientSession;

public class Main {
    public static void main(String[] args) {

        try {
            // Conectar a BaseX con usuario y contraseña
            ClientSession session = new ClientSession("localhost", 1984, "Goku", "Goku");

            // Abrir la base de datos antes de ejecutar la actualización
            session.execute("OPEN dragonball");

            // Aumentar el nivel de poder de todos los Saiyajin
            String updateQuery1 = "for $personaje in //personaje[raza=\"Saiyajin\"] "+
                    "return " +
                    "replace value of node $personaje/nivel_poder " +
                    "with (xs:int($personaje/nivel_poder) + 500)";

            // Cambiar el planeta de origen de Vegeta
            String updateQuery2="replace value of node //personaje[nombre=\"Vegeta\"]/planeta_origen " +
                    "with \"Tierra\"";

            // Añadir una nueva técnica a Goku
            String createQuery1 = "insert node <tecnica id=\"4\"> " +
                    "<nombre>Ultra Instinto</nombre>" +
                    "<usuario>Goku</usuario>" +
                    "<tipo>Ataque</tipo>" +
                    "<nivel_poder_requerido>10000</nivel_poder_requerido>" +
                    "<descripcion>Transformación que permite al usuario reaccionar instintivamente a los ataques.</descripcion>" +
                    "</tecnica> " +
                    "into //tecnicas";


            // Eliminar a Freezer de la base de datos
            String deleteQuery1 = "delete node //personaje[nombre=\"Freezer\"]";

            // Reducir a la mitad el número de habitantes de Namek
            String updateQuery3 = "replace value of node //planeta[nombre=\"Namek\"]/habitantes " +
                    "with (xs:int(//planeta[nombre=\"Namek\"]/habitantes) div 2)";


            session.execute("XQUERY " + updateQuery3);

            System.out.println("Actualizado correctamente.");

            // Cerrar la sesión
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
