package com.indua.blueva.props;

import com.indua.blueva.util.BJCreateStatus;

public class BJCreateClassOutput {
    private BJCreateStatus _status;
    private String _msg;

    public BJCreateStatus GetStatus() {
        return _status;
    }

    public String GetMsg() {
        return _msg;
    }

    public BJCreateClassOutput SetStatus(BJCreateStatus _classStatus) {
        this._status = _classStatus;
        return this;
    }

    public BJCreateClassOutput SetMsg(String _msg) {
        this._msg = _msg;
        return this;
    }

    private BJCreateClassOutput() {

    }

    public static BJCreateClassOutput CreateInstance() {
        return new BJCreateClassOutput();
    }
}
