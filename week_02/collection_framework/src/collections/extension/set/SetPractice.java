package collections.extension.set;

import java.util.Arrays;
import java.util.*;

class User {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User other = (User) o;
        return Objects.equals(this.email,other.email );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {

        // email unique => new mail trung => la 1 user

        User u1 = new User("1", "123@gmail.com");
        User u2 = new User("2", "1234@gmail.com");
        User u3 = new User("3", "8282@gmail.com");
        User u4 = new User("4", "123@gmail.com");

        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        System.out.println(users);
        System.out.println("Size = " + users.size());

    }
}

public class SetPractice {
    public static void main(String[] args) {

        // common element
        List<Integer> numbers = Arrays.asList(1,2,5,7,15,15,7,1,20,1345,500,499,945,39);
        List<Integer> numbers2 =  Arrays.asList(1,3,5,7,9,203,1345,9645,39);

        Set <Integer> se = new HashSet<>(numbers);
        Set <Integer> common = new HashSet<>();

        for(Integer x : numbers2) {
            if (se.contains(x)) {
                common.add(x);
            }
        }

        System.out.println("Common element: " + common);

        // find duplicates el

        Set <Integer> duplicates = new HashSet<>();
        Set <Integer> container = new HashSet<>();

        for(Integer x : numbers) {
            if (!container.add(x)) {
                duplicates.add(x);
            }
        }
        System.out.println("Duplicates element: " + duplicates);

        // tree set
        Set<Integer> treeSet = new TreeSet<>(numbers);
        TreeSet<Integer> treeSet2 = new TreeSet<>(numbers);
        System.out.println(treeSet); // ==> remove duplicates and sorted

        // finb max el <= x
        int x = 500;
        Integer lower = treeSet2.lower(x);  // < x
        Integer floor = treeSet2.floor(x); // <= x

        System.out.println(lower + " " + floor);

    }


}
