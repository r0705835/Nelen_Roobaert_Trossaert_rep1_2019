package domain.model;

import domain.RandomCypher;


// TODO is this adapter pattern enough?
public class RandomCipherStrategy implements CipherStrategy {

    private CipherContext context;
    private RandomCypher randomCypher;

    public RandomCipherStrategy(CipherContext context) {
        setContext(context);
        randomCypher = new RandomCypher();
    }

    @Override
    public CipherContext getContext() {
        return context;
    }

    @Override
    public void setContext(CipherContext context) {
        this.context = context;
    }

    @Override
    public void decode() {
        String content = getContext().getText();
        char[] charContent = content.toCharArray();
        String decodedContent = new String(randomCypher.decypher(charContent));
        getContext().setText(decodedContent);
    }

    @Override
    public void encode() {
        String content = getContext().getText();
        char[] charContent = content.toCharArray();
        String encodedContent = new String(randomCypher.encypher(charContent));
        getContext().setText(encodedContent);
    }
}
