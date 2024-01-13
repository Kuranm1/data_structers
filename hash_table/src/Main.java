public class Main {
    public static void main(String[] args) {
        HashTable h = new HashTable();
        h.set("mohammad",25);
        h.set("ahmad",25);
        h.set("mohammad",27);
        h.set("omar",1);
        h.set("zaid",1);
        h.set("abood",1);
        h.set("saif",1);
        h.set("jana",1);
        h.remove("omar");
        h.printTable();
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println("Get method test:");
        System.out.println(h.get("mohammad"));
        System.out.println(h.get("any"));
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println("Keys method test: ");
        System.out.println(h.keys().toString());
    }
}
