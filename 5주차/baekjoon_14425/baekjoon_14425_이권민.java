import java.io.*;
import java.util.*;

package 5주차;

public class baekjoon_14425_이권민 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i ++) {
            if (trie.search(br.readLine())) {
                count ++;
            }
        }

        System.out.println(count);

        // 해시 테이블로 insert, get
        // 이진탐색
        // 집합
        // 이진 검색 트리
    }
    
}

class TrieNode {
    TrieNode[] children;
    // 자식 노드 저장 배열
    boolean isEndOfWord;
    // 단어의 끝을 나타내는 플래그

    public TrieNode() {
        this.children = new TrieNode[26];
        // 26개 알파벳 소문자에 대한 자식 노드 배열
        this.isEndOfWord = false;
    }
    // 새로운 TrieNode를 초기화
}

class Trie {
    private TrieNode root;
// trieNode 타입의 멤버변수
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // 문자열을 문자배열로.
            int index = c - 'a';
            // 'a'는 인덱스 0에 대응. 문자간의 뺄셈연산이 가능하다 ㄷ
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }
}
// 접두사 공유하는 문자열 효율적으로 저장, 정렬된 반복