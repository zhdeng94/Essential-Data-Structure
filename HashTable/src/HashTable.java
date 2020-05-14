/**
 * My implementation of a hash map using java built in TreeMap
 *
 * @author Zihao Deng
 * @since 2020-05-14
 * @param <K> key
 * @param <V> value
 */

import java.util.TreeMap;

public class HashTable<K extends Comparable<K>, V> {

    private static final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable;
    private int size;
    private int M;

    /* Constructor */
    public HashTable() {

        M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];

        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    /* Return the hashcode of the key. The hashcode is positive integer */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /* Add (key, value) pair into the hash table */
    public void add(K key, V value) {

        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    /* Remove and return the value corresponding to key. If key is not in the
     * hash table, return null. */
    public V remove(K key) {

        TreeMap<K, V> map = hashTable[hash(key)];
        V toReturn = null;
        if (map.containsKey(key)) {
            toReturn = map.remove(key);
            size--;

            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return toReturn;
    }

    /* Return true if the key is in the hash table */
    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /* Return the value corresponding to the key */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    /* Set the key, value pair in the hash table. Do nothing if the key is
    *  not in the hash table */
    public void set(K key, V value) {
        hashTable[hash(key)].put(key, value);
    }

    /* Resize the hash table to the desired capacity */
    private void resize(int capacity) {

        TreeMap<K, V>[] newTable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newTable[i] = new TreeMap<>();
        }

        int oldM = M;
        M = capacity;
        for (int i = 0; i < oldM; i++) {
            for (K key : hashTable[i].keySet()) {
                newTable[hash(key)].put(key, hashTable[i].get(key));
            }
        }
        hashTable = newTable;
    }
}
