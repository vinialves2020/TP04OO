package TP04;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.*;

public class TelaPrincipal extends JFrame{
    static TelaDespesa telaDespesa= new TelaDespesa();
    static TelaAbastecimento telaaAbastecimento= new TelaAbastecimento();
    static TelaManutencao telaManutencao= new TelaManutencao();
    static TelaCarros telaCarros= new TelaCarros();
    static TelaLogin telaLogin= new TelaLogin();
    static Usuario usuario= new Usuario();
    static Carro carros= new Carro();
    static Despesa despesa= new Despesa();
    static Abastecimento abastecimento= new Abastecimento();
    static Manutencao manutencao= new Manutencao();

    String valorTgeral;
    float valorTgeralfloat;
    String valorTGdia ;
    String valorTdespesa ;
    String valorTddia ;
    float odometrofloat;
    String odometroF;
    String odometroD;
    String odometroA;
    String odometroM;
    String valorTabast ;
    String valorTAdia ;
    String valorTmanu ;
    String valorTMdia;
    Color fundo=new Color(0x0a1852);
    Color centro=new Color(0xcfd8fa);
     

    /**
     * O metodo setarvalores pega as valores de variaveis importantes de outra classes
     * e atribui em variaveis respectivas nesse classe
     */
    public void setarvalores(){
        
        try {
            carros.pegarNomeCarro();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            telaDespesa.pegarValorDespesa();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            telaaAbastecimento.pegarValorAbastecimento();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            telaManutencao.pegarValorManutencao();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            carros.pegarvalorodometro();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        valorTgeralfloat= telaDespesa.getValorcalc() + telaManutencao.getValorcalcM() + telaaAbastecimento.getValorcalcA();
        valorTgeral = Float.toString(valorTgeralfloat);
        valorTGdia= new DecimalFormat(".#").format(valorTgeralfloat/30);
        setValorTdespesa( Float.toString(telaDespesa.despesafinal));
        setValorTddia(new DecimalFormat(".#").format(telaDespesa.despesafinal/30));
        setValorTabast(Float.toString(telaaAbastecimento.Abastfinal));
        setValorTAdia(new DecimalFormat(".#").format(telaaAbastecimento.Abastfinal/30));
        setValorTmanu(Float.toString(telaManutencao.manufinal));
        setValorTMdia(new DecimalFormat(".#").format(telaManutencao.manufinal/30));
        odometrofloat = Float.parseFloat(carros.getOdomentro());
        odometroD = ( new DecimalFormat(".#").format(telaDespesa.despesafinal/odometrofloat));
        odometroA = ( new DecimalFormat(".#").format(telaaAbastecimento.Abastfinal/odometrofloat));
        odometroM = ( new DecimalFormat(".#").format(telaManutencao.manufinal/odometrofloat));
        odometroF = (new DecimalFormat(".#").format(valorTgeralfloat/odometrofloat));
        
        
    }
    /**
     * O método criarTelaPrincipal cria um frame que nele contem as principais informações da aplicação, 
     * apagar e atribuir valores para as classes despesa,manutençao e abastecimento
     */
    public void criarTelaPrincipal(){
       
        JFrame frame = new JFrame();

        Font fonte = new Font("Courier New", Font.BOLD, 25);
        Font fonte1 = new Font("Courier New", Font.PLAIN, 20);
        setarvalores();
        
        System.out.println(Carro.getNomeCarro());
        ImageIcon geralIcon = new ImageIcon("imagens/relatorio.png");
        ImageIcon despesaIcon = new ImageIcon("imagens/verificar.png");
        ImageIcon abastIcon = new ImageIcon("imagens/gasolina.png");
        ImageIcon manuiIcon = new ImageIcon("imagens/manutençao.png");
        ImageIcon geralIcon1 = new ImageIcon("imagens/relatorio1.png");
        ImageIcon despesaIcon1 = new ImageIcon("imagens/verificar1.png");
        ImageIcon abastIcon1 = new ImageIcon("imagens/gasolina1.png");
        ImageIcon manuiIcon1 = new ImageIcon("imagens/manutençao1.png");
        
        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(Color.YELLOW);

        JPanel panelesquerda = new JPanel();
        panelesquerda.setLayout(new FlowLayout(4,4,4));
        panelesquerda.setBackground(fundo);

        JPanel panelbotoes = new JPanel();
        panelbotoes.setLayout(new GridLayout(4,1,150,90));
        panelbotoes.setBackground(fundo);

        JButton geral = new JButton();
        geral.setPreferredSize(new Dimension(50, 120));
        geral.setIcon(geralIcon1);
        geral.setOpaque(false);
        geral.setContentAreaFilled(false);
        geral.setBorderPainted(false);
        geral.setFocusable(false);
        

        JButton abastecimento = new JButton();
        abastecimento.setPreferredSize(new Dimension(50, 50));
        abastecimento.setIcon(abastIcon);
        abastecimento.setOpaque(false);
        abastecimento.setContentAreaFilled(false);
        abastecimento.setBorderPainted(false);
        abastecimento.setFocusable(false);

        JButton despesa = new JButton();
        despesa.setPreferredSize(new Dimension(50, 50));
        despesa.setIcon(despesaIcon);
        despesa.setOpaque(false);
        despesa.setContentAreaFilled(false);
        despesa.setBorderPainted(false);
        despesa.setFocusable(false);

        JButton manutencao = new JButton();
        manutencao.setPreferredSize(new Dimension(50, 50));
        manutencao.setIcon(manuiIcon);
        manutencao.setOpaque(false);
        manutencao.setContentAreaFilled(false);
        manutencao.setBorderPainted(false);
        manutencao.setFocusable(false);

        panelbotoes.add(geral);
        panelbotoes.add(despesa);
        panelbotoes.add(abastecimento);
        panelbotoes.add(manutencao);

        JPanel panelmeio =new JPanel();
        panelmeio.setLayout(new BorderLayout());
        panelmeio.setBackground(centro);

        JPanel panelgera =new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        panelgera.setLayout(new GridBagLayout());
        panelgera.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        panelgera.setBackground(centro.darker());
        
        JPanel paneldespesa =new JPanel();
        paneldespesa.setLayout(new GridBagLayout());
        paneldespesa.setBackground(centro.darker());
        paneldespesa.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
       
        JLabel custLabelD= new JLabel("Despesas ",JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx= 60;
        gbc.ipady= 30;
        custLabelD.setFont(fonte);
        paneldespesa.add(custLabelD,gbc);
        JLabel totLabelD= new JLabel("Total",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        totLabelD.setFont(fonte1);
        paneldespesa.add(totLabelD,gbc);
        JLabel diaLabeD= new JLabel("Por dia",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.insets = new Insets(0,20,0,50); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        diaLabeD.setFont(fonte1);
        paneldespesa.add(diaLabeD,gbc);
        JLabel kmLabeD= new JLabel("Por Km",JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 1;
        kmLabeD.setFont(fonte1);
        paneldespesa.add(kmLabeD,gbc);
        JLabel valorTD= new JLabel("R$:"+valorTdespesa,JLabel.CENTER);
        gbc.insets = new Insets(0,0,0,0); 
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        valorTD.setFont(fonte1);
        paneldespesa.add(valorTD,gbc);
        JLabel valorDD= new JLabel("R$:"+valorTddia,JLabel.CENTER);
        gbc.insets = new Insets(0,20,0,50); 
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        valorDD.setFont(fonte1);
        paneldespesa.add(valorDD,gbc);
        JLabel valorkmD= new JLabel("R$:"+odometroD,JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        valorkmD.setFont(fonte1);
        paneldespesa.add(valorkmD,gbc);
        
        JButton despesaButton = new JButton("Cadastrar Despesa");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(40,0,0,0);  
        paneldespesa.add(despesaButton,gbc);
        gbc.insets = new Insets(0,0,0,0);

        JButton apagardespesa = new JButton("Apagar Despesa");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(20,0,0,0);  
        paneldespesa.add(apagardespesa,gbc);
        gbc.insets = new Insets(0,0,0,0);


        
        JPanel panelabastecimento =new JPanel();
        panelabastecimento.setLayout(new GridBagLayout());
        panelabastecimento.setBackground(centro.darker());
        panelabastecimento.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        
        JLabel custLabelA= new JLabel("Abastecimentos",JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx= 30;
        gbc.ipady= 30;
        custLabelA.setFont(fonte);
        panelabastecimento.add(custLabelA,gbc);
        JLabel totLabelA= new JLabel("Total",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        totLabelA.setFont(fonte1);
        panelabastecimento.add(totLabelA,gbc);
        JLabel diaLabelA= new JLabel("Por dia",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,20,0,50); 
        diaLabelA.setFont(fonte1);
        panelabastecimento.add(diaLabelA,gbc);
        JLabel kmLabelA= new JLabel("Por Km",JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 1;
        kmLabelA.setFont(fonte1);
        panelabastecimento.add(kmLabelA,gbc);
        JLabel valorTA= new JLabel("R$:"+valorTabast,JLabel.CENTER);
        gbc.insets = new Insets(0,0,0,0); 
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        valorTA.setFont(fonte1);
        panelabastecimento.add(valorTA,gbc);
        JLabel valorDA= new JLabel("R$:"+valorTAdia,JLabel.CENTER);
        gbc.insets = new Insets(0,20,0,50); 
        gbc.gridx = 1;
        gbc.gridy = 2;
        valorDA.setFont(fonte1);
        panelabastecimento.add(valorDA,gbc);
        JLabel valorkmA= new JLabel("R$:"+odometroA,JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 2;
        valorkmA.setFont(fonte1);
        panelabastecimento.add(valorkmA,gbc);
        JButton abasteciButton = new JButton("Cadastrar Abastecimento");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(40,0,0,0);  
        panelabastecimento.add(abasteciButton,gbc);
        gbc.insets = new Insets(0,0,0,0);
        JButton apagarAbastec = new JButton("Apagar Abastecimento");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(20,0,0,0);  
        panelabastecimento.add(apagarAbastec,gbc);
        gbc.insets = new Insets(0,0,0,0);
        
        JPanel panelmanu =new JPanel();
        panelmanu.setLayout(new GridBagLayout());
        panelmanu.setBackground(centro.darker());
        panelmanu.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
        JLabel custLabelM= new JLabel("Manutenções",JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx= 30;
        gbc.ipady= 30;
        custLabelM.setFont(fonte);
        panelmanu.add(custLabelM,gbc);
        JLabel totLabelM = new JLabel("Total",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        totLabelM.setFont(fonte1);
        panelmanu.add(totLabelM,gbc);
        JLabel diaLabelM= new JLabel("Por dia",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.insets = new Insets(0,20,0,50); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        diaLabelM.setFont(fonte1);
        panelmanu.add(diaLabelM,gbc);
        JLabel kmLabelM= new JLabel("Por Km",JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 1;
        kmLabelM.setFont(fonte1);
        panelmanu.add(kmLabelM,gbc);
        JLabel valorTM= new JLabel("R$:"+valorTmanu,JLabel.CENTER);
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        valorTM.setFont(fonte1);
        panelmanu.add(valorTM,gbc);
        JLabel valorDM= new JLabel("R$:"+valorTMdia,JLabel.CENTER);
        gbc.insets = new Insets(0,20,0,50);
        gbc.gridx = 1;
        gbc.gridy = 2;
        valorDM.setFont(fonte1);
        panelmanu.add(valorDM,gbc);
        JLabel valorkmM= new JLabel("R$:"+odometroM,JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 2;
        valorkmM.setFont(fonte1);
        panelmanu.add(valorkmM,gbc);
        JButton manuButton = new JButton("Cadastrar Manutenção");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(40,0,0,0);  
        panelmanu.add(manuButton,gbc);
        gbc.insets = new Insets(0,0,0,0);
        JButton apagarmanutencao = new JButton("Apagar Manutenção");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(20,0,0,0);  
        panelmanu.add(apagarmanutencao,gbc);
        gbc.insets = new Insets(0,0,0,0);

        JLabel custLabel= new JLabel("Relatório",JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx= 30;
        gbc.ipady= 30;
        custLabel.setFont(fonte);
        panelgera.add(custLabel,gbc);
        JLabel totLabel= new JLabel("Total",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        totLabel.setFont(fonte1);
        panelgera.add(totLabel,gbc);
        JLabel diaLabel= new JLabel("Por dia",JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.insets = new Insets(0,20,0,50); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        diaLabel.setFont(fonte1);
        panelgera.add(diaLabel,gbc);
        JLabel kmLabel= new JLabel("Por Km",JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 1;
        kmLabel.setFont(fonte1);
        panelgera.add(kmLabel,gbc);
        JLabel valorT= new JLabel("R$:"+valorTgeral,JLabel.CENTER);
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        valorT.setFont(fonte1);
        panelgera.add(valorT,gbc);
        JLabel valorD= new JLabel("R$:"+valorTGdia,JLabel.CENTER);
        gbc.insets = new Insets(0,20,0,50);
        gbc.gridx = 1;
        gbc.gridy = 2;
        valorD.setFont(fonte1);
        panelgera.add(valorD,gbc);
        JLabel valorkm= new JLabel("R$:"+odometroF,JLabel.CENTER);
        gbc.ipadx= 0;
        gbc.ipady= 0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        valorkm.setFont(fonte1);
        panelgera.add(valorkm,gbc);
        JButton VoltarButton = new JButton("Voltar para Carros");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;      
        gbc.weighty = 1.0;   
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        gbc.insets = new Insets(60,0,0,0);  
        panelgera.add(VoltarButton,gbc);
        gbc.insets = new Insets(0,0,0,0);
        
        setValorTdespesa(telaDespesa.getvalorString());
        geral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
             {   
                
                panelgera.setVisible(true);
                panelabastecimento.setVisible(false);
                panelmanu.setVisible(false);
                paneldespesa.setVisible(false);
                geral.setIcon(geralIcon1);
                manutencao.setIcon(manuiIcon);
                despesa.setIcon(despesaIcon);
                abastecimento.setIcon(abastIcon);
            }});
        despesa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {   
                
                panelgera.setVisible(false);
                panelabastecimento.setVisible(false);
                panelmanu.setVisible(false);
                paneldespesa.setVisible(true);
                panelmeio.add(paneldespesa,BorderLayout.NORTH);
                despesa.setIcon(despesaIcon1);
                manutencao.setIcon(manuiIcon);
                abastecimento.setIcon(abastIcon);
                geral.setIcon(geralIcon);

            }});
        abastecimento.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e)
            {   
                setValorTabast(telaaAbastecimento.getValorfinalA());
                panelgera.setVisible(false);
                panelabastecimento.setVisible(true);
                panelmanu.setVisible(false);
                paneldespesa.setVisible(false);
                panelmeio.add(panelabastecimento,BorderLayout.NORTH);
                abastecimento.setIcon(abastIcon1);
                manutencao.setIcon(manuiIcon);
                despesa.setIcon(despesaIcon);
                geral.setIcon(geralIcon);
            }});
        manutencao.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e)
            {   

                setValorTmanu(telaManutencao.getValorfinalM());
                panelgera.setVisible(false);
                panelabastecimento.setVisible(false);
                panelmanu.setVisible(true);
                paneldespesa.setVisible(false);
                panelmeio.add(panelmanu,BorderLayout.NORTH);
                manutencao.setIcon(manuiIcon1);
                despesa.setIcon(despesaIcon);
                abastecimento.setIcon(abastIcon);
                geral.setIcon(geralIcon);
             }});
        despesaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {   
                    telaDespesa.criarTeladespesa();
                    frame.dispose();
                
            }});
        abasteciButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                        telaaAbastecimento.criarTelaAbastecimento();
                        frame.dispose();
                    
                }});
            manuButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                        telaManutencao.criarTelaManutencao();
                        frame.dispose();
                        
                    
                }});
            apagardespesa.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                        TelaPrincipal.despesa.apagarDespesas();
                        frame.dispose();
                        criarTelaPrincipal();
                        
                        
                    }});
            apagarAbastec.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                        TelaPrincipal.abastecimento.apagarAbastecimento();
                        frame.dispose();
                        criarTelaPrincipal();
                                
                                
                    }});
             apagarmanutencao.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                       TelaPrincipal.manutencao.apagarManutencao();
                        frame.dispose();
                        criarTelaPrincipal();
                                
                                
                         }});
            VoltarButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                            
                        frame.dispose();
                        telaCarros.CriarTelaCarros();
                                        
                                        
                             }});         
        
        
        
        panelmeio.add(panelgera,BorderLayout.NORTH);
        panelgera.setVisible(true);
        paneldespesa.setVisible(false);
        panelabastecimento.setVisible(false);
        panelmanu.setVisible(false);
        mainContainer.add(panelmeio);
        panelesquerda.add(panelbotoes);
        mainContainer.add(panelesquerda,BorderLayout.WEST);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 800));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); 
    }

    
    
    /** 
     * Atribui valor a variavel valorTdespesa
     */
    public void setValorTdespesa(String valorTdespesa ) {
        this.valorTdespesa  = valorTdespesa ;
     }
     
     /** 
      * Atribui valor a variavel valorTddia
      */
     public void setValorTddia(String valorTddia ) {
        this.valorTddia  = valorTddia ;
     }
     
     /** 
      * Atribui valor a variavel valorTabast
      */
     public void setValorTabast(String valorTabast ) {
        this.valorTabast  = valorTabast ;
     }
     
     /** 
      * Atribui valor a variavel valorTAdia
      */
     public void setValorTAdia(String valorTAdia) {
        this.valorTAdia  = valorTAdia ;
     }
     
     /** 
      * Atribui valor a variavel valorTmanu
      */
     public void setValorTmanu(String valorTmanu ) {
        this.valorTmanu  = valorTmanu ;
     }
     
     /** 
      * Atribui valor a variavel valorTMdia
      */
     public void setValorTMdia(String valorTMdia ) {
        this.valorTMdia  = valorTMdia ;
     }
  
}
