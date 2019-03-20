package domain.model;


// Context class
public class CipherContext {

    private String text;
    private CipherStrategy cipherStrategy;

    public CipherContext(String string) {
        setText(string);
    }

    public String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    private CipherStrategy getCipherStrategy() {
        return cipherStrategy;
    }

    public void setCipherStrategy(CipherStrategy cipherStrategy) {
        this.cipherStrategy = cipherStrategy;
    }

    // TODO why don't we pass the text to the strategy, instead of creating a strategy with coupling to the context?
    // Concrete method
    public void decode() {
        getCipherStrategy().decode();
    }

    // Concrete method
    public void encode() {
        getCipherStrategy().encode();
    }
}