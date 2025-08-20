
package Ejercicio4;

/**
 *
 * @author gonza
 */
public class ParqueTematico {
    private Area[] areas;

    public ParqueTematico(){
        this.areas = new Area[4];
        this.areas[0] = new Area("East Zone",10);
        this.areas[1] = new Area("West Zone",5);
        this.areas[2] = new Area("North Zone",7);
        this.areas[3] = new Area("South Zone",14);
    }
    
    public boolean seReservoEnArea(String nomb, int disp){
        String zona = nomb.toLowerCase();
        boolean exito = false;
        switch(zona){
            case "east zone":
                exito = this.areas[0].reservar(disp);
                break;
            case "west zone":
                exito = this.areas[1].reservar(disp);
                break;
            case "north zone":
                exito = this.areas[2].reservar(disp);
                break;
            case "south zone":
                exito = this.areas[3].reservar(disp);
                break;
            default:
                break;
        }
        return exito;
    }
    
    
}
