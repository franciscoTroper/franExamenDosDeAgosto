package Ejercicio3.Persistencia;

import Ejercicio3.Modelo.ProgramaClienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor
{
    public static void main(String[] args) {
        try {inicio();}
        catch (IOException e) {throw new RuntimeException(e);}
    }
    public static void inicio() throws IOException
    {
        ServerSocket servidor = new ServerSocket(3000);
        while (true)
        {
            Socket s1 = servidor.accept();
            Random random=new Random();
            BufferedReader bf = new BufferedReader(new InputStreamReader(s1.getInputStream()));

            String respuesta= bf.readLine();
            System.out.println(respuesta);

            int codigoautorizacion= random.nextInt(4);
            PrintWriter sRespuesta = new PrintWriter(s1.getOutputStream(), true);
            if (codigoautorizacion==0){sRespuesta.println("Operacion aceptada");}
            else if (codigoautorizacion==1) {sRespuesta.print("Error:9137 Error al intentar validar la tarjeta");}
            else if (codigoautorizacion==2) {sRespuesta.print("Error:9221 El cliente no está introduciendo el CVV");}
            else if (codigoautorizacion==3) {sRespuesta.print("Error:9677 Saldo insuficiente");}
            else {}
            sRespuesta.close();

        }

    }
}
