/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author AntonioJesús
 */
public class Jugador {
    private boolean encarcelado = false;
    private String nombre;
     int saldo;
    private Casilla casillaActual = new Casilla(0,1000,TipoCasilla.SALIDA);
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> titulos = new ArrayList();
    static int factorEspeculador = 1;
    
    public Jugador(String nombre){
        this.encarcelado = false;
        this.nombre = nombre;
        this.saldo = 7500;

    }
    
    public Jugador(Jugador j){
       this.encarcelado = j.encarcelado;
       this.nombre = j.nombre;
       this.saldo = j.saldo;
       this.casillaActual = j.casillaActual;
       this.cartaLibertad = j.cartaLibertad;
       this.titulos = j.titulos;
    }
    
    public Casilla getCasillaActual(){
        return this.casillaActual;
    }
    
    public boolean getEncarcelado(){
        return this.encarcelado;
    }
    
    void setCartaLibertad(Sorpresa carta){
        this.cartaLibertad = carta;
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
 

    
    public boolean tengoPropiedades(){
        return !titulos.isEmpty();
    }

    private int cuantasCasasHotelesTengo(){
        int total = 0;
        for(int i = 0;i<titulos.size();i++){
            
            total = total + titulos.get(i).getCasilla().getNumCasas() + titulos.get(i).getCasilla().getNumHoteles();
        }
        return total;
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        for(int it = 0; it < titulos.size(); it++){
           TituloPropiedad t = titulos.get(it);
           if(t == casilla.getTituloPropiedad()){
              titulos.get(it).setPropietario(null);
               titulos.remove(it);
           }   
       }
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
         
        for(int it = 0; it < titulos.size(); it++){
           TituloPropiedad t = titulos.get(it);
           if(t == casilla.getTituloPropiedad()){
              return true;
           }   
       }
       
    return false;
    }
    
     boolean tengoSaldo(int cantidad){
        return saldo >= cantidad;
    }
    
    boolean actualizarPosicion(Casilla casilla){
        if(casillaActual.getNumeroCasilla() > casilla.getNumeroCasilla()){
            modificarSaldo(1000);
        }
        
        setCasillaActual(casilla);
        
        if(casillaActual.soyEdificable()){
            
            boolean tengoPropietario = casillaActual.tengoPropietario();
            
            if(tengoPropietario){
                boolean pencarcelado = casillaActual.propietarioEncarcelado();
            
            if(!pencarcelado){
                
                
                modificarSaldo(-casillaActual.cobrarAlquiler());
            }
            
            }
            
        }
        
        
        else {            
            if(casillaActual.getTipo() == TipoCasilla.IMPUESTO){
                
                int coste = casillaActual.getCoste();
                pagarImpuestos(coste);
            }
            
        }
        return true;
    }
    
    boolean comprarTitulo(){
       if(casillaActual.soyEdificable()){
           if(!casillaActual.tengoPropietario()){
               int costeCompra = casillaActual.getCoste();
               if(costeCompra <= saldo){
                   
                   TituloPropiedad titulo = casillaActual.asignarPropietario(this);
                   titulos.add(titulo);
                   modificarSaldo(-costeCompra);
                   return true;
               }
           }
       }
       return false;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa aux = null;
        aux = cartaLibertad;
        cartaLibertad = null;
        return aux;
    }
    
    void irACarcel(Casilla casilla){
        setCasillaActual(casilla);
        setEncarcelado(true);
    }
    
    void modificarSaldo(int cantidad){
        this.saldo = saldo + cantidad;
    }
    
    int obtenerCapital(){
        int capital = saldo;
        for(int i=0;i<titulos.size();i++){
            if(titulos.get(i).getFactorRevalorizacion() > 0){
                int capitalTitulos = titulos.get(i).getAlquilerBase() + titulos.get(i).getCasilla().getNumCasas()*titulos.get(i).getPrecioEdificar() + (titulos.get(i).getCasilla().getNumHoteles()*(titulos.get(i).getPrecioEdificar())*5);
                capital = capital + capitalTitulos + capitalTitulos + (int)Math.floor(capitalTitulos*titulos.get(i).getFactorRevalorizacion()/100);
                }
            if(titulos.get(i).getFactorRevalorizacion()<0){
                 int capitalTitulos = titulos.get(i).getAlquilerBase() + titulos.get(i).getCasilla().getNumCasas()*titulos.get(i).getPrecioEdificar() + (titulos.get(i).getCasilla().getNumHoteles()*(titulos.get(i).getPrecioEdificar())*5);
                capital = capital + capitalTitulos + capitalTitulos - (int)Math.floor(capitalTitulos*titulos.get(i).getFactorRevalorizacion()/100);
            }
        }
        return capital;
    }

    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        
        ArrayList<TituloPropiedad> hipotecas = new ArrayList();
        for(int it = 0; it < titulos.size(); it++){
           TituloPropiedad t = titulos.get(it);
           if(t.getHipotecado() == hipotecada){
              hipotecas.add(t);
           }
        }
        return hipotecas;
    }
    
    boolean puedoVenderPropiedad(Casilla casilla){
        
        return esDeMiPropiedad(casilla) && casilla.getTituloPropiedad().getHipotecado() == false;
  
    }
    
    boolean tengoCartaLibertad(){
        return cartaLibertad!=null;
    }
    
    boolean puedoHipotecar(Casilla casilla){
     return   esDeMiPropiedad(casilla) && !casilla.estaHipotecado();
    }
    
    void venderPropiedad(Casilla casilla){
        if(esDeMiPropiedad(casilla)){
            casilla.venderTitulo();
        }
    }
    
    boolean pagarLibertad(int cantidad){
        boolean libre = tengoSaldo(cantidad);
        if(libre){
            modificarSaldo(-cantidad);
        }
        return libre;
    }
    
    boolean puedoEdificarCasa(Casilla casilla){
        if(esDeMiPropiedad(casilla)){
            int costeEdificarCasa = casilla.getPrecioEdificar();
            return tengoSaldo(costeEdificarCasa);
        }
        return false;
    }
    
    boolean puedoEdificarHotel(Casilla casilla){
        if(esDeMiPropiedad(casilla) && casilla.getNumCasas() == 4){
            int costeEdificarHotel = casilla.getPrecioEdificar();
            return tengoSaldo(costeEdificarHotel);
        }
        return false;
    }
    
    public String getName(){
        return this.nombre;
    }
    
    boolean puedoPagarHipoteca(Casilla casilla){
        
        return tengoSaldo(casilla.getCosteHipoteca());
        
    }
    
    void pagarCobrarPorCasaHotel(int cantidad){
        
        int numeroTotal = cuantasCasasHotelesTengo();
        modificarSaldo(numeroTotal*cantidad);
        
    }
    
  public boolean bancarrota(){
        return saldo <= 0;
    }

   Especulador convertirme(Jugador j,int fianza){
        
        Especulador esp = new Especulador(this,fianza);
        return esp;
    }
    
  void pagarImpuestos(int cantidad){
      modificarSaldo(-cantidad);
  }
    
@Override
public String toString() {
return "Jugador{" + "Nombre =" + nombre + ", ¿ésta en la carcel? =" + 
encarcelado + ", saldo =" + saldo + "}";
}  
    
    
    
    
    
    
    
    
    
}
