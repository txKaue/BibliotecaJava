package Views;

import Models.Livros;
import Models.Cliente;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Listar livros");
        System.out.println("2. Listar clientes");
        System.out.println("3. Alugar livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Adicionar livro");
        System.out.println("6. Adicionar cliente");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void mostrarLivros(List<Livros> livros) {
        System.out.println("Livros disponíveis:");
        for (Livros livro : livros) {
            System.out.println(livro);
            System.out.println(); // Espaço entre livros
        }
    }

    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println(); // Espaço entre clientes
        }
    }

    public int selecionarCliente() {
        System.out.print("Digite o ID do cliente: ");
        return scanner.nextInt();
    }

    public int selecionarLivro() {
        System.out.print("Digite o ID do livro: ");
        return scanner.nextInt();
    }

    public void mensagem(String msg) {
        System.out.println(msg);
        System.out.println(); // Espaço após a mensagem
    }

    // Método para coletar informações de um novo livro
    public Livros adicionarLivro() {
        System.out.print("Digite o nome do livro: ");
        String nome = scanner.next();
        
        System.out.print("Digite o ISBN do livro: ");
        int isbn = scanner.nextInt();
        
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.next();
        
        // Geração de um ID aleatório, você pode modificar conforme sua lógica
        int id = gerarIdAleatorio(); // Supondo que você tenha um método para gerar um ID

        return new Livros(id, nome, isbn, autor);
    }

    // Método para coletar informações de um novo cliente
    public Cliente adicionarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.next();
        
        // Geração de um ID aleatório, você pode modificar conforme sua lógica
        int id = gerarIdAleatorio(); // Supondo que você tenha um método para gerar um ID

        return new Cliente(id, nome);
    }

    // Método fictício para gerar ID aleatório
    private int gerarIdAleatorio() {
        // Implemente sua lógica para gerar um ID único
        return (int) (Math.random() * 1000); // Exemplo: ID aleatório entre 0 e 999
    }
}
