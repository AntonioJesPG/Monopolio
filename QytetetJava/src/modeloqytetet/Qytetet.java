/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import GUIQytetet.Dado;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author AntonioJesús
 */
public class Qytetet {
    private static ArrayList<Sorpresa> mazo = new ArrayList();
    private static ArrayList<Jugador> jugadores = new ArrayList();
    public final static int MAXJUGADORES = 3;
    static final int MAXCARTAS = 10;
    static final int MAXCASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;
    int turnos = 0;
    Sorpresa cartaActual = null;
    Jugador jugadorActual;
    Tablero t;
    
    
    
    
    
private static final Qytetet instance = new Qytetet();
 private Qytetet() { }
 public static Qytetet getInstance() {
 return instance;
 }
 
 public Sorpresa getCartaActual(){
     return this.cartaActual;
 }
 
 public Jugador getJugadorActual(){
     return this.jugadorActual;
 }
 
 private void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa("Rick Sanchez te esta atracando, pierdes 4000 dollars pero puedes sacarle una foto",TipoSorpresa.PAGARCOBRAR,4000));
        mazo.add(new Sorpresa("El otro Manuel se acerca a ti en silencio , recibes un bollo y un euro",TipoSorpresa.PAGARCOBRAR,1));
        mazo.add(new Sorpresa("Prado se encuentra fuera de servicio, vaya a la casilla número 4 para intentar arreglarlo",TipoSorpresa.IRACASILLA,4));
        mazo.add(new Sorpresa("Tu horóscopo de twitter dice que el 19 es tu número de la suerte así que ve a ver si es verdad",TipoSorpresa.IRACASILLA,19));
        mazo.add(new Sorpresa("Ha sido sorprendido escribiendo incorrectamente ventrílocuo y la RAE le condena a ir a prisión", TipoSorpresa.IRACASILLA, 5));
        mazo.add(new Sorpresa("Atracas a todos los jugadores al grito de: ¡Arriba los atracos esto es una mano! y como les has dado un poco de pena te dan 350 dollars cada uno",TipoSorpresa.PORJUGADOR, -350));
        mazo.add(new Sorpresa("¡Saca el látigo, es hora de cobrar a los inquilinos!",TipoSorpresa.PORCASAHOTEL,250));
        mazo.add(new Sorpresa("Un empleado de hacienda entra a tu casa con escopeta en mano, toca pagar",TipoSorpresa.PORCASAHOTEL,200));
        mazo.add(new Sorpresa("Debes pagarle 200 dollars a todos los jugadores por tener que aguantar mirarte a la cara",TipoSorpresa.PORJUGADOR,200));
        mazo.add(new Sorpresa ("Vuestra persona va a ser convertida en espeteculador",TipoSorpresa.CONVERTIRME,3000));
        mazo.add(new Sorpresa ("Especulo que se va a convertir en especulador",TipoSorpresa.CONVERTIRME,5000));
        Collections.shuffle(mazo);
 }
 
 private void inicializarJugadores(ArrayList<String> nombres){
     for(int it = 0; it < nombres.size(); it++){
           String n = nombres.get(it);
     jugadores.add(new Jugador(n));
     Collections.shuffle(jugadores);
 }    
 
}
 
 private void inicializarTablero(){
     t = new Tablero();
 }
 


 
 public boolean aplicarSorpresa(){
     boolean tienePropietario = false;
     if(cartaActual.getTipo() == TipoSorpresa.CONVERTIRME){
         jugadorActual = jugadorActual.convertirme(jugadorActual,cartaActual.getValor());
         return true;
     }
     else{
     if(cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
         jugadorActual.modificarSaldo(cartaActual.getValor());
         return true;
     }
     if(cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
         if(t.esCasillaCarcel(cartaActual.getValor())){
             encarcelarJugador();
             return true;
         }
         else{
           tienePropietario =  jugadorActual.actualizarPosicion(t.obtenerCasillaNumero(cartaActual.getValor()));
         }
         
     }
     if(cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
         jugadorActual.pagarCobrarPorCasaHotel(cartaActual.getValor());
         return true;
     }
     if(cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
         
         for(int i = 0; i<jugadores.size();i++){
             
             if(jugadorActual != jugadores.get(i)){
                 
                 jugadores.get(i).modificarSaldo(cartaActual.getValor());
                 jugadorActual.modificarSaldo(-cartaActual.getValor());
                 
             }
             
         }
         return true;
     }
     if(cartaActual.getTipo() == TipoSorpresa.SALIDACARCEL){
         
         jugadorActual.setCartaLibertad(cartaActual);
         return true;
     }
     if(cartaActual.getTipo() != TipoSorpresa.SALIDACARCEL){
         
         mazo.add(cartaActual);
         return true;
     }
     }    
     return tienePropietario;
     
 }
 
 public boolean cancelarHipoteca(Casilla casilla){
     boolean sePuedeCancelarHipotecar =casilla.estaHipotecado() &&  casilla.getTituloPropiedad().getPropietario() == jugadorActual;
     if(sePuedeCancelarHipotecar){
     int cantidadAPagar= (int)Math.floor(casilla.cancelarHipoteca()*1.1);
     this.jugadorActual.modificarSaldo(-cantidadAPagar);
     }
     return sePuedeCancelarHipotecar;
 }
 
 public boolean comprarTituloPropiedad(){

     return jugadorActual.comprarTitulo();
     
 }
 
 public boolean edificarCasa(Casilla casilla){
     if(casilla.soyEdificable()){
         
         if(casilla.sePuedeEdificarCasa()){
         
         if(jugadorActual.puedoEdificarCasa(casilla)){
             
             int costeEdificarCasa = casilla.edificarCasa();
             jugadorActual.modificarSaldo(-costeEdificarCasa);

         }        
         }
         return true;
     }
     
     return false;
 }
 
 public boolean edificarHotel(Casilla casilla){
         if(casilla.soyEdificable()){
         
         if(casilla.sePuedeEdificarHotel()){
         
         if(jugadorActual.puedoEdificarHotel(casilla)){
             
             int costeEdificarHotel = casilla.edificarHotel();
             jugadorActual.modificarSaldo(-costeEdificarHotel);

         }        
         }
         return true;
     }
     
     return false;
 }
 
 public boolean hipotecarPropiedad(Casilla casilla){
     boolean sePuedeHipotecar = casilla.soyEdificable() && !casilla.estaHipotecado() &&  this.jugadorActual.puedoHipotecar(casilla);
     if(sePuedeHipotecar){
     int cantidadRecibida = casilla.hipotecar();
     this.jugadorActual.modificarSaldo(cantidadRecibida);
     }
     return sePuedeHipotecar;
    
 }
 
 public void inicializarJuego(ArrayList<String> nombres){
     
     inicializarJugadores(nombres);
     inicializarCartasSorpresa();
     inicializarTablero();
     salidaJugadores();
 }
 
 public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
     
     boolean libre = false;
     
     if(metodo == MetodoSalirCarcel.TIRANDODADO){
         Dado dado = GUIQytetet.Dado.getInstance();
         int valorDado = dado.nextNumber();
         libre = valorDado > 5;
     }
     else{
         if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
             libre = jugadorActual.pagarLibertad(Qytetet.PRECIO_LIBERTAD);
         }
     }
     
     if(libre){
         jugadorActual.setEncarcelado(false);
     }
     return libre;
 }
 
 public boolean jugar(){
      Dado dado = GUIQytetet.Dado.getInstance();
     int valorDado = dado.nextNumber();
     Casilla casillaPosicion = jugadorActual.getCasillaActual();
     Casilla nuevaCasilla = t.obtenerNuevaCasilla(casillaPosicion, valorDado);
     jugadorActual.actualizarPosicion(nuevaCasilla);
     if(!nuevaCasilla.soyEdificable()){
         if(nuevaCasilla.getTipo() == TipoCasilla.JUEZ || nuevaCasilla.getTipo() == TipoCasilla.CARCEL){
             encarcelarJugador();
             return false;
         }
         else
             if(nuevaCasilla.getTipo() == TipoCasilla.SORPRESA){
                 if(mazo.isEmpty()){
                     inicializarCartasSorpresa();
                 }
                 cartaActual = mazo.get(0);
                 aplicarSorpresa();
                 return false;
             }
             if(nuevaCasilla.getTipo() == TipoCasilla.CALLE){
                 return nuevaCasilla.tengoPropietario();
             }
     }
     
     return false;
 }
 
 public ArrayList<String> obtenerRanking(){
    ArrayList<String> ranking = new ArrayList();
     for(int i = 0; i < jugadores.size();i++){
         Jugador j = jugadores.get(i);
         String capital = Integer.toString((j.obtenerCapital()));
         ranking.add(j.getName()+"    " +capital);
     }
     return ranking;
 }
 
 public ArrayList<Casilla> propiedadesHipotecadasPorJugador(boolean hipotecadas){
    ArrayList<TituloPropiedad> tit = jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas);
    ArrayList<Casilla> hipotecadasJugador = new ArrayList();
    for(int i=0;i<20;i++){
        for(int j = 0; j<tit.size();j++){
            if(t.obtenerCasillaNumero(i).getTituloPropiedad()== tit.get(j)){
                 hipotecadasJugador.add(t.obtenerCasillaNumero(i));
            }
        }
    }
    return hipotecadasJugador;
 }
 
 public Jugador siguienteJugador(){
     jugadores.add(jugadorActual);
     jugadorActual = jugadores.remove(0);
     return jugadorActual;
 }
 
 public boolean venderPropiedad(Casilla casilla){
     
     boolean puedoVender = jugadorActual.puedoVenderPropiedad(casilla);
     jugadorActual.venderPropiedad(casilla);
     
     
     return puedoVender;
 }
 
 public void encarcelarJugador(){
     if(!jugadorActual.tengoCartaLibertad()){
         Casilla casillaCarcel = t.getCarcel();
         jugadorActual.irACarcel(casillaCarcel);
     }
     else{
         Sorpresa s = jugadorActual.devolverCartaLibertad();
         mazo.add(s);
     }
 }
 
 private void salidaJugadores(){
     for(int i = 0 ; i < jugadores.size(); i++){
         Casilla inicio = t.obtenerCasillaNumero(0);
         jugadores.get(i).actualizarPosicion(inicio);
         
     }
     
     jugadorActual = jugadores.remove(0);
     
 }
 
 
 ArrayList<Jugador> getJugadores(){
     return jugadores;
 }
 
     @Override
public String toString() {
return  cartaActual.toString();
} 
 
}
