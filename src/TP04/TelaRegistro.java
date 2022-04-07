package TP04;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class TelaRegistro {
    static TelaPrincipal TelaPrincipal= new TelaPrincipal();
    static TelaLogin telaLogin= new TelaLogin();
    static Usuario usuario= new Usuario();
    JTextField userText = new JTextField(16);
    JPasswordField passwordText = new JPasswordField(20);
    /**
     * O metodo CriaTelaRegistro cria um frame que envia as informações para a criação de um usuario
     */
         public void CriarTelaRegistro(){
            BufferedImage img = null;
            BufferedImage registerb = null;
            Color color=new Color(0xa3f0e6);
            
            
            Font fonte = new Font("Courier New",Font.BOLD,30);
            try {
                img= ImageIO.read(new File("imagens/gradiente1.png"));
                registerb = ImageIO.read(new File("imagens/register.png"));
                
        
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JFrame frame = new JFrame();
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
            label.add(userText);
    
            JLabel passwordLabel = new JLabel("Senha");
            passwordLabel.setBounds(255, 230, 280, 125);
            
            passwordLabel.setFont(fonte);
            label.add(passwordLabel);
    
            
            passwordText.setBounds(160, 330, 280, 60);
            passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            passwordText.setBackground(color);
            label.add(passwordText);

            
            JButton registerButton = new JButton("register");
            registerButton.setBounds(190, 450, 240, 80);
            registerButton.setOpaque(false);
            registerButton.setContentAreaFilled(false);
            registerButton.setBorderPainted(false);
            registerButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    telaLogin.Criartelalogin();
                    usuario.setNome(userText.getText());
                    usuario.setSenha(passwordText.getPassword());
                    usuario.salvarUsuarios();
                    frame.dispose();
                }});
            label.add(registerButton);
           
            Image dimg= img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
            Image registerI= registerb.getScaledInstance(230,registerButton.getHeight(), Image.SCALE_AREA_AVERAGING);
            ImageIcon imageIcon = new ImageIcon(dimg);
            ImageIcon registerIcon = new ImageIcon(registerI);
            registerButton.setIcon(registerIcon);
            label.setIcon(imageIcon);
    
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.add(label);
        }
        
        }
    
    
