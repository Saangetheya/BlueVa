package com.indua.props;

public class BJParameter {
    public static BJParameter CreateInstance() {
        return new BJParameter();
    }

    private String _name;

    private String _output;

    private BJParameter() {

    }

    public String GetName() {
        return _name;
    }

    public BJParameter SetName(String _name) {
        this._name = _name;
        return this;
    }

    public String GetOutput() {
        return _output;
    }

    public BJParameter SetOutput(String _output) {
        this._output = _output;
        return this;
    }
}
