package Models;

public class Livros {
    private int _id;
    private String nome;
    private int ISBN;
    private String autor;
    private boolean emprestado;
    private int id_cliente;

    public Livros(int id, String nome, int ISBN, String autor) {
        this._id = id;
        this.nome = nome;
        this.ISBN = ISBN;
        this.autor = autor;
        this.emprestado = false;
        this.id_cliente = 0;
    }

    public int getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public int getIdCliente() {
        return id_cliente;
    }

    public boolean alugar(int id_cliente) {
        if (!emprestado) {
            this.emprestado = true;
            this.id_cliente = id_cliente;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (emprestado) {
            this.emprestado = false;
            this.id_cliente = 0;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String status = emprestado ? "Emprestado" : "Disponível";
        return "ID: " + _id + ", Nome: " + nome + ", ISBN: " + ISBN + ", Autor: " + autor + ", Status: " + status;
    }
}
