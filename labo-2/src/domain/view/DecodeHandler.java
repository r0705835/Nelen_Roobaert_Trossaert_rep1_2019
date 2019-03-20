package domain.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

// TODO where do these handlers go, package-wise?
public class DecodeHandler extends CipherHandler implements EventHandler<ActionEvent> {

    DecodeHandler(String sentence, String algorithm, Label resultLabel) {
        setSentence(sentence);
        setAlgorithm(algorithm);
        setResultLabel(resultLabel);
        setCipherContext();
    }

    @Override
    public void handle(ActionEvent event) {
        setStrategy();
        getCipherContext().decode();
        getResultLabel().setText(getCipherContext().getText());
    }
}