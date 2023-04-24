package com.indua.blueva;

import com.indua.blueva.props.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.lang.model.element.Modifier;
import javax.swing.text.View;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class GenController{
    @FXML
    private Button attribute_class;
    private String prev = "";

    @FXML
    private Button delete_class;

    @FXML
    void openAttributes(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Loading.class.getResource("ClassAttributes_FXML.fxml")));
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Set Attributes");
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void openMethods(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Loading.class.getResource("ClassMethods_FXML.fxml")));
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Set Methods");
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void deleteClass(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Class");
        alert.setHeaderText("Are you sure you want to delete the Class?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
            Misc.currentPage.getBjPackage().removeClass(Misc.hashClass.get(Misc.ImVeryConfused));
            Misc.hashClass.remove(Misc.ImVeryConfused);
            TextField txt = (TextField) anchorPane.lookup("#cnameText");
            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }
    }
    @FXML
    void deletePSVM(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete PSVM");
        alert.setHeaderText("Are you sure you want to delete the PSVM?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
//            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
//            Misc.hashClass.remove(Misc.ImVeryConfused);
//            TextField txt = (TextField) anchorPane.lookup("#cnameText");
//            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }
    }
    @FXML
    void saveImports(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete PSVM");
        alert.setHeaderText("Are you sure you want to delete the PSVM?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
//            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
//            Misc.hashClass.remove(Misc.ImVeryConfused);
//            TextField txt = (TextField) anchorPane.lookup("#cnameText");
//            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }
    }
    @FXML
    void savePSVM(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete PSVM");
        alert.setHeaderText("Are you sure you want to delete the PSVM?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
//            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
//            Misc.hashClass.remove(Misc.ImVeryConfused);
//            TextField txt = (TextField) anchorPane.lookup("#cnameText");
//            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }
    }
    @FXML
    void deleteImports(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Imports");
        alert.setHeaderText("Are you sure you want to delete the Imports?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
//            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
//            Misc.hashClass.remove(Misc.ImVeryConfused);
//            TextField txt = (TextField) anchorPane.lookup("#cnameText");
//            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }
    }
    @FXML
    void deleteInterface(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Interface");
        alert.setHeaderText("Are you sure you want to delete the Interface?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
            Misc.ImVeryConfused = dlt.getParent().getParent().getParent().getParent().toString();
            Misc.currentPage.getBjPackage().removeInterface(Misc.hashInter.get(Misc.ImVeryConfused));
            Misc.hashInter.remove(Misc.ImVeryConfused);
            TextField txt = (TextField) anchorPane.lookup("#inameText");
            Misc.hashName.remove(txt.getText());
        } else {
            alert.close();
        }

    }
    @FXML
    void openAttTable(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        System.out.println(bjClass);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Attribute_Table.fxml"));
        Parent root = loader.load();
        Label lbl = (Label) root.lookup("#att_lbl");
        lbl.setText("CLASS ATTRIBUTES FOR : "+ bjClass.getName());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Attributes Table");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ClassAttrObj> classAttrObjs = FXCollections.observableArrayList();
        for (BJField bjField : bjClass.getFieldColl()) {
            ClassAttrObj classAttrObj = new ClassAttrObj(bjField.getName(),bjField.getOutput().toString(),bjField.getValue(),bjField.getAccModifier().toString(),bjField.getNaccModifier().toString());
            classAttrObjs.add(classAttrObj);
        }
        OpenClassAttrController openClassAttrController = loader.getController();
        openClassAttrController.viewClassAttTable(classAttrObjs);
    }
    @FXML
    void openMetTable(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        System.out.println(bjClass);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Methods_Table.fxml"));
        Parent root = loader.load();
        Label lbl = (Label) root.lookup("#meth_lbl");
        lbl.setText("CLASS METHODS FOR : "+ bjClass.getName());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Methods Table");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ClassMethObj> classMethObjs = FXCollections.observableArrayList();
        for (BJMethodClass bjMethodClass : bjClass.getMethodColl()) {
            StringBuilder X = new StringBuilder();
            for (BJParameter x : bjMethodClass.getParameterColl()){
                System.out.println(x.getName());
                System.out.println(x.getOutput());
                X.append(x.getName()+" "+x.getOutput()+" ");
            }
            ClassMethObj classMethObj = new ClassMethObj(bjMethodClass.getName(),bjMethodClass.getOutput().toString(),bjMethodClass.getCode(),X.toString(),bjMethodClass.getAccModifier().toString(),bjMethodClass.getNaccModifier().toString());
            classMethObjs.add(classMethObj);
        }
        OpenClassMethController openClassMethController = loader.getController();
        openClassMethController.viewClassMethTable(classMethObjs);
    }
    @FXML
    void openAttTable1(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        System.out.println(bjInterface);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Attribute_Table0.fxml"));
        Parent root = loader.load();
        Label lbl = (Label) root.lookup("#att_lbl");
        lbl.setText("INTERFACE ATTRIBUTES FOR : "+ bjInterface.getName());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Attributes Table");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ClassAttrObj> classAttrObjs = FXCollections.observableArrayList();
        for (BJFieldI bjField : bjInterface.getFieldColl()) {
            ClassAttrObj classAttrObj = new ClassAttrObj(bjField.getName(),bjField.getOutput().toString(),bjField.getValue(),bjField.getAccModifier().toString(),bjField.getNaccModifier().toString());
            classAttrObjs.add(classAttrObj);
        }
        OpenInterAttrController openClassAttrController = loader.getController();
        openClassAttrController.viewClassAttTable(classAttrObjs);
    }

    @FXML
    void openAttributes1(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Loading.class.getResource("InterfaceAttributes_FXML.fxml")));
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
//        System.out.println(Misc.ImVeryConfused);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Set Attributes");
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openMetTable1(MouseEvent event) throws IOException {

        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        System.out.println(bjInterface);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Methods_Table0.fxml"));
        Parent root = loader.load();
        Label lbl = (Label) root.lookup("#meth_lbl");
        lbl.setText("INTERFACE METHODS FOR : "+ bjInterface.getName());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Methods Table");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ClassMethObj> classMethObjs = FXCollections.observableArrayList();
        for (BJMethodInterface bjMethodClass : bjInterface.getMethodColl()) {
            StringBuilder X = new StringBuilder("");
            for (BJParameter x : bjMethodClass.getParameterColl()){
                X.append(x.getName()+" "+x.getOutput()+" ");
            }
            ClassMethObj classMethObj = new ClassMethObj(bjMethodClass.getName(),bjMethodClass.getOutput().toString(),"{No Method}",X.toString(),bjMethodClass.getAccModifier().toString(),bjMethodClass.getNaccModifier().toString());
            classMethObjs.add(classMethObj);
        }
        OpenInterMethController openInterMethController = loader.getController();
        openInterMethController.viewClassMethTable(classMethObjs);
    }

    @FXML
    void openMethods1(MouseEvent event) throws IOException{
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Loading.class.getResource("InterfaceMethods_FXML.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Set Methods");
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void edit_psvm(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Loading.class.getResource("Psvm_body.fxml")));
        Parent root = fxmlLoader.load();
        PSVM_body psvmBody = fxmlLoader.getController();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        for (BJMethodClass b:
             bjClass.getMethodColl()) {
            if(Objects.equals(b.getName(), "main")){
                psvmBody.textAreaPSVM.setText(b.getCode());
                break;
            }
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Enter main method");
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void editCname(MouseEvent event) {
        Button edt = (Button)event.getSource();
        AnchorPane anchorPane = (AnchorPane) edt.getParent();
        TextField txt = (TextField) anchorPane.lookup("#cnameText");
        prev = txt.getText();
        txt.setDisable(false);
        edt.setVisible(false);
        edt.setDisable(true);
        Button cfm = (Button)anchorPane.lookup("#cfmBtn");
        cfm.setVisible(true);
        cfm.setDisable(false);
    }
    @FXML
    void confirmCname(MouseEvent event) {
        Button cfm = (Button)event.getSource();
        AnchorPane anchorPane = (AnchorPane) cfm.getParent();
        TextField txt = (TextField) anchorPane.lookup("#cnameText");
        String cname = txt.getText();
        if(Misc.hashName.containsKey(cname) && !Objects.equals(cname, prev)){
            txt.setText(prev);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            String anchr = Misc.hashName.get(prev);
            BJClass bjClass = Misc.hashClass.get(anchr);
            bjClass.setName(cname);
            Misc.hashName.remove(prev);
            Misc.hashName.put(cname,anchr);
        }
        txt.setDisable(true);
        cfm.setVisible(false);
        cfm.setDisable(true);
        Button edt = (Button)anchorPane.lookup("#editBtn");
        edt.setVisible(true);
        edt.setDisable(false);
    }
    @FXML
    void editIname(MouseEvent event) {
        Button edt = (Button)event.getSource();
        AnchorPane anchorPane = (AnchorPane) edt.getParent();
        TextField txt = (TextField) anchorPane.lookup("#inameText");
        prev = txt.getText();
        txt.setDisable(false);
        edt.setVisible(false);
        edt.setDisable(true);
        Button cfm = (Button)anchorPane.lookup("#cfmBtn");
        cfm.setVisible(true);
        cfm.setDisable(false);
    }
    @FXML
    void confirmIname(MouseEvent event) {
        Button cfm = (Button)event.getSource();
        AnchorPane anchorPane = (AnchorPane) cfm.getParent();
        TextField txt = (TextField) anchorPane.lookup("#inameText");
        String cname = txt.getText();
        if(Misc.hashName.containsKey(cname) && !Objects.equals(cname, prev)){
            txt.setText(prev);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            String anchr = Misc.hashName.get(prev);
            BJInterface bjInterface = Misc.hashInter.get(anchr);
            bjInterface.setName(cname);
            Misc.hashName.remove(prev);
            Misc.hashName.put(cname,anchr);
        }
        txt.setDisable(true);
        cfm.setVisible(false);
        cfm.setDisable(true);
        Button edt = (Button)anchorPane.lookup("#editBtn");
        edt.setVisible(true);
        edt.setDisable(false);
    }
    @FXML
    ToggleGroup classToggle;
    public void createClass(String cname) throws IOException {
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Class_FXML.fxml")));
        DragResizeMod.makeResizable(classAnchor);
        TextField txt = (TextField) classAnchor.lookup("#cnameText");
        txt.setText(cname);
        Misc.currentTab.getChildren().add(classAnchor);
        BJClass bjClass = BJClass.createInstance(Misc.currentPage.getPackageName());
        bjClass.setName(cname);
        Misc.hashClass.put(classAnchor.toString(),bjClass);
        Misc.hashName.put(cname,classAnchor.toString());
        BJPackage bjPackage = Misc.currentPage.getBjPackage();
        bjPackage.addClass(bjClass);
    }
    public void createInterface(String iname) throws IOException {
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Interface_FXML.fxml")));
        DragResizeMod.makeResizable(classAnchor);
        TextField txt = (TextField) classAnchor.lookup("#inameText");
        txt.setText(iname);
        Misc.currentTab.getChildren().add(classAnchor);
        BJInterface bjInterface = BJInterface.createInstance(Misc.packageName   );
        bjInterface.setName(iname);
        Misc.hashInter.put(classAnchor.toString(),bjInterface);
        Misc.hashName.put(iname,classAnchor.toString());
        BJPackage bjPackage = Misc.currentPage.getBjPackage();
        bjPackage.addInterface(bjInterface);
    }

    @FXML
    void cancelName0(MouseEvent event) {
        Button cnl = (Button)event.getSource();
        Stage stage = (Stage)cnl.getScene().getWindow();
        stage.close();
    }
    @FXML
    private TextField cnameText;
    @FXML
    void confirmName0(MouseEvent event) throws IOException {
        String cname = cnameText.getText();
        Button cfm = (Button)event.getSource();
        if(Misc.hashName.containsKey(cname)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            createClass(cname);
            Stage stage = (Stage)cfm.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    private TextField inameText;
    @FXML
    void confirmName1(MouseEvent event) throws IOException {
        String iname = inameText.getText();
        Button cfm = (Button)event.getSource();
        if(Misc.hashName.containsKey(iname)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            createInterface(iname);
            Stage stage = (Stage)cfm.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    private TextField pnameText;
    @FXML
    void confirmName2(MouseEvent event) throws IOException {
        String pname = pnameText.getText();
        Button cfm = (Button)event.getSource();
        if(Misc.hashPackage.containsKey(pname)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            Loading.staticstartPage.newPackTab(pname);
            Stage stage = (Stage)cfm.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    void addExtends(MouseEvent event) throws IOException{
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClassExtend.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ClassExtend classExtend = fxmlLoader.getController();
        classExtend.doneExt.setOnMouseClicked(e->{
            System.out.println(1010101);
            String st = classExtend.extendClass.getText();
                bjClass.setExtendingInterfaces(st);
                stage.close();
        });
        classExtend.clrExt.setOnMouseClicked(e ->{
            bjClass.setExtendingInterfaces(null);
            stage.close();
        });
    }

    @FXML
    void addImplements(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        FXMLLoader fxmlLoader0 = new FXMLLoader(getClass().getResource("ClassImplement.fxml"));
        AnchorPane anchorPane = fxmlLoader0.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ClassImplement classImplement = fxmlLoader0.getController();
        classImplement.doneImp.setOnMouseClicked(e->{
            String[] st = classImplement.impClass.getText().split("\n");
            for (String s:st){
                bjClass.addInterface(s);
            }
            stage.close();
        });
    }
    @FXML
    void addImplements1(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        FXMLLoader fxmlLoader0 = new FXMLLoader(getClass().getResource("ClassImplement.fxml"));
        AnchorPane anchorPane = fxmlLoader0.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ClassImplement classImplement = fxmlLoader0.getController();
        classImplement.doneImp.setOnMouseClicked(e->{
            String[] st = classImplement.impClass.getText().split("\n");
            for (String s:st){
                bjInterface.addInterface(s);
            }
            stage.close();
        });
    }
    @FXML
    void viewExt(MouseEvent event) throws IOException{
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewExtends.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ViewExtends viewExtends = fxmlLoader.getController();
        viewExtends.viewExtends.setText(bjClass.getName()+" class Extends "+bjClass.getExtendingClass());
    }

    @FXML
    void viewImp(MouseEvent event) throws IOException {

        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ImplementsTable.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ImplementObj> implementObjs = FXCollections.observableArrayList();
        for (String st : bjClass.getImplementingInterfaces()) {
            ImplementObj implementObj = new ImplementObj(st);
            implementObjs.add(implementObj);
        }
        ImplementsController openInterMethController = loader.getController();
        openInterMethController.viewImplements(implementObjs);
    }
    @FXML
    void viewImp1(MouseEvent event) throws IOException {

        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ImplementsTable1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        stage.setScene(scene);
        stage.show();
        ObservableList<ImplementObj> implementObjs = FXCollections.observableArrayList();
        for (String st : bjInterface.getImplementingInterfaces()) {
            ImplementObj implementObj = new ImplementObj(st);
            implementObjs.add(implementObj);
        }
        ImplementsController1 openInterMethController = loader.getController();
        openInterMethController.viewImplements(implementObjs);
    }
    @FXML
    TextField subpackClass;
    @FXML
    void updateClass(MouseEvent event) {
        Button opn = (Button) event.getSource();
        RadioButton rd = (RadioButton) classToggle.getSelectedToggle();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        if(rd.isSelected()){
            if(Objects.equals(rd.getText(), "Public")){
                bjClass.setAccModifier(Modifier.PUBLIC);
            } else if (Objects.equals(rd.getText(), "Private")) {
                bjClass.setAccModifier(Modifier.PRIVATE);
            } else if (Objects.equals(rd.getText(), "Protected")) {
                bjClass.setAccModifier(Modifier.PROTECTED);
            }else if(Objects.equals(rd.getText(),"DEFAULT")){
                bjClass.setAccModifier(Modifier.DEFAULT);
            }
        }
        if(!Objects.equals(subpackClass.getText(), "")&&subpackClass.getText()!=null){
            bjClass.setPackageName(subpackClass.getText());
        }
    }
    @FXML
    void openImp(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Import0_FXML.fxml")));
        Scene scene = new Scene(classAnchor);
        Stage stage = new Stage();
        stage.setMinHeight(150);
        stage.setMinWidth(135);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    void openImp1(MouseEvent event) throws IOException {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Import1_FXML.fxml")));
        Scene scene = new Scene(classAnchor);
        Stage stage = new Stage();
        stage.setMinHeight(150);
        stage.setMinWidth(100);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void openPSVM(MouseEvent event) throws IOException{
        Button opn = (Button) event.getSource();
        RadioButton rd = (RadioButton) classToggle.getSelectedToggle();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PSVM0_FXML.fxml")));
        Scene scene = new Scene(classAnchor);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    private TextField subpackInter;
    @FXML
    void updateInter(MouseEvent event) {
        Button opn = (Button) event.getSource();
        Misc.ImVeryConfused = opn.getParent().getParent().getParent().getParent().toString();
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        if(!Objects.equals(subpackInter.getText(), "")&&subpackInter.getText()!=null){
            bjInterface.setPackageName(subpackInter.getText());
        }
    }
}
