package com.indua.blueva.props;

public class BJNodeSet {
    private BJNodeSet() {

    }

    public static BJNodeSet createInstance() {
        return new BJNodeSet();
    }

    public String build() {
        return String.format("System.out.println(\"Hi\")");
    }

}
