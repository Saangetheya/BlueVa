package com.indua.blueva.props;

import javax.lang.model.element.Modifier;

import com.indua.blueva.utils.BJAccessModifier;
import com.indua.blueva.utils.BJPrimTypes;

public class BJField {
    /**
     * Creates new instance of BJField
     *
     * @return A new instance of BJField.
     */
    public static BJField createInstance() {
        return new BJField();
    }

    private String _name;
    private BJPrimTypes _output;
    private String _value;
    private BJAccessModifier _accModifier;
    private Modifier _naccModifierField;
    private boolean isArray;

    public boolean getIsArray() {
        return isArray;
    }

    public BJField setIsArray(boolean isArray) {
        this.isArray = isArray;
        return this;
    }

    private BJField() {

    }

    /**
     * This function returns the value of the private variable _value.
     *
     * @return The value of the variable _value.
     */
    public String getValue() {
        return _value;
    }

    /**
     * This function sets the value of the field to the value passed in as a
     * parameter.
     *
     * @param _value The value of the field.
     * @return The object itself.
     */
    public BJField setValue(String _value) {
        this._value = _value;
        return this;
    }

    /**
     * Gets the name of the field
     *
     * @return The name of the field.
     */
    public String getName() {
        return _name;
    }

    /**
     * It sets the name of the field to the name passed in as a parameter
     *
     * @param _name The name of the field.
     * @return The object itself.
     */
    public BJField setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * Returns the type of the field
     *
     * @return The type of field.
     */
    public BJPrimTypes getOutput() {
        return _output;
    }

    /**
     * This function sets the output of the BJField to the value of the parameter
     * _output
     *
     * @param _output The type of the output of the field.
     * @return The BJField object.
     */
    public BJField setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    /**
     * It returns the access modifier of the class.
     *
     * @return The access modifier of the class.
     */
    public BJAccessModifier getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifier of the field and returns the field.
     *
     * @param _accModifier The access modifier for the field.
     * @return The object itself.
     */
    public BJField setAccModifier(BJAccessModifier _paccModifier) {
        this._accModifier = _paccModifier;
        return this;
    }

    /**
     * This function returns the value of the private field _naccModifierField
     *
     * @return The _naccModifierField variable is being returned.
     */

    public Modifier getNaccModifier() {
        return _naccModifierField;
    }

    /**
     * This function sets the value of the private variable _naccModifierField to
     * the value of the
     * parameter _pnaccModifierMethods.
     *
     * @param _naccModifiersMethods The access modifier for the method.
     * @return The object itself.
     */
    public BJField setNaccModifier(Modifier _pnaccModifierMethods) {
        this._naccModifierField = _pnaccModifierMethods;
        return this;
    }

}