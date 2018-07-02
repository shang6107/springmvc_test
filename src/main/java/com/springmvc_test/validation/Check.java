package com.springmvc_test.validation;

public class Check{
    public static boolean checkParam(String name){
        if(!name.equals(name.toLowerCase()))
            return false;
        return true;
    }
}
