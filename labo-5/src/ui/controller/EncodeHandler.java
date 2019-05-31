package ui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// TODO where do these handlers go, package-wise?
public class EncodeHandler extends CipherHandler implements EventHandler<ActionEvent> {

    public EncodeHandler(TextField sentenceTextField, ComboBox<String> algorithmBox, Label resultLabel) {
        super(sentenceTextField, algorithmBox, resultLabel);
    }

    @Override
    public void handle(ActionEvent event) {
        setStrategy();
        getCipherContext().encode();
        getResultLabel().setText(getCipherContext().getText());
    }
}