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
public  class Casilla {
    
     int numeroCasilla;
     int coste;
     TipoCasilla tipo;
     int numCasas = 0;
     int numHoteles = 0;
     TituloPropiedad titulo;
    
    public Casilla(int numeroCasilla, int coste, TituloPropiedad titulo){
        
       this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = TipoCasilla.CALLE;
        this.titulo = titulo;

        
    }
    
      
    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo){
        
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
    }
    
      public int getNumeroCasilla(){
        return this.numeroCasilla;
    }
    
    int getCoste(){
        return this.coste;
    }
    
    
    public TipoCasilla getTipo(){
        return this.tipo;
    }

    void AñadirHoteles(int cantidad){
        this.numHoteles = this.numHoteles + cantidad;
    }
    void AñadirCasas(int cantidad){
        this.numCasas = this.numCasas + cantidad;
    }
    int getNumHoteles(){
        return this.numHoteles;
    }
    int getNumCasas(){
        return this.numCasas;
    }
    public TituloPropiedad getTituloPropiedad(){
        return this.titulo;
    }
     void setNumCasas(int numeroNuevo){
        this.numCasas = numeroNuevo;
    }
     void setNumHoteles(int numeroNuevo){
        this.numHoteles = numeroNuevo;
    }
     void setTituloPropiedad(TituloPropiedad titulo){
         if(getTipo()==TipoCasilla.CALLE){
             this.titulo = titulo;
     }
     }
     void asignarTituloPropiedad(){
        if(this.tipo == TipoCasilla.CALLE){
        titulo.setCasilla(this);
        }
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        titulo.setPropietario(jugador);
        return titulo;
    }
    int calcularValorHipoteca(){
        int hipotecaBase = titulo.getHipotecaBase();
        int valor = hipotecaBase + (int)Math.floor(numCasas*0.5*hipotecaBase + numHoteles*hipotecaBase);
        return valor;
    }
    int cancelarHipoteca(){
        titulo.setHipotecada(false);
        return calcularValorHipoteca();
    }
    int cobrarAlquiler(){
        int costeAlquilerBase = titulo.getAlquilerBase();
        int costeAlquilerTotal = costeAlquilerBase + (int)Math.floor(numCasas*0.5+numHoteles*2);
        titulo.cobrarAlquiler(costeAlquilerTotal);
        return costeAlquilerTotal;
    }
     
    int edificarCasa(){
        setNumCasas(numCasas+1);
        return titulo.getPrecioEdificar();
    }
    int edificarHotel(){
         setNumHoteles(numHoteles+1);
         setNumCasas(0);
         return titulo.getPrecioEdificar();
    }
    boolean estaHipotecado(){
       return titulo.getHipotecado();
    }
    int getCosteHipoteca(){
        return calcularValorHipoteca();
    }
    int getPrecioEdificar(){
       return titulo.getPrecioEdificar();
    }
    int hipotecar(){
        
        titulo.setHipotecada(true);
        return calcularValorHipoteca();
    }
    boolean propietarioEncarcelado(){

        return titulo.propietarioEncarcelado();

    }
    boolean sePuedeEdificarCasa(){
        return numCasas < 4*titulo.getPropietario().factorEspeculador;
    }
   
    boolean sePuedeEdificarHotel( ){
    return numHoteles <  4*titulo.getPropietario().factorEspeculador ;
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
   
    int venderTitulo(){
        
        
        int precioCompra = coste +(numCasas + numHoteles)*titulo.getPrecioEdificar();
        setNumHoteles(0);
        setNumCasas(0);
        titulo.setPropietario(null);
        int precioVenta = (int)Math.floor(precioCompra+ titulo.getFactorRevalorizacion()*precioCompra);
        return precioVenta;
    }

    boolean soyEdificable(){
        return tipo == TipoCasilla.CALLE;
    }

    
    @Override
    public String toString(){
        if(tipo == TipoCasilla.CALLE){
            if(titulo.tengoPropietario()){
                 return "Calle{" + "Titulo=" + titulo.getNombre()+ "\n Numero de la casilla =" + 
                    Integer.toString(numeroCasilla) + "\n Propietario =" + titulo.getPropietario().getName() + "\n Coste =" + 
                    Integer.toString(coste) +"\n Numero de Casas =" + 
                    Integer.toString(numCasas) +"\n Numero de Hoteles =" + 
                    Integer.toString(numHoteles) +"\n tipo=" + tipo.toString() 
            +  "}";
                
            }
            else{
                
                 return "Calle{" + "Titulo=" + titulo.getNombre()+ "\n Numero de la casilla =" + 
                    Integer.toString(numeroCasilla) + " \n Coste =" + 
                    Integer.toString(coste) +"\n Numero de Casas =" + 
                    Integer.toString(numCasas) +"\n Numero de Hoteles =" + 
                    Integer.toString(numHoteles) +"\n tipo=" + tipo.toString() 
                            +  "}";
            }
   
        
    }

        else {
            return "Casilla{" + "Numero de la casilla =" + 
Integer.toString(numeroCasilla) + ", tipo= " + tipo.toString() + "coste =" + Integer.toString(coste) + "}";
    
        }
    }
}    
    
    
   
