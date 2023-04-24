package com.indua.blueva.props;

public class BJBuildEnumOutput {
    /**
     * This function creates an instance of the BJBuildEnumOutput class.
     *
     * @return A new instance of BJBuildEnumOutput
     */
    public static BJBuildEnumOutput createInstance() {
        return new BJBuildEnumOutput();
    }

    private String _name;
    private String _message;
    private BJBuildStatus _buildStatus;

    private BJBuildEnumOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    /**
     * This function returns the name of the enum
     *
     * @return The name of the enum.
     */
    public String getEnumName() {
        return _name;
    }

    /**
     * This function sets the name of the enum
     *
     * @param _name The name of the enum
     * @return The object itself.
     */
    public BJBuildEnumOutput setEnumName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * This function returns the message of the object
     *
     * @return The message.
     */

    public String getMessage() {
        return _message;
    }

    /**
     *
     * @param _message The message to be displayed in the output window.
     * @return The object itself.
     */

    public BJBuildEnumOutput setMessage(String _message) {
        this._message = _message;
        return this;
    }

    /**
     * This function returns the build status of the build
     *
     * @return The build status of the build.
     */

    public BJBuildStatus getBuildStatus() {
        return _buildStatus;
    }

    /**
     * This function sets the build status of the build
     *
     * @param _buildStatus The status of the build.
     * @return The object itself.
     */
    public BJBuildEnumOutput setBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
