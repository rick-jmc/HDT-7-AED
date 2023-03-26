
import java.util.Comparator;

public class arbol<Elemento extends Comparable<Elemento>> {

       nodo<Elemento> raiz;

       final nodo<Elemento> EMPTY = new nodo<>();

       Comparator<Elemento> ordenador;

       int contador;

       String arbolOrdenado = "";

       public arbol() {
              this(new Comparator<Elemento>() {
                     public int compare(Elemento a, Elemento b) {
                            return a.compareTo(b);
                     }
              });
       }

       public arbol(Comparator<Elemento> ordenAuxiliar) {
              raiz = EMPTY;
              contador = 0;
              ordenador = ordenAuxiliar;
       }

       public boolean compareTo(Elemento raizValor, Elemento valueToCompare) {
              Asosiacion valueInAssociation;
              Asosiacion valorRaiz = (Asosiacion) raizValor;
              if (valueToCompare instanceof Asosiacion) {
                     valueInAssociation = (Asosiacion) valueToCompare;
              } else {
                     return false;
              }

              return valorRaiz.getKey().equals(valueInAssociation.getKey());
       }

       protected nodo<Elemento> localizar(nodo<Elemento> raiz, Elemento valor) {
              Elemento valorRaiz = raiz.value();
              nodo<Elemento> inferior;

              if (compareTo(valorRaiz, valor))
                     return raiz;

              if (ordenador.compare(valorRaiz, valor) < 0) {
                     inferior = raiz.siguiente();
              } else {
                     inferior = raiz.previo();
              }

              if (inferior.isEmpty()) {
                     return raiz;
              } else {
                     return localizar(inferior, valor);
              }
       }

       public void agregar(Elemento valor) {
              nodo<Elemento> nuevaHoja = new nodo<>(valor, EMPTY, EMPTY);

              if (raiz.isEmpty()) {
                     raiz = nuevaHoja;
              } else {
                     nodo<Elemento> insertarUbi = localizar(raiz, valor);
                     Elemento valorNodo = insertarUbi.value();

                     if (ordenador.compare(valorNodo, valor) < 0) {
                            insertarUbi.setSiguiente(nuevaHoja);
                     } else {
                            if (!insertarUbi.previo().isEmpty()) {

                                   predecessor(insertarUbi).setSiguiente(nuevaHoja);
                            } else {
                                   insertarUbi.setPrevio(nuevaHoja);
                            }
                     }
              }
              contador++;
       }

       protected nodo<Elemento> predecessor(nodo<Elemento> raiz) {
              if (!raiz.isEmpty()) {
                     throw new IllegalArgumentException("No tiene raiz anterior.");
              }
              if (!raiz.previo().isEmpty()) {
                     throw new IllegalArgumentException("No tiene hoja anterior");
              }

              nodo<Elemento> respuesta = raiz.previo();
              while (!respuesta.siguiente().isEmpty()) {
                     respuesta = respuesta.siguiente();
              }
              return respuesta;
       }

       public boolean contiene(String llave) {
              if (raiz.isEmpty())
                     return false;
              comparable value = new comparable(llave);
              Elemento val = (Elemento) value;
              nodo<Elemento> possibleLocation = localizar(raiz, val);
              return compareTo(val, possibleLocation.value());
       }

       public Elemento get(String key) {
              if (raiz.isEmpty())
                     return null;
              comparable value = new comparable(key);
              Elemento val = (Elemento) value;
              nodo<Elemento> possibleLocation = localizar(raiz, val);
              if (compareTo(val, possibleLocation.value()))
                     return possibleLocation.value();
              else
                     return null;
       }

       public void iot(nodo<Elemento> root) {
              if (root == null || root.isEmpty()) {
                     return;
              }
              iot(root.previo());
              arbolOrdenado += root.value() + "\n";
              iot(root.siguiente());
       }

       public String inOrder() {
              arbolOrdenado = "";
              iot(raiz);
              return arbolOrdenado;
       }



}