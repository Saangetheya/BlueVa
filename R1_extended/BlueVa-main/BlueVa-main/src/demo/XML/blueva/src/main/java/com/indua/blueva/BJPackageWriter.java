package com.indua.blueva;

import com.indua.blueva.props.BJCreateClassInput;
import com.indua.blueva.props.BJCreateClassOutput;
import com.indua.blueva.props.BJCreateEnumInput;
import com.indua.blueva.props.BJCreateEnumOutput;
import com.indua.blueva.props.BJCreateInterfaceInput;
import com.indua.blueva.props.BJCreateInterfaceOutput;
import com.indua.blueva.util.BJCreateStatus;

public class BJPackageWriter {

    private BJPackageClassColl classColl;
    private BJPackageEnumColl enumColl;
    private BJPackageInterfaceColl interfaceColl;

    private String _packageName;

    public String GetPackageName() {
        return _packageName;
    }

    public void SetPackageName(String name) {
        this._packageName = name;
    }

    public String GetXmlFileName() {
        return String.format("%s.xml", this._packageName);
    }

    public BJCreateClassOutput AddClass(BJCreateClassInput createClassInput) {
        if (classColl.Contains(createClassInput.GetName())) {
            return BJCreateClassOutput.CreateInstance().SetStatus(BJCreateStatus.ALREADYEXISTS)
                    .SetMsg(String.format("Class %s Already exists", createClassInput.GetName()));
        }

        // TODO: Xml code to generate the class

        return BJCreateClassOutput.CreateInstance().SetStatus(BJCreateStatus.SUCCESS)
                .SetMsg(String.format("Class %s Successfully created",createClassInput.GetName()));

    }

    public BJCreateEnumOutput AddEnum(BJCreateEnumInput createEnumInput) {
        if (enumColl.Contains(createEnumInput.GetName())) {
            return BJCreateEnumOutput.CreateInstance().SetStatus(BJCreateStatus.ALREADYEXISTS)
            .SetMsg(String.format("Enum %s Already exists", createEnumInput.GetName()));
        }

        // TODO: Xml code to generate the enum

        return BJCreateEnumOutput.CreateInstance().SetStatus(BJCreateStatus.SUCCESS)
        .SetMsg(String.format("Enum %s Successfully created",createEnumInput.GetName()));
    }

    public BJCreateInterfaceOutput AddInterface(BJCreateInterfaceInput createInterfaceInput) {
        if (interfaceColl.Contains(createInterfaceInput.GetName())) {
            return BJCreateInterfaceOutput.CreateInstance().SetStatus(BJCreateStatus.ALREADYEXISTS)
            .SetMsg(String.format("Interface %s Already exists", createInterfaceInput.GetName()));
        }

        // TODO: Xml code to generate the interface

        return BJCreateInterfaceOutput.CreateInstance().SetStatus(BJCreateStatus.SUCCESS)
        .SetMsg(String.format("Interface %s Successfully created",createInterfaceInput.GetName()));
    }
}
