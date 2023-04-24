package com.indua.blueva.props;

import java.util.ArrayList;

public class BJBuildOutput {
    /**
     * It creates an instance of BJBuildOutput.
     *
     * @return A new instance of BJBuildOutput.
     */
    public static BJBuildOutput createInstance() {
        return new BJBuildOutput();
    }

    private ArrayList<BJBuildClassOutput> _classOutputs;
    private ArrayList<BJBuildEnumOutput> _enumOutputs;

    private ArrayList<BJBuildInterfaceOutput> _interfaceOutputs;

    private BJBuildOutput() {
        _classOutputs = new ArrayList<>();
        _enumOutputs = new ArrayList<>();
        _interfaceOutputs = new ArrayList<>();
    }

    /**
     * It adds a class output to the build output
     *
     * @param _classOutput The class output to add to the build output.
     * @return The BJBuildOutput object.
     */
    public BJBuildOutput addBuildClassOutput(BJBuildClassOutput _classOutput) {
        _classOutputs.add(_classOutput);
        return this;
    }

    /**
     * @param _interfaceOutput The interface output to add to the build output.
     * @return The BJBuildOutput object.
     */
    public BJBuildOutput addBuildInterfaceOutput(BJBuildInterfaceOutput _interfaceOutput) {
        _interfaceOutputs.add(_interfaceOutput);
        return this;
    }

    /**
     * It adds a BJBuildEnumOutput to the list of BJBuildEnumOutputs
     *
     * @param _enumOutput The enum output to add to the build output.
     * @return The BJBuildOutput object.
     */
    public BJBuildOutput addBuildEnumOutput(BJBuildEnumOutput _enumOutput) {
        _enumOutputs.add(_enumOutput);
        return this;
    }

    /**
     * It returns the class outputs.
     *
     * @return An ArrayList of BJBuildClassOutput objects.
     */
    public ArrayList<BJBuildClassOutput> getClassOutputColl() {
        return this._classOutputs;
    }

    /**
     * This function returns an ArrayList of BJBuildEnumOutput objects
     *
     * @return An ArrayList of BJBuildEnumOutput objects.
     */
    public ArrayList<BJBuildEnumOutput> getEnumOutputColl() {
        return this._enumOutputs;
    }

    /**
     * This function returns an ArrayList of BJBuildInterfaceOutput objects
     *
     * @return An ArrayList of BJBuildInterfaceOutput objects.
     */
    public ArrayList<BJBuildInterfaceOutput> getInterfaceOutputColl() {
        return this._interfaceOutputs;
    }
}
