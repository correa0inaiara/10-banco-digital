import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Calendar dataInicio;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.dataInicio = Calendar.getInstance();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Valor R$ " + valor + " sacado com sucesso.");
        } else {
            System.out.println("Saldo insuficiênte: R$ " + this.saldo);
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Valor R$ " + valor + " depositado com sucesso.");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Valor R$ " + valor + " transferido com sucesso.");
        } else {
            System.out.println("Saldo insuficiênte: R$ " + this.saldo);
        }
    }

    protected void imprimirExtrato() {
//        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Data/Hora Ínicio: %s", this.getDataHoraFormatada()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }

    protected String getDataHoraFormatada() {
        Date data = this.dataInicio.getTime();
        DateFormat formatData = DateFormat.getDateInstance(DateFormat.SHORT);

        DateFormat formatHora = DateFormat.getTimeInstance();

        String dataHora = formatData.format(data) + " " + formatHora.format((data));

        return dataHora;
    }
}
