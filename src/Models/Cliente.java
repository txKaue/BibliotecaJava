package Models;

public class Cliente {
    private int _id;
    private String nome;

    public Cliente(int id, String nome) {
        this._id = id;
        this.nome = nome;
    }

    public int getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + _id + ", Nome: " + nome;
    }
}
