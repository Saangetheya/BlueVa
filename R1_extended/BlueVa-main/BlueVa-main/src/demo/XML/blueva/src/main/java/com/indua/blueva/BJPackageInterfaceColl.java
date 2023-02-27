package com.indua.blueva;

import java.util.ArrayList;

public class BJPackageInterfaceColl {
    private ArrayList<String> interfaces;

    public BJPackageInterfaceColl() {
        interfaces = new ArrayList<String>();
    }

    public void Add(String className) {
        interfaces.add(className);
    }

    public Boolean Contains(String className) {
        if (interfaces.contains(className)) {
            return true;
        } else {
            return false;
        }
    }

    public void Remove(String className) {
        interfaces.remove(className);
    }

    public ArrayList<String> GetAllNames() {
        return this.interfaces;
    }
}
