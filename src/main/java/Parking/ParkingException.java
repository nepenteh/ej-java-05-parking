/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parking;

/**
 *
 * @author josep
 */
public class ParkingException extends Exception {
    
    private final String mensaje;
    private final String matricula;
    
    public ParkingException(String mensaje, String matricula) {
        this.mensaje = mensaje;
        this.matricula = matricula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getMatricula() {
        return matricula;
    }
    
    
    
}
