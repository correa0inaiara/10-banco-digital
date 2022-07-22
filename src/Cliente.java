public class Cliente {

    private String nome;
    private Conta contaCorrente;
    private Conta contaPoupanca;

    public Cliente(String nome) {
        this.nome = nome;
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaCorrente() {
        return contaCorrente;
    }

    public Conta getContaPoupanca() {
        return contaPoupanca;
    }
}
