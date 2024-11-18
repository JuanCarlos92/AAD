package org.example;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class LeerXMLStAX {
    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("documento.xml"));

        while (reader.hasNext()) {
            reader.next();

            if (reader.isStartElement()) {
                System.out.println("Inicio del elemento: " + reader.getLocalName());

            } else if (reader.isEndElement()) {
                System.out.println("Fin del elemento: " + reader.getLocalName());

            } else if (reader.hasText()) {
                System.out.println("Contenido: " + reader.getText());
            }
        }
    }
}