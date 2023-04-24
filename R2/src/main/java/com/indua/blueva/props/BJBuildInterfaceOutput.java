package com.indua.blueva.props;

public class BJBuildInterfaceOutput {
    /**
     * This function creates an instance of the BJBuildInterfaceOutput class
     *
     * @return A new instance of BJBuildInterfaceOutput
     */
    public static BJBuildInterfaceOutput createInstance() {
        return new BJBuildInterfaceOutput();
    }

    private String _name;
    private String _message;
    private BJBuildStatus _buildStatus;

    private BJBuildInterfaceOutput() {
        _buildStatus = BJBuildStatus.SUCCESS;
        _message = "No error";
    }

    /**
     * It returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return _name;
    }

    /**
     * It sets the name of the interface.
     *
     * @param _name The name of the interface
     * @return The object itself.
     */
    public BJBuildInterfaceOutput setInterfaceName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * Returns the message
     *
     * @return The message.
     */
    public String getMessage() {
        return _message;
    }

    /**
     * It sets the message.
     *
     * @param _message The message to be displayed in the output window.
     * @return The object itself.
     */
    public BJBuildInterfaceOutput setMessage(String _message) {
        this._message = _message;
        return this;
    }

    /**
     * It returns the build status of the build.
     *
     * @return The build status of the build.
     */
    public BJBuildStatus getBuildStatus() {
        return _buildStatus;
    }

    /**
     * This function sets the build status of the build interface output
     *
     * @param _buildStatus The status of the build.
     * @return The object itself.
     */
    public BJBuildInterfaceOutput setBuildStatus(BJBuildStatus _buildStatus) {
        this._buildStatus = _buildStatus;
        return this;
    }
}
