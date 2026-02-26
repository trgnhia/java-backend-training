package generics.extension;

public class GenericsExample {

    public static <T, V> void shout (T thingToShout, V otherThing) {
        System.out.println(thingToShout + " " + otherThing + "!!!!!");
    }

    public static <T> void swapper (T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> T maxElement (T[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("Arr cannot be empty");
        }

        T maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(maxVal) > 0) {
                maxVal = arr[i];
            }
        }

        return maxVal;
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

        String[] names = {"AN", "Tran nghia", "Bao", "Hoang", ",,vvv"};
        Double[] numbers = {1.8,2.94,3.45,22.56,1.33, -6.22, 9.3992};

        swapper(names, 1,4);
        System.out.println(names[4]);
        Double maxEl = maxElement(numbers);
        System.out.println("Phan tu lon nhat trong mang: " + maxEl);
    }
}
