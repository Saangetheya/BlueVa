package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.util.AccessModifiers;

public class BJCreateEnumInput extends BJCreateInput {

    private AccessModifiers _accessModifier;
    private ArrayList<BJCreateEnumValueInput> _enumValues;

    @Override
    public void Initialize() {
        _enumValues = new ArrayList<BJCreateEnumValueInput>();
    }

    private BJCreateEnumInput() {

    }

    public static BJCreateEnumInput CreateInstance() {
        return new BJCreateEnumInput();
    }

    public String GetName() {
        return this._name;
    }

    public AccessModifiers GetAccessModifier() {
        return _accessModifier;
    }

    public ArrayList<BJCreateEnumValueInput> GetEnumValues() {
        return _enumValues;
    }

    public BJCreateEnumInput SetEnumValues(ArrayList<BJCreateEnumValueInput> _enumValues) {
        this._enumValues = _enumValues;

        return this;
    }

    public BJCreateEnumInput SetName(String name) {
        this._name = name;
        return this;
    }

    public BJCreateEnumInput SetAccessModifiers(AccessModifiers accessModifiers) {
        this._accessModifier = accessModifiers;
        return this;
    }

}
