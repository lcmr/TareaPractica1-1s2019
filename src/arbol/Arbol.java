/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Julio - 2018
 */
package arbol;

import java.util.LinkedList;

/**
 * Clase que alberga todas las funciones definidas y las variables globales
 * declaradas.
 * @author erick
 */
public class Arbol implements Instruccion{
    /**
     * Lista de las instrucciones (Funciones y declaraciones de variables globales) que componen el archivo.
     */
    private final LinkedList<Instruccion> instrucciones;
    
    
    /**
     * Variable correspondiente a la instancia de la tabla de simbolos global que podrá ser accedida por cualquier función interpretada.
     */
    public TablaDeSimbolos tablaDeSimbolosGlobal;
    
    /**
     * Constructor de la clase Arbol
     * @param a Lista de instrucciones que conforman al Arbol
     */
    public Arbol(LinkedList<Instruccion> a) {
        instrucciones=a;
    }
    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna el valor producido por la operación que se ejecutó
     */    
    @Override
    public Object ejecutar(TablaDeSimbolos ts,Arbol ar) {
        
        tablaDeSimbolosGlobal = ts;
        System.out.println("Bloque: "+ts.profundidad);
        for(Instruccion ins:instrucciones){
            if(ins instanceof Declaracion){
                Declaracion d=(Declaracion)ins;
                d.ejecutar(ts, ar);
            }
            if(ins instanceof Arbol){
            	ts.profundidad++;
                ins.ejecutar(ts, (Arbol)ins);
            	ts.profundidad--;
            }
        }
        return null;
    }
    
}
