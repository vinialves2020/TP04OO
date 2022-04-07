package TP04;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TelaCarros {
    private static Scanner x;
    static TelaLogin telaLogin= new TelaLogin();
    static TelaPrincipal telaPrincipal = new TelaPrincipal();
    static TelaCadastro telaCadastro = new TelaCadastro();
    static TelaDespesa telaDespesa= new TelaDespesa();
    static TelaManutencao telaManutencao= new TelaManutencao();
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
    static boolean verficador ;
    static int contador = 0;
    static String[] Info;
    static String TempNome ="";
    static String TempMarca ="";
    static String TempModelo ="";
    static String Tempodometro ="";
    static String Temp ="";
    static JPanel panel = new JPanel();
    static ArrayList<String> infocarros = new ArrayList<>(20);
    Font fonte = new Font("Courier New",Font.BOLD,20);
    private static String nomeCarro;
    static Font fonte1 = new Font("Courier New",Font.PLAIN,15);
    
/**
 * O metodo CriaTelaCarros cria um frame que envia as informacoes para o acesso ou criacao de um carro
 */
    public void CriarTelaCarros(){
        verificarCarros();
        Carro.ContarCarros();
        
        String nomeUsuario = usuario.getUsuarioString();
        Color centro=new Color(0xcfd8fa);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 800));
    
        panel.setBackground(centro);
        panel.setLayout(null);

        JButton  Carro1 = new JButton  ();
        JButton  Carro2 = new JButton ();
        JButton  Carro3 = new JButton ();
        JLabel nomeusuario = new JLabel("Carros de "+nomeUsuario);
        nomeusuario.setBounds(20, 20, 250, 30);
        nomeusuario.setFont(fonte);
        panel.add(nomeusuario);

        JButton cadastrarcarros = new JButton("Cadastrar Carros");
        cadastrarcarros.setBounds(270, 20, 250, 30);
        cadastrarcarros.setFocusable(false);
        cadastrarcarros.setFont(fonte1);
        panel.add(cadastrarcarros);

        switch(Carro.getContador()){
            case 1:
            Carro1.setBounds(20, 100, 250, 30);
            Carro1.setText(infocarros.get(0)+"/"+infocarros.get(1)+"/"+infocarros.get(2));
            Carro1.setFont(fonte1);
            panel.add(Carro1);
            System.out.println("1");
            break;
            case 2:
            Carro1.setBounds(20, 100, 250, 30);
            Carro1.setFont(fonte1);
            Carro1.setText(infocarros.get(0)+"/"+infocarros.get(1)+"/"+infocarros.get(2));
            panel.add(Carro1);
            Carro2.setBounds(20, 150, 250, 30);
            Carro2.setFont(fonte1);
            Carro2.setText(infocarros.get(4)+"/"+infocarros.get(5)+"/"+infocarros.get(6));
            panel.add(Carro2);
            System.out.println("2");
            break;
            case 3:
            Carro1.setBounds(20, 100, 250, 30);
            Carro1.setFont(fonte1);
            Carro1.setText(infocarros.get(0)+"/"+infocarros.get(1)+"/"+infocarros.get(2));
            panel.add(Carro1);
            Carro2.setBounds(20, 150, 250, 30);
            Carro2.setFont(fonte1);
            Carro2.setText(infocarros.get(4)+"/"+infocarros.get(5)+"/"+infocarros.get(6));
            panel.add(Carro2);
            Carro3.setBounds(20, 200, 250, 30);
            Carro3.setText(infocarros.get(8)+"/"+infocarros.get(9)+"/"+infocarros.get(10));
            Carro3.setFont(fonte1);
            panel.add(Carro3);
            System.out.println("3");
            
            break;
        }
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        

        cadastrarcarros.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
                {   
                
                frame.dispose();
                telaCadastro.criarTelacadastroCarros();
                    
            }});
                
            
            Carro1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                 {   
                    nomeCarro=infocarros.get(0);
                    salvarNomeCarros();
                    frame.dispose();
                    telaPrincipal.criarTelaPrincipal();
                    
                                    
                    
                }});
            Carro2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                    {   
                    
                    nomeCarro=infocarros.get(4);
                    salvarNomeCarros();
                    frame.dispose();
                    telaPrincipal.criarTelaPrincipal();
                    
                                       
                        
                 }});  
         Carro3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                    {
                    
                    nomeCarro=infocarros.get(8);
                    salvarNomeCarros();
                    frame.dispose();
                    telaPrincipal.criarTelaPrincipal();
                                      
                        
                }});  
}
/**
 * O metodo verificarCarros ira pegar valores de nome,marca,modelo,odometro de um text basedo no nome do usuario
 * e atribui-los a um ArrayList
 */
public static void verificarCarros(){

    try {
        File file = new File("Usuarios/"+usuario.getUsuarioString()); 
        if (!file.exists()) {
        file.mkdirs();}
        x = new Scanner(new File("Usuarios/"+usuario.getUsuarioString()+"/carros.txt"));
        x.useDelimiter("[,\n]");

        while(x.hasNext())
        {
            TempNome= x.next();
            TempMarca= x.next();
            TempModelo= x.next();
            Tempodometro= x.next();
            infocarros.add(TempNome);
            infocarros.add(TempMarca);
            infocarros.add(TempModelo);
            infocarros.add(Tempodometro);
            
            
        }
        x.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    /**
     * O metodo salvarNomeCarros salva em um txt o nome no carro para a organizacao do projeto
     */
public void salvarNomeCarros(){
    FileWriter VW = null;
    try {
        VW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/Nomecarro.txt");
        VW.write(nomeCarro);
        VW.close();
    } catch (IOException e) {

    }
}

}

