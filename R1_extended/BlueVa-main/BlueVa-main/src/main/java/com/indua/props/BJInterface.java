package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;

public class BJInterface {
    public static BJInterface CreateInstance() {
        return new BJInterface();
    }
    /*
     *  name="" implements="" accmod=""
     */
    private String _name;

    private ArrayList<String> _implementingInterfaces;

    private BJAccessModifers _accModifiers;

    private BJInterface() {
        _implementingInterfaces = new ArrayList<>();
    }

    public String GetName() {
        return _name;
    }

    public BJInterface SetName(String _name) {
        this._name = _name;
        return this;
    }

    public ArrayList<String> GetImplementingInterfaces() {
        return _implementingInterfaces;
    }
    public BJInterface SetImplementingInterfaces(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    } 

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJInterface SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }
}
