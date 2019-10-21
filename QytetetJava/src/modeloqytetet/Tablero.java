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
public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList();
    private ArrayList<TituloPropiedad> titulos = new ArrayList();
    private Casilla carcel = new Casilla(5,0,TipoCasilla.CARCEL);
    
    public Tablero(){
        
        inicializar();
    }
    
    private void inicializar(){
        
        titulos.add( new TituloPropiedad("Joe maxo",50,150,250, 10));
        titulos.add( new TituloPropiedad("Calle LitroEuro",55,200,300, 11));
        titulos.add(  new TituloPropiedad("Villa Ricky And Martin",60,250,350, 13));
        titulos.add( new TituloPropiedad("Calle Twich Plus Prime Premium",65,300,400, 18));
        titulos.add( new TituloPropiedad("Calle Indiependiente",70,350,450, 20));
        titulos.add( new TituloPropiedad("Villa Juegos de Video",75,400,500, -10));
        titulos.add( new TituloPropiedad("Calle Prado Caido",80,450,550, -13));
        titulos.add( new TituloPropiedad("Villa SHHH",85,500,600, -15));
        titulos.add( new TituloPropiedad("Calle Git Gu",90,600,650, -18 ));
        titulos.add( new TituloPropiedad("Villa Fantas Paga",95,700,700, -20));
        titulos.add( new TituloPropiedad("Calle Pokachu",100,850,750,20));
        titulos.add( new TituloPropiedad("Calle Don Arturo",100,1000,750,15));
        
        casillas.add(new Casilla(0,1000,TipoCasilla.SALIDA));
        casillas.add(new Casilla(1,1500,titulos.get(0)));
        casillas.add(new Casilla(2,2000,titulos.get(1)));
        casillas.add(new Casilla(3,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(4,2500,titulos.get(2)));
        casillas.add(carcel);
        casillas.add(new Casilla(6,3000,titulos.get(3)));
        casillas.add(new Casilla(7,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(8,3500,titulos.get(4)));
        casillas.add(new Casilla(9,4000,titulos.get(5)));
        casillas.add(new Casilla(10,0,TipoCasilla.PARKING));
        casillas.add(new Casilla(11,4500,titulos.get(6)));
        casillas.add(new Casilla(12,5000,titulos.get(7)));
        casillas.add(new Casilla(13,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(14,6000,titulos.get(8)));       
        casillas.add(new Casilla(15,0,TipoCasilla.JUEZ));
        casillas.add(new Casilla(16,7000,titulos.get(9)));
        casillas.add(new Casilla(17,8500,titulos.get(10)));
        casillas.add(new Casilla(18,10000,titulos.get(11)));
        casillas.add(new Casilla(19,1000,TipoCasilla.IMPUESTO));
        
        titulos.get(0).setCasilla(casillas.get(1));
        titulos.get(1).setCasilla(casillas.get(2));
        titulos.get(2).setCasilla(casillas.get(4));
        titulos.get(3).setCasilla(casillas.get(6));
        titulos.get(4).setCasilla(casillas.get(8));
        titulos.get(5).setCasilla(casillas.get(9));
        titulos.get(6).setCasilla(casillas.get(11));
        titulos.get(7).setCasilla(casillas.get(12));
        titulos.get(8).setCasilla(casillas.get(14));
        titulos.get(9).setCasilla(casillas.get(16));
        titulos.get(10).setCasilla(casillas.get(17));
        titulos.get(11).setCasilla(casillas.get(18));

       
        
    }

Casilla getCarcel(){
    
    return this.carcel;
    
}

boolean esCasillaCarcel(int n){
    if(n==5) return true;
    else return false;
}

Casilla obtenerCasillaNumero(int Casilla){
    if(Casilla > 19){
        return null;
    }
    Casilla T = casillas.get(0+Casilla);
     
     return T;
}


Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
    int base = casilla.getNumeroCasilla();
    base = base + desplazamiento;
    if(base > 19){
        int vecesPasadoTablero = base/20;
        base = base - 20*vecesPasadoTablero;
    }
    Casilla T = casillas.get(base);
    return T;
    
}


    @Override
public String toString() {
return "Tablero{" + "Carcel =" + carcel + ", Casillas =" + 
casillas + "}";
} 
    
}
