package com.indua.blueva.code;

import java.util.ArrayList;
import java.util.HashMap;

public class BJClassObjWriter {
    private final BJClassObject _classObj;

    private BJClassObjWriter(BJClassObject _pclass) {
        this._classObj = _pclass;
    }

    /**
     * "Create a new instance of the BJClassObjWriter class, passing in the
     * BJClassObject class as a
     * parameter."
     *
     * The BJClassObjWriter class is a class that writes the BJClassObject class to
     * a file
     *
     * @param _pClassObj The class object that you want to write to a file.
     * @return A new instance of BJClassObjWriter
     */
    public static BJClassObjWriter createInstance(BJClassObject _pClassObj) {
        return new BJClassObjWriter(_pClassObj);
    }

    /**
     * It takes a class object, and returns a hashmap of the class object's schema,
     * class name, and a
     * list of hashmaps of the class object's methods
     *
     * @return A HashMap of the schema, class name, and method.
     */
    public HashMap<String, Object> build() throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        res.put("schema", this._classObj.getSchema());
        res.put("className", this._classObj.getClassName());

        ArrayList<HashMap<String, Object>> myres = new ArrayList<>();

        for (BJMethodObject _methodObj : this._classObj.getMethodColl()) {
            myres.add(BJMethodObjWriter.createInstance(_methodObj).build());
        }

        res.put("method", myres);

        return res;
    }
}
