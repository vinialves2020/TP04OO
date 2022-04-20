package TP04;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;


public class TelaManutencao extends TelaPrincipal {
    
    
    static TelaPrincipal telaPrincipal= new TelaPrincipal();
    static TelaLogin telaLogin= new TelaLogin();
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
    float valorfloatM =0;
    float valorcalcM = 0;
    String valorfinalM ;
    float manufinal = 0;
    Color fundo=new Color(0x0a1852);
    ArrayList<String> manutencoes = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();

    /**
     * Retorna o valor da variavel valorfinalM;
     */
    public String getvalorStringM() {
		return valorfinalM;
	}


    /**
     * O metodo criarTelaManutencao cria um frame que envia as informacoes para a criação de uma manutencao
     */
    public void criarTelaManutencao(){
        
        try {
            carros.pegarNomeCarro();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        Font fonte = new Font("Courier New", Font.PLAIN, 20);
        JFrame frame = new JFrame();
        JPanel cadastroPanel =new JPanel();
        cadastroPanel.setSize(new Dimension(600, 800));
        cadastroPanel.setBackground(fundo);
        cadastroPanel.setLayout(null);

        

        JLabel dataLabel= new JLabel("Data:");
        dataLabel.setForeground(Color.WHITE);
        dataLabel.setBounds(160,250,150,30);
        dataLabel.setFont(fonte);
        JLabel odometrolabel =new JLabel("Odometro:");
        odometrolabel.setForeground(Color.WHITE);
        odometrolabel.setBounds(160,300,150,30);
        odometrolabel.setFont(fonte);
        JLabel tipodespLabel= new JLabel("Tipo:");
        tipodespLabel.setForeground(Color.WHITE);
        tipodespLabel.setBounds(160,350,150,30);
        tipodespLabel.setFont(fonte);
        JLabel valordespLabel= new JLabel("Valor:");
        valordespLabel.setForeground(Color.WHITE);
        valordespLabel.setBounds(160,400,150,30);
        valordespLabel.setFont(fonte);

        JTextField dataTextField = new JTextField(20);
        dataTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        dataTextField.setBounds(270,250,200,30);
        JTextField odometroTextField = new JTextField(20);
        odometroTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        odometroTextField.setBounds(270,300,200,30);
        JTextField tipodespTextField = new JTextField(20);
        tipodespTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        tipodespTextField.setBounds(270,350,200,30);
        JTextField valordespTextField = new JTextField(20);
        valordespTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        valordespTextField.setBounds(270,400,200,30);

        JButton cadastrarbButton = new JButton("Cadastrar");
        cadastrarbButton.setBounds(140,480,160,30);
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBounds(320,480,160,30);
     
        
        cadastroPanel.add(cadastrarbButton);
        cadastroPanel.add(voltarButton);
        cadastroPanel.add(dataLabel);
        cadastroPanel.add(odometrolabel);
        cadastroPanel.add(tipodespLabel);
        cadastroPanel.add(valordespLabel);
        cadastroPanel.add(dataTextField);
        cadastroPanel.add(odometroTextField);
        cadastroPanel.add(tipodespTextField);
        cadastroPanel.add(valordespTextField);


        frame.add(cadastroPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 800));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); 

        cadastrarbButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
             {   
                    String dataString = dataTextField.getText();
                    String odomeString = odometroTextField.getText();
                    String tipoString = tipodespTextField.getText();
                    String valorString = valordespTextField.getText();
                    carro.salvarOdometro(odomeString);
                    manutencao.ValidarManutencao(dataString, odomeString, valorString, tipoString);
                    if(manutencao.getValidador()== true && carro.getValiodometro() == true){
                        
                        a.add(dataString);
                        a.add(odomeString);
                        a.add(tipoString);
                        a.add(Float.toString(manutencao.getcalc()));
                        manutencoes.add(dataString);
                        manutencoes.add(odomeString);
                        manutencoes.add(tipoString);
                        manutencoes.add(Float.toString(manutencao.getcalc()));
                        salvarManutencao();
                        carro.salvarOdometro(odomeString);
                        frame.dispose();
                        telaPrincipal.criarTelaPrincipal();

                    }
                    manutencao.salvarValorManutencao();
                    dataTextField.setText("");
                    odometroTextField.setText("");
                    tipodespTextField.setText("");
                    valordespTextField.setText("");
                   
                    
                
            }});
            voltarButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                 {   
                    frame.toBack();
                    frame.setVisible(false);
                    criarTelaPrincipal();
                    frame.dispose();
                }});        

            }
             /**
            * Retorna o valor da variavel manufinal;
            */
            public float getValorcalcM() {
                return manufinal;
            }
            /**
            * Retorna o valor da variavel valorfinalM;
            */
            public String getValorfinalM() {
                return valorfinalM;
            }
            /**
            * O metodo egarValorManutencao busca em em text especifico o valor referente ao abasticimento
            * e atribui a variavel manufinal
            */
            public void pegarValorManutencao() throws IOException{
                try {
                    carros.pegarNomeCarro();
                    StringBuilder content = new StringBuilder();
                    FileReader leitor= new FileReader("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"ManutençõesValor.txt");
                    int nextChar;
                while ((nextChar = leitor.read()) != -1) {
                content.append((char) nextChar);
                }
                manufinal = Float.parseFloat(String.valueOf(content));
                    
                    leitor.close();
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
        
            }
            /**
            * O metodo salvarManutencao pega as informacoes coletadas pela TP04.TelaManutencao salva em um txt
            * com o nome baseado no nome de usuario e no nome do carro usando um PrintWriter
            */
            public void salvarManutencao() {
                FileWriter FW = null;
                PrintWriter PW = null;
        
                try {
                    File file = new File("Usuarios/"+usuario.getUsuarioString());  

                    if (!file.exists()) {
                    file.mkdirs();}
                    FW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"ManutençõesInfos.txt",true);
                    PW= new PrintWriter(FW);
                    
                    for (String a : manutencoes) {
                        PW.write(a.toString());
                        PW.write("\n");
                    }
                    
                    PW.write("<------------------------->");
                    PW.write("\n");
                    a.clear();
                    manutencoes.clear();
                    PW.close();
                } catch (IOException e) {
        
                }
            }

           
           
        
}
