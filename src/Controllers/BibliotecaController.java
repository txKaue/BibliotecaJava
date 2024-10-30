package Controllers;

import Models.Livros;
import Models.Cliente;
import Views.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private List<Livros> livros;
    private List<Cliente> clientes;
    private ConsoleView view;

    public BibliotecaController() {
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.view = new ConsoleView();
        inicializarDados(); // Adiciona alguns dados iniciais
    }

    private void inicializarDados() {
        // Adiciona livros iniciais
        livros.add(new Livros(1, "O Senhor dos Anéis", 123456, "J.R.R. Tolkien"));
        livros.add(new Livros(2, "1984", 654321, "George Orwell"));

        // Adiciona clientes iniciais
        clientes.add(new Cliente(1, "João"));
        clientes.add(new Cliente(2, "Maria"));
    }

    public void iniciar() {
        boolean running = true;
        while (running) {
            int opcao = view.mostrarMenu();
            switch (opcao) {
                case 1:
                    view.mostrarLivros(livros);
                    break;
                case 2:
                    view.mostrarClientes(clientes);
                    break;
                case 3: // Alugar livro
                    int idCliente = view.selecionarCliente();
                    int idLivro = view.selecionarLivro();
                    if (alugarLivro(idLivro, idCliente)) {
                        view.mensagem("Livro alugado com sucesso!");
                    } else {
                        view.mensagem("Erro ao alugar livro.");
                    }
                    break;
                case 4: // Devolver livro
                    idLivro = view.selecionarLivro();
                    if (devolverLivro(idLivro)) {
                        view.mensagem("Livro devolvido com sucesso!");
                    } else {
                        view.mensagem("Erro ao devolver livro.");
                    }
                    break;
                case 5: // Adicionar livro
                    Livros novoLivro = view.adicionarLivro();
                    livros.add(novoLivro);
                    view.mensagem("Livro adicionado com sucesso!");
                    break;
                case 6: // Adicionar cliente
                    Cliente novoCliente = view.adicionarCliente();
                    clientes.add(novoCliente);
                    view.mensagem("Cliente adicionado com sucesso!");
                    break;
                case 7: // Sair
                    running = false;
                    view.mensagem("Saindo...");
                    break;
                default:
                    view.mensagem("Opção inválida.");
            }
        }
    }

    private boolean alugarLivro(int livroId, int clienteId) {
        for (Livros livro : livros) {
            if (livro.getId() == livroId) {
                return livro.alugar(clienteId);
            }
        }
        return false;
    }

    private boolean devolverLivro(int livroId) {
        for (Livros livro : livros) {
            if (livro.getId() == livroId) {
                return livro.devolver();
            }
        }
        return false;
    }
}
