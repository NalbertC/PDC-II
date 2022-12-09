package exercicio1;

public class Produto {

    int id;
    String nome, descricao, fornecedor;
    float preco;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, String fornecedor, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto {\n\tid: " + id + ", \n\tnome: " + nome + ", \n\tdescricao: " + descricao + ", \n\tfornecedor: " + fornecedor + ", \n\tpreco: R$ " + String.format("%.2f", preco) + "\n}";
    }

}
