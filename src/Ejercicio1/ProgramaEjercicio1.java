package Ejercicio1;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaEjercicio1 {
    private static Scanner scanner=new Scanner(System.in);
    private static String nombreFichero;

    public static ArrayList<String> inicio() throws IOException {
        String ruta= Paths.get("").toAbsolutePath().toString();
        System.out.print("Introduce la ruta del archivo: ");
        nombreFichero=scanner.next();
        FileReader fileReader=new FileReader(nombreFichero);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String respuesta="a";
        ArrayList<String>datos=new ArrayList<>();
        while (true) {
                respuesta=bufferedReader.readLine();
                if (respuesta!=null){ datos.add(respuesta);}
                else break;
        }
        bufferedReader.close();
        return datos;
    }
}
