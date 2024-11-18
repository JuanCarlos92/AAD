package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

    public class GuardarLibroXML {
        public static void main(String[] args) {
            File archivo = new File("nuevo_libro.xml");
            Libro libro = new Libro("LibroTitulo","Juan");

        try {
            JAXBContext context = JAXBContext.newInstance(Libro.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libro,archivo);
        }catch (JAXBException e){
            System.out.println(e.getMessage());
        }

        }
    }

