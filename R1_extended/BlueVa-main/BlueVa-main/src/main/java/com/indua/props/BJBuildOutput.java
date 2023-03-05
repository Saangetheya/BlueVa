package com.indua.props;

import java.util.ArrayList;

public class BJBuildOutput {
    private ArrayList<BJBuildClassOutput> _classOutputs;
    private ArrayList<BJBuildEnumOutput> _enumOutputs;
    private ArrayList<BJBuildInterfaceOutput> _interfaceOutputs;

    private BJBuildOutput() {
        _classOutputs = new ArrayList<>();
        _enumOutputs = new ArrayList<>();
        _interfaceOutputs = new ArrayList<>();
    }

    public static BJBuildOutput CreateInstance() {
        return new BJBuildOutput();
    }

    public BJBuildOutput AddBuildClassOutput(BJBuildClassOutput _classOutput) {
        _classOutputs.add(_classOutput);
        return this;
    }

    public BJBuildOutput AddBuildInterfaceOutput(BJBuildInterfaceOutput _interfaceOutput) {
        _interfaceOutputs.add(_interfaceOutput);
        return this;
    }

    public BJBuildOutput AddBuildEnumOutput(BJBuildEnumOutput _enumOutput) {
        _enumOutputs.add(_enumOutput);
        return this;
    }
}
