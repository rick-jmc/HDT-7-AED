public class nodo<Elemento> {
    private Elemento val;
    private nodo<Elemento> parent;

    private nodo<Elemento> left, right;

    public nodo()
    {
        val = null;
        parent = null; left = right = this;
    }

    public nodo(Elemento valor, nodo<Elemento> previo, nodo<Elemento> siguiente)
    {

        if(valor!=null){

            val = valor;
            if (previo == null) { previo = new nodo<Elemento>(); }
            setPrevio(previo);
            if (siguiente == null) { siguiente = new nodo<Elemento>(); }
            setSiguiente(siguiente);
        }else{
            throw new IllegalArgumentException("El arbol no se encuentra listo para utilizar");
        }
        }

    public nodo<Elemento> previo()
    {
        return left;
    }

    public nodo<Elemento> siguiente()
    {
        return right;
    }

    public nodo<Elemento> superior()
    {
        return parent;
    }

    public void setPrevio(nodo<Elemento> valorPrev)
    {
        if (isEmpty()) return;
        if (left != null && left.superior() == this) left.setSuperior(null);
        left = valorPrev;
        left.setSuperior(this);
    }

    public void setSiguiente(nodo<Elemento> valorSig)
    {
        if (isEmpty()) return;
        if (right != null && right.superior() == this) right.setSuperior(null);
        right = valorSig;
        right.setSuperior(this);
    }

    protected void setSuperior(nodo<Elemento> valorSup)
    {
        if (!isEmpty()) {
            parent = valorSup;
        }
    }

    public boolean isEmpty()
    {
        return val == null;
    }

    public Elemento value()
    {
        return val;
    }

}