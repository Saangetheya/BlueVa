package com.indua.blueva.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.indua.blueva.misc.MainChart;
import com.indua.blueva.props.BJBuildClassOutput;
import com.indua.blueva.props.BJBuildStatus;
import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJField;
import com.indua.blueva.props.BJImport;
import com.indua.blueva.props.BJMethodClass;
import com.indua.blueva.props.BJParameter;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.JavaFile.Builder;
public class BJClassWriter {
    /**
     * Create a new instance of BJClassWriter, passing in the BJClass object that
     * was created in the
     * previous step.
     *
     * @param _pclass The class to be written.
     * @return A new instance of BJClassWriter
     */

    private File filePath;

    public static BJClassWriter createInstance(BJClass _pclass) throws IOException {
        return new BJClassWriter(_pclass);
    }

    private final BJClass _class;

    private BJClassWriter(BJClass _pclass) throws IOException {
        _class = _pclass;
    }

    /**
     * It creates a JavaFile object, writes it to a folder, and returns a
     * BJBuildClassOutput object
     *
     * @return The return type is BJBuildClassOutput.
     */
    public BJBuildClassOutput build() throws IOException {
        TypeSpec myclass = createClassSpec();
        Builder javaBuilder;

        if (_class.getFileComment() == null) {
            javaBuilder = JavaFile.builder(_class.getPackageName(), myclass);
        } else {
            javaBuilder = JavaFile.builder(_class.getPackageName(), myclass).addFileComment(_class.getFileComment());
        }

        if (_class.getStaticImports() != null) {

            for (BJImport _import : _class.getStaticImports().getImportColl()) {
                javaBuilder = javaBuilder.addStaticImport(
                        ClassName.get(_import.getPackageName(), _import.getSimpleName()),
                        _import.getLeafName());
            }
        }

        JavaFile javaFile = javaBuilder.build();
        javaFile.writeTo(getFolderFile());

        return generateClassOutput();
    }

    /**
     * Get the output folder as a File object.
     *
     * @return A File object that represents the folder output.
     */
    private File getFolderFile() {
        return filePath == null ? Paths.get("./output").toFile() : filePath;
    }

    public BJClassWriter setFolderFile(String folderName) {
        filePath = Paths.get(folderName).toFile();
        return this;
    }

    /**
     * `generateClassOutput()` creates a `BJBuildClassOutput` object and returns it
     *
     * @return A BJBuildClassOutput object.
     */
    private BJBuildClassOutput generateClassOutput() {
        BJBuildClassOutput classOutput = BJBuildClassOutput.createInstance()
                .setClassName(this._class.getName())
                .setMessage(String.format("Class %s.java successfully created", this._class.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return classOutput;
    }

    /**
     * It creates a class spec for a class
     *
     * @return A TypeSpec object.
     */
    private TypeSpec createClassSpec() {
        com.squareup.javapoet.TypeSpec.Builder classBuilder = TypeSpec.classBuilder(this._class.getName());

        if (_class.isMain()) {
            MainChart.createInstance().FillBjClass(_class);
        }

        if (_class.getAccModifier() == Modifier.DEFAULT) {
            classBuilder = classBuilder.addModifiers(Modifier.PUBLIC, this._class.getNaccModifier());
        } else if (_class.getNaccModifier() == Modifier.DEFAULT) {
            classBuilder = classBuilder.addModifiers(this._class.getAccModifier());
        } else {
            classBuilder = classBuilder.addModifiers(this._class.getAccModifier(), this._class.getNaccModifier());
        }

        classBuilder = classBuilder
                .addJavadoc(String.format("Hello , this is Sample Java doc for class %s\n", this._class.getName())
                        + "@brief\nSome sample brief message");

        if (_class.getExtendingClass() != null) {
            classBuilder = classBuilder
                    .superclass(Utility.getTypeNameFromString(_class.getPackageName(), _class.getExtendingClass()));
        }

        if (_class.getIsShouldAddDefConstructor()) {
            com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.constructorBuilder();
            for (BJField field : _class.getFieldColl()) {
                if (field.getIsArray()) {
                    methodBuilder = methodBuilder.addStatement(
                            String.format("this.%s = new %s[]{}", field.getName(), field.getOutput().getClassName()));
                } else {
                    methodBuilder = methodBuilder.addStatement(
                            String.format("this.%s = %s", field.getName(), Utility.getDefaultValue(field.getOutput())));
                }
            }

            classBuilder = classBuilder.addMethod(methodBuilder.build());
        }

        if (_class.getIsShouldAddParamConstructor()) {
            com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.constructorBuilder();

            for (BJField field : _class.getFieldColl()) {
                if (field.getIsArray()) {
                    methodBuilder = methodBuilder.addParameter(
                            ArrayTypeName.of(Utility.getTypeNameForPrimTypes(field.getOutput())),
                            field.getName());
                } else {
                    methodBuilder = methodBuilder.addParameter(Utility.getTypeNameForPrimTypes(field.getOutput()),
                            field.getName());
                }

                methodBuilder.addStatement(String.format("this.%s = %s", field.getName(), field.getName()));
            }

            classBuilder = classBuilder.addMethod(methodBuilder.build());
        }

        for (BJMethodClass methodClass : this._class.getMethodColl()) {
            classBuilder = classBuilder.addMethod(createMethodSpec(methodClass));
        }

        for (BJField field : this._class.getFieldColl()) {
            classBuilder = classBuilder.addField(createFieldSpec(field));
        }

        for (String interfaceName : _class.getImplementingInterfaces()) {
            classBuilder = classBuilder.addSuperinterface(Utility.getTypeNameFromString(_class.getPackageName(),
                    interfaceName));
        }

        return classBuilder.build();
    }

    /**
     * It creates a method spec for a given method class
     *
     * @param _methodClass This is the class that holds all the information about
     *                     the method.
     * @return A MethodSpec object.
     */
    private MethodSpec createMethodSpec(BJMethodClass _methodClass) {

        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodClass.getName());

        if (_methodClass.getNaccModifier() == Modifier.DEFAULT) {
            _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodClass.getAccModifier()));
        } else {
            _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodClass.getAccModifier()),
                    _methodClass.getNaccModifier());
        }

        _methodBuilder = _methodBuilder.returns(Utility.getTypeNameForPrimTypes(_methodClass.getOutput()));

        for (BJParameter parameter : _methodClass.getParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(createParameterSpec(parameter));
        }

        if (_methodClass.getComment() != null) {
            _methodBuilder = _methodBuilder.addJavadoc(_methodClass.getComment());
        }

        if (_methodClass.getCode() != null) {
            _methodBuilder = _methodBuilder.addCode(_methodClass.getCode());
        }

        return _methodBuilder.build();
    }

    /**
     * It creates a ParameterSpec object for a given BJParameter object
     *
     * @param _parameter This is the parameter object that contains the information
     *                   about the parameter.
     * @return A ParameterSpec object.
     */

    private ParameterSpec createParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder _parameterBuilder;
        if (_parameter.getIsArray()) {

            if (_parameter.getNaccModifier() == BJNAccessModifierParameter.DEFAULT) {
                _parameterBuilder = ParameterSpec.builder(
                                ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_parameter.getOutput())),
                                _parameter.getName())
                        .addJavadoc(
                                String.format("Sample Java doc for Parameter %s\n", _parameter.getName()));
            } else {
                _parameterBuilder = ParameterSpec.builder(
                                ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_parameter.getOutput())),
                                _parameter.getName(), Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()))
                        .addJavadoc(
                                String.format("Sample Java doc for Parameter %s\n", _parameter.getName()));
            }
        } else {
            if (_parameter.getNaccModifier() == BJNAccessModifierParameter.DEFAULT) {
                _parameterBuilder = ParameterSpec.builder(
                                Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                                _parameter.getName())
                        .addJavadoc(
                                String.format("Sample Java doc for Parameter %s\n", _parameter.getName()));
            } else {
                _parameterBuilder = ParameterSpec.builder(
                                Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                                _parameter.getName(), Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()))
                        .addJavadoc(
                                String.format("Sample Java doc for Parameter %s\n", _parameter.getName()));
            }
        }

        return _parameterBuilder.build();
    }

    /**
     * It creates a field spec for a given field
     *
     * @param _field This is the field object that contains all the information
     *               about the field.
     * @return A FieldSpec object.
     */
    private FieldSpec createFieldSpec(BJField _field) {

        com.squareup.javapoet.FieldSpec.Builder fieldBuilder;

        if (_field.getIsArray()) {

            if (_field.getNaccModifier() == Modifier.DEFAULT) {
                fieldBuilder = FieldSpec.builder(
                                ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_field.getOutput())),
                                _field.getName())
                        .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()))
                        .initializer(String.format("new %s[] {}", _field.getOutput().getClassName()));
            } else {
                fieldBuilder = FieldSpec.builder(
                                ArrayTypeName.of(Utility.getTypeNameForPrimTypes(_field.getOutput())),
                                _field.getName(), _field.getNaccModifier())
                        .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()))
                        .initializer(String.format("new %s[] {}", _field.getOutput().getClassName()));
            }
        } else {
            if (_field.getNaccModifier() == Modifier.DEFAULT) {
                fieldBuilder = FieldSpec.builder(
                                Utility.getTypeNameForPrimTypes(_field.getOutput()),
                                _field.getName())
                        .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()))
                        .initializer(String.format("%s.valueOf(%s)", _field.getOutput().getClassName(),
                                Utility.getDefaultValue(_field.getOutput())));
            } else {

                fieldBuilder = FieldSpec.builder(
                                Utility.getTypeNameForPrimTypes(_field.getOutput()),
                                _field.getName(), _field.getNaccModifier())
                        .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()))
                        .initializer(String.format("%s.valueOf(%s)", _field.getOutput().getClassName(),
                                Utility.getDefaultValue(_field.getOutput())));

            }
        }

        return fieldBuilder.build();
    }

    /*
     * name="" output="" id="" accmod="" naccmod=""
     */
}

/**
 * BJClassWriter.createInstance(BJClass).build(); // returns BJBuildClassOutput
 *
 * Automatically writes to `${BJClass.getName()}.java` file
 */