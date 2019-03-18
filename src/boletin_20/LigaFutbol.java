/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_20;

import java.util.Random;

/**
 *
 * @author slorenzorodriguez
 */
public class LigaFutbol {
     public String[] equipos = {"Alaves", "Athletic", "Atletico de Madrid", "Barcelona", "Betis", "Celta", "Eibar", "Español", "Getafe", "Girona", "Huesca", "Leganes", "Levante", "Rayo", "Real Madrid", "Real Sociedad", "Sevilla", "Valencia", "Valladolid", "Villareal"};
    public int[][] tabla;

    public int jornadas;

    public LigaFutbol() {
    }

    public LigaFutbol(int jornadas) {
        this.jornadas = jornadas;
        this.tabla = new int[equipos.length][jornadas];
        this.golesRandom();
    }

    public LigaFutbol(int jornadas, String[] equipos) {
        this.jornadas = jornadas;
        this.equipos = equipos;
        this.tabla = new int[equipos.length][jornadas];
        this.golesRandom();
    }

    public void golesRandom() {
        Random rand = new Random();
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = rand.nextInt(6);
            }
        }
    }

    public void mostrarTabla() {
        //head
        System.out.printf("%3s %20s", " ", "Jornada");
        for (int i = 0; i < tabla[0].length; i++) {
            System.out.printf("%3d", i + 1);
        }
        System.out.printf("%7s\n", "Total");
        //body
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%3d %20s", i + 1, equipos[i]);
            for (int j = 0; j < tabla[0].length; j++) {
                System.out.printf("%3d", tabla[i][j]);
            }
            System.out.printf("%5d\n", golesDeEquipo(i));
        }
        System.out.printf("%24s", "");
        for (int i = 0; i < tabla[0].length; i++) {
            System.out.printf("%3d", getGolesTotalDeJornada(i));
        }
    }

    public void mostrarTablaTotales() {
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%3d %20s %5d\n", i + 1, equipos[i], golesDeEquipo(i));
        }
    }

    public int[] indicesGolesAscendentes() {
        int[] indexReordenados = new int[equipos.length];
        for (int i = 0; i < indexReordenados.length; i++) {
            indexReordenados[i] = i;
        }
        for (int i = 0; i < equipos.length - 1; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                if (golesDeEquipo(indexReordenados[i]) > golesDeEquipo(indexReordenados[j])) {
                    int t = indexReordenados[i];
                    indexReordenados[i] = indexReordenados[j];
                    indexReordenados[j] = t;
                }
            }
        }
        return indexReordenados;
    }

    public int[] indicesDeGolesAscEnJornada(int indexJornada) {
        int[] indexReordenados = new int[equipos.length];
        for (int i = 0; i < indexReordenados.length; i++) {
            indexReordenados[i] = i;
        }
        for (int i = 0; i < equipos.length - 1; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                if (tabla[indexReordenados[i]][indexJornada] > tabla[indexReordenados[j]][indexJornada]) {
                    int t = indexReordenados[i];
                    indexReordenados[i] = indexReordenados[j];
                    indexReordenados[j] = t;
                }
            }
        }
        return indexReordenados;
    }

    public int getGolesTotalDeJornada(int indexJornada) {
        int sum = 0;
        for (int i = 0; i < equipos.length; i++) {
            sum += tabla[i][indexJornada];
        }
        return sum;
    }

    public int[] indicesGolesPorJornada() {
        int[] indexReordenados = new int[jornadas];
        for (int i = 0; i < indexReordenados.length; i++) {
            indexReordenados[i] = i;
        }
        for (int i = 0; i < equipos.length - 1; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                if (getGolesTotalDeJornada(indexReordenados[i]) > getGolesTotalDeJornada(indexReordenados[j])) {
                    int t = indexReordenados[i];
                    indexReordenados[i] = indexReordenados[j];
                    indexReordenados[j] = t;
                }
            }
        }
        return indexReordenados;
    }

    public void mostrarTablaOrdenadaTotal() {
        int[] orden = indicesGolesAscendentes();
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%3d %20s %5d %3d\n", i, equipos[orden[i]], golesDeEquipo(orden[i]), orden[i]);
        }
    }

    public void mostrarTablaJornadaOrdenada(int indexJornada) {
        int[] orden = indicesDeGolesAscEnJornada(indexJornada);
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%3d %20s %5d %3d\n", i, equipos[orden[i]], tabla[orden[i]][indexJornada], orden[i]);
        }
    }

    public void mostrarTablaJornadas() {
        for (int i = 0; i < tabla[0].length; i++) {
            System.out.printf("%2d %20s %4d\n", i, equipos[indicesDeGolesAscEnJornada(i)[19]], tabla[indicesDeGolesAscEnJornada(i)[19]][i]);
        }
    }

    public int getGoles(int equipo, int indexJornada) {
        return tabla[equipo][indexJornada];
    }

    public int getTopEquipo() {
        return indicesGolesAscendentes()[equipos.length - 1];
    }

    public String getTopEquipoString() {
        return equipos[getTopEquipo()];
    }

    public int getTopJornada() {
        return indicesGolesPorJornada()[jornadas - 1];
    }

    public String getTopJornadaString() {
        return equipos[indicesDeGolesAscEnJornada(getTopJornada())[equipos.length - 1]];
    }

    public int indiceDeEquipo(String nombre) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public int golesDeEquipo(String nombre) {
        return golesDeEquipo(indiceDeEquipo(nombre));
    }

    public int golesDeEquipo(int index) {
        int goles = 0;
        for (int i = 0; i < tabla[index].length; i++) {
            goles += tabla[index][i];
        }
        return goles;
    }

}

