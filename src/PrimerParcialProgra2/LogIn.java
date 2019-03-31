/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcialProgra2;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.util.regex.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author hernandez
 */
public class LogIn extends javax.swing.JFrame implements Runnable{
    private static String Usuario;
    private static String Contraseña;
    private Document docUser;
    private  Document docPass;
    private  boolean NormasUser=false;
    private boolean NormasPass=false;
    private static String rutaData=System.getProperty("user.dir") + "\\Data123.txt";
   
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        
        
        initComponents();
        ImageIcon imagen=new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        ImageIcon imagen2=new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
         ImageIcon imagenCompas=new ImageIcon(getClass().getResource("/imagenes/Compas.jpg"));
         ImageIcon imagenCompas2=new ImageIcon(imagenCompas.getImage().getScaledInstance(fondoCompas.getWidth(), fondoCompas.getHeight(), Image.SCALE_DEFAULT));
       fondoCompas.setIcon(imagenCompas2);
        fondo.setIcon(imagen2);
       Enviar.setEnabled(false);
        docUser=User.getDocument(); 
        docUser.addDocumentListener(new ManejaDocUser());
        
        docPass=Pass.getDocument();
        docPass.addDocumentListener(new ManejaDocPass());
                

        Pass.addKeyListener(new Enter());
        
        User.addKeyListener(new Enter());
        
        
    }
    
    public static void setUser(String nombre){
        Usuario=nombre;
    }
    public static String getUser(){
        return Usuario;
    }
    public static void setPass(String Password){
        Contraseña=Password;
    }
    public static String getPass(){
        return Contraseña;
    }
    public static String getRuta(){
        return rutaData;
    }
    
  
    public void validaNombre(){
        if(User.getText().length()>0){
          Usuario=User.getText();
            int sizeUser=Usuario.length();
              if(sizeUser<6||sizeUser>12){
                etiqueta.setText("El tamaño del nombre debe estar entre 6 y 12 caracteres");
                
            }if(sizeUser>6&&sizeUser<12){
              etiqueta.setText("");
              NormasUser=true;
            }if(sizeUser==0){
                etiqueta.setText("");
            }if(NormasUser){
                if(!Character.isUpperCase(Usuario.charAt(0))){
               Usuario=Usuario.toUpperCase().charAt(0)+Usuario.substring(1, Usuario.length()).toLowerCase();
                    }else{
                    Usuario=Usuario.charAt(0)+Usuario.substring(1,Usuario.length()).toLowerCase();
                         }
                            }
            if(!NormasUser||!NormasPass){Enviar.setEnabled(false);
            
            }else{Enviar.setEnabled(true); }}
    }
    
     
 
    public void validaContra(){
        boolean buenTamaño=false;
        boolean Normas=false;
        char[]interpass=Pass.getPassword();
        Contraseña=String.copyValueOf(interpass);
        int sizePass=Contraseña.length();
       String Especiales = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]+|\\{+|\\}+|\\^+|\\<+|\\>+|\\´´+|\\\"+ ";
        
       String Numeros = "\\d";
       Pattern patronEspe=Pattern.compile(Especiales);
       Matcher emparejaEspe=patronEspe.matcher(Contraseña);
       
       Pattern patronNum=Pattern.compile(Numeros);
       Matcher emparejaNum=patronNum.matcher(Contraseña);
       if(sizePass<8||sizePass>20){
           avisoLargo.setText("El tamaño de la contraseña debe estar entre 8 y 20 caracteres");
       }
       else if(sizePass>8&&sizePass<20){avisoLargo.setText("");buenTamaño=true;} 
       if(emparejaEspe.find()&&emparejaNum.find()){etiqueta2.setText("");Normas=true;}
       //el método find devuelve true si encontró que si tiene o false si no tiene lo que estábamos buscando
       else if(!emparejaEspe.find()||!emparejaNum.find()){etiqueta2.setText("La contraseña debe llevar numeros y caracteres especiales");Normas=false;}
            if(Normas&&buenTamaño){
                NormasPass=true;
            }else if(!Normas||!buenTamaño){
                NormasPass=false;
            }
           if(!NormasUser||!NormasPass){
               Enviar.setEnabled(false);
           }else if (NormasUser && NormasPass){Enviar.setEnabled(true);}
            
            
            
        
        
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
   
    
    private class ManejaDocUser implements DocumentListener{
        

        @Override
        public void insertUpdate(DocumentEvent e) {
      validaNombre();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          validaNombre();
        }

        @Override
        public void changedUpdate(DocumentEvent e) { 
           
        }
        
    }
    private class ManejaDocPass implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            validaContra();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validaContra();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        User = new javax.swing.JTextField();
        Etiqueta3 = new javax.swing.JLabel();
        etiqueta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Enviar = new javax.swing.JButton();
        avisoLargo = new javax.swing.JLabel();
        etiqueta2 = new javax.swing.JLabel();
        fondoCompas = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        getContentPane().add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 230, -1));

        Etiqueta3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        Etiqueta3.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(Etiqueta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 280, 20));

        etiqueta.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(etiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 340, 20));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        Enviar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11)); // NOI18N
        Enviar.setForeground(new java.awt.Color(255, 255, 255));
        Enviar.setText("Log In");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });
        getContentPane().add(Enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        avisoLargo.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        avisoLargo.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(avisoLargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 340, 20));

        etiqueta2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        etiqueta2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(etiqueta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 340, 20));
        getContentPane().add(fondoCompas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 230, 130));
        getContentPane().add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 230, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
darPasoLogIn();        // TODO add your handling code here:
    }//GEN-LAST:event_EnviarActionPerformed

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserActionPerformed

    public void darPasoLogIn(){
    
        String savedPass=""; 
        String savedUser="";
        int conta=0;
        boolean esUser=false; 
        boolean esPass=false;
        String Bienvenida="";
        
        
        File path =new File(rutaData);
        System.out.println(rutaData);
        if(path.exists()){
            Bienvenida="Bienvenido de nuevo: ";
            FileReader fr = null;
            try {
                fr = new FileReader(path);
                 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            } 
              BufferedReader bf = new BufferedReader(fr);
              
                while(conta<2){if(conta==0){try { 
                    savedUser=bf.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
}
                else if(conta==1){
                    try {
                        savedPass=bf.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }conta++;}
            if(savedUser.equalsIgnoreCase(Usuario)){esUser=true;} 
            else if(!savedUser.equalsIgnoreCase(Usuario)){esUser=false;}
            if(savedPass.equals(Contraseña)){esPass=true;}
            else if(!savedPass.equalsIgnoreCase(Contraseña)){esPass=false; }
            if(esUser && esPass){
                CuadroSecundario cuadro=new CuadroSecundario(Usuario,Bienvenida);
                
                this.setVisible(false);
            
            }else{ 
                if(!esUser&&esPass){ 
                    JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto");}
                
                else if(!esPass&&esUser){
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");}
            else if(!esUser&&!esPass){
                JOptionPane.showMessageDialog(null, "Nombre de usuario y contraseña incorrecto");}}
            
                
        }
        else if(!path.exists()){
            Bienvenida="Bienvenido nuevo usuario: ";
            try {
                crearFileWriter();
            } catch (IOException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
            CuadroSecundario cuadro2=new CuadroSecundario(Usuario,Bienvenida);
            this.setVisible(false);
        }
}public void crearFileWriter() throws IOException{
    FileWriter fw =new FileWriter(System.getProperty("user.dir") + "\\Data123.txt"); 
    fw.write(Usuario+ System.getProperty("line.separator"));
    fw.write(Contraseña);
    fw.flush();
  
}
private class Enter extends KeyAdapter{ 
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            darPasoLogIn();
        }
    }
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.JLabel Etiqueta3;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JTextField User;
    private javax.swing.JLabel avisoLargo;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondoCompas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
