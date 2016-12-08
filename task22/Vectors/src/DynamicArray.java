/**
 * Created by thy humble Lovnag on 03.12.2016.
 */
public class DynamicArray<T> {
    private Object[] existingArray = new Object[10];
    private int duhAmonudOvNumbas = 0;

    public void add(T thingy) {
        Object[] newArray;
        if (existingArray.length == duhAmonudOvNumbas) {
            newArray = new Object[existingArray.length * 2];
            for (int i = 0; i != duhAmonudOvNumbas; i++) {
                newArray[i] = existingArray[i];
            }
            existingArray = newArray;
        }
        existingArray[duhAmonudOvNumbas] = thingy;
        duhAmonudOvNumbas++;
    }

    public T get(int theNumba) {
        return (T) existingArray[theNumba];
    }

    public int length() {
        return duhAmonudOvNumbas;
    }

}
