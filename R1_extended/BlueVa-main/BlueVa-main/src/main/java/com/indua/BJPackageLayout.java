package com.indua;

import java.util.ArrayList;

import com.indua.props.BJBuildOutput;
import com.indua.props.BJClass;
import com.indua.props.BJEnum;
import com.indua.props.BJInterface;

public class BJPackageLayout {
    private String _packageName;
    private ArrayList<BJClass> _classColl;
    private ArrayList<BJEnum> _enumColl;
    private ArrayList<BJInterface> _interfaceColl;

    private ArrayList<String> _classNames;
    private ArrayList<String> _enumNames;
    private ArrayList<String> _interfaceNames;

    public String GetPackageName() {
        return _packageName;
    }

    public BJPackageLayout SetPackageName(String _packageName) {
        this._packageName = _packageName;
        return this;
    }

    public ArrayList<BJClass> GetClassColl() {
        return _classColl;
    }

    public BJPackageLayout SetClassColl(ArrayList<BJClass> _classColl) {
        this._classColl = _classColl;
        return this;
    }

    public ArrayList<BJEnum> GetEnumColl() {
        return _enumColl;
    }

    public BJPackageLayout SetEnumColl(ArrayList<BJEnum> _enumColl) {
        this._enumColl = _enumColl;
        return this;
    }

    public ArrayList<BJInterface> GetInterfaceColl() {
        return _interfaceColl;
    }

    public BJPackageLayout SetInterfaceColl(ArrayList<BJInterface> _interfaceColl) {
        this._interfaceColl = _interfaceColl;
        return this;
    }

    public ArrayList<String> GetClassNames() {
        return _classNames;
    }

    public BJPackageLayout SetClassNames(ArrayList<String> _classNames) {
        this._classNames = _classNames;
        return this;
    }

    public ArrayList<String> GetEnumNames() {
        return _enumNames;
    }

    public BJPackageLayout SetEnumNames(ArrayList<String> _enumNames) {
        this._enumNames = _enumNames;
        return this;
    }

    public ArrayList<String> GetInterfaceNames() {
        return _interfaceNames;
    }

    public BJPackageLayout SetInterfaceNames(ArrayList<String> _interfaceNames) {
        this._interfaceNames = _interfaceNames;
        return this;
    }

    private BJPackageLayout() {
        _classColl = new ArrayList<>();
        _interfaceColl = new ArrayList<>();
        _enumColl = new ArrayList<>();

        _classNames = new ArrayList<>();
        _enumNames = new ArrayList<>();
        _interfaceNames = new ArrayList<>();
    }

    public static BJPackageLayout CreateInstance(String _packageName) {
        BJPackageLayout packageLayout = new BJPackageLayout();
        packageLayout.SetName(_packageName);

        return packageLayout;
    }

    public String GetName() {
        return this._packageName;
    }

    public BJPackageLayout SetName(String _packageName) {
        this._packageName = _packageName;
        return this;
    }

    public BJBuildOutput BuildContent() {
        
    }
}
