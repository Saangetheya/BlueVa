package com.indua.blueva.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.indua.blueva.props.BJBuildEnumOutput;
import com.indua.blueva.props.BJBuildStatus;
import com.indua.blueva.props.BJEnum;
import com.indua.blueva.props.BJImport;
import com.indua.blueva.props.BJValue;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.JavaFile.Builder;

public class BJEnumWriter {

    private File filePath;

    /**
     * Create a new instance of the BJEnumWriter Enum, passing in the BJEnum object
     * that you want to
     * write to the file
     *
     * @param _penum The enum to be written.
     * @return A new instance of BJEnumWriter.
     */
    public static BJEnumWriter createInstance(BJEnum _penum) throws IOException {
        return new BJEnumWriter(_penum);
    }

    private BJEnum _enum;

    private BJEnumWriter(BJEnum _penum) throws IOException {
        _enum = _penum;
    }

    /**
     * It creates a JavaFile object, writes it to a folder, and returns an object
     * that contains the name of
     * the file that was written
     *
     * @return The return type is BJBuildEnumOutput.
     * @throws IOException
     */
    public BJBuildEnumOutput build() throws IOException {
        TypeSpec myenum = createEnumSpec();
        Builder javaBuilder = JavaFile.builder(_enum.getPackageName(), myenum)
                .addFileComment(_enum.getFileComment());

        if (_enum.getStaticImports() != null) {

            for (BJImport _import : _enum.getStaticImports().getImportColl()) {
                javaBuilder = javaBuilder.addStaticImport(
                        ClassName.get(_import.getPackageName(), _import.getSimpleName()),
                        _import.getLeafName());
            }
        }

        JavaFile javaFile = javaBuilder.build();
        javaFile.writeTo(getFolderFile());
        return generateEnumOutput();
    }

    /**
     * It creates an enum type spec for a given enum
     *
     * @return A TypeSpec object.
     */
    public TypeSpec createEnumSpec() {
        com.squareup.javapoet.TypeSpec.Builder enumBuilder = TypeSpec.enumBuilder(_enum.getName());

        enumBuilder = enumBuilder.addModifiers(Utility.getAccessModifierE(_enum.getAccModifier()));

        for (BJValue _value : _enum.getValueColl()) {
            enumBuilder = enumBuilder.addEnumConstant(_value.getName(),
                    TypeSpec.anonymousClassBuilder("$L", _value.getValue()).build());
        }

        return enumBuilder.build();
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

    public BJEnumWriter setFolderFile(String folderName) {
        filePath =  Paths.get(folderName).toFile();
        return this;
    }

    /**
     * It generates an enum output.
     *
     * @return A BJBuildEnumOutput object.
     */
    private BJBuildEnumOutput generateEnumOutput() {
        BJBuildEnumOutput IntefaceOutput = BJBuildEnumOutput.createInstance()
                .setEnumName(_enum.getName())
                .setMessage(String.format("Inteface %s.java successfully created", this._enum.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return IntefaceOutput;
    }
}

/**
 * BJEnumWriter.createInstance(BJEnum).build(); // returns BJBuildEnumOutput
 *
 * Automatically writes to `${BJEnum.getName()}.java` file
 */