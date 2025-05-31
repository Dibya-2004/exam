import java.util.*;
class HuffmanSimpleHashing {
 static class Node implements Comparable<Node> {
 char ch; int freq; Node left, right;
 Node(char c, int f) { ch = c; freq = f; }
 Node(int f, Node l, Node r) { freq = f; left = l; right = r; }
 public int compareTo(Node o) { return freq - o.freq; }
 }
 static void makeCode(Node root, String code, Map<Character,
String> map) {
 if (root.left == null && root.right == null) map.put(root.ch,
code);
 else {
 makeCode(root.left, code + "0", map);
 makeCode(root.right, code + "1", map);
 }
 }
 public static void main(String[] args) {
 String msg = "hellohello", enc = "";
 Map<Character, Integer> freq = new HashMap<>();
 for (char c : msg.toCharArray()) freq.put(c,
freq.getOrDefault(c, 0) + 1);
 PriorityQueue<Node> pq = new PriorityQueue<>();
 for (var e : freq.entrySet()) pq.add(new Node(e.getKey(),
e.getValue()));
 while (pq.size() > 1) pq.add(new Node(0, pq.poll(), pq.poll()));
 Node root = pq.poll(); Map<Character, String> map = new
HashMap<>();
 makeCode(root, "", map);
 for (char c : msg.toCharArray()) enc += map.get(c);
 int fixed = msg.length() *
(int)Math.ceil(Math.log(freq.size())/Math.log(2));
 System.out.println("Encoded: " + enc);
 System.out.printf("Avg bits saved/char: %.2f\n", (fixed -
(double)enc.length()) / msg.length());
 }
}