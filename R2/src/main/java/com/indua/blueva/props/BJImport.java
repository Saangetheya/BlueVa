package com.indua.blueva.props;

/**
 * This class represents an import statement in a Java file.
 * by default,the package is java and the simple name is lang
 * and the leaf name is * (all inside java.lang).
 */

public class BJImport {
    private String packageName;
    private String simpleName;
    private String leafName;

    private BJImport() {
        packageName = "java";
        simpleName = "lang";
        leafName = "*";
    }

    /**
     * Creates new instance of BJImport
     *
     * @return A new instance of BJImport.
     */
    public static BJImport createInstance() {
        return new BJImport();
    }

    /**
     * This function returns the value of the private variable _packageName.
     *
     * @return The value of the variable _packageName.
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * This function sets the value of the private variable _packageName to the
     * value passed in as a parameter.
     *
     * @param packageName The value of the variable _packageName.
     * @return The object itself.
     */
    public BJImport setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    /**
     * This function returns the value of the private variable _simpleName.
     *
     * @return The value of the variable _simpleName.
     */
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * This function sets the value of the private variable _simpleName to the
     * value passed in as a parameter.
     *
     * @param simpleName The value of the variable _simpleName.
     * @return The object itself.
     */
    public BJImport setSimpleName(String simpleName) {
        this.simpleName = simpleName;
        return this;
    }

    /**
     * This function returns the value of the private variable _leafName.
     *
     * @return The value of the variable _leafName.
     */
    public String getLeafName() {
        return leafName;
    }

    /**
     * This function sets the value of the private variable _leafName to the
     * value passed in as a parameter.
     *
     * @param leafName The value of the variable _leafName.
     * @return The object itself.
     */
    public BJImport setLeafName(String leafName) {
        this.leafName = leafName;
        return this;
    }


}