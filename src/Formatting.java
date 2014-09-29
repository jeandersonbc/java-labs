class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 10, 0, 1000000, -123123, -99999999};
        for (int value : values) {
            System.out.printf("%-10d - %x\n", value, value);
        }
        System.out.println(String.format("Hi, my name is %s.", "Jeanderson"));
    }
}
