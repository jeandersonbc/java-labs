import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static class A {
        public String toString() { return "A"; } 
    }
    static class B extends A {
        public String toString() { return "B"; } 
    }
    static class C extends A {
        public String toString() { return "C"; } 
    }
    static class Z extends B {
        public String toString() { return "C"; } 
    }

    static void print(List<? extends A> m) {
        System.out.println(m);
    }

    public static void main(String[] args) {
        List<A> objs = new ArrayList<>();
        objs.add(new B());
        objs.add(new C());
        objs.add(new A());
        print(objs);

        List<? extends A> objs2 = Arrays.asList(new Z());
        print(objs2);
    }
}
