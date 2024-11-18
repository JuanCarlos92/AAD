package org.example;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class VinculacionLibros {
    public static void main(String[] args) {
        try {
            File file = new File("libros.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Libros.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Libros libros = (Libros) jaxbUnmarshaller.unmarshal(file);

            // Mostrar los libros leídos
            for (Libro libro : libros.getListaLibros()) {
                System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

