package TP04;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin  extends JFrame{
    static TelaPrincipal TelaPrincipal= new TelaPrincipal();
    static TelaRegistro telaRegistro= new TelaRegistro();
    static TelaCarros telaCarros= new TelaCarros();
    static Usuario usuario= new Usuario();
    String senhaString;
    static JFrame frame = new JFrame();
    static JTextField userText = new JTextField(16);
    static JPasswordField passwordText = new JPasswordField(20);
    static String nomeU ;
    static String TempUsuario ="";
    static String TempSenha ="";
    
    /**
     * O método CriaTelaLogin cria um frame que envia as informações para a autentificação de um login 
     */
         public void Criartelalogin(){
            BufferedImage img = null;
            BufferedImage loginb = null;
            BufferedImage registerb = null;
            Color color=new Color(0xa3f0e6);
            
            
            Font fonte = new Font("Courier New",Font.BOLD,30);
            try {
                img= ImageIO.read(new File("imagens/gradiente1.png"));
                loginb = ImageIO.read(new File("imagens/login.png"));
                registerb = ImageIO.read(new File("imagens/register.png"));
                
        
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(600, 800));
            JLabel label = new JLabel();
            
            JLabel userLabel = new JLabel("Usuário");
            userLabel.setBounds(245, 130, 150, 100);
            userLabel.setFont(fonte);
            label.add(userLabel);
           
            
            userText.setBounds(160, 200, 280, 60);
            userText.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            userText.setBackground(color);
            userText.setFont(fonte);
            nomeU = userText.getText();
            
            label.add(userText);
    
            JLabel passwordLabel = new JLabel("Senha");
            passwordLabel.setBounds(255, 230, 280, 125);
            
            passwordLabel.setFont(fonte);
           
    
            
            passwordText.setBounds(160, 330, 280, 60);
            passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            passwordText.setBackground(color);
            

            JButton loginButton = new JButton();
            loginButton.setBounds(50, 450, 230, 80);
            loginButton.setOpaque(false);
            loginButton.setContentAreaFilled(false);
            loginButton.setBorderPainted(false);
            label.add(loginButton);
            loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {   
                String senhaString = String.valueOf(passwordText.getPassword());

                Usuario.verificarlogin(userText.getText(),  senhaString);
                
            }});
            
            
            JButton registerButton = new JButton("register");
            registerButton.setBounds(305, 450, 240, 80);
            registerButton.setOpaque(false);
            registerButton.setContentAreaFilled(false);
            registerButton.setBorderPainted(false);
            label.add(registerButton);
            registerButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {   
                    
                    telaRegistro.CriarTelaRegistro();
                    frame.dispose();
                }});
            
           
            
            Image dimg= img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
            Image loginI= loginb.getScaledInstance(loginButton.getWidth(),loginButton.getHeight(), Image.SCALE_SMOOTH);
            Image registerI= registerb.getScaledInstance(230,registerButton.getHeight(), Image.SCALE_AREA_AVERAGING);
            
            ImageIcon imageIcon = new ImageIcon(dimg);
            ImageIcon loginicon = new ImageIcon(loginI);
            ImageIcon registerIcon = new ImageIcon(registerI);
            loginButton.setIcon(loginicon);
            registerButton.setIcon(registerIcon);
            label.setIcon(imageIcon);
            label.add(passwordLabel);
            label.add(passwordText);
    
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.add(label);
        }

        
    }  
