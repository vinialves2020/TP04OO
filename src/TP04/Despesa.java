package TP04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Despesa  extends Padronizacao implements FuncoesGerais{
    static TelaDespesa telaDespesa = new TelaDespesa();
    static TelaPrincipal TelaPrincipal= new TelaPrincipal();
    static Carro carro= new Carro();
    static Usuario usuario= new Usuario();
    private float despesafinal;
    float valorcalc;
    
    private boolean validador = false;


public Despesa() {
    
}
/**
 * * Retorna o valor da varivel validador
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
 * * O metodo salvarValorDespesa pega o valor da variavel despesafinal e salva em um txt especifico
 */
public void salvarValorDespesa(){
    FileWriter VW = null;
    
    try {
        carro.pegarNomeCarro();
        File file = new File("Usuarios/"+usuario.getUsuarioString());  

            if (!file.exists()) {
            file.mkdirs();}

        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"DespesaValor.txt");
        VW.write("0"+Float.toString(despesafinal));
        VW.close();
    } catch (IOException e) {

    }
}
/**
 * O metodo apagarDespesas apaga todos os valores de abastecimentos existes de um carro
 */
public void apagarDespesas(){
    FileWriter VW = null;
    FileWriter VW1 = null;
    
    try {
        carro.pegarNomeCarro();
        File file = new File("Usuarios/"+usuario.getUsuarioString());  

            if (!file.exists()) {
            file.mkdirs();}

        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"DespesaValor.txt");
        VW1 = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"DespesaInfos.txt");
        VW.write("00");
        VW1.write("");
        VW.close();
    } catch (IOException e) {

    }
}
/**
 * Atribui valor a variavel despesafinal
 */
public void setDespesaF(float despesafinal) {
    this.despesafinal = despesafinal;
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
 * O metodo ValidarDepesa recebe data,odometro,valorString e tipo,verifica se os valores sao validos
 * atribui true ou false dependendo do resultado a variavel validador
 */
public boolean ValidarDepesa(String data, String odometro,String valorString ,String tipo) {
    if( data.matches("[0-9]*") && odometro.matches("[0-9]*")&& valorString.matches("[0-9]*") && tipo.matches("[a-zA-Z]*") ){
        

        try {
            telaDespesa.pegarValorDespesa();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setValidador(true);
        float valorfloat = Float.parseFloat(valorString);
        despesafinal = telaDespesa.getValorcalc() +valorfloat;
        setDespesaF(despesafinal);
        
        
    }
    else{

        JOptionPane.showMessageDialog(null, "Digite Valores Validos");
        setValidador(false);
    }
    return validador;
}
/**
 * Retorna o valor da varivel valorcalc
 */
public float getcalc() {
    return valorcalc;
}
}
