package com.indua.blueva.layout;

import com.indua.blueva.props.BJClass;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJPackage;
import com.indua.blueva.props.BJEnum;
import com.indua.blueva.props.BJInterface;

public class BJPackageElemBuilder {
    private final Document _document;
    private final BJPackage _package;
    private Element _element;

    // A constructor.
    public BJPackageElemBuilder(Document _pdocument, BJPackage _pinterface) {
        _document = _pdocument;
        _package = _pinterface;

        _element = _document.createElement("package");
    }

    /**
     * It creates an XML element for a Java package, and adds XML elements for the
     * classes, enums, and
     * interfaces in the package
     *
     * @return The Element object.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_package.getName());

        _element.setAttributeNode(nameAttr);

        for (BJClass _class : _package.getClassColl()) {
            _element.appendChild(BJElementBuilder.createInstance(_document).createClassBuilder(_class).build());
        }

        for (BJEnum _enum : _package.getEnumColl()) {
            _element.appendChild(BJElementBuilder.createInstance(_document).createEnumBuilder(_enum).build());
        }

        for (BJInterface _interface : _package.getInterfaceColl()) {
            _element.appendChild(BJElementBuilder.createInstance(_document).createInterfaceBuilder(_interface).build());
        }

        return _element;
    }
}
