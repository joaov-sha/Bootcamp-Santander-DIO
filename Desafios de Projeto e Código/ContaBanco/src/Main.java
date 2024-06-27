import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        Locale.setDefault(Locale.US);

        String correntista, agencia;
        int numeroConta;
        char opcao;
        double valor;

        System.out.print("Informe seu nome: ");
        correntista = s.nextLine();

        System.out.print(correntista + " favor informar o número da Agência: ");
        agencia = s.nextLine();

        System.out.print("Agora, informe o número da conta: ");
        numeroConta = s.nextInt();
        s.nextLine();

        System.out.print("Você deseja realizar algum depósito? (s/n)");
        opcao = s.next().charAt(0);
        s.nextLine();

        Conta conta = new Conta(correntista,agencia,numeroConta);

        if(opcao == 's'){
            System.out.print("Informe o valor que deseja depositar: ");
            valor = s.nextDouble();
            s.nextLine();
            conta.depositar(valor);
        }else{
            valor = 0.0;
        }

        System.out.println(conta.toString());

        s.close();
    }
}
