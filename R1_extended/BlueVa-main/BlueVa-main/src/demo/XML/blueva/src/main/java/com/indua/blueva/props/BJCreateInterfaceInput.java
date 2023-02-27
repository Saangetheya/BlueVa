package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.util.AccessModifiers;

public class BJCreateInterfaceInput extends BJCreateInput {

    private ArrayList<String> _implementingInterface;
    private AccessModifiers _accessModifiers;

    @Override
    public void Initialize() {
        _implementingInterface = new ArrayList<>();
    }

    private BJCreateInterfaceInput() {

    }

    public static BJCreateInterfaceInput CreateInstance() {
        return new BJCreateInterfaceInput();
    }

    public String GetName() {
        return this._name;
    }

    public ArrayList<String> GetImplementingInterface() {
        return _implementingInterface;
    }

    public AccessModifiers GetAccessModifiers() {
        return _accessModifiers;
    }

    public BJCreateInterfaceInput SetAccessModifiers(AccessModifiers _accessModifiers) {
        this._accessModifiers = _accessModifiers;
        return this;
    }

    public BJCreateInterfaceInput SetImplementingInterface(ArrayList<String> _implementingInterface) {
        this._implementingInterface = _implementingInterface;
        return this;
    }
}
