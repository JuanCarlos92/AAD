package org.example;
import org.basex.api.client.ClientSession;

public class Main {
    public static void main(String[] args) {
        try {
            ClientSession session = new ClientSession("localhost", 1984, "Goku", "Goku");
            session.execute("OPEN dragonball");

            String query = "for $p in //personaje return <nombre>{$p/nombre/text()}</nombre>";
            String result = session.execute("XQUERY " + query);

            System.out.println("Resultado de la consulta:");
            System.out.println(result);

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}