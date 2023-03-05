package com.indua.props;

public class BJEnumValue {
    public static BJEnumValue CreateInstance() {
        return new BJEnumValue();
    }

    private String _name;

    private int value;// 0 1 2 (automatically assinged by enum)

    private BJEnumValue() {

    }

    public String GetName() {
        return _name;
    }

    public BJEnumValue SetName(String _name) {
        this._name = _name;
        return this;
    }

    public int GetValue() {
        return value;
    }

    public BJEnumValue SetValue(int value) {
        this.value = value;
        return this;
    }
}
