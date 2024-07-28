public class ContaCorrente extends Conta{
    
    public ContaCorrente(){
        super.agencia = AGENCIA_PADRAO;
        super.numero = SEQUENCIAL++;
    }
}
