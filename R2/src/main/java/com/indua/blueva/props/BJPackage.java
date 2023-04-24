package com.indua.blueva.props;

import java.io.IOException;
import java.util.ArrayList;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJEnum;
import com.indua.blueva.props.BJInterface;
import com.indua.blueva.utils.BJClassWriter;
import com.indua.blueva.utils.BJEnumWriter;
import com.indua.blueva.utils.BJInterfaceWriter;

public class BJPackage {
    /**
     * // Java
     * public static BJPackage createInstance(String _ppackageName) {
     * BJPackage packageLayout = new BJPackage(_ppackageName);
     * return packageLayout;
     * }
     *
     * @param _ppackageName The name of the package.
     * @return A new instance of BJPackage.
     */
    public static BJPackage createInstance(String _ppackageName) {
        BJPackage packageLayout = new BJPackage(_ppackageName);

        return packageLayout;
    }

    private  String _packageName;
    private ArrayList<BJClass> _classColl;
    private ArrayList<BJEnum> _enumColl;
    private ArrayList<BJInterface> _interfaceColl;
    private String _packageDir;

    private ArrayList<String> _classNames;
    private ArrayList<String> _enumNames;
    private ArrayList<String> _interfaceNames;

    private BJPackage(String _ppackageName) {
        _classColl = new ArrayList<>();
        _interfaceColl = new ArrayList<>();
        _enumColl = new ArrayList<>();

        _packageName = _ppackageName;
        _packageDir = "";

        _classNames = new ArrayList<>();
        _enumNames = new ArrayList<>();
        _interfaceNames = new ArrayList<>();
    }

    public BJPackage setPackageName(String packageName){
        this._packageName = packageName;
        return this;
    }

    public BJPackage setPackageDir(String _packageDir) {
        this._packageDir = _packageDir;
        return this;
    }

    /**
     * // Java
     * public String getPackageName() {
     * return _packageName;
     * }
     *
     * @return The package name.
     */
    public String getName() {
        return _packageName;
    }

    /**
     * This function returns the collection of classes
     *
     * @return An ArrayList of BJClass objects.
     */
    public ArrayList<BJClass> getClassColl() {
        return _classColl;
    }

    /**
     * This function sets the class collection of the package
     *
     * @param _classColl The collection of classes in the package.
     * @return The object itself.
     */
    public BJPackage setClassColl(ArrayList<BJClass> _classColl) {
        this._classColl = _classColl;
        return this;
    }

    /**
     * This function returns the value of the private variable _enumColl
     *
     * @return An ArrayList of BJEnum objects.
     */

    public ArrayList<BJEnum> getEnumColl() {
        return _enumColl;
    }

    /**
     * This function sets the value of the private variable _enumColl to the value
     * of the parameter
     * _enumColl
     *
     * @param _enumColl An ArrayList of BJEnum objects.
     * @return The object itself.
     */

    public BJPackage setEnumColl(ArrayList<BJEnum> _enumColl) {
        this._enumColl = _enumColl;
        return this;
    }

    /**
     * This function returns the collection of interfaces that are associated with
     * this object.
     *
     * @return An ArrayList of BJInterface objects.
     */
    public ArrayList<BJInterface> getInterfaceColl() {
        return _interfaceColl;
    }

    /**
     * This function sets the value of the _interfaceColl variable to the value of
     * the _interfaceColl
     * variable passed in as a parameter.
     *
     * @param _interfaceColl ArrayList of BJInterface objects
     * @return The object itself.
     */
    public BJPackage setInterfaceColl(ArrayList<BJInterface> _interfaceColl) {
        this._interfaceColl = _interfaceColl;
        return this;
    }

    /**
     * // Java
     *
     * public ArrayList<String> getClassNames() {
     * return _classNames;
     * }
     *
     * @return An ArrayList of Strings.
     */

    public ArrayList<String> getClassNames() {
        return _classNames;
    }

    /**
     * It sets the class names of the package.
     *
     * @param _classNames The list of class names that are in the package.
     * @return The object itself.
     */
    public BJPackage setClassNames(ArrayList<String> _classNames) {
        this._classNames = _classNames;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of the
     * enumerations
     *
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getEnumNames() {
        return _enumNames;
    }

    /**
     * This function sets the value of the private variable _enumNames to the value
     * of the parameter
     * _enumNames
     *
     * @param _enumNames The names of the enums in the package.
     * @return The object itself.
     */

    public BJPackage setEnumNames(ArrayList<String> _enumNames) {
        this._enumNames = _enumNames;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of all
     * the interfaces that the
     * class implements
     *
     * @return An ArrayList of Strings.
     */

    public ArrayList<String> getInterfaceNames() {
        return _interfaceNames;
    }

    /**
     * This function sets the interface names of the package
     *
     * @param _interfaceNames The list of interfaces that the package implements.
     * @return The object itself.
     */
    public BJPackage setInterfaceNames(ArrayList<String> _interfaceNames) {
        this._interfaceNames = _interfaceNames;
        return this;
    }

    /**
     * Adds a class to the package
     *
     * @param _class The class to add to the package.
     * @return The BJPackage object.
     */
    public BJPackage addClass(BJClass _class) {
        this._classColl.add(_class);
        return this;
    }

    /**
     * AddEnum() adds an enum to the enum collection.
     *
     * @param _enum The enum to add to the package
     * @return The BJPackage object.
     */

    public BJPackage addEnum(BJEnum _enum) {
        this._enumColl.add(_enum);
        return this;
    }

    /**
     * This function adds an interface to the interface collection.
     *
     * @param _interface The interface to add to the package.
     * @return The BJPackage object.
     */
    public BJPackage addInterface(BJInterface _interface) {
        this._interfaceColl.add(_interface);
        return this;
    }

    public boolean removeClass(BJClass _class) {
        return this._classColl.remove(_class);
    }

    public boolean removeEnum(BJEnum _enum) {
        return this._enumColl.remove(_enum);
    }

    public boolean removeInterface(BJInterface _interface) {
        return this._interfaceColl.remove(_interface);
    }

    public void build() throws IOException {

        if (_packageName == null || _packageName == "") {
            System.out.println("Package name is null or empty., so output is generated in default directory");
            return; // TODO: implement this part
        }

        for (BJClass _class : _classColl) {
            if (_class.getPackageName() == "") {
                _class.setPackageName(_packageName);
            } else {
                _class.setPackageName(_packageName + "." + _class.getPackageName());
            }
            BJClassWriter.createInstance(_class).setFolderFile(_packageDir).build();
        }

        for (BJEnum _enum : _enumColl) {
            if (_enum.getPackageName() == "") {
                _enum.setPackageName(_packageName);
            } else {
                _enum.setPackageName(_packageName + "." + _enum.getPackageName());
            }
            BJEnumWriter.createInstance(_enum).setFolderFile(_packageDir).build();
        }

        for (BJInterface _interface : _interfaceColl) {
            if (_interface.getPackageName() == "") {
                _interface.setPackageName(_packageName);
            } else {
                _interface.setPackageName(_packageName + "." + _interface.getPackageName());
            }
            BJInterfaceWriter.createInstance(_interface).setFolderFile(_packageDir).build();
        }
    }

}

/*
 * BJPackage _package =
 * BJPackage.createInstance(PackageString).addClass(BJClass).addEnum(BJEnum).
 * addInterface(BJInterface);
 *
 * Used this stack of function calls to add class / enum / interface to the
 * package object
 */