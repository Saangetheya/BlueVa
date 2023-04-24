package com.indua.blueva.props;

import java.util.ArrayList;

public class BJImports {
    private ArrayList<BJImport> _importColl;

    private BJImports() {
        _importColl = new ArrayList<>();
    }

    /**
     * Creates new instance of BJImports
     *
     * @return A new instance of BJImports.
     */
    public static BJImports createInstance() {
        return new BJImports();
    }

    /**
     * This function returns the value of the private variable _importColl.
     *
     * @return The value of the variable _importColl.
     */
    public ArrayList<BJImport> getImportColl() {
        return _importColl;
    }

    /**
     * This function sets the value of the private variable _importColl to the
     * value passed in as a parameter.
     *
     * @param _importColl The value of the variable _importColl.
     * @return The object itself.
     */
    public BJImports setImportColl(ArrayList<BJImport> _importColl) {
        this._importColl = _importColl;
        return this;
    }

    /**
     * This function adds the value passed in as a parameter to the private
     * variable _importColl.
     *
     * @param _import The value to be added to the variable _importColl.
     * @return The object itself.
     */
    public BJImports addImport(BJImport _import) {
        this._importColl.add(_import);
        return this;
    }

    public boolean isImported(BJImport pimport) {
        for (BJImport _import : _importColl) {
            if (_import.getPackageName().equals(pimport.getPackageName())
                    && _import.getSimpleName().equals(pimport.getSimpleName())
                    && _import.getLeafName().equals(pimport.getLeafName())
                    || _import.getPackageName().equals(pimport.getPackageName())
                    && _import.getSimpleName().equals(pimport.getSimpleName())
                    && _import.getLeafName().equals("*")) {
                return true;
            }
        }
        return false;
    }

    public boolean removeImport(BJImport pimport) {
        return this._importColl.remove(pimport);
    }
}