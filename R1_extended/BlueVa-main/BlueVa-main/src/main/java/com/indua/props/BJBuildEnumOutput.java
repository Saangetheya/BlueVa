package com.indua.props;

import com.indua.utils.BJBuildStatus;

public class BJBuildEnumOutput {
    public static BJBuildEnumOutput CreateInstance() {
        return new BJBuildEnumOutput();
    }
    private String _enumName;
    private String _message;

    private BJBuildStatus _buildStatus;

    private BJBuildEnumOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    public String GetClassName() {
        return _enumName;
    }

    public BJBuildEnumOutput SetClassName(String _enumName) {
        this._enumName = _enumName;
        return this;
    }

    public String GetMessage() {
        return _message;
    }

    public BJBuildEnumOutput SetMessage(String _message) {
        this._message = _message;
        return this;
    }

    public BJBuildStatus GetBuildStatus() {
        return _buildStatus;
    }

    public BJBuildEnumOutput SetBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
