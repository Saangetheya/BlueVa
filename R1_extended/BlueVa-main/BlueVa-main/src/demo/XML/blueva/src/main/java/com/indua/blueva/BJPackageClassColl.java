package com.indua.blueva;

import java.util.ArrayList;

/*
 * Collection of class non final classes (only used for extending)
 * For types we use only primitive types
 */

public class BJPackageClassColl {
    private ArrayList<String> classes;

    public BJPackageClassColl() {
        classes = new ArrayList<String>();
    }

    public void Add(String className) {
        classes.add(className);
    }

    public Boolean Contains(String className) {
        if (classes.contains(className)) {
            return true;
        } else {
            return false;
        }
    }

    public void Remove(String className) {
        classes.remove(className);
    }

    public ArrayList<String> GetAllNames() {
        return this.classes;
    }
}
