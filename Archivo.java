import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Archivo{

    public static String formatear(String palabra){
        String nueva="";
        nueva=palabra.trim().toLowerCase();

        return nueva;
    }

    public static void leer(arbol<comparable<String,List<String>>> arbol,int idiomaIngresado,String nombreArchivo,String caracter) throws IOException{
        File archivo=new File(nombreArchivo);
        FileReader lector=new FileReader(archivo);
        try(BufferedReader lectorBuffer=new BufferedReader(lector)){
            String linea;

            while((linea=lectorBuffer.readLine())!=null){
                String[] lista=linea.split(caracter);
                if(lista.length!=3){throw new IllegalArgumentException("Esta mal escrita la linea: "+linea);}
                String ingles=formatear(lista[0]);
                String espaniol=formatear(lista[1]);
                String frances=formatear(lista[2]);

                arbol.agregar(new comparable<String,List<String>>(formatear(lista[idiomaIngresado]),Arrays.asList(ingles,espaniol,frances)));

                
            }
        }
    }
}
