package Ejercicio2;

import java.io.*;
import java.util.Scanner;

public class CifrarArchivo {
    private static Scanner scanner=new Scanner(System.in);
    public static void inicio() throws IOException {
        System.out.print("Introduce el nombre del archivo de origen: (nombreRef: origen.txt) ");
        String archivoOrigen=scanner.next();
        System.out.print("Introduce el nombre del archivo de cifrado: (nombreRef: cifrado.txt) ");
        String archivoCifrado=scanner.next();
        System.out.print("Introduce un numero entre 1 y 255:");
        int numIntroducido= scanner.nextInt();
        FileReader fileReader=new FileReader(archivoOrigen);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String frase="a";
        while (true)
        {
            frase=bufferedReader.readLine();
            if (frase!=null)
            {
                for (char elemento:frase.toCharArray())
                {
                    char resultado= (char) (elemento ^ numIntroducido);
                    FileWriter fileWriter=new FileWriter(archivoCifrado,true);
                    BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                    bufferedWriter.write(resultado);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                System.out.println();
                System.out.println("Los datos se escribieron cifrados correctamente en el archivo cifrado.txt ");
                System.out.println();
            }
            else break;

        }


    }
}
