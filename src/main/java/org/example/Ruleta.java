package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private List<String> jugadores = new ArrayList<>();
    private List<Integer> tambor = new ArrayList<>();
    private int bala;
    int posicionActual;
    private Random random;

    public Ruleta(int numJugadores, List<String> jugadores) {
        this.random = new Random();
        this.jugadores = jugadores;
        this.tambor = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            tambor.add(0);
        }

        this.bala = random.nextInt(6);
        tambor.set(bala, 1);
        this.posicionActual = 0;
    }

    public boolean disparar() {
        System.out.println("¡Es el turno de " + jugadores.get(posicionActual) + "!");
        System.out.print("¡Tira del gatillo para disparar!");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (posicionActual == bala) {
            System.out.println("¡" + jugadores.get(posicionActual) + " ha muerto! Fin del juego.");
            return true;
        }

        posicionActual = (posicionActual + 1) % jugadores.size();
        return false;
    }

    public void reiniciarJuego() {
        this.tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(0);
        }
        this.bala = random.nextInt(6);
        tambor.set(bala, 1);
        this.posicionActual = 0;
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "RuletaRusa{" +
                "jugadores=" + jugadores +
                ", tambor=" + tambor +
                ", bala=" + bala +
                ", posicionActual=" + posicionActual +
                '}';
    }
}
