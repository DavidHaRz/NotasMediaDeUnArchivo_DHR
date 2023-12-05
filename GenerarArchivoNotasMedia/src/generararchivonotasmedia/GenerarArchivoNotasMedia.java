/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generararchivonotasmedia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
        BufferedReader lectura = null;
        BufferedWriter escritura = null;

        try {
            lectura = new BufferedReader(new FileReader("./archivos/alumnosNotas.txt"));       //Ruta donde se encuentra el archivo a leer.
            escritura = new BufferedWriter(new FileWriter("./archivos/alumnosSolucion.txt"));         //Ruta donde se va a escibir la solución
            String cadena;
            while ((cadena = lectura.readLine()) != null) {        //Leer el archivo línea por línea.
                //Separar cada vez que aparezca :
                String[] separar = cadena.split(":");
                
                int suma = 0, cantidadNumeros = 0;
                
                for (int i = 1; i < separar.length; i++) {
                    int numero = Integer.parseInt(separar[i]);
                    
                    suma += numero;
                    cantidadNumeros ++;
                }
                
                //En la posición 0 están los nombres.
                String nombre = separar[0];
                /*
                String separarNombre = separar[0];
                int separar2 = Integer.parseInt(separar[1]);
                int separar3 = Integer.parseInt(separar[2]);
                int separar4 = Integer.parseInt(separar[3]);
                   */
                double resultado;
                resultado = (double)suma / cantidadNumeros;
                
                String linea = "La media de " + nombre + " es: " + resultado;
                escritura.write(linea + "\n");
                System.out.println(linea);
                
            }         
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (lectura != null)        //Cierra el fichero.
                lectura.close();
            if (escritura != null)
                escritura.close();
        }  
    }
}
