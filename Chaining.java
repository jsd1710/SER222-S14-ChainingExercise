import java.util.Scanner;

public class Chaining 
{

	static class Node 
	{
		Object key;
		Object value;
		Node next;
	};

	static public class HashTable 
	{
		int size = 10;
		Node[] buckets = new Node[size];
		
		final double threshold = 0.75;
		int counter = 0;

		public void print() 
		{
			for (int i = 0; i < buckets.length; ++i) 
			{
				System.out.print(String.format("%4d : ", i));
				Node current = buckets[i];
				while (current != null) 
				{
					System.out.print("->");
					System.out.print(current.key);
					System.out.print(":");
					System.out.print(current.value);
					current = current.next;
				}
				System.out.println();
			}
		}

		public Object insert(Object key, Object value) 
		{
			int code = key.hashCode();
			int index = code % this.buckets.length;
			
			if (this.loadFactor() > this.threshold)
			{
				this.resize(this.size*2);
			}
			
			if (find(key) != null)
			{
				Node temp = find(key);
				Object old_value = temp.value;
				temp.value = value;
				return  old_value;
			}
			counter++;
			
			Node new_node = new Node();
			new_node.value = value;
			new_node.key = key;
			new_node.next = buckets[index];
			buckets[index] = new_node;
			

			return null; 
		}

		private Node find(Object key) 
		{
			for (int i = 0; i < this.buckets.length; i++)
			{
				Node temp = buckets[i];
				while (temp != null)
				{
					if (temp.key.equals(key))
					{
						return temp;
					}
					temp = temp.next;
				}
			}
			return null;
		}

		public double loadFactor() 
		{
			return ((double)counter)/((double)size);
		}

		public Object get(Object key, Object defaultValue) 
		{
			Node temp = find(key);
			if (temp != null)
			{
				return temp.value;
			}
			else
			{
				return defaultValue;
			}
		}
		
		public Object get(Object key)
		{
			return this.get(key, null);
		}
		
		public boolean contains(Object key) 
		{
			return find(key) != null;
		}

		private void resize(int newsize) 
		{
			Node[] oldbuckets = this.buckets;

			this.buckets = new Node[newsize];
			this.size = newsize;

			for (Node bucket : oldbuckets) 
			{
				Node current = bucket;
				while (current != null) 
				{
					this.insert(current.key, current.value);
					current = current.next;
				}
			}
		}

	}

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		HashTable table = new HashTable();

		// -->Whenever there is an = sign on the line, we split the
		// line into a key and value and insert into the table
		// -->Whenever there is NOT an = sign, we lookup the entire
		// line as a key.
		while (s.hasNextLine()) 
		{
			String line = s.nextLine();
			if (line.contains("=")) 
			{
				String[] kv = line.split("=");
				String key = kv[0].trim();
				String value = kv[1];
				String last = (String) table.insert(key, value);

				System.out.println("----------------");
				System.out.print("inserted " + key + ":" + value);
				if (last != null) 
				{
					System.out.print(" returned previous value of " + last);
				}
				System.out.println();
				System.out.println("----------------");
				table.print();
			} 
			else 
			{
				String key = line.trim();
				System.out.println("----------------");
				System.out.print("Looking up " + key);
				String value = (String) table.get(key);
				System.out.print(" found " + value);
				System.out.println();
				System.out.println("----------------");
			}
		}

	}

}
