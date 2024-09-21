package academy.devonline.java.structures;

class DynaArrayTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new int[]{0, 1, 2, 3});
        DynaArray dynaArray = new DynaArray();

        dynaArray.add(list);

        System.out.println(dynaArray.asString());
    }
}
