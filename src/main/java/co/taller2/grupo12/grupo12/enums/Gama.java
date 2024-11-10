package co.taller2.grupo12.grupo12.enums;

public enum Gama {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");

    private final String nombre;

    Gama(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}