package hash_table_hw1;

public class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry(K key, V value) {///  LINEAR PROBING  SOLUTION FOR THE  COLLISION(IT USED PAF)
        this.key = key;
        this.value = value;
    }




}

