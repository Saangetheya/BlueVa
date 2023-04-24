package com.indua.blueva.props;

public class BJBuildClassOutput {
    /**
     * It creates an instance of the BJBuildClassOutput class.
     *
     * @return A new instance of BJBuildClassOutput
     */
    public static BJBuildClassOutput createInstance() {
        return new BJBuildClassOutput();
    }

    private String _className;
    private String _message;
    private BJBuildStatus _buildStatus;

    private BJBuildClassOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    /**
     * This function returns the class name of the object
     *
     * @return The class name.
     */

    public String getClassName() {
        return _className;
    }

    /**
     * It sets the class name.
     *
     * @param _className The name of the class to be created.
     * @return The object itself.
     */
    public BJBuildClassOutput setClassName(String _className) {
        this._className = _className;
        return this;
    }

    /**
     * This function returns the message of the exception
     *
     * @return The message.
     */
    public String getMessage() {
        return _message;
    }

    /**
     * This function sets the message of the class to the message that is passed in
     *
     * @param _message The message to display in the build log.
     * @return The object itself.
     */
    public BJBuildClassOutput setMessage(String _message) {
        this._message = _message;
        return this;
    }

    /**
     * This function returns the build status of the current build
     *
     * @return The build status of the build job.
     */
    public BJBuildStatus getBuildStatus() {
        return _buildStatus;
    }

    /**
     * It sets the build status of the class output
     *
     * @param _buildStatus The status of the build.
     * @return The object itself.
     */
    public BJBuildClassOutput setBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
