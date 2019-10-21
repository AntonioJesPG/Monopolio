/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;
import modeloqytetet.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Drakthon
 */
public class ControladorQytetet extends javax.swing.JFrame {

    public static Qytetet modeloQytetet;
       
    /**
     * Creates new form ControladorQytetet
     */
    public ControladorQytetet() {
        initComponents();
    }

  public void habilitarComenzarTurno(){
 this.jbComprar.setEnabled(false);
 this.jbSiguienteJugador.setEnabled(false);
 this.jbAplicarSorpresa.setEnabled(false);
 if(modeloQytetet.getJugadorActual().getEncarcelado()){
 this.jbSalirCarcelPagando.setEnabled(true);
 this.jbSalirCarcelDado.setEnabled(true);
 }
 else
 this.jbJugar.setEnabled(true);
  this.jbSalirCarcelPagando.setEnabled(false);
 this.jbSalirCarcelDado.setEnabled(false);
 } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistaQytetet1 = new GUIQytetet.VistaQytetet();
        jPanel4 = new javax.swing.JPanel();
        jbSalirCarcelDado = new javax.swing.JButton();
        jbSalirCarcelPagando = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jbComprar = new javax.swing.JButton();
        jbJugar = new javax.swing.JButton();
        jbAplicarSorpresa = new javax.swing.JButton();
        jbSiguienteJugador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Carcel"));

        jbSalirCarcelDado.setText("Intentar salir tirando el dado");
        jbSalirCarcelDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelDadoActionPerformed(evt);
            }
        });

        jbSalirCarcelPagando.setText("Intentar salir pagando");
        jbSalirCarcelPagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelPagandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbSalirCarcelDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalirCarcelPagando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSalirCarcelDado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalirCarcelPagando)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Juego"));

        jbComprar.setText("Comprar");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbJugar.setText("Jugar");
        jbJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJugarActionPerformed(evt);
            }
        });

        jbAplicarSorpresa.setText("Aplicar sorpresa");
        jbAplicarSorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarSorpresaActionPerformed(evt);
            }
        });

        jbSiguienteJugador.setText("Pasar turno");
        jbSiguienteJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbSiguienteJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbJugar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbAplicarSorpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbComprar)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAplicarSorpresa)
                    .addComponent(jbComprar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbJugar)
                    .addComponent(jbSiguienteJugador))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vistaQytetet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaQytetet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirCarcelDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelDadoActionPerformed
 boolean resultado =
modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
this.jbSalirCarcelPagando.setEnabled(false);
this.jbSalirCarcelDado.setEnabled(false);

if(resultado){
 JOptionPane.showMessageDialog(this, "Sales de la cárcel");
 this.jbJugar.setEnabled(true);
}else {
 JOptionPane.showMessageDialog(this, "NO sales de la carcel");
 this.jbSiguienteJugador.setEnabled(true);
 }
this.vistaQytetet1.Actualizar(modeloQytetet);

    }//GEN-LAST:event_jbSalirCarcelDadoActionPerformed

    private void jbJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJugarActionPerformed
        modeloQytetet.jugar();
         this.jbJugar.setEnabled(false);
        
        if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.SORPRESA){
            this.jbComprar.setEnabled(false);
            this.jbSiguienteJugador.setEnabled(false);
            this.jbAplicarSorpresa.setEnabled(true);
            
        }

       
        else{
            
             if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.CALLE){
                 if(modeloQytetet.getJugadorActual().getCasillaActual().getTituloPropiedad().tengoPropietario() == false){
           this.jbComprar.setEnabled(true);
                 }
       }
        this.jbSiguienteJugador.setEnabled(true);
       }
        this.vistaQytetet1.Actualizar(modeloQytetet);
        

    }//GEN-LAST:event_jbJugarActionPerformed

    private void jbSiguienteJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteJugadorActionPerformed
       
        if(modeloQytetet.getJugadorActual().bancarrota()){
            ArrayList<String> ranking = modeloQytetet.obtenerRanking();
            String rank = "Ranking de jugadores \n";
            for(int it = 0; it<=ranking.size();it++){
               rank = rank + ranking.get(it) + "\n";
            }
            JOptionPane.showMessageDialog(this,rank);
            
             this.jbComprar.setEnabled(false);
            this.jbSiguienteJugador.setEnabled(false);
            this.jbAplicarSorpresa.setEnabled(false);
            this.jbSalirCarcelPagando.setEnabled(false);
            this.jbSalirCarcelDado.setEnabled(false);
            this.jbJugar.setEnabled(false);
        }
        else{
        modeloQytetet.siguienteJugador();
        // Se puede usar el método de habilitarComenzarTurno() pero he considerado añadir mensajes para avisar cuando se esta en la carcel.
        if(modeloQytetet.getJugadorActual().getEncarcelado() == true){
             JOptionPane.showMessageDialog(this, "Estas en la carcel ameego");
            this.jbSalirCarcelPagando.setEnabled(true);
            this.jbSalirCarcelDado.setEnabled(true);
            this.jbJugar.setEnabled(false);

        }
        else{
             JOptionPane.showMessageDialog(this, "Tu turno jugador");
            this.jbJugar.setEnabled(true);
        }
         this.jbAplicarSorpresa.setEnabled(false);
            this.jbComprar.setEnabled(false);
            this.jbSiguienteJugador.setEnabled(false);
        }
            this.vistaQytetet1.Actualizar(modeloQytetet);
    }//GEN-LAST:event_jbSiguienteJugadorActionPerformed

    private void jbSalirCarcelPagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelPagandoActionPerformed
    boolean resultado =
modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
this.jbSalirCarcelPagando.setEnabled(false);
this.jbSalirCarcelDado.setEnabled(false);

if(resultado){
 JOptionPane.showMessageDialog(this, "Sales de la cárcel");
 this.jbJugar.setEnabled(true);
}else {
 JOptionPane.showMessageDialog(this, "NO sales de la carcel");
 this.jbSiguienteJugador.setEnabled(true);
 }
this.vistaQytetet1.Actualizar(modeloQytetet);

    }//GEN-LAST:event_jbSalirCarcelPagandoActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
       if(modeloQytetet.comprarTituloPropiedad()){
           JOptionPane.showMessageDialog(this, "Has comprado la propiedad");
       }
       else{
           JOptionPane.showMessageDialog(this, "NO has comprado la propiedad");
       }
       this.jbComprar.setEnabled(false);
       this.vistaQytetet1.Actualizar(modeloQytetet);
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jbAplicarSorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarSorpresaActionPerformed
        if(modeloQytetet.aplicarSorpresa()){
            JOptionPane.showMessageDialog(this, "Se ha aplicado la sorpresa");
        }
        else{
            JOptionPane.showMessageDialog(this, "NO ha sido posible aplicar la sorpresa");
        }
        
        this.jbAplicarSorpresa.setEnabled(false);
        this.jbSiguienteJugador.setEnabled(true);
        this.vistaQytetet1.Actualizar(modeloQytetet);
    }//GEN-LAST:event_jbAplicarSorpresaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       ControladorQytetet controladorQytetet= new ControladorQytetet();
     controladorQytetet.setVisible(true); 
     
     CapturaNombreJugadores capturaNombres
 = new CapturaNombreJugadores(controladorQytetet, true);
ArrayList<String> nombres= capturaNombres.obtenerNombres();

modeloQytetet  = Qytetet.getInstance();
modeloQytetet.inicializarJuego(nombres);

Dado.createInstance(controladorQytetet); 
controladorQytetet.habilitarComenzarTurno();
controladorQytetet.vistaQytetet1.Actualizar(modeloQytetet);


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbAplicarSorpresa;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbJugar;
    private javax.swing.JButton jbSalirCarcelDado;
    private javax.swing.JButton jbSalirCarcelPagando;
    private javax.swing.JButton jbSiguienteJugador;
    private GUIQytetet.VistaQytetet vistaQytetet1;
    // End of variables declaration//GEN-END:variables
}
