import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Criar sistema de reservas
        SistemaReservas sistemaReservas = new SistemaReservas();

        Avião aviao1 = new Avião(123456L, 150, 2000.0, 5.0);
        Helicoptéro helicoptero1 = new Helicoptéro(789012L, 5, 500.0, "Pacientes");
        Helicoptéro helicoptero2 = new Helicoptéro(345678L, 200, 2500.0, "Voo Comercial");

        sistemaReservas.adicionarMeioDeTransporte(aviao1);
        sistemaReservas.adicionarMeioDeTransporte(helicoptero1);
        sistemaReservas.adicionarMeioDeTransporte(helicoptero2);

        // Variáveis para armazenar os dados inseridos pelo usuário
        String nomeCliente, origem, destino, tipoTransporte;
        Long cpfCliente;
        Long dataNascimento;
        long dataViagem;
        Integer capacidadePassageiros;
        Double autonomia, capacidadeCarga;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("------------------------------------------");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Meios de Transporte Disponíveis");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Sair");
            System.out.println("------------------------------------------");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    // Adicionar Cliente
                    System.out.print("Nome do Cliente: ");
                    nomeCliente = scanner.nextLine();
                    System.out.print("CPF do Cliente: ");
                    cpfCliente = scanner.nextLong();
                    System.out.print("Data de Nascimento do Cliente (AAAAMMDD): ");
                    dataNascimento = scanner.nextLong();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Endereço do Cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.print("Número de Telefone do Cliente: ");
                    String numeroTelefoneCliente = scanner.nextLine();
                    System.out.print("E-mail do Cliente: ");
                    String emailCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpfCliente, dataNascimento, enderecoCliente, numeroTelefoneCliente, emailCliente);
                    sistemaReservas.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    // Listar Meios de Transporte Disponíveis
                    sistemaReservas.listarMeiosDeTransporte();
                    break;

                case 3:
                    // Fazer Reserva
                    System.out.print("CPF do Cliente: ");
                    cpfCliente = scanner.nextLong();
                    Cliente clienteReserva = sistemaReservas.buscarCliente(cpfCliente);
                    if (clienteReserva == null) {
                        System.out.println("Cliente não encontrado. Por favor, adicione o cliente primeiro.");
                    } else {
                        System.out.print("Escolha o tipo de transporte (Avião/Helicóptero): ");
                        tipoTransporte = scanner.next();
                        scanner.nextLine(); // Consumir a quebra de linha

                        if (tipoTransporte.equalsIgnoreCase("Avião")) {
                            System.out.print("Origem da Viagem: ");
                            origem = scanner.nextLine();
                            System.out.print("Destino da Viagem: ");
                            destino = scanner.nextLine();
                            System.out.print("Data da Viagem (AAAAMMDD): ");
                            dataViagem = scanner.nextLong();
                            System.out.print("Capacidade de Passageiros: ");
                            capacidadePassageiros = scanner.nextInt();
                            System.out.print("Autonomia (em km): ");
                            autonomia = scanner.nextDouble();
                            System.out.print("Capacidade de Carga (em toneladas): ");
                            capacidadeCarga = scanner.nextDouble();

                            Avião aviao = new Avião(System.currentTimeMillis(), capacidadePassageiros, autonomia, capacidadeCarga);
                            sistemaReservas.criarReserva(clienteReserva, aviao, origem, destino, String.valueOf(dataViagem));
                            System.out.println("Reserva criada com sucesso!");
                        } else if (tipoTransporte.equalsIgnoreCase("Helicóptero")) {
                            System.out.print("Origem da Viagem: ");
                            origem = scanner.nextLine();
                            System.out.print("Destino da Viagem: ");
                            destino = scanner.nextLine();
                            System.out.print("Data da Viagem (AAAAMMDD): ");
                            dataViagem = scanner.nextLong();
                            System.out.print("Capacidade de Passageiros: ");
                            capacidadePassageiros = scanner.nextInt();
                            System.out.print("Autonomia (em km): ");
                            autonomia = scanner.nextDouble();

                            Helicoptéro helicoptero = new Helicoptéro(System.currentTimeMillis(), capacidadePassageiros, autonomia, "Pacientes");
                            sistemaReservas.criarReserva(clienteReserva, helicoptero, origem, destino, String.valueOf(dataViagem));
                            System.out.println("Reserva criada com sucesso!");
                        } else {
                            System.out.println("Tipo de transporte não reconhecido.");
                        }
                    }
                    break;

                case 4:
                    // Sair do programa
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
