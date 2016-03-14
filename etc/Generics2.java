import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static class A { }

    static class B extends A {
        public String toString() { return "B"; }
    }

    static void print(List<? extends A> m) {
        System.out.println(m);
    }

    public static void main(String[] args) {
        //List<A> objs2 = new ArrayList<>();
        //objs2.add(new B()); 

        List<A> objs2 = Arrays.asList(new B());

        print(objs2);
    }
}
