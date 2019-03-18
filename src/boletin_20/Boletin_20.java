/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_20;

/**
 *
 * @author slorenzorodriguez
 */
public class Boletin_20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         LigaFutbol liga = new LigaFutbol(38);
        liga.mostrarTabla();
        System.out.println("Total");
        liga.mostrarTablaTotales();
        System.out.println("Tabla Ascendente");
        liga.mostrarTablaOrdenadaTotal();
        System.out.println("Segunda Jornada en orden");
        liga.mostrarTablaJornadaOrdenada(2);
        System.out.println("Máximo goleador por jornada");
        liga.mostrarTablaJornadas();
        System.out.println("Jornada Top " + liga.getTopJornada());
        System.out.println("Mejor equipo en la Jornada Top " + liga.getTopJornadaString());
        System.out.println("Total mejor equipo " + liga.getTopEquipoString());
        System.out.println("Goles de un equipo en una jornada:");
        System.out.printf("El equipo %s en la jornada %d marco %d goles", liga.equipos[3], 18, liga.getGoles(3, 18));

    }
}
    
    
