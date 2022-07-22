import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<Cliente>();
    }

    public String getNome() {
        return nome;
    }

    public void getClientes() {
        System.out.println("\n=== Lista de clientes do banco ===");
        clientes.forEach(c -> System.out.println(c.getNome()));
        System.out.println();
    }

    public void novoCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente getCliente(String nomeCliente) {
        return this.clientes.stream().filter(c -> c.getNome().equals(nomeCliente)).findAny().orElse(null);
    }
}
