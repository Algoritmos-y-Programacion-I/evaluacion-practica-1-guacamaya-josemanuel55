package ui;

import java.util.Scanner;

public class Atlaspuntuaciones {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }
    /**
     * Descripcion: Este metodo pide al usuario y guarda los valores de las referencias y el numero de ventas de cada una en los diferentes  arreglos,(precios y unidades).
     */

    public static void solicitarDatos(){
        for(int i = 0; i < precios.length; i++){
            System.out.println("Por favor digite el valor de la referecia "+(i+1)+":");
            precios[i]=reader.nextDouble();
            System.out.println("Por favor digite el numero de ventas de la referecia "+(i+1)+":");
            unidades[i]=reader.nextInt();

        }

     
    }
    /**
     * Descripcion: Este metodo calcula el total de unidades vendidas,de todas las referencias,sumando cada cantidad de la referencia del arreglo unidades.
     * @return devuelve el total de unidades vendidas.
     */

    public static int calcularTotalUnidadesVendidas(){

        int total_unidades=0;
        for(int i =0;i<unidades.length;i++){
            total_unidades = unidades[i];
        }


        return total_unidades;

    }
    /**
     * Descripcion: Este metodo calcula el precio promedio de las ventas del dia.
     * @return devuelve el promedio de las ventas del dia,dividiendo la suma de todos los precios entre la longitud del arrreglo,precios.
     */

    public static double calcularPrecioPromedio(){
        double suma_precios=0;
        for(int i=0;i<precios.length;i++){
            suma_precios += precios[i];
        }

        return suma_precios/precios.length;

    }

    public static double calcularVentasTotales(){
        double total_ventas=0;
        for(int i=0;i<precios.length;i++){
            total_ventas += precios[i]*unidades[i];
        }

        return total_ventas;

    }

    public static int consultarReferenciasSobreLimite(double limite){
        int num_productos=0;
        for(int i=0;i<precios.length;i++){
            if(precios[i]*unidades[i] > limite){
                num_productos++;
            }
        }

        return num_productos;

    }

}