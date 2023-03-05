package com.indua.props;


import com.indua.utils.BJBuildStatus;

public class BJBuildClassOutput {
    public static BJBuildClassOutput CreateInstance() {
        return new BJBuildClassOutput();
    }
    private String _className;
    private String _message;

    private BJBuildStatus _buildStatus;

    private BJBuildClassOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    public String GetClassName() {
        return _className;
    }

    public BJBuildClassOutput SetClassName(String _className) {
        this._className = _className;
        return this;
    }

    public String GetMessage() {
        return _message;
    }

    public BJBuildClassOutput SetMessage(String _message) {
        this._message = _message;
        return this;
    }

    public BJBuildStatus GetBuildStatus() {
        return _buildStatus;
    }

    public BJBuildClassOutput SetBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
