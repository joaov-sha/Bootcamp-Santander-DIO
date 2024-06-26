public class Usuario {
    
    public static void main(String[] args) throws Exception{
        
        SmartTv smartTv = new SmartTv();

        System.out.println(smartTv.toString());

        smartTv.ligar();

        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        smartTv.aumentarVolume();
        smartTv.aumentarCanal();
        smartTv.aumentarCanal();
        smartTv.diminuirCanal();
        smartTv.selecionarCanal(8);

        System.out.println(smartTv.toString());

        smartTv.desligar();

        System.out.println(smartTv.toString());
        
    }
}
