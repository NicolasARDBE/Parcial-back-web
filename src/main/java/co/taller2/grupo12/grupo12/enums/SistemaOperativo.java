package co.taller2.grupo12.grupo12.enums;

public enum SistemaOperativo {
    ANDROID("Android"),
    IOS("iOS");

    private final String nombre;

    SistemaOperativo(String nombre) {
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