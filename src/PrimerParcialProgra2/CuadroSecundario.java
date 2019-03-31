
package PrimerParcialProgra2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class CuadroSecundario {
    
    
    JLabel etiqueta22;
    JLabel etiqueta23;
    boolean NormasPass;
    JButton guardar;
    String contra;
    JFrame cuadroCambio;
    JTextField damePass;
    JLabel cambio;
    public CuadroSecundario(String Usuario, String Wellcome){
        JFrame frame=new JFrame(); frame.setLocationRelativeTo(null); frame.setSize(500, 400);
            frame.setTitle("Home"); frame.setVisible(true);
            
            JPanel panel =new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(new BorderLayout());
            JLabel label=new JLabel(Wellcome+ Usuario);
            label.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 20));
            cambio=new JLabel();
            cambio.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11));
            cambio.setHorizontalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label, BorderLayout.NORTH);
            panel.add(cambio, BorderLayout.CENTER);
            
            JLabel botonCambio=new JLabel ("Cambiar Contraseña");
            botonCambio.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11));
            manejador maneja=new manejador(); 
            
           botonCambio.addMouseListener(maneja);
           panel.add(botonCambio, BorderLayout.SOUTH); 
          frame.add(panel);
    }

 
    
        
        
            
    
    
    public void validaContra(){
        
        
         boolean buenTamaño=false;
        boolean Normas=false;
        contra=damePass.getText();
        
        int sizePass=contra.length();
       String Especiales = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]+|\\{+|\\}+|\\^+|\\<+|\\>+|\\´´+|\\\"+ ";
       String Numeros = "\\d";
       Pattern patronEspe=Pattern.compile(Especiales);
       Matcher emparejaEspe=patronEspe.matcher(contra);
       Pattern patronNum=Pattern.compile(Numeros);
       Matcher emparejaNum=patronNum.matcher(contra);
       if(sizePass<8||sizePass>20){
           etiqueta23.setText("El tamaño de la contraseña debe estar entre 8 y 20 caracteres");
       }
       
       else if(sizePass>8&&sizePass<20){etiqueta23.setText("");buenTamaño=true;} 
       if(emparejaEspe.find()&&emparejaNum.find()){ etiqueta22.setText("");Normas=true;}
       else if(!emparejaEspe.find()||!emparejaNum.find()){etiqueta22.setText("La contraseña debe llevar numeros y caracteres especiales");Normas=false;}
            if(Normas&&buenTamaño){
                NormasPass=true;
            }
            if(NormasPass){guardar.setEnabled(true);}else if(!NormasPass){guardar.setEnabled(false);}
    }
    
    private class manejador extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
           
         
       cuadroCambio=new JFrame();
        cuadroCambio.setVisible(true);
        cuadroCambio.setLocationRelativeTo(null);
        cuadroCambio.setTitle("Cambio de Contraseña");
        cuadroCambio.setSize(350, 275);
        cuadroCambio.setLayout(new BorderLayout()); 
        cuadroCambio.setBackground(Color.white);
        JPanel panel2=new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout(new BorderLayout());
        JLabel pongala=new JLabel("Ingrese la nueva contraseña");
        pongala.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11));
        pongala.setHorizontalAlignment(JLabel.CENTER);
        cuadroCambio.add(pongala,BorderLayout.NORTH);
        damePass=new JTextField();
        Document docCambio=damePass.getDocument();
        docCambio.addDocumentListener(new manejadoc());
        panel2.add(damePass,BorderLayout.NORTH);
        etiqueta22=new JLabel();
        etiqueta22.setFont(new java.awt.Font("Tahoma", 3, 11));
        etiqueta22.setForeground(new java.awt.Color(255, 0, 0));
        etiqueta22.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(etiqueta22, BorderLayout.CENTER); 
         etiqueta23=new JLabel();
         etiqueta23.setFont(new java.awt.Font("Tahoma", 3, 11));
         etiqueta23.setForeground(new java.awt.Color(255,0,0));
         etiqueta23.setHorizontalAlignment(JLabel.CENTER);
         panel2.add(etiqueta23,BorderLayout.SOUTH);
       guardar=new JButton("Guardar");
       guardar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 11));
       guardar.setEnabled(false);
        guardar.addActionListener(new manejaEnvio());
     cuadroCambio.add(guardar,BorderLayout.SOUTH);
     cuadroCambio.add(panel2,BorderLayout.CENTER); 
        
        
       
        }

      
    }
    
     private class manejadoc implements DocumentListener {

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
     private class manejaEnvio implements ActionListener{

        @Override
        
        public void actionPerformed(ActionEvent e) {
             BufferedReader reader =null;
            BufferedWriter writer=null;
            try {
                String viejoPath =LogIn.getRuta();
                
                String nuevoPath=System.getProperty("user.dir") + "\\tempFile.txt"; 
                File inputFile = new File(viejoPath);
                File tempFile = new File(nuevoPath);
                reader = new BufferedReader(new FileReader(inputFile));
               writer = new BufferedWriter(new FileWriter(tempFile));
                String currentLine;
                while((currentLine = reader.readLine()) != null) {
                    if(null!=currentLine && !currentLine.equalsIgnoreCase(LogIn.getPass())){
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }       writer.flush();
                
                
                inputFile=new File(nuevoPath);
                tempFile=new File(viejoPath);
                reader=new BufferedReader(new FileReader(inputFile));
                writer =new BufferedWriter(new FileWriter(tempFile));
                while((currentLine=reader.readLine())!=null){
                    writer.write(currentLine + System.getProperty("line.separator"));
                }   
                
                writer.flush();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CuadroSecundario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CuadroSecundario.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            try {
                File tempfile=new File(LogIn.getRuta());
                writer = new BufferedWriter(new FileWriter(tempfile));
                int contador=0;
                
                while(contador<2){
                    
                    if(contador==0){
                        writer.write(LogIn.getUser() + System.getProperty("line.separator"));
                    }
                    if(contador==1){
                        try {
                            writer.write(contra);
                        } catch (IOException ex) {
                            Logger.getLogger(CuadroSecundario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    contador++;}
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(CuadroSecundario.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            cuadroCambio.setVisible(false);
            
            cambio.setText("Se cambió la contraseña con éxito");
            
            
           
        }
         
     }
}
