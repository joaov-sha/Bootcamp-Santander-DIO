public class SmartTv{

    boolean ligada = false;
    int canal = 1;
    int volume = 25;

    public void ligar(){
        ligada = true;
    }

    public void desligar(){
        ligada = false;
    }

    public void aumentarVolume(){
        volume++;
    }

    public void diminuirVolume(){
        volume--;
    }

    public void aumentarCanal(){
        canal++;
    }

    public void diminuirCanal(){
        canal--;
    }

    public void selecionarCanal(int valor){
        canal = valor;
    }

    @Override
    public String toString() {
        String retorno = "A tv está ligada? " + ligada + "\nEm qual canal está a tv? " + canal + "\nQual o volume da tv? " + volume + "\n";
        return retorno;
    }
}