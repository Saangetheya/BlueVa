package com.indua.blueva.code;

import java.util.ArrayList;
import java.util.HashMap;

public class BJMethodObjWriter {
    private final BJMethodObject _methodObj;

    // A constructor.
    private BJMethodObjWriter(BJMethodObject _pmethod) {
        this._methodObj = _pmethod;
    }

    /**
     * This function creates an instance of the BJMethodObjWriter class
     *
     * @param _pmethodObj The method object that you want to write to the file.
     * @return A new instance of BJMethodObjWriter
     */
    public static BJMethodObjWriter createInstance(BJMethodObject _pmethodObj) {
        return new BJMethodObjWriter(_pmethodObj);
    }

    /**
     * It takes a method object, and returns a hashmap of the method's name, codeId,
     * code, doc, and tags
     *
     * @return A HashMap of the method object.
     */
    public HashMap<String, Object> build() throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        res.put("name", this._methodObj.getName());
        res.put("codeId", this._methodObj.getId().toString());
        res.put("code", this._methodObj.getNodeSet().build());
        res.put("doc", this._methodObj.getDoc());

        if (this._methodObj.getHasTags()) {
            ArrayList<HashMap<String, Object>> myarr = new ArrayList<>();
            for (BJTagObject _pTag : this._methodObj.getTagColl()) {
                myarr.add(BJTagObjWriter.createInstance(_pTag).build());
            }

            res.put("tag", myarr);
        }

        return res;
    }
}
