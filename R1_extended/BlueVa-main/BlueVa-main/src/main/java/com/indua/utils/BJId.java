package com.indua.utils;

import java.util.UUID;

public class BJId {
    public static BJId CreateInstance() {
        return new BJId();
    }

    private UUID _id;

    private BJId() {

    }

    public UUID GetId() {
        return _id;
    }

    public void SetId(UUID _id) {
        this._id = _id;
    }
}
