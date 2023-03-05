package com.indua.props;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJNAccessModifiersField;
import com.indua.utils.BJPrimTypes;

public class BJField {
    public static BJField CreateInstance() {
        return new BJField();
    }

    /**
     * name="" type="" value="" accmod="" naccmod=""
     */

    private String _name;
    private BJPrimTypes _output;
    private String _value;
    private BJAccessModifers _accModifiers;
    private BJNAccessModifiersField _naccModifiersFields;

    private BJField() {

    }

    public String Getvalue() {
        return _value;
    }

    public BJField SetValue(String _value) {
        this._value = _value;
        return this;
    }

    public String GetName() {
        return _name;
    }

    public BJField SetName(String _name) {
        this._name = _name;
        return this;
    }

    public BJPrimTypes GetOutput() {
        return _output;
    }

    public BJField SetOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJField SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifiersField GetNaccModifiersMethods() {
        return _naccModifiersFields;
    }

    public BJField SetNaccModifiersMethods(BJNAccessModifiersField _naccModifiersMethods) {
        this._naccModifiersFields = _naccModifiersMethods;
        return this;
    }

}
