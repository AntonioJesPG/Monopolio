/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazTextualQytetet;
import java.util.ArrayList;
import java.util.Scanner;
import modeloqytetet.*;
/**
 *
 * @author AntonioJesús
 */
public class ControladorQytetet {
    
    private static final Scanner in = new Scanner (System.in);
    VistaTextualQytetet vista = new VistaTextualQytetet();
    Jugador jugadorActual;
    Casilla casillaActual;
    Qytetet qytetet;
    
    public void desarrolloJuego(){
        
      boolean finJuego = false;
      while(finJuego == false){
      
          vista.mostrar("\n" + jugadorActual.toString() + "\n" + Integer.toString(jugadorActual.getCasillaActual().getNumeroCasilla()) + "\n Pulse una tecla para continuar");
           in.nextLine();
          
          if(jugadorActual.getEncarcelado()){
              
              vista.mostrar("\n Se encuentra en la carcel" );
              int valor = vista.menuSalirCarcel();
              if(valor == 0){
                 qytetet.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                 
              }
              else{
                  qytetet.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
              }
              boolean carcel = jugadorActual.getEncarcelado();
              
              if(carcel == true){
                  vista.mostrar("\n Usted sigue encarcelado, pulse cualquier tecla para pasar su turno");
                   in.nextLine();
              }
              else{
                  vista.mostrar("\n Ha conseguido salir de la carcel con éxito, su estado actual es : " + jugadorActual.toString() + "\n  Pulse cualquier tecla para moverse");
                   in.nextLine();
              } 
            
              if(!carcel){
                  
                  qytetet.jugar();
                  casillaActual = jugadorActual.getCasillaActual();
                  if(casillaActual.getTipo() == TipoCasilla.SORPRESA){
                      vista.mostrar("\n Se ha cojido la siguiente carta sorpresa : " +  qytetet.toString() + "\n Pulse una tecla para continuar");
                      in.nextLine();
                      qytetet.aplicarSorpresa();
                      vista.mostrar("\n El nuevo estado del jugador tras aplicar la sorpresa es : " + jugadorActual.toString() + "\n Pulse una tecla para continuar");
                      in.nextLine();
                  }
                  
                  if(casillaActual.getTipo() == TipoCasilla.PARKING){
                      vista.mostrar("\n Se encuentra visitando el parking, pulse una tecla para seguir");
                      in.nextLine();
                  }
                  if(casillaActual.getTipo() == TipoCasilla.JUEZ){
                      vista.mostrar("\n El juez le ha enviado a la carcel, pulse una tecla para continuar");
                      in.nextLine();
                  }
                  if(casillaActual.getTipo() == TipoCasilla.CARCEL){
                      vista.mostrar("\n Esta de visita en la carcel, pulse una tecla para continuar");
                      in.nextLine();
                  }
                  if(casillaActual.getTipo() == TipoCasilla.SALIDA){
                      vista.mostrar("\n Esta en la salida del tablero, pulse una tecla para continuar");
                      in.nextLine();
                  }
                  if(casillaActual.getTipo() == TipoCasilla.IMPUESTO){
                      vista.mostrar("\n Ha de pagar los impuestos y su nuevo estado es : " + jugadorActual.toString() + "\n Pulse una tecla para continuar");
                      in.nextLine();
                  }
                  
                  if(casillaActual.getTipo()== TipoCasilla.CALLE){
                      vista.mostrar("\n Has caido en la siguiente calle : " + casillaActual.toString() + "\n" + casillaActual.getTituloPropiedad().toString() +  "\n Pulsa una tecla para continuar");
                      in.nextLine();
                      if(!casillaActual.getTituloPropiedad().tengoPropietario()){
                          vista.mostrar("\n Puedes comprar este lugar ya que no tiene propietario y dispones de saldo, pulsa una tecla decidir si comprar o no");
                          in.nextLine();
                          boolean comprar = vista.elegirQuieroComprar();
                          if(comprar){
                              qytetet.comprarTituloPropiedad();
                              vista.mostrar("\n Has comprado el siguiente titulo : " + casillaActual.getTituloPropiedad().toString() + "\n Tu estado actual es : "  + jugadorActual.toString() + "\n Pulsa una tecla para continuar");
                              in.nextLine();
                          }
                          else{
                              vista.mostrar("\n Has decidido no comprar, pulsa una tecla para continuar");
                              in.nextLine();
                          }                                                    
                      }
                      else{
                          
                          vista.mostrar("\n Esta casilla tiene propietario : " + casillaActual.toString() + "\n" + casillaActual.getTituloPropiedad().toString() + "\n Has de pagar el alquiler de modo que tu nuevo estado es : " + jugadorActual.toString() + "\n pulsa una tecla para continuar.");
                          in.nextLine();
                          
                      }
                      
                  }
                  
                  if(jugadorActual.tengoPropiedades() && !jugadorActual.bancarrota() && !jugadorActual.getEncarcelado()){
                     
                     int    gestion  =  vista.menuGestionInmobiliaria();
                          switch(gestion){
                              
                              case 1 : 
                                        ArrayList<String>nombresCasa = new ArrayList();
                                      for(int i = 0; i < qytetet.propiedadesHipotecadasPorJugador(false).size() ; i++){
                                       nombresCasa.add(qytetet.propiedadesHipotecadasPorJugador(false).get(i).getTituloPropiedad().getNombre());
                                      }
                                      int casa =  vista.menuElegirPropiedad(nombresCasa);
                                      if(qytetet.edificarCasa(qytetet.propiedadesHipotecadasPorJugador(false).get(casa))){
                                            
                                      vista.mostrar( "\n Casilla en la que se ha edificado : " + 
                                              qytetet.propiedadesHipotecadasPorJugador(false).get(casa).toString() +  "\n Su propietario y saldo son : " + jugadorActual.toString()
                                               + "\n Pulse una tecla para continuar.");
                                      in.nextLine();
                                      }
                                     else{
                                          vista.mostrar("\n No se ha podido edificar la casa, pulse una tecla para continuar");
                                          in.nextLine();
                                      } 
                                      break;
                              
                              case 2 : 
                                        ArrayList<String>nombresHotel = new ArrayList();
                                      for(int i = 0; i < qytetet.propiedadesHipotecadasPorJugador(false).size() ; i++){
                                       nombresHotel.add(qytetet.propiedadesHipotecadasPorJugador(false).get(i).getTituloPropiedad().getNombre());
                                      }
                                      int hotel =  vista.menuElegirPropiedad(nombresHotel);
                                      if(qytetet.edificarCasa(qytetet.propiedadesHipotecadasPorJugador(false).get(hotel))){                                      
                                       vista.mostrar("\n Hoteles edificados : 1" + "\n Número de casas actualmente : 0 " + "\n Casilla en la que se ha edificado : " + 
                                              qytetet.propiedadesHipotecadasPorJugador(false).get(hotel).toString() + "\n Su propietario y su saldo son : " + jugadorActual.toString()
                                               + "\n Pulse una tecla para continuar.");
                                      in.nextLine();
                                      }
                                      else{
                                          vista.mostrar("\n No se ha podido edificar el hotel, pulse una tecla para continuar");
                                          in.nextLine();
                                      } 
                                     
                                            break;
                                            
                              case 3 : 
                                        ArrayList<String>nombresVenta= new ArrayList();
                                      for(int i = 0; i < qytetet.propiedadesHipotecadasPorJugador(false).size() ; i++){
                                       nombresVenta.add(qytetet.propiedadesHipotecadasPorJugador(false).get(i).getTituloPropiedad().getNombre());
                                      }
                                      int venta =  vista.menuElegirPropiedad(nombresVenta);
                                      if(qytetet.venderPropiedad(qytetet.propiedadesHipotecadasPorJugador(false).get(venta))){
                                          vista.mostrar("\n La propiedad : " + qytetet.propiedadesHipotecadasPorJugador(false).get(venta).toString() +  " se ha vendido satisfactoriamente" + "\n Su saldo actual es : " + jugadorActual.toString() + "\n Pulse una tecla para continuar");
                                      }
                                       else{
                                          vista.mostrar("\n No se ha podido vender la propiedad, pulse una tecla para continuar");
                                          in.nextLine();
                                      } 
                                      
                                      
                                            break;
                                            
                              case 4 : 
                                         ArrayList<String>nombresHipo= new ArrayList();
                                      for(int i = 0; i < qytetet.propiedadesHipotecadasPorJugador(false).size() ; i++){
                                       nombresHipo.add(qytetet.propiedadesHipotecadasPorJugador(false).get(i).getTituloPropiedad().getNombre());
                                      }
                                      int hipo =  vista.menuElegirPropiedad(nombresHipo);
                                      if(qytetet.hipotecarPropiedad(qytetet.propiedadesHipotecadasPorJugador(false).get(hipo))){
                                               vista.mostrar("\n La propiedad : " + qytetet.propiedadesHipotecadasPorJugador(false).get(hipo).toString() +  " se ha hipotecado satisfactoriamente" + "\n Su saldo actual es : " + jugadorActual.toString() + "\n Pulse una tecla para continuar");
                                      }
                                       else{
                                          vista.mostrar("\n No se ha podido hipotecar la propiedad, pulse una tecla para continuar");
                                          in.nextLine();
                                      } 
                                      
                                            break;
                                            
                              case 5 :
                                         ArrayList<String>nombresCancel= new ArrayList();
                                      for(int i = 0; i < qytetet.propiedadesHipotecadasPorJugador(true).size() ; i++){
                                       nombresCancel.add(qytetet.propiedadesHipotecadasPorJugador(true).get(i).getTituloPropiedad().getNombre());
                                      }
                                      int cancel =  vista.menuElegirPropiedad(nombresCancel);
                                      if(qytetet.cancelarHipoteca(qytetet.propiedadesHipotecadasPorJugador(true).get(cancel))){
                                           vista.mostrar("\n La propiedad : " + qytetet.propiedadesHipotecadasPorJugador(false).get(cancel).toString() +  " ha dejado de estar hipotecada" + "\n Su saldo actual es : " + jugadorActual.toString() + "\n Pulse una tecla para continuar");
                                      }
                                       else{
                                          vista.mostrar("\n No se ha podido cancelar la hipoteca, pulse una tecla para continuar");
                                          in.nextLine();
                                      }     
                                      
                                            break;
                              
                              default :              
                                            
                                            break;
                          }
                          
                      }
                  }
                  
              }
              
      
          
          
          qytetet.siguienteJugador();
          jugadorActual = qytetet.getJugadorActual();
      }
      
       ArrayList<String> ranking = qytetet.obtenerRanking();
      for(int i = 0 ; i < ranking.size(); i++){
          
          vista.mostrar("\n" + ranking.get(i));
          
      }
}
    
    public void inicializacionJuego(){
        qytetet = Qytetet.getInstance();
        ArrayList<String> nombres = vista.obtenerNombreJugadores();
        qytetet.inicializarJuego(nombres);
        vista.mostrar("\n" + "Tablero : 20 casillas" + "\n" + "Mazo : 10 cartas" + "\n" + "jugador que comienza : " + qytetet.getJugadorActual().getName() + "\n" + "Casilla Actual : 0" + "\n Pulse una tecla para continuar");
        in.nextLine();
    }
    
    public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){
    //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
     //luego llama a la vista para que el usuario pueda elegir.
       vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades= new ArrayList();
        for ( Casilla casilla: propiedades) {
                listaPropiedades.add( "\t"+casilla.getNumeroCasilla()+"\t"+casilla.getTituloPropiedad().getNombre()); 
        }
        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
        return propiedades.get(seleccion);
         }
 
        public void main(String[] args) {
            ControladorQytetet q = new ControladorQytetet();
            q.inicializacionJuego();
            q.desarrolloJuego();
            
        }
    
}
        
        
   
    

