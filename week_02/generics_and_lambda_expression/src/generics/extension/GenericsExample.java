package generics.extension;

public class GenericsExample {

    public static <T, V> void shout (T thingToShout, V otherThing) {
        System.out.println(thingToShout + " " + otherThing + "!!!!!");
    }

    public static <T> void shout (T thingToShout ) {
        System.out.println(thingToShout + "!!!!!");
    }

    public static void main(String[] args) {
        Printer<String> stringPrinter = new Printer<>("Hello");
        stringPrinter.print();
        Printer<Integer> integerPrinter = new Printer<>(200);
        integerPrinter.print();

        shout("hher", 12000);

    }
}
