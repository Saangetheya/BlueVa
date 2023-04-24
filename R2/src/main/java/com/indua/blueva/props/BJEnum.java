package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.utils.BJAccessModifierE;

public class BJEnum {
    /**
     * The function creates a new instance of the class BJEnum
     *
     * @param _ppackageName The package name of the enum class.
     * @return A new instance of BJEnum.
     */
    public static BJEnum createInstance(String _ppackageName) {
        return new BJEnum(_ppackageName);
    }

    /**
     * It takes an array of strings and returns an array of BJEnumValue objects
     *
     * @param _enumStr   An array of strings that will be used to generate the enum
     *                   values.
     * @param reqDefault If true, the first value in the enum will be "DEFAULT" and
     *                   will have a value of 0.
     * @return An ArrayList of BJEnumValue objects.
     */
    public static ArrayList<BJValue> generateEnumValues(ArrayList<String> _enumStr, Boolean reqDefault) {
        ArrayList<BJValue> _enumValues = new ArrayList<>();
        int count = 1;
        _enumValues.add(BJValue.createInstance().setName("DEFAULT").setValue(0));

        for (String str : _enumStr) {
            _enumValues.add(BJValue.createInstance().setName(str).setValue(count));
            count += 1;
        }

        return _enumValues;
    }

    private String _name;
    private BJAccessModifierE _accModifier;
    private ArrayList<BJValue> _enumvaluesColl;
    private String _packageName;
    private String _fileComment;
    private BJImports _staticImports;

    public BJEnum setPackageName(String newPackageName) {
        this._packageName = newPackageName;
        return this;
    }

    /**
     * This function returns the static imports
     *
     * @return The static imports.
     */
    public BJImports getStaticImports() {
        return _staticImports;
    }

    /**
     * This function sets the static imports
     *
     * @param _staticImports The static imports.
     * @return The object itself.
     */
    public BJEnum setStaticImports(BJImports _staticImports) {
        this._staticImports = _staticImports;
        return this;
    }

    /**
     * This function sets the file comment for the enum.
     *
     * @param _fileComment The file comment for the enum.
     * @return The enum itself.
     */
    public BJEnum setFileComment(String _fileComment) {
        this._fileComment = _fileComment;
        return this;
    }

    /**
     * This function returns the file comment for the enum.
     *
     * @return The file comment for the enum.
     */
    public String getFileComment() {
        return _fileComment;
    }

    private BJEnum(String _ppackageName) {
        _enumvaluesColl = new ArrayList<>();
        this._packageName = _ppackageName;

        _name = "DefaultEnum";
        _accModifier = BJAccessModifierE.PUBLIC;
        _packageName = "";
        _fileComment = "";
    }

    /**
     * It returns the package name of the enum.
     *
     * @return The package name of the enum.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the enum.
     *
     * @return The name of the enum.
     */
    public String getName() {
        return _name;
    }

    /**
     * Sets name of the enum
     *
     * @param _name The name of the enum.
     * @return The enum itself.
     */
    public BJEnum setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * It returns the access modifiers of the class.
     *
     * @return The access modifiers of the class.
     */
    public BJAccessModifierE getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifiers of the enum to the access modifiers
     * passed in as a
     * parameter.
     *
     * @param _accModifier The access modifiers for the enum.
     * @return The object itself.
     */
    public BJEnum setAccModifier(BJAccessModifierE _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }

    /**
     * This function returns the collection of enum values for this enum.
     *
     * @return An ArrayList of BJEnumValue objects.
     */
    public ArrayList<BJValue> getValueColl() {
        return _enumvaluesColl;
    }

    /**
     * This function adds an enum value to the enum values collection.
     *
     * @param _enumvalue The enum value to add to the enum
     * @return The object itself.
     */
    public BJEnum addValue(BJValue _enumvalue) {
        this._enumvaluesColl.add(_enumvalue);
        return this;
    }
}