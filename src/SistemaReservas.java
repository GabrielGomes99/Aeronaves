import java.util.ArrayList;
import java.util.List;


public class SistemaReservas {
    private List<Aeronave> meiosDeTransporte;
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public SistemaReservas() {
        meiosDeTransporte = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarMeioDeTransporte(Aeronave meioDeTransporte) {
        meiosDeTransporte.add(meioDeTransporte);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarMeiosDeTransporte() {
        System.out.println("Meios de Transporte Disponíveis:");
        System.out.println("------------------------------------------");
        for (Aeronave meio : meiosDeTransporte) {
            if (meio instanceof Avião) {
                Avião aviao = (Avião) meio;
                System.out.println("Número de Registro: " + aviao.getNumeroRegistro());
                System.out.println("Tipo: Avião");
                System.out.println("Capacidade de Passageiros: " + aviao.getCapacidadePassageiros());
                System.out.println("Autonomia: " + aviao.getAutonomia() + " km");
                System.out.println("Capacidade de Carga: " + aviao.getCapacidadeCarga() + " toneladas");
            } else if (meio instanceof Helicoptéro) {
                Helicoptéro helicoptero = (Helicoptéro) meio;
                System.out.println("Número de Registro: " + helicoptero.getNumeroRegistro());
                System.out.println("Tipo: Helicóptero");
                System.out.println("Capacidade de Passageiros: " + helicoptero.getCapacidadePassageiros());
                System.out.println("Autonomia: " + helicoptero.getAutonomia() + " km");
                System.out.println("Tipo de Transporte: " + helicoptero.getTipoTransporte());
            }
            System.out.println("-----------------------------------------");
        }
    }

    public void criarReserva(Cliente cliente, Aeronave meioDeTransporte, String origem, String destino, String dataViagem) {
        Reserva reserva = new Reserva(meioDeTransporte, origem, destino, Long.parseLong(dataViagem));
        reservas.add(reserva);
    }

    public Cliente buscarCliente(Long cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Reserva> buscarReservasCliente(Long cpf) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getMeioTransporte() instanceof Avião) {
                Avião aviao = (Avião) reserva.getMeioTransporte();
                if (aviao.getNumeroRegistro().equals(cpf)) {
                    reservasCliente.add(reserva);
                }
            }
            if (reserva.getMeioTransporte() instanceof Helicoptéro) {
                Helicoptéro helicoptero = (Helicoptéro) reserva.getMeioTransporte();
                if (helicoptero.getNumeroRegistro().equals(cpf)) {
                    reservasCliente.add(reserva);
                }
            }
        }
        return reservasCliente.isEmpty() ? null : reservasCliente;
    }
}
