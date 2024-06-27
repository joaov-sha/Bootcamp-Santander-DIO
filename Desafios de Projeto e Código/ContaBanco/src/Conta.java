public class Conta {
    
    private String correntista;
    private String agencia;
    private int numeroConta;
    private double saldo;

    public Conta(String correntista, String agencia, int numeroConta){
        this.correntista = correntista;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        saldo -= valor;
    }

    @Override
    public String toString() {
        String mensagem;
        if(saldo > 0){
            mensagem = "Olá " + correntista + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo de: R$" + saldo + " já está disponível para saque."; 
        }else{
            mensagem = "Olá " + correntista + ", sua conta de número " + numeroConta + " na agência " + agencia + " foi criada com sucesso! Ao realizar seus próximos depósitos o seu saldo estará disponível para saque.";
        }
        return mensagem;
    }
}
