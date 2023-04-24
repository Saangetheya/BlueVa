package com.indua.blueva.code;

import com.indua.blueva.props.BJTag;

public class BJTagObject {
    private final BJTag _tag;

    public BJTagObject(BJTag _ptags) {
        _tag = _ptags;
    }

    /**
     * It returns the tag of the current object.
     *
     * @return The tag of the current node.
     */
    public BJTag getTag() {
        return this._tag;
    }
}
