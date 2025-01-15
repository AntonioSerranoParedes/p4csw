package p4csw;
import java.util.List;

public class Campeon {
    private final String nombre;
    private final String rol; //No se hace uso es simplemente informativo
    private final int puntosVidaMaxima;
    private int puntosVida;
    private final int danoAtaque;
    private final int defensa;
    private List<Habilidad> habilidades;
        
    
        // Constructor
    public Campeon(String nombre, String rol,int puntosVidaMaxima, int puntosVida, int danoAtaque, int defensa, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.rol = rol;
        this.puntosVidaMaxima=puntosVidaMaxima;
        this.puntosVida = puntosVida;
        this.danoAtaque = danoAtaque;
        this.defensa = defensa;
        this.habilidades = habilidades;
    }

    public Campeon(String nombre, String rol,int puntosVidaMaxima, int puntosVida, int danoAtaque, int defensa) {
        this.nombre = nombre;
        this.rol = rol;
        this.puntosVidaMaxima=puntosVidaMaxima;
        this.puntosVida = puntosVida;
        this.danoAtaque = danoAtaque;
        this.defensa = defensa;
    }


    // Método atacar
    public void atacar(Campeon otroCampeon) {
         
        System.out.println(nombre + " atacó a " + otroCampeon.nombre + " causando " + danoAtaque + " de daño.");
        otroCampeon.recibirDano(danoAtaque);
    }

    // Método usar_habilidad
    public void usarHabilidad(String habilidadNombre, Campeon campeon, Campeon otroCampeon) {
        // Busca la habilidad en la lista de habilidades
        Habilidad habilidad = habilidades.stream()
                                         .filter(h -> h.getNombre().equalsIgnoreCase(habilidadNombre))
                                         .findFirst()
                                         .orElse(null);
    
        if (habilidad != null) {
            System.out.println(nombre + " usó la habilidad " + habilidad.getNombre() + 
            " contra " + otroCampeon.getNombre() + ".");
            habilidad.aplicar(campeon, otroCampeon); // Aplicar la habilidad al otro campeón
          
        }
    }
    // Método recibir_dano
    public void recibirDano(int dano) {
      
        int danoFinal = Math.max(dano - this.defensa, 0); // El daño recibido se reduce por la defensa
        this.puntosVida = Math.max(this.puntosVida - danoFinal, 0); // Los puntos de vida no pueden ser negativos
        System.out.println(nombre + " recibió " + danoFinal + " de daño. Puntos de vida restantes: " + puntosVida);
    }

    //Metodo recibir curaciones
    public void recibirCuracion(int cantidad) {
        // Evita que los puntos de vida excedan el máximo
        this.puntosVida = Math.min(this.puntosVida + cantidad, this.puntosVidaMaxima);
        System.out.println(nombre + " recibió una curación de " + cantidad + " puntos. Puntos de vida actuales: " + puntosVida);
    }
    // Método esta_vivo
    public boolean estaVivo() {
        return this.puntosVida > 0;
    }
    
    // Getters y Setters (opcional, según necesidad)
    public String getNombre() {
        return nombre;
    }
    public int getPuntosVidaMaxima() {
        return puntosVidaMaxima;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getPuntosDefensa() {
        return defensa;
    }
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }
    public int getDanoAtaque() {
        return danoAtaque;
    }
    public String getRol() {
        return rol;
    }
        
}