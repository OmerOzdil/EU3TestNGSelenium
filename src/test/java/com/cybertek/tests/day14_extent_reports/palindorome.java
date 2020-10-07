package com.cybertek.tests.day14_extent_reports;

public class palindorome {
    public static void main(String[] args) {

        System.out.println(plndm("racecar"));

    }
    public static boolean plndm(String str){

        if(str==null){
            return false;
        }

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);

    }
}
