package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Intrinsic State (Shared Object)
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.color = color;
        this.name = name;
        this.texture = texture;
    }

    // Display the Tree based on different positions.
    public void display(int x, int y) {
        System.out.println("Tree: " + name + " at (" + x + "," + y + ")");
    }
}

// Factory Flyweight
class TreeTypeFactory {
    // Map collection of each type of object
    private static Map<String, TreeType> treetypes = new HashMap<String, TreeType>();

    // Get the Tree type according to the key from the map
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        if (!treetypes.containsKey(key)) {
            // Add the Tree type in the map to share the same object
            treetypes.put(key, new TreeType(name, color, texture));
        }
        return treetypes.get(key);
    }
}

// Extrinsic State
class Tree {
    private int x;
    private int y;
    private TreeType treeType; //shared object

    public Tree(int x, int y, TreeType treetype) {
        this.x = x;
        this.y = y;
        this.treeType = treetype;
    }

    // Display the Tree based on the shared object but on different positions
    public void display() {
        treeType.display(this.x, this.y);
    }
}

public class FlyWeightPattern {
    public static void main(String[] args) {
        List<Tree> forest = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            TreeType oak = TreeTypeFactory.getTreeType("Oak", "Green", "Rough");
            forest.add(new Tree(i, i * 2, oak));
        }

        for (Tree tree : forest) {
            tree.display();
        }
    }
}
