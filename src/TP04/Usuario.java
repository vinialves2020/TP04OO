package TP04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {
    private static Scanner x;
    private String Nome;
    private char[] Senha;
    private static String TempNome ="";
    private static String TempSenha ="";
    static TelaLogin telaLogin = new TelaLogin();
    static TelaCarros telaCarros = new TelaCarros();
    static boolean validador = false;
    
public Usuario(){
}


/** 
 * @return retorna o valor de Senha para o usuario
 */
public char[] getSenha() {
    return Senha;
}

/** 
 * Atribui valor a variavel Senha
 */
public void setSenha(char[] Senha) {
    this.Senha = Senha;
}

public void setValidador(Boolean validador) {
    Usuario.validador = validador;
}

/** 
 * @return retorna o valor de Nome para o usuario
 */
public String getNome() {
    return Nome;
}

/** 
 *  Atribui valor a variavel nome
 */
public void setNome(String nome) {
    this.Nome = nome;
}
/**
 * O metodo SalvarUsuarios usando um FileWriter salva as informacoes do usuario em um arquivo txt
 */
public void salvarUsuarios(){
    FileWriter VW = null;
    try {
        VW = new FileWriter("Usuarios.txt",true);
        VW.write(Nome);
        VW.write(",");
        VW.write(Senha);
        VW.write("\n");
        VW.close();
    } catch (IOException e) {

    }
}

/** 
 * O metodo verificarlogin recebe os valores de usuario e senha e verificao se esses valores batem com
 * os valores presentes no Usuarios.txt usando um Scanner para a verificaçao
 */
public static Boolean verificarlogin(String usuario, String senha){

   
    try {
        x = new Scanner(new File("Usuarios.txt"));
        x.useDelimiter("[,\n]");

        while(x.hasNext() && !validador)
        {
            TempNome= x.next();
            TempSenha= x.next();
            
            if(TempNome.trim().equals(usuario.trim()) && TempSenha.trim().equals(senha.trim())){

                telaCarros.CriarTelaCarros();
                validador= true;
                if (validador = true){
                    TelaLogin.frame.dispose();
                }
            }
            else{
                TelaLogin.userText.setText("");
                TelaLogin.passwordText.setText("");
            }
        }
        x.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return validador;
}

/** 
 * Retorna o valor de Nome do usuarios para organizacao do projeto
 */
public String getUsuarioString() {
    return TempNome;
}
}
