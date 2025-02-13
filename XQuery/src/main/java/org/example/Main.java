package org.example;
import org.basex.api.client.ClientSession;

public class Main {
    public static void main(String[] args) {
        try {
            ClientSession session = new ClientSession("localhost", 1984, "Goku", "Goku");
            session.execute("OPEN dragonball");

            String query1 = "for $p in //personaje/nombre return <nombre>{$p/nombre/text()}</nombre>";
            String query2 = "for $p in //personaje/nombre/text() return $p";
            String query3 = "for $p in //personaje return $p/nombre";
            String query4 = "//personaje/nombre/text()";
            String query5 = "for $p in //personaje\n" +
                    "return <luchador>\n" +
                    "    <nombre>{$p/nombre/text()}</nombre>\n" +
                    "    <categoria>\n" +
                    "        {\n" +
                    "            if ($p/nivel_poder > 8500) then \"Clase S\"\n" +
                    "            else \"Clase A\"\n" +
                    "        }\n" +
                    "    </categoria>\n" +
                    "</luchador>";

            String query6 = "for $p in //planetas/planeta " +
                    "return <planetas> " +
                    "    <nombre>{$p/nombre/text()}</nombre> " +
                    "    <categoria>" +
                    "        { " +
                    "            if ($p/habitantes > 1000000) then 'Alta Habitabilidad' " +
                    "            else if ($p/habitantes < 1000) then 'Baja Habitabilidad' " +
                    "            else 'Media Habitabilidad' " +
                    "        } " +
                    "    </categoria>" +
                    "</planetas>";

            String result = session.execute("XQUERY " + query6);

            System.out.println("Resultado de la consulta:");
            System.out.println(result);

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}