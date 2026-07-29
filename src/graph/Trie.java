package src.graph;

class Trie {
    // 1. 成员变量写在类内部，而不是构造函数里
    private Trie[] son;
    private boolean isEnd;

    // 2. 构造函数：初始化成员变量
    public Trie() {
        son = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie cur = this; // 当前节点
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // 如果子节点不存在，在对应位置创建新节点
            if (cur.son[index] == null) {
                cur.son[index] = new Trie(); // 修复：给数组对应位置赋值
            }
            cur = cur.son[index];
        }
        cur.isEnd = true; // 标记单词结尾
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // 修复：检查具体的子节点 cur.son[index] 是否为空
            if (cur.son[index] == null) {
                return 0; // 找不到对应字符，匹配失败
            }
            cur = cur.son[index];
        }
        // 找到了所有字符，判断是完整单词(2)还是仅前缀(1)
        return cur.isEnd ? 2 : 1;
    }
}