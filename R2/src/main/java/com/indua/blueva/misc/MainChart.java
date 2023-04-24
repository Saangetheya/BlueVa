package com.indua.blueva.misc;

import java.util.ArrayList;
import java.util.UUID;

import javax.lang.model.element.Modifier;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJField;
import com.indua.blueva.props.BJId;
import com.indua.blueva.props.BJMethodClass;
import com.indua.blueva.props.BJParameter;
import com.indua.blueva.utils.BJAccessModifier;
import com.indua.blueva.utils.BJPrimTypes;

public class MainChart {
    private ArrayList<BJMethodClass> _methodColl;
    private ArrayList<BJField> _fieldColl;

    public static MainChart createInstance() {
        return new MainChart();
    }

    private MainChart() {
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();

        BJMethodClass mainMethod = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
                .setName("main").setOutput(BJPrimTypes.VOID)
                .setNaccModifier(Modifier.STATIC)
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(
                        BJParameter.createInstance().setName("args").setIsArray(true).setOutput(BJPrimTypes.STRING))
                .setCode("System.out.println(\"Hello Mom!\");");

        _methodColl.add(mainMethod);
    }

    public void FillBjClass(BJClass bjClass) {
        for(BJMethodClass method : _methodColl) {
            bjClass.addMethod(method);
        }

        for(BJField field : _fieldColl) {
            bjClass.addField(field);
        }
    }
}