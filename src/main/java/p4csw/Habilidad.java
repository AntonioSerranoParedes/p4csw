package p4csw;

public class Habilidad {
    private final String nombre;
    private final int dano;
    private final String tipo; // Ejemplo: "daño", "cura", etc.
    
    // Constructor
    public Habilidad(String nombre, int dano, String tipo) {
        this.nombre = nombre;
        this.dano = dano;
        this.tipo = tipo;
    }
        
    // Método aplicar
    public void aplicar(Campeon campeon, Campeon otroCampeon) {
        if (tipo.equalsIgnoreCase("daño")) {
            // Aplica daño al otro campeón
            
            System.out.println("La habilidad " + nombre + " causó " + dano + " de daño a " + otroCampeon.getNombre() + ".");
            otroCampeon.recibirDano(dano);
        } else if (tipo.equalsIgnoreCase("cura")) {
            // Aplica curación al otro campeón
            
            System.out.println("La habilidad " + nombre + " curó a " + campeon.getNombre() + " con " + dano + " puntos de vida.");
            campeon.recibirCuracion(dano);
        } else {
            System.out.println("El tipo de habilidad " + tipo + " no está soportado.");
        }
    }


    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDano() {
        return dano;
    }

    public String getTipo() {
        return tipo;
    }
}