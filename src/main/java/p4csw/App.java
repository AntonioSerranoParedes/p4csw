package p4csw;

import java.util.Arrays;
import java.util.List;
  
public class App {
    public static void main(String[] args) {
        // Crear habilidades para cada campeón
        List<Habilidad> habilidades1 = Arrays.asList(
            new Habilidad("La espada de los oscuros", 950, "daño"),
            new Habilidad("Cadenas Infernales", 170, "daño"),
            new Habilidad("Deslizamiento Sombrio", 25, "daño"),
            new Habilidad("El aniquilador de Mundos", 300, "daño")
        );

        List<Habilidad> habilidades2 = Arrays.asList(
            new Habilidad("Parrrlamento", 60, "daño"),
            new Habilidad("Eliminar escorbuto", 70, "cura"),
            new Habilidad("Barril de pólvora", 90, "daño"),
            new Habilidad("Andanada de Cañon", 275, "daño")
        );

        // Crear campeones con sus atributos y habilidades
        Campeon campeon1 = new Campeon("Aatrox", "Luchador",600, 600, 100, 70, habilidades1);
        Campeon campeon2 = new Campeon("Gangplank", "Especialista",550, 550, 95, 65, habilidades2);

        // Mostrar detalles iniciales de los campeones
        System.out.println("=== Detalles Iniciales de los Campeones ===");
        System.out.println("Campeón 1: " + campeon1.getNombre() + " (Rol: " + campeon1.getRol() + ")");
        System.out.println("Campeón 2: " + campeon2.getNombre() + " (Rol: " + campeon2.getRol() + ")");

        // Crear el combate
        Combate combate = new Combate(campeon1, campeon2);

        // Iniciar el combate
        System.out.println("\n=== Iniciando Combate ===");
        combate.iniciar();
    }
}
