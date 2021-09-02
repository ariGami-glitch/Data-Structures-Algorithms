public class DynamicListTest {
    public static void main(String args[]) {
        DynamicList<String> names = new DynamicList<String>(30);
        names.add("Alice");
        names.add("Bob");
        names.add("Claire");
        names.add("Dominic");
        names.add("Estelle");
        names.add("Frank");
        names.add("Gwen");
        names.add("Hugo");
        names.add("Irene");
        names.add("Claire");
        names.add("Jack");

        // test the set method
        names.set(1, "Billy");
        System.out.println(names.get(1));
        try {
            names.set(100, "Slartibartfast");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown correctly");
        }

        // test the last index method
        int index = names.lastIndexOf("Claire");
        System.out.println("Last index of Claire is " + index);

        // call the trimToSize method -- should ensure that works in method
        names.trimToSize();

        // print the final list
        System.out.println("List contents:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("\t" + names.get(i));
        }
    }
}
