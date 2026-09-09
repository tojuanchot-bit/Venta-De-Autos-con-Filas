public class Objautos {
    
    private String Marca;
    private String Modelo;
    private String Estado;
    private int Anio;
    private double Precio;
    private int TiempoEspera;
    
    public Objautos() {
    }

    public Objautos(String marca, String modelo, String estado, int anio, double precio, int tiempoEspera) {
        Marca = marca;
        Modelo = modelo;
        Estado = estado;
        Anio = anio;
        Precio = precio;
        TiempoEspera = tiempoEspera;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getTiempoEspera() {
        return TiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        TiempoEspera = tiempoEspera;
    }

    
}
