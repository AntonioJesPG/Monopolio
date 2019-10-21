/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author AntonioJesús
 */
public class TituloPropiedad {
    private String nombreCalle;
    private boolean hipotecado;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private Casilla casilla;
    Jugador prueba = new Jugador("prueba");
    private Jugador propietario = prueba;
    
    
    public TituloPropiedad(String nombreCalle, int alquilerBase, int hipotecaBase, int precioEdificar, float factorRevalorizacion){
        this.nombreCalle = nombreCalle;
        this.alquilerBase = alquilerBase;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        this.hipotecado = false;
        //Entre el 10% y 20% y puede ser negativo
        this.factorRevalorizacion = factorRevalorizacion;

    }
   
  void Hipotecar(){
      if(this.hipotecado == false)  this.hipotecado = true;
    
      else this.hipotecado = false;
      
  }
    
 public  String getNombre(){
      return this.nombreCalle;
  }
    
  boolean getHipotecado(){
      return this.hipotecado;
  }
  
  int getAlquilerBase(){
      return this.alquilerBase;
  }
  
  float getFactorRevalorizacion(){
      return this.factorRevalorizacion;
  }
  
  int getHipotecaBase(){
      return this.hipotecaBase;
  }
  
  int getPrecioEdificar(){
      return this.precioEdificar;
  }
  
  Jugador getPropietario(){
      return this.propietario;
  }
  
  void setCasilla(Casilla casilla){
      this.casilla = casilla;
  }
  
  void setHipotecada(boolean hipotecada){
      this.hipotecado = hipotecada;
  }
  
  void setPropietario(Jugador propietario){
      this.propietario = propietario;
  }
  
  boolean propietarioEncarcelado(){

             

      return propietario.getEncarcelado();

  }
  
    
  void cobrarAlquiler(int coste){
      propietario.modificarSaldo(+coste);
  }
    
 public boolean tengoPropietario(){
      if(propietario != prueba){
      return true;
      }
      return false;
  }
  
  Casilla getCasilla(){
      return casilla;
  }
  
 @Override
public String toString() {
return "Propiedad{" + "Nombre de la calle =" + nombreCalle + ", Estado hipoteca =" + 
hipotecado +", Precio de Edificar =" + Integer.toString(precioEdificar) + ", Propietario =" + propietario.toString() + "}";
} 
  
}
