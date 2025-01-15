package p4csw;

import java.util.List;

public class Combate {
    private final Campeon campeon1;
    private final Campeon campeon2;
    private boolean enCurso;
    private int turno;

    // Constructor
    public Combate(Campeon campeon1, Campeon campeon2) {
        this.campeon1 = campeon1;
        this.campeon2 = campeon2;
        this.enCurso = true;
        this.turno=0; //
    }

    // Método iniciar
    public void iniciar() {
        System.out.println("¡El combate comienza entre " + campeon1.getNombre() + " y " + campeon2.getNombre() + "!");
        
        turno = 1; // Contador de turnos

        while (enCurso) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Turno de ataque alternado
            if (turno % 2 != 0) {
                // Campeón 1 ataca
                realizarAccion(campeon1, campeon2);
            } else {
                // Campeón 2 ataca
                realizarAccion(campeon2, campeon1);
            }

            // Verificar si el combate debe detenerse
            detener();
            turno++;
        }

        // Mostrar el ganador al final del combate
        String ganador = mostrarGanador();
        System.out.println("\n¡" + ganador + " es el ganador!");
    }

    // Método realizarAccion (ataque o habilidad al azar)
    private void realizarAccion(Campeon atacante, Campeon defensor) {
        //Decidir aleatoriamente si usar una habilidad o ataque base
        if (Math.random() < 0.5 || atacante.getHabilidades().isEmpty()) {
            atacante.atacar(defensor); // Ataque básico
        } else {
            // Seleccionar una habilidad al azar
            List<Habilidad> habilidades = atacante.getHabilidades();
            Habilidad habilidad = habilidades.get((int) (Math.random() * habilidades.size()));
            atacante.usarHabilidad(habilidad.getNombre(), atacante, defensor);
        }
    }

    // Método detener
    public void detener() {
        if (!campeon1.estaVivo() || !campeon2.estaVivo()) {
            enCurso = false;
        }
    }

    // Método mostrar_ganador
    public String mostrarGanador() {
        if (campeon1.estaVivo() && !campeon2.estaVivo()) {
            return campeon1.getNombre(); // Devuelve el nombre del campeón 1 si está vivo
        } else{
            return campeon2.getNombre(); // Devuelve el nombre del campeón 2 si está vivo
        }
    }
    public boolean getenCurso() {
        return enCurso;
    }
    public int getTurno() {
        return turno;
    }
}

    