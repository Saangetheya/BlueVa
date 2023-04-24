package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.utils.BJAccessModifier;
import com.indua.blueva.utils.BJNAccessModifierMethod;
import com.indua.blueva.utils.BJPrimTypes;

public class BJMethodInterface extends BJMethod {

    /**
     * This function creates an instance of the BJMethodInterface class and returns
     * it.
     *
     * @return An instance of the class BJMethodInterface.
     */
    public static BJMethodInterface createInstance() {
        return new BJMethodInterface();
    }

    private String _name;
    private ArrayList<BJParameter> _parameterColl;
    private BJPrimTypes _output;
    private boolean isOutputAryType;
    private BJAccessModifier _accModifier;
    private BJNAccessModifierMethod _naccModifier;
    private String _comment;

    public boolean getIsOutputAryType() {
        return isOutputAryType;
    }

    public BJMethodInterface setIsOutputAryType(boolean isOutputAryType) {
        this.isOutputAryType = isOutputAryType;
        return this;
    }

    /**
     * This function returns the comment of the method
     *
     * @return The comment of the method.
     */
    public String getComment() {
        return _comment;
    }

    /**
     * This function sets the comment of the method
     *
     * @param _comment The comment of the method.
     * @return The object itself.
     */
    public BJMethodInterface setComment(String _comment) {
        this._comment = _comment;
        return this;
    }

    private BJMethodInterface() {
        _parameterColl = new ArrayList<>();
    }

    /**
     * Returns the name of the method
     *
     * @return The name of the person.
     */

    public String getName() {
        return _name;
    }

    /**
     * "This function sets the name of the object to the value of the parameter
     * _name and returns the
     * object."
     *
     * The function is a member of the class BJMethodInterface
     *
     * @param _name The name of the method.
     * @return The object itself.
     */
    public BJMethodInterface setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * This function returns the value of the private variable _parameterColl
     *
     * @return An ArrayList of BJParameter objects.
     */

    public ArrayList<BJParameter> getParameterColl() {
        return _parameterColl;
    }

    /**
     * It adds a parameter to the parameter collection
     *
     * @param _parameter The parameter to add to the method.
     * @return The method is returning the object itself.
     */
    public BJMethodInterface addParameter(BJParameter _parameter) {
        this._parameterColl.add(_parameter);
        return this;
    }

    /**
     * Returns the return type of the method
     *
     * @return The output of the function.
     */
    public BJPrimTypes getOutput() {
        return _output;
    }

    /**
     * The function `setOutput` takes a `BJPrimTypes` as an argument and returns a
     * `BJMethodInterface`
     *
     * @param _output The type of the output of the method.
     * @return The object itself.
     */
    public BJMethodInterface setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    /**
     * It returns the access modifiers of the class.
     *
     * @return The access modifiers of the class.
     */
    public BJAccessModifier getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifiers of the method and returns the method.
     *
     * @param _accModifier The access modifiers for the method.
     * @return The object itself.
     */
    public BJMethodInterface setAccModifier(BJAccessModifier _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }

    /**
     * This function returns the value of the variable _naccModifier
     *
     * @return The method is returning the value of the variable _naccModifier.
     */
    public BJNAccessModifierMethod getNaccModifier() {
        return _naccModifier;
    }

    /**
     * This function sets the value of the private variable _naccModifier to the
     * value of the parameter
     * _naccModifier and returns the value of this.
     *
     * @param _naccModifier The access modifiers for the method.
     * @return The object itself.
     */
    public BJMethodInterface setNaccModifier(BJNAccessModifierMethod _naccModifier) {
        this._naccModifier = _naccModifier;
        return this;
    }
}