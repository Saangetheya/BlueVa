package com.indua.blueva;

import com.indua.blueva.props.*;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.HashMap;

public class Misc {
    public static ArrayList<BJClass> ClassColl = new ArrayList<>();
    public static ArrayList<BJInterface> InterColl = new ArrayList<>();
    public static ArrayList<BJEnum> EnumColl = new ArrayList<>();
    public static HashMap<String ,BJClass> hashClass = new HashMap<>();
    public static HashMap<String,String > hashName = new HashMap<>();
    public static HashMap<String,String > hashPackage = new HashMap<>();
    public static HashMap<String ,BJInterface> hashInter = new HashMap<>();
    public static HashMap<String ,BJEnum> hashEnum = new HashMap<>();
    public static String ImVeryConfused = "";
    public static String packageName = "a0";
    public static AnchorPane currentTab;
    public static Page currentPage;
    public static HashMap<String, BJField> againMapped = new HashMap<>();
    public static HashMap<String,BJMethodClass> notagain = new HashMap<>();
    public static HashMap<String,BJMethodInterface> notagain0 = new HashMap<>();
    public static HashMap<String, BJFieldI> againMapped0 = new HashMap<>();
    public static HashMap<Integer,Page> tabPageHashMap = new HashMap<>();
}
