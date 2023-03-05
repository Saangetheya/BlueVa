package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJNAccessModifiersMethod;
import com.indua.utils.BJPrimTypes;

public class BJMethodInterface {
    /*
     * name="" input="" output="" accmod="" naccmod=""
     */

    public static BJMethodInterface CreateInstance() {
        return new BJMethodInterface();
    }

    private String _name;

    private ArrayList<BJParameter> _inputs;

    private BJPrimTypes _output;

    private BJAccessModifers _accModifiers;

    private BJNAccessModifiersMethod _naccModifiers;

    private BJMethodInterface() {

    }

    public String Getname() {
        return _name;
    }

    public BJMethodInterface Setname(String _name) {
        this._name = _name;
        return this;
    }

    public ArrayList<BJParameter> Getinputs() {
        return _inputs;
    }

    public BJMethodInterface Setinputs(ArrayList<BJParameter> _inputs) {
        this._inputs = _inputs;
        return this;
    }

    public BJPrimTypes Getoutput() {
        return _output;
    }

    public BJMethodInterface Setoutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    public BJAccessModifers GetaccModifiers() {
        return _accModifiers;
    }

    public BJMethodInterface SetaccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifiersMethod GetnaccModifiers() {
        return _naccModifiers;
    }

    public BJMethodInterface SetnaccModifiers(BJNAccessModifiersMethod _naccModifiers) {
        this._naccModifiers = _naccModifiers;
        return this;
    }
}
