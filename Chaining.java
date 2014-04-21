
//NOTE: Make changes ONLY where I have put comments with "TODO"
//NOTE: REMOVE the TODO comments when you have done them (That should not have to be said!!!)
//NOTE: I deliberately left comments minimal -- you are supposed to know enough about hashing to figure out what is needed or know when to ASK. 
//NOTE: I expect you to test your own code!!



/** The 'Chaining' exercise.
 *
 * This is an assignment asking students to complete a HashTable that uses
 * chaining. 
 */
public class Chaining {

   
    /** A Node from a singly linked list.
     *
     * This is used to represent each bucket as a singly linked list. 
     */
    static class Node {
            /** The name associated with a piece of data (can actually be any object. **/
            Object key;

            /** The data associated with the name. **/
            Object value;

            /** A reference to the next node in the list (or null at end of list). */
            Node next;
    };


    
    /** A HashTable implementation of a Dictionary / Map using Chaining. 
     *
     *  Documentation is sparse and some of it is left to students. 
     *  You should read the chapter on HashTable from your book or 
     *  other assigned reading. Make sure you are using CHAINING
     *  and not some other approach.
     */
    static public class HashTable {
        /** Bucket/bins for the hash table - each bucket is the head reference of a linked list. */
        Node [] buckets = new Node[10];

        /** TODO: Add a one-liner explaining the purpose of this field. */
        int size;

        /** TODO: Add a one-liner comment explaining the purpose of this field. */
        final double threshold = 0.75;


        /** Prints the HashTable.
         *
         * This function is here to help you understand the structure of the hash table
         * or to help in debugging.
         */
        public void print() {
            System.out.println("HASHTABLE");
            System.out.println("   SIZE:" + this.size);
            System.out.println("   CAPACITY:" + this.buckets.length);
            System.out.println("   LOAD-FACTOR:" + this.loadFactor());

            System.out.println("   BINS:");
            for (int i = 0; i < buckets.length; ++i) {
                System.out.print(String.format("%4d : ", i));
                            Node current = buckets[i];
                while (current != null) {
                    System.out.print("->");
                    System.out.print(current.key);
                    System.out.print(":");
                    System.out.print(current.value);
                    current = current.next;
                }
                System.out.println();
            }       
        }

        
        /** TODO: Document this method.
         */
        public Object put(Object key, Object value) {
            int code = key.hashCode();
            int index = code % this.buckets.length;

            //TODO  insert the mapping from key to value. If the key is 
            //      already associated with a value then the old value is
            //      replaced by the new one. 
            //TODO: if the load factor exceeds this.threshold, 
            //      then double the capacity of the table

            //NOTE: Make sure you insert into the HEAD of each list when you have to add new nodes. 
            //Delete these comments after adding code + Java docs
            
            //If the key was already in the table, just change 
            //the value and return the previous value
            //
            //Example:
            //   Chaining.HashTable x = new Chaining.HashTable();
            //   x.put("A", "B"); //returns null
            //   x.put("A", "C"); //returns "B"
            //   x.put("A", "D"); //returns "C"

            return null; //TODO: <--- replace that!
        }

            
        /** TODO: Document this PRIVATE method.
         */
        private Node find(Object key) {
            //TODO: return a node with a matching key, 
            //      or return null if the key is not in the table.

            return null;
        }

        
        /** TODO: Document this method.
         */
        public double loadFactor() {
            return 0.0; //TODO:<-- replace that
        }


        /** TODO: Document this method.
         */
        public Object get(Object key, Object defaultValue) {
            //TODO: if the key is in the table, return the corresponding value. Else return defaultValue.
            return null;
        }


        /** Get the value associated with a key. 
         *
         * If the key is not in the dictionary this method returns null. 
         * If the key is in the dictionary but it maps to null then you will not be able to tell
         * using this method; the {@link #get(Object, Object) 2-argument  method}  allows you to 
         * specify a different default return value. 
         * 
         * @param key  The key associated with the value you wish to look up.
         *
         * @return The value associates with key, if it exists, or null if the key is not in the table. 
         *
         * @see #get(Object, Object)
         */
        public Object get(Object key) {
            return this.get(key, null);
        }


        /** Return true of the key is in the dictionary.
         *
         * @param key A key that may (or may not) have been inserted into the dictionary.
         * @return true if the key was in the dictionary, false else. 
         */
        public boolean contains(Object key) {
            return find(key) != null;
        }


        /** Increase the number of buckets in the HashTable.
         *
         * This increases the number of <i> buckets</i> in the table.
         * By increasing the number of buckets it is possible to keep the load
         * factor small, and assuming that the hash distributes values uniformly 
         * the performance of find/insert can be kept constant on average.
         *
         * This will invalidate all references to Nodes, and the indexes of all
         * keys will changes.
         *
         * @param newCapacity  The desired number of buckets.
         */
        private void ensureCapacity(int newCapacity) {
            Node[] oldbuckets = this.buckets;
            this.buckets = new Node[newCapacity];
            this.size = 0;
            
            for (Node bucket: oldbuckets) {
                Node current = bucket;
                while (current != null){
                    put(current.key, current.value);
                    current = current.next;
                }
            }
        }

    }

    
    
    /** Process a script.
     *
     * This reads a simple script from STDIN and prints output to STDOUT. 
     * 
     * Each line is processed until the end of the file (CTRL+D) is reached.
     * The input is assumed to have valid syntax (no error checking)
     * 
     * If the input has an equal sign, it is split into a key and value and inserted 
     * into the table.
     *
     * If the input has no equal sign, it is searched for in the HashTable and the
     * corresponding value is output. 
     *
     * After each modification to the table, the entire table is output as
     * well as the load factor and size.
     */
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        HashTable table = new HashTable();

       
        System.out.println("This is the HashTable exercise.");
        System.out.println("Type KEY=VALUE[ENTER] to insert a key, type KEY[ENTER] to look one up.");
        System.out.println("Type CTRL+D when you are done.");
        System.out.println();



        //-->Whenever there is an = sign on the line, we split the 
        //   line into a key and value and insert into the table
        //-->Whenever there is NOT an = sign, we lookup the entire 
        //   line as a key. 
        while (s.hasNextLine()){
            String line = s.nextLine();
            if (line.contains("=")) {
                String[] kv = line.split("=");
                String key = kv[0].trim();
                String value = kv[1];
                String last = (String)table.put(key, value);
                
                System.out.println("----------------");
                System.out.print("Inserted "+key + ":" + value);
                if (last != null){
                    System.out.print(" returned previous value of " + last);
                }
                System.out.println();
                System.out.println("----------------");         
                table.print();
            } else {
                String key = line.trim();
                System.out.println("----------------");
                System.out.print("Looking up " + key);
                String value = (String)table.get(key);
                System.out.print(" found " + value);
                System.out.println();
                System.out.println("----------------");
            }
        }   
        
    }

}
