package domain.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

// TODO where do these handlers go, package-wise?
public class EncodeHandler extends CipherHandler implements EventHandler<ActionEvent> {

    EncodeHandler(String sentence, String algorithm, Label resultLabel) {
        setSentence(sentence);
        setAlgorithm(algorithm);
        setResultLabel(resultLabel);
        setCipherContext();
    }

    @Override
    public void handle(ActionEvent event) {
        setStrategy();
        getCipherContext().encode();
        getResultLabel().setText(getCipherContext().getText());
    }
}