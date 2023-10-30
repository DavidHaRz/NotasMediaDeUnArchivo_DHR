/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generararchivonotasmedia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

/**
 *
 * @author David
 */
public class GenerarArchivoNotasMedia {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = null;
        //BufferedWriter salida = null;

        try {
            entrada = new BufferedReader(new FileReader("./archivos/alumnosNotas.txt"));       //Ruta donde se encuentra el archivo a leer.
            String cadena;
            while ((cadena = entrada.readLine()) != null) {        //Leer el archivo línea por línea.
                String[] separar = cadena.split(":");
                
                int suma = 0, cantidadNumeros = 0;
                
                for (int i = 1; i < separar.length; i++) {
                    int numero = Integer.parseInt(separar[i]);
                    
                    suma += numero;
                    cantidadNumeros ++;
                }
                String nombre = separar[0];
                /*
                String separarNombre = separar[0];
                int separar2 = Integer.parseInt(separar[1]);
                int separar3 = Integer.parseInt(separar[2]);
                int separar4 = Integer.parseInt(separar[3]);
                   */

                double resultado;
                resultado = (double)suma / cantidadNumeros;
                
                System.out.println("La media de " + nombre + " es: " + resultado);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (entrada != null)        //Cierra el fichero.
                entrada.close();
        }
        
    }
    
}
