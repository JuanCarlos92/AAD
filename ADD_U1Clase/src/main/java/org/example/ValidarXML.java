package org.example;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidarXML {
    public static void main(String[] args) {
        try {
            // Cargar el esquema XSD
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("esquema.xsd"));

            // Crear el validador
            Validator validator = schema.newValidator();

            // Validar el documento XML
            validator.validate(new StreamSource(new File("documento.xml")));
            System.out.println("El documento XML es válido.");
        } catch (SAXException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
