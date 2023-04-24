package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJField;

public class BJFieldElemBuilder {
    private final Document _document;
    private final BJField _field;
    private Element _element;
    // Creating a new element called field.

    public BJFieldElemBuilder(Document _pdocument, BJField _pfield) {
        _document = _pdocument;
        _field = _pfield;

        _element = _document.createElement("field");
    }

    /**
     * This function creates an XML element with the attributes of the field object
     *
     * @return The element that was created.
     */
    public Element build() {

        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_field.getName());

        Attr outputAttr = _document.createAttribute("output");
        outputAttr.setNodeValue(_field.getOutput().toString());

        Attr valueAttr = _document.createAttribute("value");
        valueAttr.setNodeValue(_field.getValue());

        Attr accmodAttr = _document.createAttribute("accmod");
        accmodAttr.setNodeValue(_field.getAccModifier().toString());

        Attr naccmodAttr = _document.createAttribute("naccmod");
        naccmodAttr.setNodeValue(_field.getNaccModifier().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(outputAttr);
        _element.setAttributeNode(valueAttr);
        _element.setAttributeNode(accmodAttr);
        _element.setAttributeNode(naccmodAttr);

        return _element;
    }
}

/*
 * name="" type="" value="" accmod="" naccmod=""
 */
