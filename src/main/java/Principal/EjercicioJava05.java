/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Principal;

import Parking.Parking;
import Parking.ParkingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josep
 */
public class EjercicioJava05 {

    static Parking parking = new Parking("Centro",10);
    static int opcion;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        do {
            menu();
            accion();
        } while(opcion!=4);
  
    }
    
    public static void accion() {
        switch(opcion) {
            case 1 -> entradaCoche();
            case 2 -> salidaCoche();
            case 3 -> System.out.println(parking+"\n\n");
            case 4 -> System.out.println("Fin del del programa\n\n");
            default -> System.out.println("Error en la opción\n\n");
        }
    }
    
    public static void entradaCoche() {
        boolean correcto = false;
        try {
            
            System.out.println("Introduzca matrícula: ");
            String m = scanner.nextLine();
            System.out.println("Introduzca la plaza: ");
            int p = Integer.parseInt(scanner.nextLine());
            //int a = 3/0;
            parking.entrada(m, p);
            correcto = true;
            
        } catch (ParkingException ex) {
            //gestiono el error
            System.out.println("ERROR: "+ex.getMensaje());
            System.out.println("No se realizó la entrada del coche con matrícula " +
                    ex.getMatricula()+" en el parking");
            
        } catch (NumberFormatException ex) {
            System.out.println("Formato de número incorrecto");
        
        } catch (Exception ex) {
            System.out.println("ERROR DESCONOCIDO. ");
        
        } finally {
            if(!correcto)
                System.out.println("Se produjo un error.");
        }
    }
    
    
    
    public static void salidaCoche() {
        boolean correcto = false;
        try {
            
            System.out.println("Introduzca la matrícula: ");
            String m = scanner.nextLine();
            
            int p = parking.salida(m);
            System.out.println("El coche "+m+" salió de la plaza "+p+"\n\n");
            System.out.println("Plazas totales: "+parking.getPlazasTotales()+"\n");
            System.out.println("Plazas ocupadas: "+parking.getPlazasOcupadas()+"\n");
            System.out.println("Plazas libres: "+parking.getPlazasLibres()+"\n\n");
            correcto = true;
            
        } catch (ParkingException ex) {
            System.out.println("ERROR: "+ex.getMensaje());
            System.out.println("No se realizó la salida del coche con matrícula "+
                    ex.getMatricula()+" del parking");
        
        } catch (Exception ex) {
            System.out.println("ERROR DESCONOCIDO.");
        
        } finally {
            if(!correcto)
                System.out.println("Se produjo un error");
        }
        
    }
    
    public static void menu() {
        System.out.println("""
                           1) Entrada de coche
                           2) Salida de coche
                           3) Mostrar parking
                           4) Salir del programa
                           ->              
                           """);
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch(Exception ex) {
            opcion = 0;
        }
    }
    
}
