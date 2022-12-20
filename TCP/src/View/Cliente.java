package View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JFileChooser;

public class Cliente extends javax.swing.JFrame {

    private static Socket socket;
    private static DataOutputStream saida;
    private static DataInputStream entrada;
    private static String nome;
    private static String texto;
    private static String nomeArq="";
    
    public Cliente() {
        
        initComponents();
        inciaCliente();
        mensagem();
    }
    
    private void mensagem(){
        
        new Thread(){
                public void run(){
                    do{
                        try{
                            
                            String msg = entrada.readUTF();
                            TFChat.append(msg+"\n");
                            int tam = entrada.readInt();
                            
                            FileOutputStream file = new FileOutputStream(new File(msg));
                            
                            do {
                                file.write(entrada.read());
                            } while (tam-- > 1);
                            file.close();
                        }catch(IOException e){
                            
                            System.out.println("Erro ao receber mensagem! "+ e.getMessage());
                        }
                    }while(true);
                }
            }.start();
            
            
              
                
            
    }
    
    private static void inciaCliente(){
        
        
        try{
            socket = new Socket("127.1.1.0",1500);
            System.out.println("CLiente Conectado!");
            saida = new DataOutputStream(socket.getOutputStream());
            entrada = new DataInputStream(socket.getInputStream());
            
            
            
        }catch(SocketException e){
            System.out.println("Erro de Conexao! "+ e.getMessage());
        }catch(IOException e){
            System.out.println("Erro ao enviar ou receber mensagem! "+ e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFText = new javax.swing.JTextField();
        BEnvia = new javax.swing.JButton();
        TFNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BSalva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TFChat = new javax.swing.JTextArea();
        TFArq = new javax.swing.JTextField();
        BArq = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BEnvia.setText("Enviar");
        BEnvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnviaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        BSalva.setText("Salva");
        BSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalvaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente");

        TFChat.setColumns(20);
        TFChat.setRows(5);
        jScrollPane1.setViewportView(TFChat);

        BArq.setText("Busca Arquivo");
        BArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BArqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFArq, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BArq))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BSalva))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFText, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BEnvia)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BSalva))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFArq, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BArq)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BEnvia))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEnviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnviaActionPerformed
        
        System.out.println(TFText.getText());
        try {
                
                if(nomeArq.equals("")){
                    
                    saida.writeUTF(nome+":"+TFText.getText());
                    texto = (nome+":"+TFText.getText());
                    TFText.setText("");
                }
                else{
                    
                    File arquivo = new File(nomeArq);
                    FileInputStream file = new FileInputStream(arquivo);
                    int tam = file.available();
                    byte[] buffer = new byte[tam];
                    file.read(buffer);
                    
                    nomeArq = (arquivo.getName());
                    saida.writeUTF(nomeArq);
                    saida.flush();
                    saida.writeInt(tam);
                    saida.flush();
                    saida.write(buffer);
                    saida.flush();
                    file.close();
                    saida.flush();

                    texto = (nome+":"+nomeArq);
                    TFText.setText("");
                    TFArq.setText("");
                }
            
                
                
                
                
            } catch (IOException ex) {
                System.out.println("Erro ao enviar ou receber mensagem! "+ ex.getMessage());
            }
        
        TFChat.append(texto+"\n");
        
        
    }//GEN-LAST:event_BEnviaActionPerformed

    private void BSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalvaActionPerformed
        nome = TFNome.getText();
    }//GEN-LAST:event_BSalvaActionPerformed

    private void BArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BArqActionPerformed
        
        JFileChooser file = new JFileChooser();
        
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= file.showSaveDialog(null);
        
       if (i==1){
           
           TFArq.setText("");
       }
       
       else {
       
            File arquivo = file.getSelectedFile();
            TFArq.setText(arquivo.getPath());
            nomeArq = (arquivo.getPath());
       }
        
    }//GEN-LAST:event_BArqActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BArq;
    private javax.swing.JButton BEnvia;
    private javax.swing.JButton BSalva;
    private javax.swing.JTextField TFArq;
    private javax.swing.JTextArea TFChat;
    private javax.swing.JTextField TFNome;
    private javax.swing.JTextField TFText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
