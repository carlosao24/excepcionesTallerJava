package com.krakedev.taller.exepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerContacto {

    private static final Logger log = LoggerFactory.getLogger(LeerContacto.class);

    public static void leer() {

        // el BufferedReader se declara FUERA del try para poder cerrarlo en el finally
        BufferedReader lector = null;

        try {
            // ERROR A PROPOSITO (Parte 2, prueba 1): cambia "contactos.txt" por
            // "fantasma.txt" y observa como se ejecuta el catch de FileNotFoundException
            lector = new BufferedReader(new FileReader("contactos.txt"));

            System.out.println("---- Contenido de contactos.txt ----");

            // for para recorrer cada linea del archivo
            for (String linea = lector.readLine(); linea != null; linea = lector.readLine()) {
                System.out.println(linea);
            }

            log.info("Archivo contactos.txt leido correctamente");

        } catch (FileNotFoundException e) {
            // primer catch: el archivo no existe (es la excepcion mas especifica)
            log.error("El archivo no existe: " + e.getMessage(), e);

        /*
         * ERROR A PROPOSITO (Parte 2, prueba 2): si INVIERTES el orden de los catch
         * (primero IOException y despues FileNotFoundException), Eclipse marca un
         * error de compilacion en el segundo catch:
         *   "Unreachable catch block for FileNotFoundException.
         *    It is already handled by the catch block for IOException"
         * Esto pasa porque IOException es la clase madre y ya captura todo.
         * Los catch siempre van de la excepcion mas especifica a la mas general.
         */
        } catch (IOException e) {
            // segundo catch: cualquier otro error de lectura (clase madre)
            log.error("Error al leer el archivo", e);

        } finally {
            // el BufferedReader se cierra AQUI SIEMPRE, haya error o no
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    log.error("Error al cerrar el BufferedReader", e);
                }
            }
        }
    }
}