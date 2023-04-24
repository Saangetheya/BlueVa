package com.indua.blueva.layout;

import com.indua.blueva.props.BJMethod;
import org.w3c.dom.Document;

import com.indua.blueva.props.BJPackage;
import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJEnum;
import com.indua.blueva.props.BJValue;
import com.indua.blueva.props.BJField;
import com.indua.blueva.props.BJInterface;
import com.indua.blueva.props.BJMethodClass;
import com.indua.blueva.props.BJMethodInterface;
import com.indua.blueva.props.BJMethodType;
import com.indua.blueva.props.BJParameter;

public class BJElementBuilder {

    private final Document _document;

    private BJElementBuilder(Document _pdocument) {
        _document = _pdocument;
    }

    /**
     * This function creates a new instance of the BJElementBuilder class, and
     * returns it.
     *
     * @param _pdocument The document that the element will be created in.
     * @return A new instance of BJElementBuilder
     */
    public static BJElementBuilder createInstance(Document _pdocument) {
        return new BJElementBuilder(_pdocument);
    }

    /**
     * This function creates a new instance of the BJClassElemBuilder class, which
     * is a class that
     * extends the BJElemBuilder class.
     *
     * @param _pclass The class that is being built.
     * @return A new BJClassElemBuilder object.
     */
    public BJClassElemBuilder createClassBuilder(BJClass _pclass) {
        return new BJClassElemBuilder(_document, _pclass);
    }

    /**
     * It creates a new instance of the BJEnumElemBuilder class, passing in the
     * document and the enum
     *
     * @param _penum The enum to be built
     * @return A BJEnumElemBuilder object.
     */
    public BJEnumElemBuilder createEnumBuilder(BJEnum _penum) {
        return new BJEnumElemBuilder(_document, _penum);
    }

    /**
     * Creates a new interface builder with passed Document object and BJInterface
     * object
     *
     * @param _interface The interface to be built
     * @return A BJInterfaceElemBuilder object.
     */
    public BJInterfaceElemBuilder createInterfaceBuilder(BJInterface _interface) {
        return new BJInterfaceElemBuilder(_document, _interface);
    }

    /**
     * If the method is a class method, return a new BJMethodClassElemBuilder,
     * otherwise return a new
     * BJMethodInterElemBuilder.
     *
     * @param _methodType The type of method (class or interface)
     * @param _method     The method to be built
     * @return A BJMethodElemBuilder object.
     */
    public BJMethodElemBuilder createMethodBuilder(BJMethodType _methodType, BJMethod _method) {
        if (_methodType == BJMethodType.CLASS) {
            return new BJMethodClassElemBuilder(_document, (BJMethodClass) _method);
        } else {
            return new BJMethodInterElemBuilder(_document, (BJMethodInterface) _method);
        }
    }

    /**
     * This function creates a new BJFieldElemBuilder object, which is a class that
     * is used to create a
     * new BJFieldElem object.
     *
     * The BJFieldElemBuilder class is defined in the following file:
     *
     * @param _pfield The field that you want to create a builder for.
     * @return A BJFieldElemBuilder object.
     */
    public BJFieldElemBuilder createFieldBuilder(BJField _pfield) {
        return new BJFieldElemBuilder(_document, _pfield);
    }

    /**
     * This function creates a new BJPackageElemBuilder object, which is a subclass
     * of BJElemBuilder and returns it.
     *
     * @param _ppackage The package to be built
     * @return A BJPackageElemBuilder object.
     */
    public BJPackageElemBuilder createPackageBuilder(BJPackage _ppackage) {
        return new BJPackageElemBuilder(_document, _ppackage);
    }

    /**
     * It creates a new instance of the BJParameterElemBuilder class, passing in the
     * document and parameter
     *
     * @param _pparameter The parameter to be built
     * @return A new BJParameterElemBuilder object.
     */
    public BJParameterElemBuilder createParameterBuilder(BJParameter _pparameter) {
        return new BJParameterElemBuilder(_document, _pparameter);
    }

    /**
     * This function creates a new BJValueElemBuilder object, which is a subclass of
     * BJElemBuilder, and
     * returns it.
     *
     * @param _penumValue The value of the enumeration
     * @return A BJValueElemBuilder object.
     */
    public BJValueElemBuilder createValueBuilder(BJValue _penumValue) {
        return new BJValueElemBuilder(_document, _penumValue);
    }
}
