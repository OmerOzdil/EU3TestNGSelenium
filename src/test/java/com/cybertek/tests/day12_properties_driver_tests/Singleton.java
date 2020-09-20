package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {
    // singleton class will have private constructor
    // it means other classes can not create object of this class.
    private Singleton() {
    }

    private static String str;
    public static String getInstance() {
        // if str has no value, initiliase it and return it
        if (str == null) {
            System.out.println("str is null. assinging value it");
            str = "somevalue";
        } else {
            //if it has a value just return it
            System.out.println("it has value, just returning it");
        }
        return str;
    }
}
