package program;


import arbol.Arbol;
import arbol.TablaDeSimbolos;
import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        interpretar("entrada.txt");
	}

    /**
     * Método que lee el contenido de un archivo de texto y ejecuta las 
     * instrucciones que contiene.
     * @param path ruta del archivo de texto que se desea interpretar
     */
    private static void interpretar(String path) {
        parser.parser pars;
        Arbol AST_arbolSintaxisAbstracta=null;
        try {
            pars=new parser.parser(new parser.Lexico(new FileInputStream(path)));
            pars.parse();        
            AST_arbolSintaxisAbstracta=pars.getAST();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
        } 
        ejecutarAST(AST_arbolSintaxisAbstracta);
    }
    /**
     * Recibe una lista de instrucciones y la ejecuta
     * @param ast lista de instrucciones
     */
    private static void ejecutarAST(Arbol ast) {
        if(ast==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        TablaDeSimbolos ts=new TablaDeSimbolos();
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.

        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        //Se ejecuta el árbol
        ast.ejecutar(ts, ast);
		 
    }
}
