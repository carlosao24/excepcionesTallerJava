package com.krakedev.taller.exepciones;

import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardarContacto {

    // Logger de Logback (via SLF4J). Logback ya viene incluido en Spring Boot,
    // por eso no hay que tocar el pom.xml
    private static final Logger log = LoggerFactory.getLogger(GuardarContacto.class);

    public static void guardar(String nombre, String apellido, String telefono) {

        // el FileWriter se declara FUERA del try para poder cerrarlo en el finally
        FileWriter escritor = null;

        try {
            // ERROR A PROPOSITO (Parte 1): si cambias la ruta por una carpeta que
            // no existe, por ejemplo "carpeta_inexistente/contactos.txt", se provoca
            // un IOException y podras ver el log.error del catch
            //
            // true = modo append: escribe al final y NO borra lo que ya existe
            escritor = new FileWriter("contactos.txt", true);

            // cada dato en una linea separada con \n
            escritor.write("Nombre: " + nombre + "\n");
            escritor.write("Apellido: " + apellido + "\n");
            escritor.write("Telefono: " + telefono + "\n");

            log.info("Contacto guardado exitosamente en contactos.txt");

        } catch (IOException e) {
            // aqui se maneja el error de escritura
            log.error("Error al escribir el contacto en el archivo", e);

        } finally {
            // el archivo se cierra AQUI SIEMPRE, haya error o no
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    log.error("Error al cerrar el FileWriter", e);
                }
            }
        }
    }
}