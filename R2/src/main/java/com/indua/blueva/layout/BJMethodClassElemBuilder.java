package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJMethodClass;

public class BJMethodClassElemBuilder extends BJMethodElemBuilder{

    private final Document _document;
    private Element _element;
    private final BJMethodClass _method;

    // Creating a new element called method.
    public BJMethodClassElemBuilder(Document _pdocument, BJMethodClass _pmethod) {
        _document = _pdocument;
        _method = _pmethod;

        _element = _document.createElement("method");
    }

    /**
     * It creates an element and sets the attributes of the element to the values of
     * the fields of the
     * object
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        Attr outputAttr = _document.createAttribute("output");
        Attr idAttr = _document.createAttribute("id");
        Attr accmodAttr = _document.createAttribute("accmod");
        Attr naccmodAttr = _document.createAttribute("naccmod");

        nameAttr.setNodeValue(_method.getName());
        outputAttr.setNodeValue(_method.getOutput().toString());
        idAttr.setNodeValue(_method.getBjId().toString());
        accmodAttr.setNodeValue(_method.getAccModifier().toString());
        naccmodAttr.setNodeValue(_method.getNaccModifier().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(outputAttr);
        _element.setAttributeNode(idAttr);
        _element.setAttributeNode(accmodAttr);
        _element.setAttributeNode(naccmodAttr);

        return _element;
    }

}

/**
 * BJMethodClassElemBuilder(Document,BJMethodForClass).build()
 *
 * name="" output="" id="" accmod="" naccmod=""
 */
