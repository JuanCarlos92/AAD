package org.example;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LeerXMLDOM {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("documento.xml");

        // Acceder al elemento raíz
        Element raiz = document.getDocumentElement();
        System.out.println("Elemento raíz: " + raiz.getNodeName());
    }
}