package domain.view;

import domain.model.CaesarCipherStrategy;
import domain.model.CipherContext;
import domain.model.MirrorCipherStrategy;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

abstract class CipherHandler {

    private TextField sentenceTextField;
    private ComboBox<String> algorithmBox;
    private CipherContext cipherContext;
    private Label resultLabel;

    CipherHandler(TextField sentenceTextField, ComboBox<String> algorithmBox, Label resultLabel) {
        setSentenceTextField(sentenceTextField);
        setAlgorithmBox(algorithmBox);
        setResultLabel(resultLabel);
    }

    private TextField getSentenceTextField() {
        return this.sentenceTextField;
    }

    private void setSentenceTextField(TextField sentenceTextField) {
        this.sentenceTextField = sentenceTextField;
    }

    private ComboBox<String> getAlgorithmBox() {
        return this.algorithmBox;
    }

    private void setAlgorithmBox(ComboBox<String> algorithmBox) {
        this.algorithmBox = algorithmBox;
    }

    CipherContext getCipherContext() {
        return this.cipherContext;
    }

    private void setCipherContext() {
        this.cipherContext = new CipherContext(getSentenceTextField().getText());
    }

    Label getResultLabel() {
        return this.resultLabel;
    }

    private void setResultLabel(Label resultLabel) {
        this.resultLabel = resultLabel;
    }

    void setStrategy(){
        setCipherContext();
        if (getAlgorithmBox().getValue().equals("Caesarcijfer"))
            getCipherContext().setCipherStrategy(new CaesarCipherStrategy(getCipherContext()));
        else if(getAlgorithmBox().getValue().equals("Spiegeling"))
            getCipherContext().setCipherStrategy(new MirrorCipherStrategy(getCipherContext()));
        else
            throw new IllegalStateException("Algoritme " + getAlgorithmBox().getValue() + " niet gevonden in het systeem");
    }
}