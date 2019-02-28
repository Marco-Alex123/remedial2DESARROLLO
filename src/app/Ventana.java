
package app;


import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedWriter;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import java.io.InputStream;

/**
 *
 * @author Marco Lopez
 */
public class Ventana extends javax.swing.JFrame {

    
    public Ventana() {
        initComponents();
        this.setTitle("Descargador de imagenes");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel1.setText("URL:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(51, 255, 0));
        jToggleButton1.setText("DOWLANS");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel2.setText("Document´s name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       
        try {
            // URL
            URL url = new URL(jTextField1.getText()); 
            URLConnection urlCon = url.openConnection();  
            System.out.println(urlCon.getContentType()); 
          
            String nombre = jTextField2.getText(); 
            String ruta = "C:\\Users\\SERGIO LOPEZ\\Documents" + nombre + urlCon.getContentType(); 
            File archivo = new File(ruta);
            BufferedWriter bw=null;
            if (archivo.exists()) {
   
                        int choice = JOptionPane.showOptionDialog(null, 
                            "Renombrar archivo", 
                            "Archivo existente", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, 
                            null, null, null);

            
                    
                        if (choice != JOptionPane.YES_OPTION)
                        {
                          System.exit(0);
                        }
            } 
            else {
           
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\SERGIO LOPEZ\\Documents" + nombre + ".jpg"); 
   
            

                    String path = "C:\\Users\\SERGIO LOPEZ\\Documents" + nombre + ".jpg";
                    URL dir = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    jLabel3.setIcon(icon);

                    byte[] array = new byte[1000]; 
                    int leido = is.read(array);
                    while (leido > 0) {
                        fos.write(array, 0, leido);
                        leido = is.read(array);
                    }
                    is.close();
                    fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
