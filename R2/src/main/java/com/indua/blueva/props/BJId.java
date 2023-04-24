package com.indua.blueva.props;

import java.util.UUID;

public class BJId {
    /**
     * This function creates a new instance of the BJId class and returns it.
     *
     * @return A new instance of BJId
     */
    public static BJId createInstance(UUID _pid) {
        return new BJId(_pid);
    }

    private final UUID _id;

    private BJId(UUID _pid) {
        _id = _pid;
    }

    /**
     * This function returns the UUID of the object
     *
     * @return The UUID of the object.
     */
    public UUID getId() {
        return _id;
    }

   /**
    * This function returns a string representation of the object.
    *
    * @return The id of the object.
    */
    @Override
    public String toString() {
        return String.format("%s", this._id.toString());
    }
}
