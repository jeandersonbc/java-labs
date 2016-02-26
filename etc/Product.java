// Consider Builder pattern when having constructors with lots of parameters
class Product {

    private int prop1;
    private int prop2;
    private int prop3;
    private int prop4;
    private int prop5;

    static class Builder {
        private int prop1, prop2;

        // optional properties with default initialization
        private int prop3 = 3;
        private int prop4 = 4;
        private int prop5 = 5;

        public Builder(int prop1, int prop2) {
            this.prop1 = prop1;
            this.prop2 = prop2;
        }
        // consider having all methods for optional attributes
        public Builder setProp3(int p) {
            this.prop3 = p;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.prop1 = builder.prop1;
        this.prop2 = builder.prop2;
        this.prop3 = builder.prop3;
        this.prop4 = builder.prop4;
        this.prop5 = builder.prop5;
    }

    @Override
    public String toString() {
        return String.format("Product:[%3d, %3d, %3d, %3d, %3d]",
                    prop1, prop2, prop3, prop4, prop5);
    }

    public static void main(String[] args) {
        System.out.println(new Product.Builder(10, 99).build());
        System.out.println(new Product.Builder(10, 99).setProp3(-10).build());
    }
}
