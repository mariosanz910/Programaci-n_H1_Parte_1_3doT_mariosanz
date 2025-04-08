package principal;

import java.util.ArrayList;
import java.util.Scanner;

import modulo.Animal;
import modulo.Gato;
import modulo.Perro;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Animal> listaAnimales = new ArrayList<>();

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("--- MENÚ ---");
            System.out.println("1. Añadir animal");
            System.out.println("2. Ver todos los animales");
            System.out.println("3. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
            	System.out.print("¿Qué tipo de animal quieres crear? (perro/gato): ");
                String tipo = sc.nextLine();

                System.out.print("Introduce número de chip: ");
                String chip = sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                System.out.print("Raza: ");
                String raza = sc.nextLine();

                System.out.print("¿Está adoptado? (s/n): ");
                String adop = sc.nextLine();
                boolean adoptado = false;

                if (adop.equals("s") || adop.equals("S")) {
                    adoptado = true;
                }

                if (tipo.equals("perro")) {
                    System.out.print("Tamaño (pequeño/mediano/grande): ");
                    String tamaño = sc.nextLine();

                    Perro perronuevo = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
                    listaAnimales.add(perronuevo);
                    System.out.println("Perro añadido correctamente.");

                } else if (tipo.equals("gato")) {
                    System.out.print("¿Tiene test de leucemia positivo? (s/n): ");
                    String test = sc.nextLine();
                    boolean leucemia = false;
                    
                    if (test.equals("s") || test.equals("S")) {
                        leucemia = true;
                    }

                    Gato gatonuevo = new Gato(chip, nombre, edad, raza, adoptado, leucemia);
                    listaAnimales.add(gatonuevo);
                    System.out.println("Gato añadido correctamente.");

                } else {
                    System.out.println("Tipo no válido.");
                }

            } else if (opcion == 2) {
                if (listaAnimales.isEmpty()) {
                    System.out.println("No hay animales en la lista.");
                } else {
                    for (Animal animal : listaAnimales) {
                    	System.out.println("---------------");
                        animal.mostrar();
                        System.out.println("---------------");
                    }
                }

            } else if (opcion == 3) {
                System.out.println("Saliendo...");
            } else if (opcion != 1 || opcion != 2 || opcion != 3) {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}