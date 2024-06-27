import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o primeiro parâmetro: ");
        int numeroUm = s.nextInt();
        s.nextLine();
        System.out.print("Digite o segundo parâmetro: ");
        int numeroDois = s.nextInt();
        s.nextLine();

        try{
            contar(numeroUm, numeroDois);
        }catch(ParametrosInvalidosException e){
            System.out.println(e.getMessage());
        }
        s.close();
    }

    public static void contar(int numeroUm, int numeroDois) throws ParametrosInvalidosException{
        if(numeroDois > numeroUm){
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }else{
            for(int i = numeroUm; i <= numeroDois; i++){
                System.out.println("Imprimindo o número " + i);
            }
        }
    }
}
