package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJParameter;

public class BJParameterElemBuilder {
    private final Document _document;
    private Element _element;
    private final BJParameter _parameter;

    // Creating a new element called parameter.
    public BJParameterElemBuilder(Document _pdocument, BJParameter _pparameter) {
        _document = _pdocument;
        _parameter = _pparameter;

        _element = _document.createElement("parameter");
    }

    /**
     * This function creates an XML element with two attributes, one of which is the
     * name of the
     * parameter and the other is the output of the parameter.
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_parameter.getName());

        Attr outputAttr = _document.createAttribute("output");
        outputAttr.setNodeValue(_parameter.getOutput().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(outputAttr);

        return _element;
    }
}

/**
 * name="" output=""
 */
