package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJInterface;
import com.indua.blueva.props.BJMethodInterface;
import com.indua.blueva.props.BJMethodType;
import com.indua.blueva.utils.Utility;

public class BJInterfaceElemBuilder {
    private final Document _document;
    private final BJInterface _interface;
    private Element _element;

    // Creating an element called interface.
    public BJInterfaceElemBuilder(Document _pdocument, BJInterface _pinterface) {
        _document = _pdocument;
        _interface = _pinterface;

        _element = _document.createElement("interface");
    }

    /**
     * It creates an XML element for an interface, and adds the interface's name,
     * access modifier, and
     * implementing interfaces as attributes, and then adds the interface's methods
     * as child elements
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_interface.getName());

        Attr implementsAttr = _document.createAttribute("implements");
        implementsAttr.setNodeValue(Utility.getArrayString(_interface.getImplementingInterfaces()));

        Attr accmodAttr = _document.createAttribute("accmod");
        accmodAttr.setNodeValue(_interface.getAccModifier().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(implementsAttr);
        _element.setAttributeNode(accmodAttr);

        for (BJMethodInterface _method : _interface.getMethodColl()) {
            _element.appendChild(((BJMethodInterElemBuilder) BJElementBuilder.createInstance(_document)
                    .createMethodBuilder(BJMethodType.INTERFACE, _method)).build());
        }

        return _element;
    }
}

/**
 * name="" implements="" accmod=""
 */
