/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * <p>Esto es un ejemplo de un programa de manejo de archivos</p>
 * @author Ana
 * @author Adri
 * 
 * @version 1.0
 * 
 */

public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream streamEntrada = null;
    private static BufferedInputStream buferEntrada = null;

    public static void inicializarArchivos() throws FileNotFoundException
    {
        streamEntrada = new FileInputStream(nombreArchivo);
        buferEntrada = new BufferedInputStream(streamEntrada);
    }
    
    public static int mostrarArchivoTexto() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = streamEntrada.read(bufer)) != -1)
        {
            System.out.println(new String(bufer));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args los argumentos de la línea de comando
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarArchivoTexto();

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if(buferEntrada != null && streamEntrada != null)
                {
                    streamEntrada.close();
                    buferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
