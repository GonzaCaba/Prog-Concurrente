package Ejercicio6;

public class Area {
    private int disponibilidad;
    private String nombreArea;
    private boolean estadoReserva;

    public Area(int unaDisponibilidad, String unNombre) {
        this.disponibilidad = unaDisponibilidad;
        this.nombreArea = unNombre;
        this.estadoReserva = false;
    }

    public void setEstadoReserva(boolean estadoNuevo) {
        this.estadoReserva = estadoNuevo;
    }

    public void setNombreArea(String nuevoNombre) {
        this.nombreArea = nuevoNombre;
    }

    public void setDisponibilidad(int nuevaDisponibilidad) {
        this.disponibilidad = nuevaDisponibilidad;
    }

    public int getDisponibilidad() {
        return this.disponibilidad;
    }

    public boolean getEstadoReserva() {
        return this.estadoReserva;
    }

    public String getNombre() {
        return this.nombreArea;
    }
}
