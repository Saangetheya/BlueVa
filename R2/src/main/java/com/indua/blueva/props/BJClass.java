package com.indua.blueva.props;

import java.util.ArrayList;

import javax.lang.model.element.Modifier;

public class BJClass extends BJNode {

    /**
     * This function creates a new instance of the BJClass class, and returns it
     *
     * @param _ppackageName The package name of the class.
     * @return A new instance of BJClass.
     */
    public static BJClass createInstance(String _ppackageName) {
        return new BJClass(_ppackageName);
    }

    private String _extendingClass;
    private ArrayList<String> _implementingInterfaces;
    private Modifier _accModifier;
    private Modifier _naccModifier;
    private ArrayList<BJMethodClass> _methodColl;
    private ArrayList<BJField> _fieldColl;
    private String _packageName;
    private String _fileComment;
    private BJImports _staticImports;
    private boolean isMain;
    private boolean shouldAddDefConstructor;
    private boolean shouldAddParamConstructor;

    public boolean getIsShouldAddDefConstructor() {
        return shouldAddDefConstructor;
    }

    public BJClass setIsShouldAddDefConstructor(boolean shouldAddDefConstructor) {
        this.shouldAddDefConstructor = shouldAddDefConstructor;
        return this;
    }

    public boolean getIsShouldAddParamConstructor() {
        return shouldAddParamConstructor;
    }

    public BJClass setIsShouldAddParamConstructor(boolean shouldAddParamConstructor) {
        this.shouldAddParamConstructor = shouldAddParamConstructor;
        return this;
    }

    private BJClass(String _ppackageName) {
        _extendingClass = null;
        _accModifier = Modifier.PUBLIC;
        _naccModifier = Modifier.DEFAULT;
        _implementingInterfaces = new ArrayList<>();
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();

        shouldAddDefConstructor= true;
        shouldAddParamConstructor= false;

        _packageName = _ppackageName;
        _fileComment = null;
        _name = "DefaultClass";
        _staticImports = null;
    }

    public BJClass setPackageName(String _packageName) {
        this._packageName = _packageName;
        return this;
    }

    public boolean isMain() {
        return isMain;
    }

    public BJClass setMain(boolean isMain) {
        this.isMain = isMain;
        return this;
    }

    public boolean removeInterface(String _interface) {
        return _implementingInterfaces.remove(_interface);
    }

    public boolean removeMethod(BJMethodClass _method) {
        return _methodColl.remove(_method);
    }

    public boolean removeField(BJField _field) {
        return _fieldColl.remove(_field);
    }

    public BJClass setStaticImports(BJImports _staticImports) {
        this._staticImports = _staticImports;
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

    public BJClass setFileComment(String _fileComment) {
        this._fileComment = _fileComment;
        return this;
    }

    public String getFileComment() {
        return _fileComment;
    }

    /**
     * Returns the package name
     *
     * @return The package name.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the class that is extending the current class.
     *
     * @return The extending class.
     */
    public String getExtendingClass() {
        return _extendingClass;
    }

    /**
     * This function sets the extending class of the class
     *
     * @param _extendingClass The class that this class extends.
     * @return The class itself.
     */
    public BJClass setExtendingInterfaces(String _extendingClass) {
        this._extendingClass = _extendingClass;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of all
     * the interfaces that
     * the class implements
     *
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getImplementingInterfaces() {
        return _implementingInterfaces;
    }

    /**
     * This function sets the implementing classes of the class
     *
     * @param _implementingInterfaces The list of interfaces that this class
     *                                implements.
     * @return The class itself.
     */
    public BJClass setImplementingClasses(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    /**
     * Returns the access modifiers of the current class
     *
     * @return The access modifiers of the class.
     */
    public Modifier getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifiers of the class to the access modifiers
     * passed in as a
     * parameter.
     *
     * @param _accModifier The access modifiers for the class.
     * @return The object itself.
     */
    public BJClass setAccModifier(Modifier _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }

    /**
     * This function returns the value of the private variable _naccModifier
     *
     * @return The value of the variable _naccModifier.
     */

    public Modifier getNaccModifier() {
        return _naccModifier;
    }

    /**
     * "This function sets the value of the private variable _naccModifier to the
     * value of the parameter
     * _naccModifier."
     *
     * @param _naccModifier The access modifiers for the class.
     * @return The object itself.
     */
    public BJClass setNaccModifier(Modifier _naccModifier) {
        this._naccModifier = _naccModifier;
        return this;
    }

    /**
     * This function returns the ArrayList of BJMethodClass objects that are stored
     * in the _methodColl
     * variable.
     *
     * @return An ArrayList of BJMethodClass objects.
     */
    public ArrayList<BJMethodClass> getMethodColl() {
        return _methodColl;
    }

    /**
     * This function adds a method to the class
     *
     * @param _method The method to add to the class.
     * @return The class itself.
     */
    public BJClass addMethod(BJMethodClass _method) {
        this._methodColl.add(_method);
        return this;
    }

    public BJClass addInterface(String interfaceName) {
        this._implementingInterfaces.add(interfaceName);
        return  this;
    }

    /**
     * Returns the field collection
     *
     * @return An ArrayList of BJField objects.
     */
    public ArrayList<BJField> getFieldColl() {
        return _fieldColl;
    }

    /**
     * Adds a field to the class
     *
     * @param _field The field to add to the class.
     * @return The class itself.
     */
    public BJClass addField(BJField _field) {
        this._fieldColl.add(_field);
        return this;
    }

    /**
     * Returns the name of the class
     *
     * @return The name of the person.
     */
    public String getName() {
        return this._name;
    }

    /**
     * "This function sets the name of the class to the value of the parameter
     * passed in."
     *
     * Now, let's look at the function in more detail
     *
     * @param _pname The name of the class
     * @return The class itself.
     */
    public BJClass setName(String _pname) {
        this._name = _pname;
        return this;
    }
}