package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.util.AccessModifiers;
import com.indua.blueva.util.NonAccessModifiersClass;

public class BJCreateClassInput extends BJCreateInput {

    private String _extendingClass;
    private ArrayList<String> _implementingInterface;
    private AccessModifiers _accessModifier;
    private NonAccessModifiersClass _nonAccessModifiersClass;

    private ArrayList<BJCreateFieldInput> _fieldInputs;
    private ArrayList<BJCreateMethodInput> _methodInputs;

    @Override
    public void Initialize() {
        _implementingInterface = new ArrayList<>();
    }

    private BJCreateClassInput() {

    }

    public static BJCreateClassInput CreateInstance() {
        return new BJCreateClassInput();
    }

    public String GetName() {
        return this._name;
    }

    public String GetExtendingClass() {
        return _extendingClass;
    }

    public ArrayList<String> GetImplementingInterface() {
        return _implementingInterface;
    }

    public AccessModifiers GetAccessModifier() {
        return _accessModifier;
    }

    public NonAccessModifiersClass GetNonAccessModifiersClass() {
        return _nonAccessModifiersClass;
    }

    public ArrayList<BJCreateFieldInput> GetFieldInputs() {
        return _fieldInputs;
    }

    public ArrayList<BJCreateMethodInput> GetMethodInputs() {
        return _methodInputs;
    }

    public BJCreateClassInput SetName(String name) {
        this._name = name;
        return this;
    }

    public BJCreateClassInput SetExtendingClass(String extendingClass) {
        this._extendingClass = extendingClass;
        return this;
    }

    public BJCreateClassInput SetImplementingInterfaces(ArrayList<String> implementingInterfaces) {
        this._implementingInterface = implementingInterfaces;
        return this;
    }

    public BJCreateClassInput SetAccessModifiers(AccessModifiers accessModifiers) {
        this._accessModifier = accessModifiers;
        return this;
    }

    public BJCreateClassInput SetNonAccessModifiers(NonAccessModifiersClass nonAccessModifiersClass) {
        this._nonAccessModifiersClass = nonAccessModifiersClass;
        return this;
    }

    public BJCreateClassInput SetFieldInputs(ArrayList<BJCreateFieldInput> _fieldInputs) {
        this._fieldInputs = _fieldInputs;
        return this;
    }

    public BJCreateClassInput SetMethodInputs(ArrayList<BJCreateMethodInput> _methodInputs) {
        this._methodInputs = _methodInputs;
        return this;
    }

}
