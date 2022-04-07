package TP04;

public class App {
    static Abastecimento abastecimento = new Abastecimento();
    static Carro carro = new Carro();
    static Despesa despesa = new Despesa();
    static Manutencao manutencao = new Manutencao();
    static Padronizacao padronizacao = new Padronizacao();
    static Usuario usuario = new Usuario();
    static TelaLogin telaLogin = new TelaLogin();
    
    /** 
     *  A Classe Main e a primeira funcao executada no projeto , no caso executando a criacao da tela de Login
     * @author Vinicius Alves
     */
    public static void main(String[] args) {
        telaLogin.Criartelalogin();
    }

}
