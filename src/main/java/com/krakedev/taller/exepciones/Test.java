package com.krakedev.taller.exepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        String nombre = "Maria";
        String apellido = "Gomez";

        // PRUEBA OBLIGATORIA 1: con "123" entra al catch y NO guarda nada
        // PRUEBA OBLIGATORIA 2: cambialo a "0981234567" -> guarda y lee correctamente
        String telefono = "123";

        try {
            // 1. llama a ValidarContacto con el telefono.
            //    Si es invalido, la excepcion propagada (throw + throws)
            //    llega hasta este try y salta directo al catch de abajo
            ValidarContacto.validarTelefono(telefono);

            // 2. si el telefono es valido, guarda el contacto en el archivo
            GuardarContacto.guardar(nombre, apellido, telefono);

            // 3. lee el archivo y muestra cada linea
            LeerContacto.leer();

            // 4. si llego hasta aqui, todo salio bien
            log.info("Proceso completado: telefono valido, contacto guardado y archivo leido");

        } catch (IllegalArgumentException e) {
            // aqui se MANEJA la excepcion que propago ValidarContacto
            log.error("Telefono invalido, no se guardo nada: " + e.getMessage());
        }
    }
}