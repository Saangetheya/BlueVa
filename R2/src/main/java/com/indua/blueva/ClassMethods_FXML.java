package com.indua.blueva;

        import com.indua.blueva.props.BJClass;
        import com.indua.blueva.props.BJMethodClass;
        import com.indua.blueva.props.BJMethodInterface;
        import com.indua.blueva.props.BJParameter;
        import com.indua.blueva.utils.BJAccessModifier;
        import com.indua.blueva.utils.BJNAccessModifierMethod;
        import com.indua.blueva.utils.BJPrimTypes;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import javax.lang.model.element.Modifier;
        import java.util.ArrayList;
        import java.util.Objects;

public class ClassMethods_FXML {
    @FXML
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;
    public RadioButton rb9,p1,p2,p3,f1,f2,d1;
    public TextField name1;
    public Button cl1;
    @FXML
    public TextField l1;
    @FXML
    public TextArea c1;

    public void clear() {
        name1.clear();
        l1.clear();
        c1.clear();
        d1.setSelected(false);
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
        rb9.setSelected(false);
        f1.setSelected(false);
        f2.setSelected(false);
        p1.setSelected(false);
        p2.setSelected(false);
        p3.setSelected(false);
    }
    public void initialize() {
        cl1.setOnAction(event -> clear());
    }

    @FXML
    void methodAdded(MouseEvent event) {
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        BJMethodClass bjMethodClass = BJMethodClass.createInstance();
        bjMethodClass.setName(name1.getText());
        if(p1.isSelected()){
            bjMethodClass.setAccModifier(BJAccessModifier.PUBLIC);
        }
        else if(p2.isSelected()){
            bjMethodClass.setAccModifier(BJAccessModifier.PRIVATE);
        }
        else if(p3.isSelected()){
            bjMethodClass.setAccModifier(BJAccessModifier.PROTECTED);
        }
        else {
            bjMethodClass.setAccModifier(BJAccessModifier.DEFAULT);
        }
        bjMethodClass.setCode(c1.getText());
        if(f1.isSelected()){
            bjMethodClass.setNaccModifier(Modifier.FINAL);
        }
        else if(f2.isSelected()){
            bjMethodClass.setNaccModifier(Modifier.STATIC);
        }
        else{
            bjMethodClass.setNaccModifier(Modifier.DEFAULT);
        }
        if(rb1.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.INT);
        }
        else if(rb2.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.FLOAT);
        }
        else if(rb3.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.DOUBLE);
        }
        else if(rb4.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.CHAR);
        }
        else if(rb5.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.STRING);
        }
        else if(rb6.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.BOOLEAN);
        }
        else if(rb7.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.SHORT);
        }
        else if(rb8.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.LONG);
        }
        else if(rb9.isSelected()){
            bjMethodClass.setOutput(BJPrimTypes.BYTE);
        }
        String X = l1.getText();
        String[] A = X.split(",");
        for (String s : A) {
            s = s.trim();
            String[] B = s.split(" ");
            BJParameter bjParameter = BJParameter.createInstance();
            bjParameter.setName(B[1]);
            if (Objects.equals(B[0], "int")) {
                bjParameter.setOutput(BJPrimTypes.INT);
            } else if (Objects.equals(B[0], "float")) {
                bjParameter.setOutput(BJPrimTypes.FLOAT);
            } else if (Objects.equals(B[0], "double")) {
                bjParameter.setOutput(BJPrimTypes.DOUBLE);
            } else if (Objects.equals(B[0], "char")) {
                bjParameter.setOutput(BJPrimTypes.CHAR);
            } else if (Objects.equals(B[0], "string")) {
                bjParameter.setOutput(BJPrimTypes.STRING);
            } else if (Objects.equals(B[0], "boolean")) {
                bjParameter.setOutput(BJPrimTypes.BOOLEAN);
            } else if (Objects.equals(B[0], "short")) {
                bjParameter.setOutput(BJPrimTypes.SHORT);
            } else if (Objects.equals(B[0], "long")) {
                bjParameter.setOutput(BJPrimTypes.LONG);
            } else if (Objects.equals(B[0], "byte")) {
                bjParameter.setOutput(BJPrimTypes.BYTE);
            }
            bjMethodClass.addParameter(bjParameter);
        }
        if(Misc.notagain.containsKey(bjMethodClass.getName())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            bjClass.addMethod(bjMethodClass);
            Misc.notagain.put(bjMethodClass.getName(),bjMethodClass);
            Button add = (Button) event.getSource();
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
        }
    }
}
