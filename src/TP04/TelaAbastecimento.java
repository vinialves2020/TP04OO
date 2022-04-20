package TP04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TelaAbastecimento extends TelaPrincipal {
    static TelaPrincipal telaPrincipal= new TelaPrincipal();
    static TelaLogin telaLogin= new TelaLogin();
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
    static Abastecimento abastecimento = new Abastecimento();

    float valorfloatA =0;
    float valorcalcA = 0;
    String valorfinalA ;
    float Abastfinal = 0;
    Color fundo=new Color(0x0a1852);
    ArrayList<String> abastecimentos = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();
    
    /**
     * O metodo criarTelaAbastecimento cria um frame que envia as informacoes para a criação de um abastecimento
     */
    public void criarTelaAbastecimento(){
        try {
            carro.pegarNomeCarro();
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
        dataLabel.setBounds(160,250,150,30);
        dataLabel.setForeground(Color.WHITE);
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
                    abastecimento.ValidarAbastecimento(dataString, odomeString, valorString, tipoString);
                    

                    if (abastecimento.getValidador() == true && carro.getValiodometro() == true){
                        
                    
                        a.add(dataString);
                        a.add(odomeString);
                        a.add(tipoString);
                        a.add(Float.toString(abastecimento.getcalc()));
                        abastecimentos.add(dataString);
                        abastecimentos.add(odomeString);
                        abastecimentos.add(tipoString);
                        abastecimentos.add(Float.toString(abastecimento.getcalc()));
                        carro.salvarOdometro(odomeString);
                        frame.dispose();
                        telaPrincipal.criarTelaPrincipal();
                    }
                    
                    abastecimento.salvarValorAbastecimento();
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
             * Retorna o valor da variavel Abastfinal
             */
            public float getValorcalcA() {
                return Abastfinal;
            }
            
            /** 
             * Retorna o valor da variavel valorfinalA
             */
            public String getValorfinalA() {
                return valorfinalA;
            }
            /** 
            * Retorna o valor da variavel valorfinalA
            */
            public String getvalorStringA() {
		    return valorfinalA;
	        }
            
            /** 
             * O metodo pegarValorAbastecimento busca em em text especifico o valor referente ao abasticimento
             * e atribui a variavel Abastfinal
             */
            public void pegarValorAbastecimento() throws IOException{
                try {
                    carros.pegarNomeCarro();
                    StringBuilder content = new StringBuilder();
                    FileReader leitor= new FileReader("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"AbastecimentoValor.txt");
                    int nextChar;
                while ((nextChar = leitor.read()) != -1) {
                content.append((char) nextChar);
                }
                Abastfinal = Float.parseFloat(String.valueOf(content));
                    
                    leitor.close();
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
        
            }
            /** 
             * O metodo salvarAbastecimento pega as informacoes coletadas pela TP04.TelaAbastecimento e salva em um txt
             * com o nome baseado no nome de usuario e no nome do carro usando um PrintWriter
             */
            public void salvarAbastecimento() {
                FileWriter FW = null;
                PrintWriter PW = null;
        
                try {
                    File file = new File("Usuarios/"+usuario.getUsuarioString());  
                    if (!file.exists()) {
                    file.mkdirs();}
                    FW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"AbastecimentoInfos.txt",true);
                    PW= new PrintWriter(FW);
                    
                    for (String a : abastecimentos) {
                        PW.write(a.toString());
                        PW.write("\n");
                    }
                    
                    PW.write("<------------------------->");
                    PW.write("\n");
                    a.clear();
                    abastecimentos.clear();
                    PW.close();
                } catch (IOException e) {
        
                }
            }
            
}
