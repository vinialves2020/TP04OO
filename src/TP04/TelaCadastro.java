package TP04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCadastro {
    static TelaCarros telaCarros= new TelaCarros();
    static TelaLogin telaLogin= new TelaLogin();
    static JTextField nomectTextField = new JTextField(20);
    static JTextField marcTextField = new JTextField(20);
    static JTextField modeloTextField = new JTextField(20);
    static JTextField odometroTextField = new JTextField(20);
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
/**
 * O metodo criarTelacadastroCarros cria um frame que envia as informacoes para a criacao de um carro
 */
    public void criarTelacadastroCarros(){
        
        Color fundo=new Color(0x0a1852);
        Font fonte = new Font("Courier New", Font.PLAIN, 20);
        JFrame frame = new JFrame();
        JPanel cadastroPanel =new JPanel();
        cadastroPanel.setSize(new Dimension(600, 800));
        cadastroPanel.setBackground(fundo);
        cadastroPanel.setLayout(null);

        

        JLabel nomeclLabel= new JLabel("Apelido:");
        nomeclLabel.setForeground(Color.WHITE);
        nomeclLabel.setBounds(160,250,150,30);
        nomeclLabel.setFont(fonte);
        JLabel marcLabel =new JLabel("Marca:");
        marcLabel.setBounds(160,300,150,30);
        marcLabel.setFont(fonte);
        marcLabel.setForeground(Color.WHITE);
        JLabel modelolLabel= new JLabel("Modelo:");
        modelolLabel.setBounds(160,350,150,30);
        modelolLabel.setFont(fonte);
        modelolLabel.setForeground(Color.WHITE);
        JLabel odometrolLabel= new JLabel("Odometro:");
        odometrolLabel.setBounds(160,400,150,30);
        odometrolLabel.setFont(fonte);
        odometrolLabel.setForeground(Color.WHITE);

        
        nomectTextField.setBounds(270,250,200,30);
        nomectTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
       
        marcTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        marcTextField.setBounds(270,300,200,30);
        
        modeloTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        modeloTextField.setBounds(270,350,200,30);
        
        odometroTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        odometroTextField.setBounds(270,400,200,30);

        JButton cadastrarbButton = new JButton("Cadastrar");
        cadastrarbButton.setBounds(140,480,160,30);
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBounds(320,480,160,30);
        
        cadastroPanel.add(cadastrarbButton);
        cadastroPanel.add(voltarButton);
        cadastroPanel.add(nomeclLabel);
        cadastroPanel.add(marcLabel);
        cadastroPanel.add(modelolLabel);
        cadastroPanel.add(odometrolLabel);
        cadastroPanel.add(nomectTextField);
        cadastroPanel.add(marcTextField);
        cadastroPanel.add(modeloTextField);
        cadastroPanel.add(odometroTextField);


        frame.add(cadastroPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 800));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); 
        
        cadastrarbButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
             {   
                String nomeString =nomectTextField.getText();
                String odomeString = odometroTextField.getText();
                String marcasString= marcTextField.getText();
                String modeloString= modeloTextField.getText();

                    carro.ValidarCarro(nomeString, marcasString, modeloString,odomeString);
                    if(carro.getValidador()==true){
                    carro.salvarOdometro(odomeString);
                    carro.salvarCarros();
                }
                
                    
            }});
        voltarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
                {   
                    
                frame.dispose();
                telaCarros.CriarTelaCarros();                    
                    
            }});              

    }
    
    
}
