package com.indua.blueva.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import javax.lang.model.element.Modifier;

import org.json.simple.JSONValue;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

public class Utility {
    /**
     * It takes a BJAccessModifiers enum and returns a Modifier enum
     *
     * @param accModifer The access modifier of the method.
     * @return A Modifier object.
     */
    public static Modifier getAccessModifier(BJAccessModifier accModifer) {
        if (accModifer == BJAccessModifier.DEFAULT) {
            return Modifier.DEFAULT;
        } else if (accModifer == BJAccessModifier.PRIVATE) {
            return Modifier.PRIVATE;
        } else if (accModifer == BJAccessModifier.PROTECTED) {
            return Modifier.PROTECTED;
        } else {
            return Modifier.PUBLIC;
        }
    }

    /**
     * It takes a BJNAccessModifiersMethod enum value and returns a Modifier enum
     * value
     *
     * @param naccModifier The non-access modifier for the method.
     * @return The return type of the method.
     */
    public static Modifier getNonAccessModifierForMethod(BJNAccessModifierMethod naccModifier) {
        if (naccModifier == BJNAccessModifierMethod.ABSTRACT) {
            return Modifier.ABSTRACT;
        } else if (naccModifier == BJNAccessModifierMethod.FINAL) {
            return Modifier.FINAL;
        } else if (naccModifier == BJNAccessModifierMethod.STATIC) {
            return Modifier.STATIC;
        } else if (naccModifier == BJNAccessModifierMethod.SYNCHRONIZED) {
            return Modifier.SYNCHRONIZED;
        } else if (naccModifier == BJNAccessModifierMethod.TRANSIENT) {
            return Modifier.TRANSIENT;
        } else {
            return Modifier.DEFAULT;
        }
    }

    /**
     * "If the parameter is DEFAULT, return Modifier.DEFAULT, otherwise return
     * Modifier.FINAL."
     *
     * The function is called in the following way:
     *
     * @param naccModifier The non-access modifier for the parameter.
     * @return A modifier.
     */
    public static Modifier getNonAccessModifierForParameter(BJNAccessModifierParameter naccModifier) {
        if (naccModifier == BJNAccessModifierParameter.DEFAULT) {
            return Modifier.DEFAULT;
        } else {
            return Modifier.FINAL;
        }
    }

    /**
     * It returns the Java class type for the given primitive type
     *
     * @param _primTypes The primitive type that you want to convert to a Type.
     * @return The return type is a Class object.
     */
    public static Type getTypeNameForPrimTypes(BJPrimTypes _primTypes) {
        if (_primTypes == BJPrimTypes.BOOLEAN) {
            return Boolean.class;
        } else if (_primTypes == BJPrimTypes.BYTE) {
            return Byte.class;
        } else if (_primTypes == BJPrimTypes.CHAR) {
            return Character.class;
        } else if (_primTypes == BJPrimTypes.DOUBLE) {
            return Double.class;
        } else if (_primTypes == BJPrimTypes.FLOAT) {
            return Float.class;
        } else if (_primTypes == BJPrimTypes.INT) {
            return Integer.class;
        } else if (_primTypes == BJPrimTypes.SHORT) {
            return Short.class;
        } else if (_primTypes == BJPrimTypes.LONG) {
            return Long.class;
        } else if (_primTypes == BJPrimTypes.VOID) {
            return Void.class;
        } else {
            return String.class;
        }
    }

    public static String getDefaultValue(BJPrimTypes primType) {
        if (primType == BJPrimTypes.BOOLEAN) {
            return "false";
        } else if (primType == BJPrimTypes.BYTE) {
            return "0";
        } else if (primType == BJPrimTypes.CHAR) {
            return "' '";
        } else if (primType == BJPrimTypes.DOUBLE) {
            return "0.0";
        } else if (primType == BJPrimTypes.FLOAT) {
            return "0.0f";
        } else if (primType == BJPrimTypes.INT) {
            return "0";
        } else if (primType == BJPrimTypes.SHORT) {
            return "0";
        } else if (primType == BJPrimTypes.LONG) {
            return "0L";
        } else if (primType == BJPrimTypes.VOID) {
            return "null";
        } else {
            return "null";
        }
    }

    /**
     * It takes a package name and a class name and returns a TypeName object
     *
     * @param _packageName The package name of the class you want to create.
     * @param _className   The name of the class you want to create.
     * @return A TypeName object.
     */

    public static TypeName getTypeNameFromString(String _packageName, String _className) {
        return ClassName.get(_packageName, _className);
    }

    /**
     * It takes an ArrayList of Strings and returns a String of all the elements in
     * the ArrayList
     * separated by commas
     *
     * @param _arrayList The array list you want to convert to a string.
     * @return A string of the array list.
     */
    public static String getArrayString(ArrayList<String> _arrayList) {
        return String.join(",", _arrayList);
    }

    /**
     * It takes a BJAccessModifierCI enum and returns a Modifier enum
     *
     * @param accModifer BJAccessModifierCI.DEFAULT
     * @return A Modifier object.
     */
    public static Modifier getAccessModifierCI(BJAccessModifierCI accModifer) {
        if (accModifer == BJAccessModifierCI.PUBLIC) {
            return Modifier.PUBLIC;
        } else {
            return Modifier.ABSTRACT;
        }
    }

    /**
     * If the access modifier is default, return default, otherwise return public.
     *
     * @param accModifer BJAccessModifierE
     * @return Modifier.DEFAULT or Modifier.PUBLIC
     */
    public static Modifier getAccessModifierE(BJAccessModifierE accModifer) {
        if (accModifer == BJAccessModifierE.PUBLIC) {
            return Modifier.PUBLIC;
        } else {
            return Modifier.DEFAULT;
        }
    }

    public static Modifier getAccessModifierFieldI(BJAccessModifierFieldI _accMod) {
        if (_accMod == BJAccessModifierFieldI.PUBLIC) {
            return Modifier.PUBLIC;
        } else {
            return Modifier.PUBLIC;
        }
    }

    /**
     * It takes a HashMap<String, Object> and returns a JSON String
     *
     * @param hMap HashMap<String, Object>
     * @return A JSON String
     */
    public static String convertToJSONString(HashMap<String, Object> hMap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        JsonElement element = JsonParser.parseString(JSONValue.toJSONString(hMap));
        return gson.toJson(element);
    }

    public static String createInitializer(BJPrimTypes _primType, String value) {
        if (_primType == BJPrimTypes.BOOLEAN) {
            return String.format("Boolean.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.BYTE) {
            return String.format("Byte.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.CHAR) {
            return String.format("Character.valueOf(\'%s\')", value.charAt(0));
        } else if (_primType == BJPrimTypes.DOUBLE) {
            return String.format("Double.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.FLOAT) {
            return String.format("Float.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.INT) {
            return String.format("Integer.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.LONG) {
            return String.format("Long.valueOf(\"%s\")", value);
        } else if (_primType == BJPrimTypes.SHORT) {
            return String.format("Short.valueOf(\"%s\")", value);
        } else {
            return String.format("String.valueOf(\"%s\")", value);
        }
    }
}