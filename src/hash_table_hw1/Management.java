package hash_table_hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Management {
    static int inputforHash;//SELECTION THE HASHMETHOD
    static long indexingTime;///TOTAL TIME FOR THE CREATE HASHTABLE

    ///THIS METHOD INCREASE IF THE KEY IS ALREADY ON MAP OTHERWISE INCREASE COUNTEROFTABLE
    private static void valueCounter(HashTable<String, Integer> hashMap, int value, String word) {
        if (hashMap.put(word, value, inputforHash)) {/// IF PUT FUNCTION RETURN TRUE THAT MEANS TAKEN WORD ALREADY IN HASHMAP SO IT'S VALUE 1 INCREASE
            if (HashTable.flagKeynotitsLocation) {
                hashMap.table[HashTable.hashofnotitsLocation].setValue(hashMap.table[HashTable.hashofnotitsLocation].getValue() + 1);
                HashTable.counterofTable--;///when key are add table then ıt increase 1
            } else {
                HashTable.counterofTable--;///when key are add table then ıt increase 1
                if (inputforHash == 1)
                    hashMap.table[hashMap.pafHash(word) % HashTable.capacity].setValue(hashMap.table[hashMap.pafHash(word) % HashTable.capacity].getValue() + 1);
                else if (inputforHash == 2)
                    hashMap.table[hashMap.myHash(word) % HashTable.capacity].setValue(hashMap.table[hashMap.myHash(word)].getValue() + 1);
            }

        }
        HashTable.counterofTable++;///when key are add table then ıt increase 1
        HashTable.flagKeynotitsLocation = false;
        HashTable.flagDIB = false;
    }

    ///IT TAKES LOADFACTOR AND SHOWS THE WORDS ON HASHTABLE AND IT SEARCH'S TIME
    public static void SerchTxtReader(int loadfactor) {
        try {
            HashTable.capacity = 997;
            HashTable.counterofTable = 0;
            HashTable.countofCollusion = 0;
            HashTable hashTable = fileReader(loadfactor);
            long minTime = Long.MAX_VALUE;
            long maxTime = Long.MIN_VALUE;
            long totalTime = 0;
            System.out.println("*****TIME WAS TAKEN NANOSECOND*****");
            BufferedReader reader = new BufferedReader(new FileReader("search.txt"));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] words = currentLine.toLowerCase().split(" ");// all words taken lowercase
                for (String word : words) {
                    if (word.isEmpty())/// FOR THE SPACE LINES
                        break;

                    hashTable.get(word, inputforHash);
                    long indexTime = (HashTable.end - HashTable.start);
                    if (indexTime < minTime) {
                        minTime = indexTime;
                    }

                    if (indexTime > maxTime) {
                        maxTime = indexTime;
                    }
                    totalTime += indexTime;

                }
                currentLine = reader.readLine();
            }
            System.out.println("AVARAGE TIME: " + totalTime / 100);
            System.out.println("MINUMUM TIME: " + minTime);
            System.out.println("MAX TIME:" + maxTime);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///IT READS STORY FILE AND CREATES HASHTABLE
    public static HashTable<String, Integer> fileReader(int loadFactor) {
        try {
            long start = System.nanoTime();
            long end = System.nanoTime();
            HashTable<String, Integer> hashMap = new HashTable<String, Integer>();
            final int value = 1;
            BufferedReader reader = new BufferedReader(new FileReader("story.txt"));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] words = currentLine.toLowerCase().split(" ");// all words taken lowercase
                for (String word : words) {
                    if (word.isEmpty())/// FOR THE SPACE LINES
                        break;
                    if (hashMap.reSize(loadFactor)) {
                        hashMap = new HashTable<String, Integer>();
                        HashTable.counterofTable = 0;
                        reader = new BufferedReader(new FileReader("story.txt"));
                        break;
                    }
                    start = System.nanoTime();
                    valueCounter(hashMap, value, word);/// keys ADDED TO MAP
                }
                currentLine = reader.readLine();
            }
            end = System.nanoTime();
            indexingTime = end - start;
            return hashMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashTable<String, Integer> emptyhashMap = new HashTable<String, Integer>();
        System.out.println("CATCH BLOKS ARE RUN");
        return emptyhashMap;
    }

///MENUU OPTIONAL
    public static void menu() {
        System.out.println("2016510075 FERHAT YILDIZ / DATA STRUCTURES HOMEWORK1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER(1 or 2) FOR THE SELECT OF HASH METHOD\n" + "1: PAFHASH\n" + "2: MYHASH");
        inputforHash = scanner.nextInt();
        while(inputforHash!=1 && inputforHash!=2){
            System.out.println("PLEASE ENTER(1 or 2) FOR THE SELECT OF HASH METHOD\n" + "1: PAFHASH\n" + "2: MYHASH");
            inputforHash = scanner.nextInt();
        }
        System.out.println("PLEASE ENTER A LOAD FACTOR(SUCH AS 50 ,70) TO OPEN MENU");
        int loadFactor = scanner.nextInt();
        HashTable<String, Integer> hashMap;
///MENU DESIGN
        try {
            do {
                HashTable.capacity = 997;
                HashTable.counterofTable = 0;
                HashTable.countofCollusion = 0;
                hashMap = fileReader(loadFactor);
                System.out.println("             #MENU# ");
                System.out.println("0-CHANGE THE LOADFACTOR AND HASHMETHOD");
                System.out.println("**************************************");
                System.out.println("1-DISPLAY (HASHTABLE,CAPACITY,INDEXING TIME)");
                System.out.println("2-SEARCH A SPESIFIC WORD/PLEASE ENTER A WORD");
                System.out.println("3-SEARCH THE 'SEARCH.TXT' FILE");
                System.out.println("4-EXIT\n\n ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("PLEASE ENTER(1 or 2) FOR THE SELECT OF HASH METHOD\n" + "1: PAFHASH\n" + "2: MYOWNHASH");
                        inputforHash = scanner.nextInt();
                        while(inputforHash!=1 && inputforHash!=2){
                            System.out.println("PLEASE ENTER(1 or 2) FOR THE SELECT OF HASH METHOD\n" + "1: PAFHASH\n" + "2: MYHASH");
                            inputforHash = scanner.nextInt();
                        }
                        System.out.println("PLEASE ENTER A LOAD FACTOR(SUCH AS 50 ,70) TO OPEN MENU");
                        loadFactor = scanner.nextInt();

                        break;
                    case 1:
                        hashMap.display(inputforHash);
                        break;
                    case 2:
                        System.out.println("PLEASE ENTER A WORD ");
                        scanner = new Scanner(System.in);
                        String input = scanner.nextLine();
                        input = input.toLowerCase();
                        if(hashMap.put(input ,1, inputforHash)==false){
                            System.out.println("WORD NOT FOUND");
                            return;
                        }
                        else
                            hashMap.get(input, inputforHash);
                        break;
                    case 3:
                        SerchTxtReader(loadFactor);
                        break;
                    case 4:
                        System.out.println("Running out");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }//end of switch
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
