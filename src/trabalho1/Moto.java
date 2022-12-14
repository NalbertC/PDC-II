package trabalho1;

public class Moto {

    private int id, ano;
    private String marca, modelo, cor;

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    private Moto(int id, int ano, String marca, String modelo, String cor) {
        this.id = id;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public static class MotoBuilder {

        private int id, ano;
        private String marca, modelo, cor;

        public MotoBuilder() {
        }

        public MotoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public MotoBuilder ano(int ano) {
            this.ano = ano;
            return this;
        }

        public MotoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public MotoBuilder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public MotoBuilder cor(String cor) {
            this.cor = cor;
            return this;
        }

        public Moto build() {
            return new Moto(id, ano, marca, modelo, cor);
        }

    }

    @Override
    public String toString() {
        return "\nMoto = {" + "\n\tid: " + id + ",\n\tmarca: " + marca + ",\n\tmodelo: " + modelo + "\n}";
    }

}
