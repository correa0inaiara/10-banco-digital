public class ContaPoupanca extends Conta {

    @Override
    public void extrato() {
        System.out.println("\n=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
    }
}
