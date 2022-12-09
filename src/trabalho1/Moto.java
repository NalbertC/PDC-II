package trabalho1;

public class Moto {

    private int id, ano;
    private String marca, modelo, cor;

    public Moto() {
    }

    public Moto(int id) {
        this.id = id;
    }

    public Moto(int id, int ano, String marca, String modelo, String cor) {
        this.id = id;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "\nMoto {\n\tid: " + id + ", \n\tcor: " + cor + ", \n\tmarca: " + marca + ", \n\tmodelo: " + modelo + ",\n\tano: " + ano + "\n}";
    }

}
