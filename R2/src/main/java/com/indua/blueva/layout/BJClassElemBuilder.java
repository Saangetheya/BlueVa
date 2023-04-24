package com.indua.blueva.layout;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJMethod;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.indua.blueva.props.BJField;
import com.indua.blueva.props.BJMethodType;
import com.indua.blueva.utils.Utility;

public class BJClassElemBuilder implements IElement {
    private final BJClass _class;
    private Element _element;
    private final Document _document;

    // Creating a class element.
    public BJClassElemBuilder(Document _pdocument, BJClass _pclass) {
        _class = _pclass;
        _document = _pdocument;

        _element = _pdocument.createElement("class");
    }

    /**
     * It creates an element, adds attributes to it, and returns it
     *
     * @return The element that was created.
     */
    public Element build() {
        Attr nameAttr = _document.createAttribute("name");
        nameAttr.setNodeValue(_class.getName());

        Attr extendAttr = _document.createAttribute("extends");
        extendAttr.setNodeValue(_class.getExtendingClass());

        Attr implAttr = _document.createAttribute("implements");
        implAttr.setNodeValue(Utility.getArrayString(_class.getImplementingInterfaces()));

        Attr accmodAttr = _document.createAttribute("accmod");
        accmodAttr.setNodeValue(_class.getAccModifier().toString());

        Attr naccmodAttr = _document.createAttribute("naccmod");
        naccmodAttr.setNodeValue(_class.getNaccModifier().toString());

        _element.setAttributeNode(nameAttr);
        _element.setAttributeNode(extendAttr);
        _element.setAttributeNode(implAttr);
        _element.setAttributeNode(accmodAttr);
        _element.setAttributeNode(naccmodAttr);

        for (BJField _field : _class.getFieldColl()) {
            _element.appendChild(BJElementBuilder.createInstance(_document).createFieldBuilder(_field).build());
        }

        for (BJMethod _method : _class.getMethodColl()) {
            _element.appendChild(
                    ((BJMethodClassElemBuilder) BJElementBuilder.createInstance(_document)
                            .createMethodBuilder(BJMethodType.CLASS, _method)).build());
        }

        return _element;
    }
}

/**
 * name="" extends="" implements="" accmod="" naccmod=""
 * fields method
 *
 * BJElementBuilder.createClass()
 */
