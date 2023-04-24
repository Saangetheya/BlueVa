package com.indua.blueva.code;

import java.util.HashMap;

public class BJTagObjWriter {
    private final BJTagObject _tag;

    // A constructor.
    private BJTagObjWriter(BJTagObject _ptag) {
        this._tag = _ptag;
    }

    /**
     * * It creates a new instance of the BJTagObjWriter class, and returns it
     *
     * @param _ptag The tag object to be written.
     * @return A new instance of BJTagObjWriter
     */
    public static BJTagObjWriter createInstance(BJTagObject _ptag) {
        return new BJTagObjWriter(_ptag);
    }

    /**
     * This function returns a HashMap with a single key-value pair, where the key
     * is "name" and the
     * value is the value of the _tag field
     *
     * @return A HashMap with a key of "name" and a value of the tag.
     */
    public HashMap<String, Object> build() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("name", this._tag.toString());
        return res;
    }
}

/*
 * BJTagWObjWriter.createInstance(BJTag).build() : HashMap<String,Object>
 */
