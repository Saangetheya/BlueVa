package com.indua.blueva.props;

import com.indua.blueva.util.BJCreateStatus;

public class BJCreateInterfaceOutput {
    private BJCreateStatus _status;
    private String _msg;

    public BJCreateStatus GetStatus() {
        return _status;
    }

    public String GetMsg() {
        return _msg;
    }

    public BJCreateInterfaceOutput SetStatus(BJCreateStatus _classStatus) {
        this._status = _classStatus;
        return this;
    }

    public BJCreateInterfaceOutput SetMsg(String _msg) {
        this._msg = _msg;
        return this;
    }

    private BJCreateInterfaceOutput() {

    }

    public static BJCreateInterfaceOutput CreateInstance() {
        return new BJCreateInterfaceOutput();
    }
}
