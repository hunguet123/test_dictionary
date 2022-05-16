package com.example.javafx;

import com.example.solution.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RepairController implements Initializable {

    @FXML
    private TextField target;

    @FXML
    private TextArea explain;

    @FXML
    void Fix(ActionEvent event) throws IOException {
        String Target = target.getText();
        String Explain = explain.getText();
        Word newWord = new Word(Target,Explain);
        int index = HelloController.IndexViewAllItem;
        HelloController.dictionary.get(index).setWord_target(Target);
        HelloController.dictionary.get(index).setWord_explain(Explain);
        HelloController.dictionaryManagement.dictionaryExportToFile(HelloController.dictionary);
        if (HelloController.dictionary.get(index).equals(newWord)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("thông báo");
            alert.setHeaderText("Đã sửa xong");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        target.setText(HelloController.dictionary.get(HelloController.IndexViewAllItem).getWord_target());
        explain.setText(HelloController.dictionary.get(HelloController.IndexViewAllItem).getWord_explain());
    }
}
