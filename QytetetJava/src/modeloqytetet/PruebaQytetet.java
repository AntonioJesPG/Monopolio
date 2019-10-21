/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author antoniojespg
 */
public class PruebaQytetet {
    //RUEBAS DE OTRAS PRACTICAS
    /*
    private static ArrayList<Sorpresa> mazo = new  ArrayList();

    
    

    private static void inicializarSorpresa(){
        mazo.add(new Sorpresa("Rick Sanchez te esta atracando, pierdes 4000 dollars pero puedes sacarle una foto",TipoSorpresa.PAGARCOBRAR,4000));
        mazo.add(new Sorpresa("El otro Manuel se acerca a ti en silencio , recibes un bollo y un euro",TipoSorpresa.PAGARCOBRAR,1));
        mazo.add(new Sorpresa("Prado se encuentra fuera de servicio, vaya a la casilla número 4 para intentar arreglarlo",TipoSorpresa.IRACASILLA,4));
        mazo.add(new Sorpresa("Tu horóscopo de twitter dice que el 19 es tu número de la suerte así que ve a ver si es verdad",TipoSorpresa.IRACASILLA,19));
        mazo.add(new Sorpresa("Ha sido sorprendido escribiendo incorrectamente ventrílocuo y la RAE le condena a ir a prisión", TipoSorpresa.IRACASILLA, 9));
        mazo.add(new Sorpresa("Atracas a todos los jugadores al grito de: ¡Arriba los atracos esto es una mano! y como les has dado un poco de pena te dan 350 dollars cada uno",TipoSorpresa.PORJUGADOR, 350));
        mazo.add(new Sorpresa("¡Saca el látigo, es hora de cobrar a los inquilinos!",TipoSorpresa.PORCASAHOTEL,250));
        mazo.add(new Sorpresa("Un empleado de hacienda entra a tu casa con escopeta en mano, toca pagar",TipoSorpresa.PORCASAHOTEL,200));
        mazo.add(new Sorpresa("Debes pagarle 200 dollars a todos los jugadores por tener que aguantar mirarte a la cara",TipoSorpresa.PORJUGADOR,200));
        mazo.add(new Sorpresa ("Don Arturo Pérez-Reverte y la RAE le permiten abandonar la prisión siempre que no vuelva a cometer los mismos errores de escritura.", TipoSorpresa.SALIDACARCEL, 0));
    }
   
    private  static void mayorCero(ArrayList<Sorpresa> S){
        
       for(int it = 0; it < S.size(); it++){
           Sorpresa T = S.get(it);
           if(T.getValor() > 0){
              System.out.println("Mayores que 0 son : " + T);
           }   
       }
       
    }
    
      private  static void irACasilla(ArrayList<Sorpresa> S){
       
          
       for(int it = 0; it < S.size(); it++){
           Sorpresa T = S.get(it);
           if(T.getTipo() == TipoSorpresa.IRACASILLA){
               System.out.println("Nos piden ir a cierta casilla : " + T);
           }   
       }
       
    }
      
      private static void tipoDeterminado (ArrayList<Sorpresa> S, TipoSorpresa TS){
          
          ArrayList<Sorpresa> tipo = new ArrayList();
          
          for(int it = 0; it < S.size(); it++){
              Sorpresa T = S.get(it);
              if(T.getTipo() == TS){
                tipo.add(T);
          }
          }
          System.out.println(" Con el tipo de sorpresa " + TS + " tenemos a " + tipo);
      }
    /**
     * @param args the command line arguments
     */
      
      
     //PRUEBAS code 
      
      
    public static void main(String[] args) {
        
        //PRUEBAS DE OTRAS PRACTICAS
        /*
        inicializarSorpresa();        
        mayorCero(mazo);
        irACasilla(mazo);
        tipoDeterminado(mazo,TipoSorpresa.PAGARCOBRAR);
        tipoDeterminado(mazo,TipoSorpresa.IRACASILLA);
        tipoDeterminado(mazo,TipoSorpresa.PORCASAHOTEL);
        tipoDeterminado(mazo,TipoSorpresa.PORJUGADOR);
        tipoDeterminado(mazo,TipoSorpresa.SALIDACARCEL);
                */
        /*
        System.out.println("Pruebas SORPRESAS");
        System.out.println(mazo.toString());
        
        
        System.out.println("Pruebas TABLEROS");
        System.out.println(t.toString());
        
        
        
        System.out.println("Pruebas Jugador");
        System.out.println(j.toString());
        
       System.out.println("Prueba Qytetet");
       System.out.println(Qytetet.getInstance().toString());
    
        
        */
    // t.getCarcel(); //PRUEBA CARCEL TABLERO

    }
    
    
   
    
}
