package hash_table_hw1;

class HashTable<K, V> {
    static int counterofTable = 0;
    static int hash = 0;
    static int hashBeforeMod;
    static boolean flagDIB = false;
    static int capacity = 997;  //Initial capacity of HashMap
    static boolean flagKeynotitsLocation = false;//IF KEY LOCATION CHANGED
    static boolean isFlagContains = false;//IF A KEY IS ALREADY ON HASHMAP
    static int hashofnotitsLocation;
    static int countofCollusion = 0;
    static long start = System.nanoTime();
    static long end = System.nanoTime();

    public HashTable() {
        table = new Entry[capacity];
    }

    public Entry<K, V>[] table;   //Array of Entry.

    ///RESIZE METHOD RESIZE=RESIZE*2
    public boolean reSize(int loadFactor) {
        if (counterofTable >= capacity * loadFactor / 100) {
            capacity = capacity * 2;
            return true;
        }
        return false;
    }

    ///DISPLAY ALL TABLE AND SOME PROPERTIES
    public void display(int choiceHashMethod) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    if (choiceHashMethod == 1)
                        System.out.print("Table[" + i + "] " + "> " + entry.key + "\t\t value:" + entry.getValue() + "\t " + "Index : " + (pafHash(entry.key)) % capacity + " \n");
                    else if (choiceHashMethod == 2)
                        System.out.print("Table[" + i + "] " + "> " + entry.key + "\t\t value:" + entry.getValue() + "\t " + "Index : " + (myHash(entry.key)) + " \n");

                    entry = entry.next;
                }
            }
        }
        System.out.println("CAPACITY: " + capacity);
        System.out.println("COLLUSION COUNT: " + countofCollusion);
        System.out.println("INDEXING TIME: " + Management.indexingTime + "\n");
    }

    ///FOR MY OWN HASH FUNCTION
    //use recursion - keep breaking down the multiplication into smaller pieces and mod each of the pieces individually
    public static int modMult(int first, int second, int modul) {
        if (second == 0)
            return 0;
        else if (second % 2 == 0) {
            int half = modMult(first, second / 2, modul);
            return (half + half) % modul;
        } else {
            int half = modMult(first, second / 2, modul);
            return (half + half + first) % modul;
        }
    }

    //use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together
    public static int modPow(int number, int power, int modul) {
        if (power == 0)
            return 1;
        else if (power % 2 == 0) {
            int halfpower = modPow(number, power / 2, modul);
            return modMult(halfpower, halfpower, modul);
        } else {
            int halfpower = modPow(number, power / 2, modul);
            int firstbit = modMult(halfpower, halfpower, modul);
            return modMult(firstbit, number, modul);
        }
    }
    //assume that the alphabet is ASCII characters - a total of 256 possibilities
//each successive character value should be raised to successive powers of 256
//the whole thing is added together and then moduloed to create a hash table index

    public int myHash(K key) {
        String word = (String) key;
        int hash = 0;
        int count = 0;
        for (char c : word.toCharArray()) {
            int i = (int) c;
            hash += i * modPow(258, count, capacity);
            count++;
        }
        hashBeforeMod=hash;
        hash = hash % capacity;
        return hash;
    }


///FINISH MYOWN FUNCTION

    /// PRIME NUMBER SELECTED 39 IT RETURNS value of PAF function
    public int pafHash(K key) {
        int primeNumber = 39;// 39 selected because least collusion number
        int charValue = -1;//it is for letter value on alphabet
        double hash = 0;
        int overflowHash = 0; //// FOR THE BIG WORDS >> HASH NUMBERS NOT TO BE SAME
        char[] alphabet = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String word = (String) key;
        int pow = word.length() - 1;///it begins 1 less from size
        for (int i = 0; i < (word.length()); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (word.charAt(i) == alphabet[j]) {
                    charValue = j;
                    break;
                }
            }
            hash += (charValue * Math.pow(primeNumber, pow));
            pow--;
            if (hash >= Integer.MAX_VALUE) {
                overflowHash += hash % capacity;
                hash = 0;
            }
        }
        if (hash != 0 && overflowHash + hash < Integer.MAX_VALUE) { /// IF AGAIN HASH VALUES BIGGER THAN "INTEGERMAXVALUE" THEN IGNORE IT.
            overflowHash += hash;
        }
        return overflowHash;
    }

/// IF THE INPUT 1: CALL PAFHASH , INPUT:2 CALL MY HASH

    ///IF THE TABLE[HASH]==EMPTY PUT METHOD LOCATED THE KEY OTHERWISE CALL DIB() METHOD
    public boolean put(K newKey, V data, int choiceHashMethod) { /// IT IS ALSO CHECKİNG CONTAINS OR NOT
        if (newKey == null)
            return false;    //does not allow to store null.
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data);
        if (choiceHashMethod == 1)
            hash = pafHash(newKey) % capacity;//IT RETURNS HASH OF WORD
        else if (choiceHashMethod == 2)
            hash = myHash(newKey);//IT RETURNS HASH OF WORD
        //if table location does not contain any entry, store entry there.
        if (hash < 0 || newKey.equals(" "))///IT DEDETCTS NOT TABLE CHARECTER SUCH AS "--" CHARECTER
            return false;
        if (table[hash] == null) {
            table[hash] = newEntry;
            return false;
        }
        if (table[hash].getKey().equals(newKey)) /// IF IT EQUALS THE KEY THAT MEANS KEY VALUE MUST BE 1 ICREASE
            return true;
        /// WHEN COLLISION
        while (!flagDIB) {
            newEntry = DIB(newEntry, choiceHashMethod);
            if (hash == capacity)
                hash = 0;
            if (table[hash] == null) {
                table[hash] = newEntry;
                flagDIB = true;
                isFlagContains = false;
                break;
            }
            if (table[hash].key.equals(newEntry.key)) {/// IF IT EQUALS THE KEY THAT MEANS KEY VALUE MUST BE 1 ICREASE
                flagKeynotitsLocation = true;
                hashofnotitsLocation = hash;
                isFlagContains = true;
                flagDIB = true;
                break;
            }
        }
        return isFlagContains;
    }

    ///DIB METHOD RUNS ONLY COLLUSION STATEMENT
    public Entry DIB(Entry entry, int choiceHashMethod) {
        int entryHash = 0, locationElementHash = 0;
        if (choiceHashMethod == 1) {
            entryHash = pafHash((K) entry.key) % capacity;
            locationElementHash = pafHash((K) table[hash].key) % capacity;
        } else if (choiceHashMethod == 2) {
            entryHash = myHash((K) entry.key);//IT RETURNS HASH OF WORD
            locationElementHash = myHash((K) table[hash].key);
        }
        countofCollusion++;
        while (hash - locationElementHash >= hash - entryHash) {
            hash++;
            return entry;
        }
        Entry<K, V> prewEntry = table[hash];//
        table[hash] = entry;//entry located prewentries location
        hash++;
        return prewEntry;
    }

    ///GET METHOD IS ALSO SHOW SEARCH TIME
    public void get(K key, int choiceHashMethod) {
        start = System.nanoTime();
        end = System.nanoTime();
        if (choiceHashMethod == 1)
            hash = pafHash(key) % capacity;//IT RETURNS HASH OF WORD
        else if (choiceHashMethod == 2)
            hash = myHash(key);//IT RETURNS HASH OF WORD
        start = System.nanoTime();
        if (table[hash] == null) {
            end = System.nanoTime();
            System.out.println("Search Time: " + (end - start) + "\n");//NanoSecon to milisecond
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    end = System.nanoTime();
                    if (choiceHashMethod == 1)
                        System.out.println("Search: " + temp.key + "\n" + "Key: " + pafHash(temp.key) + "\n" + "Count: " + temp.value + "\n" + "Index: " + hash);
                    else if (choiceHashMethod == 2)
                        System.out.println("Search: " + temp.key + "\n" + "Key: " + hashBeforeMod+ "\n" + "Count: " + temp.value + "\n" + "Index: " + (myHash(temp.key)%capacity));
                    System.out.println("Search Time: " + (end - start) + "\n");//NanoSecon to milisecond
                    break;
                }
                ///IF HASH=LAST INDEX
                if (hash == capacity - 1) {
                    hash = 0;
                    temp = table[hash];
                    while (!(temp.key.equals(key))) {
                        hash++;
                        temp = table[hash];
                    }
                    end = System.nanoTime();
                    if (choiceHashMethod == 1)
                        System.out.println("Search: " + temp.key + "\n" + "Key: " + pafHash(temp.key) + "\n" + "Count: " + temp.value + "\n" + "Index: " + hash);
                    else if (choiceHashMethod == 2)
                        System.out.println("Search: " + temp.key + "\n" + "Key: " + hashBeforeMod + "\n" + "Count: " + temp.value + "\n" + "Index: " + hash);
                    System.out.println("Search Time: " + (end - start) + "\n");//NanoSecon to milisecond
                    break;
                }
                hash++;
                temp = table[hash]; //return value corresponding to key.
            }
        }
    }
}
