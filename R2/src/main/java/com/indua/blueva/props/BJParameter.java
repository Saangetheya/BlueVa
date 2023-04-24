package com.indua.blueva.props;

import com.indua.blueva.utils.BJNAccessModifierParameter;
import com.indua.blueva.utils.BJPrimTypes;

public class BJParameter {
    /**
     * This function creates a new instance of the BJParameter class
     *
     * @return A new instance of BJParameter.
     */
    public static BJParameter createInstance() {
        return new BJParameter();
    }

    private String _name;
    private BJPrimTypes _output;
    private BJNAccessModifierParameter _naccModifier;
    private boolean isArray;

    public boolean getIsArray() {
        return isArray;
    }

    public BJParameter setIsArray(boolean isArray) {
        this.isArray = isArray;
        return this;
    }

    private BJParameter() {
        isArray = false;
        _naccModifier = BJNAccessModifierParameter.DEFAULT;
    }

    /**
     * This function returns the value of the private variable _naccModifier
     *
     * @return The value of the variable _naccModifier.
     */
    public BJNAccessModifierParameter getNaccModifier() {
        return _naccModifier;
    }

    /**
     * This function is used to set the value of the private variable _naccModifier
     * to the value of the
     * parameter _naccModifier.
     *
     * @param _naccModifier The parameter that is passed in from the calling method.
     */
    public BJParameter setNaccModifier(BJNAccessModifierParameter _naccModifier) {
        this._naccModifier = _naccModifier;
        return this;
    }

    /**
     * This function returns the name of the person
     *
     * @return The name of the person.
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the name of parameter
     *
     * @param _name The name of the parameter.
     * @return The object itself.
     */
    public BJParameter setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * This function returns the output of the node
     *
     * @return The output of the function.
     */
    public BJPrimTypes getOutput() {
        return _output;
    }

    /**
     * This function sets the output of the BJParameter to the output of the
     * BJPrimTypes
     *
     * @param _output The type of the output of the function.
     * @return The object itself.
     */
    public BJParameter setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }
}