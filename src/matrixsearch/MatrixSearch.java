package matrixsearch;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Chris
 */
public class MatrixSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tamano = new Scanner(System.in);
        Scanner numberSearch = new Scanner(System.in);

        System.out.println("Programa que Busca un numero en una matriz");
        System.out.println("Inserte el numero de filas de la matriz");
        int filas = tamano.nextInt();
        System.out.println("Inserte el numero de columnas");
        int columnas = tamano.nextInt();
        System.out.println("Ingrese el numero a buscar");
        int numberToSearch = numberSearch.nextInt();

        /*calculate size for transform the matrix to array to apply bubble search*/
        int size = filas * columnas;
        /*create array for store the matrix numbers*/
        List<Integer> arraySearch = new ArrayList<>();

        /*create the matrix*/
        int[][] resultMatrix = matrixCreator(filas, columnas);

        /*Transform from Matrix to Array*/
        arraySearch = matrixToArray(filas, columnas, resultMatrix);;

        /*print the array creates from the matrix*/
        System.out.println("El array para busqueda es:");
        printArray(arraySearch);

        /* Search for the target number*/
        List<Integer> indices = linearSearch(arraySearch, numberToSearch);
        
        /*Print Index*/
        printIndex(indices, numberToSearch);

    }

    public static int[][] matrixCreator(int fila, int columna) {
        Scanner datosMatrix = new Scanner(System.in);

        int[][] matrixCreator = new int[fila][columna];
        for (int k = 0; k < fila; k++) {
            for (int l = 0; l < columna; l++) {
                System.out.println("Ingrese el dato de la fila " + k + " de la columna " + l);
                int nDato = datosMatrix.nextInt();
                matrixCreator[k][l] = nDato;
            }
        }

        return matrixCreator;
    }

    public static List<Integer> matrixToArray(int filas, int columnas, int matrixToTransform[][]) {
        List<Integer> arrayResult = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                arrayResult.add(matrixToTransform[i][j]);
            }
        }

        return arrayResult;
    }

    public static void printArray(List<Integer> arrayToPrint) {
        for (int i = 0; i < arrayToPrint.size(); i++) {
            System.out.println(arrayToPrint.get(i));
        }
    }

    /* Linear search in an unsorted list */
    public static List<Integer> linearSearch(List<Integer> array, int target) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == target) {
                indices.add(i); 
            }
        }

        return indices;
    }

    public static void printIndex(List<Integer> indices, int numberToSearch) {
        if (!indices.isEmpty()) {
            System.out.println("Numero " + numberToSearch + " encontrado en los indices " + indices);
        } else {
            System.out.println("Numero " + numberToSearch + " no encontrado en ningun indice");
        }
    }

}
