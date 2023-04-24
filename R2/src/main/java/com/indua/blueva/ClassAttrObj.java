package com.indua.blueva;

public class ClassAttrObj {
    String nameColumn;
    String typeColumn;
    String valColumn;
    String accColumn;
    String naccColumn;

    public ClassAttrObj(String nameColumn, String typeColumn, String valColumn, String accColumn, String naccColumn) {
        this.nameColumn = nameColumn;
        this.typeColumn = typeColumn;
        this.valColumn = valColumn;
        this.accColumn = accColumn;
        this.naccColumn = naccColumn;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public String getTypeColumn() {
        return typeColumn;
    }

    public void setTypeColumn(String typeColumn) {
        this.typeColumn = typeColumn;
    }

    public String getValColumn() {
        return valColumn;
    }

    public void setValColumn(String valColumn) {
        this.valColumn = valColumn;
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
