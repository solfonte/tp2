package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.vista.VistaKashoot;
import java.util.*;


public class Kashoot  {

    private int tamanio = 20;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Queue<Jugador> jugadores = new LinkedList<Jugador>();

    public ArrayList<Opcion> getOpciones() {// antes llamar a getpregunta
        Ronda ronda = this.rondas.element();
        ArrayList<Opcion> opciones = ronda.getOpciones();
        return opciones;
    }

    public Pregunta getPregunta() {
        Ronda ronda = this.rondas.element();
        Pregunta pregunta = ronda.getPregunta();
        return pregunta;
    }

    public void agregarJugadores(Jugador jugador1, Jugador jugador2) {
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);

    }

    public void actualizarJugadorActual(){

        Jugador jugadorActual = jugadores.poll();

        jugadores.add(jugadorActual); //jugadores es una cola, lo pone al final
        System.out.println("Actualice Jugador");
    }

    public Jugador obtenerJugadorActual(){

        return jugadores.element();

    }

    public void agregarRonda(Ronda ronda) {
        this.rondas.add(ronda);
    }

    public void actualizar(){
        this.actualizarJugadorActual();
        rondas.element().aumentarturnos();
         if(!rondas.element().rondaContinua()){
             rondas.element().asignarPuntajes(jugadores);
             rondas.poll();
         }
    }

    public void jugarRondaConExclusividad() {

        Ronda rondaActual = this.rondas.element();
        rondaActual.jugarConExclusividad();

    }

    public boolean terminoJuego() {
        return (this.rondas.isEmpty());
    }

    public Jugador getJugador1() {
        Jugador jugador1 = jugadores.poll();
        return jugador1;
    }


    public void setNombreJugadores(String nombreJugadorUno, String nombreJugadorDos) {
        Jugador jugadorUno = this.jugadores.poll();
        jugadorUno.setNombre(nombreJugadorUno);
        this.jugadores.add(jugadorUno);
        Jugador jugadorDos = this.jugadores.poll();
        jugadorDos.setNombre(nombreJugadorDos);
        this.jugadores.add(jugadorDos);

    }
}
