package com.indua.blueva;

import java.util.ArrayList;

public class BJPackageEnumColl {
    private ArrayList<String> enums;

    public BJPackageEnumColl() {
        enums = new ArrayList<String>();
    }

    public void Add(String className) {
        enums.add(className);
    }

    public Boolean Contains(String className) {
        if(enums.contains(className)) {
            return true;
        }else {
            return false;
        }
    }
    public void Remove(String className) {
        enums.remove(className);
    }

    public ArrayList<String> GetAllNames() {
        return this.enums;
    }
}
