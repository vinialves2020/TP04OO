package TP04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Abastecimento extends Padronizacao implements FuncoesGerais{
    static Usuario usuario= new Usuario();
    static Carro carro =new Carro();
    static TelaAbastecimento telaAbastecimento= new TelaAbastecimento();
    private float abastfinal;
    private boolean validador = false;
    private float valorcalc;

public Abastecimento(){

}
/** 
 * Atribui valor a variavel abastfinal
 */
public void setAbastF(float abastfinal) {
    this.abastfinal = abastfinal;
}
/** 
* O metodo salvarValorAbastecimento pega o valor da variavel abastfinal e salva em um txt especifico
*/
public void salvarValorAbastecimento(){
    FileWriter VW = null;
    try {
        File file = new File("Usuarios/"+usuario.getUsuarioString()); 
        if (!file.exists()) {
        file.mkdirs();}
        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"AbastecimentoValor.txt");
        VW.write("0"+Float.toString(abastfinal));
        VW.close();
    } catch (IOException e) {

    }
}
/** 
* O metodo apagarAbastecimento apaga todos os valores de abastecimentos existes de um carro
 */
public void apagarAbastecimento(){
    FileWriter VW = null;
    FileWriter VW1 = null;
    
    try {
        carro.pegarNomeCarro();
        File file = new File("Usuarios/"+usuario.getUsuarioString());  

            if (!file.exists()) {
            file.mkdirs();}

        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"AbastecimentoValor.txt");
        VW1 = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"AbastecimentoInfos.txt");
        VW.write("00");
        VW1.write("");
        VW.close();
    } catch (IOException e) {

    }
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
* O metodo ValidarAbastecimento recebe data,odometro,valorString e tipo,verifica se os valores sao validos
 * atribui true ou false dependendo do resultado a variavel validador
 */
public boolean ValidarAbastecimento(String data, String odometro,String valorString ,String tipo) {
        if( data.matches("[0-9]*") && odometro.matches("[0-9]*")&& valorString.matches("[0-9]*") && tipo.matches("[a-zA-Z]*") ){
            try {
                telaAbastecimento.pegarValorAbastecimento();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            setValidador(true);
            float valorfloat = Float.parseFloat(valorString);
            abastfinal = telaAbastecimento.getValorcalcA()+valorfloat;
            setAbastF(abastfinal);
        
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
