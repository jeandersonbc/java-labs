class Main {

    // Dummy results
    final static int RESULT = 10;
    final static int INVALID = -1;

    // Dummy class that possibly can me null while code is executing
    static class Model {
        public int doSomeAction() {
            return RESULT;
        }
    }
    // Describes how a null Model should behave
    static class NullModel extends Model {
        @Override
        public int doSomeAction() {
            return INVALID;
        }
    }

    // Dummy situation SIMPLIFIED
    static void schedule(Model worker) {
        int result = worker.doSomeAction();
        System.out.println("Reporting result: " + result);
    }

    public static void main(String[] args) {
        // It's important and crucial to have control of object
        // instatiation. In practice, I could be using a Factory
        Model validWorker = new Model();
        Model invalidWorker = new NullModel();

        schedule(validWorker);
        schedule(invalidWorker);
    }
}
