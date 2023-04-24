package com.indua.blueva;

public class ClassMethObj {
    String nameColumn;
    String returnColumn;
    String bodyColumn;
    String parameterColumn;
    String accColumn;
    String naccColumn;

    public ClassMethObj(String nameColumn, String returnColumn, String bodyColumn, String parameterColumn, String accColumn, String naccColumn) {
        this.nameColumn = nameColumn;
        this.returnColumn = returnColumn;
        this.bodyColumn = bodyColumn;
        this.parameterColumn = parameterColumn;
        this.accColumn = accColumn;
        this.naccColumn = naccColumn;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public String getReturnColumn() {
        return returnColumn;
    }

    public void setReturnColumn(String returnColumn) {
        this.returnColumn = returnColumn;
    }

    public String getBodyColumn() {
        return bodyColumn;
    }

    public void setBodyColumn(String bodyColumn) {
        this.bodyColumn = bodyColumn;
    }

    public String getParameterColumn() {
        return parameterColumn;
    }

    public void setParameterColumn(String parameterColumn) {
        this.parameterColumn = parameterColumn;
    }

    public String getAccColumn() {
        return accColumn;
    }

    public void setAccColumn(String accColumn) {
        this.accColumn = accColumn;
    }

    public String getNaccColumn() {
        return naccColumn;
    }

    public void setNaccColumn(String naccColumn) {
        this.naccColumn = naccColumn;
    }
}
