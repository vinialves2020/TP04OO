package TP04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Carro {
    private String apelidoVeiculo;
    private String marca;
    private String modelo;
    private String odomentro;
    private boolean validador = false;
    private boolean valiodometro = false;
    private static String nomeCarro;
    static String valorodometro;
    static Usuario usuario= new Usuario();
    static String TempNome ="";
    static String TempMarca ="";
    static String TempModelo ="";
    static String Tempodometro ="";
    static String Temp ="";
    static float Tempodo;
    static ArrayList<String> infocarros = new ArrayList<>(20);
    private static Scanner y;
    private static int contador;
public Carro() {
}


/**
 * @return  Retorna o valor de nomeCarro
 */
public static String getNomeCarro() {
    return nomeCarro;
}


/** 
 * Atribui valor a variavel nomeCarro
 */
public static void setNomeCarro(String nomeCarro) {
    Carro.nomeCarro = nomeCarro;
}
public static void setValorodometro(String valorodometro) {
    Carro. valorodometro =  valorodometro;
}


/** 
 *@return  Retorna o valor de contador
 */
public static int getContador() {
    return contador;
}


/** 
 *@return  Atribui valor a variavel contador
 */
public static void setContador(int contador) {
    Carro.contador = contador;
}



/** 
 * @return Retorno o valor de odometro
 */
public String getOdomentro() {
    return valorodometro;
}


/** 
 * Atribui valor a variavel odometro
 */
public void setOdomentro(String odomentro) {
    this.odomentro = odomentro;
}


/** 
 *@return  Retorno o valor de modelo
 */
public String getModelo() {
    return modelo;
}


/** 
 *Atribui valor a variavel modelo
 */
public void setModelo(String modelo) {
    this.modelo = modelo;
}


/** 
 *@return  Retorno o valor de marca
 */
public String getMarca() {
    return marca;
}


/** 
 * Atribui valor a variavel marca
 */
public void setMarca(String marca) {
    this.marca = marca;
}


/** 
 * @return Retorno o valor de apelidoVeiculo
 */
public String getApelidoVeiculo() {
    return apelidoVeiculo;
}


/** 
 * Atribui valor a variavel apelidoVeiculo
 */
public void setApelidoVeiculo(String apelidoVeiculo) {
    this.apelidoVeiculo = apelidoVeiculo;
}

/**
 * O método salvarCarros pega os valores das variáveis apelidoVeiculo,marca,modelo,odomentro e armazena em um txt
 */
public void salvarCarros(){
    String nomeUsuario = usuario.getUsuarioString();
    FileWriter VW = null;
    try {
        VW = new FileWriter("Usuarios/"+nomeUsuario+"/carros.txt",true);
        VW.write(apelidoVeiculo+","+marca+","+modelo+","+odomentro+"\n");
        VW.close();
    } catch (IOException e) {

    }
}
/**
 * O método ContarCarros buscar no txt que contem as informações dos carros
 * ,conta quantos carros tem e atribui o valor a um contador
 */
    public static void ContarCarros(){

        try {
            y = new Scanner(new File("Usuarios/"+usuario.getUsuarioString()+"/carros.txt"));
            y.useDelimiter("[\n]");
    
            while(y.hasNext())
            {
                TempNome= y.next();
                setContador(getContador() +1);   
            }
            y.close();
    
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
        
      
}

/** 
 * O método pegarNomeCarro busca no txt que contem o nome dos carros e atribui a variavel nomeCarro 
 * usando um FileReader
 */
public void pegarNomeCarro() throws IOException{
    try {
        StringBuilder content = new StringBuilder();
        FileReader leitor= new FileReader("Usuarios/"+usuario.getUsuarioString()+"/Nomecarro.txt");
        int nextChar;
    while ((nextChar = leitor.read()) != -1) {
    content.append((char) nextChar);
    }
    setNomeCarro(String.valueOf(content));
        
        leitor.close();
        
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}

/** 
 * O método ValidarCarro recebe nome,marca,modelo e odometro,verifica se os valores são validos
 * atribui true ou false dependendo do resultado a variavel validador
 */
public void ValidarCarro(String nome, String marca,String modelo ,String odometro) {
    if( nome.matches("[a-zA-Z]*") && marca.matches("[a-zA-Z]*") && modelo.matches("[a-zA-Z]*") &&odometro.matches("[0-9]*") ){
        
        setValidador(true);  
        setApelidoVeiculo(nome);
        setMarca(marca);
        setModelo(modelo);
        setOdomentro(odometro);
    }
    else{

        JOptionPane.showMessageDialog(null, "Digite Valores Validos");
        setValidador(false);
    }
    System.out.println(validador);
}
public void salvarOdometro(String odometrovalor){
    try {
        pegarvalorodometro();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    float valor = Float.parseFloat(odometrovalor);
    if (valor  > Tempodo ){
    System.out.println(valor + "--"+ Tempodo);
    setValidador(true);
    FileWriter VW = null;
    try {
        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/Odometrocarro.txt");
        VW.write(odometrovalor);
        VW.close();
    } catch (IOException e) {

    }
}
    else {
        setValidador(false);
        JOptionPane.showMessageDialog(null, "Valor do Odometro Invalido");
    }
}
public void pegarvalorodometro() throws IOException{
    try {
        StringBuilder content = new StringBuilder();
        FileReader leitor= new FileReader("Usuarios/"+usuario.getUsuarioString()+"/Odometrocarro.txt");
        int nextChar;
    while ((nextChar = leitor.read()) != -1) {
    content.append((char) nextChar);
    }
    
    setValorodometro(String.valueOf(content));
    Tempodo = Float.parseFloat(valorodometro);
        
        leitor.close();
        
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}

/** 
 * Atribui valor a variavel validador
 */
private void setValidador(boolean validador) {
    this.validador = validador;
}


/** 
 * Retorna o valor de validador(true ou false)
 */
public boolean getValidador() {
    return validador;
}
public boolean getValiodometro() {
    return valiodometro;
}
}
