package com.indua.blueva.props;

import com.indua.blueva.util.BJCreateStatus;

public class BJCreateEnumOutput {
    private BJCreateStatus _status;
    private String _msg;

    public BJCreateStatus GetStatus() {
        return _status;
    }

    public String GetMsg() {
        return _msg;
    }

    public BJCreateEnumOutput SetStatus(BJCreateStatus _classStatus) {
        this._status = _classStatus;
        return this;
    }

    public BJCreateEnumOutput SetMsg(String _msg) {
        this._msg = _msg;
        return this;
    }

    private BJCreateEnumOutput() {

    }

    public static BJCreateEnumOutput CreateInstance() {
        return new BJCreateEnumOutput();
    }
}
