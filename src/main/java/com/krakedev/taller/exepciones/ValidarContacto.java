package com.krakedev.taller.exepciones;

public class ValidarContacto {

    /*
     * Parte 3: este metodo NO maneja la excepcion (no tiene try/catch).
     * - "throws IllegalArgumentException" en la firma AVISA que el metodo
     *   puede lanzar esa excepcion.
     * - "throw" LANZA la excepcion y corta la ejecucion del metodo.
     * Quien llame a este metodo (la clase Test) es el responsable de
     * capturarla con try/catch.
     */
    public static void validarTelefono(String telefono) throws IllegalArgumentException {

        // si el telefono no tiene 10 digitos, se lanza la excepcion con throw
        if (telefono == null || telefono.length() != 10) {
            throw new IllegalArgumentException(
                    "El telefono debe tener 10 digitos. Recibido: " + telefono);
        }
    }
}