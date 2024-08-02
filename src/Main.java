import Ejercicio1.ProgramaEjercicio1;
import Ejercicio2.CifrarArchivo;
import Ejercicio3.Modelo.ProgramaClienteServidor;
import Ejercicio3.Persistencia.Servidor;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {verejercicios();}

    public static void verejercicios()
    {
        System.out.print("Elige el ejercicio a mirar (1,2 o 3)(Si elijes otro valor saldrás del programa ): ");
        int respuestaEjercicio= scanner.nextInt();
        if (respuestaEjercicio==1) {
            System.out.println("Ruta de Referencia al archivo es): "+ Paths.get("").toAbsolutePath().toString()+"/FicheroA.txt");
            try {
                ArrayList<String> datos= ProgramaEjercicio1.inicio();
                for (String elemento:datos) {
                    System.out.println(elemento);
                }
                verejercicios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (respuestaEjercicio==2) {
            try {
                CifrarArchivo.inicio();
                verejercicios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (respuestaEjercicio==3) {
            try {
                System.out.println("INICIA EL SERVIDOR");
                ProgramaClienteServidor programaClienteServidor=new ProgramaClienteServidor();
                verejercicios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {"Saliendo...."}
    }
}