import java.util.LinkedHashMap;
import java.util.Map;

public class MainImplementLRUCache {
	
	public static void main(String[] args) {
//		LRUCache cache = new LRUCache(10);
//		for (int i = 0; i < 20; i++) {
//			cache.put(i, i);
//		}
//		System.out.println("Cache size: " + cache.size());
//		System.out.println("Iterating through all key-value pair:");
//		for (Integer key : cache.keySet()) {
//			System.out.println(key + " -> " + cache.get(key));
//		}
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4

	}
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // this makes difference
        this.capacity = capacity;
    }
    
    public Integer get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    public boolean removeEldestEntry (Map.Entry eldest){
        return super.size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */