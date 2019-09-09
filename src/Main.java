public class Main {
    public static void main(String[] args) {
        int parent[] = new int[11];
        for (int  i = 1; i <= 10; i++) {
            parent[i] = i;
        }
        UnionFind unionFind = new UnionFind();
        unionFind.unionParent(parent, 1, 2);
        unionFind.unionParent(parent, 2, 3);
        unionFind.unionParent(parent, 3, 4);
        unionFind.unionParent(parent, 5, 6);
        unionFind.unionParent(parent, 6, 7);
        unionFind.unionParent(parent, 7, 8);
        System.out.printf("1과 5는 연결되어 있나요? %s\n", unionFind.findParent(parent, 1, 5));
        unionFind.unionParent(parent, 1, 5);
        System.out.printf("1과 5는 연결되어 있나요? %s\n", unionFind.findParent(parent, 1, 5));
    }
}

class UnionFind {
    private int getParent(int parent[], int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 각 부모 노드를 합칩니다.
    public void unionParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public boolean findParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }
}
