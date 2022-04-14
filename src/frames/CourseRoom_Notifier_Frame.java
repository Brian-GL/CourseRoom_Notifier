/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author LENOVO
 */
public class CourseRoom_Notifier_Frame extends javax.swing.JFrame {

    private DatagramSocket datagramSocket;
    private Conexion_Servidor conexion_Servidor;
    private int Id_Usuario;
    
    
    /**
     * Creates new form CourseRoom_Notifier_Frame
     */
    public CourseRoom_Notifier_Frame() {
        initComponents();
        
        Color color_Azul_Oscuro = new Color(14, 30, 64);
        Color color_Azul_Claro = new Color(104, 194, 232);
        descripcion_JScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        descripcion_JScrollPane.getHorizontalScrollBar().setUnitIncrement(15);
        
        descripcion_JTextPane.setBackground(color_Azul_Claro);
        descripcion_JTextPane.setForeground(color_Azul_Oscuro);
        descripcion_JTextPane.setCaretColor(color_Azul_Oscuro);
        descripcion_JScrollPane.setForeground(color_Azul_Oscuro);
        
        Image logo_Imagen;
        try {
            logo_Imagen = ImageIO.read(getClass().getResource("/recursos/imagenes/Course_Room_Brand_Blue.png"));
            logo_Imagen = logo_Imagen.getScaledInstance(150, 125, Image.SCALE_SMOOTH);
            this.setIconImage(logo_Imagen);
            ImageIcon icono = new ImageIcon(logo_Imagen);
            logo_Inicio_JLabel.setIcon(icono);
            logo_Imagen.flush();
            icono.getImage().flush();
            datagramSocket = new DatagramSocket(9001);
            conexion_Servidor = new Conexion_Servidor();
            conexion_Servidor.start();
        } catch (IOException ex) {
            Agregar_Texto(ex.getMessage());
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

        visualizador_JPanel = new javax.swing.JPanel();
        logo_Inicio_JLabel = new javax.swing.JLabel();
        descripcion_JScrollPane = new javax.swing.JScrollPane();
        descripcion_JTextPane = new javax.swing.JTextPane();
        titulo_Inicio_JLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CourseRoom Notifier");
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        visualizador_JPanel.setBackground(new java.awt.Color(14, 30, 64));
        visualizador_JPanel.setForeground(new java.awt.Color(104, 194, 232));

        logo_Inicio_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo_Inicio_JLabel.setMaximumSize(new java.awt.Dimension(150, 125));
        logo_Inicio_JLabel.setMinimumSize(new java.awt.Dimension(150, 125));
        logo_Inicio_JLabel.setPreferredSize(new java.awt.Dimension(150, 125));

        descripcion_JTextPane.setEditable(false);
        descripcion_JTextPane.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        descripcion_JTextPane.setToolTipText("");
        descripcion_JScrollPane.setViewportView(descripcion_JTextPane);

        titulo_Inicio_JLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo_Inicio_JLabel.setForeground(new java.awt.Color(104, 194, 232));
        titulo_Inicio_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_Inicio_JLabel.setText("Notificador");
        titulo_Inicio_JLabel.setPreferredSize(new java.awt.Dimension(670, 48));

        javax.swing.GroupLayout visualizador_JPanelLayout = new javax.swing.GroupLayout(visualizador_JPanel);
        visualizador_JPanel.setLayout(visualizador_JPanelLayout);
        visualizador_JPanelLayout.setHorizontalGroup(
            visualizador_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizador_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visualizador_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo_Inicio_JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(descripcion_JScrollPane)
                    .addComponent(titulo_Inicio_JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        visualizador_JPanelLayout.setVerticalGroup(
            visualizador_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizador_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo_Inicio_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo_Inicio_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcion_JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(visualizador_JPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        conexion_Servidor.interrupt();

        // Cerrando la conexón
        datagramSocket.close();

        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

   
    private class Conexion_Servidor extends Thread{
        
        
        @Override
        public void run(){
            
            Agregar_Texto("Esperando Conexión Con CourseRoom Server...");
            byte[] entryBuffer = new byte[128];
            DatagramPacket datagramPacket = new DatagramPacket(entryBuffer,entryBuffer.length);
            String mensaje;
            String valor;
            int longitud;
            int indice;
            while(true){
                
                try {
                    
                    datagramSocket.receive(datagramPacket);
                    
                    //Usuario:
                    indice = 0;
                    longitud = (int)entryBuffer[indice];
                    byte[] arreglo = new byte[longitud];
                    
                    for(int i = 1; i <= longitud; i++){
                        arreglo[i-1] = entryBuffer[i];
                    }
                    
                    indice = indice + 1;
                    valor = ConvertirArreglo(arreglo);
                    System.out.println(valor);
                    
                    Id_Usuario = Integer.parseInt(valor);
                    
                    //Ip:
                    longitud = (int)entryBuffer[indice];
                    indice++;
                    arreglo = new byte[longitud];
                    
                    for(int i = 0; i < longitud; i++,indice++){
                        arreglo[i] = entryBuffer[indice];
                    }
                    
                    valor = ConvertirArreglo(arreglo).substring(1);
                    
                    mensaje = "\nEl Usuario "+String.valueOf(Id_Usuario)+" Tiene Una Nueva Notificación Con IP: "+valor;
                    Agregar_Texto(mensaje+"\n");
                    
                    Enviar_Aviso(Id_Usuario,valor);

                } catch (IOException ex) {
                    Agregar_Texto(ex.getMessage());
                }
                
            }
        }
    }
    
    public String ConvertirArreglo(byte[] arreglo) {
        return new String(arreglo);
    }

    private void Enviar_Aviso(int id_Usuario, String ip){
        
        Agregar_Texto("Enviando Aviso Al IP: "+ip+"...\n");
        
        String simpleMessage = String.valueOf(id_Usuario);
        byte bandera = 0;
        
        byte[] buffer = new byte[128];
        
        //Usuario:
        buffer[0] = (byte) simpleMessage.length();
			
        //Creamos un valor auxiliar (copia) que nos obtendrá los bytes de la cadena.
        byte[] copia = simpleMessage.getBytes();

        //Creamos la copia del valor auxiliar hacia nuestro arreglo de bytes
        for(int i = 1; i <= simpleMessage.length();i++){
            buffer[i] = copia[i-1];
        }
        
        int indice = simpleMessage.length()+1;
        buffer[indice] = (byte) ip.length();
        indice++;
        
        //Creamos un valor auxiliar (copia) que nos obtendrá los bytes de la cadena.
        copia = ip.getBytes();

        //Creamos la copia del valor auxiliar hacia nuestro arreglo de bytes
        for(int i = 0; i < ip.length();i++,indice++){
            buffer[indice] = copia[i];
        }
       
        while(bandera < 60){
            try(DatagramSocket socketSender = new DatagramSocket()){

                DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,
                        InetAddress.getByName("localhost"),9002);

                socketSender.send(datagramPacket);
                bandera = 100;
            } catch (SocketException ex) {
                System.err.println(ex.getMessage());
                bandera++;
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                bandera++;
            }    
        }
    }

    private void Agregar_Texto(String texto){
        try {
            Document doc = descripcion_JTextPane.getDocument();
            doc.insertString(doc.getLength(), texto, null);
        } catch(BadLocationException exc) {
            
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane descripcion_JScrollPane;
    private javax.swing.JTextPane descripcion_JTextPane;
    private javax.swing.JLabel logo_Inicio_JLabel;
    private javax.swing.JLabel titulo_Inicio_JLabel;
    private javax.swing.JPanel visualizador_JPanel;
    // End of variables declaration//GEN-END:variables
}
