package TP04;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;


public class TelaDespesa extends TelaPrincipal {
   
    static TelaPrincipal telaPrincipal= new TelaPrincipal();
    static TelaLogin telaLogin= new TelaLogin();
    static TelaCarros telaCarros= new TelaCarros();
    static Usuario usuario= new Usuario();
    static Carro carro= new Carro();
    static Despesa despesa= new Despesa();
    float valorfloat =0;
    float valorcalc = 0;
    String valorfinal ;
    String dataString;
    String odomeString;
    String tipoString;
    float despesafinal = 0;
    static JFormattedTextField dataTextField = new JFormattedTextField();
    ArrayList<String> despesas = new ArrayList<>();
    Color fundo=new Color(0x0a1852);

    ArrayList<String> a = new ArrayList<>();
   

    /**
     * O metodo criarTeladespesa cria um frame que envia as informacoes para a criação de uma despesa
     */
    public void criarTeladespesa(){
        try {
            carros.pegarNomeCarro();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
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
        odometrolabel.setBounds(160,300,150,30);
        odometrolabel.setFont(fonte);
        odometrolabel.setForeground(Color.WHITE);
        JLabel tipodespLabel= new JLabel("Tipo:");
        tipodespLabel.setBounds(160,350,150,30);
        tipodespLabel.setFont(fonte);
        tipodespLabel.setForeground(Color.WHITE);
        JLabel valordespLabel= new JLabel("Valor:");
        valordespLabel.setBounds(160,400,150,30);
        valordespLabel.setFont(fonte);
        valordespLabel.setForeground(Color.WHITE);

        
        dataTextField.setBounds(270,250,200,30);
        dataTextField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
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
                    //float valorfloat = Float.parseFloat(valorString);
                    //valorcalc = valorcalc + valorfloat ;
                    despesa.ValidarDepesa(dataString, odomeString, valorString, tipoString);
                    

                    if (despesa.getValidador() == true){
                        
                        telaDespesa.a.add(dataString);
                        telaDespesa.a.add(odomeString);
                        telaDespesa.a.add(tipoString);
                        telaDespesa.a.add(Float.toString(despesa.getcalc()));       
                        telaDespesa.despesas.add(dataString);
                        telaDespesa.despesas.add(odomeString);
                        telaDespesa.despesas.add(tipoString);
                        telaDespesa.despesas.add(Float.toString(despesa.getcalc()));
                        salvarDespesa();
                        
                    }
                    despesa.salvarValorDespesa();
                    
                    dataTextField.setText("");
                    odometroTextField.setText("");
                    tipodespTextField.setText("");
                    valordespTextField.setText("");
                    frame.dispose();
                    telaPrincipal.criarTelaPrincipal();
                    
                    
            }});
            voltarButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                 {   
                    
                    frame.toBack();
                    frame.setVisible(false);
                    criarTelaPrincipal();                    
                    
                }});        

              

    }


    /**
     * O metodo pegarValorDespesa busca em em text especifico o valor referente ao abasticimento
     * e atribui a variavel despesafinal
     */
    public void pegarValorDespesa() throws IOException{
        try {
            carros.pegarNomeCarro();
            StringBuilder content = new StringBuilder();
            FileReader leitor= new FileReader("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"DespesaValor.txt");
            int nextChar;
        while ((nextChar = leitor.read()) != -1) {
        content.append((char) nextChar);
        }
        despesafinal = Float.parseFloat(String.valueOf(content));
            
            leitor.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    /**
     * O metodo salvarDespesa pega as informacoes coletadas pela TP04.TelaDespesa salva em um txt
     * com o nome baseado no nome de usuario e no nome do carro usando um PrintWriter
     */
    public void salvarDespesa() {
		FileWriter FW = null;
        PrintWriter PW = null;

		try {
            carros.pegarNomeCarro();
            File file = new File("Usuarios/"+usuario.getUsuarioString());  

                if (!file.exists()) {
                file.mkdirs();}
			FW = new FileWriter("Usuarios/"+usuario.getUsuarioString()+"/"+Carro.getNomeCarro()+"DespesaInfos.txt",true);
			PW= new PrintWriter(FW);
            
			for (String a : despesas) {
				PW.write(a.toString());
				PW.write("\n");
			}
            
            PW.write("<------------------------->");
            PW.write("\n");
            a.clear();
            despesas.clear();
			PW.close();
		} catch (IOException e) {

		}
	}


    /**
     * Retorna o valor da variavel despesafinal;
     */
    public float getValorcalc() {
        return despesafinal;
    }
    /**
     * Retorna o valor da variavel valorfinal
     */
    public String getvalorString() {
		return valorfinal;
	}

      
}
