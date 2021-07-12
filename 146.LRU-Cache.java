class LRUCache {

    class Node{
      int key;
      int value;
      Node next;
      Node prev;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }

    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
             Node node = map.get(key);
             remove(node);
             node.value = value;
             add(node);
        } else {
          if (map.size() == capacity){
            remove(tail);
          }
          add(new Node(key, value));
        }
    }

    private void remove(Node node) {
      map.remove(node.key);
      if (node.prev != null) {
        node.prev.next = node.next;
      }
      if (node.next != null) {
        node.next.prev = node.prev;
      }
      if (node == head){
        head = head.next;
      }
      if (node == tail){
        tail = tail.prev;
      }
      node.prev = node.next = null;
    }

    private void add(Node node) {
      map.put(node.key, node);
      if (head == null) {
        head = tail = node;
      } else {
          node.next = head;
          head.prev = node;
          head = node;
      }
    }
}
