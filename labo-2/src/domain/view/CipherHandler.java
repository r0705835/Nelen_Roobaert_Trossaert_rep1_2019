package domain.view;

import domain.model.CaesarCipherStrategy;
import domain.model.CipherContext;
import domain.model.MirrorCipherStrategy;
import javafx.scene.control.Label;

abstract class CipherHandler {

    private String sentence;
    private String algorithm;
    private CipherContext cipherContext;
    private Label resultLabel;

    private String getSentence() {
        return this.sentence;
    }

    void setSentence(String sentence) {
        this.sentence = sentence;
    }

    private String getAlgorithm() {
        return this.algorithm;
    }

    void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    CipherContext getCipherContext() {
        return this.cipherContext;
    }

    void setCipherContext() {
        this.cipherContext = new CipherContext(getSentence());
    }

    Label getResultLabel() {
        return this.resultLabel;
    }

    void setResultLabel(Label resultLabel) {
        this.resultLabel = resultLabel;
    }

    void setStrategy(){
        if (getAlgorithm().equals("Caesarcijfer"))
            getCipherContext().setCipherStrategy(new CaesarCipherStrategy(getCipherContext()));
        else if(getAlgorithm().equals("Spiegeling"))
            getCipherContext().setCipherStrategy(new MirrorCipherStrategy(getCipherContext()));
        else
            throw new IllegalStateException("Algoritme " + getAlgorithm() + " niet gevonden in het systeem");
    }
}