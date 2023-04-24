package com.indua.blueva.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.indua.blueva.props.BJBuildInterfaceOutput;
import com.indua.blueva.props.BJBuildStatus;
import com.indua.blueva.props.BJFieldI;
import com.indua.blueva.props.BJImport;
import com.indua.blueva.props.BJInterface;
import com.indua.blueva.props.BJMethodInterface;
import com.indua.blueva.props.BJParameter;
import com.squareup.javapoet.*;
import com.squareup.javapoet.JavaFile.Builder;


public class BJInterfaceWriter {

    private File filePath;

    /**
     * This function creates a new instance of the BJInterfaceWriter class
     *
     * @param _pinterface The interface to write.
     * @return A new instance of BJInterfaceWriter
     */
    public static BJInterfaceWriter createInstance(BJInterface _pinterface) throws IOException {
        return new BJInterfaceWriter(_pinterface);
    }

    private BJInterface _interface;

    private BJInterfaceWriter(BJInterface _pinterface) throws IOException {
        _interface = _pinterface;
    }

    /**
     * Builds the interface
     *
     * @return The return type is BJBuildInterfaceOutput.
     */
    public BJBuildInterfaceOutput build() throws IOException {
        TypeSpec myinterface = createInterfaceSpec();
        Builder javaBuilder;

        if (_interface.getFileComment() != null) {
            javaBuilder = JavaFile.builder(_interface.getPackageName(), myinterface)
                    .addFileComment(_interface.getFileComment());
        } else {
            javaBuilder = JavaFile.builder(_interface.getPackageName(), myinterface);
        }

        if (_interface.getStaticImports() != null) {

            for (BJImport _import : _interface.getStaticImports().getImportColl()) {
                javaBuilder = javaBuilder.addStaticImport(
                        ClassName.get(_import.getPackageName(), _import.getSimpleName()),
                        _import.getLeafName());
            }
        }

        JavaFile javaFile = javaBuilder.build();
        javaFile.writeTo(getFolderFile());
        return generateInterfaceOutput();
    }

    /**
     * This function creates a Java interface using the JavaPoet library
     *
     * @return A TypeSpec object.
     */
    public TypeSpec createInterfaceSpec() {
        com.squareup.javapoet.TypeSpec.Builder interfaceBuilder = TypeSpec.interfaceBuilder(this._interface.getName());

        interfaceBuilder = interfaceBuilder.addModifiers(Utility.getAccessModifierCI(this._interface.getAccModifier()));

        if (_interface.getInterfaceComment() != null) {
            interfaceBuilder = interfaceBuilder.addJavadoc(_interface.getInterfaceComment());
        }

        for (BJMethodInterface methodClass : this._interface.getMethodColl()) {
            interfaceBuilder = interfaceBuilder.addMethod(createMethodSpec(methodClass));
        }

        for (String interfaceName : _interface.getImplementingInterfaces()) {
            interfaceBuilder = interfaceBuilder
                    .addSuperinterface(Utility.getTypeNameFromString(_interface.getPackageName(),
                            interfaceName));
        }

        for (BJFieldI field : this._interface.getFieldColl()) {
            interfaceBuilder = interfaceBuilder.addField(createFieldSpec(field));
        }

        return interfaceBuilder.build();
    }

    private FieldSpec createFieldSpec(BJFieldI _field) {
        com.squareup.javapoet.FieldSpec.Builder fieldBuilder = FieldSpec.builder(
                        Utility.getTypeNameForPrimTypes(_field.getOutput()),
                        _field.getName(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()))
                .initializer(Utility.createInitializer(_field.getOutput(), _field.getValue()));

        return fieldBuilder.build();
    }

    /**
     * It creates a method spec for a given method interface
     *
     * @param _methodInterface This is the interface that contains the method
     *                         details.
     * @return A MethodSpec object.
     */
    public MethodSpec createMethodSpec(BJMethodInterface _methodInterface) {
        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodInterface.getName());

        if (_methodInterface.getNaccModifier() == BJNAccessModifierMethod.DEFAULT) {
            _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodInterface.getAccModifier()));
        } else {
            _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodInterface.getAccModifier()),
                    Utility.getNonAccessModifierForMethod(_methodInterface.getNaccModifier()));

        }

        if (_methodInterface.getIsOutputAryType()) {
            _methodBuilder = _methodBuilder
                    .returns(ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_methodInterface.getOutput())));
        } else {
            _methodBuilder = _methodBuilder.returns(Utility.getTypeNameForPrimTypes(_methodInterface.getOutput()));

        }

        for (BJParameter parameter : _methodInterface.getParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(createParameterSpec(parameter));
        }

        _methodBuilder = _methodBuilder.addJavadoc(String.format("Sample Java doc for Method %s %s",
                _methodInterface.getName(), _methodInterface.getComment()));

        return _methodBuilder.build();
    }

    /**
     * It creates a parameter spec for a given parameter
     *
     * @param _parameter This is the parameter object that contains the information
     *                   about the parameter.
     * @return A ParameterSpec object.
     */
    public ParameterSpec createParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder parameterBuilder;
        if (_parameter.getNaccModifier() == BJNAccessModifierParameter.DEFAULT) {
            if (_parameter.getIsArray()) {
                parameterBuilder = ParameterSpec.builder(
                        ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_parameter.getOutput())),
                        _parameter.getName());
            } else {
                parameterBuilder = ParameterSpec.builder(
                        Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                        _parameter.getName());
            }
        } else {
            if (_parameter.getIsArray()) {
                parameterBuilder = ParameterSpec.builder(
                        ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_parameter.getOutput())),
                        _parameter.getName(),
                        Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()));
            } else {
                parameterBuilder = ParameterSpec.builder(
                        Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                        _parameter.getName(),
                        Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()));
            }
        }

        parameterBuilder = parameterBuilder.addJavadoc(
                String.format("Sample Java doc for %s\n", _parameter.getName()));

        return parameterBuilder.build();
    }

    /**
     * It returns a `File` object that represents the folder `output` in the current
     * working directory
     *
     * @return A File object that represents the output folder.
     */

    private File getFolderFile() {
        return filePath == null ? Paths.get("./output").toFile() : filePath;
    }

    public BJInterfaceWriter setFolderFile(String folderName) {
        filePath = Paths.get(folderName).toFile();
        return this;
    }

    /**
     * This function creates an instance of the BJBuildInterfaceOutput class, sets
     * the interface name,
     * message, and build status, and returns the instance
     *
     * @return An instance of BJBuildInterfaceOutput.
     */

    private BJBuildInterfaceOutput generateInterfaceOutput() {
        BJBuildInterfaceOutput interfaceOutput = BJBuildInterfaceOutput.createInstance()
                .setInterfaceName(this._interface.getName())
                .setMessage(String.format("Interface %s.java successfully created", this._interface.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return interfaceOutput;
    }

}