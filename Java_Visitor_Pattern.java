
import java.io.*;
import java.util.*;

// Visitor interface for tree nodes and leaves
abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

// Tree class (parent for both nodes and leaves)
abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

// Tree node class
class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

// Tree leaf class
class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

// Enum for color
enum Color {
    RED, GREEN
}

// Visitor 1: Sum of all leaf nodes
class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // Do nothing for nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

// Visitor 2: Product of all red nodes' values
class ProductOfRedNodesVisitor extends TreeVis {
    private int result = 1;
    private static long MODULO_FACTOR = ((long) Math.pow(10, 9) + 7);

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        visit(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        visit(leaf);
    }

    private void visit(Tree tree) {
        if (tree.getColor() == Color.RED) {
            long temp = result;
            temp = (temp * tree.getValue());
            result = (int) (temp % MODULO_FACTOR);
        }
    }
}

// Visitor 3: Absolute difference between sum of non-leaf nodes at even depth and sum of green leaf nodes
class FancyVisitor extends TreeVis {
    int nonLeafSum = 0;
    int leafSum = 0;

    public int getResult() {
        return (int) Math.abs(nonLeafSum - leafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            leafSum += leaf.getValue();
        }
    }
}

public class Java_Visitor_Pattern{
    public static void main(String[] args) {
        Tree root = solve();

        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        Setup setup = new Setup(sc);

        Tree[] tree = new Tree[setup.n];
        int currentDepth = -1;
        Queue<Context> toVisit = new ArrayDeque<>();
        toVisit.add(new Context(currentDepth, 0, null));

        while (!toVisit.isEmpty()) {
            Context ctx = toVisit.poll();
            if (tree[ctx.index] != null) continue;

            int currentIndex = ctx.index;
            currentDepth = ctx.depth + 1;
            TreeNode parent = ctx.parent;

            List<Integer> children = setup.adjacencies.get(currentIndex);
            List<Integer> filteredIndexes = new ArrayList<>();
            for (int child : children) {
                if (tree[child] == null) filteredIndexes.add(child);
            }

            boolean isLeaf = filteredIndexes.isEmpty();

            if (isLeaf) {
                tree[currentIndex] = new TreeLeaf(setup.values[currentIndex], setup.colors[currentIndex], currentDepth);
            } else {
                tree[currentIndex] = new TreeNode(setup.values[currentIndex], setup.colors[currentIndex], currentDepth);
                for (Integer filteredIndex : filteredIndexes) {
                    toVisit.add(new Context(currentDepth, filteredIndex, (TreeNode) tree[currentIndex]));
                }
            }

            if (parent != null) parent.addChild(tree[currentIndex]);
        }
        return tree[0];
    }

    static class Context {
        int depth;
        int index;
        TreeNode parent;

        Context(int depth, int index, TreeNode parent) {
            this.depth = depth;
            this.index = index;
            this.parent = parent;
        }
    }

    static class Setup {
        int n;
        int[] values;
        Color[] colors;
        Map<Integer, List<Integer>> adjacencies = new HashMap<>();

        Setup(Scanner sc) {
            n = sc.nextInt();
            values = new int[n];
            colors = new Color[n];
            adjacencies = new HashMap<>();

            for (int i = 0; i < n; i++) values[i] = sc.nextInt();
            for (int i = 0; i < n; i++) colors[i] = Color.values()[sc.nextInt()];

            for (int i = 0; i < (n - 1); i++) {
                int leftIndex = sc.nextInt() - 1;
                int rightIndex = sc.nextInt() - 1;
                adjacencies.computeIfAbsent(leftIndex, k -> new ArrayList<>()).add(rightIndex);
                adjacencies.computeIfAbsent(rightIndex, k -> new ArrayList<>()).add(leftIndex);
            }
        }
    }
}

