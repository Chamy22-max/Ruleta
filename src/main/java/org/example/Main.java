package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarJuego = true;

        while (continuarJuego) {
            System.out.print("¿Cuántos jugadores van a jugar? (máximo 6 jugadores): ");
            int numJugadores = scanner.nextInt();
            scanner.nextLine();

            if (numJugadores > 6) {
                System.out.println("No puedes tener más de 6 jugadores.");
                continue;
            }

            List<String> jugadores = new ArrayList<>();
            for (int i = 0; i < numJugadores; i++) {
                System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
                String nombre = scanner.nextLine();
                jugadores.add(nombre);
            }

            Collections.shuffle(jugadores);

            Ruleta ruleta = new Ruleta(numJugadores, jugadores);
            boolean finDelJuego = false;

            while (!finDelJuego) {
                System.out.println("\nEs el turno de " + ruleta.getJugadores().get(ruleta.posicionActual));
                System.out.println(ruleta);
                finDelJuego = ruleta.disparar();
                if (finDelJuego) {
                    System.out.print("¿Quieres volver a jugar? (si/no): ");
                    String respuesta = scanner.nextLine();
                    switch (respuesta.toLowerCase()) {
                        case "si":
                            ruleta.reiniciarJuego();
                            break;
                        case "no":
                            System.out.println("Fin del juego. ¡Hasta la próxima!");
                            continuarJuego = false;
                            break;
                        default:
                            System.out.println("Opción no válida. Fin del juego.");
                            continuarJuego = false;
                            break;
                    }
                }
            }
        }

        scanner.close();
    }
}
