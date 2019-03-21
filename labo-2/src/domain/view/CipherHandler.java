package domain.view;

import domain.model.CaesarCipherStrategy;
import domain.model.CipherContext;
import domain.model.MirrorCipherStrategy;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;

abstract class CipherHandler {

    private TextField sentenceTextField;
    private ComboBox<String> algorithmBox;
    private CipherContext cipherContext;
    private Label resultLabel;

    private TextField getSentenceTextField() {
        return this.sentenceTextField;
    }

    void setSentenceTextField(TextField sentenceTextField) {
        this.sentenceTextField = sentenceTextField;
    }

    private ComboBox<String> getAlgorithmBox() {
        return this.algorithmBox;
    }

    void setAlgorithmBox(ComboBox<String> algorithmBox) {
        this.algorithmBox = algorithmBox;
    }

    CipherContext getCipherContext() {
        return this.cipherContext;
    }

    void setCipherContext() {
        this.cipherContext = new CipherContext(getSentenceTextField().getText());
    }

    Label getResultLabel() {
        return this.resultLabel;
    }

    void setResultLabel(Label resultLabel) {
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