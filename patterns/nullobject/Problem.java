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

    // Dummy situation
    static void schedule(Model worker) {
        int result = 0;
        if (worker != null) {
            result = worker.doSomeAction();
        } else {
            result = INVALID;
        }
        System.out.println("Reporting result: " + result);
    }

    public static void main(String[] args) {
        Model validWorker = new Model();
        Model invalidWorker = null;

        schedule(validWorker);
        schedule(invalidWorker);
    }
}
