package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJValue;

public class BJValueElemBuilder {
    private final Document _document;
    private Element _element;
    private final BJValue _value;

    // Creating a new element called value.
    public BJValueElemBuilder(Document _pdocument, BJValue _pvalue) {
        _document = _pdocument;
        _value = _pvalue;

        _element = _document.createElement("value");
    }

    /**
     * This function creates an XML element with two attributes, one of which is the
     * name of the element
     * and the other is the value of the element.
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_value.getName());

        Attr outputAttr = _document.createAttribute("value");
        outputAttr.setNodeValue(Integer.toString(_value.getValue()));

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(outputAttr);

        return _element;
    }
}
