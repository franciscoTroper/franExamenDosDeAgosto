package Ejercicio3.Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ProgramaClienteServidor {
    private Scanner scanner=new Scanner(System.in);
    private String fechaTransaccion,numTarjeta,fechaCaducidad,cvv;

    public ProgramaClienteServidor() throws IOException {
        peticionCliente();
    }

    @Override
    public String toString() {
        return "Programa{" +
                "fechaTransaccion='" + fechaTransaccion + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", fechaCaducidad='" + fechaCaducidad + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }

    public void peticionCliente() throws IOException {
        System.out.print("Introduce fecha de transaccion: (formato AAAA/MM/DD) ");
        fechaTransaccion = scanner.next();
        System.out.print("Introduce numero de tarjeta: ");
        numTarjeta = scanner.next();
        System.out.print("Introduce fecha de caducidad: (formato AAAA/MM/DD)");
        fechaCaducidad = scanner.next();
        System.out.print("Introduce CVV: (3 digitos)");
        cvv = scanner.next();

        Socket peticion = new Socket("localhost", 3000);
        // 3. Escribir en el outputStream
        PrintWriter sSalida = new PrintWriter(peticion.getOutputStream(), true);
        sSalida.println(this.toString());
        sSalida.flush();
        // 4. Leer que ha llegado las ventas
        BufferedReader bf = new BufferedReader(new InputStreamReader(peticion.getInputStream()));
        while (true)
        {
            String respuesta= bf.readLine();
            if (respuesta!=null){System.out.println(respuesta);}
            else break;
        }
        bf.close();

    }




}
