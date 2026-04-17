package flyweight;

public class StringFlyweight {
    public static void main(String[] args) {
        String a="Final";
        String b="Final";
        System.out.println(a==b);

        // Both the Hashcode is Same. JVM is also reusing the same variable instead of creating the new one.
        System.out.println(a.hashCode() +" "+ b.hashCode());
    }
}
