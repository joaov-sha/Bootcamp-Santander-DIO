public class Iphone implements AparelhoTelefonico, ReprodutorMusical, NavegadorWeb{

    @Override
    public void tocar(){
        System.out.println("Tocando música!");
    }

    @Override
    public void pausar(){
        System.out.println("Pausando música!");
    }

    @Override
    public void selecionarMusica(){
        System.out.println("Selecionando música!");
    }

    @Override
    public void ligar(){
        System.out.println("Realizando ligação!");
    }

    @Override
    public void atender(){
        System.out.println("Atendendo chamada recebida!");
    }

    @Override
    public void iniciarCorreioDeVoz(){
        System.out.println("Iniciando correio de voz!");
    }

    @Override
    public void exibirPaginaWeb(){
        System.out.println("Exibindo página web!");
    }

    @Override
    public void adicionarNovaAba(){
        System.out.println("Adicionando nova aba!");
    }

    @Override
    public void atualizarPaginaWeb(){
        System.out.println("Atualizando página web!");
    }
}
