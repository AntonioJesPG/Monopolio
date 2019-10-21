/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Drakthon
 */
public class Especulador  extends Jugador   {
    int fianza;
    static int factorEspeculador = 2;
    public Especulador(Jugador j, int fianza){
        super(j);
        this.fianza = fianza;
    }
    
    Especulador convertirme(int fianza){
        return this;
    }

 void pagarImpuestos(int cantidad){
      modificarSaldo(-cantidad/2);
  }
    
 void irACarcel(Casilla casilla){
     if(!pagarFianza(fianza)){
         setCasillaActual(casilla);
        setEncarcelado(true);
     }
 }
 
 private boolean pagarFianza(int cantidad){
     if(super.tengoSaldo(cantidad)){
     super.modificarSaldo(-cantidad);
     }
     return super.tengoSaldo(cantidad);
     
     
 }
 
 @Override
public String toString() {
return "Especulador{" + "Nombre =" + super.getName() + ", ¿ésta en la carcel? =" + 
super.getEncarcelado() + ", saldo =" + saldo + ", fianza =" + fianza + "}";
}  
 
}
