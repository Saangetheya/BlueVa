package com.indua.blueva.layout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJEnum;
import com.indua.blueva.props.BJValue;

public class BJEnumElemBuilder {
    private final Document _document;
    private final BJEnum _enum;
    private Element _element;

    // Creating a new element called enum.
    public BJEnumElemBuilder(Document _pdocument, BJEnum _pinterface) {
        _document = _pdocument;
        _enum = _pinterface;

        _element = _document.createElement("enum");
    }

    /**
     * It creates an element, sets the name and access modifier attributes, and then
     * appends the values of
     * the enum to the element
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_enum.getName());

        Attr accmodAttr = _document.createAttribute("accmod");
        accmodAttr.setNodeValue(_enum.getAccModifier().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(accmodAttr);

        for (BJValue _value : _enum.getValueColl()) {
            _element.appendChild(BJElementBuilder.createInstance(_document).createValueBuilder(_value).build());
        }

        return _element;
    }
}

/**
 * name="" accmod=""
 */
