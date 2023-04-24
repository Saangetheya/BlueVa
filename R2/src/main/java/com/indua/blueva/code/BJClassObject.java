package com.indua.blueva.code;

import java.util.ArrayList;
import java.util.UUID;

import com.indua.blueva.props.BJId;

public class BJClassObject {

    private final String _schema;
    private final String _className;
    private ArrayList<BJMethodObject> _methodColl;
    private ArrayList<BJId> _ids;

    public BJClassObject(String _pschema, String _pclassName) {
        _schema = _pschema;
        _className = _pclassName;

        _methodColl = new ArrayList<>();
        _ids = new ArrayList<>();
    }

    /**
     * This function returns the schema of the table
     *
     * @return The schema of the database.
     */

    public String getSchema() {
        return _schema;
    }

    /**
     * It returns the class name.
     *
     * @return The class name.
     */
    public String getClassName() {
        return _className;
    }

    /**
     * This function returns the value of the private variable _methodColl
     *
     * @return An ArrayList of MethodObjects.
     */

    public ArrayList<BJMethodObject> getMethodColl() {
        return _methodColl;
    }

    /**
     * Adds Method Object to Method Collection
     *
     * @param _pmethodObj MethodObject
     */
    public BJClassObject addMethodObj(BJMethodObject _pmethodObj) {
        this._methodColl.add(_pmethodObj);
        return this;
    }

    /**
     * It creates a unique ID
     *
     * @return A BJId object.
     */
    public BJId createUniqueId() {
        boolean isUnique = true;
        UUID myRes = new UUID(0, 0);

        while (isUnique) {
            UUID myId = UUID.randomUUID();

            for (BJId _myId : this._ids) {
                if (_myId.getId().compareTo(myId) == 0) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                myRes = myId;
                break;
            }

            isUnique = true;
        }
        BJId myIdOut = BJId.createInstance(myRes);
        this._ids.add(myIdOut);
        return myIdOut;
    }
}

/*
 * ClassObject obj = ClassObject.createInstance(String,String)
 * obj.addMethodObj(MethodObject.createInstance(obj.createUniqueId()).setNameColumn0(
 * String).setDoc(String).setCode(BJNodeSet.build()).addTag(TagObject))
 *
 * obj.build()
 *
 * BJCode obj = new BJCode();
 */
