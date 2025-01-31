package sample;

class TestException {
    public static void main (String[] args) throws Exception {
        TestException t1 = new TestException();
        System.out.println(t1.print(1));
    }
    public Exception print(int i) throws Exception {
        if (i > 0) {
            throw new Exception("Custom Exception");
        } else {
            throw new RuntimeException();
        }
    }
}