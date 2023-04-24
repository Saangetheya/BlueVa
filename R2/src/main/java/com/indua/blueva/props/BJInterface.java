package com.indua.blueva.props;

import java.util.ArrayList;

import com.indua.blueva.utils.BJAccessModifierCI;

public class BJInterface {
    /**
     * This function creates a new instance of the BJInterface class, and returns
     * it.
     *
     * @param _ppackageName The package name of the app you want to launch.
     * @return A new instance of BJInterface.
     */
    public static BJInterface createInstance(String _ppackageName) {
        return new BJInterface(_ppackageName);
    }

    private String _name;
    private ArrayList<String> _implementingInterfaces;
    private BJAccessModifierCI _accModifier;
    private String _packageName;
    private ArrayList<BJMethodInterface> _methodColl;
    private ArrayList<BJFieldI> _fieldColl;
    private BJImports _staticImports;
    private String _fileComment;
    private String _interfaceComment;

    public BJInterface addInterface(String newIntername) {
        this._implementingInterfaces.add(newIntername);
        return this;
    }

    public String getInterfaceComment() {
        return _interfaceComment;
    }

    public BJInterface setInterfaceComment(String _interfaceComment) {
        this._interfaceComment = _interfaceComment;
        return this;
    }

    public BJInterface setPackageName(String newPackageName) {
        this._packageName = newPackageName;
        return this;
    }
    // A constructor.
    private BJInterface(String _ppackageName) {
        _name = "DefaultInterface";
        _implementingInterfaces = new ArrayList<>();
        _accModifier = BJAccessModifierCI.PUBLIC;
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();
        _staticImports = null;
        _fileComment = null;
        _interfaceComment = null;

        this._packageName = _ppackageName;
    }

    public boolean removeInterface(String _interface) {
        return _implementingInterfaces.remove(_interface);
    }

    public boolean removeMethod(BJMethodInterface _method) {
        return _methodColl.remove(_method);
    }

    public boolean removeField(BJFieldI _field) {
        return _fieldColl.remove(_field);
    }


    public BJInterface setFileComment(String _fileComment) {
        this._fileComment = _fileComment;
        return this;
    }

    public String getFileComment() {
        return _fileComment;
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
    public BJInterface setStaticImports(BJImports _staticImports) {
        this._staticImports = _staticImports;
        return this;
    }

    /**
     * This function returns the field collection
     *
     * @return An ArrayList of BJFieldI objects.
     */
    public ArrayList<BJFieldI> getFieldColl() {
        return _fieldColl;
    }

    public BJInterface addField(BJFieldI _pfield) {
        this._fieldColl.add(_pfield);
        return this;
    }

    /**
     * It returns the method collection.
     *
     * @return An ArrayList of BJMethodInterface objects.
     */
    public ArrayList<BJMethodInterface> getMethodColl() {
        return _methodColl;
    }

    /**
     * Adds method to interface method collection
     *
     * @param _method The method to add to the interface.
     * @return The interface itself.
     */
    public BJInterface addMethod(BJMethodInterface _method) {
        this._methodColl.add(_method);
        return this;
    }

    /**
     * It returns the package name of the interface.
     *
     * @return The package name of the interface.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the interface.
     *
     * @return The name of the interface.
     */
    public String getName() {
        return _name;
    }

    /**
     * This function sets the name of the object to the value of the parameter _name
     * and returns the
     * object.
     *
     * @param _name The name of the interface.
     * @return The object itself.
     */
    public BJInterface setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * Returns the implementing interfaces
     *
     * @return An ArrayList of Strings
     */
    public ArrayList<String> getImplementingInterfaces() {
        return _implementingInterfaces;
    }

    /**
     * This function sets the implementing interfaces of the interface
     *
     * @param _implementingInterfaces The list of interfaces that this interface
     *                                implements.
     * @return The object itself.
     */
    public BJInterface setImplementingInterfaces(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    /**
     * Returns the access modifiers for the class
     *
     * @return The access modifiers of the class.
     */
    public BJAccessModifierCI getAccModifier() {
        return _accModifier;
    }

    /**
     * Sets the access modifiers for the class
     *
     * @param _accModifier The access modifiers for the interface.
     * @return The object itself.
     */
    public BJInterface setAccModifier(BJAccessModifierCI _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }
}