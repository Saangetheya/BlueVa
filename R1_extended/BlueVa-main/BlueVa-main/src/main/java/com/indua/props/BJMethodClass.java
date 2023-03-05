package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJId;
import com.indua.utils.BJNAccessModifiersMethod;

public class BJMethodClass {
    public static BJMethodClass CreateInstance() {
        return new BJMethodClass();
    }

    /**
     * name="" output="" id="" accmod="" naccmod=""
     */

    private String _name;

    private String _output;

    private BJId _bjId;

    private BJAccessModifers _accModifiers;

    private BJNAccessModifiersMethod _naccModifiersMethods;

    private ArrayList<BJParameter> _parameterColl;

    private BJMethodClass() {
        _parameterColl = new ArrayList<>();
    }

    public String GetName() {
        return _name;
    }

    public BJMethodClass SetName(String _name) {
        this._name = _name;
        return this;
    }

    public String GetOutput() {
        return _output;
    }

    public BJMethodClass SetOutput(String _output) {
        this._output = _output;
        return this;
    }

    public BJId GetBjId() {
        return _bjId;
    }

    public BJMethodClass SetBjId(BJId _bjId) {
        this._bjId = _bjId;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJMethodClass SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifiersMethod GetNaccModifiersMethods() {
        return _naccModifiersMethods;
    }

    public BJMethodClass SetNaccModifiersMethods(BJNAccessModifiersMethod _naccModifiersMethods) {
        this._naccModifiersMethods = _naccModifiersMethods;
        return this;
    }

    public ArrayList<BJParameter> GetParameterColl() {
        return _parameterColl;
    }

    public BJMethodClass SetParameterColl(ArrayList<BJParameter> _parameterColl) {
        this._parameterColl = _parameterColl;
        return this;
    }

}
