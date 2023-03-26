
import java.util.Map;

public class Asosiacion<llave,valor> implements Map.Entry<llave,valor>{
    private llave key;
    private valor value;

    public Asosiacion (llave key, valor value){
        this.key = key;
        this.value = value;
    }

    public llave getKey() {
        return key;
    }

    public valor getValue() {
        return this.value;
    }

    public valor setValue(valor value) {
        this.value = value;
        return value;
    }

}