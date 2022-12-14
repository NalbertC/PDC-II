package trabalho1;

public class Pessoa {

    private String nome, sobrenome, apelido, nomePai;

    private Pessoa(String nome, String sobrenome, String apelido, String nomePai) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.nomePai = nomePai;
    }

    public static class PessoaBuilder {

        private String nome, sobrenome, apelido, nomePai;

        public PessoaBuilder() {

        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public PessoaBuilder apelido(String apelido) {
            this.apelido = apelido;
            return this;
        }

        public PessoaBuilder nomePai(String nomePai) {
            this.nomePai = nomePai;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(nome, sobrenome, apelido, nomePai);
        }

    }

    @Override
    public String toString() {
        return "\nPessoa {" + "\n\tnome=" + nome + ", \n\tsobrenome=" + sobrenome + ", \n\tapelido=" + apelido + ", \n\tnomePai=" + nomePai + "\n}";
    }

}
