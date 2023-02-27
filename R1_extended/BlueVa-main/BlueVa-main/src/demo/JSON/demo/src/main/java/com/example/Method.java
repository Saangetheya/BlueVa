package com.example;

import com.google.gson.*;

public class Method {
    public String FirstName ;
    public int Myage ;
    public String MyState;

    public Method(String name , int age ,String state) {
        this.FirstName = name;
        this.Myage = age;
        this.MyState = state;
    }

    public String getJSONAsString() {
        Gson gsonObj = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
        .create();
        return gsonObj.toJson(this);
    }
}
