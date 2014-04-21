
//NOTE: Make changes ONLY where I have put comments with "TODO"
//NOTE: REMOVE the TODO comments when you have done them (That should not have to be said!!!)
//NOTE: I deliberately left comments minimal -- you are supposed to know anough about hashing to figure out what is needed or know when to ASK. 
//NOTE: I expect you to test your own code!!


public class Chaining {

    static class Node {
            Object key;
            Object value;
            Node next;
    };

    static public class HashTable {
        Node [] buckets = new Node[10];
        int size;
        final double threshold = 0.75;

        public void print() {
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

        public Object insert(Object key, Object value) {
            int code = key.hashCode();
            int index = code % this.buckets.length;

            //TODO  insert the new object.
            //TODO: if the load factor exceeds this.threshold, 
            //      then double the capacity of the table

            //If the key was already in the table, just change 
            //the value and return the previouse value
            //
            //Example:
            //   Chaining.HashTable x = new Chaining.HashTable();
            //   x.insert("A", "B"); //returns null
            //   x.insert("A", "C"); //returns "B"
            //   x.insert("A", "D"); //returns "C"

            return null; //TODO: <--- replace that!
        }

            
        private Node find(Object key) {
            //TODO: return a node with a matching key, 
            //      or return null if the key is not in the table.

            return null;
        }

        public double loadFactor() {
            return 0.0; //TODO:<-- replace that
        }

        public Object get(Object key, Object defaultValue) {
            //TODO: if the key is in the table, return the corresponding value. Else return defaultvalue.
            return null;
        }

        public Object get(Object key) {
            return this.get(key, null);
        }


        public boolean contains(Object key) {
            return find(key) != null;
        }


        private void ensureCapacity(int newCapacity) {
            Node[] oldbuckets = this.buckets;
            this.buckets = new Node[newCapacity];
            this.size = 0;
            
            for (Node bucket: oldbuckets) {
                Node current = bucket;
                while (current != null){
                    insert(current.key, current.value);
                    current = current.next;
                }
            }
        }

    }

    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        HashTable table = new HashTable();

        
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
                String last = (String)table.insert(key, value);
                
                System.out.println("----------------");
                System.out.print("inserted "+key + ":" + value);
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
