

import java.util.Map;

public class comparable<llave extends Comparable<llave>,valor> extends Asosiacion<llave,valor> implements Comparable<comparable<llave,valor>>, Map.Entry<llave,valor>
{
    public comparable(llave a)
    {
        this(a,null);
    }

    public comparable(llave a, valor b)
    {
        super(a,b);
    }
    public int compareTo(comparable<llave,valor> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        llave a;
        valor b;
        a=getKey();
        b=getValue();

        
        s.append(a+" es igual a "+b);
        return s.toString();
    }

}