import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class driver {
    public static void main(String[] args) throws IOException{
        Scanner teclado=new Scanner(System.in);
        Archivo manejoArchivo=new Archivo();


        int selecciona=0,seleccionb=0;
        arbol<comparable<String,List<String>>> arbolito=new arbol<>();
        System.out.println("Welcome---Bienvenido---Accueillir");
        System.out.println("Ingresa el idioma con el que esta tu palabra ");
        System.out.println("0. Ingles ");
        System.out.println("1. Español ");
        System.out.println("2. Frances ");

        selecciona=teclado.nextInt();
        if(selecciona>=0&&selecciona<=2){
            manejoArchivo.leer(arbolito, selecciona, "diccionario.txt", ",");


        }else{
            System.out.println("Hay un error");
        }




        System.out.println("Ingresa el idioma al que quieres traducir");
        System.out.println("0. Ingles ");
        System.out.println("1. Español ");
        System.out.println("2. Frances ");

        seleccionb=teclado.nextInt();
        

        try {
            BufferedReader lector = new BufferedReader(new FileReader("mensaje.txt"));
            String linea = lector.readLine();
            String transalte = "";
            while (linea != null) {
                if(linea != null){
                    transalte = linea;
               }
               linea = lector.readLine();
            }
            lector.close();
            String[] toTranslate = transalte.split(" ");
            String mensajeRetornar = "";
            for(String word:toTranslate){
                if(arbolito.contiene(word))
                    mensajeRetornar+= arbolito.get(word).getValue().get(seleccionb)+" ";
                else{
                    mensajeRetornar+= "*"+word+"* ";
                }
            }
            System.out.println(mensajeRetornar);
            System.out.println("Recorrido in-order por medio del idioma seleccionado del arbol: ");
            System.out.println(arbolito.inOrder());

         } catch (IOException e) {
            System.out.println(e);
         }



    

        
    }
}