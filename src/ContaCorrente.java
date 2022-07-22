public class ContaCorrente extends Conta {

    @Override
    public void extrato() {
        System.out.println("\n=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }

}
