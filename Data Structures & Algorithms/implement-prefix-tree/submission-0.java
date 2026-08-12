public class TrieNode{
    HashMap<Character,TrieNode>child=new HashMap<>();
    boolean endofword=false;
}
class PrefixTree {
    public TrieNode root;
    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            curr.child.putIfAbsent(c,new TrieNode());
            curr=curr.child.get(c);
        }
        curr.endofword=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr=curr.child.get(c);
        }
        return curr.endofword;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr=curr.child.get(c);
        }
        return true;
    }
}
