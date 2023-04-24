package com.indua.blueva.code;

import java.util.ArrayList;

import com.indua.blueva.props.BJId;
import com.indua.blueva.props.BJNodeSet;

public class BJMethodObject {

    private String _name;
    private final BJId _id;
    private BJNodeSet _nodeSet;
    private String _doc;
    private ArrayList<BJTagObject> _tagColl;
    private boolean _hasTags;

    // A constructor.
    public BJMethodObject(BJId _pid) {
        this._id = _pid;
        _hasTags = false;

        _tagColl = new ArrayList<>();
    }

    /**
     * Returns the name
     *
     * @return The name of the person.
     */
    public String getName() {
        return _name;
    }

    /**
     * This function returns a boolean value that indicates whether the current
     * object has tags
     *
     * @return A boolean value.
     */
    public boolean getHasTags() {
        return this._hasTags;
    }

    /**
     * This function sets the value of the private variable _hasTags to the value of
     * the parameter
     * _pHasTags and returns the object
     *
     * @param _pHasTags boolean
     * @return The object itself.
     */

    public BJMethodObject setHasTags(boolean _pHasTags) {
        this._hasTags = _pHasTags;
        return this;
    }

    /**
     * The function returns the object itself, so that the function can be chained
     *
     * @param _name The name of the method.
     * @return The object itself.
     */

    public BJMethodObject setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * It returns the id of the object.
     *
     * @return The _id field is being returned.
     */

    public BJId getId() {
        return _id;
    }

    /**
     * Returns the Node set
     *
     * @return The node set.
     */

    public BJNodeSet getNodeSet() {
        return _nodeSet;
    }

    /**
     * This function sets the node set of the method object
     *
     * @param _nodeSet The node set that the method is being called on.
     * @return The MethodObject is being returned.
     */

    public BJMethodObject setNodeSet(BJNodeSet _nodeSet) {
        this._nodeSet = _nodeSet;
        return this;
    }

    /**
     * Returns the doc string
     *
     * @return The _doc variable is being returned.
     */

    public String getDoc() {
        return _doc;
    }

    /**
     * This function sets the value of the _doc variable to the value of the _doc
     * parameter
     *
     * @param _doc The documentation for the method.
     * @return The object itself.
     */

    public BJMethodObject setDoc(String _doc) {
        this._doc = _doc;
        return this;
    }

    /**
     * If the method has tags, return the tag collection
     *
     * @return An ArrayList of TagObjects
     */

    public ArrayList<BJTagObject> getTagColl() throws Exception {
        if (!this._hasTags) {
            throw new Exception("Tag is disabled for this MethodObject");
        }
        return _tagColl;
    }

    public BJMethodObject addTag(BJTagObject _tag) throws Exception {
        if (!this._hasTags) {
            throw new Exception("Tag is disabled for this MethodObject");
        }
        this._tagColl.add(_tag);
        return this;
    }
}

/**
 *
 * MethodObject.createInstance()
 *
 */
