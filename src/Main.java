import java.util.Scanner;

public class Main {
    static Banco banco = new Banco("Nova Geração");

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Naiara");
        banco.novoCliente(cliente);

//        ccorrente.depositar(100);
//        ccorrente.transferir(100, cpoupanca);
//        ccorrente.sacar(50);
//
//        ccorrente.extrato();
//        cpoupanca.extrato();

        System.out.println("Olá, Bem-vindo ao Banco " + banco.getNome());

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1. Já sou cliente");
            System.out.println("2. Ainda não sou cliente.");
            System.out.println("3. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuCliente(scanner);
                    break;
                case 2:
                    menuAindaNaoEhCliente(scanner);
                    break;
            }
        } while (opcao != 3);
    }

    public static Cliente verificaCliente(String nomeCliente) {
        banco.getClientes();
        return banco.getCliente(nomeCliente);
    }

    public static void menuCliente(Scanner scanner) {
        System.out.println("Nome da conta (cliente): ");
        String nome = scanner.next();
        Cliente cliente = verificaCliente(nome);

        if (cliente != null) {
            System.out.println("Bem-vindo de volta, " + cliente.getNome());
            System.out.println("O que você gostaria de fazer hoje?");

            Conta corrente = cliente.getContaCorrente();
            Conta poupanca = cliente.getContaPoupanca();

            int opcao = 0;

            do {
                System.out.println("1. Sacar");
                System.out.println("2. Depositar");
                System.out.println("3. Transferir");
                System.out.println("4. Extrato");
                System.out.println("5. Voltar ao menu anterior");

                opcao = scanner.nextInt();

                if (opcao < 4) {
                    System.out.println("Qual o valor?");
                    double valor = scanner.nextDouble();

                    switch (opcao) {
                        case 1:
                            corrente.sacar(valor);
                            break;
                        case 2:
                            corrente.depositar(valor);
                            break;
                        case 3:
                            corrente.transferir(valor, poupanca);
                            break;
                    }
                }

                if (opcao == 4) {
                    corrente.extrato();
                    poupanca.extrato();
                }
            } while (opcao != 5);
        } else {
            System.out.println("Opa, infelizmente não encontramos uma conta com esse nome, mas se quiser pode criar uma.");
        }
    }

    public static void menuAindaNaoEhCliente(Scanner scanner) {
        System.out.println("Gostaria de criar uma conta conosco?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.println("Informe o seu nome: ");
            String nomeCliente = scanner.next();

            if (nomeCliente.length() > 0) {
                Cliente cliente = verificaCliente(nomeCliente);
                if (cliente == null) {
                    Cliente novoCliente = new Cliente(nomeCliente);
                    banco.novoCliente(novoCliente);
                    System.out.println("Parabéns, " + novoCliente.getNome() + " suas contas Corrente e Poupança já foram criadas.");
                } else {
                    System.out.println("");
                }
            }

        }
    }
}
