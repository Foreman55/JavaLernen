package de.willi.literature.test;

public class TestConstructor {

    private static TestConstructor tc;

    private TestConstructor() {
    }

    public static TestConstructor getInstance(){
        if (tc == null){
            System.out.println("intance of");
            tc = new TestConstructor();
        }
        return tc;
    }
}
