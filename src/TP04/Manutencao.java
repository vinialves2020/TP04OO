package TP04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Manutencao extends Padronizacao implements FuncoesGerais  {
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
    static TelaManutencao telaManutencao =new TelaManutencao();
    private float manufinal;
    private boolean validador;
    private float valorcalc;
public Manutencao() {
    }


    /**
     * * Atribui valor a variavel manufinal
     */
public void setManuF(float manufinal) {
    this.manufinal = manufinal;
}

@Override
public void cadastrarOdometro() {
    // TODO Auto-generated method stub
    
}


@Override
public void cadastrarData() {
    // TODO Auto-generated method stub
    
}
/**
 * O metodo salvarValorManutencao pega o valor da variavel manufinal e salva em um txt especifico
 */
public void salvarValorManutencao(){
    FileWriter VW = null;
    try {
        File file = new File("Usuarios/"+usuario.getUsuarioString()); 
        if (!file.exists()) {
        file.mkdirs();}
        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"ManutençõesValor.txt");
        VW.write("0"+Float.toString(manufinal));
        VW.close();
    } catch (IOException e) {

    }
}
/**
 * O metodo apagarManutencao apaga todos os valores de abastecimentos existes de um carro
 */
public void apagarManutencao(){
    FileWriter VW = null;
    FileWriter VW1 = null;
    
    try {
        carro.pegarNomeCarro();
        File file = new File("Usuarios/"+usuario.getUsuarioString());  

            if (!file.exists()) {
            file.mkdirs();}

        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"ManutençõesValor.txt");
        VW1 = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"ManutençõesInfos.txt");
        VW.write("00");
        VW1.write("");
        VW.close();
    } catch (IOException e) {

    }
}

/**
 * O metodo ValidarManutencaorecebe data,odometro,valorString e tipo,verifica se os valores sao validos
 * atribui true ou false dependendo do resultado a variavel validador
 */
public boolean ValidarManutencao(String data, String odometro,String valorString ,String tipo) {
    if( data.matches("[0-9]*") && odometro.matches("[0-9]*")&& valorString.matches("[0-9]*") && tipo.matches("[a-zA-Z]*") ){
        

        try {
            telaManutencao.pegarValorManutencao();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setValidador(true);
        float valorfloat = Float.parseFloat(valorString);
        manufinal = telaManutencao.getValorcalcM() +valorfloat;
        setManuF(manufinal);
        
    }
    else{

        JOptionPane.showMessageDialog(null, "Digite Valores Validos");
        setValidador(false);
    }
    return validador;
    
}
/**
 * Retorna o valor da varivel validador
 */
public boolean getValidador() {
    return validador;
}
/**
 * Atribui valor a variavel validador
 */
public void setValidador(boolean validador) {
    this.validador = validador;
}
/**
 * Retorna o valor da varivel valorcalc
 */
public float getcalc() {
    return valorcalc;
}
}
