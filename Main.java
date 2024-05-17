package suaempresa.seuapp;

import suaempresa.seuapp.dao.PassageiroDAO;
import suaempresa.seuapp.dao.MotoristaDAO;
import suaempresa.seuapp.dao.ViagemDAO;
import suaempresa.seuapp.entidades.Passageiro;
import suaempresa.seuapp.entidades.Motorista;
import suaempresa.seuapp.entidades.Viagem;
import suaempresa.seuapp.util.ConexaoBD;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar uma conexão com o banco de dados
        ConexaoBD conexaoBD = new ConexaoBD();

        // Instanciar DAOs
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        ViagemDAO viagemDAO = new ViagemDAO();

        // Instanciar Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibir menu para o usuário
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Passageiro");
            System.out.println("2. Cadastrar Motorista");
            System.out.println("3. Solicitar Viagem");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastro de Passageiro
                    cadastrarPassageiro(passageiroDAO, scanner);
                    break;
                case 2:
                    // Cadastro de Motorista
                    cadastrarMotorista(motoristaDAO, scanner);
                    break;
                case 3:
                    // Solicitar Viagem
                    solicitarViagem(viagemDAO, scanner);
                    break;
                case 4:
                    // Sair
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        // Fechar o Scanner
        scanner.close();
    }

    private static void cadastrarPassageiro(PassageiroDAO passageiroDAO, Scanner scanner) {
        // Solicitar dados do passageiro
        System.out.print("Nome do passageiro: ");
        String nome = scanner.next();
        System.out.print("CPF do passageiro: ");
        long cpf = scanner.nextLong();
        System.out.print("Cartão de crédito: ");
        String cartaoCredito = scanner.next();
        System.out.print("Bandeira do cartão: ");
        String bandeiraCartao = scanner.next();
        System.out.print("Cidade de origem: ");
        String cidadeOrigem = scanner.next();

        // Criar objeto Passageiro
        Passageiro passageiro = new Passageiro();
        passageiro.setNome(nome);
        passageiro.setCpf(cpf);
        passageiro.setCartaoCredito(cartaoCredito);
        passageiro.setBandeiraCartao(bandeiraCartao);
        passageiro.setCidadeOrigem(cidadeOrigem);

        // Adicionar o passageiro ao banco de dados
        passageiroDAO.adicionarPassageiro(passageiro);
    }

    private static void cadastrarMotorista(MotoristaDAO motoristaDAO, Scanner scanner) {
        // Solicitar dados do motorista
        System.out.print("Nome do motorista: ");
        String nome = scanner.next();
        System.out.print("CPF do motorista: ");
        long cpf = scanner.nextLong();
        System.out.print("CNH do motorista: ");
        String cnh = scanner.next();
        System.out.print("Banco: ");
        int banco = scanner.nextInt();
        System.out.print("Agência: ");
        int agencia = scanner.nextInt();
        System.out.print("Conta: ");
        int conta = scanner.nextInt();

        // Criar objeto Motorista
        Motorista motorista = new Motorista();
        motorista.setNome(nome);
        motorista.setCpf(cpf);
        motorista.setCnh(cnh);
        motorista.setBanco(banco);
        motorista.setAgencia(agencia);
        motorista.setConta(conta);

        // Adicionar o motorista ao banco de dados
        motoristaDAO.adicionarMotorista(motorista);
    }

    private static void solicitarViagem(ViagemDAO viagemDAO, Scanner scanner) {
        // Solicitar dados da viagem
        // ...

        // Criar objeto Viagem
        Viagem viagem = new Viagem();
        // ...

        // Adicionar a viagem ao banco de dados
        viagemDAO.adicionarViagem(viagem);
    }
}
