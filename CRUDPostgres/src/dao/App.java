package principal;

import dao.ClienteDAO;
import modelo.Cliente;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar clientes");
            System.out.println("2. Inserir cliente");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Excluir cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:

                    for (Cliente c : clienteDAO.listar()) {
                        System.out.println(c.getNome() + " - " + c.getCpf());
                    }
                    break;
                case 2:

                    Cliente cliente = new Cliente();
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    cliente.setCpf(scanner.nextLine());
                    System.out.print("Email: ");
                    cliente.setEmail(scanner.nextLine());
                    System.out.print("Telefone: ");
                    cliente.setTelefone(scanner.nextLine());
                    System.out.print("Salário: ");
                    cliente.setSalario(scanner.nextDouble());
                    scanner.nextLine(); 
                    System.out.print("Carro desejado: ");
                    cliente.setCarroDesejado(scanner.nextLine());

                    clienteDAO.inserir(cliente);
                    System.out.println("Cliente inserido com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
