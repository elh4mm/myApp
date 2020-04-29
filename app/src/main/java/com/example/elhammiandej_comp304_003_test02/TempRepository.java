package com.example.elhammiandej_comp304_003_test02;

import java.util.ArrayList;

public class TempRepository {

    public static ArrayList<CoStudent> list = new ArrayList<CoStudent>();

    public static void add(CoStudent cs) {
        if (!list.contains(cs)) {
            list.add(cs);
        }

    }
}
