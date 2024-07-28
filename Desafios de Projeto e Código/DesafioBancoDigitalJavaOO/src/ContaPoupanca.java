public class ContaPoupanca extends Conta{
        
    public ContaPoupanca(){
        super.agencia = AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }
}
