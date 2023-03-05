package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJNAccessModifersClass;

public class BJClass extends BJNode {

    public static BJClass CreateInstance() {
        return new BJClass();
    }
    private String _extendingClass;
    private ArrayList<String> _implementingClasses;
    private BJAccessModifers _accModifiers;

    private BJNAccessModifersClass _naccModifiers;

    private ArrayList<BJMethodClass> _methodColl;

    private ArrayList<BJField> _fieldColl;

    private BJClass() {
        _implementingClasses = new ArrayList<>();
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();

        _accModifiers = BJAccessModifers.DEFAULT;
        _naccModifiers= BJNAccessModifersClass.DEFAULT;
    }

    public String GetExtendingClass() {
        return _extendingClass;
    }

    public BJClass SetExtendingClass(String _extendingClass) {
        this._extendingClass = _extendingClass;
        return this;
    }

    public ArrayList<String> GetImplementingClasses() {
        return _implementingClasses;
    }

    public BJClass SetImplementingClasses(ArrayList<String> _implementingClasses) {
        this._implementingClasses = _implementingClasses;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJClass SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifersClass GetNaccModifiers() {
        return _naccModifiers;
    }

    public BJClass SetNaccModifiers(BJNAccessModifersClass _naccModifiers) {
        this._naccModifiers = _naccModifiers;
        return this;
    }

    public ArrayList<BJMethodClass> GetMethodColl() {
        return _methodColl;
    }
    public BJClass SetMethodColl(ArrayList<BJMethodClass> _methodColl) {
        this._methodColl = _methodColl;
        return this;
    }

    public ArrayList<BJField> GetfieldColl() {
        return _fieldColl;
    }

    public BJClass SetfieldColl(ArrayList<BJField> _fieldColl) {
        this._fieldColl = _fieldColl;
        return this;
    }

    public String GetName() {
        return this._name;
    }

    public BJClass SetName(String _pname) {
        this._name = _pname;
        return this;
    }
}
