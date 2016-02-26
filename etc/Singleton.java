class MyClass {

    // Test purpose
    private static int instances = 0;
    private int id;

    // enforce singleton property
    private MyClass() { this.id = instances++; }

    @Override
    public String toString() {
        return String.format("MyClass[id:%2d]", this.id);
    }
    // Instance Holder idiom - Lazy Initializaion due to JVM property
    private static class InstanceHolder {
        private static MyClass instance = new MyClass();
    }
    public static MyClass getInstance() {
        return InstanceHolder.instance;
    }
    // Driver
    public static void main(String[] args) {
        for (int attempt = 0; attempt < 10; attempt++)
            System.out.println(MyClass.getInstance());
    }

}
