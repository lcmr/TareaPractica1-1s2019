package arbol;

import java.util.LinkedList;

public class Ambito  implements Instruccion{

    /**
     * Tipo de la variable que será declarada.
     */
    Simbolo.Tipo tipo;
    

    /**
     * Parámetros de la función.
     */
    private final LinkedList<Declaracion> variables;
    /**
     * Constructor de la clase
     * @param a Identificador de la variable que será declarada
     * @param b Tipo de la clase que será declarada
     */
    public Ambito(String a, LinkedList<Declaracion> b) {
        variables = b;
    }
    
    
    
	@Override
	public Object ejecutar(TablaDeSimbolos ts,Arbol ar) {
		TablaDeSimbolos tablaLocal=new TablaDeSimbolos(); // Creamos una nueva tabla local para la función.
        tablaLocal.addAll(ar.tablaDeSimbolosGlobal); // Agregamos a la tabla local las referencias a las variables globales.
        for(int i=0;i<variables.size();i++){
            Declaracion d=variables.get(i); 
            d.ejecutar(tablaLocal, ar);
        }     
        return null;
	}

}
