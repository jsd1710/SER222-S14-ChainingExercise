

public class Chaining {

	static class Node {
		Object key;
		Object value;
                Node next;
        };

        static public class HashTable {
		Node [] buckets = new Node[10];
		int size;
		final float threshold = 0.75;

		public void print() {
			for (int i = 0; i < buckets.length; ++i) {
				System.out.print(String.format("%4d : ", i));
               		        node current = buckets[i];
				while (current) {
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
                        int index = code % this.size;

			//TODO  insert the new object.
			//TODO: if the load factor exceeds this.threshold, 
			//      then double the capacity of the table

			//If the key was already in the table, just change 
			//the value and return the previouse value
			
			return null; //TODO: <--- replace that!
		}

			
		private Node find(Object key) {
			
			
			//TODO: return a node that satidfies node.value.equals(key)
			//      or return null if the key is not in the table.
		}

		public float loadFactor() {
			return 0.0; //TODO:<-- replace that
		}

		public Object get(Object key, Object defaultValue) {
			//TODO: if the key is in the table, return it. Else return defaultvalue.
		}


		public boolean contains(Object key) {
			return find(key) != null;
		}


		private void resize(int newsize) {
			Node[] oldbuckets = this.buckets
			
			this.buckets = new Node[newsize];
			this.n = 0
			
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
		Scanner s = new Scanner(System.in);
		
		HashTable table = new HashTable();

		//-->Whenever there is an = sign on the line, we split the 
		//   line into a key and value and insert into the table
		//-->Whenever there is NOT an = sign, we lookup the entire 
		//   line as a key. 
		while (s.hasNextLine()){
			line = s.nextLine();
			if (line.contains("=")) {
				String[] kv = line.split("=");
				String key = kv[0].trim();
				String value = kv[1];
				String last = table.insert(key, value);
				
				System.out.println("----------------");
				System.out.print("inserted "+key + ":" + value);
				if (last != null){
					System.out.print(" returned previous value of " + last);
				}
				System.out.prinrln("----------------");			
				table.print();
			} else {
				String key = line.trim();
				System.out.println("----------------");
				System.out.print("Looking up " + key);
				String value = table.get(key);
				System.out.print(" found " + value);
				System.out.println("----------------");
			}
		}	
		
	}

}